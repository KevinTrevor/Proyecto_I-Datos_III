/*
    Asignatura: Algoritmos y Estructuras de Datos III
    Hecho por: Kevin Rojas y Nestor Aguilar
    C.I: 29.582.382 y 28.316.308
    Email: kevintrevor0905@gmail.com y nestor.gar22194@gmail.com
 */
package Analizadores;
import Estructuras_de_Datos.*;
/**
    @author Kevin Rojas and Nestor Aguilar
 */
public class ProcesamientoSueno{
    /** Atributos de la Clase RegistroSueño*/
    Dipolo cola_sueno;
    
    ServidorSueno servidor_Ligeros;
    ServidorSueno servidor_Pesados;
    ServidorSueno servidor_REM;
    
    public ProcesamientoSueno(){
        this.cola_sueno = new Dipolo();
        
        this.servidor_Ligeros = new ServidorSueno();
        this.servidor_Pesados = new ServidorSueno();
        this.servidor_REM = new ServidorSueno();
    }
    
    public boolean todos_servidoresDisponibles(){
        /** Método que retorno un booleano si los servidores están disponibles
         true si lo están
         false si no lo están*/
        return this.servidor_Ligeros.estaDisponible() && this.servidor_Pesados.estaDisponible() && this.servidor_REM.estaDisponible();
    }
    public void asignarDatos(BloqueSueno bloque) throws Exception{
        /** Método que transforma y asigna datos a los atributos*/
        int dia_inicio = Integer.parseInt(bloque.datos_dia[0].trim());
        
        for (int i = 0; i < bloque.getSize(); i++){
            DatosSueno nuevo_sueno = new DatosSueno();
            nuevo_sueno.ingresarDatos(bloque.datos_Sueno[i], dia_inicio);
            cola_sueno.encolarFondo(nuevo_sueno);
        }
    }
    
    public void procesarSueno() throws Exception{
        /** Método que procesa los DatosSueno dentro cola_sueno y los asigna a un servidor*/
        switch (this.cola_sueno.frente.info_sueno.tipo_de_sueno){
            case 1:
                if (this.servidor_Ligeros.estaDisponible()){
                    this.servidor_Ligeros.asignar(this.cola_sueno.desencolarFrente().info_sueno);
                }
                else{
                    this.cola_sueno.encolarFondo(this.cola_sueno.desencolarFrente().info_sueno);
                }
                break;
            
            case 2:
                if (this.servidor_Pesados.estaDisponible()){
                    this.servidor_Pesados.asignar(this.cola_sueno.desencolarFrente().info_sueno);
                }
                else{
                    this.cola_sueno.encolarFondo(this.cola_sueno.desencolarFrente().info_sueno);
                }
                break;
            
            case 3:
                if (this.servidor_REM.estaDisponible()){
                    this.servidor_REM.asignar(this.cola_sueno.desencolarFrente().info_sueno);
                }
                else{
                    this.cola_sueno.encolarFondo(this.cola_sueno.desencolarFrente().info_sueno);
                }
                break; 
        }
    }
    
    public void reducir_tiempoServidores(){
        /** Método que reduce el tiempo de los servidores en 1*/
        if (!this.servidor_Ligeros.estaDisponible()){
            if (this.servidor_Ligeros.duracion_procesamiento != 0){
                this.servidor_Ligeros.duracion_procesamiento--;
            }
        }
                            
        if (!this.servidor_Pesados.estaDisponible()){
            if (this.servidor_Pesados.duracion_procesamiento != 0){
                this.servidor_Pesados.duracion_procesamiento--;
            }
        }
                            
        if (!this.servidor_REM.estaDisponible()){
            if (this.servidor_REM.duracion_procesamiento != 0){
                this.servidor_REM.duracion_procesamiento--;
            }  
        }
    }
}
