/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.DAO.model;

import com.digitalfinance.DAO.entity.PlanesPago;
import com.digitalfinance.DAO.entity.PromesaPago;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class InsertaPlanesPago {

    public static boolean RegistrarPlanPago(ArrayList<PlanesPago> listaPlanesPago) {
        PreparedStatement ps;
        boolean retorno = false;
        Connection con;
        try {
            con = ModelConection.getConnection();
            ps = con.prepareStatement("INSERT INTO [DC_PlanesPagoJava] "
                    + "([contrato],[dpd],[algoritmo],[agente],[adeudo],"
                    + "[frecuencia],[plazos],[tipoMonto],[montoPlan],"
                    + "[fechaPagoPlan],[StatusPlan],[Creation_Day]) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            String fechaString;
            for (PlanesPago planesPago : listaPlanesPago) {
                ps.setString(1, planesPago.getContrato());
                ps.setString(2, planesPago.getDpd());
                ps.setString(3, planesPago.getAlgoritmo());
                ps.setString(4, planesPago.getAgente());
                ps.setString(5, planesPago.getAdeudo());
                ps.setString(6, planesPago.getFecuencia());
                ps.setInt(7, planesPago.getPlazos());
                ps.setString(8, planesPago.getTipoMonto());
                ps.setString(9, planesPago.getMontoPlan());
                
                 fechaString= planesPago.getFechaPagoPlan();
                // Convertir el String a java.sql.Date
                Date sqlDate = Date.valueOf(fechaString);
                
                ps.setDate(10, sqlDate);
                ps.setString(11, planesPago.getStatusPlan());
                ps.setString(12, planesPago.getCreationDay());

                // Ejecutar la inserción
                retorno = ps.executeUpdate() > 0;
                System.out.println("retorno "+retorno);
            }
            con.close();
            ps.close();
            JOptionPane.showMessageDialog(null, "¡Planes de pago guardados exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return retorno;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los planes de pago: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + e);
            return retorno;
        }
    }
}
