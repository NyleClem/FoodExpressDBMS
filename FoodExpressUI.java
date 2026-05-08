import java.awt.BorderLayout;     // Swing GUI classes (JFrame, JButton, JTextField, etc.)
import java.awt.GridLayout;        // Layout managers like BorderLayout, GridLayout
import java.sql.Connection;        // JDBC classes for database connection
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FoodExpressUI extends JFrame{
    
    // Database connection details
        String url = "jdbc:mysql://localhost:3306/FoodExpress"; 
        // jdbc:mysql://host:port/databaseName
        
        String user = "root";     
        // MySQL username
        
        String password = "Fatika@006"; 
        // Replace with your MySQL root password

    // Input fields and output area
    JTextField customer, majorField;
    JTextArea output;

 private Connection getConn() throws Exception {
        Class.forName("com.mysql.cj.FoodExpress.Driver");  // Load MySQL driver
        return DriverManager.getConnection(url, user, password);
    }
private void viewCustomers() {
        output.setText("");  // Clear output

        try (Connection conn = getConn();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Customer")) {

            // Loop through result rows
            while (rs.next()) {
                output.append(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("major") + "\n"
                );
            }

        } catch (Exception ex) {
            output.setText(ex.getMessage());
        }
    }
    private void viewRestaurant () {
        output.setText("");  // Clear output

        try (Connection conn = getConn();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Customer")) {

            // Loop through result rows
            while (rs.next()) {
                output.append(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("major") + "\n"
                );
            }

        } catch (Exception ex) {
            output.setText(ex.getMessage());
        }
    }private void viewCustomers() {
        output.setText("");  // Clear output

        try (Connection conn = getConn();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Customer")) {

            // Loop through result rows
            while (rs.next()) {
                output.append(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("major") + "\n"
                );
            }

        } catch (Exception ex) {
            output.setText(ex.getMessage());
        }
    }

    public static void main (String[] arg)
    {

    }

   
}