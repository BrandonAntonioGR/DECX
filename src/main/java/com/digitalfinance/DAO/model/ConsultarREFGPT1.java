/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.DAO.model;

import com.digitalfinance.DAO.entity.REF_GPT1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConsultarREFGPT1 {
    public static ArrayList<REF_GPT1> consultaREFGPT1(String numeroContrato){
        Connection con;
        PreparedStatement ps;
        try{
            con=ModelConection.getConnection();//SELECT  number ,DPD ,client_full_name ,open_principal,NOMBRE ,SPEI_CLABE ,OXXOReference ,EXTENSION_20 ,EXTENSION_30 ,Saldo_hoy ,Adeudo ,Fecha_Pago FROM [DC REPORT].[dbo].[dm_REF_GPT1]
            ps=con.prepareStatement("SELECT TOP 1\n" +
                " ll.Tel_id_Vchar \n" +
                " ,r.number  \n" +
                " ,ll.correo  \n" +
                " ,r.DPD  \n" +
                " ,r.client_full_name  \n" +
                " ,r.open_principal, \n" +
                " r.NOMBRE  \n" +
                " ,r.SPEI_CLABE  \n" +
                " ,r.OXXOReference  \n" +
                " ,CEILING(r.EXTENSION_20)  AS EXTENSION_20\n" +
                " ,CEILING(r.EXTENSION_30)  AS EXTENSION_30\n" +
                " ,CEILING(r.Saldo_hoy)  AS Saldo_hoy\n" +
                " ,CEILING(r.Adeudo)  AS Adeudo\n" +
                " ,r.Fecha_Pago   \n" +
                " ,a.TEL,\n" +
                " a.ALGORITMO \n" +
                " ,a.[Creation_Day]\n" +
                " ,a.tipo_cliente  \n" +
                " FROM dm_REF_GPT1 AS r \n" +
                " LEFT JOIN DC_HIS_ASIG AS a  \n" +
                " ON  a.CONTRATO=r.number  \n" +
                " LEFT JOIN dm_LLAVES AS ll \n" +
                " ON a.CONTRATO=ll.contract_id \n" +
                " where r.number='"+numeroContrato+"'\n" +
                " order by [Creation_Day] DESC");
            ResultSet rs=ps.executeQuery();
            ArrayList<REF_GPT1> lista=new ArrayList();
            while(rs.next()){
                REF_GPT1 contrato=new REF_GPT1();
                contrato.setNumber(rs.getString("number"));
                contrato.setDpd(rs.getString("DPD"));
                contrato.setClientFullName(rs.getString("client_full_name"));
                contrato.setOpen_principal(rs.getString("open_principal"));
                contrato.setNombre(rs.getString("NOMBRE"));
                contrato.setSpeiClave(rs.getString("SPEI_CLABE"));
                contrato.setOxxoReference(rs.getString("OXXOReference"));
                contrato.setExtension20(rs.getString("EXTENSION_20"));
                contrato.setExtension30(rs.getString("EXTENSION_30"));
                contrato.setSaldoHoy(rs.getString("Saldo_hoy"));
                contrato.setAdeudo(rs.getString("Adeudo"));
                contrato.setFechaPago(rs.getDate("Fecha_Pago"));
                contrato.setTel(rs.getString("TEL"));
                contrato.setAlgoritmo(rs.getString("ALGORITMO"));
                contrato.setTipoCliente(rs.getString("tipo_cliente"));
                
                lista.add(contrato);
            }
            cerrarConexion(con, ps, rs);
            return lista;
        }catch(Exception e){
            return null;
        }
    }
    public static ArrayList<REF_GPT1> consultaREFGPT1Tel(String telefono){
        Connection con;
        PreparedStatement ps;
        try{
            con=ModelConection.getConnection();//SELECT  number ,DPD ,client_full_name ,open_principal,NOMBRE ,SPEI_CLABE ,OXXOReference ,EXTENSION_20 ,EXTENSION_30 ,Saldo_hoy ,Adeudo ,Fecha_Pago FROM [DC REPORT].[dbo].[dm_REF_GPT1]
            ps=con.prepareStatement("SELECT TOP 1\n" +
                " a.Creation_Day\n" +
                " ,ll.Tel_id_Vchar \n" +
                " ,r.number  \n" +
                " ,ll.correo  \n" +
                " ,r.DPD  \n" +
                " ,r.client_full_name  \n" +
                " ,r.open_principal, \n" +
                " r.NOMBRE  \n" +
                " ,r.SPEI_CLABE  \n" +
                " ,r.OXXOReference  \n" +
                " ,CEILING(r.EXTENSION_20)  AS EXTENSION_20\n" +
                " ,CEILING(r.EXTENSION_30)  AS EXTENSION_30\n" +
                " ,CEILING(r.Saldo_hoy)  AS Saldo_hoy\n" +
                " ,CEILING(r.Adeudo)  AS Adeudo\n" +
                " ,r.Fecha_Pago   \n" +
                " ,a.TEL\n" +
                " ,a.ALGORITMO \n" +
                " ,a.tipo_cliente  \n" +
                " FROM dm_REF_GPT1 AS r\n" +
                " LEFT JOIN DC_HIS_ASIG AS a\n" +
                " ON  a.CONTRATO=r.number  \n" +
                " LEFT JOIN dm_LLAVES AS ll \n" +
                " ON a.CONTRATO=ll.contract_id \n" +
                "WHERE ll.Tel_id_Vchar='"+telefono+"'\n" +
                "order by [Creation_Day] DESC\n" +
                "--and CONVERT(DATE,a.Creation_Day)=CONVERT(DATE, GETDATE())");
            ResultSet rs=ps.executeQuery();
            ArrayList<REF_GPT1> lista=new ArrayList();
            while(rs.next()){
                REF_GPT1 contrato=new REF_GPT1();
                contrato.setNumber(rs.getString("number"));
                contrato.setDpd(rs.getString("DPD"));
                contrato.setClientFullName(rs.getString("client_full_name"));
                contrato.setOpen_principal(rs.getString("open_principal"));
                contrato.setNombre(rs.getString("NOMBRE"));
                contrato.setSpeiClave(rs.getString("SPEI_CLABE"));
                contrato.setOxxoReference(rs.getString("OXXOReference"));
                contrato.setExtension20(rs.getString("EXTENSION_20"));
                contrato.setExtension30(rs.getString("EXTENSION_30"));
                contrato.setSaldoHoy(rs.getString("Saldo_hoy"));
                contrato.setAdeudo(rs.getString("Adeudo"));
                contrato.setFechaPago(rs.getDate("Fecha_Pago"));
                contrato.setTel(rs.getString("TEL"));
                contrato.setAlgoritmo(rs.getString("ALGORITMO"));
                contrato.setTipoCliente(rs.getString("tipo_cliente"));
                contrato.setCorreo(rs.getString("correo"));
                
                lista.add(contrato);
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
