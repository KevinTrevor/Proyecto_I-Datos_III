/*
    Asignatura: Algoritmos y Estructuras de Datos III
    Hecho por: Kevin Rojas y Nestor Aguilar
    C.I: 29.582.382 y 28.316.308
    Email: kevintrevor0905@gmail.com y 
 */
package Analizadores;

import Estructuras_de_Datos.Cola;

/**
    @author Kevin Rojas and Nestor Aguilar
 */
public class DatosSueno extends Datos{
    /** Atributos de la Clase DatosSueño*/
    public int tiempo_inicio;
    public int tiempo_fin;
    public int tipo_de_sueno;
    public int dia;
    public int tiempo_total_dormido;
    String unidad;
    
    public DatosSueno(){
        /** Método constructor de la Clase DatosSueño*/
        this.tiempo_inicio = -1;
        this.tiempo_fin = -1;
        this.tipo_de_sueno = -1;
        this.dia = -1;
        this.tiempo_total_dormido = -1;
        this.unidad = "sueño";
    }
    
    private int calcularTiempoTotal(){
        int resultado = 0;
        int contador = this.tiempo_inicio;
        
        while (contador != this.tiempo_fin){
            if (contador == 1439){
                contador = 1;
            }
            else{
                contador++;
            }    
            resultado++;
        }
        return resultado;
    }
    
    @Override
    public void ingresarDatos(String datos, int dia){
        /** Método que transforma y asigna datos a los atributos*/
        
        String[] datos_sueño = datos.split("-");
        
        this.tiempo_inicio = Integer.parseInt(datos_sueño[0]);
        this.tiempo_fin = Integer.parseInt(datos_sueño[1]);
        this.tiempo_total_dormido = this.calcularTiempoTotal();
        this.tipo_de_sueno = Integer.parseInt(datos_sueño[2]);
        this.dia = dia;
    }
    
    public static void main(String[] args) throws Exception{
        DatosSueno nuevo_Sueno1 = new DatosSueno();
        DatosSueno nuevo_Sueno2 = new DatosSueno();
        DatosSueno nuevo_Sueno3 = new DatosSueno();
        Cola nueva_cola = new Cola();
        Cola nueva_prueba = new Cola();
        int suma = 0;
        
        nuevo_Sueno1.ingresarDatos("251-350-2", 1);
        nuevo_Sueno2.ingresarDatos("1401-1-2",1);
        suma = nuevo_Sueno1.tiempo_total_dormido + nuevo_Sueno2.tiempo_total_dormido;
        
        System.out.println(nuevo_Sueno2.tiempo_total_dormido);
    }
}
