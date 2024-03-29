/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.controller;

import com.digitalfinance.view.AdminPlantillas;
import com.digitalfinance.view.AgregaPlantilla;
import com.digitalfinance.view.ExaminaPlantilla;
import com.digitalfinance.view.ModificaPlantilla;
import com.digitalfinance.view.Menu;
import com.digitalfinance.view.InicioSesion;
import com.digitalfinance.view.ViewMacro;
import com.digitalfinance.DAO.entity.Plantilla;
import java.sql.SQLException;


public class ControllerPantallas {
    public void InicioSesion(){
        InicioSesion login = new InicioSesion();
        login.setVisible(true);
        login.setResizable(false);
        login.setLocationRelativeTo(null);
    }
    public void Menu(String agente){
        Menu menu=new Menu(agente);
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        menu.setResizable(false);
    }
    public void Macro(String agente) throws SQLException{
        ViewMacro macro=new ViewMacro(agente);
        macro.setVisible(true);
        macro.setLocationRelativeTo(null);
        macro.setResizable(false);
    }
    public void AdministraPlantilla(String agente){
        AdminPlantillas mp= new AdminPlantillas(agente);
        mp.setVisible(true);
        mp.setLocationRelativeTo(null);
        mp.setResizable(false);
    }
    public void ExaminaPlantilla(Plantilla pl,String agente){
        ExaminaPlantilla ep= new ExaminaPlantilla(pl,agente);
        ep.setVisible(true);
        ep.setLocationRelativeTo(null);
        ep.setResizable(false);
    }
    public void AgregaPlantilla(String agente){
        AgregaPlantilla ap= new AgregaPlantilla(agente);
        ap.setVisible(true);
        ap.setLocationRelativeTo(null);
        ap.setResizable(false);
    }
    public void ModificaPlantilla(Plantilla pl,int i,String agente){
        ModificaPlantilla mp= new ModificaPlantilla(pl,i,agente);
        mp.setVisible(true);
        mp.setLocationRelativeTo(null);
        mp.setResizable(false);
    }
}
