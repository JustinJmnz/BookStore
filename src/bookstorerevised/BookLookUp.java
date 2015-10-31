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
import javax.swing.JOptionPane;

/**
 *
 * @author Justin
 */
public class BookLookUp extends JFrame implements ActionListener {

    private JLabel lblStoreName;
    private JButton btnBack;
    private JLabel lblISBN;
    private JLabel lblTitle;
    private JLabel lblAuthor;
    private JLabel lblPublisher;  
    private JLabel lblDateAdded;
    private JLabel lblQuantity;
    private JLabel lblWholeSale;
    private JLabel lblRetail;
    private String title1;
    private String ISBN1;
    private String author;
    private String publisher;
    private String date;
    private int quantity;
    private double wholesale;
    private double retail;
    public BookLookUp(String title) throws FileNotFoundException{
        super(title);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 7, 0, 10));
        check();
        /////// GUI ////////////
        lblStoreName = new JLabel("SERENDIPITY BOOKSELLERS", JLabel.CENTER); //Title
           add(lblStoreName);
        btnBack = new JButton("Back"); // Main menu button
            btnBack.addActionListener(this);
            add(btnBack);
        lblISBN = new JLabel("ISBN: " + ISBN1);   
            add(lblISBN);
        lblTitle = new JLabel("Title: " + title1);  
            add(lblTitle);
        lblAuthor = new JLabel("Author: " + author);
            add(lblAuthor);
        lblPublisher = new JLabel("Publisher: " + publisher);
            add(lblPublisher);
        lblDateAdded = new JLabel("Date Added: " + date);
            add(lblDateAdded);
        lblQuantity = new JLabel("Quantity-On-Hand: " + quantity);
            add(lblQuantity);
        lblWholeSale = new JLabel("Wholesale cost: $" + wholesale);
            add(lblWholeSale);
        lblRetail = new JLabel("Retail cost: $" + retail);
            add(lblRetail);
        /////// GUI ////////////
        
            
    }
    public void check(){
        String Choices[] = {"ISBN", "Title"};
        String choice = (String)JOptionPane.showInputDialog(null, "Enter the book either by ISBN or author", "Book Look Up", JOptionPane.PLAIN_MESSAGE,null, Choices, Choices[0]);
        switch(choice){
            case "ISBN":
                 ISBN1 = JOptionPane.showInputDialog(null, "Enter the ISBN", "Finding by ISBN", JOptionPane.PLAIN_MESSAGE);
                if(ISBN1.length() == 10){
                    boolean right = false;
                    for(int a = 0; a < FileRead.books.size(); a++){
                        if(ISBN1.equals(FileRead.books.get(a).getISBN())){
                        ISBN1 = FileRead.books.get(a).getISBN(); 
                        title1 = FileRead.books.get(a).getTitle();
                        author = FileRead.books.get(a).getAuthor();
                        publisher = FileRead.books.get(a).getPublisher();
                        quantity = FileRead.books.get(a).getQuantity();
                        date = FileRead.books.get(a).getDate();
                        wholesale = FileRead.books.get(a).getWholesale();
                        retail = FileRead.books.get(a).getRetail();
                        right = true;
                        }
                    }
                    if(right == false){
                        JOptionPane.showConfirmDialog(null, "No ISBNs matched", "Error", JOptionPane.PLAIN_MESSAGE);
                        check();
                    }
                }else{
                JOptionPane.showConfirmDialog(null, "Enter a 10 digit ISBN Number", "Invalid Input", JOptionPane.PLAIN_MESSAGE);
                check();
                }
                break;
            case "Title":
                 boolean right = false;
                 title1 = JOptionPane.showInputDialog(null, "Enter the title", "Finding by Title", JOptionPane.PLAIN_MESSAGE);        
                    for(int a = 0; a < FileRead.books.size(); a++){
                        if(title1.equals(FileRead.books.get(a).getTitle())){
                        ISBN1 = FileRead.books.get(a).getISBN(); 
                        title1 = FileRead.books.get(a).getTitle();
                        author = FileRead.books.get(a).getAuthor();
                        publisher = FileRead.books.get(a).getPublisher();
                        quantity = FileRead.books.get(a).getQuantity();
                        date = FileRead.books.get(a).getDate();
                        wholesale = FileRead.books.get(a).getWholesale();
                        retail = FileRead.books.get(a).getRetail();     
                        right = true;
                        }
                    }
                 if(right == false){
                     JOptionPane.showConfirmDialog(null, "The title didn't match any books", "Title didn't match", JOptionPane.PLAIN_MESSAGE);
                     check();
                 }
               break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals(btnBack.getText())){ // Open inventory Menu
            InventoryDatabaseMenu InventoryDatabase = new InventoryDatabaseMenu("Serendipity Booksellers");
            InventoryDatabase.setLocationRelativeTo(null);
            InventoryDatabase.setVisible(true);
            this.dispose();
        }
    }
    
}
