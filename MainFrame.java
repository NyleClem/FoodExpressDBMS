import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);

    public MainFrame() {

        setTitle("Food Express System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create panels
        //mainPanel.add(new ClassName(), name of the panel)
        mainPanel.add(new DeliveryInterface(), "delivery");
        
        //show first screen
        add(mainPanel);

        

        cardLayout.show(mainPanel, "delivery");

        setVisible(true);
    }

    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
