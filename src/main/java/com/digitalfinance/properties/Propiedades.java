package com.digitalfinance.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propiedades {
    public Properties cargarArchivobd() throws FileNotFoundException, IOException{
        Properties propiedades = new Properties();
        String directorioActual = System.getProperty("user.dir");
        //descomentar cuando se desarrole en netbeans
//        String rutacampaniaId="C:\\Users\\Brandon Garduño\\Documents\\NetBeansProjects\\Plantilla\\src\\main\\java\\com\\digitalfinance\\DAO\\resources\\campaniaId.properties";
        //descomente cuando se despliegue la aplicacion
        String rutacampaniaId=directorioActual+"\\campaniaId.properties";
        InputStream archivo = new FileInputStream(rutacampaniaId);
        propiedades.load(archivo);
        return propiedades;
    }
}