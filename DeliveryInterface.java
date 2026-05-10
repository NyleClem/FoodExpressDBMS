import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;       // JDBC classes for database connection
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DeliveryInterface extends JFrame{
    
    
    // Input fields and output area
    JTextField DriverID, DriverUpdate,OrderID;
    JTextArea output;

    public DeliveryInterface(){
         // Frame settings
        setTitle("Delivery System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        

       JPanel top = new JPanel(new GridLayout(3, 2)); 

        top.add(new JLabel("DriverID:"));
        DriverID = new JTextField();
        top.add(DriverID);

        top.add(new JLabel("OrderID:"));
        OrderID = new JTextField();
        top.add(OrderID);
        
        top.add(new JLabel("Order Update:"));
        DriverUpdate = new JTextField();
        top.add(DriverUpdate);
        add(top, BorderLayout.NORTH); 

        output = new JTextArea();
        output.setEditable(false);                      // User cannot type here
        add(new JScrollPane(output), BorderLayout.CENTER);
         JPanel bottom = new JPanel(new GridLayout(1, 3));  // 1 row × 3 columns

        JButton viewBtn = new JButton("View Assigned Delivery");
        JButton viewBtn2 = new JButton("View Delivery");
        JButton updateBtn = new JButton("Update Delivery");

        bottom.add(viewBtn);
        bottom.add(viewBtn2);
        bottom.add(updateBtn);
        add(bottom, BorderLayout.SOUTH);

        viewBtn.addActionListener(e-> AssignedDelivery());
        viewBtn2.addActionListener(e-> viewDelivery());
        updateBtn.addActionListener(e->updateDelivery());
        setVisible(true); 


        //This is how we add
        // JButton toRestaurant = new JButton("Restaurant");
        // JButton toDelivery = new JButton("Delivery"); 

        //This is how we can click to other UI
        // toRestaurant.addActionListener(e ->
        //     frame.showPanel("restaurant")
        // );

        // toDelivery.addActionListener(e ->
        //     frame.showPanel("delivery")
        // );

        //This is how we can display 
        // add(toRestaurant, BorderLayout.WEST);
        // add(toDelivery, BorderLayout.EAST);

    

       
        
    }


private void AssignedDelivery() {
    output.setText("");  // Clear output

    String ID = DriverID.getText();

    String viewSql =
        "SELECT O.OrderID, DR.DriverName, D.DeliveryStatus, O.OrderTime " +
        "FROM Orders O " +
        "INNER JOIN Delivery D ON D.OrderID = O.OrderID " +
        "INNER JOIN Driver DR ON DR.DriverID = D.DriverID " +
        "WHERE DR.DriverID = ?;";

    if (ID.isEmpty()) {
        output.setText("DriverID field required.");
        return;
    }

    try (Connection conn = DBConnection.getConn();
         PreparedStatement pstmt = conn.prepareStatement(viewSql)) {

        // Set parameter
        pstmt.setInt(1, Integer.parseInt(ID));

        try (ResultSet rs = pstmt.executeQuery()) {

            // Loop through result rows
            while (rs.next()) {
                output.append(
                    "OrderID: "+ rs.getInt("OrderID") + " | " +
                    "Driver's Name: "+rs.getString("DriverName") + " | " +
                    "Delivery Status: "+ rs.getString("DeliveryStatus") + " | " +
                    "Order Time: " +rs.getString("OrderTime") + "\n"
                );
            }
        }

    } catch (Exception ex) {
        output.setText(ex.getMessage());
    }
}

private void viewDelivery() {
    output.setText("");  // Clear output

    String ID = DriverID.getText();
    String OrderID2 = OrderID.getText();

    String viewSql = "SELECT  DATE_FORMAT(O.OrderTime, '%Y-%m-%d %H:%i:%s') AS OrderTime, O.TotalAmount, C.Address, D.DeliveryTime From Orders O\n" + //
                "INNER JOIN Delivery D on D.OrderID = O.OrderID\n" + //
                "INNER JOIN Driver DR on DR.DriverID = D.DriverID\n" + //
                "INNER JOIN Customer C on O.CustomerID = C.CustomerID\n" + //
                "Where DR.DriverID =? AND O.OrderID =?;";

    if (ID.isEmpty()|| OrderID2.isEmpty()) {
        output.setText("Both fields required.");
            return;
    }

    try (Connection conn = DBConnection.getConn();
         PreparedStatement pstmt = conn.prepareStatement(viewSql)) {

        // Set parameter
        pstmt.setInt(1, Integer.parseInt(ID));
        pstmt.setInt(2, Integer.parseInt(OrderID2));

        try (ResultSet rs = pstmt.executeQuery()) {

            // Loop through result rows
            while (rs.next()) {
                output.append(
                    "Order Time: "+ rs.getString("OrderTime") + " \n " +
                    "Total Amount: " + rs.getString("TotalAmount") + " \n " +
                    "Address: "+rs.getString("Address") + " \n " +
                    "Delivery Time: " +rs.getString("DeliveryTime") + "\n"
                );
            }
        }
    } catch (NumberFormatException ex) {
        output.setText("DriverID must be a number.");
    } catch (Exception ex) {
        output.setText(ex.getMessage());
    }
}


private void updateDelivery() {
        output.setText("");

        String ID = OrderID.getText();
        String Status = DriverUpdate.getText();

        String updateSQL ="UPDATE Delivery SET DeliveryStatus = ? Where OrderID = ?;";

        if (ID.isEmpty() || Status.isEmpty()) {
            output.setText("Both fields required.");
            return;
        }

        try (Connection conn = DBConnection.getConn();
             PreparedStatement ps = conn.prepareStatement(updateSQL)) {

         
        ps.setString(1, Status);
        ps.setInt(2, Integer.parseInt(ID));

        int rowsUpdated = ps.executeUpdate();

        if (rowsUpdated > 0) {
            output.setText("Order " + ID + " updated to: " + Status);
        } else {
            output.setText("No order found with ID: " + ID);
        }

    } catch (NumberFormatException ex) {
        output.setText("OrderID must be a number.");
    } catch (Exception ex) {
        output.setText(ex.getMessage());
    }
    }

}
