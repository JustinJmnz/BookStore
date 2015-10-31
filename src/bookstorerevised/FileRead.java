/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstorerevised;

import java.io.*;
import java.util.*;

/**
 *
 * @author Justin
 */
public class FileRead {
    public static ArrayList<BookInfo> books = new ArrayList<>(); 
    private String ISBN;
    private String title;
    private String author;
    private String publisher;
    private String date;
    private int quantity;
    private double wholesale;
    private double retail;
    
    public void sortFile() throws FileNotFoundException{
        Scanner inFile = new Scanner(new FileReader("Records"));
        while(inFile.hasNextLine()){
            BookInfo book = new BookInfo();
            ISBN = inFile.nextLine();
            title = inFile.nextLine();
            author = inFile.nextLine();
            publisher = inFile.nextLine();
            date = inFile.nextLine();
            quantity = inFile.nextInt();
            wholesale = inFile.nextDouble();
            retail = inFile.nextDouble();
            inFile.nextLine();
            book.setISBN(ISBN);
            book.setTitle(title);
            book.setAuthor(author);
            book.setPublisher(publisher);
            book.setDate(date);
            book.setQuantity(quantity);
            book.setWholesale(wholesale);
            book.setRetail(retail);
            book.setDay(); // Sets the day
            book.setMonth(); // Sets the month
            book.setYear(); // Sets the year
            books.add(book);
        }
        
    }
}
