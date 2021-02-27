/*
    Asignatura: Algoritmos y Estructuras de Datos III
    Hecho por: Kevin Rojas y Nestor Aguilar
    C.I: 29.582.382 y 28.316.308
    Email: kevintrevor0905@gmail.com y 
 */
package Analizadores;
import Estructuras_de_Datos.*;
import java.io.File;
import java.util.Scanner;

/**
    @author Kevin Rojas and Nestor Aguilar
 */
public class LogicaPrincipal {
    /** Atributos de la clase Main*/
    public BloqueBMP bloqueDatos_BMP;
    public BloqueSueno bloqueDatos_Sueno;
    public BloquePasos bloqueDatos_Pasos;
    
    public ProcesamientoPasos analizador_Pasos;
    public ProcesamientoBMP analizador_BMP;
    public ProcesamientoSueno analizador_Sueno;
    
    public Cola cola_bloqueSueno;
    public Cola auxiliar_colaSueno;
    public Cola resultado_BMP;
    public Cola resultado_Pasos;
    public Cola resultado_Sueno;
 
    public int duracion_total_Suenos;
    public int total_duracion_Ligeros;
    public int total_duracion_Pesados;
    public int total_duracion_REM;
    public int duracion_ultimo_registro_enviado;
    public int dia;
    
    public LogicaPrincipal(){
        this.bloqueDatos_BMP = new BloqueBMP();
        this.bloqueDatos_Pasos = new BloquePasos();     
        this.bloqueDatos_Sueno = new BloqueSueno();
        
        this.analizador_BMP = new ProcesamientoBMP();
        this.analizador_Pasos = new ProcesamientoPasos();
        this.analizador_Sueno = new ProcesamientoSueno();
        
        this.auxiliar_colaSueno = new Cola();
        this.resultado_Sueno = new Cola();
        this.resultado_Pasos = new Cola();
        this.cola_bloqueSueno = new Cola();
        this.resultado_BMP = new Cola();
        
        
    }
    public void analisisSueno() throws Exception{
        if (this.analizador_Sueno.servidor_Ligeros.duracion_procesamiento == 0){
            this.auxiliar_colaSueno.encolar(this.analizador_Sueno.servidor_Ligeros.retirar());
        }
            
        if (this.analizador_Sueno.servidor_Pesados.duracion_procesamiento == 0){
            this.auxiliar_colaSueno.encolar(this.analizador_Sueno.servidor_Pesados.retirar());
        }
            
       if (this.analizador_Sueno.servidor_REM.duracion_procesamiento == 0){
            this.auxiliar_colaSueno.encolar(this.analizador_Sueno.servidor_REM.retirar());
        }
       
       this.analizador_Sueno.reducir_tiempoServidores();
       
       if (!this.analizador_Sueno.cola_sueno.esVacio()){
            this.analizador_Sueno.procesarSueno();
       }
    }
    public void analisisBMP() throws Exception{
        if (!this.analizador_BMP.servidor1.estaDisponible()){
            this.resultado_BMP.encolar(this.analizador_BMP.servidor1.retirar());
        }    
                            
        if (!this.analizador_BMP.servidor2.estaDisponible()){    
            this.resultado_BMP.encolar(this.analizador_BMP.servidor2.retirar());
        }    
                           
        if (!this.analizador_BMP.servidor3.estaDisponible()){    
            this.resultado_BMP.encolar(this.analizador_BMP.servidor3.retirar());
        }
        if (!this.analizador_BMP.cola_bmp.esVacio()){
            this.analizador_BMP.procesarBMP();
        }
    }
    
    public void analisisPasos() throws Exception{
        if (!this.analizador_Pasos.cola_procesamiento.esVacio()){
            this.resultado_Pasos.encolar(this.analizador_Pasos.procesarPasos());
        }
    }
    
