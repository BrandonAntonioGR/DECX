package com.digitalfinance.DAO.model;

import java.sql.Connection;
import java.sql.DriverManager;


public class ModelConection {
    public static Connection getConnection(){
        Connection con;
        try{
            String url2="jdbc:sqlserver://192.168.1.38\\SQLEXPRESS;"
                    + "databaseName=DC REPORT;"
                    + "user=jcruz1;"
                    + "password=Jcruz*23;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;";
            con=DriverManager.getConnection(url2);
            System.out.print("Conectado!");
            return con;
        }catch(Exception e){
            System.out.print("No conectado "+e);
            return null;
        }
    }
}
