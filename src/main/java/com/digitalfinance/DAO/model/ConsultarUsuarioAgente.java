/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.DAO.model;

import com.digitalfinance.DAO.entity.Agente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultarUsuarioAgente {
    public static ArrayList<Agente> consultaUsuariosAgentes(){
        Connection con;
        PreparedStatement ps;
        try{
            con=ModelConection.getConnection();
            ps=con.prepareStatement("SELECT  [name],[key],[Agente] FROM [DC REPORT].[dbo].[users_macro]");
            ResultSet rs=ps.executeQuery();
            ArrayList<Agente> lista=new ArrayList();
            while(rs.next()){
                Agente agente=new Agente();
                agente.setUsuario(rs.getString("name"));
                agente.setContrasenia(rs.getString("key"));
                agente.setAgente(rs.getString("Agente"));
                lista.add(agente);
            }
            cerrarConexion(con, ps, rs);
            return lista;
        }catch(Exception e){
            return null;
        }
        
    }
    public static void cerrarConexion(Connection con,PreparedStatement ps,ResultSet rs) throws SQLException{
        con.close();
        ps.close();
        rs.close();
    }
}
