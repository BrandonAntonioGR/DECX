/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.digitalfinance.view;

import com.digitalfinance.DAO.entity.Plantilla;
import com.digitalfinance.DAO.model.ConsultarPlantilas;
import com.digitalfinance.controller.ControllerPantallas;
import com.opencsv.exceptions.CsvValidationException;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


public class AdminPlantillas extends javax.swing.JFrame {
    ControllerPantallas cp= new ControllerPantallas();
    DefaultTableModel modelo=new DefaultTableModel(){
         @Override
         public boolean isCellEditable(int row,int column){
             return false;
         }
    };
    String agente;

    public AdminPlantillas(String agnt) {
        setIconImage(new ImageIcon(getClass().getResource("/LogoCobranzaExpress.png")).getImage());
        initComponents();
        this.agente=agnt;
        //centra el texto de los txtlabel
        txtExaminarPlantilla.setHorizontalAlignment(SwingConstants.CENTER);
        txtAgregarPlantilla.setHorizontalAlignment(SwingConstants.CENTER);
        txtModificarPlantilla.setHorizontalAlignment(SwingConstants.CENTER);
        txtEliminarPlantilla.setHorizontalAlignment(SwingConstants.CENTER);
        txtRegresar.setHorizontalAlignment(SwingConstants.CENTER);
        //modifica estilo de tabla
        tblPlantilla.getTableHeader().setFont (new Font("Segoe UI", Font. BOLD, 14));
        tblPlantilla.getTableHeader().setOpaque (false);
        tblPlantilla.getTableHeader().setBackground (new Color (0,109,56));
        tblPlantilla.getTableHeader().setForeground (new Color(255,255,255));
        try {
             llenarTabla();
        } catch (CsvValidationException ex) {
             System.err.println("Error" + ex);
        }
        tblPlantilla.getColumnModel().getColumn(0).setMaxWidth(0);
        tblPlantilla.getColumnModel().getColumn(0).setMinWidth(0);
        tblPlantilla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblPlantilla.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        //this.frame=jf;
    }

