/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.controller;

import com.digitalfinance.DAO.entity.Macro;
import com.digitalfinance.DAO.model.ConsultaCargadosCCCone;
import java.util.ArrayList;

public class ControllerCCCone {
    public ArrayList<Macro> consultaCCCone(String agente){
        return  ConsultaCargadosCCCone.consultaCargadosCCConeAsc(agente);
    }
//    public ArrayList<Macro> consultaMacroDesc(String agente){
//        return  ConsultaCargadosCCCone.consultaCargadosCCConeDesc(agente);
//    }
}
