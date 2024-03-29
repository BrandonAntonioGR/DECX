/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.DAO.entity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GeneraExcelMacro {
    public static void generaExcelPromesas(ArrayList<Macro> lstMacro) {
        // Crear un nuevo libro de Excel
        try (Workbook workbook = new XSSFWorkbook()) {
            // Crear una hoja en el libro
            Sheet sheet = workbook.createSheet("Promesas");

            // Escribir encabezados
            Row headerRow = sheet.createRow(0);
            String[] headers = {"AGENTE", "TELEFONO", "CONTRATO","DPD","ADEUDO","NOMBRE","CORREO","SPEI","OXXO","ALGORITMO","WHATSAPP","MITROL"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // Iterar sobre los datos y escribirlos en la hoja
            int rowNum = 1;
            for (Macro listaMacro : lstMacro) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(listaMacro.getAgente());
                row.createCell(1).setCellValue(listaMacro.getTel());
                row.createCell(2).setCellValue(listaMacro.getNumber());
                row.createCell(3).setCellValue(listaMacro.getDpd());
                row.createCell(4).setCellValue(listaMacro.getAdeudo());
                row.createCell(5).setCellValue(listaMacro.getNombre());
                row.createCell(6).setCellValue(listaMacro.getCorreo());
                row.createCell(7).setCellValue(listaMacro.getSpeiClave());
                row.createCell(8).setCellValue(listaMacro.getOxxoReference());
                row.createCell(9).setCellValue(listaMacro.getAlgoritmo());
                row.createCell(10).setCellValue(listaMacro.getEnviado());
                row.createCell(11).setCellValue(listaMacro.getConteoMit());                
            }

            // Escribir los datos al archivo
            try (FileOutputStream outputStream = new FileOutputStream("MacroFiltrado.xlsx")) {
                workbook.write(outputStream);
                JOptionPane.showMessageDialog(null, "Archivo Excel creado correctamente.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se agregaron los datos al archivo excel, posiblemente tengas el archivo datos_macro.xlsx abierto."+e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
