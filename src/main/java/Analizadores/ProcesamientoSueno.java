package Analizadores;
import Estructuras_de_Datos.*;
/**
    @author Kevin Rojas
 */
public class ProcesamientoSueno{
    /** Atributos de la Clase RegistroSueño*/
    Dipolo cola_sueno = new Dipolo();
    
    public void asignarDatos(BloqueSueno bloque) throws Exception{
        /** Método que transforma y asigna datos a los atributos*/
        int dia_inicio = Integer.parseInt(bloque.datos_dia[0].trim());
        
        for (int i = 0; i < bloque.getSize(); i++){
            DatosSueno nuevo_sueno = new DatosSueno();
            nuevo_sueno.ingresarDatos(bloque.datos_Sueno[0], dia_inicio);
            cola_sueno.encolarFondo(nuevo_sueno);
        }
    }
    
    public DatosSueno procesamientoSueno() throws Exception{
        DatosSueno dia_evaluado = this.cola_sueno.desencolarFrente().info_sueno;
        
        return dia_evaluado;
    }
}
