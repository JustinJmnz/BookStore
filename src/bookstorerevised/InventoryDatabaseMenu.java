/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstorerevised;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Justin
 */
public class InventoryDatabaseMenu extends JFrame implements ActionListener {
    private JLabel lblStoreName;
    private JButton btnMainMenu;
    private JButton btnLookUp;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    public InventoryDatabaseMenu(String title){
        super(title);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 7, 0, 10));
      
        lblStoreName = new JLabel("SERENDIPITY BOOKSELLERS", JLabel.CENTER); //Title
           add(lblStoreName);
        btnMainMenu = new JButton("Main Menu"); // Main menu button
            btnMainMenu.addActionListener(this);
            add(btnMainMenu);
        btnLookUp = new JButton("Look-up a book"); // Look-up button
            btnLookUp.addActionListener(this);
            add(btnLookUp);
        btnAdd = new JButton("Add a book"); // Add a book button
            btnAdd.addActionListener(this);
            add(btnAdd);
        btnEdit = new JButton("Edit a book"); // Edit a book button
            btnEdit.addActionListener(this);
            add(btnEdit);
        btnDelete = new JButton("Delete a book"); // Delete book button
            btnDelete.addActionListener(this);
            add(btnDelete);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals(btnMainMenu.getText())){
            MainMenu MainGUI = new MainMenu("Serendipity Booksellers");
            MainGUI.setLocationRelativeTo(null);
            MainGUI.setVisible(true);
            this.dispose();
         }else if(event.getActionCommand().equals(btnLookUp.getText())){
           BookLookUp look;
            try {
                look = new BookLookUp("Serendipity Booksellers");
                look.setLocationRelativeTo(null);
           look.setVisible(true);
           this.dispose();
            } catch (FileNotFoundException ex) {
                JOptionPane.showConfirmDialog(null, "Error", "BookLookUp", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }
           
         }else if(event.getActionCommand().equals(btnAdd.getText())){
           AddBook add = new AddBook("Serendipity BookSellers");
           add.setLocationRelativeTo(null);
           add.setVisible(true);
           this.dispose();
         }else if(event.getActionCommand().equals(btnEdit.getText())){
           EditBook edit = new EditBook();
            try {
                edit.go();
            } catch (FileNotFoundException ex) {
                System.exit(0);
            } catch (IOException ex) {
                System.exit(0);
            }
         }else if(event.getActionCommand().equals(btnDelete.getText())){
          DeleteBook delete = new DeleteBook();
            try {
                delete.compareISBN();
            } catch (IOException ex) {
                System.exit(0);
            }
         }
    }
}
