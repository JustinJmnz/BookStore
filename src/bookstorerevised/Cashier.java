/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstorerevised;


import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author Justin
 */
public class Cashier extends JFrame implements ActionListener{
    private JLabel lblCashier;
    private JLabel lblDate;
    private JLabel lblBookInfo;
    private JLabel lblBookSold;
    private JLabel lblSubTotal;
    private JButton btnBack;
    private JLabel lblTax;
    private JLabel lblTotal;
    private JLabel lblThankYou;
    private String Date = "";
    private String ISBN = "";
    private String title = "";
    private int quantity = 0;
    private double cost = 0.00;
    private double tax = 0.06;
    private double subtotal;
    private double total;
    private int remove;
    public Cashier(String t) throws FileNotFoundException{
        super(t);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 7, 0, 10)); 
        checkISBN(); // Checks if ISBN matches a book
        checkDate(); // Checks if date is in correct format 
        checkQuantity(); // Checks if quantity is an integer
        tax(); // Calculates tax, subtotal and total
        lblCashier = new JLabel("Cashier Menu", JLabel.CENTER);
        add(lblCashier);
        btnBack = new JButton("Back");
        btnBack.addActionListener(this);
        add(btnBack);
        lblDate = new JLabel("Date: " + Date);
        add(lblDate);
        lblBookInfo = new JLabel("Qty" + "                    ISBN " + "                  Title" + "                                                                          " + " Price ");
        add(lblBookInfo);
        lblBookSold = new JLabel(quantity + "                 " + ISBN + "           " + title + "                                       $" + cost + "ea.");
        add(lblBookSold);
        lblSubTotal = new JLabel("                                                                                                          SubTotal: $" + subtotal);   
        add(lblSubTotal);
        lblTax = new JLabel("                                                                                                          Tax: $" + tax);
        add(lblTax);
        lblTotal = new JLabel("                                                                                                          Total: $" + total);
        add(lblTotal);
        lblThankYou = new JLabel("Thank for you shopping at Serendipity booksellers!");
        add(lblThankYou);
       
    } // End of Constructor
    public void tax(){
        subtotal = cost * quantity;
        tax = subtotal * 0.06;
        total = subtotal + tax;
        BookInfo book = new BookInfo();
        try {
            book.writeBook();
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(null, "Error, no file was found", "AddBook", JOptionPane.PLAIN_MESSAGE);
        }
    }
    public void checkQuantity(){
       
        String quant = JOptionPane.showInputDialog(null, "Enter the amount of books being purchased", "Enter Quantity", JOptionPane.PLAIN_MESSAGE);
        if(quant.equals("") || quant.equals(null)){
            JOptionPane.showConfirmDialog(null, "You didn't enter anything", "Wrong input", JOptionPane.PLAIN_MESSAGE);
            checkQuantity();
        }else{
            quantity = Integer.parseInt(quant);
        }
        removeQuantity(remove); // Removes quantity at index of remove(index of a in checkISBN method)
    } // End of checkQuantity method
    public void checkISBN(){
        int a;
        ISBN = JOptionPane.showInputDialog(null, "Enter the ISBN Number of the book", "Enter ISBN", JOptionPane.PLAIN_MESSAGE);
        if(ISBN.length() == 10){
            boolean right = false;
            for(a = 0; a < FileRead.books.size(); a++){
                if(ISBN.equals(FileRead.books.get(a).getISBN())){
                    title = FileRead.books.get(a).getTitle();
                    cost = FileRead.books.get(a).getRetail();
                    right = true;
                    remove = a; // remove is used for removeQuantity method
                    break;
                }
            }
            if(right == false){
                JOptionPane.showConfirmDialog(null, "No ISBNs matched", "Error", JOptionPane.PLAIN_MESSAGE);
                checkISBN();
            }
        }else{
            JOptionPane.showConfirmDialog(null, "Enter a 10 digit ISBN Number", "Invalid Input", JOptionPane.PLAIN_MESSAGE);
            checkISBN();
        }
    } // End of checkISBN method        
public void removeQuantity(int a){
    FileRead.books.get(a).setQuantity(FileRead.books.get(a).getQuantity() - quantity);
} // End of removeQuantity method
        
    
    public void checkDate(){ 
      
        Date = JOptionPane.showInputDialog(null, "Enter the date in mm/dd/yy", "Enter Date", JOptionPane.PLAIN_MESSAGE);
        if(Date.equals("") || Date.equals(null)){
            JOptionPane.showConfirmDialog(null, "You didn't enter anything", "Wrong input", JOptionPane.PLAIN_MESSAGE);
            checkDate();
         }else if(Date.length() == 8){
            Date = Date;
        }else{
             JOptionPane.showConfirmDialog(null, "Invalid input, enter as mm/dd/yy", "Error", JOptionPane.PLAIN_MESSAGE);
             checkDate();
         }
       
    } //End of checkDate method

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(btnBack.getText())){
            MainMenu main = new MainMenu("Serendipity BookSellers");
            main.setLocationRelativeTo(null);
            main.setVisible(true);
            this.dispose();
        }
    }
        
}
