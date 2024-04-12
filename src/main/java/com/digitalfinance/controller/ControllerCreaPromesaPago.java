/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 */
package com.digitalfinance.controller;

import com.digitalfinance.DAO.entity.Macro;
import com.digitalfinance.DAO.model.ConsultaCreaPromesaPago;
/**
 *
 * @author Brandon Garduño
 */
public class ControllerCreaPromesaPago {
    public Macro consultaCreaPromesaPago(String contrato){
        return ConsultaCreaPromesaPago.consultaCreaPromesa(contrato);
    }
}
