/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.controller;

import com.digitalfinance.DAO.entity.Algoritmo;
import com.digitalfinance.DAO.entity.Dpd;
import com.digitalfinance.DAO.entity.Macro;
import com.digitalfinance.DAO.model.ConsultaMacro;
import java.util.ArrayList;


public class ControllerMacro {
    public ArrayList<Macro> consultaMacroAsc(String agente,String dpd,String algoritmo){
        return  ConsultaMacro.consultaMacroDpdAsc(agente, dpd, algoritmo);
    }
    public ArrayList<Macro> consultaMacroDesc(String agente,String dpd,String algoritmo){
        return  ConsultaMacro.consultaMacroDpdDesc(agente, dpd, algoritmo);
    }
    
    public ArrayList<Dpd> consultaDpdComboBox(String agente ){
        return  ConsultaMacro.consultaDpdsDisponibles(agente);
    }
    public ArrayList<Algoritmo> consultaAlgoritmoComboBox(String agente){
        return  ConsultaMacro.consultaAlgoritmosDisponibles(agente);
    }
}
