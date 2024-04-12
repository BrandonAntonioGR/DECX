/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.DAO.entity;

import java.sql.Date;

public class PromesaPago {
    private String contrato;
    private String dpd;
    private String algoritmo;
    private String contactDate;
    private String promiseDate;
    private String promiseLimitDate;
    private double promiseAmount;
    private String agente;
    private String promiseType;
    private String canal;
    private String contacto;
    private String medioContacto;
    private String comentarios;

    public PromesaPago() {
    }

    public PromesaPago(String contrato, String dpd, String algoritmo, String contactDate, String promiseDate, String promiseLimitDate, double promiseAmount, String agente, String promiseType, String canal, String contacto, String medioContacto, String comentarios) {
        this.contrato = contrato;
        this.dpd = dpd;
        this.algoritmo = algoritmo;
        this.contactDate = contactDate;
        this.promiseDate = promiseDate;
        this.promiseLimitDate = promiseLimitDate;
        this.promiseAmount = promiseAmount;
        this.agente = agente;
        this.promiseType = promiseType;
        this.canal = canal;
        this.contacto = contacto;
        this.medioContacto = medioContacto;
        this.comentarios = comentarios;
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

    public String getContactDate() {
        return contactDate;
    }

    public void setContactDate(String contactDate) {
        this.contactDate = contactDate;
    }

    public String getPromiseDate() {
        return promiseDate;
    }

    public void setPromiseDate(String promiseDate) {
        this.promiseDate = promiseDate;
    }

    public String getPromiseLimitDate() {
        return promiseLimitDate;
    }

    public void setPromiseLimitDate(String promiseLimitDate) {
        this.promiseLimitDate = promiseLimitDate;
    }

    public double getPromiseAmount() {
        return promiseAmount;
    }

    public void setPromiseAmount(double promiseAmount) {
        this.promiseAmount = promiseAmount;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getPromiseType() {
        return promiseType;
    }

    public void setPromiseType(String promiseType) {
        this.promiseType = promiseType;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getMedioContacto() {
        return medioContacto;
    }

    public void setMedioContacto(String medioContacto) {
        this.medioContacto = medioContacto;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    
}
