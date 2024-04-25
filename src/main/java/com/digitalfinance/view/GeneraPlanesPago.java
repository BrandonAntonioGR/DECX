/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.digitalfinance.view;

import com.digitalfinance.DAO.entity.Macro;
import com.digitalfinance.DAO.entity.PlanesPago;
import com.digitalfinance.DAO.model.ConsultarPlantilas;
import com.digitalfinance.controller.ControllerGeneraPlanesPago;
import com.digitalfinance.controller.ControllerInsertarPlanesPago;
import com.digitalfinance.controller.ControllerInsertarPromesaPago;
import java.awt.Color;
import java.awt.Font;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GeneraPlanesPago extends javax.swing.JFrame {

    ControllerInsertarPlanesPago insertaPlanPago = new ControllerInsertarPlanesPago();
    ControllerInsertarPromesaPago cargarPromesaPago = new ControllerInsertarPromesaPago();
    ControllerGeneraPlanesPago consultaPromesa = new ControllerGeneraPlanesPago();
    ConsultarPlantilas consultarPlantillas = new ConsultarPlantilas();
    DefaultTableModel modeloSimulacionPagos = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    ArrayList<PlanesPago> listaPlanesPago = new ArrayList<>();
    int[] dias = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
        21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    int[] semanal = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    int[] quincenal = {1, 2, 3, 4, 5, 6};
    int[] mes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    int[] porcentaje = {40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50};
    boolean contratoEncontrado = false;

    int adeudo = 0;
    int saldoHoy = 0;
    int ext10 = 0;
    int ext20 = 0;
    int ext30 = 0;
    double capitalDouble;
    String agnt;
    Date fechaPago;
    String contrato;
    String nombre;
    String dpd;
    String algoritmo;

    Date promiseDate;
    Date promiseLimitDate;
    Date fechaInicioPlanPagos;

    double pagoIntencion;
    double restante;

    public GeneraPlanesPago(String agente) {
        initComponents();
        this.agnt = agente;
        cmbProcentaje.removeAllItems();
        for (int i = 0; i < porcentaje.length; i++) {
            cmbProcentaje.addItem(porcentaje[i] + "");
        }
    }

    public void estilosTabla() {
        tblSimulacionPagos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblSimulacionPagos.getTableHeader().setOpaque(false);
        tblSimulacionPagos.getTableHeader().setBackground(new Color(102, 0, 102));
        tblSimulacionPagos.getTableHeader().setForeground(new Color(255, 255, 255));
    }

    public void limpiarTabla(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnCount(0); // Eliminar todas las columnas
        model.setRowCount(0);    // Eliminar todas las filas
    }

    public void llenarTablaPlanesPago() {
        ArrayList<Object> nombreColumnas = new ArrayList<>();
        nombreColumnas.add("FECHA");
        nombreColumnas.add("MONTO");
        for (Object columnas : nombreColumnas) {
            modeloSimulacionPagos.addColumn(columnas);
        }
        this.tblSimulacionPagos.setModel(modeloSimulacionPagos);
        modeloSimulacionPagos = (DefaultTableModel) tblSimulacionPagos.getModel();

        ArrayList<Date> listaFechas = obtenerListaFechas();
        int opcPlazos = Integer.parseInt(cmbPlazos.getSelectedItem().toString());
        System.out.println("combo lapsos: " + opcPlazos);
        Object[] ob = new Object[2];
        // Crear un formato para la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //Se llenan los elementos de la tabla y se setea la listaPlanesPago
        String frecuencia = cmbFrecuencia.getSelectedItem().toString();
        int plazos = Integer.parseInt(cmbPlazos.getSelectedItem().toString());
        String tipoMonto = "";
        listaPlanesPago.clear();
        for (int i = 0; i < opcPlazos + 1; i++) {
            PlanesPago planPago = new PlanesPago();
            planPago.setContrato(contrato);
            planPago.setDpd(dpd);
            planPago.setAlgoritmo(algoritmo);
            planPago.setAgente(agnt);
            planPago.setAdeudo(adeudo + "");
            planPago.setFecuencia(frecuencia);
            planPago.setPlazos(plazos);
            planPago.setStatusPlan("VIGENTE");

            planPago.setCreationDay(obtenerFechaActual());
            if (i == 0) {
                ob[0] = sdf.format(promiseDate);
                ob[1] = pagoIntencion;
                modeloSimulacionPagos.addRow(ob);
                tipoMonto = "PAGO DE INTENCION";
                planPago.setTipoMonto(tipoMonto);
                planPago.setMontoPlan(pagoIntencion + "");
                planPago.setFechaPagoPlan(sdf.format(promiseDate));
            } else {
                ob[0] = sdf.format(listaFechas.get(i - 1));
                ob[1] = Math.round(obtenerExibicionesPagos());
                modeloSimulacionPagos.addRow(ob);
                tipoMonto = "EXIBICION";
                planPago.setTipoMonto(tipoMonto);
                planPago.setMontoPlan(Math.round(obtenerExibicionesPagos()) + "");
                planPago.setFechaPagoPlan(sdf.format(listaFechas.get(i - 1)));
            }
            listaPlanesPago.add(planPago);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelMain = new javax.swing.JPanel();
        panelDerecha = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cmbFrecuencia = new javax.swing.JComboBox<>();
        cmbPlazos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtFechaPagoIntencion = new com.toedter.calendar.JDateChooser();
        cmbProcentaje = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtFechaInicioPlanPago = new com.toedter.calendar.JDateChooser();
        panelIzquierda = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtAdeudo = new javax.swing.JTextField();
        txtPagoIntencion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnGeneraSimulacion = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnGuardarPlanPago = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSimulacionPagos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        panelBuscaContrato = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtContrato = new javax.swing.JTextField();
        btnBuscarContrato = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel12.setText("Plazos:");

        cmbFrecuencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diaria", "Semanal", "Quincenal", "Mensual" }));
        cmbFrecuencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFrecuenciaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel5.setText("Frecuencia:");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel2.setText("Porcentaje:");

        jLabel15.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel15.setText("Pago intencion:");

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel13.setText("%");

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel16.setText("Inicio Plan pago:");

        javax.swing.GroupLayout panelDerechaLayout = new javax.swing.GroupLayout(panelDerecha);
        panelDerecha.setLayout(panelDerechaLayout);
        panelDerechaLayout.setHorizontalGroup(
            panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDerechaLayout.createSequentialGroup()
                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDerechaLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaInicioPlanPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFechaPagoIntencion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelDerechaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(jLabel2))
                            .addGroup(panelDerechaLayout.createSequentialGroup()
                                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15))
                                .addGap(1, 1, 1)))
                        .addGap(18, 18, 18)
                        .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDerechaLayout.createSequentialGroup()
                                .addComponent(cmbFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cmbPlazos, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelDerechaLayout.createSequentialGroup()
                                .addComponent(cmbProcentaje, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)))))
                .addGap(22, 22, 22))
        );
        panelDerechaLayout.setVerticalGroup(
            panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDerechaLayout.createSequentialGroup()
                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPlazos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbProcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(txtFechaPagoIntencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(panelDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(txtFechaInicioPlanPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel6.setText("Cliente: ");

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel8.setText("Adeudo:");

        txtCliente.setEditable(false);

        txtAdeudo.setEditable(false);

        txtPagoIntencion.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel11.setText("Pago intencion:");

        btnGeneraSimulacion.setBackground(new java.awt.Color(0, 109, 56));
        btnGeneraSimulacion.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnGeneraSimulacion.setForeground(new java.awt.Color(255, 255, 255));
        btnGeneraSimulacion.setText("Generar simulacion");
        btnGeneraSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneraSimulacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelIzquierdaLayout = new javax.swing.GroupLayout(panelIzquierda);
        panelIzquierda.setLayout(panelIzquierdaLayout);
        panelIzquierdaLayout.setHorizontalGroup(
            panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIzquierdaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGeneraSimulacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelIzquierdaLayout.createSequentialGroup()
                        .addGroup(panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelIzquierdaLayout.createSequentialGroup()
                                .addGroup(panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelIzquierdaLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPagoIntencion, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIzquierdaLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txtAdeudo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelIzquierdaLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelIzquierdaLayout.setVerticalGroup(
            panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIzquierdaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtAdeudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtPagoIntencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGeneraSimulacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel9.setText("Plazos:");

        btnGuardarPlanPago.setBackground(new java.awt.Color(0, 109, 56));
        btnGuardarPlanPago.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnGuardarPlanPago.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarPlanPago.setText("Guardar");
        btnGuardarPlanPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPlanPagoActionPerformed(evt);
            }
        });

        tblSimulacionPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Fecha", "Monto"
            }
        ));
        jScrollPane1.setViewportView(tblSimulacionPagos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarPlanPago)
                        .addGap(27, 27, 27))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardarPlanPago)
                        .addGap(31, 31, 31))))
        );

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(panelDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelIzquierda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel2.setBackground(new java.awt.Color(0, 109, 56));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Generación de planes de pago");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 7, -1, -1));

        btnRegresar.setBackground(new java.awt.Color(0, 109, 56));
        btnRegresar.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 98, 32));

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
            .addGroup(panelBuscaContratoLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarContrato)
                .addContainerGap(106, Short.MAX_VALUE))
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
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBuscaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBuscaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        String openprincipals = macro.getOpen_principal();
        if (adeudos != null && saldoHoys != null && openprincipals != null && ext20s != null && ext30s != null) {
            capitalDouble = Double.parseDouble(openprincipals);
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
            txtAdeudo.setText(adeudo + "");////////////////////////////////////////ADEUDO
            
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
            fechaPago = macro.getFechaPago();
            contrato = macro.getNumber();
            nombre = macro.getNombre();
            txtCliente.setText(nombre);
            algoritmo = macro.getAlgoritmo();
            JOptionPane.showMessageDialog(null, "Plan de pago disponible continue llenando el formulario", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Plan depago con promesa o DPD menor a 0", "Advertencia", JOptionPane.ERROR_MESSAGE);
            contratoEncontrado = false;
        }
    }//GEN-LAST:event_btnBuscarContratoActionPerformed

    private void cmbFrecuenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFrecuenciaActionPerformed
        String opcFrecuencia = (String) cmbFrecuencia.getSelectedItem();
        switch (opcFrecuencia) {
            case "Diaria":
                cmbPlazos.removeAllItems();
                for (int i = 0; i < dias.length; i++) {
                    cmbPlazos.addItem(dias[i] + "");
                }
                break;
            case "Semanal":
                cmbPlazos.removeAllItems();
                for (int i = 0; i < semanal.length; i++) {
                    cmbPlazos.addItem(semanal[i] + "");
                }
                break;
            case "Quincenal":
                cmbPlazos.removeAllItems();
                for (int i = 0; i < quincenal.length; i++) {
                    cmbPlazos.addItem(quincenal[i] + "");
                }
                break;
            case "Mensual":
                cmbPlazos.removeAllItems();
                for (int i = 0; i < mes.length; i++) {
                    cmbPlazos.addItem(mes[i] + "");
                }
                break;
        }
    }//GEN-LAST:event_cmbFrecuenciaActionPerformed
 // Método para convertir un java.util.Date a java.time.LocalDate
    public static LocalDate convertirADateLocal(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    private void btnGeneraSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneraSimulacionActionPerformed
        promiseDate = txtFechaPagoIntencion.getDate();
        fechaInicioPlanPagos = txtFechaInicioPlanPago.getDate();

        if (promiseDate == null || fechaInicioPlanPagos == null) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha valida formato:dd/MM/yyyy", "Advertencia", JOptionPane.ERROR_MESSAGE);
        } else {
            if (validarFecha(promiseDate) == false) {
                JOptionPane.showMessageDialog(null, "No es posible ingresar dias anteriores ", "Advertencia", JOptionPane.ERROR_MESSAGE);
            } else {
                if (validarFecha(fechaInicioPlanPagos) == false) {
                    JOptionPane.showMessageDialog(null, "No es posible ingresar dias anteriores ", "Advertencia", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Convertir las fechas de java.util.Date a java.time.LocalDate
                    LocalDate fechaInicio = LocalDate.now();
                    LocalDate fechaFin = convertirADateLocal(promiseDate);

                    long diferenciaEnDias = fechaFin.toEpochDay() - fechaInicio.toEpochDay();
//                    diferenciaEnDias=diferenciaEnDias+1;
                    // Imprimir el resultado
                    double moratoriosExtra=diferenciaEnDias*capitalDouble*0.0232;
                    System.out.println("Capital "+capitalDouble);
                    System.out.println("Diferencia en dias: "+diferenciaEnDias);
                    System.out.println("moratorios Extra "+moratoriosExtra);
                    System.out.println("adeudo: "+adeudo);
                    promiseLimitDate = ObtenerdiaMaximo();
                    String porcentajeS = cmbProcentaje.getSelectedItem().toString();
                    int porcentaje = Integer.parseInt(porcentajeS);
                    pagoIntencion = Math.round((porcentaje * (adeudo+moratoriosExtra)) / 100);
                    System.out.println("pagoIntencion: "+pagoIntencion);
                    if (pagoIntencion == ext10 || pagoIntencion == ext20 || pagoIntencion == ext30) {
                        JOptionPane.showMessageDialog(null, "Seleccione otro porcentaje ya que coincide con una extencion", "Advertencia", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txtPagoIntencion.setText(pagoIntencion + "");
                        restante = (adeudo+moratoriosExtra) - pagoIntencion;
                        limpiarTabla(tblSimulacionPagos);
                        llenarTablaPlanesPago();
                        estilosTabla();
                    }
                }
            }
        }

    }//GEN-LAST:event_btnGeneraSimulacionActionPerformed
    public double obtenerExibicionesPagos() {
        int opcPlazos = Integer.parseInt(cmbPlazos.getSelectedItem().toString());
        double exibicionesPagos = restante / opcPlazos;
        return exibicionesPagos;
    }

    public ArrayList<Date> obtenerListaFechas() {
        String opcFrecuencia = (String) cmbFrecuencia.getSelectedItem();
        int opcPlazos = Integer.parseInt(cmbPlazos.getSelectedItem().toString());
        ArrayList<Date> listaFechas = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        Date fechaHoy = fechaInicioPlanPagos;
        Date fechaAuxiliar;
        Date fechaPlus;
        switch (opcFrecuencia) {
            case "Diaria":
                listaFechas.add(fechaInicioPlanPagos);
                for (int i = 0; i < opcPlazos - 1; i++) {
                    calendar.setTimeInMillis(fechaHoy.getTime());
                    calendar.add(Calendar.DAY_OF_YEAR, 1);
                    fechaPlus = calendar.getTime();
                    fechaHoy = fechaPlus;
                    listaFechas.add(fechaPlus);
                }
                break;
            case "Semanal":
                listaFechas.add(fechaInicioPlanPagos);
                for (int i = 0; i < opcPlazos - 1; i++) {
                    calendar.setTimeInMillis(fechaHoy.getTime());
                    calendar.add(Calendar.WEEK_OF_YEAR, 1);
                    fechaPlus = calendar.getTime();
                    fechaHoy = fechaPlus;
                    listaFechas.add(fechaPlus);
                }
                break;
            case "Quincenal":
                listaFechas.add(fechaInicioPlanPagos);
                for (int i = 0; i < opcPlazos - 1; i++) {
                    calendar.setTimeInMillis(fechaHoy.getTime());
                    calendar.add(Calendar.DAY_OF_YEAR, 14);
                    fechaPlus = calendar.getTime();
                    fechaHoy = fechaPlus;
                    listaFechas.add(fechaPlus);
                }
                break;
            case "Mensual":
                listaFechas.add(fechaInicioPlanPagos);
                for (int i = 0; i < opcPlazos - 1; i++) {
                    calendar.setTimeInMillis(fechaHoy.getTime());
                    calendar.add(Calendar.MONTH, 1);
                    fechaPlus = calendar.getTime();
                    fechaHoy = fechaPlus;
                    listaFechas.add(fechaPlus);
                }
                break;
        }
        return listaFechas;
    }
    private void btnGuardarPlanPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPlanPagoActionPerformed
        if (listaPlanesPago.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Primero Genere una simulacion para guardar los datos", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (PlanesPago planesPago : listaPlanesPago) {
                System.out.println("listaPlanesPago.size(): " + listaPlanesPago.size());
                System.out.println("contrato: " + planesPago.getContrato());
                System.out.println("dpd: " + planesPago.getDpd());
                System.out.println("algoritmo: " + planesPago.getAlgoritmo());
                System.out.println("agente: " + planesPago.getAgente());
                System.out.println("adeudo: " + planesPago.getAdeudo());
                System.out.println("ferecuencia: " + planesPago.getFecuencia());
                System.out.println("plazos: " + planesPago.getPlazos());
                System.out.println("tipomonto: " + planesPago.getTipoMonto());
                System.out.println("fecha: " + planesPago.getFechaPagoPlan());
                System.out.println("status: " + planesPago.getStatusPlan());
                System.out.println("creation: " + planesPago.getCreationDay());
                System.out.println("***************************************");
            }
            insertaPlanPago.CargarPlanPago(listaPlanesPago);
            this.dispose();
        }
    }//GEN-LAST:event_btnGuardarPlanPagoActionPerformed
    public String modificarCoincidencias(String patronNombreVariable, String descPlantilla, String OBJETONOMBRE) {
        Pattern patternNombreVariable = Pattern.compile(patronNombreVariable);
        Matcher similitudNombreVariable = patternNombreVariable.matcher(descPlantilla);
        String textoNuevo1 = similitudNombreVariable.replaceAll(OBJETONOMBRE);
        return textoNuevo1;
    }

    public boolean validarFecha(Date fechaIngresada) {
        // Obtener la fecha de ayer
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date fechaAyer = calendar.getTime();

        // Comparar las fechas
        if (fechaIngresada.after(fechaAyer)) {
            System.out.println("okey");
            return true;
        } else {
            System.out.println("no cumple");
            return false;
        }
    }

    public Date ObtenerdiaMaximo() {
        // Obtener la fecha de ayer
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        Date fechaAyer = calendar.getTime();
//        System.out.println("dia maximo " + fechaAyer);
        return fechaAyer;
    }

    public static Date obtenerFechaActualaSQL() {
        // Obtener la fecha actual en milisegundos
        long millis = System.currentTimeMillis();

        // Crear un objeto java.sql.Date utilizando la fecha actual en milisegundos
        Date fechaActual = new Date(millis);

        return fechaActual;
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

    public void limpiarDatos() {
        contratoEncontrado = false;
        adeudo = 0;
        saldoHoy = 0;
        ext10 = 0;
        ext20 = 0;
        ext30 = 0;
        contrato = "";
        nombre = "";
        dpd = "";
        algoritmo = "";
        txtContrato.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarContrato;
    private javax.swing.JButton btnGeneraSimulacion;
    private javax.swing.JButton btnGuardarPlanPago;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbFrecuencia;
    private javax.swing.JComboBox<String> cmbPlazos;
    private javax.swing.JComboBox<String> cmbProcentaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBuscaContrato;
    private javax.swing.JPanel panelDerecha;
    private javax.swing.JPanel panelIzquierda;
    private javax.swing.JPanel panelMain;
    private javax.swing.JTable tblSimulacionPagos;
    private javax.swing.JTextField txtAdeudo;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtContrato;
    private com.toedter.calendar.JDateChooser txtFechaInicioPlanPago;
    private com.toedter.calendar.JDateChooser txtFechaPagoIntencion;
    private javax.swing.JTextField txtPagoIntencion;
    // End of variables declaration//GEN-END:variables
}
/*
1 050 832 850/herasc/administrador
Equipo1.
HERASC\Administrador
Contraseña: X6cgtPdld75z14U8v2Ra
 */
