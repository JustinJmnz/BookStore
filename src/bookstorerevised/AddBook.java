/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstorerevised;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Justin
 */
public class AddBook extends JFrame implements ActionListener{
    private JLabel lblStoreName;
    private JButton btnBack;
    private JButton btnDone;
    private JTextField txtISBN;
    private JTextField txtTitle;
    private JTextField txtAuthor;
    private JTextField txtPublisher;
    private JTextField txtDateAdded;
    private JTextField txtQuantity;
    private JTextField txtWholesale;
    private JTextField txtRetail;
    private JLabel lblISBN;
    private JLabel lblTitle;
    private JLabel lblAuthor;
    private JLabel lblPublisher;
    private JLabel lblDateAdded;
    private JLabel lblQuantity;
    private JLabel lblWholesale;
    private JLabel lblRetail;
    private JLabel lblClickDone;
    private double wholesaleOutput = 0;
    private double retailOutput = 0;
    private int quantityOutput;
    private String ISBN = "";
    private String title = "";
    private String author = "";
    private String publisher = "";
    private String date = "";
    private String quantity = "";
    private String wholesale = "";
    private String retail = "";

    public AddBook(String title) {
        super(title);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        getContentPane().add(panel, BorderLayout.NORTH);
        GridBagConstraints c = new GridBagConstraints();
        lblStoreName = new JLabel("SERENDIPITY BOOKSELLERS"); //Title
            c.gridx = 0;
            c.gridy = 0;
            c.insets = new Insets(5,5,5,5);
            panel.add(lblStoreName, c);
        btnBack = new JButton("Back"); // Main menu button
            c.gridx = 0;
            c.gridy = 1;
            c.insets = new Insets(5,5,5,5);
            btnBack.addActionListener(this);
            panel.add(btnBack, c);
        btnDone = new JButton("Done"); // Save to ArrayList
            c.gridx = 1;
            c.gridy = 1;
            btnDone.addActionListener(this);
            panel.add(btnDone, c);
        txtISBN = new JTextField(10); // Text Field
            c.gridx = 1;
            c.gridy = 2;
            c.insets = new Insets(5,5,5,5);
            txtISBN.setSize(5, 10);
            panel.add(txtISBN, c);
        txtTitle = new JTextField(10); // Text Field
            txtTitle.setSize(5, 10);
            c.gridx = 1;
            c.gridy = 3;
            c.insets = new Insets(5,5,5,5);
            panel.add(txtTitle, c);
        txtAuthor = new JTextField(10); // Text Field
            c.gridx = 1;
            c.gridy = 4;
            c.insets = new Insets(5,5,5,5);
            txtAuthor.setSize(5, 10);
            panel.add(txtAuthor, c);
        txtPublisher = new JTextField(10); // Text Field
            c.gridx = 1;
            c.gridy = 5;
            c.insets = new Insets(5,5,5,5);
            txtPublisher.setSize(5, 10);
            panel.add(txtPublisher, c);
        txtDateAdded = new JTextField(10); //Text Field
            c.gridx = 1;
            c.gridy = 6;
            c.insets = new Insets(5,5,5,5);
            txtDateAdded.setSize(5, 10);
            panel.add(txtDateAdded, c);
        txtQuantity = new JTextField(10); // Text Field
            c.gridx = 1;
            c.gridy = 7;
            c.insets = new Insets(5,5,5,5);
            txtQuantity.setSize(5, 10);
            panel.add(txtQuantity, c);
        txtWholesale = new JTextField(10); // Text Feld
            c.gridx = 1;
            c.gridy = 8;
            c.insets = new Insets(5,5,5,5);
            txtWholesale.setSize(5, 10);
            panel.add(txtWholesale, c);
        txtRetail = new JTextField(10); // Text Field
            c.gridx = 1;
            c.gridy = 9;
            c.insets = new Insets(5,5,5,5);
            txtRetail.setSize(5, 10);
            panel.add(txtRetail, c);
        lblISBN = new JLabel("Enter ISBN here:"); // JLabel
            c.gridx = 0;
            c.gridy = 2;
            c.insets = new Insets(5,5,5,5);
            panel.add(lblISBN, c);
        lblTitle = new JLabel("Enter Title here:"); // JLabel
            c.gridx = 0;
            c.gridy = 3;
            c.insets = new Insets(5,5,5,5);
            panel.add(lblTitle, c);
        lblAuthor = new JLabel("Enter Author here:"); // JLabel
            c.gridx = 0;
            c.gridy = 4;
            c.insets = new Insets(5,5,5,5);
            panel.add(lblAuthor, c);
        lblPublisher = new JLabel("Enter Publisher here:"); // JLabel
            c.gridx = 0;
            c.gridy = 5;
            c.insets = new Insets(5,5,5,5);
            panel.add(lblPublisher, c);
        lblDateAdded = new JLabel("Enter Date here (mm/dd/yy):"); // JLabel
            c.gridx = 0;
            c.gridy = 6;
            c.insets = new Insets(5,5,5,5);
            panel.add(lblDateAdded, c);
         lblQuantity = new JLabel("Enter Quantity here:"); // JLabel
            c.gridx = 0;
            c.gridy = 7;
            c.insets = new Insets(5,5,5,5);
            panel.add(lblQuantity, c);
         lblWholesale = new JLabel("Enter Wholesale cost here: $"); // JLabel
            c.gridx = 0;
            c.gridy = 8;
            c.insets = new Insets(5,5,5,5);
            panel.add(lblWholesale, c);
         lblRetail = new JLabel("Enter Retail cost here: $"); // JLabel
            c.gridx = 0;
            c.gridy = 9;
            c.insets = new Insets(5,5,5,5);
            panel.add(lblRetail, c);
         lblClickDone = new JLabel("Click Done when info is complete"); // JLabel
            c.gridx = 0;
            c.gridy = 15;
            c.insets = new Insets(5,5,5,5);
            panel.add(lblClickDone, c);
    } 
    public void checkInfo(){ // Checks if info format is correct
        int go = 0;    
        if(txtISBN.getText().length() < 10 || txtISBN.getText().length() > 10){
            JOptionPane.showConfirmDialog(null, "The ISBN Needs to be 10 digits", "Error", JOptionPane.PLAIN_MESSAGE);
        }else if(!txtISBN.getText().isEmpty()){
            ISBN = txtISBN.getText();
            go++;
        }else{
            JOptionPane.showConfirmDialog(null, "You didnt enter in the ISBN", "Error", JOptionPane.PLAIN_MESSAGE);
        }
        if(!txtTitle.getText().isEmpty()){
        title = txtTitle.getText();
        go++;
        }else{
            JOptionPane.showConfirmDialog(null, "You didnt enter in the Title", "Error", JOptionPane.PLAIN_MESSAGE);
        }
        if(!txtAuthor.getText().isEmpty()){
        author = txtAuthor.getText();
        go++;
        }else{
            JOptionPane.showConfirmDialog(null, "You didnt enter in the Author", "Error", JOptionPane.PLAIN_MESSAGE);
        }
        if(!txtPublisher.getText().isEmpty()){
        publisher = txtPublisher.getText();
        go++;
        }else{
            JOptionPane.showConfirmDialog(null, "You didnt enter in the Publisher", "Error", JOptionPane.PLAIN_MESSAGE);
        }
        if(!txtDateAdded.getText().isEmpty()){
        date = txtDateAdded.getText();
        go++;
        }else{
            JOptionPane.showConfirmDialog(null, "You didnt enter in the Date", "Error", JOptionPane.PLAIN_MESSAGE);
        }
        if(!txtQuantity.getText().isEmpty()){
        quantity = txtQuantity.getText();
        try{
            quantityOutput = Integer.parseInt(quantity);
            go++;
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "You didn't enter an Integer number in the quantity", "Error", JOptionPane.PLAIN_MESSAGE);
        }
        }else{
            JOptionPane.showConfirmDialog(null, "You didnt enter in the Quantity", "Error", JOptionPane.PLAIN_MESSAGE);
        }
       
