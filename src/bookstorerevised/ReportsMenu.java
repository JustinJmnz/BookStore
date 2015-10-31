/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstorerevised;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Justin
 */
public class ReportsMenu extends JFrame implements ActionListener{
    
    private JLabel lblStoreName;
    private JButton btnMainMenu;
    private JButton btnListing;
    private JButton btnWholesaleValue;
    private JButton btnRetailValue;
    private JButton btnQuantity;
    private JButton btnDate;

    public ReportsMenu(String title){
        super(title);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 7, 0, 10));
        
        lblStoreName = new JLabel("SERENDIPITY BOOKSELLERS", JLabel.CENTER); 
            add(lblStoreName);
        btnMainMenu = new JButton("Main Menu");
            btnMainMenu.addActionListener(this);
            add(btnMainMenu);
        btnListing = new JButton("Inventory Listing");
            btnListing.addActionListener(this);
            add(btnListing);   
        btnWholesaleValue = new JButton("Inventory Wholesale Value");
            btnWholesaleValue.addActionListener(this);
            add(btnWholesaleValue);
       btnRetailValue = new JButton("Inventory Retail Value");
            btnRetailValue.addActionListener(this);
            add(btnRetailValue);
       btnQuantity = new JButton("Listing by Quantity");
            btnQuantity.addActionListener(this);
            add(btnQuantity);
       btnDate = new JButton("Listing by date");
            btnDate.addActionListener(this);
            add(btnDate);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals(btnMainMenu.getText())){
           MainMenu MainGUI = new MainMenu("Serendipity Booksellers");
           MainGUI.setLocationRelativeTo(null);
           MainGUI.setVisible(true);
           this.dispose();
       }else if(e.getActionCommand().equals(btnListing.getText())){
           try {
               ReportsAllBooks listGUI = new ReportsAllBooks("Serendipity Booksellers");
               listGUI.setLocationRelativeTo(null);
               listGUI.setVisible(true);
               this.dispose();
           } catch (FileNotFoundException ex) {
               System.exit(0);
           }          
       }else if(e.getActionCommand().equals(btnWholesaleValue.getText())){
           try {
               ReportWholesale i = new ReportWholesale("Serendipity Wholesale");
               i.setLocationRelativeTo(null);
               i.setVisible(true);
               this.dispose();
           } catch (FileNotFoundException ex) {
               System.exit(0);
           }
       }else if(e.getActionCommand().equals(btnRetailValue.getText())){
           try {
               ReportRetail i = new ReportRetail("Serendipity Wholesale");
               i.setLocationRelativeTo(null);
               i.setVisible(true);
               this.dispose();
           } catch (FileNotFoundException ex) {
               System.exit(0);
           }
       }else if(e.getActionCommand().equals(btnQuantity.getText())){
           try {
               ReportQuantity i = new ReportQuantity("Serendipity Wholesale");
               i.setLocationRelativeTo(null);
               i.setVisible(true);
               this.dispose();
           } catch (FileNotFoundException ex) {
               System.exit(0);
           }
       }else if(e.getActionCommand().equals(btnDate.getText())){
          try {
               ReportDate i = new ReportDate("Serendipity Wholesale");
               i.setLocationRelativeTo(null);
               i.setVisible(true);
               this.dispose();
           } catch (FileNotFoundException ex) {
               System.exit(0);
           }
       }
    }
    
}
