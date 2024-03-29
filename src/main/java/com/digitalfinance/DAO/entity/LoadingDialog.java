/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.DAO.entity;

import javax.swing.*;

/**
 *
 * @author Brandon Garduño
 */
public class LoadingDialog extends JDialog{
    public LoadingDialog(JFrame parent) {
        super(parent, "Cargando", true);
        JLabel label = new JLabel("Cargando, por favor espere...");
        getContentPane().add(label);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(300, 100);
        setLocationRelativeTo(parent);
    }
}
