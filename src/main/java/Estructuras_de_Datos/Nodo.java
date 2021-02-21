package Estructuras_de_Datos;
import Analizadores.*;
/*
    Asignatura: Algoritmos y Estructuras de Datos III
    Hecho por: Kevin Rojas
    C.I: 29.582.382
    Email: kevintrevor0905@gmail.com
 */

/*
    @author Kevin Rojas
*/
public class Nodo {
    /** Atributos de la Clase Nodo */
    public Nodo siguiente;
    public DatosPasos info_pasos;
    public DatosBMP info_bmp;
    public DatosSueno info_sueno;

    /** Métodos de la Clase Nodo */
    public Nodo(){
        /** Método constructor de la Clase Nodo */
        info_pasos = null;
        info_sueno = null;
        info_bmp = null;
        siguiente = null;
    }
    
    public void ingresar(DatosBMP datos){
        info_bmp = datos;
    }
    
    public void ingresar(DatosSueno datos){
        info_sueno = datos;
    }
    
    public void ingresar(DatosPasos datos){
        info_pasos = datos;
    }
   
}    


