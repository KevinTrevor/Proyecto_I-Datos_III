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
public class DatosSueno extends Datos{
    /** Atributos de la Clase DatosSueño*/
    public int minuto_inicio;
    public int minuto_fin;
    public int tipo_de_sueno;
    public int dia;
    public int tiempo_total_dormido;
    String unidad;
    
    public DatosSueno(){
        /** Método constructor de la Clase DatosSueño*/
        this.minuto_inicio = -1;
        this.minuto_fin = -1;
        this.tipo_de_sueno = -1;
        this.dia = -1;
        this.tiempo_total_dormido = -1;
        this.unidad = "sueño";
    }
    
    private int calcularTiempoTotal(){
        int resultado = 0;
        int contador = this.minuto_inicio;
        
        while (contador != this.minuto_fin){
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
        
        this.minuto_inicio = Integer.parseInt(datos_sueño[0]);
        this.minuto_fin = Integer.parseInt(datos_sueño[1]);
        this.tiempo_total_dormido = this.calcularTiempoTotal();
        this.tipo_de_sueno = Integer.parseInt(datos_sueño[2]);
        this.dia = dia;
    }
}
