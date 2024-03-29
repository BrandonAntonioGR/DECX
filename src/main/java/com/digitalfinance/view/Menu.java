/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.digitalfinance.view;

import com.digitalfinance.controller.ControllerPantallas;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Menu extends javax.swing.JFrame {
    ControllerPantallas cp =new ControllerPantallas();
    String agente;
    public Menu(String agnt) {
        setIconImage(new ImageIcon(getClass().getResource("/LogoCobranzaExpress.png")).getImage());
        initComponents();
        this.agente=agnt;
        txtMisPlantillas.setHorizontalAlignment(SwingConstants.CENTER);
        txtBuscaContrato.setHorizontalAlignment(SwingConstants.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelMisPlantillas = new javax.swing.JPanel();
        txtMisPlantillas = new javax.swing.JLabel();
        panelBuscaContrato = new javax.swing.JPanel();
        txtBuscaContrato = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMisPlantillas.setBackground(new java.awt.Color(0, 109, 56));
        panelMisPlantillas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelMisPlantillas.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));

        txtMisPlantillas.setBackground(new java.awt.Color(0, 109, 56));
        txtMisPlantillas.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        txtMisPlantillas.setForeground(new java.awt.Color(255, 255, 255));
        txtMisPlantillas.setText("Mis plantillas");
        txtMisPlantillas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtMisPlantillas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtMisPlantillas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMisPlantillasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtMisPlantillasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtMisPlantillasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelMisPlantillasLayout = new javax.swing.GroupLayout(panelMisPlantillas);
        panelMisPlantillas.setLayout(panelMisPlantillasLayout);
        panelMisPlantillasLayout.setHorizontalGroup(
            panelMisPlantillasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMisPlantillas, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );
        panelMisPlantillasLayout.setVerticalGroup(
            panelMisPlantillasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMisPlantillas, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel1.add(panelMisPlantillas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 250, 50));

        panelBuscaContrato.setBackground(new java.awt.Color(0, 109, 56));
        panelBuscaContrato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBuscaContrato.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));

        txtBuscaContrato.setBackground(new java.awt.Color(0, 109, 56));
        txtBuscaContrato.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        txtBuscaContrato.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscaContrato.setText("Buscar contrato");
        txtBuscaContrato.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtBuscaContrato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtBuscaContrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscaContratoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtBuscaContratoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtBuscaContratoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelBuscaContratoLayout = new javax.swing.GroupLayout(panelBuscaContrato);
        panelBuscaContrato.setLayout(panelBuscaContratoLayout);
        panelBuscaContratoLayout.setHorizontalGroup(
            panelBuscaContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtBuscaContrato, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );
        panelBuscaContratoLayout.setVerticalGroup(
            panelBuscaContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtBuscaContrato, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel1.add(panelBuscaContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 250, 50));

        jLabel1.setBackground(new java.awt.Color(0, 109, 56));
        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 109, 56));
        jLabel1.setText("Menú");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, 20));

        jSeparator1.setForeground(new java.awt.Color(0, 109, 56));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 196, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMisPlantillasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMisPlantillasMouseClicked
        cp.AdministraPlantilla(agente);
        this.dispose();
    }//GEN-LAST:event_txtMisPlantillasMouseClicked

    private void txtBuscaContratoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscaContratoMouseClicked
        abrirMacro();
//        try {
//            cp.Macro(agente);
//        } catch (SQLException ex) {
//            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
//        }
        this.dispose();
    }//GEN-LAST:event_txtBuscaContratoMouseClicked
    private void abrirMacro() {
        // Mostrar mensaje de carga en un hilo aparte
        final JDialog loadingDialog = new JDialog(this, "Cargando Macro", true);
        SwingUtilities.invokeLater(() -> {
            loadingDialog.setSize(200, 100);
            loadingDialog.setLocationRelativeTo(this);
            //loadingDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            JLabel loadingLabel = new JLabel("Cargando...");
            loadingLabel.setHorizontalAlignment(JLabel.CENTER);
            loadingDialog.add(loadingLabel);

            loadingDialog.setVisible(true);
        });

        // Simulando la carga del JFrame "macro" en un hilo aparte
        new Thread(() -> {
            ViewMacro macroFrame;
            try {
                macroFrame = new ViewMacro(agente);
                // Mostrar el JFrame "macro" después de la carga
            SwingUtilities.invokeLater(() -> {
                loadingDialog.dispose();
                macroFrame.setVisible(true);
                macroFrame.setResizable(false);
                macroFrame.setLocationRelativeTo(null);
            });
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }


        }).start();
    }
    private void txtMisPlantillasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMisPlantillasMouseEntered
        panelMisPlantillas.setBackground(new Color(163,205,58));
        txtMisPlantillas.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_txtMisPlantillasMouseEntered

    private void txtMisPlantillasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMisPlantillasMouseExited
        panelMisPlantillas.setBackground(new Color(0,109,56));
        txtMisPlantillas.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_txtMisPlantillasMouseExited

    private void txtBuscaContratoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscaContratoMouseEntered
        panelBuscaContrato.setBackground(new Color(163,205,58));
        txtBuscaContrato.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_txtBuscaContratoMouseEntered

    private void txtBuscaContratoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscaContratoMouseExited
        panelBuscaContrato.setBackground(new Color(0,109,56));
        txtBuscaContrato.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_txtBuscaContratoMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelBuscaContrato;
    private javax.swing.JPanel panelMisPlantillas;
    private javax.swing.JLabel txtBuscaContrato;
    private javax.swing.JLabel txtMisPlantillas;
    // End of variables declaration//GEN-END:variables
}
