package Analizadores;

/**
    @author Kevin Rojas
 */
public class DatosSueno extends Datos{
    /** Atributos de la Clase DatosSueño*/
    int tiempo_inicio;
    int tiempo_fin;
    int tipo_de_sueño;
    int dia;
    String unidad;
    
    public DatosSueno(){
        /** Método constructor de la Clase DatosSueño*/
        this.tiempo_inicio = 0;
        this.tiempo_fin = 0;
        this.tipo_de_sueño = 0;
        this.dia = 0;
        this.unidad = "sueño";
    }
    
    @Override
    public void ingresarDatos(String datos, int dia){
        /** Método que transforma y asigna datos a los atributos*/
        
        String[] datos_sueño = datos.split("-");
        
        this.tiempo_inicio = Integer.parseInt(datos_sueño[0]);
        this.tiempo_fin = Integer.parseInt(datos_sueño[1]);
        this.tipo_de_sueño = Integer.parseInt(datos_sueño[2]);
        this.dia = dia;
    }
    
}
