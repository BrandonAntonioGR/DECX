/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.digitalfinance.view;

import com.digitalfinance.DAO.entity.Macro;
import com.digitalfinance.DAO.entity.Plantilla;
import com.digitalfinance.DAO.entity.PromesaPago;
import com.digitalfinance.DAO.model.ConsultarPlantilas;
import com.digitalfinance.controller.ControllerCreaPromesaPago;
import com.digitalfinance.controller.ControllerInsertarPromesaPago;
import com.opencsv.exceptions.CsvValidationException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class GeneraPromesa extends javax.swing.JFrame {
    ControllerInsertarPromesaPago cargarPromesaPago= new ControllerInsertarPromesaPago();
    ControllerCreaPromesaPago consultaPromesa = new ControllerCreaPromesaPago();
    ConsultarPlantilas consultarPlantillas = new ConsultarPlantilas();
    boolean contratoEncontrado = false;
    boolean fecharango=false;
    int adeudo = 0;
    int saldoHoy = 0;
    int ext10 = 0;
    int ext20 = 0;
    int ext30 = 0;
    String agnt;
    ArrayList<Plantilla> lstPlantillas = new ArrayList<>();
    String referenciaOxxo;
    String referenciaSpei;
    Date fechaPago;

    String contrato;
    String nombre;
    String dpd;
    String algoritmo;

    public GeneraPromesa(String agente) {
        initComponents();
        txtComentarios.setWrapStyleWord(true);
        this.agnt = agente;
        try {
            ArrayList<Plantilla> listaPlantillas = consultarPlantillas.leerCSV();
            lstPlantillas = listaPlantillas;
            //cmbSelec.addItem("---Seleccione la plantilla---");
            for (int i = 0; i < lstPlantillas.size(); i++) {
                Plantilla plantilla = new Plantilla();
                plantilla = lstPlantillas.get(i);
                cmbSelec.addItem(plantilla.getNombrePlantilla());
            }
        } catch (CsvValidationException ex) {
            Logger.getLogger(ViewMacro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        panelDerecha = new javax.swing.JPanel();
        txtFechaPromesa = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbTipoMonto = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cmbSelec = new javax.swing.JComboBox<>();
        panelIzquierda = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbAccion = new javax.swing.JComboBox<>();
        cmbContacto = new javax.swing.JComboBox<>();
        cmbCanal = new javax.swing.JComboBox<>();
        cmbTipoPromesa = new javax.swing.JComboBox<>();
        panelAbajo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComentarios = new javax.swing.JTextArea();
        btnGuardarPromesa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        panelBuscaContrato = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtContrato = new javax.swing.JTextField();
        btnBuscarContrato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtFechaPromesa.setDateFormatString("dd/MM/yyyy");

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel4.setText("Fecha  de promesa:");

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel7.setText("T ipo Monto:");

        cmbTipoMonto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SALDO TOTAL", "SALDO HOY", "EXT 10", "EXT 20", "EXT 30" }));
        cmbTipoMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoMontoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel9.setText("Monto:");

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel11.setText("Cargar plantilla:");

        cmbSelec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDerechaLayout = new javax.swing.GroupLayout(panelDerecha);
        panelDerecha.setLayout(panelDerechaLayout);
        panelDerechaLayout.setHorizontalGroup(
            panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDerechaLayout.createSequentialGroup()
                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelDerechaLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtFechaPromesa, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelDerechaLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbSelec, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDerechaLayout.createSequentialGroup()
                        .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDerechaLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDerechaLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMonto)
                            .addComponent(cmbTipoMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDerechaLayout.setVerticalGroup(
            panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDerechaLayout.createSequentialGroup()
                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDerechaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtFechaPromesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDerechaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbTipoMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cmbSelec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel6.setText("Contacto:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel5.setText("Canal:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel8.setText("Medio de contacto:");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel2.setText("Tipo promesa:");

        cmbAccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTACTO TITULAR", "CONTACTO TERCERO", "CONTACTO REP. LEGAL" }));

        cmbContacto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CELULAR", "CASA", "TRABAJO" }));

        cmbCanal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MITROL", "MSGBIRD", "MACRO", "SMS", "CORREO ELECTRONICO" }));

        cmbTipoPromesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PAGO TOTAL", "PAGO DESCUENTO", "EXTENSION TOTAL", "EXTENSION DESCUENTO" }));

        javax.swing.GroupLayout panelIzquierdaLayout = new javax.swing.GroupLayout(panelIzquierda);
        panelIzquierda.setLayout(panelIzquierdaLayout);
        panelIzquierdaLayout.setHorizontalGroup(
            panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIzquierdaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelIzquierdaLayout.createSequentialGroup()
                        .addGroup(panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbAccion, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbCanal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelIzquierdaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipoPromesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        panelIzquierdaLayout.setVerticalGroup(
            panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIzquierdaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbTipoPromesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(20, 20, 20)
                .addGroup(panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel1.setText("Comentarios:");

        txtComentarios.setColumns(20);
        txtComentarios.setRows(5);
        jScrollPane1.setViewportView(txtComentarios);

        btnGuardarPromesa.setBackground(new java.awt.Color(0, 109, 56));
        btnGuardarPromesa.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btnGuardarPromesa.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarPromesa.setText("Guardar");
        btnGuardarPromesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPromesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAbajoLayout = new javax.swing.GroupLayout(panelAbajo);
        panelAbajo.setLayout(panelAbajoLayout);
        panelAbajoLayout.setHorizontalGroup(
            panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAbajoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAbajoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(546, Short.MAX_VALUE))
                    .addGroup(panelAbajoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarPromesa)
                        .addGap(26, 26, 26))))
        );
        panelAbajoLayout.setVerticalGroup(
            panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAbajoLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAbajoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAbajoLayout.createSequentialGroup()
                        .addComponent(btnGuardarPromesa)
                        .addGap(39, 39, 39))))
        );

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(panelIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addComponent(panelAbajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 109, 56));

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Generar promesa de pago ");

        btnRegresar.setBackground(new java.awt.Color(0, 109, 56));
        btnRegresar.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jLabel10.setText("Ingresa contrato:");

        btnBuscarContrato.setBackground(new java.awt.Color(0, 109, 56));
        btnBuscarContrato.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnBuscarContrato.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarContrato.setText("Buscar");
        btnBuscarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarContratoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBuscaContratoLayout = new javax.swing.GroupLayout(panelBuscaContrato);
        panelBuscaContrato.setLayout(panelBuscaContratoLayout);
        panelBuscaContratoLayout.setHorizontalGroup(
            panelBuscaContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscaContratoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarContrato)
                .addGap(175, 175, 175))
        );
        panelBuscaContratoLayout.setVerticalGroup(
            panelBuscaContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscaContratoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBuscaContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarContrato))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBuscaContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBuscaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarPromesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPromesaActionPerformed
        Date fechaSeleccionada = txtFechaPromesa.getDate();
        if (fechaSeleccionada != null && contratoEncontrado==true) {
            Date fechaPromesa = fechaPromesa(fechaSeleccionada);
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea continuar?", "Se guardara la promesa", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                String tipoPromesa = cmbTipoPromesa.getSelectedItem().toString();
                String canal = cmbCanal.getSelectedItem().toString();
                String contacto = cmbAccion.getSelectedItem().toString();
                String medioContacto = cmbContacto.getSelectedItem().toString();
                String fechaActual=obtenerFechaActual();
                String promiseDateS=obtenerFechaFormateada(fechaPromesa);
                
                // Creamos un objeto Calendar y lo configuramos con la fecha actual
                Calendar calendario = Calendar.getInstance();
                calendario.setTime(fechaPromesa);
                // Sumamos un día al objeto Calendar
                calendario.add(Calendar.DAY_OF_YEAR, 1);
                // Obtenemos la fecha resultante
                Date promiseLimitDate = calendario.getTime();
                String promiseLimitDateS=obtenerFechaFormateada(promiseLimitDate);
                
                PromesaPago pp = new PromesaPago();
                pp.setContrato(contrato);
                pp.setDpd(dpd);
                pp.setAlgoritmo(algoritmo);
                pp.setContactDate(fechaActual);
                pp.setPromiseDate(promiseDateS);
                pp.setPromiseLimitDate(promiseLimitDateS);
                pp.setPromiseAmount(Double.parseDouble(txtMonto.getText()));
                pp.setAgente(agnt);
                pp.setPromiseType(tipoPromesa);
                pp.setCanal(canal);
                pp.setContacto(contacto);
                pp.setMedioContacto(medioContacto);
                pp.setComentarios(txtComentarios.getText());
                cargarPromesaPago.CargarPromesaPago(pp);
                
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solo es posible ingresar fechas en el rango de hoy a 5 dias posteriores", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarPromesaActionPerformed
    
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarContratoActionPerformed
        String obtenercontrato = txtContrato.getText();
        Macro macro = consultaPromesa.consultaCreaPromesaPago(obtenercontrato);
        String adeudos = macro.getAdeudo();
        String saldoHoys = macro.getSaldoHoy();
        String ext20s = macro.getExtension20();
        String ext30s = macro.getExtension30();
        String openprincipal = macro.getOpen_principal();
        if (adeudos != null && saldoHoys != null && openprincipal != null && ext20s != null && ext30s != null) {
            double capitalDouble = Double.parseDouble(openprincipal);
            double valorminimoExt = capitalDouble * 0.075;
            double aux;
            if (valorminimoExt < 150) {
                aux = valorminimoExt;
            } else {
                aux = 150;
            }
            double ext10double = (10 * 0.018 * capitalDouble * 1.16) + aux;
            int extencion10 = (int) Math.ceil(ext10double);
            ext10 = extencion10;

            double adeudodouble = Double.parseDouble(adeudos);
            int adeudoint = (int) Math.ceil(adeudodouble);
            adeudo = adeudoint;

            double saldoHoydouble = Double.parseDouble(saldoHoys);
            int saldohoyint = (int) Math.ceil(saldoHoydouble);
            saldoHoy = saldohoyint;

            double ext20double = Double.parseDouble(ext20s);
            int ext20int = (int) Math.ceil(ext20double);
            ext20 = ext20int;

            double ext30double = Double.parseDouble(ext30s);
            int ext30int = (int) Math.ceil(ext30double);
            ext30 = ext30int;

            //bandera para saber si encontro el contrato
            contratoEncontrado = true;

            //seteo de datos extra
            dpd = macro.getDpd();
            referenciaOxxo = macro.getOxxoReference();
            referenciaSpei = macro.getSpeiClave();
            fechaPago = macro.getFechaPago();
            contrato = macro.getNumber();
            nombre = macro.getNombre();
            algoritmo=macro.getAlgoritmo();
        } else {
            JOptionPane.showMessageDialog(null, "Contrato ya promesado", "Advertencia", JOptionPane.ERROR_MESSAGE);
            contratoEncontrado = false;
        }
    }//GEN-LAST:event_btnBuscarContratoActionPerformed

    private void cmbTipoMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoMontoActionPerformed
        int opcTipoMonto = cmbTipoMonto.getSelectedIndex();
        switch (opcTipoMonto) {
            case 0:
                //SALDO TOTAL
                txtMonto.setText(adeudo + "");
                break;
            case 1:
                //SALDO HOY
                txtMonto.setText(saldoHoy + "");
                break;
            case 2:
                //EXT 10
                txtMonto.setText(ext10 + "");
                break;
            case 3:
                //EXT 20
                txtMonto.setText(ext20 + "");
                break;
            case 4:
                //EXT 30
                txtMonto.setText(ext30 + "");
                break;
        }
    }//GEN-LAST:event_cmbTipoMontoActionPerformed

    private void cmbSelecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelecActionPerformed
        try {
            if (!txtContrato.getText().isEmpty()) {
                ArrayList<Plantilla> listaPlantillas = consultarPlantillas.leerCSV();
                int opc = cmbSelec.getSelectedIndex();
                Plantilla pl = listaPlantillas.get(opc);
                String descPlantilla = pl.getDescPlantilla();

                String patronNombreVariable = "/NOMBRE_VARIABLE/";
                String NombreCteStr = nombre;
                String descPlantilla1 = modificarCoincidencias(patronNombreVariable, descPlantilla, NombreCteStr);
                //obteniendo credito del clinete
                String patronCreditoVariable = "/CREDITO_VARIABLE/";
                String contratoStr = contrato;
                String descPlantilla2 = modificarCoincidencias(patronCreditoVariable, descPlantilla1, contratoStr);
                //obteniendo fecha de pago del clinete
                String patronFechaPagoVariable = "/FECHA_PAGO/";
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
                String oFechPago = formatoFecha.format(fechaPago);
                String descPlantilla3 = modificarCoincidencias(patronFechaPagoVariable, descPlantilla2, oFechPago);
                //obteniendo nombre del clinete
                String patronAdeudoVariable = "/ADEUDO_VARIABLE/";
                String AdeudoVariableStr = adeudo + "";
                String descPlantilla4 = modificarCoincidencias(patronAdeudoVariable, descPlantilla3, AdeudoVariableStr);

                //obteniendo saldo del clinete
                String patronSaldoVariable = "/SALDO_VARIABLE/";
                String SaldoVariableStr = saldoHoy + "";
                String descPlantilla5 = modificarCoincidencias(patronSaldoVariable, descPlantilla4, SaldoVariableStr);

                //obteniendo ext20 del clinete
                String patronExt20NombreVariable = "/EXT_20/";
                String ext20Str = ext20 + "";
                String descPlantilla6 = modificarCoincidencias(patronExt20NombreVariable, descPlantilla5, ext20Str);

                //obteniendo ext20 del clinete
                String patronExt20Variable = "/EXT_30/";
                String ext30Str = ext30 + "";
                String descPlantilla7 = modificarCoincidencias(patronExt20Variable, descPlantilla6, ext30Str);

                String patronSpeiVariable = "/REF_SPEI/";
                String oSpei = referenciaSpei;
                String descPlantilla8 = modificarCoincidencias(patronSpeiVariable, descPlantilla7, oSpei);

                String patronOxxoVariable = "/REF_OXXO/";
                String oOxxo = referenciaOxxo;
                String descPlantilla9 = modificarCoincidencias(patronOxxoVariable, descPlantilla8, oOxxo);

                txtComentarios.setText(descPlantilla9);
            }

        } catch (CsvValidationException ex) {
            Logger.getLogger(ViewMacro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbSelecActionPerformed
    public String modificarCoincidencias(String patronNombreVariable, String descPlantilla, String OBJETONOMBRE) {
        Pattern patternNombreVariable = Pattern.compile(patronNombreVariable);
        Matcher similitudNombreVariable = patternNombreVariable.matcher(descPlantilla);
        String textoNuevo1 = similitudNombreVariable.replaceAll(OBJETONOMBRE);
        return textoNuevo1;
    }
    public Date fechaPromesa(Date fechaIngresada) {
        // Obtener la fecha de ayer
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date fechaAyer = calendar.getTime();

        // Obtener la fecha de hace 5 días
        calendar.add(Calendar.DAY_OF_YEAR, 6);
        Date fechaHaceCincoDias = calendar.getTime();

        // Comparar las fechas
        if (fechaIngresada.after(fechaAyer) && fechaIngresada.before(fechaHaceCincoDias)) {
            System.out.println("okey");
            return fechaIngresada;
        } else {
            System.out.println("no cumple");
            return null;
        }
    }
    public String obtenerFechaActual() {
        // Obteniendo la fecha y hora actual utilizando Calendar
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();

        // Convirtiendo la fecha y hora actual a un objeto Timestamp
        Timestamp currentTimestamp = new Timestamp(currentDate.getTime());

        // Creando un objeto Date a partir del objeto Timestamp
        Date currentDateSQL = new Date(currentTimestamp.getTime());

        // Formateando la fecha y hora actual
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateFormat.format(currentDateSQL);

        return formattedDateTime;
    }
    public String obtenerFechaFormateada(Date fecha) {
        // Convirtiendo la fecha y hora actual a un objeto Timestamp
        Timestamp currentTimestamp = new Timestamp(fecha.getTime());

        // Creando un objeto Date a partir del objeto Timestamp
        Date currentDateSQL = new Date(currentTimestamp.getTime());

        // Formateando la fecha y hora actual
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateFormat.format(currentDateSQL);

        return formattedDateTime;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarContrato;
    private javax.swing.JButton btnGuardarPromesa;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbAccion;
    private javax.swing.JComboBox<String> cmbCanal;
    private javax.swing.JComboBox<String> cmbContacto;
    private javax.swing.JComboBox<String> cmbSelec;
    private javax.swing.JComboBox<String> cmbTipoMonto;
    private javax.swing.JComboBox<String> cmbTipoPromesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelAbajo;
    private javax.swing.JPanel panelBuscaContrato;
    private javax.swing.JPanel panelDerecha;
    private javax.swing.JPanel panelIzquierda;
    private javax.swing.JPanel panelMain;
    private javax.swing.JTextArea txtComentarios;
    private javax.swing.JTextField txtContrato;
    private com.toedter.calendar.JDateChooser txtFechaPromesa;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
/*
1 050 832 850/herasc/administrador
Equipo1.
HERASC\Administrador
Contraseña: X6cgtPdld75z14U8v2Ra
*/