        if(!txtWholesale.getText().isEmpty() || !txtWholesale.getText().equals("")){
            wholesale = txtWholesale.getText();
                try{
                    wholesaleOutput = Double.parseDouble(wholesale);
                    go++;
                }catch(Exception x){
                    JOptionPane.showConfirmDialog(null, "You didn't enter wholesale value as a number..(ex) 0.00", "Error", JOptionPane.PLAIN_MESSAGE);
                    txtWholesale.setText("");
                
            }
        }else if(txtWholesale.getText().isEmpty()){
            JOptionPane.showConfirmDialog(null, "You didnt enter in the Wholesale price", "Error", JOptionPane.PLAIN_MESSAGE);
        }
        
        if(!txtRetail.getText().isEmpty() || !txtRetail.getText().isEmpty()){
            retail = txtRetail.getText();
                try{
                    retailOutput = Double.parseDouble(retail);
                    go++;
                }catch(Exception x){
                    JOptionPane.showConfirmDialog(null, "You didnt enter in the Retail value as a number..(ex) 0.00", "Error", JOptionPane.PLAIN_MESSAGE);
                }
        }else{
            JOptionPane.showConfirmDialog(null, "You didnt enter in the Retail price", "Error", JOptionPane.PLAIN_MESSAGE);
        }      
        if(go == 8){
        createBook(); // Calls method to create book
        }
    } // End of checkInfo method
    
    public void createBook(){
        BookInfo book = new BookInfo();
        book.setISBN(ISBN);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setDate(date);
        book.setQuantity(quantityOutput);
        book.setWholesale(wholesaleOutput);
        book.setRetail(retailOutput);
        FileRead.books.add(book);
        JOptionPane.showConfirmDialog(null, "Book added successfully!", "Done!", JOptionPane.PLAIN_MESSAGE);
        try {
            book.writeBook();
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(null, "Error, no file was found", "AddBook", JOptionPane.PLAIN_MESSAGE);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(btnBack.getText())){
            InventoryDatabaseMenu InventoryDatabase = new InventoryDatabaseMenu("Serendipity Booksellers");
            InventoryDatabase.setLocationRelativeTo(null);
            InventoryDatabase.setVisible(true);
            this.dispose();
        }else if(e.getActionCommand().equals(btnDone.getText())){
            checkInfo();
            
        }
          
    }
}