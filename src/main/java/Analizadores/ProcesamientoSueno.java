package Analizadores;
import Estructuras_de_Datos.*;
/**
    @author Kevin Rojas
 */
public class ProcesamientoSueno{
    /** Atributos de la Clase RegistroSueño*/
    Dipolo cola_sueno;
    
    ServidorSueno servidor_Ligeros;
    ServidorSueno servidor_Pesados;
    ServidorSueno servidor_REM;
    
    public ProcesamientoSueno(){
        this.cola_sueno = new Dipolo();
        
        this.servidor_Ligeros = new ServidorSueno();
        this.servidor_Pesados = new ServidorSueno();
        this.servidor_REM = new ServidorSueno();
    }
    
    public void asignarDatos(BloqueSueno bloque) throws Exception{
        /** Método que transforma y asigna datos a los atributos*/
        int dia_inicio = Integer.parseInt(bloque.datos_dia[0].trim());
        
        for (int i = 0; i < bloque.getSize(); i++){
            DatosSueno nuevo_sueno = new DatosSueno();
            nuevo_sueno.ingresarDatos(bloque.datos_Sueno[0], dia_inicio);
            cola_sueno.encolarFondo(nuevo_sueno);
        }
    }
    
    public void procesarSueno() throws Exception{
        switch (this.cola_sueno.frente.info_sueno.tipo_de_sueño){
            case 1:
                break;
            
            case 2:
                break;
            
            case 3:
                break;
                
        }
        
      
    }
}
