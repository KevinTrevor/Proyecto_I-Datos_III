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
public class DatosPasos extends Datos{
    /** Atributos de la Clase DatosPasos*/
    int pasos_dados;
    int dia;
    int mejor_diaAnterior;
    String unidad;
   
    public DatosPasos(){
        /** Método constructor de la Clase DatosPasos*/
        this.pasos_dados = 0;
        this.dia = 0;
        this.mejor_diaAnterior = -1;
        this.unidad = "pasos";
    }
    
    
    @Override
    public void ingresarDatos(String datos, int dia){
        /** Método que transforma y asigna datos a los atributos*/
        this.pasos_dados = Integer.parseInt(datos);
        this.dia = dia;
    }
}
