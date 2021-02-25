package Analizadores;

/**
    @author Kevin Rojas
 */
public class ServidorSueno extends Servidor{
    DatosSueno dato_procesar = null;
    int tiempo_procesamiento = -1;
           
    @Override
    public boolean estaDisponible(){
        return this.dato_procesar == null;
    }
    
    public void asignar(DatosSueno ingreso){
        this.dato_procesar = ingreso;
        this.tiempo_procesamiento = (int) Math.ceil(ingreso.tiempo_total_dormido / 8); 
    }
    
    public DatosSueno retirar(){
        DatosSueno retorno = this.dato_procesar;
        this.tiempo_procesamiento = -1;
        this.dato_procesar = null;
        
        return retorno;
    }
    
    public static void main(String[] args) {
        DatosSueno nuevo_sueno = new DatosSueno();
        nuevo_sueno.ingresarDatos("1439-180-2", 31);
        
        ServidorSueno prueba = new ServidorSueno();
        
        prueba.asignar(nuevo_sueno);
        
        System.out.println(prueba.tiempo_procesamiento);
    }
}
