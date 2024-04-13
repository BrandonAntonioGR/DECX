/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.digitalfinance.plantilla;

import com.digitalfinance.controller.ControllerPantallas;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.sql.SQLException;


//@author Brandon Antonio Garduño Rubio
public class Plantilla {
    public static void main(String[] args) throws CsvException, IOException, SQLException {
        ControllerPantallas cp= new ControllerPantallas();        
//        cp.agregaPromesaPago("MARIANA");
//        cp.InicioSesion();
        cp.Macro("MARIANA");
    }
}
