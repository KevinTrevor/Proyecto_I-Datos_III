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
public class BloqueSueno extends Bloque {
    /** Atributos de la Clase BloqueSueño*/
    String[] datos_Sueno;
    String[] datos_dia;
    int lleno = 0;
    
    @Override
    public void obtenerDatos(String datos){
        /** Método para obtener datos a traves de una cadena*/
        if (datos.length() > 7){
            this.datos_Sueno = datos.split(" ");
        } 
        else{
            this.datos_dia = datos.split(",");
        }
        
        this.lleno = 1;
    }
    
    public int getSize(){
        /** Método que devuelve el tamaño de datos_Sueno*/
        return this.datos_Sueno.length;
    }
}
