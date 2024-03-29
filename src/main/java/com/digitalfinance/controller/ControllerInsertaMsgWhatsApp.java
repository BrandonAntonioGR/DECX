/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.controller;

import com.digitalfinance.DAO.model.InsertaCargaMsgWhatsApp;

public class ControllerInsertaMsgWhatsApp {
    public static boolean CargarMsgWhatsApp(String CreateDate, String Contrato,
             String Agente, String Enviado){
        return InsertaCargaMsgWhatsApp.RegistrarUsuario(CreateDate, Contrato, Agente, Enviado);
    }
}
