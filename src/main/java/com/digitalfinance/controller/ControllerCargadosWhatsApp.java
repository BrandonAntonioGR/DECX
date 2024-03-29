/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.controller;

import com.digitalfinance.DAO.entity.Macro;
import com.digitalfinance.DAO.model.ConsultaCargadosWhatsApp;
import java.util.ArrayList;

public class ControllerCargadosWhatsApp {
    public ArrayList<Macro> consultaCargadosWhatsapp(String agente){//String agente,String dpd,String algoritmo
        return  ConsultaCargadosWhatsApp.consultaCargadosCCConeAsc(agente);
    }
}
