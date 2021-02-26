package Analizadores;

/**
    @author Kevin Rojas
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
    
    public void eliminarDatos(){
        this.lleno = 0;
    }
    
    public int getSize(){
        return this.datos_Sueno.length;
    }
}
