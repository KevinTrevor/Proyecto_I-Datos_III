/*
    Asignatura: Algoritmos y Estructuras de Datos III
    Hecho por: Kevin Rojas y Nestor Aguilar
    C.I: 29.582.382 y 28.316.308
    Email: kevintrevor0905@gmail.com y nestor.gar22194@gmail.com
 */
package Analizadores;

/**
    @author Kevin Rojas and Nestor Aguilar
 */
public class ServidorBMP extends Servidor{
    /** Atributos de la Clase ServidorBMP*/
    DatosBMP dato_procesar;
    int duracion_procesamiento;
    
    public ServidorBMP(){
        /** Método constructor de la Clase ServidorBMP*/
        this.dato_procesar = null;
        this.duracion_procesamiento = -1;
    }
    @Override
    public boolean estaDisponible(){
        /** Método que devuelve un valor booleano si el servidor está disponible
         true si lo está
         false si no lo está*/
        return this.dato_procesar == null;
    }
    
    public void asignar(DatosBMP ingreso){
        /** Método que asigna un valor DatosBMP al servidor y asigna su duración de procesamiento*/
        this.dato_procesar = ingreso;
        this.duracion_procesamiento = 1;
    }
    
    public DatosBMP retirar(){
        /** Método que retira (devuelve) el valor de dato_procesar 
         DatosBMP si hay uno 
         null si no lo hay*/
        DatosBMP retorno = this.dato_procesar;
        this.duracion_procesamiento = -1;
        this.dato_procesar = null;
        
        return retorno;
    }
}
