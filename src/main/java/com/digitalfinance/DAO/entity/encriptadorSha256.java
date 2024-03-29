/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.DAO.entity;

import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class encriptadorSha256 {
    
      public String sha256(String mensaje){ 
        try{ 
            MessageDigest sha=MessageDigest.getInstance("SHA-256"); 
            byte [] digest=sha.digest(mensaje.getBytes()); 
             
            StringBuilder hexString=new StringBuilder(); 
            for(byte b:digest){ 
                hexString.append(String.format("%02x", b)); 
            } 
            return hexString.toString(); 
        }catch(NoSuchAlgorithmException ex){ 
            throw new RuntimeException(ex); 
        } 
    } 
}
