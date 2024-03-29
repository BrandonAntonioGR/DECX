/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.DAO.entity;

import org.json.JSONObject;

public class ObjetoJson {
    public static String objetoJson(){
        JSONObject jsonObject = new JSONObject();
        // Agregar datos al JSONObject
        jsonObject.put("string", "Ping");
        // Convertir JSONObject a String
        String jsonString = jsonObject.toString();
        //Retorna el Json a tipo de dato String 
        return jsonString;
    }
}
