/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.DAO.entity;

import org.apache.poi.ss.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GenerarExcelPromesas {
    public static void generaExcelPromesas(ArrayList<Promesa> lstPromesas) {
        // Crear un nuevo libro de Excel
        try (Workbook workbook = new XSSFWorkbook()) {
            // Crear una hoja en el libro
            Sheet sheet = workbook.createSheet("Promesas");

            // Escribir encabezados
            Row headerRow = sheet.createRow(0);
            String[] headers = {"Pago", "Contrato", "Nombre Cliente","DiasPromesa","Telefono","Agente","Correo","Monto Promesado","OXXO Reference","SPEI Reference","Fecha Promesa","Extencion 20"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // Iterar sobre los datos y escribirlos en la hoja
            int rowNum = 1;
            for (Promesa promesa : lstPromesas) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(promesa.getPago());
                row.createCell(1).setCellValue(promesa.getContrato());
                row.createCell(2).setCellValue(promesa.getNombreCte());
                row.createCell(3).setCellValue(promesa.getDiasPromesa());
                row.createCell(4).setCellValue(promesa.getTelCte());
                row.createCell(5).setCellValue(promesa.getAgente());
                row.createCell(6).setCellValue(promesa.getCorreoCte());
                row.createCell(7).setCellValue(promesa.getMontoPromesado());
                row.createCell(8).setCellValue(promesa.getOxxoReference());
                row.createCell(9).setCellValue(promesa.getSpeiReference());
                row.createCell(10).setCellValue(promesa.getFechaPromesada());
                row.createCell(11).setCellValue(promesa.getExtencion20());                
            }

            // Escribir los datos al archivo
            try (FileOutputStream outputStream = new FileOutputStream("Promesas.xlsx")) {
                workbook.write(outputStream);
                JOptionPane.showMessageDialog(null, "Archivo Excel creado correctamente.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se agregaron los datos al archivo excel, posiblemente tengas el archivo datos_promesas.xlsx abierto."+e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
