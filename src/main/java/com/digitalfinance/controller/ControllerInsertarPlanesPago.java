/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.controller;

import com.digitalfinance.DAO.entity.PlanesPago;
import com.digitalfinance.DAO.model.InsertaPlanesPago;
import com.digitalfinance.DAO.model.InsertarCargaCCCone;
import java.util.ArrayList;

/**
 *
 * @author Brandon Garduño
 */
public class ControllerInsertarPlanesPago {
    public static boolean CargarPlanPago(ArrayList<PlanesPago> listaPlanesPago){
        return InsertaPlanesPago.RegistrarPlanPago(listaPlanesPago);
    }
}