    public void agregarBloques() throws Exception{
        this.analizador_Pasos.asignarDatos(this.bloqueDatos_Pasos);
        this.analizador_BMP.asignarDatos(this.bloqueDatos_BMP);
        this.cola_bloqueSueno.encolar(bloqueDatos_Sueno);
        
        if (this.analizador_Sueno.cola_sueno.esVacio()){
            this.analizador_Sueno.asignarDatos(cola_bloqueSueno.desencolar().info_bloqueSueno);
        }
    }
    
    public void contador_Suenos(Cola cola_suenos_analizada) throws Exception{
        this.dia = 0;
        this.duracion_total_Suenos = 0;
        this.total_duracion_Ligeros = 0;
        this.total_duracion_Pesados = 0;
        this.total_duracion_REM = 0;
        this.duracion_ultimo_registro_enviado = 0;
        
        while (!cola_suenos_analizada.esVacio()){
            DatosSueno sueno_analizado = cola_suenos_analizada.desencolar().info_sueno;
            
            if (cola_suenos_analizada.esVacio()){
                this.dia = sueno_analizado.dia;
                this.duracion_ultimo_registro_enviado = sueno_analizado.tiempo_total_dormido;
            }
            this.duracion_total_Suenos = this.duracion_total_Suenos + sueno_analizado.tiempo_total_dormido;
            
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
    
    public void iniciar_procesamiento() throws Exception {
        String archivo = "./data.txt";
        Scanner scan = new Scanner(new File(archivo));
        String analisis = null;
        
        while(scan.hasNext()) {
            String line = scan.nextLine();
            if ("BMP".equals(line) || "SUENO".equals(line) || "PASOS".equals(line) || "#".equals(line) 
                || "0 0".equals(line)){
                
                analisis = line;
                
                switch (analisis){
                    case "#":
                        this.agregarBloques();
                        for (int i = 0; i < 5; i++){
                            this.analisisBMP();
                            this.analisisSueno();
                            
                        }
                        break;
                    
                    case "0 0":
                        this.agregarBloques();
                        boolean terminado = false;
                        if (this.analizador_Sueno.cola_sueno.esVacio()){
                            this.analizador_Sueno.asignarDatos(cola_bloqueSueno.desencolar().info_bloqueSueno);
                        }    
                        while(!terminado){
                            
                            this.analisisBMP();
                            this.analisisSueno();
                            this.analisisPasos();
                            
                            if (this.analizador_Sueno.todos_servidoresDisponibles() && this.analizador_Sueno.cola_sueno.esVacio()){
                                Cola nueva_cola = new Cola();
                                while (!this.auxiliar_colaSueno.esVacio()){
                                    nueva_cola.encolar(this.auxiliar_colaSueno.desencolar().info_sueno);
                                }
                                this.resultado_Sueno.encolar(nueva_cola);
                                if (!this.cola_bloqueSueno.esVacio()){
                                    this.analizador_Sueno.asignarDatos(cola_bloqueSueno.desencolar().info_bloqueSueno);
                                }
                                else{
                                    terminado = true;
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
                        
                    default:
                        System.out.println("ERROR");
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
            System.out.println(this.dia+", "+this.duracion_total_Suenos+", "+this.total_duracion_Ligeros+", "+this.total_duracion_Pesados+", "+this.total_duracion_REM+", "+this.duracion_ultimo_registro_enviado);
        }
        System.out.println("\nBMP");
        String res_bmp = "";
        while (!this.resultado_BMP.esVacio()){
            int valor_bmp_resultado = this.resultado_BMP.desencolar().info_bmp.valor_bmp;
            if ("".equals(res_bmp)){
                res_bmp = "["+valor_bmp_resultado+", ";
            }
            else{
                if (!this.resultado_BMP.esVacio()){
                    res_bmp = res_bmp + valor_bmp_resultado + ", ";
                }
                else{
                    res_bmp = res_bmp + valor_bmp_resultado + "]";
                }
            }
        }
        System.out.println(res_bmp);
        
    }
    
    public static void main(String[] args) throws Exception{
        LogicaPrincipal main = new LogicaPrincipal();
        
        main.iniciar_procesamiento();
        
        main.imprimirResultado();
    }
}
