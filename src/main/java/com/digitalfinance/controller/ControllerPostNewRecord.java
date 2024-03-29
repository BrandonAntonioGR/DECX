/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.controller;

import com.digitalfinance.DAO.entity.encriptadorSha256;
import com.digitalfinance.DAO.entity.JsonArrayJson;
import com.digitalfinance.DAO.entity.FechaActual;
import okhttp3.*;
import java.io.IOException; 


public class ControllerPostNewRecord {
    //Metodo Post     OkHttpClient  New Record
    public static void PostOkHttp(String number,String dpd,String tipoAsignacion,
            String adeudo,String tel,String nameClient,String algoritmo) throws IOException{ 
        encriptadorSha256 Sha256=new encriptadorSha256(); 
        //AuthUsername=user
        //String AuthUsername = "CCCWebServicesTestMode";//AuthUsername es usuario general
        String user="API-4FINANCE-2077";//usuario que se ocupara
        //String userId="2077";
        String userSecret="API4finance#Ccc).23";
        String Client_id="2077";
        String RequestDateTime = FechaActual.fechaActual();//"2024-03-08 10:00:00";
        
        //encriptando 
        String dataJsonArrayJson=JsonArrayJson.jsonArrayJson(number, dpd, tipoAsignacion, adeudo, tel, nameClient, algoritmo);
        String SecretHash=Sha256.sha256(userSecret); 
        String token1=Sha256.sha256(dataJsonArrayJson);
        String token2=Sha256.sha256(Client_id+":"+user+":"+SecretHash);
        String AuthToken=Sha256.sha256(token1+":"+token2+":"+RequestDateTime);
            
        // URL de la API a la que se hará la solicitud POST 
        String apiUrl = "https://api.ccc.uno/ws/Lead"; 
        //------------------------------------------------------------------------------
        // Crear un cliente OkHttp 
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("text/plain"); 
        // Crear el cuerpo de la solicitud POST 
        String requestBody ="AuthUsername = "+user+"\r\n"
                        + "AuthToken = "+AuthToken+"\r\n"
                        + "RequestDateTime = "+RequestDateTime+"\r\n"
                        + "Data = "+dataJsonArrayJson;
        RequestBody body = RequestBody.create(requestBody, mediaType);
        
        // Crear la solicitud POST 
        Request request = new Request.Builder()
            .url(apiUrl) 
            //.method("POST", body) ó .post(body)//es ugual pero mas reducido 
            .post(body)
            .addHeader("Content-Type", "text/plain") 
            .build(); 
        try {
            // Realizar la solicitud y obtener la respuesta 
            Response response = client.newCall(request).execute(); 
 
            // Obtener la respuesta 
            int statusCode = response.code(); 
            String responseBody = response.body().string(); 
            
            // Imprimir la respuesta en la consola 
            System.out.println("Código de estado: " + statusCode); 
            System.out.println("Cuerpo de la respuesta: " + responseBody); 
//            System.out.println("userSecret :" + userSecret); 
//            System.out.println("SecretHash :" + SecretHash); 
//            System.out.println("user :" + user); 
//            System.out.println("Client_id :" + Client_id); 
//            System.out.println("dataJsonArrayJson :" + dataJsonArrayJson); 
//            System.out.println("User :" + user);
//            System.out.println("Token 1 :" + token1);
//            System.out.println("Token 2 :" + token2);
//            System.out.println("AuthToken :" + AuthToken);
//            System.out.println("requestBodyok :" + requestBody);
//            System.out.println("request :" + request);

        } catch (IOException e) {
            e.printStackTrace(); 
        }
        //------------------------------------------------------------------------------
    }
}
