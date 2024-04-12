/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.controller;

import com.digitalfinance.DAO.entity.PromesaPago;
import com.digitalfinance.DAO.model.InsertaPromesaPago;
import com.digitalfinance.DAO.model.InsertarCargaCCCone;

/**
 *
 * @author Brandon Garduño
 */
public class ControllerInsertarPromesaPago {
    public static boolean CargarPromesaPago(PromesaPago promesaPago){
        return InsertaPromesaPago.RegistrarPromesaPago(promesaPago);
    }
}
