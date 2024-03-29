/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.controller;

import com.digitalfinance.DAO.entity.Promesa;
import com.digitalfinance.DAO.model.ConsultaPromesados;
import java.util.ArrayList;


public class ControllerPromesados {
    public ArrayList<Promesa> consultaPromesados(String agente,String DiasPromesa){
        return  ConsultaPromesados.consultaPromesados(agente, DiasPromesa);
    }
    public ArrayList<Promesa> consultaPromesados(String agente){
        return  ConsultaPromesados.consultaPromesados(agente);
    }
}
