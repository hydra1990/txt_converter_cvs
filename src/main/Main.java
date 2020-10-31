package main;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Receive a TXT
        try {
            JFileChooser fileChooser = new JFileChooser();
            FileFilter txtFilter = new FileNameExtensionFilter("Plain Text Files", "txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setFileFilter(txtFilter);

            int returnVal = fileChooser.showOpenDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION){
                File auditTxt = fileChooser.getSelectedFile();
                Scanner myReader = new Scanner(auditTxt);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        // Convert to Auditoria

        // Return a CSV

    }
}