/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstorerevised;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Justin
 */
public class EditBook extends JFrame  {
    private String ISBN;
    private String title;
    private String author;
    private String publisher;
    private String dateAdded;
    private int quantity;
    private double wholeSale;
    private double retail;
    private int sort = 0; 
    

 public void go() throws FileNotFoundException, IOException{
        
        ISBN = JOptionPane.showInputDialog(null, "Enter the ISBN number for the book you want to edit", "Enter ISBN", JOptionPane.PLAIN_MESSAGE);
        for(int a = 0; a < FileRead.books.size(); a++){
            if(ISBN.equals(FileRead.books.get(a).getISBN())){
                 if(!ISBN.equals(null) && !ISBN.equals("")){
                    Scanner inGUI = new Scanner(ISBN);
                    ISBN = inGUI.next();
                    break;
                 }else if(ISBN.length() < 10 || ISBN.length() > 10){
                    JOptionPane.showConfirmDialog(null, "ISBN doesn't equal 10", "Error", JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                }else{
                    JOptionPane.showConfirmDialog(null, "You didnt enter anything" , "Error", JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                }   
            }
            if(a + 1 == FileRead.books.size()){
                JOptionPane.showConfirmDialog(null, "No ISBNs matched", "Error", JOptionPane.PLAIN_MESSAGE);
                go();
            }
        }
        
        compare();
 }      
 public void compare() throws IOException{
        String Choices[] = {"Title", "Author", "Publisher", "Date Added", "Quantity", "Wholesale price", "Retail price"};
        String choice = (String)JOptionPane.showInputDialog(null, "Chose what you want to edit", "Make a choice", JOptionPane.PLAIN_MESSAGE,null, Choices, Choices[1]);     
        switch (choice) {
            case "Title":
                 title = JOptionPane.showInputDialog(null, "Enter the new Title", "Changing title", JOptionPane.PLAIN_MESSAGE);
                if(!title.equals(null) || !title.equals("")){
                    sort = 1;
                    break;
                }else{
                    JOptionPane.showConfirmDialog(null, "Incorrect input", "Error", JOptionPane.PLAIN_MESSAGE);
                    compare();
                }
            case "Author":
                author = JOptionPane.showInputDialog(null, "Enter the new Author", "Changing Author", JOptionPane.PLAIN_MESSAGE);
                 if(!author.equals(null) || !author.equals("")){
                    sort = 2;
                    break;
                }else{
                    JOptionPane.showConfirmDialog(null, "Incorrect input", "Error", JOptionPane.PLAIN_MESSAGE);
                    compare();
                }
            case "Publisher":
                publisher = JOptionPane.showInputDialog(null, "Enter the new Publisher", "Changing Publisher", JOptionPane.PLAIN_MESSAGE);
                 if(!publisher.equals(null) || !publisher.equals("")){
                    sort = 3;
                    break;
                }else{
                    JOptionPane.showConfirmDialog(null, "Incorrect input", "Error", JOptionPane.PLAIN_MESSAGE);
                    compare();
                }
            case "Date Added":
                dateAdded = JOptionPane.showInputDialog(null, "Enter the new Date mm/dd/yy", "Changing Date", JOptionPane.PLAIN_MESSAGE);
                if(!dateAdded.equals(null) || !dateAdded.equals("")){
                    sort = 4;
                    break;
                }else{
                    JOptionPane.showConfirmDialog(null, "Incorrect input", "Error", JOptionPane.PLAIN_MESSAGE);
                    compare();
                }    
            case "Quantity":
               
                try{
                quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the new Quantity", "Changing Quantity", JOptionPane.PLAIN_MESSAGE));
                if(quantity > 0){
                    sort = 5;
                    break;
                }else{
                    JOptionPane.showConfirmDialog(null, "Quantity can't be below 0", "Error", JOptionPane.PLAIN_MESSAGE);
                    compare();
                }
                }catch(Exception e){
                    JOptionPane.showConfirmDialog(null, "You didn't enter it as an Integer digit. ex.. 10", "Error", JOptionPane.PLAIN_MESSAGE);
                    compare();
                }
            case "Wholesale price":
                 try{
                wholeSale = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the new Wholesale price", "Changing Wholesale", JOptionPane.PLAIN_MESSAGE));
                if(wholeSale > 0){
                    sort = 6;
                    break;
                }else{
                    JOptionPane.showConfirmDialog(null, "Wholesale price can't be below 0", "Error", JOptionPane.PLAIN_MESSAGE);
                    compare();
                }
                }catch(Exception e){
                    JOptionPane.showConfirmDialog(null, "You didn't enter it as a digit. ex.. 0.00", "Error", JOptionPane.PLAIN_MESSAGE);
                    compare();
                }
            case "Retail price":
                try{
                retail = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the new Retail price", "Changing Retail", JOptionPane.PLAIN_MESSAGE));
                if(retail > 0){
                    sort = 7;
                    break;
                }else{
                    JOptionPane.showConfirmDialog(null, "Retail price can't be below 0", "Error", JOptionPane.PLAIN_MESSAGE);
                    compare();
                }
                }catch(Exception e){
                    JOptionPane.showConfirmDialog(null, "You didn't enter it as a digit. ex.. 0.00", "Error", JOptionPane.PLAIN_MESSAGE);
                    compare();
                }
        }
        editBook();
    }
 public void editBook(){
     for(int a = 0; a < FileRead.books.size(); a++){
         if(ISBN.equals(FileRead.books.get(a).getISBN())){
             switch(sort){ 
                 case 1: // Sets new Title
                     FileRead.books.get(a).setTitle(title);
                     break;
                 case 2: // Sets new Author
                     FileRead.books.get(a).setAuthor(author);
                     break;
                 case 3: // Sets new Publisher
                     FileRead.books.get(a).setPublisher(publisher);
                     break;
                 case 4: // Sets new Date
                     FileRead.books.get(a).setDate(dateAdded);
                     break;
                 case 5: // Sets new Quantity
                     FileRead.books.get(a).setQuantity(quantity);
                     break;
                 case 6: // Sets new Wholesale price
                     FileRead.books.get(a).setWholesale(wholeSale);
                     break;
                 case 7: // Sets new retail price
                     FileRead.books.get(a).setRetail(retail);
                     break;
             }
             JOptionPane.showConfirmDialog(null, "Completed change!", "Done!", JOptionPane.PLAIN_MESSAGE);
             BookInfo book = new BookInfo();
                try {
                    book.writeBook();
                } catch (IOException ex) {
                    JOptionPane.showConfirmDialog(null, "Error, no file was found", "AddBook", JOptionPane.PLAIN_MESSAGE);
                }
         }
     }
     
 }
}
