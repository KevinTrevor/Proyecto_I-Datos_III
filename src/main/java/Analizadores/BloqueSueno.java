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
    public static void main(String[] args) throws Exception{
        BloqueSueno prueba = new BloqueSueno();
        ProcesamientoSueno prueba_app = new ProcesamientoSueno();
        
        prueba.obtenerDatos("43,44");
        prueba.obtenerDatos("1320-1400-1 1401-100-2 101-200-3 201-250-1 251-350-2 351-351-1 352-400-1 401-420-3");
        
        prueba_app.asignarDatos(prueba);
        while (!prueba_app.cola_sueno.esVacio()){
            System.out.println(prueba_app.cola_sueno.desencolarFrente().info_sueno.tiempo_total_dormido);
        }    
    }
}
