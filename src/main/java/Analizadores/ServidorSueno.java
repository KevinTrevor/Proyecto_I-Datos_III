package Analizadores;

/**
    @author Kevin Rojas
 */
public class ServidorSueno extends Servidor{
    DatosSueno dato_procesar;
    int duracion_procesamiento;
    
    public ServidorSueno(){
        this.dato_procesar = null;
        this.duracion_procesamiento = -1;
    }
    
    @Override
    public boolean estaDisponible(){
        return this.dato_procesar == null;
    }
    
    public void asignar(DatosSueno ingreso){
        this.dato_procesar = ingreso;
        this.duracion_procesamiento = (int) Math.ceil(ingreso.tiempo_total_dormido / 8); 
    }
    
    public DatosSueno retirar(){
        DatosSueno retorno = this.dato_procesar;
        this.duracion_procesamiento = -1;
        this.dato_procesar = null;
        
        return retorno;
    }
    
    public static void main(String[] args) {
        DatosSueno nuevo_Sueno1 = new DatosSueno();
        nuevo_Sueno1.ingresarDatos("1-120-2", 1);
        
        ServidorSueno nuevo_servidor = new ServidorSueno();
        
        nuevo_servidor.asignar(nuevo_Sueno1);
        
        System.out.println(nuevo_servidor.duracion_procesamiento);
      
    }
    
}
