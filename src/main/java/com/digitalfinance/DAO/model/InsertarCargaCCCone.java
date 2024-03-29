/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.DAO.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;



public class InsertarCargaCCCone {
    public static boolean RegistrarUsuario(String contrato, String agente){
        PreparedStatement ps;
        boolean retorno = false;
        Connection con;
        try {
            con = ModelConection.getConnection();
            ps=con.prepareStatement("INSERT INTO dm_PJava (number,Agente)VALUES(?,?)");
            ps.setString(1, contrato);
            ps.setString(2, agente);
            retorno = Boolean.parseBoolean(Integer.toString(ps.executeUpdate()));
            JOptionPane.showMessageDialog(null, "El contrato se cargo correctamente a CCCone", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            con.close();
            ps.close();
            return retorno;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return retorno;
        }
    }
}
