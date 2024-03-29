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


public class ConsultaMacro {
    public static ArrayList<Macro> consultaMacroDpdAsc(String agente,String dpd,String algoritmo){
        Connection con;
        PreparedStatement ps;
        try{
            con=ModelConection.getConnection();
            ps=con.prepareStatement("SELECT --cast([Creation_Day] as date ) \n" +
                "      [Agente] AS AGENTE\n" +
                "      ,a.[TEL] AS TELEFONO\n" +
                "      ,a.[CONTRATO] AS CONTRATO\n" +
                "      ,convert(int,dpd) as DPD\n" +
                "      ,[Adeudo] AS ADEUDO\n" +
                "      ,[NOMBRE] AS NOMBRE\n" +
                "	  ,ll.correo AS CORRE0\n" +
                "      ,[SPEI_CLABE] AS SPEI\n" +
                "      ,[OXXOReference] AS OXXO\n" +
                "      ,CASE WHEN [ALGORITMO] = '' THEN 'D'ELSE [ALGORITMO] END AS ALGORITMO\n" +
                "	  ,a.Tipo_Cliente as TIPOCTE\n" +
                "	  ,w.Enviado AS ENVIADO\n" +
                "	  ,m.Conteo AS CONTEO\n" +
                "FROM [DC REPORT].[dbo].[DC_HIS_ASIG] AS a\n" +
                "  LEFT JOIN  [DC REPORT].[dbo].[dm_LLAVES] AS ll on ll.contract_id=a.CONTRATO\n" +
                "  LEFT JOIN (SELECT w1.[Contrato],COUNT(w1.[Enviado]) AS Enviado FROM [DC REPORT].[dbo].[dm_PJavaMsgWhatsappp] as w1 GROUP BY w1.[Contrato]) AS w on w.[Contrato] = a.CONTRATO\n" +
                "  LEFT JOIN (SELECT  [Cliente] ,COUNT([Cliente]) as Conteo FROM [DC REPORT].[dbo].[Mitrol_int] where cast([Fecha_interaccion] as date ) = cast(getdate() as date ) AND [Campaña] LIKE '%W%'group by [Cliente]) AS m on m.Cliente = a.[TEL]\n" +
                "  where cast([Creation_Day] as date ) = cast(GETDATE ()as date )\n" +
                "  AND a.[CONTRATO] NOT IN (SELECT  [ContractNumber] FROM [DC REPORT].[dbo].[PaymentPromises]  WHERE CONVERT(DATE,GETDATE()) between CONVERT(DATE,[ContactDate]) and CONVERT(DATE,[PromiseLimitDate])\n" +
                "		UNION \n" +
                "		SELECT [Contrato] FROM [DC REPORT].[dbo].[CurrentDatePayment] \n" +
                "		UNION \n" +
                "		SELECT [number] FROM [DC REPORT].[dbo].[dm_PJava]\n" +
                "		)\n" +
                "  AND a.Agente='"+agente+"'\n" +
                "  AND a.DPD = "+dpd+"  and a.ALGORITMO='"+algoritmo+"'\n" +
                "  --AND a.[CONTRATO]='3006799973'\n" +
                "ORDER BY convert(int,a.Adeudo) ASC");
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
                macro.setCorreo(rs.getString("CORRE0"));
                macro.setSpeiClave(rs.getString("SPEI"));
                macro.setOxxoReference(rs.getString("OXXO"));
//                macro.setTipoCliente(rs.getString("TIPOCLIENTE"));
//                macro.setPromesas(rs.getString("PROMESAS"));
//                macro.setDiasCCC(rs.getString("DIASCCC"));
//                macro.setDiasMit(rs.getString("DIASMIT"));
//                macro.setDiasMssb(rs.getString("DIASMSB"));
                macro.setAlgoritmo(rs.getString("ALGORITMO"));
                macro.setTipoCte(rs.getString("TIPOCTE"));
                macro.setEnviado(rs.getString("ENVIADO"));
                macro.setConteoMit(rs.getString("CONTEO"));
                lista.add(macro);
            }
            cerrarConexion(con, ps, rs);
            return lista;
        }catch(Exception e){
            return null;
        }        
    }
    public static ArrayList<Macro> consultaMacroDpdDesc(String agente,String dpd,String algoritmo){
        Connection con;
        PreparedStatement ps;
        try{
            con=ModelConection.getConnection();
            ps=con.prepareStatement("SELECT --cast([Creation_Day] as date ) \n" +
                "      [Agente] AS AGENTE\n" +
                "      ,a.[TEL] AS TELEFONO\n" +
                "      ,a.[CONTRATO] AS CONTRATO\n" +
                "      ,convert(int,dpd) as DPD\n" +
                "      ,[Adeudo] AS ADEUDO\n" +
                "      ,[NOMBRE] AS NOMBRE\n" +
                "	  ,ll.correo AS CORRE0\n" +
                "      ,[SPEI_CLABE] AS SPEI\n" +
                "      ,[OXXOReference] AS OXXO\n" +
                "      ,CASE WHEN [ALGORITMO] = '' THEN 'D'ELSE [ALGORITMO] END AS ALGORITMO\n" +
                "	  ,a.Tipo_Cliente as TIPOCTE\n" +
                "	  ,w.Enviado AS ENVIADO\n" +
                "	  ,m.Conteo AS CONTEO\n" +
                "FROM [DC REPORT].[dbo].[DC_HIS_ASIG] AS a\n" +
                "  LEFT JOIN  [DC REPORT].[dbo].[dm_LLAVES] AS ll on ll.contract_id=a.CONTRATO\n" +
                "  LEFT JOIN (SELECT w1.[Contrato],COUNT(w1.[Enviado]) AS Enviado FROM [DC REPORT].[dbo].[dm_PJavaMsgWhatsappp] as w1 GROUP BY w1.[Contrato]) AS w on w.[Contrato] = a.CONTRATO\n" +
                "  LEFT JOIN (SELECT  [Cliente] ,COUNT([Cliente]) as Conteo FROM [DC REPORT].[dbo].[Mitrol_int] where cast([Fecha_interaccion] as date ) = cast(getdate() as date ) AND [Campaña] LIKE '%W%'group by [Cliente]) AS m on m.Cliente = a.[TEL]\n" +
                "  where cast([Creation_Day] as date ) = cast(GETDATE ()as date )\n" +
                "  AND a.[CONTRATO] NOT IN (SELECT  [ContractNumber] FROM [DC REPORT].[dbo].[PaymentPromises]  WHERE CONVERT(DATE,GETDATE()) between CONVERT(DATE,[ContactDate]) and CONVERT(DATE,[PromiseLimitDate])\n" +
                "		UNION \n" +
                "		SELECT [Contrato] FROM [DC REPORT].[dbo].[CurrentDatePayment] \n" +
                "		UNION \n" +
                "		SELECT [number] FROM [DC REPORT].[dbo].[dm_PJava]\n" +
                "		)\n" +
                "  AND a.Agente='"+agente+"'\n" +
                "  AND a.DPD = "+dpd+"  and a.ALGORITMO='"+algoritmo+"'\n" +
                "  --AND a.[CONTRATO]='3006799973'\n" +
                "ORDER BY convert(int,a.Adeudo) DESC");
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
                macro.setCorreo(rs.getString("CORRE0"));
                macro.setSpeiClave(rs.getString("SPEI"));
                macro.setOxxoReference(rs.getString("OXXO"));
//                macro.setTipoCliente(rs.getString("TIPOCLIENTE"));
//                macro.setPromesas(rs.getString("PROMESAS"));
//                macro.setDiasCCC(rs.getString("DIASCCC"));
//                macro.setDiasMit(rs.getString("DIASMIT"));
//                macro.setDiasMssb(rs.getString("DIASMSB"));
                macro.setAlgoritmo(rs.getString("ALGORITMO"));
                macro.setTipoCte(rs.getString("TIPOCTE"));
                macro.setEnviado(rs.getString("ENVIADO"));
                macro.setConteoMit(rs.getString("CONTEO"));
                lista.add(macro);
            }
            cerrarConexion(con, ps, rs);
            return lista;
        }catch(Exception e){
            return null;
        }        
    }

    public static ArrayList<Dpd> consultaDpdsDisponibles(String agente){
        Connection con;
        PreparedStatement ps;
        try{
            con=ModelConection.getConnection();
            ps=con.prepareStatement("Select DPD FROM \n" +
                "(SELECT \n" +
                "      convert(int,dpd) as DPD\n" +
                "      --CASE WHEN [ALGORITMO] = '' THEN 'D'ELSE [ALGORITMO] END AS ALGORITMO\n" +
                "FROM [DC REPORT].[dbo].[DC_HIS_ASIG] AS a\n" +
                "  LEFT JOIN  [DC REPORT].[dbo].[dm_LLAVES] AS ll on ll.contract_id=a.CONTRATO\n" +
                "  LEFT JOIN (SELECT w1.[Contrato],COUNT(w1.[Enviado]) AS Enviado FROM [DC REPORT].[dbo].[dm_PJavaMsgWhatsappp] as w1 GROUP BY w1.[Contrato]) AS w on w.[Contrato] = a.CONTRATO\n" +
                "  LEFT JOIN (SELECT  [Cliente] ,COUNT([Cliente]) as Conteo FROM [DC REPORT].[dbo].[Mitrol_int] where cast([Fecha_interaccion] as date ) = cast(getdate() as date ) AND [Campaña] LIKE '%W%'group by [Cliente]) AS m on m.Cliente = a.[TEL]\n" +
                "  where cast([Creation_Day] as date ) = cast(GETDATE ()as date )\n" +
                "  AND a.[CONTRATO] NOT IN (SELECT  [ContractNumber] FROM [DC REPORT].[dbo].[PaymentPromises]  WHERE CONVERT(DATE,GETDATE()) between CONVERT(DATE,[ContactDate]) and CONVERT(DATE,[PromiseLimitDate])\n" +
                "		UNION \n" +
                "		SELECT [Contrato] FROM [DC REPORT].[dbo].[CurrentDatePayment] \n" +
                "		UNION \n" +
                "		SELECT [number] FROM [DC REPORT].[dbo].[dm_PJava])\n" +
                "  AND a.Agente='"+agente+"'\n" +
                "  AND a.DPD BETWEEN -5 and 15\n" +
                "  --and a.[CONTRATO]='3005598282'\n" +
                "--GROUP BY ALGORITMO\n" +
                "--ORDER BY ALGORITMO\n" +
                "GROUP BY convert(int,dpd)\n" +
                "--ORDER BY DPD\n" +
                ") AS TABLA\n" +
                "group by DPD\n" +
                "ORDER BY DPD");
            ResultSet rs=ps.executeQuery();
            ArrayList<Dpd> lista=new ArrayList();
            while(rs.next()){
                Dpd dpd=new Dpd();
                dpd.setDpd(rs.getString("DPD"));
                lista.add(dpd);
            }
            cerrarConexion(con, ps, rs);
            return lista;
        }catch(Exception e){
            return null;
        }
    }
    public static ArrayList<Algoritmo> consultaAlgoritmosDisponibles(String agente){
        Connection con;
        PreparedStatement ps;
        try{
            con=ModelConection.getConnection();
            ps=con.prepareStatement("Select ALGORITMO FROM \n" +
                "(SELECT \n" +
                "      --convert(int,dpd) as DPD\n" +
                "      CASE WHEN [ALGORITMO] = '' THEN 'D'ELSE [ALGORITMO] END AS ALGORITMO\n" +
                "FROM [DC REPORT].[dbo].[DC_HIS_ASIG] AS a\n" +
                "  LEFT JOIN  [DC REPORT].[dbo].[dm_LLAVES] AS ll on ll.contract_id=a.CONTRATO\n" +
                "  LEFT JOIN (SELECT w1.[Contrato],COUNT(w1.[Enviado]) AS Enviado FROM [DC REPORT].[dbo].[dm_PJavaMsgWhatsappp] as w1 GROUP BY w1.[Contrato]) AS w on w.[Contrato] = a.CONTRATO\n" +
                "  LEFT JOIN (SELECT  [Cliente] ,COUNT([Cliente]) as Conteo FROM [DC REPORT].[dbo].[Mitrol_int] where cast([Fecha_interaccion] as date ) = cast(getdate() as date ) AND [Campaña] LIKE '%W%'group by [Cliente]) AS m on m.Cliente = a.[TEL]\n" +
                "  where cast([Creation_Day] as date ) = cast(GETDATE ()as date )\n" +
                "  AND a.[CONTRATO] NOT IN (SELECT  [ContractNumber] FROM [DC REPORT].[dbo].[PaymentPromises]  WHERE CONVERT(DATE,GETDATE()) between CONVERT(DATE,[ContactDate]) and CONVERT(DATE,[PromiseLimitDate])\n" +
                "		UNION \n" +
                "		SELECT [Contrato] FROM [DC REPORT].[dbo].[CurrentDatePayment] \n" +
                "		UNION \n" +
                "		SELECT [number] FROM [DC REPORT].[dbo].[dm_PJava])\n" +
                "  AND a.Agente='"+agente+"'\n" +
                "  AND a.DPD BETWEEN -5 and 15\n" +
                "  --and a.[CONTRATO]='3005598282'\n" +
                "GROUP BY ALGORITMO\n" +
                "--ORDER BY ALGORITMO\n" +
                "--GROUP BY convert(int,dpd)\n" +
                "--ORDER BY DPD\n" +
                ") AS TABLA\n" +
                "group by ALGORITMO\n" +
                "ORDER BY ALGORITMO");
            ResultSet rs=ps.executeQuery();
            ArrayList<Algoritmo> lista=new ArrayList();
            while(rs.next()){
                Algoritmo algortimo=new Algoritmo();
                algortimo.setAlgoritmo(rs.getString("ALGORITMO"));
                lista.add(algortimo);
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