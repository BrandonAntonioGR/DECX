/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.DAO.model;


import com.digitalfinance.DAO.entity.Promesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConsultaPromesados {
    public static ArrayList<Promesa> consultaPromesados(String agente,String DiasPromesa){
        Connection con;
        PreparedStatement ps;
        try{
            con=ModelConection.getConnection();
            ps=con.prepareStatement("USE [DC REPORT]\n" +
                "DECLARE @Hoy datetime = CONVERT(DATE,GETDATE());\n" +
                "SELECT\n" +
                "	  cp.ValorPago AS PAGO\n" +
                "	  ,r.[number] AS Contrato\n" +
                "      ,r.[NOMBRE] AS NombreCliente\n" +
                "      ,DATEDIFF(DD, @Hoy, CONVERT(DATE,pp.PromiseDate)) AS DiasPromesa_1\n" +
                "	  ,CONVERT(DATE,pp.PromiseDate) AS PROMESE_DATE\n" +
                "	  ,ll.Tel_id_Vchar AS NUMERO\n" +
                "	  ,ll.correo AS Correo\n" +
                "	  ,pp.PromiseAmount AS MontoPromesado\n" +
                "	  ,r.[OXXOReference] AS OXXOReference\n" +
                "	  ,r.[SPEI_CLABE] AS SPEI\n" +
                "	  ,r.[EXTENSION_20] AS EXTENCION_20\n" +
                "	  ,CASE\n" +
                "	WHEN pp.Agent =  'ANDREA RAMIREZ'   Then    'ANDREA'\n" +
                "	WHEN pp.Agent = 'ELIAS CASTELLANOS'   Then    'ARAMUEL'\n" +
                "	WHEN pp.Agent =  'ARELI'   Then    'DIANA'\n" +
                "	WHEN pp.Agent =  'CARLOS IVAN CASTILLO  ARCOS'   Then    'CARLOS'\n" +
                "	WHEN pp.Agent =  'CRISTAL PADILLA'   Then    'CRISTAL'\n" +
                "	WHEN pp.Agent =  'CRISTIAN ARENAS'   Then    'CRISTIAN'\n" +
                "	WHEN pp.Agent =  'DIANA PAOLA RUIZ AGUILAR'   Then    'DIANA'\n" +
                "	WHEN pp.Agent =  'ELIAS ROJAS'   Then    'ELIAS'\n" +
                "	WHEN pp.Agent =  'GUILLERMO CERA'   Then    'GUILLERMO'\n" +
                "	WHEN pp.Agent =  'ISELA LOPEZ'   Then    'ISELA'\n" +
                "	WHEN pp.Agent =  'ITZAE HERNANDEZ'   Then    'ITZAE'\n" +
                "	WHEN pp.Agent =  'KEVIN ORTIZ'   Then    'KEVIN'\n" +
                "	WHEN pp.Agent =  'LAURA DIAZ'   Then    'LAURA'\n" +
                "	WHEN pp.Agent =  'MARIANA  BERNAL'   Then    'MARIANA'\n" +
                "	WHEN pp.Agent =  'MAYRA MORALES'   Then    'MAYRA'\n" +
                "	WHEN pp.Agent = 'NANCY MARTINEZ' THEN 'NANCY'\n" +
                "	WHEN pp.Agent =  'OMAR GUTIERREZ'   Then    'OMAR'\n" +
                "	WHEN pp.Agent =  'ROCIO  DUARTE NARVAEZ'   Then    'ROCIO'\n" +
                "	WHEN pp.Agent =  'VIRIDIANA LOPEZ'   Then    'VIRIDIANA'\n" +
                "	WHEN pp.Agent =  'VOX'   Then    'VOX'\n" +
                "	WHEN pp.Agent = 'HUERTA FLORES YOHISKOOL YUZMARHA' THEN 'YOHISKOLL'\n" +
                "	ELSE pp.Agent\n" +
                "	END AS AGENTE\n" +
                "  FROM [PaymentPromises]				AS pp\n" +
                "  INNER JOIN [dm_REF_GPT1]				AS r\n" +
                "  ON pp.[ContractNumber]=r.[number]\n" +
                "  LEFT JOIN CurrentDatePayment			AS cp\n" +
                "  ON pp.[ContractNumber]=cp.Contrato  \n" +
                "  LEFT JOIN dm_LLAVES					AS ll\n" +
                "  ON pp.[ContractNumber]=ll.contract_id\n" +
                "  WHERE DATEDIFF(DD, @Hoy, CONVERT(DATE,pp.PromiseDate))="+DiasPromesa+"--BETWEEN -1 AND 1\n" +
                "  AND pp.[ContractNumber] is not null\n" +
                "     AND CASE\n" +
                "WHEN pp.Agent =  'ANDREA RAMIREZ'   Then    'ANDREA'\n" +
                "WHEN pp.Agent = 'ELIAS CASTELLANOS'   Then    'ARAMUEL'\n" +
                "WHEN pp.Agent =  'ARELI'   Then    'DIANA'\n" +
                "WHEN pp.Agent =  'CARLOS IVAN CASTILLO  ARCOS'   Then    'CARLOS'\n" +
                "WHEN pp.Agent =  'CRISTAL PADILLA'   Then    'CRISTAL'\n" +
                "WHEN pp.Agent =  'CRISTIAN ARENAS'   Then    'CRISTIAN'\n" +
                "WHEN pp.Agent =  'DIANA PAOLA RUIZ AGUILAR'   Then    'DIANA'\n" +
                "WHEN pp.Agent =  'ELIAS ROJAS'   Then    'ELIAS'\n" +
                "WHEN pp.Agent =  'GUILLERMO CERA'   Then    'GUILLERMO'\n" +
                "WHEN pp.Agent =  'ISELA LOPEZ'   Then    'ISELA'\n" +
                "WHEN pp.Agent =  'ITZAE HERNANDEZ'   Then    'ITZAE'\n" +
                "WHEN pp.Agent =  'KEVIN ORTIZ'   Then    'KEVIN'\n" +
                "WHEN pp.Agent =  'LAURA DIAZ'   Then    'LAURA'\n" +
                "WHEN pp.Agent =  'MARIANA  BERNAL'   Then    'MARIANA'\n" +
                "WHEN pp.Agent =  'MAYRA MORALES'   Then    'MAYRA'\n" +
                "WHEN pp.Agent = 'NANCY MARTINEZ' THEN 'NANCY'\n" +
                "WHEN pp.Agent =  'OMAR GUTIERREZ'   Then    'OMAR'\n" +
                "WHEN pp.Agent =  'ROCIO  DUARTE NARVAEZ'   Then    'ROCIO'\n" +
                "WHEN pp.Agent =  'VIRIDIANA LOPEZ'   Then    'VIRIDIANA'\n" +
                "WHEN pp.Agent =  'VOX'   Then    'VOX'\n" +
                "WHEN pp.Agent = 'HUERTA FLORES YOHISKOOL YUZMARHA' THEN 'YOHISKOLL'\n" +
                "ELSE pp.Agent\n" +
                "END='"+agente+"'\n" +
                "AND r.[DPD]>-5\n" +
                "AND CAST([PromiseLimitDate] AS DATE) >DATEADD(day, -1, GETDATE())\n" +
                "ORDER BY DATEDIFF(DD, @Hoy, CONVERT(DATE,pp.PromiseDate)) DESC");
            ResultSet rs=ps.executeQuery();
            ArrayList<Promesa> lista=new ArrayList();
            while(rs.next()){
                Promesa promesa=new Promesa();
                promesa.setPago(rs.getString("PAGO"));
                promesa.setContrato(rs.getString("Contrato"));
                promesa.setNombreCte(rs.getString("NombreCliente"));
                promesa.setDiasPromesa(rs.getString("DiasPromesa_1"));
                promesa.setTelCte(rs.getString("NUMERO"));
                promesa.setAgente(rs.getString("AGENTE"));
                promesa.setCorreoCte(rs.getString("Correo"));
                promesa.setMontoPromesado(rs.getString("MontoPromesado"));
                promesa.setOxxoReference(rs.getString("OXXOReference"));
                promesa.setSpeiReference(rs.getString("SPEI"));
                promesa.setFechaPromesada(rs.getString("PROMESE_DATE"));
                promesa.setExtencion20(rs.getString("EXTENCION_20"));
                lista.add(promesa);
            }
            cerrarConexion(con, ps, rs);
            return lista;
        }catch(Exception e){
            return null;
        }        
    }
    //este es el query de la funcionalidad de descarga excel
    public static ArrayList<Promesa> consultaPromesados(String agente){
        Connection con;
        PreparedStatement ps;
        try{
            con=ModelConection.getConnection();
            ps=con.prepareStatement("USE [DC REPORT]\n" +
                "DECLARE @Hoy datetime = CONVERT(DATE,GETDATE());\n" +
                "SELECT\n" +
                "	  cp.ValorPago AS PAGO\n" +
                "	  ,r.[number] AS Contrato\n" +
                "      ,r.[NOMBRE] AS NombreCliente\n" +
                "      ,DATEDIFF(DD, @Hoy, CONVERT(DATE,pp.PromiseDate)) AS DiasPromesa_1\n" +
                "	  ,CONVERT(DATE,pp.PromiseDate) AS PROMESE_DATE\n" +
                "	  ,ll.Tel_id_Vchar AS NUMERO\n" +
                "	  ,ll.correo AS Correo\n" +
                "	  ,pp.PromiseAmount AS MontoPromesado\n" +
                "	  ,r.[OXXOReference] AS OXXOReference\n" +
                "	  ,r.[SPEI_CLABE] AS SPEI\n" +
                "	  ,r.[EXTENSION_20] AS EXTENCION_20\n" +
                "	  ,CASE\n" +
                "	WHEN pp.Agent =  'ANDREA RAMIREZ'   Then    'ANDREA'\n" +
                "	WHEN pp.Agent = 'ELIAS CASTELLANOS'   Then    'ARAMUEL'\n" +
                "	WHEN pp.Agent =  'ARELI'   Then    'DIANA'\n" +
                "	WHEN pp.Agent =  'CARLOS IVAN CASTILLO  ARCOS'   Then    'CARLOS'\n" +
                "	WHEN pp.Agent =  'CRISTAL PADILLA'   Then    'CRISTAL'\n" +
                "	WHEN pp.Agent =  'CRISTIAN ARENAS'   Then    'CRISTIAN'\n" +
                "	WHEN pp.Agent =  'DIANA PAOLA RUIZ AGUILAR'   Then    'DIANA'\n" +
                "	WHEN pp.Agent =  'ELIAS ROJAS'   Then    'ELIAS'\n" +
                "	WHEN pp.Agent =  'GUILLERMO CERA'   Then    'GUILLERMO'\n" +
                "	WHEN pp.Agent =  'ISELA LOPEZ'   Then    'ISELA'\n" +
                "	WHEN pp.Agent =  'ITZAE HERNANDEZ'   Then    'ITZAE'\n" +
                "	WHEN pp.Agent =  'KEVIN ORTIZ'   Then    'KEVIN'\n" +
                "	WHEN pp.Agent =  'LAURA DIAZ'   Then    'LAURA'\n" +
                "	WHEN pp.Agent =  'MARIANA  BERNAL'   Then    'MARIANA'\n" +
                "	WHEN pp.Agent =  'MAYRA MORALES'   Then    'MAYRA'\n" +
                "	WHEN pp.Agent = 'NANCY MARTINEZ' THEN 'NANCY'\n" +
                "	WHEN pp.Agent =  'OMAR GUTIERREZ'   Then    'OMAR'\n" +
                "	WHEN pp.Agent =  'ROCIO  DUARTE NARVAEZ'   Then    'ROCIO'\n" +
                "	WHEN pp.Agent =  'VIRIDIANA LOPEZ'   Then    'VIRIDIANA'\n" +
                "	WHEN pp.Agent =  'VOX'   Then    'VOX'\n" +
                "	WHEN pp.Agent = 'HUERTA FLORES YOHISKOOL YUZMARHA' THEN 'YOHISKOLL'\n" +
                "	ELSE pp.Agent\n" +
                "	END AS AGENTE\n" +
                "  FROM [PaymentPromises]				AS pp\n" +
                "  INNER JOIN [dm_REF_GPT1]				AS r\n" +
                "  ON pp.[ContractNumber]=r.[number]\n" +
                "  LEFT JOIN CurrentDatePayment			AS cp\n" +
                "  ON pp.[ContractNumber]=cp.Contrato  \n" +
                "  LEFT JOIN dm_LLAVES					AS ll\n" +
                "  ON pp.[ContractNumber]=ll.contract_id\n" +
                "  WHERE DATEDIFF(DD, @Hoy, CONVERT(DATE,pp.PromiseDate))BETWEEN -1 AND 1\n" +
                "  AND pp.[ContractNumber] is not null\n" +
                "     AND CASE\n" +
                "WHEN pp.Agent =  'ANDREA RAMIREZ'   Then    'ANDREA'\n" +
                "WHEN pp.Agent = 'ELIAS CASTELLANOS'   Then    'ARAMUEL'\n" +
                "WHEN pp.Agent =  'ARELI'   Then    'DIANA'\n" +
                "WHEN pp.Agent =  'CARLOS IVAN CASTILLO  ARCOS'   Then    'CARLOS'\n" +
                "WHEN pp.Agent =  'CRISTAL PADILLA'   Then    'CRISTAL'\n" +
                "WHEN pp.Agent =  'CRISTIAN ARENAS'   Then    'CRISTIAN'\n" +
                "WHEN pp.Agent =  'DIANA PAOLA RUIZ AGUILAR'   Then    'DIANA'\n" +
                "WHEN pp.Agent =  'ELIAS ROJAS'   Then    'ELIAS'\n" +
                "WHEN pp.Agent =  'GUILLERMO CERA'   Then    'GUILLERMO'\n" +
                "WHEN pp.Agent =  'ISELA LOPEZ'   Then    'ISELA'\n" +
                "WHEN pp.Agent =  'ITZAE HERNANDEZ'   Then    'ITZAE'\n" +
                "WHEN pp.Agent =  'KEVIN ORTIZ'   Then    'KEVIN'\n" +
                "WHEN pp.Agent =  'LAURA DIAZ'   Then    'LAURA'\n" +
                "WHEN pp.Agent =  'MARIANA  BERNAL'   Then    'MARIANA'\n" +
                "WHEN pp.Agent =  'MAYRA MORALES'   Then    'MAYRA'\n" +
                "WHEN pp.Agent = 'NANCY MARTINEZ' THEN 'NANCY'\n" +
                "WHEN pp.Agent =  'OMAR GUTIERREZ'   Then    'OMAR'\n" +
                "WHEN pp.Agent =  'ROCIO  DUARTE NARVAEZ'   Then    'ROCIO'\n" +
                "WHEN pp.Agent =  'VIRIDIANA LOPEZ'   Then    'VIRIDIANA'\n" +
                "WHEN pp.Agent =  'VOX'   Then    'VOX'\n" +
                "WHEN pp.Agent = 'HUERTA FLORES YOHISKOOL YUZMARHA' THEN 'YOHISKOLL'\n" +
                "ELSE pp.Agent\n" +
                "END='"+agente+"'\n" +
                "AND r.[DPD]>-5\n" +
                "AND CAST([PromiseLimitDate] AS DATE) >DATEADD(day, -1, GETDATE())\n" +
                "ORDER BY DATEDIFF(DD, @Hoy, CONVERT(DATE,pp.PromiseDate)) DESC");
            ResultSet rs=ps.executeQuery();
            ArrayList<Promesa> lista=new ArrayList();
            while(rs.next()){
                Promesa promesa=new Promesa();
                promesa.setPago(rs.getString("PAGO"));
                promesa.setContrato(rs.getString("Contrato"));
                promesa.setNombreCte(rs.getString("NombreCliente"));
                promesa.setDiasPromesa(rs.getString("DiasPromesa_1"));
                promesa.setTelCte(rs.getString("NUMERO"));
                promesa.setAgente(rs.getString("AGENTE"));
                promesa.setCorreoCte(rs.getString("Correo"));
                promesa.setMontoPromesado(rs.getString("MontoPromesado"));
                promesa.setOxxoReference(rs.getString("OXXOReference"));
                promesa.setSpeiReference(rs.getString("SPEI"));
                promesa.setFechaPromesada(rs.getString("PROMESE_DATE"));
                promesa.setExtencion20(rs.getString("EXTENCION_20"));
                lista.add(promesa);
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
