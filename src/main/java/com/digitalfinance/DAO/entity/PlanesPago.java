/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.DAO.entity;

import java.sql.Date;

public class PlanesPago{
    private String contrato;
    private String dpd;
    private String algoritmo;
    private String agente;
    private String adeudo;
    private String fecuencia;
    private int plazos;
    private String tipoMonto;
    private String montoPlan;
    private String fechaPagoPlan;
    private String statusPlan;
    private String creationDay;

    public PlanesPago() {
    }

    public PlanesPago(String contrato, String dpd, String algoritmo, 
            String agente, String adeudo, String fecuencia, int plazos, 
            String tipoMonto, String montoPlan, String fechaPagoPlan, 
            String statusPlan, String creationDay) {
        this.contrato = contrato;
        this.dpd = dpd;
        this.algoritmo = algoritmo;
        this.agente = agente;
        this.adeudo = adeudo;
        this.fecuencia = fecuencia;
        this.plazos = plazos;
        this.tipoMonto = tipoMonto;
        this.montoPlan = montoPlan;
        this.fechaPagoPlan = fechaPagoPlan;
        this.statusPlan = statusPlan;
        this.creationDay = creationDay;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getDpd() {
        return dpd;
    }

    public void setDpd(String dpd) {
        this.dpd = dpd;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getAdeudo() {
        return adeudo;
    }

    public void setAdeudo(String adeudo) {
        this.adeudo = adeudo;
    }

    public String getFecuencia() {
        return fecuencia;
    }

    public void setFecuencia(String fecuencia) {
        this.fecuencia = fecuencia;
    }

    public int getPlazos() {
        return plazos;
    }

    public void setPlazos(int plazos) {
        this.plazos = plazos;
    }

    public String getTipoMonto() {
        return tipoMonto;
    }

    public void setTipoMonto(String tipoMonto) {
        this.tipoMonto = tipoMonto;
    }

    public String getMontoPlan() {
        return montoPlan;
    }

    public void setMontoPlan(String montoPlan) {
        this.montoPlan = montoPlan;
    }

    public String getFechaPagoPlan() {
        return fechaPagoPlan;
    }

    public void setFechaPagoPlan(String fechaPagoPlan) {
        this.fechaPagoPlan = fechaPagoPlan;
    }

    public String getStatusPlan() {
        return statusPlan;
    }

    public void setStatusPlan(String statusPlan) {
        this.statusPlan = statusPlan;
    }

    public String getCreationDay() {
        return creationDay;
    }

    public void setCreationDay(String creationDay) {
        this.creationDay = creationDay;
    }

            
}
