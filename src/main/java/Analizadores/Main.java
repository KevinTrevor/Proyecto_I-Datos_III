package Analizadores;

import Estructuras_de_Datos.*;
import java.io.File;
import java.util.Scanner;

/**
    @author Kevin Rojas
 */
public class Main {
    public BloqueBMP bloqueDatos_BMP = new BloqueBMP();
    public BloqueSueno bloqueDatos_Sueno = new BloqueSueno();
    public BloquePasos bloqueDatos_Pasos = new BloquePasos();
    
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
                        if (bloqueDatos_Sueno.lleno == 1){
                            this.cola_bloqueSueno.encolar(bloqueDatos_Sueno);
                            bloqueDatos_Sueno.eliminarDatos();
                        }
                        
                        this.analizador_Pasos.asignarDatos(bloqueDatos_Pasos);
                        this.analizador_BMP.asignarDatos(bloqueDatos_BMP);
                        
                        if (this.analizador_Sueno.cola_sueno.esVacio()){
                                this.analizador_Sueno.asignarDatos(cola_bloqueSueno.desencolar().info_bloqueSueno);
                            }
                        for (int i = 0; i < 5; i++){
                            if (!this.analizador_BMP.servidor1.estaDisponible()){
                                this.resultado_BMP.encolar(this.analizador_BMP.servidor1.retirar());
                            }    
                            
                            if (!this.analizador_BMP.servidor2.estaDisponible()){    
                                this.resultado_BMP.encolar(this.analizador_BMP.servidor2.retirar());
                            }    
                            if (!this.analizador_BMP.servidor3.estaDisponible()){    
                                this.resultado_BMP.encolar(this.analizador_BMP.servidor3.retirar());
                            }
                            
                            this.analizador_Sueno.procesarSueno();
                            
                            if (!this.analizador_BMP.cola_bmp.esVacio()){
                                this.analizador_BMP.procesarBMP();
                            }
                            
                            this.contador_global++;
                        }    
                      
                        
                        
                        break;
                        
                    case "0 0":
                        boolean bandera = true;
                        this.analizador_Pasos.asignarDatos(bloqueDatos_Pasos);
                        
                        while (bandera){
                            if (!this.analizador_BMP.servidor1.estaDisponible()){
                                this.resultado_BMP.encolar(this.analizador_BMP.servidor1.retirar());
                            }    
                            if (!this.analizador_BMP.servidor2.estaDisponible()){    
                                this.resultado_BMP.encolar(this.analizador_BMP.servidor2.retirar());
                            }    
                            if (!this.analizador_BMP.servidor3.estaDisponible()){    
                                this.resultado_BMP.encolar(this.analizador_BMP.servidor3.retirar());
                            }
                            
                            this.resultado_Pasos.encolar(this.analizador_Pasos.procesarPasos());
                            this.analizador_Sueno.procesarSueno();
                            this.analizador_BMP.procesarBMP();
                            
                            this.contador_global++;
                        }
                        break;
                }                
            }
            else{
                switch (analisis){
                    case "BMP":
                        this.bloqueDatos_BMP.obtenerDatos(line);
                        break;
                    
                    case "SUENO":
                        this.bloqueDatos_Sueno.obtenerDatos(line);
                        break;
                    
                    case "PASOS": 
                       
                        this.bloqueDatos_Pasos.obtenerDatos(line);
                        break;
                }
            }
        }
    }
    
    public void imprimirResultado() throws Exception{
        System.out.println("PASOS");
        while (!this.resultado_Pasos.esVacio()){
            Nodo res = this.resultado_Pasos.desencolar();
            System.out.println(res.info_pasos.dia +", "+res.info_pasos.pasos_dados+", "+res.info_pasos.mejor_diaAnterior);
        }
        System.out.println("\nSUENO");
        
        System.out.println("\nBMP");
        
    }
    
    public static void main(String[] args) throws Exception{
        Main app = new Main();
        
        app.procesamiento_de_datos();
        
        app.imprimirResultado();
    }
}
   
