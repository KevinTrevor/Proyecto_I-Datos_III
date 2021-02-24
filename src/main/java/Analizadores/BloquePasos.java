package Analizadores;

/**
 *
 * @author Kevin Rojas
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
        return this.datos_Pasos.length;
    }
}
