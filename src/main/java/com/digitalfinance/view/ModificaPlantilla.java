/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.digitalfinance.view;

//import com.view.*;
import com.digitalfinance.DAO.entity.Plantilla;
import com.digitalfinance.DAO.model.ConsultarPlantilas;
import com.digitalfinance.controller.ControllerPantallas;
import com.opencsv.exceptions.CsvValidationException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class ModificaPlantilla extends javax.swing.JFrame {
    ControllerPantallas cp= new ControllerPantallas();
    Plantilla pl = new Plantilla();
    int aux;
    String agnt;
    public ModificaPlantilla(Plantilla plantilla,int i,String agente) {
        setIconImage(new ImageIcon(getClass().getResource("/LogoCobranzaExpress.png")).getImage());
        initComponents();
        this.agnt=agente;
        this.pl=plantilla;
        this.aux=i;
        txtPlantilla.setLineWrap(true);
        txtPlantilla.setWrapStyleWord(true);
        txtNombrePlantilla.setText(pl.getNombrePlantilla());
        txtPlantilla.setText(pl.getDescPlantilla());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombrePlantilla = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnExt30 = new javax.swing.JButton();
        btnAdeudoVariable = new javax.swing.JButton();
        btnCreditoVariable = new javax.swing.JButton();
        btnReferenciaSpei = new javax.swing.JButton();
        btnReferenciaOxxo = new javax.swing.JButton();
        btnFechaPago = new javax.swing.JButton();
        btnNombreVariable1 = new javax.swing.JButton();
        btnSaldoVariable1 = new javax.swing.JButton();
        btnExt20 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPlantilla = new javax.swing.JTextArea();
        btnGuardarPlantilla = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 109, 56));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre plantilla: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNombrePlantilla, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombrePlantilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, -1));

        btnExt30.setBackground(new java.awt.Color(155, 214, 47));
        btnExt30.setForeground(new java.awt.Color(255, 255, 255));
        btnExt30.setText("EXT 30");
        btnExt30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExt30ActionPerformed(evt);
            }
        });

        btnAdeudoVariable.setBackground(new java.awt.Color(155, 214, 47));
        btnAdeudoVariable.setForeground(new java.awt.Color(255, 255, 255));
        btnAdeudoVariable.setText("ADEUDO");
        btnAdeudoVariable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdeudoVariableActionPerformed(evt);
            }
        });

        btnCreditoVariable.setBackground(new java.awt.Color(155, 214, 47));
        btnCreditoVariable.setForeground(new java.awt.Color(255, 255, 255));
        btnCreditoVariable.setText("CREDITO");
        btnCreditoVariable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditoVariableActionPerformed(evt);
            }
        });

        btnReferenciaSpei.setBackground(new java.awt.Color(155, 214, 47));
        btnReferenciaSpei.setForeground(new java.awt.Color(255, 255, 255));
        btnReferenciaSpei.setText("SPEI");
        btnReferenciaSpei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReferenciaSpeiActionPerformed(evt);
            }
        });

        btnReferenciaOxxo.setBackground(new java.awt.Color(155, 214, 47));
        btnReferenciaOxxo.setForeground(new java.awt.Color(255, 255, 255));
        btnReferenciaOxxo.setText("OXXO");
        btnReferenciaOxxo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReferenciaOxxoActionPerformed(evt);
            }
        });

        btnFechaPago.setBackground(new java.awt.Color(155, 214, 47));
        btnFechaPago.setForeground(new java.awt.Color(255, 255, 255));
        btnFechaPago.setText("FECHA PAGO");
        btnFechaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechaPagoActionPerformed(evt);
            }
        });

        btnNombreVariable1.setBackground(new java.awt.Color(155, 214, 47));
        btnNombreVariable1.setForeground(new java.awt.Color(255, 255, 255));
        btnNombreVariable1.setText("NOMBRE CLIENTE");
        btnNombreVariable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNombreVariable1ActionPerformed(evt);
            }
        });

        btnSaldoVariable1.setBackground(new java.awt.Color(155, 214, 47));
        btnSaldoVariable1.setForeground(new java.awt.Color(255, 255, 255));
        btnSaldoVariable1.setText("SALDO");
        btnSaldoVariable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaldoVariable1ActionPerformed(evt);
            }
        });

        btnExt20.setBackground(new java.awt.Color(155, 214, 47));
        btnExt20.setForeground(new java.awt.Color(255, 255, 255));
        btnExt20.setText("EXT 20");
        btnExt20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExt20ActionPerformed(evt);
            }
        });

        txtPlantilla.setColumns(20);
        txtPlantilla.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        txtPlantilla.setRows(5);
        jScrollPane1.setViewportView(txtPlantilla);

        btnGuardarPlantilla.setBackground(new java.awt.Color(0, 109, 56));
        btnGuardarPlantilla.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btnGuardarPlantilla.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarPlantilla.setText("Modificar plantilla");
        btnGuardarPlantilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPlantillaActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(0, 109, 56));
        btnRegresar.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarPlantilla, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnNombreVariable1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(btnSaldoVariable1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(btnFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(btnExt20, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnCreditoVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(btnAdeudoVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(btnReferenciaSpei, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(btnReferenciaOxxo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnExt30, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNombreVariable1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaldoVariable1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExt20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreditoVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdeudoVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReferenciaSpei, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnReferenciaOxxo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExt30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarPlantilla)
                    .addComponent(btnRegresar))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 650, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarPlantillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPlantillaActionPerformed
        if(txtNombrePlantilla.getText().isEmpty() || txtPlantilla.getText().isEmpty()){
            if(txtNombrePlantilla.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Es necesario llenar el campo de Nombre de plantilla", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }else if(txtPlantilla.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingresar datos a la plantilla", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
        if(!txtNombrePlantilla.getText().isEmpty() && !txtPlantilla.getText().isEmpty()){
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
            // Verificar la respuesta
            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    ArrayList<Plantilla> listaPlantilla=ConsultarPlantilas.leerCSV();
                    Plantilla plantillaModificada=new Plantilla();
                    plantillaModificada.setNombrePlantilla(txtNombrePlantilla.getText());
                    plantillaModificada.setDescPlantilla(txtPlantilla.getText());
                    ConsultarPlantilas.modificarRegistro(listaPlantilla, aux, plantillaModificada);
                    this.dispose();
                    cp.AdministraPlantilla(agnt);
                } catch (CsvValidationException ex) {
                    System.err.println("Error "+ex);
                }
            }
        }
    }//GEN-LAST:event_btnGuardarPlantillaActionPerformed

    private void btnExt30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExt30ActionPerformed
        txtPlantilla.append(" $/EXT_30/ ");
    }//GEN-LAST:event_btnExt30ActionPerformed

    private void btnAdeudoVariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdeudoVariableActionPerformed
        txtPlantilla.append(" $/ADEUDO_VARIABLE/ ");
    }//GEN-LAST:event_btnAdeudoVariableActionPerformed

    private void btnCreditoVariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditoVariableActionPerformed
        txtPlantilla.append(" /CREDITO_VARIABLE/ ");
    }//GEN-LAST:event_btnCreditoVariableActionPerformed

    private void btnReferenciaSpeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReferenciaSpeiActionPerformed
        txtPlantilla.append(" /REF_SPEI/ ");
    }//GEN-LAST:event_btnReferenciaSpeiActionPerformed

    private void btnReferenciaOxxoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReferenciaOxxoActionPerformed
        txtPlantilla.append(" /REF_OXXO/ ");
    }//GEN-LAST:event_btnReferenciaOxxoActionPerformed

    private void btnFechaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechaPagoActionPerformed
        txtPlantilla.append(" /FECHA_PAGO/ ");
    }//GEN-LAST:event_btnFechaPagoActionPerformed

    private void btnNombreVariable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNombreVariable1ActionPerformed
        txtPlantilla.append(" /NOMBRE_VARIABLE/ ");
    }//GEN-LAST:event_btnNombreVariable1ActionPerformed

    private void btnSaldoVariable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaldoVariable1ActionPerformed
        txtPlantilla.append(" $/SALDO_VARIABLE/ ");
    }//GEN-LAST:event_btnSaldoVariable1ActionPerformed

    private void btnExt20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExt20ActionPerformed
        txtPlantilla.append(" $/EXT_20/ ");
    }//GEN-LAST:event_btnExt20ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        cp.AdministraPlantilla(agnt);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdeudoVariable;
    private javax.swing.JButton btnCreditoVariable;
    private javax.swing.JButton btnExt20;
    private javax.swing.JButton btnExt30;
    private javax.swing.JButton btnFechaPago;
    private javax.swing.JButton btnGuardarPlantilla;
    private javax.swing.JButton btnNombreVariable1;
    private javax.swing.JButton btnReferenciaOxxo;
    private javax.swing.JButton btnReferenciaSpei;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSaldoVariable1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNombrePlantilla;
    private javax.swing.JTextArea txtPlantilla;
    // End of variables declaration//GEN-END:variables
}
