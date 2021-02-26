package Analizadores;

import Estructuras_de_Datos.*;
import java.io.File;
import java.util.Scanner;

/**
    @author Kevin Rojas
 */
public class Main {
    /** Atributos de la clase Main*/
    public BloqueBMP bloqueDatos_BMP;
    public BloqueSueno bloqueDatos_Sueno;
    public BloquePasos bloqueDatos_Pasos;
    
    public ProcesamientoPasos analizador_Pasos = new ProcesamientoPasos();
    public ProcesamientoBMP analizador_BMP = new ProcesamientoBMP();
    public ProcesamientoSueno analizador_Sueno = new ProcesamientoSueno();
    
    public Cola cola_bloqueSueno = new Cola();
    public Cola resultado_BMP = new Cola();
    public Cola resultado_Pasos = new Cola();
    public Cola resultado_Sueno = new Cola(); 
    
    public int total_duracion_Ligeros;
    public int total_duracion_Pesados;
    public int total_duracion_REM;
    public int duracion_ultimo_registro_enviado;
    public int dia;
    
    public Main(){
        this.bloqueDatos_BMP = new BloqueBMP();
        this.bloqueDatos_Pasos = new BloquePasos();     
        this.bloqueDatos_Sueno = new BloqueSueno();
        
        this.analizador_BMP = new ProcesamientoBMP();
        this.analizador_Pasos = new ProcesamientoPasos();
        this.analizador_Sueno = new ProcesamientoSueno();
        
        this.dia = 0;
        this.total_duracion_Ligeros = 0;
        this.total_duracion_Pesados = 0;
        this.total_duracion_REM = 0;
        this.duracion_ultimo_registro_enviado = 0;
    }
    
    public void contador_Suenos(Cola cola_suenos_analizada) throws Exception{
        this.total_duracion_Ligeros = 0;
        this.total_duracion_Pesados = 0;
        this.total_duracion_REM = 0;
        this.duracion_ultimo_registro_enviado = 0;
        System.out.println(cola_suenos_analizada.size);
        while (!cola_suenos_analizada.esVacio()){
            DatosSueno sueno_analizado = cola_suenos_analizada.desencolar().info_sueno;
            System.out.println(sueno_analizado.tipo_de_sueno);
            
            switch (sueno_analizado.tipo_de_sueno){
                case 1:
                    this.total_duracion_Ligeros = this.total_duracion_Ligeros + sueno_analizado.tiempo_total_dormido;
                    break;
                
                case 2:
                    this.total_duracion_Pesados = this.total_duracion_Pesados + sueno_analizado.tiempo_total_dormido;
                    break;
                    
                case 3:
                    this.total_duracion_REM = this.total_duracion_REM + sueno_analizado.tiempo_total_dormido;
                    break;
            }
        }
    }
    
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
                        }    
                        break;
                        
                    case "0 0":
                        Cola cola_respuesta_Sueno = new Cola();
                        this.analizador_Pasos.asignarDatos(bloqueDatos_Pasos);
                        this.analizador_BMP.asignarDatos(bloqueDatos_BMP);
                        this.cola_bloqueSueno.encolar(bloqueDatos_Sueno);
                        
                        while (!this.cola_bloqueSueno.esVacio()){
                            /* Disminución de minutos en los servidores*/
                            if (!this.analizador_BMP.servidor1.estaDisponible()){
                                this.resultado_BMP.encolar(this.analizador_BMP.servidor1.retirar());
                            }    
                            
                            if (!this.analizador_BMP.servidor2.estaDisponible()){    
                                this.resultado_BMP.encolar(this.analizador_BMP.servidor2.retirar());
                            }    
                            
                            if (!this.analizador_BMP.servidor3.estaDisponible()){    
                                this.resultado_BMP.encolar(this.analizador_BMP.servidor3.retirar());
                            }
                            
                            if (!this.analizador_Sueno.servidor_Ligeros.estaDisponible()){
                                if (this.analizador_Sueno.servidor_Ligeros.duracion_procesamiento != 0){
                                    this.analizador_Sueno.servidor_Ligeros.duracion_procesamiento--;
                                }
                                else{
                                    cola_respuesta_Sueno.encolar(this.analizador_Sueno.servidor_Ligeros.retirar());
                                }
                            }
                            
                            if (!this.analizador_Sueno.servidor_Pesados.estaDisponible()){
                                if (this.analizador_Sueno.servidor_Pesados.duracion_procesamiento != 0){
                                    this.analizador_Sueno.servidor_Pesados.duracion_procesamiento--;
                                }
                                else{
                                    cola_respuesta_Sueno.encolar(this.analizador_Sueno.servidor_Pesados.retirar());
                                }
                            }
                            
                            if (!this.analizador_Sueno.servidor_REM.estaDisponible()){
                                if (this.analizador_Sueno.servidor_REM.duracion_procesamiento != 0){
                                    this.analizador_Sueno.servidor_REM.duracion_procesamiento--;
                                }
                                else{
                                    cola_respuesta_Sueno.encolar(this.analizador_Sueno.servidor_REM.retirar());
                                }
                            }
                            
                            /* Procesamiento de los bloques de datos */
                            if (!this.analizador_Pasos.cola_procesamiento.esVacio()){
                                this.resultado_Pasos.encolar(this.analizador_Pasos.procesarPasos());
                            }
                            if (!this.analizador_Sueno.cola_sueno.esVacio()){
                                this.analizador_Sueno.procesarSueno();
                            }
                            if (!this.analizador_BMP.cola_bmp.esVacio()){
                                this.analizador_BMP.procesarBMP();
                            }
                            
                            if (this.analizador_Sueno.todos_servidoresDisponibles() && this.analizador_Sueno.cola_sueno.esVacio()){
                                this.resultado_Sueno.encolar(cola_respuesta_Sueno);
                                if (!this.cola_bloqueSueno.esVacio()){
                                    this.analizador_Sueno.asignarDatos(this.cola_bloqueSueno.desencolar().info_bloqueSueno);
                                }
                            }
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
        while (!this.resultado_Sueno.esVacio()){
            this.contador_Suenos(resultado_Sueno.desencolar().info_cola);
            System.out.println(this.dia+", "+this.total_duracion_Ligeros+", "+this.total_duracion_Pesados+", "+this.total_duracion_REM+", "+this.duracion_ultimo_registro_enviado);
        }
        System.out.println("\nBMP");
        
    }
    
    public static void main(String[] args) throws Exception{
        Main app = new Main();
        
        app.procesamiento_de_datos();
        
        app.imprimirResultado();
    }
}
   
