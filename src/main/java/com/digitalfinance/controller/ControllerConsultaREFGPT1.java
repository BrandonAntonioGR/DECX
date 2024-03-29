/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.controller;

import com.digitalfinance.DAO.entity.REF_GPT1;
import com.digitalfinance.DAO.model.ConsultarREFGPT1;
import java.util.ArrayList;


public class ControllerConsultaREFGPT1 {
    public ArrayList<REF_GPT1> consultaREFGPT1(String numeroContrato){
        return  ConsultarREFGPT1.consultaREFGPT1(numeroContrato);
    }
    public ArrayList<REF_GPT1> consultaREFGPT1Tel(String telefono){
        return  ConsultarREFGPT1.consultaREFGPT1Tel(telefono);
    }
}
