package main;

import domain.Auditoria;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    List<Auditoria> auditorias = new ArrayList<>();

    public static void main(String[] args) {
        File auditTxt = getAuditTxt();
        addAuditorias(auditTxt);
    }

    private static File getAuditTxt() {
        JFileChooser fileChooser = new JFileChooser();
        FileFilter txtFilter = new FileNameExtensionFilter("Plain Text Files", "txt");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(txtFilter);

        int returnVal = fileChooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }

        return null;
    }

    private static void addAuditorias(File auditTxt) {
        try (Scanner myReader = new Scanner(auditTxt)) {
            if (myReader.hasNextLine()) {
                myReader.nextLine();
            }
            while (myReader.hasNextLine()) {
                String dataLine = myReader.nextLine();
                transformAuditoria(dataLine);
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Convert to Auditoria
    private static void transformAuditoria(String cuenta) {
        String[] information = cuenta.split("\",\"");
        System.out.println(Arrays.toString(information));
    }

    // Return a CSV
}