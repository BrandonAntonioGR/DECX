/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.DAO.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class InsertaCargaMsgWhatsApp {
     public static boolean RegistrarUsuario(String CreateDate, String Contrato,
             String Agente, String Enviado){
        PreparedStatement ps;
        boolean retorno = false;
        Connection con;
        try {
            con = ModelConection.getConnection();
            ps=con.prepareStatement("INSERT INTO dm_PJavaMsgWhatsappp "
                    + "(CreateDate,Contrato,Agente,Enviado)"
                    + "VALUES(?,?,?,?)");
            ps.setString(1, CreateDate);
            ps.setString(2, Contrato);
            ps.setString(3, Agente);
            ps.setString(4, Enviado);
            retorno = Boolean.parseBoolean(Integer.toString(ps.executeUpdate()));
            //JOptionPane.showMessageDialog(null, "Mensaje a whats app ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            con.close();
            ps.close();
            return retorno;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el mensaje en BD", "Error", JOptionPane.ERROR_MESSAGE);
            return retorno;
        }
    }   
}
