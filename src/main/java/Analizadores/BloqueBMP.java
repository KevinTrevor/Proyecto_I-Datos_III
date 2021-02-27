package Analizadores;

/**
    @author Kevin Rojas
 */
public class BloqueBMP extends Bloque{
    /** Atributos de la Clase BloqueBMP*/
    String[] datos_BMP;
    String[] datos_dia;
    
    @Override
    public void obtenerDatos(String datos){
        /** Método para obtener datos a traves de una cadena*/
        if (datos.length() > 10){
            this.datos_BMP = datos.split(" ");
        } 
        else {
            this.datos_dia = datos.split(",");
        }
    }
    
    public int getSize(){
        return this.datos_BMP.length;
    }
    
    public static void main(String[] args) {
        BloqueBMP prueba = new BloqueBMP();
        
        prueba.obtenerDatos("10 20 110 200");
        
        System.out.println(prueba.datos_BMP[0]);
    }
}

