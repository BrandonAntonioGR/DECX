/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.DAO.entity;

import com.digitalfinance.properties.Propiedades;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class JsonCCCone {

    // Crear un objeto JSON con un array que contiene otro objeto JSON
    public static String jsonArrayJson(ArrayList<REF_GPT1> listaCargadosCCCone) throws IOException {
        // Crear un objeto JSON con la estructura modificada
        //POST Lead - New record
        // Crear el objeto ObjectMapper de Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        // Crear un objeto JSON principal
        ObjectNode objetoPrincipal = objectMapper.createObjectNode();

        //carga de el id de propiedades 
        Propiedades pr = new Propiedades();
        Properties propiedades = pr.cargarArchivobd();
        String idCampaign = propiedades.getProperty("campaniaId");

        // Agregar propiedades al objeto principal
        objetoPrincipal.put("campaign_id", idCampaign);
        // Crear un arreglo dentro del objeto principal
        ArrayNode arreglo = objetoPrincipal.putArray("Leads");
        for (int i = 0; i < listaCargadosCCCone.size(); i++) {
            // Crear un objeto JSON dentro del arreglo
            ObjectNode objetoEnArreglo = objectMapper.createObjectNode();
            objetoEnArreglo.put("NUMBER", listaCargadosCCCone.get(i).getNumber());
            objetoEnArreglo.put("DPD", listaCargadosCCCone.get(i).getDpd());
            objetoEnArreglo.put("TIPO_ASIGNACION", listaCargadosCCCone.get(i).getTipoCliente());
            objetoEnArreglo.put("ADEUDO", listaCargadosCCCone.get(i).getAdeudo());
            objetoEnArreglo.put("TEL", listaCargadosCCCone.get(i).getTel());
            objetoEnArreglo.put("CLIENT_FULL_NAME", listaCargadosCCCone.get(i).getClientFullName());
            objetoEnArreglo.put("ALGORITMO", listaCargadosCCCone.get(i).getAlgoritmo());
            // Agregar el objeto al arreglo
            arreglo.add(objetoEnArreglo);
        }

        // Convertir el objeto principal a formato JSON
        String jsonString = objetoPrincipal.toString();
        // Imprimir el JSON resultante
        return jsonString;
    }
}
