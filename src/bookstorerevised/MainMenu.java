/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstorerevised;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Justin
 */
public class MainMenu extends JFrame implements ActionListener{
    private JLabel lblStoreName;
    private JLabel lblMainMenu;
    private JButton btnFirstChoice;
    private JButton btnSecondChoice;
    private JButton btnThirdChoice;
    private JButton btnFourthChoice;
    
    public MainMenu(String title){
        super(title);
        setSize(600, 500);
        setLayout(new GridLayout(6, 0, 0, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lblStoreName = new JLabel("SERENDIPITY BOOKSELLERS", JLabel.CENTER); //Title
            add(lblStoreName);
        lblMainMenu = new JLabel("Main Menu", JLabel.CENTER); // Home button
            add(lblMainMenu);
        btnFirstChoice = new JButton("Cashier Menu"); // Cashier menu
            btnFirstChoice.addActionListener(this);
            btnFirstChoice.setBounds(WIDTH, WIDTH, 4, 4);
            add(btnFirstChoice);
        btnSecondChoice = new JButton("Inventory Database Menu"); // Inventory database menu
            btnSecondChoice.addActionListener(this);
            add(btnSecondChoice);
        btnThirdChoice = new JButton("Report Menu"); // Report menu
            btnThirdChoice.addActionListener(this);
            add(btnThirdChoice);
        btnFourthChoice = new JButton("Exit"); //Exit
            btnFourthChoice.addActionListener(this);
            add(btnFourthChoice);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals(btnFirstChoice.getText())){ // Open cashier menu
            try {              
                Cashier cashGUI = new Cashier("Serendipity BookSellers");
                cashGUI.setLocationRelativeTo(null);
                cashGUI.setVisible(true);
                this.dispose();
            } catch (FileNotFoundException ex) {
                JOptionPane.showConfirmDialog(null, "File Not Found", "Cashier Class", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }            
       }else if(event.getActionCommand().equals(btnSecondChoice.getText())){ // Open inventory Menu
           InventoryDatabaseMenu IDM = new InventoryDatabaseMenu("Serendipity Booksellers");
           IDM.setLocationRelativeTo(null);
           IDM.setVisible(true);
           this.dispose();
       }else if(event.getActionCommand().equals(btnThirdChoice.getText())){ // Open report menu
           ReportsMenu r = new ReportsMenu("Serendipity Booksellers");
           r.setLocationRelativeTo(null);
           r.setVisible(true);
           this.dispose();
       }else if(event.getActionCommand().equals(btnFourthChoice.getText())){ // Exit option
           System.exit(0);
       }
    } 
}
