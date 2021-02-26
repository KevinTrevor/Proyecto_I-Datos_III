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
    
    public ProcesamientoPasos analizador_Pasos = new ProcesamientoPasos();
    public ProcesamientoBMP analizador_BMP = new ProcesamientoBMP();
    public ProcesamientoSueno analizador_Sueno = new ProcesamientoSueno();
    
    public Cola cola_bloqueSueno = new Cola();
    public Cola resultado_BMP = new Cola();
    public Cola resultado_Pasos = new Cola();
    public Cola resultado_Sueno = new Cola(); 
    
    public int contador_global = 0;
            
    public void procesamiento_de_datos() throws Exception {
        Scanner scan = new Scanner(new File("./data.txt"));
        String analisis = null;
        
        
        while(scan.hasNext()) {
            String line = scan.nextLine();
            if ("BMP".equals(line) || "SUENO".equals(line) || "PASOS".equals(line) || "#".equals(line) || "0 0".equals(line)){
                analisis = line;
                
                switch (analisis){
                    case "#":
                        if (datos_Sueno.lleno == 1){
                            this.cola_bloqueSueno.encolar(datos_Sueno);
                            datos_Sueno.eliminarDatos();
                        }
                        
                        this.analizador_Pasos.asignarDatos(datos_Pasos);
                        this.analizador_BMP.asignarDatos(datos_BMP);
                        if (this.analizador_Sueno.cola_sueno.esVacio()){
                                this.analizador_Sueno.asignarDatos(cola_bloqueSueno.desencolar().info_bloqueSueno);
                            }
                        for (int i = 0; i < 5; i++){    
                            this.analizador_Sueno.procesarSueno();
                            
                            this.contador_global++;
                        }    
                      
                        
                        
                        break;
                        
                    case "0 0":
                        
                        this.analizador_Pasos.asignarDatos(datos_Pasos);
                        
                        while (!analizador_Pasos.cola_procesamiento.esVacio()){
                            resultado_Pasos.encolar(this.analizador_Pasos.procesarPasos());
                            
                            this.contador_global++;
                        }
                        
                        System.out.println("PASOS");
                        while (!this.resultado_Pasos.esVacio()){
                            Nodo res = this.resultado_Pasos.desencolar();
                            System.out.println(res.info_pasos.dia +", "+res.info_pasos.pasos_dados+", "+res.info_pasos.mejor_diaAnterior);
                        }
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
   
