/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstorerevised;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
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
public class ReportsAllBooks extends JFrame implements ActionListener {
    private JButton btnBack;
    private JLabel lblInfo;
    private JTextArea txtInfo;
    private JScrollPane scroll;
    private String output = "";
    
    public ReportsAllBooks(String title) throws FileNotFoundException{
        super(title);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        getContentPane().add(panel, BorderLayout.NORTH);
        GridBagConstraints c = new GridBagConstraints();
        btnBack = new JButton("Back");
            c.gridx = 0;
            c.gridy = 0;
            btnBack.addActionListener(this);
            panel.add(btnBack, c);
       lblInfo = new JLabel("All book Information");
            c.gridx = 0;
            c.gridy = 1;
            panel.add(lblInfo, c);
       txtInfo = new JTextArea(25,50);
            c.gridx = 0;
            c.gridy = 3;
            append(); // appends books to text field
            txtInfo.append(output);
            txtInfo.setEditable(false); // Text Field is uneditable
            panel.add(txtInfo, c);
       scroll = new JScrollPane(txtInfo); // Scroll bar
            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            panel.add(scroll, c);
   }
    public void append(){
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
    }
}
