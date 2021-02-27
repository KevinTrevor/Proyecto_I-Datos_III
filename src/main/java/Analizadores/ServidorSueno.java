/*
    Asignatura: Algoritmos y Estructuras de Datos III
    Hecho por: Kevin Rojas y Nestor Aguilar
    C.I: 29.582.382 y 28.316.308
    Email: kevintrevor0905@gmail.com y 
 */
package Analizadores;

/**
    @author Kevin Rojas and Nestor Aguilar
 */
public class ServidorSueno extends Servidor{
    /**Atributos de la Clase ServidorSueno*/
    DatosSueno dato_procesar;
    int duracion_procesamiento;
    
    public ServidorSueno(){
        /** Método constructor de la clase ServidorSueno*/
        this.dato_procesar = null;
        this.duracion_procesamiento = -1;
    }
    
    @Override
    public boolean estaDisponible(){
        /** Método que devuelve un boolean si la cola esta disponible
         true si está disponible
         false si no lo está*/
        return this.dato_procesar == null;
    }
    
    public void asignar(DatosSueno ingreso){
        /** Método que asigna el valor que se pasa por parametro y calcula la duración de su procesamiento */
        this.dato_procesar = ingreso;
        this.duracion_procesamiento = (int) Math.ceil(ingreso.tiempo_total_dormido / 8); 
    }
    
    public DatosSueno retirar(){
        /** Método que retira (devuelve) el valor deñ dato procesado
         DatosSueno si hay un elemento en el servidor
         null si no lo hay*/
        
        DatosSueno retorno = this.dato_procesar;
        this.duracion_procesamiento = -1;
        this.dato_procesar = null;
        
        return retorno;
    } 
}
