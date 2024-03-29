/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.DAO.model;

import com.digitalfinance.DAO.entity.Algoritmo;
import com.digitalfinance.DAO.entity.Dpd;
import com.digitalfinance.DAO.entity.Macro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConsultaCargadosCCCone {
    public static ArrayList<Macro> consultaCargadosCCConeAsc(String agente){
        Connection con;
        PreparedStatement ps;
        try{
            con=ModelConection.getConnection();
            ps=con.prepareStatement("SELECT\n" +
                "a.Agente as AGENTE----interno\n" +
                ",a.TEL AS TELEFONO--api\n" +
                ",a.CONTRATO AS CONTRATO\n" +
                ",Convert(int,a.DPD) AS DPD\n" +
                ",a.Adeudo AS ADEUDO\n" +
                " ,a.NOMBRE AS NOMBRE\n" +
                "--,a.NCOMPLETO AS NCOMPLETO\n" +
                "--,ll.correo AS CORREO\n" +
                ",a.SPEI_CLABE AS SPEI\n" +
                ",a.OXXOReference AS OXXO\n" +
                "--,a.Client_Type AS TIPOCLIENTE\n" +
                "--,a.PROMESAS AS PROMESAS\n" +
                "--,a.DIAS_CCC AS DIASCCC\n" +
                "--,a.DIAS_MIT AS DIASMIT\n" +
                "--,a.DIAS_MESSB AS DIASMSB\n" +
                ",a.ALGORITMO AS ALGORITMO\n" +
                " FROM DC_HIS_ASIG a\n" +
                "LEFT JOIN dm_LLAVES ll\n" +
                "ON ll.contract_id=a.CONTRATO\n" +
                "LEFT JOIN dm_REF_GPT1 AS r\n" +
                "ON r.number=a.CONTRATO\n" +
                "JOIN dm_PJava AS j\n" +
                "ON a.CONTRATO=j.number\n" +
                "WHERE CONVERT(DATE,[Creation_Day])=CONVERT(DATE,GETDATE()) and a.Agente='"+agente+"'\n" +
                "ORDER BY CONVERT(int, a.Adeudo) DESC,a.DPD");
            ResultSet rs=ps.executeQuery();
            ArrayList<Macro> lista=new ArrayList();
            while(rs.next()){
                Macro macro=new Macro();
                macro.setAgente(rs.getString("AGENTE"));
                macro.setTel(rs.getString("TELEFONO"));
                macro.setNumber(rs.getString("CONTRATO"));
                macro.setDpd(rs.getString("DPD"));
                macro.setAdeudo(rs.getString("ADEUDO"));
                macro.setNombre(rs.getString("NOMBRE"));
//                macro.setClientFullName(rs.getString("NCOMPLETO"));
//                macro.setCorreo(rs.getString("CORREO"));
                macro.setSpeiClave(rs.getString("SPEI"));
                macro.setOxxoReference(rs.getString("OXXO"));
//                macro.setTipoCliente(rs.getString("TIPOCLIENTE"));
//                macro.setPromesas(rs.getString("PROMESAS"));
//                macro.setDiasCCC(rs.getString("DIASCCC"));
//                macro.setDiasMit(rs.getString("DIASMIT"));
//                macro.setDiasMssb(rs.getString("DIASMSB"));
                macro.setAlgoritmo(rs.getString("ALGORITMO"));
                lista.add(macro);
            }
            cerrarConexion(con, ps, rs);
            return lista;
        }catch(Exception e){
            return null;
        }        
    }
//    public static ArrayList<Macro> consultaCargadosCCConeDesc(String agente){
//        Connection con;
//        PreparedStatement ps;
//        try{
//            con=ModelConection.getConnection();
//            ps=con.prepareStatement("SELECT\n" +
//                "a.Agente as AGENTE----interno\n" +
//                ",a.TEL AS TELEFONO--api\n" +
//                ",a.CONTRATO AS CONTRATO\n" +
//                ",Convert(int,a.DPD) AS DPD\n" +
//                ",a.Adeudo AS ADEUDO\n" +
//                " ,a.NOMBRE AS NOMBRE\n" +
//                "--,a.NCOMPLETO AS NCOMPLETO\n" +
//                "--,ll.correo AS CORREO\n" +
//                ",a.SPEI_CLABE AS SPEI\n" +
//                ",a.OXXOReference AS OXXO\n" +
//                "--,a.Client_Type AS TIPOCLIENTE\n" +
//                "--,a.PROMESAS AS PROMESAS\n" +
//                "--,a.DIAS_CCC AS DIASCCC\n" +
//                "--,a.DIAS_MIT AS DIASMIT\n" +
//                "--,a.DIAS_MESSB AS DIASMSB\n" +
//                ",a.ALGORITMO AS ALGORITMO\n" +
//                " FROM DC_HIS_ASIG a\n" +
//                "LEFT JOIN dm_LLAVES ll\n" +
//                "ON ll.contract_id=a.CONTRATO\n" +
//                "LEFT JOIN dm_REF_GPT1 AS r\n" +
//                "ON r.number=a.CONTRATO\n" +
//                "JOIN dm_PJava AS j\n" +
//                "ON a.CONTRATO=j.number\n" +
//                "WHERE CONVERT(DATE,[Creation_Day])=CONVERT(DATE,GETDATE()) and a.Agente='"+agente+"'\n" +
//                "ORDER BY CONVERT(int, a.Adeudo) DESC,a.DPD");
//            ResultSet rs=ps.executeQuery();
//            ArrayList<Macro> lista=new ArrayList();
//            while(rs.next()){
//                Macro macro=new Macro();
//                macro.setAgente(rs.getString("AGENTE"));
//                macro.setTel(rs.getString("TELEFONO"));
//                macro.setNumber(rs.getString("CONTRATO"));
//                macro.setDpd(rs.getString("DPD"));
//                macro.setAdeudo(rs.getString("ADEUDO"));
//                macro.setNombre(rs.getString("NOMBRE"));
////                macro.setClientFullName(rs.getString("NCOMPLETO"));
////                macro.setCorreo(rs.getString("CORREO"));
//                macro.setSpeiClave(rs.getString("SPEI"));
//                macro.setOxxoReference(rs.getString("OXXO"));
////                macro.setTipoCliente(rs.getString("TIPOCLIENTE"));
////                macro.setPromesas(rs.getString("PROMESAS"));
////                macro.setDiasCCC(rs.getString("DIASCCC"));
////                macro.setDiasMit(rs.getString("DIASMIT"));
////                macro.setDiasMssb(rs.getString("DIASMSB"));
//                macro.setAlgoritmo(rs.getString("ALGORITMO"));
//                lista.add(macro);
//            }
//            cerrarConexion(con, ps, rs);
//            return lista;
//        }catch(Exception e){
//            return null;
//        }        
//    }

    
    
    public static void cerrarConexion(Connection con,PreparedStatement ps,ResultSet rs) throws SQLException{
        con.close();
        ps.close();
        rs.close();
    }    
}
