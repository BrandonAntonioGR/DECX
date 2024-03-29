/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.plantilla;

import com.digitalfinance.DAO.model.ModelConection;
import com.digitalfinance.view.Menu;
import com.digitalfinance.view.ViewMacro;
import java.io.FileOutputStream;
import java.sql.*;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class crearexcelmasivo extends javax.swing.JFrame {
    public void cargarDatosMacroExcel(String agente) {
        // Mostrar mensaje de carga en un hilo aparte
        final JDialog loadingDialog = new JDialog(this, "Cargando datos... ", true);
        SwingUtilities.invokeLater(() -> {
            loadingDialog.setSize(200, 100);
            loadingDialog.setLocationRelativeTo(this);
            //loadingDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            JLabel loadingLabel = new JLabel("Guardando datos a Excel...");
            loadingLabel.setHorizontalAlignment(JLabel.CENTER);
            loadingDialog.add(loadingLabel);

            loadingDialog.setVisible(true);
        });

        // Simulando la carga del JFrame "macro" en un hilo aparte
        new Thread(() -> {
            exportToExcel(agente);
            SwingUtilities.invokeLater(() -> {
                loadingDialog.dispose();
            });
        }).start();
    }
    public void exportToExcel(String agente) {
        Connection con;
        PreparedStatement ps;
        FileOutputStream outputStream = null;
        try {
            con=ModelConection.getConnection();
            ps=con.prepareStatement("SELECT --cast([Creation_Day] as date ) \n" +
                "      [Agente] AS AGENTE\n" +
                "      ,a.[TEL] AS TELEFONO\n" +
                "      ,a.[CONTRATO] AS CONTRATO\n" +
                "      ,convert(int,dpd) as DPD\n" +
                "      ,[Adeudo] AS ADEUDO\n" +
                "      ,[NOMBRE] AS NOMBRE\n" +
                "	  ,ll.correo AS CORRE0\n" +
                "      ,[SPEI_CLABE] AS SPEI\n" +
                "      ,[OXXOReference] AS OXXO\n" +
                "      ,CASE WHEN [ALGORITMO] = '' THEN 'D'ELSE [ALGORITMO] END AS ALGORITMO\n" +
                "	  ,w.Enviado AS ENVIADO\n" +
                "	  ,m.Conteo AS CONTEO\n" +
                "FROM [DC REPORT].[dbo].[DC_HIS_ASIG] AS a\n" +
                "  LEFT JOIN  [DC REPORT].[dbo].[dm_LLAVES] AS ll on ll.contract_id=a.CONTRATO\n" +
                "  LEFT JOIN (SELECT w1.[Contrato],COUNT(w1.[Enviado]) AS Enviado FROM [DC REPORT].[dbo].[dm_PJavaMsgWhatsappp] as w1 GROUP BY w1.[Contrato]) AS w on w.[Contrato] = a.CONTRATO\n" +
                "  LEFT JOIN (SELECT  [Cliente] ,COUNT([Cliente]) as Conteo FROM [DC REPORT].[dbo].[Mitrol_int] where cast([Fecha_interaccion] as date ) = cast(getdate() as date ) AND [Campaña] LIKE '%W%'group by [Cliente]) AS m on m.Cliente = a.[TEL]\n" +
                "  where cast([Creation_Day] as date ) = cast(GETDATE ()as date )\n" +
                "  AND a.[CONTRATO] NOT IN (SELECT  [ContractNumber]  FROM [DC REPORT].[dbo].[PaymentPromises]  WHERE CAST([ContactDate] AS DATE)  BETWEEN DATEADD(DAY, -5, CONVERT(DATE, GETDATE())) AND CAST(GETDATE() AS DATE) \n" +
                "		UNION \n" +
                "		SELECT [Contrato] FROM [DC REPORT].[dbo].[CurrentDatePayment] \n" +
                "		UNION \n" +
                "		SELECT [number] FROM [DC REPORT].[dbo].[dm_PJava])\n" +
                    "  AND a.Agente='"+agente+"'\n" +
                "ORDER BY convert(int,a.Adeudo) ASC");
            ResultSet rs=ps.executeQuery();
            // Ejecutar la consulta SQL
            ResultSet rs1 = rs;

            // Crear el libro de Excel y la hoja de trabajo
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Resultado de consulta");

            // Crear la fila para los encabezados
            Row headerRow = sheet.createRow(0);

            // Obtener metadatos de la consulta para los nombres de columna
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                headerRow.createCell(i - 1).setCellValue(columnName);
            }

            // Llenar el contenido de la hoja de trabajo con los datos del ResultSet
            int rowNum = 1;
            while (rs.next()) {
                Row row = sheet.createRow(rowNum++);
                for (int i = 1; i <= columnCount; i++) {
                    Object value = rs.getObject(i);
                    if (value != null) {
                        row.createCell(i - 1).setCellValue(value.toString());
                    } else {
                        row.createCell(i - 1).setCellValue(""); // Manejo de valor nulo
                    }
                }
            }

            // Escribir el libro de Excel en un archivo
            outputStream = new FileOutputStream("Macro.xlsx");
            workbook.write(outputStream);
            workbook.close();
            rs.close();
            System.out.println("Exportación exitosa a 'Macro.xlsx'");
            JOptionPane.showMessageDialog(null, "Archivo Excel creado correctamente.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            cerrarConexion(con, ps, rs);
            
        } catch (Exception e) {
            System.out.println("error: " + e);
            
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close(); // Cierra el flujo de salida
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void cerrarConexion(Connection con,PreparedStatement ps,ResultSet rs) throws SQLException{
        con.close();
        ps.close();
        rs.close();
    }    
}
