package Analizadores;

import Estructuras_de_Datos.*;
import java.io.File;
import java.util.Scanner;

/**
    @author Kevin Rojas
 */
public class Main {
    public BloqueBMP datos_BMP = new BloqueBMP();
    public BloqueSueno datos_Sueno = new BloqueSueno();
    public BloquePasos datos_Pasos = new BloquePasos();
    public RegistroPasos registrador_Pasos = new RegistroPasos();
    public RegistroBMP registrador_BMP = new RegistroBMP();
    public RegistroSueno registrador_Sueno = new RegistroSueno();
   
    public void procesamiento_de_datos() throws Exception {
        Scanner scan = new Scanner(new File("./data.txt"));
        String analisis = null;
        
        
        while(scan.hasNext()) {
            String line = scan.nextLine();
            if ("BMP".equals(line) || "SUENO".equals(line) || "PASOS".equals(line) || "#".equals(line) || "0 0".equals(line)){
                analisis = line;
                
                switch (analisis){
                    case "#":
                        this.registrador_BMP.asignarDatos(datos_BMP);
                        this.registrador_Pasos.asignarDatos(datos_Pasos);
                        this.registrador_Sueno.asignarDatos(datos_Sueno);
                        
                        while (!this.registrador_Pasos.pila_pasos.esVacio()){
                            this.registrador_Pasos.procesamientoPasos();
                        }
                        
                        
                        while (!this.registrador_Pasos.historial.esVacio()){
                            Nodo res = this.registrador_Pasos.historial.desencolar();
                            System.out.println(res.info_pasos.dia +", "+res.info_pasos.pasos_dados+", "+res.info_pasos.mejor_diaAnterior);
                        }
                        break;
                    case "0 0":
                        System.out.println("Fin");
                        System.out.println(line);
                        break;
                }                
            }
            else{
                switch (analisis){
                    case "BMP":
                        
                        this.datos_BMP.obtenerDatos(line);
                        break;
                    
                    case "SUENO":
                        
                        this.datos_Sueno.obtenerDatos(line);
                        break;
                    
                    case "PASOS": 
                       
                        this.datos_Pasos.obtenerDatos(line);
                        break;
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        Main app = new Main();
        
        app.procesamiento_de_datos();
    }
}
   
