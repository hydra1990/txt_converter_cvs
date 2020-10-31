package main;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Receive a TXT
        try {
            File auditTxt = new File("/home/aleph02/Documents/audit.txt");
            Scanner myReader = new Scanner(auditTxt);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        // Convert to Auditoria

        // Return a CSV

    }
}