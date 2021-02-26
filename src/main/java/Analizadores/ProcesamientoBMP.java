package Analizadores;
import Estructuras_de_Datos.*;

/**
    @author Kevin Rojas
 */
public class ProcesamientoBMP {
    /** Atributos de la Clase ProcesamientoBMP*/
    Dipolo cola_bmp;
    
    ServidorBMP servidor1;
    ServidorBMP servidor2;
    ServidorBMP servidor3;
    
    public ProcesamientoBMP(){
        this.cola_bmp = new Dipolo();
        this.servidor1 = new ServidorBMP();
        this.servidor2 = new ServidorBMP();
        this.servidor3 = new ServidorBMP();
    }
    
    public void asignarDatos(BloqueBMP bloque) throws Exception{
        /** Método que transforma y asigna datos a los atributos*/
        
        int dia_bmp = Integer.parseInt(bloque.datos_dia[0].trim());
        int minuto_inicio = Integer.parseInt(bloque.datos_dia[1].trim());
        int minuto_fin = Integer.parseInt(bloque.datos_dia[2].trim());
        
        for (int i= 0; i < minuto_fin - minuto_inicio; i++){
            DatosBMP nuevo_bmp = new DatosBMP();
            nuevo_bmp.ingresarDatos(bloque.datos_BMP[i], dia_bmp);
            this.cola_bmp.encolarFondo(nuevo_bmp);
        }
    }
    
    public void procesarBMP(){
        
    }
}