    public void llenarTabla()throws CsvValidationException{
        ArrayList<Object> nombreColumnas=new ArrayList<>();
        nombreColumnas.add("ID");
        nombreColumnas.add("Nombre plantilla");
        nombreColumnas.add("Descripcion ");
        for(Object columnas: nombreColumnas){
            modelo.addColumn(columnas);
        }
        this.tblPlantilla.setModel(modelo);
        ArrayList<Plantilla> pl=ConsultarPlantilas.leerCSV();
        
        modelo=(DefaultTableModel)tblPlantilla.getModel();
        Object[] ob=new Object[3];
        for(int i=0;i<pl.size();i++){
            Plantilla plantilla=pl.get(i);
            ob[0]=plantilla.getIndicePlantilla();
            ob[1]=plantilla.getNombrePlantilla();
            ob[2]=plantilla.getDescPlantilla();
            modelo.addRow(ob);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelExaminar = new javax.swing.JPanel();
        txtExaminarPlantilla = new javax.swing.JLabel();
        panelAgregar = new javax.swing.JPanel();
        txtAgregarPlantilla = new javax.swing.JLabel();
        panelModificar = new javax.swing.JPanel();
        txtModificarPlantilla = new javax.swing.JLabel();
        panelEliminar = new javax.swing.JPanel();
        txtEliminarPlantilla = new javax.swing.JLabel();
        panelRegresar = new javax.swing.JPanel();
        txtRegresar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlantilla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 109, 56));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 64, 55));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrar plantillas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 196, 10));

        panelExaminar.setBackground(new java.awt.Color(0, 109, 56));
        panelExaminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelExaminar.setForeground(new java.awt.Color(255, 255, 255));

        txtExaminarPlantilla.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        txtExaminarPlantilla.setForeground(new java.awt.Color(255, 255, 255));
        txtExaminarPlantilla.setText("Examinar plantilla");
        txtExaminarPlantilla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtExaminarPlantilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtExaminarPlantillaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtExaminarPlantillaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtExaminarPlantillaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelExaminarLayout = new javax.swing.GroupLayout(panelExaminar);
        panelExaminar.setLayout(panelExaminarLayout);
        panelExaminarLayout.setHorizontalGroup(
            panelExaminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtExaminarPlantilla, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );
        panelExaminarLayout.setVerticalGroup(
            panelExaminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtExaminarPlantilla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        jPanel1.add(panelExaminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 300, 60));

        panelAgregar.setBackground(new java.awt.Color(0, 109, 56));
        panelAgregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelAgregar.setForeground(new java.awt.Color(255, 255, 255));

        txtAgregarPlantilla.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        txtAgregarPlantilla.setForeground(new java.awt.Color(255, 255, 255));
        txtAgregarPlantilla.setText("Agregar");
        txtAgregarPlantilla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtAgregarPlantilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAgregarPlantillaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtAgregarPlantillaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtAgregarPlantillaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelAgregarLayout = new javax.swing.GroupLayout(panelAgregar);
        panelAgregar.setLayout(panelAgregarLayout);
        panelAgregarLayout.setHorizontalGroup(
            panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtAgregarPlantilla, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );
        panelAgregarLayout.setVerticalGroup(
            panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtAgregarPlantilla, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        jPanel1.add(panelAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 300, 60));

        panelModificar.setBackground(new java.awt.Color(0, 109, 56));
        panelModificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelModificar.setForeground(new java.awt.Color(255, 255, 255));

        txtModificarPlantilla.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        txtModificarPlantilla.setForeground(new java.awt.Color(255, 255, 255));
        txtModificarPlantilla.setText("Modificar");
        txtModificarPlantilla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtModificarPlantilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtModificarPlantillaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtModificarPlantillaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtModificarPlantillaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelModificarLayout = new javax.swing.GroupLayout(panelModificar);
        panelModificar.setLayout(panelModificarLayout);
        panelModificarLayout.setHorizontalGroup(
            panelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtModificarPlantilla, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );
        panelModificarLayout.setVerticalGroup(
            panelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtModificarPlantilla, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        jPanel1.add(panelModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 300, 60));

        panelEliminar.setBackground(new java.awt.Color(0, 109, 56));
        panelEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelEliminar.setForeground(new java.awt.Color(255, 255, 255));

        txtEliminarPlantilla.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        txtEliminarPlantilla.setForeground(new java.awt.Color(255, 255, 255));
        txtEliminarPlantilla.setText("Eliminar");
        txtEliminarPlantilla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtEliminarPlantilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEliminarPlantillaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtEliminarPlantillaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtEliminarPlantillaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelEliminarLayout = new javax.swing.GroupLayout(panelEliminar);
        panelEliminar.setLayout(panelEliminarLayout);
        panelEliminarLayout.setHorizontalGroup(
            panelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEliminarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtEliminarPlantilla, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelEliminarLayout.setVerticalGroup(
            panelEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEliminarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtEliminarPlantilla, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(panelEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 300, 60));

        panelRegresar.setBackground(new java.awt.Color(0, 109, 56));
        panelRegresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelRegresar.setForeground(new java.awt.Color(255, 255, 255));

        txtRegresar.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        txtRegresar.setForeground(new java.awt.Color(255, 255, 255));
        txtRegresar.setText("Regresar");
        txtRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRegresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtRegresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtRegresarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRegresarLayout = new javax.swing.GroupLayout(panelRegresar);
        panelRegresar.setLayout(panelRegresarLayout);
        panelRegresarLayout.setHorizontalGroup(
            panelRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegresarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRegresarLayout.setVerticalGroup(
            panelRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegresarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(panelRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 300, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 420));

        tblPlantilla.setSelectionBackground(new java.awt.Color(155, 214, 47));
        tblPlantilla.setSelectionForeground(new java.awt.Color(0, 109, 56));
        jScrollPane1.setViewportView(tblPlantilla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 400, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtExaminarPlantillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExaminarPlantillaMouseClicked
        int fila = tblPlantilla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro para Examinar");
        } else {
            int id = Integer.parseInt(tblPlantilla.getValueAt(fila, 0).toString());
            try {
                ArrayList<Plantilla> listaPlantilla=ConsultarPlantilas.leerCSV();
                Plantilla pl=listaPlantilla.get(id);
                cp.ExaminaPlantilla(pl,agente);
            } catch (CsvValidationException ex) {
                System.err.println("Error "+ex);
            }

        }
    }//GEN-LAST:event_txtExaminarPlantillaMouseClicked

    private void txtExaminarPlantillaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExaminarPlantillaMouseEntered
        panelExaminar.setBackground(new Color(155,214,47));
    }//GEN-LAST:event_txtExaminarPlantillaMouseEntered

    private void txtExaminarPlantillaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExaminarPlantillaMouseExited
        panelExaminar.setBackground(new Color(0,109,56));
    }//GEN-LAST:event_txtExaminarPlantillaMouseExited

    private void txtAgregarPlantillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAgregarPlantillaMouseClicked
        cp.AgregaPlantilla(agente);
        this.dispose();
    }//GEN-LAST:event_txtAgregarPlantillaMouseClicked

    private void txtAgregarPlantillaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAgregarPlantillaMouseEntered
        panelAgregar.setBackground(new Color(155,214,47));
    }//GEN-LAST:event_txtAgregarPlantillaMouseEntered

    private void txtAgregarPlantillaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAgregarPlantillaMouseExited
        panelAgregar.setBackground(new Color(0,109,56));
    }//GEN-LAST:event_txtAgregarPlantillaMouseExited

    private void txtModificarPlantillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarPlantillaMouseClicked
        int fila = tblPlantilla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro para modificar");
        } else {
            int id = Integer.parseInt(tblPlantilla.getValueAt(fila, 0).toString());
            try {
                ArrayList<Plantilla> listaPlantilla=ConsultarPlantilas.leerCSV();
                Plantilla pl=listaPlantilla.get(id);
                this.dispose();
                cp.ModificaPlantilla(pl,id,agente);

            } catch (CsvValidationException ex) {
                System.err.println("Error "+ex);
            }
        }
    }//GEN-LAST:event_txtModificarPlantillaMouseClicked

    private void txtModificarPlantillaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarPlantillaMouseEntered
        panelModificar.setBackground(new Color(155,214,47));
    }//GEN-LAST:event_txtModificarPlantillaMouseEntered

    private void txtModificarPlantillaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarPlantillaMouseExited
        panelModificar.setBackground(new Color(0,109,56));
    }//GEN-LAST:event_txtModificarPlantillaMouseExited

    private void txtRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRegresarMouseClicked
        cp.Menu(agente);
        this.dispose();
    }//GEN-LAST:event_txtRegresarMouseClicked

    private void txtRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRegresarMouseEntered
        panelRegresar.setBackground(new Color(155,214,47));
    }//GEN-LAST:event_txtRegresarMouseEntered

    private void txtRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRegresarMouseExited
        panelRegresar.setBackground(new Color(0,109,56));
    }//GEN-LAST:event_txtRegresarMouseExited

    private void txtEliminarPlantillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEliminarPlantillaMouseClicked
        int fila = tblPlantilla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro para eliminar");
        } else {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
            // Verificar la respuesta
            if (respuesta == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(tblPlantilla.getValueAt(fila, 0).toString());
                try {
                    ArrayList<Plantilla> listaPlantilla=ConsultarPlantilas.leerCSV();
                    ConsultarPlantilas.eliminarRegistro(listaPlantilla, id);
                    this.dispose();
                    cp.AdministraPlantilla(agente);
                } catch (CsvValidationException ex){
                    System.err.println("Error "+ex);
                }
            }
        }
    }//GEN-LAST:event_txtEliminarPlantillaMouseClicked

    private void txtEliminarPlantillaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEliminarPlantillaMouseEntered
        panelEliminar.setBackground(new Color(155,214,47));
    }//GEN-LAST:event_txtEliminarPlantillaMouseEntered

    private void txtEliminarPlantillaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEliminarPlantillaMouseExited
        panelEliminar.setBackground(new Color(0,109,56));
    }//GEN-LAST:event_txtEliminarPlantillaMouseExited

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelAgregar;
    private javax.swing.JPanel panelEliminar;
    private javax.swing.JPanel panelExaminar;
    private javax.swing.JPanel panelModificar;
    private javax.swing.JPanel panelRegresar;
    private javax.swing.JTable tblPlantilla;
    private javax.swing.JLabel txtAgregarPlantilla;
    private javax.swing.JLabel txtEliminarPlantilla;
    private javax.swing.JLabel txtExaminarPlantilla;
    private javax.swing.JLabel txtModificarPlantilla;
    private javax.swing.JLabel txtRegresar;
    // End of variables declaration//GEN-END:variables
}
