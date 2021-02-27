/*
    Asignatura: Algoritmos y Estructuras de Datos III
    Hecho por: Kevin Rojas y Nestor Aguilar
    C.I: 29.582.382 y 28.316.308
    Email: kevintrevor0905@gmail.com y nestor.gar22194@gmail.com
 */
package Analizadores;

/**
 *
 * @author Kevin Rojas and Nestor Aguilar
 */
public class BloquePasos extends Bloque{
    /** Atributos de la Clase BloquePasos*/
    String[] datos_Pasos;
    String[] datos_dia;
    
    @Override
    public void obtenerDatos(String datos){
        /** Método para obtener datos a traves de una cadena*/
        if (datos.length() > 7){
            this.datos_Pasos = datos.split(",");
        } 
        else {
            this.datos_dia = datos.split(",");
        }
    }
    
    public int getSize(){
        /** Método que retorna el tamaño del arreglo datos_Pasos*/
        return this.datos_Pasos.length;
    }
}
