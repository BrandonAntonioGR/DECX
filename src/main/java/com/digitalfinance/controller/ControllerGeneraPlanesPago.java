/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 */
package com.digitalfinance.controller;

import com.digitalfinance.DAO.entity.Macro;
import com.digitalfinance.DAO.model.ConsultaCreaPromesaPago;
import com.digitalfinance.DAO.model.ConsultaGeneraPlanesPago;
/**
 *
 * @author Brandon Garduño
 */
public class ControllerGeneraPlanesPago {
    public Macro consultaCreaPromesaPago(String contrato){
        return ConsultaGeneraPlanesPago.consultaGeneraPlanesPago(contrato);
    }
}
