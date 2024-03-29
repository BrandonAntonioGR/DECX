/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.DAO.entity;


public class Promesa {
    String pago;
    String contrato;
    String nombreCte;
    String diasPromesa;
    String telCte;
    String agente;
    String correoCte;
    String montoPromesado;
    String oxxoReference;
    String speiReference;
    String fechaPromesada;
    String extencion20;

    public Promesa() {
    }

    public Promesa(String pago, String contrato, String nombreCte, String diasPromesa, String telCte, String agente, String correoCte, String montoPromesado, String oxxoReference, String speiReference, String fechaPromesada, String extencion20) {
        this.pago = pago;
        this.contrato = contrato;
        this.nombreCte = nombreCte;
        this.diasPromesa = diasPromesa;
        this.telCte = telCte;
        this.agente = agente;
        this.correoCte = correoCte;
        this.montoPromesado = montoPromesado;
        this.oxxoReference = oxxoReference;
        this.speiReference = speiReference;
        this.fechaPromesada = fechaPromesada;
        this.extencion20 = extencion20;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getNombreCte() {
        return nombreCte;
    }

    public void setNombreCte(String nombreCte) {
        this.nombreCte = nombreCte;
    }

    public String getDiasPromesa() {
        return diasPromesa;
    }

    public void setDiasPromesa(String diasPromesa) {
        this.diasPromesa = diasPromesa;
    }

    public String getTelCte() {
        return telCte;
    }

    public void setTelCte(String telCte) {
        this.telCte = telCte;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getCorreoCte() {
        return correoCte;
    }

    public void setCorreoCte(String correoCte) {
        this.correoCte = correoCte;
    }

    public String getMontoPromesado() {
        return montoPromesado;
    }

    public void setMontoPromesado(String montoPromesado) {
        this.montoPromesado = montoPromesado;
    }

    public String getOxxoReference() {
        return oxxoReference;
    }

    public void setOxxoReference(String oxxoReference) {
        this.oxxoReference = oxxoReference;
    }

    public String getSpeiReference() {
        return speiReference;
    }

    public void setSpeiReference(String speiReference) {
        this.speiReference = speiReference;
    }

    public String getFechaPromesada() {
        return fechaPromesada;
    }

    public void setFechaPromesada(String fechaPromesada) {
        this.fechaPromesada = fechaPromesada;
    }

    public String getExtencion20() {
        return extencion20;
    }

    public void setExtencion20(String extencion20) {
        this.extencion20 = extencion20;
    }

    
}
