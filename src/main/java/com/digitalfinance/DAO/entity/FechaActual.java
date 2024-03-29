/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.DAO.entity;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


public class FechaActual {
    public static String fechaActual(){
        // Definir el formato de la fecha
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Obtener la fecha y hora actual
        LocalDateTime fechaYHoraActual = LocalDateTime.now();
        // Convertir LocalDateTime a Date
        Date fechaComoDate = java.sql.Timestamp.valueOf(fechaYHoraActual);
        // Formatear la fecha y hora actual
        String requestDateTime = formato.format(fechaComoDate);
        return requestDateTime;
    }
}
