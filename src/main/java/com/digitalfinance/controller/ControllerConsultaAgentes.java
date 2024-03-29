/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.controller;

import com.digitalfinance.DAO.entity.Agente;
import com.digitalfinance.DAO.model.ConsultarUsuarioAgente;
import java.util.ArrayList;

/**
 *
 * @author Brandon Garduño
 */
public class ControllerConsultaAgentes {
    public ArrayList<Agente> consultaUsuariogente(){
        return  ConsultarUsuarioAgente.consultaUsuariosAgentes();
    }
}
