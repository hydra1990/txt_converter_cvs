package main;

import domain.Auditoria;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Converter {
    List<Auditoria> auditorias = new ArrayList<>();
    File auditTxt;

    public void convert() throws IOException {
        auditTxt = getAuditTxt();
        addAuditorias(auditTxt);
        exportToCsv();
    }

    private File getAuditTxt() {
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

    private void addAuditorias(File auditTxt) {
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

    private void transformAuditoria(String cuenta) {
        String[] information = cuenta.split("(^\"|\",\"|,)");
        Auditoria auditoria = new Auditoria();
        auditoria.setCuenta(information[1]);
        auditoria.setDescripcion(information[2]);
        auditoria.setEntidad(information[3]);
        auditoria.setAct(information[4]);
        auditoria.setSaldoApertura(new BigDecimal(information[5]));
        auditoria.setSaldoInicial(new BigDecimal(information[6]));
        auditoria.setDebito(new BigDecimal(information[7]));
        auditoria.setCredito(new BigDecimal(information[8]));
        auditoria.setSaldoFinal(new BigDecimal(information[9]));

        auditorias.add(auditoria);
    }

    private void exportToCsv() throws IOException {
        String[] auditRoute = auditTxt.getAbsolutePath().split("\\.");
        String route = auditRoute[0];
        FileWriter writer = new FileWriter(route + ".csv");

        CSVUtils.writeLine(writer, Arrays.asList("Cuenta", "Descripcion", "Entidad", "Act", "Saldo Apertura"
                , "Saldo Inicial", "Debito", "Credito", "Saldo Final"));

        for (Auditoria auditoria : auditorias) {
            List<String> list = new ArrayList<>();
            list.add(auditoria.getCuenta());
            list.add(auditoria.getDescripcion());
            list.add(auditoria.getEntidad());
            list.add(auditoria.getAct());
            list.add(auditoria.getSaldoApertura().toString());
            list.add(auditoria.getSaldoInicial().toString());
            list.add(auditoria.getDebito().toString());
            list.add(auditoria.getCredito().toString());
            list.add(auditoria.getSaldoFinal().toString());

            CSVUtils.writeLine(writer, list);
        }

        writer.flush();
        writer.close();

        JOptionPane.showMessageDialog(null, "CSV generado en " + route + ".csv");
    }
}
