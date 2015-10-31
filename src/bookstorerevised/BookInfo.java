/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstorerevised;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Justin
 */
public class BookInfo {
    private String ISBN;
    private String title;
    private String author;
    private String publisher;
    private String date;
    private int quantity;
    private double wholesale;
    private double retail;
    private int month, day, year;
    
    
    public BookInfo(){
        ISBN = "";
        title = "";
        author = "";
        publisher = "";
        date = "";
        quantity = 1;
        wholesale = 0.00;
        retail = 0.00;
        month = 00;
        day = 00;
        year = 00;
    }
    public String getISBN(){
        return ISBN;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getPublisher(){
        return publisher;
    }
    public String getDate(){
        return date;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getWholesale(){
        return wholesale;
    }
    public double getRetail(){
        return retail;
    }
    public void setISBN(String newISBN){
        ISBN = newISBN;
    }
    
    public void setTitle(String newTitle){
        title = newTitle;
    }
    public void setAuthor(String newAuthor){
        author = newAuthor;
    }
    public void setPublisher(String newPublisher){
        publisher = newPublisher;
    }
    public void setDate(String newDate){
        date = newDate;
    }
    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }
    public void setWholesale(double newWholesale){
        wholesale = newWholesale;
    }
    public void setRetail(double newRetail){
        retail = newRetail;
    }
    public void setMonth(){
        month = Integer.parseInt(date.substring(0, 2));
    }
    public void setDay(){
        day = Integer.parseInt(date.substring(4, 5));
    }
    public void setYear(){
        year = Integer.parseInt(date.substring(6));
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public int getYear(){
        return year;
    }
    public void writeBook() throws IOException{
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("Records", false))); // Appends to end of file
        for(int i = 0; i < FileRead.books.size(); i++){
            output.println(FileRead.books.get(i).getISBN());
            output.println(FileRead.books.get(i).getTitle());
            output.println(FileRead.books.get(i).getAuthor());
            output.println(FileRead.books.get(i).getPublisher());
            output.println(FileRead.books.get(i).getDate());
            output.println(FileRead.books.get(i).getQuantity());
            output.println(FileRead.books.get(i).getWholesale());
            output.println(FileRead.books.get(i).getRetail());
        }
        output.close();
    }
}
