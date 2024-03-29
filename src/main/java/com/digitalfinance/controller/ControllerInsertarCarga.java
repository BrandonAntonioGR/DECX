/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.controller;

import com.digitalfinance.DAO.model.InsertarCargaCCCone;

/**
 *
 * @author Brandon Garduño
 */
public class ControllerInsertarCarga {
    public static boolean CargarCCCone(String contrato, String agente){
        return InsertarCargaCCCone.RegistrarUsuario(contrato, agente);
    }
}
