package Analizadores;
import Estructuras_de_Datos.*;

/**
    @author Kevin Rojas
 */
public class RegistroBMP {
    /** Atributos de la Clase RegistroBMP*/
    Dipolo cola_bmp;
    Cola resultado;
    
    public void asignarDatos(BloqueBMP bloque) throws Exception{
        /** Método que transforma y asigna datos a los atributos*/
        
        int dia_bmp = Integer.parseInt(bloque.datos_dia[0]);
        int minuto_inicio = Integer.parseInt(bloque.datos_dia[1]);
        int minuto_fin = Integer.parseInt(bloque.datos_dia[2]);
        
        for (int i= 0; i < minuto_fin - minuto_inicio; i++){
            DatosBMP nuevo_bmp = new DatosBMP();
            nuevo_bmp.ingresarDatos(bloque.datos_BMP[i], dia_bmp);
            cola_bmp.encolarFondo(nuevo_bmp);
        }
    }
}
