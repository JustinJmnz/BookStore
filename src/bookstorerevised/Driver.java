/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstorerevised;

import java.io.*;

/**
 *
 * @author Justin
 */
public class Driver {
 public static void main(String[] args) throws FileNotFoundException {
        FileRead file = new FileRead();
        file.sortFile();
        MainMenu MainMenu = new MainMenu("Serendipity Booksellers");
        MainMenu.setLocationRelativeTo(null);
        MainMenu.setVisible(true);
        
    }

}
