/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstorerevised;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Justin
 */
public class DeleteBook {
    private String ISBN; 
    private boolean result = false;
    public void compareISBN() throws IOException{
        ISBN = JOptionPane.showInputDialog(null, "Enter the ISBN number of the book you want to remove", "Enter ISBN", JOptionPane.PLAIN_MESSAGE);
        if(ISBN.length() > 10 || ISBN.length() < 10){
            JOptionPane.showConfirmDialog(null, "Enter a 10 digit number", "Error", JOptionPane.PLAIN_MESSAGE);
            compareISBN();
        }
        for(int a = 0; a < FileRead.books.size(); a++){
            if(ISBN.equals(FileRead.books.get(a).getISBN())){
                FileRead.books.remove(a);
                result = true;
                JOptionPane.showConfirmDialog(null, "Book Removed!", "Success!", JOptionPane.PLAIN_MESSAGE);
                BookInfo book = new BookInfo();
                try {
                    book.writeBook();
                } catch (IOException ex) {
                    JOptionPane.showConfirmDialog(null, "Error, no file was found", "AddBook", JOptionPane.PLAIN_MESSAGE);
                }
                break;                
            }
        }
        if(result == false){
            JOptionPane.showConfirmDialog(null, "No ISBNs matched", "Error", JOptionPane.PLAIN_MESSAGE);
            compareISBN();
        }
    }
}
