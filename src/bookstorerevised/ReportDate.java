/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstorerevised;

import static bookstorerevised.FileRead.books;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Justin
 */
public class ReportDate extends JFrame implements ActionListener {
    private JButton btnBack;
    private JLabel lblInfo;
    private JTextArea txtInfo;
    private JScrollPane scroll;
    private String output = "";
    public ReportDate(String title) throws FileNotFoundException{
        super(title);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        getContentPane().add(panel, BorderLayout.NORTH);
        GridBagConstraints c = new GridBagConstraints();
        sort(); // Sorts Books
        btnBack = new JButton("Back");
            c.gridx = 0;
            c.gridy = 0;
            btnBack.addActionListener(this);
            panel.add(btnBack, c);
       lblInfo = new JLabel("Listed by Date (Oldest to Newest)");
            c.gridx = 0;
            c.gridy = 1;
            panel.add(lblInfo, c);
       txtInfo = new JTextArea(25,50);
            c.gridx = 0;
            c.gridy = 2;    
            txtInfo.append(output);
            txtInfo.setEditable(false); // Text Field is uneditable
            panel.add(txtInfo, c);
       scroll = new JScrollPane(txtInfo); // Scroll bar
            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            panel.add(scroll, c);
} // End of constructor
    public void sort(){ 
     Collections.sort(books, new Comparator<BookInfo>(){
            @Override
            public int compare(BookInfo book1, BookInfo book2) {
                Integer year1 = book1.getYear(); // Casts to Integer
                Integer year2 = book2.getYear(); // Casts to Integer
                int result = year1.compareTo(year2); // Compares Years
                if(result == 0){ // If years are equal
                    Integer month1 = book1.getMonth(); // Casts to Integer
                    Integer month2 = book2.getMonth(); // Casts to Integer
                    result = month1.compareTo(month2); // Compares months
                    if(result == 0){ // If months are equal
                        Integer day1 = book1.getDay(); // Casts to Integer
                        Integer day2 = book1.getDay(); // Casts to Integer
                        result = day1.compareTo(day2); // Compares days
                        if(result == 0){ // If days are equal
                            return book1.getTitle().compareTo(book2.getTitle()); // Sort by title
                        }
                    }
                }
                return result; // Sort by date
            }
        });
        for(int a = 0; a < FileRead.books.size(); a++){
            output += "Book " + (a+1) + "\n";
            output += "------" + "\n";
            output += "ISBN: " + FileRead.books.get(a).getISBN() + "\n";
            output += "Title: " + FileRead.books.get(a).getTitle() + "\n";
            output += "Author: " + FileRead.books.get(a).getAuthor() + "\n";
            output += "Publisher: " + FileRead.books.get(a).getPublisher() + "\n";
            output += "Date Added: " + FileRead.books.get(a).getDate() + "\n";
            output += "Quantity in Stock: " + String.valueOf(FileRead.books.get(a).getQuantity()) + "\n";
            output += "Wholesale price: $" + String.valueOf(FileRead.books.get(a).getWholesale()) + "\n";
            output += "Retail price: $" + String.valueOf(FileRead.books.get(a).getRetail()) + "\n";
            output += "\n";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(btnBack.getText())){
            ReportsMenu reportGUI = new ReportsMenu("Serendiptity Booksellers");
            reportGUI.setLocationRelativeTo(null);
            reportGUI.setVisible(true);
            this.dispose();
        }
    } // End of actionPerformed
} // End of class
