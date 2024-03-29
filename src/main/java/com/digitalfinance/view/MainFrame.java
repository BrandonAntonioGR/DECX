/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.view;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private JTable table;
    private JButton button;
    private JLabel resultLabel;

    public MainFrame() {
        setTitle("Tabla con Función");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String[][] data = {
            {"A", "1"},
            {"B", "2"},
            {"C", "3"}
        };

        String[] columnNames = {"Letra", "Número"};

        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        button = new JButton("Obtener Valor");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                if (row != -1 && col != -1) {
                    String value = (String) table.getValueAt(row, col);
                    // Aquí puedes ejecutar tu función con el valor obtenido
                    // Aquí solo se imprimirá en consola el valor seleccionado
                    System.out.println("Valor seleccionado: " + value);
                    resultLabel.setText("Valor seleccionado: " + value);
                } else {
                    resultLabel.setText("Selecciona una celda primero");
                }
            }
        });

        resultLabel = new JLabel("");

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int row = table.getSelectedRow();
                    int col = table.getSelectedColumn();
                    if (row != -1 && col != -1) {
                        String value = (String) table.getValueAt(row, col);
                        resultLabel.setText("Celda seleccionada: " + value);
                    }
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(button);
        panel.add(resultLabel);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panel, BorderLayout.SOUTH);
    }
}