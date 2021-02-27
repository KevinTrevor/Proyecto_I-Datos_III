package Analizadores;

/**
    @author Kevin Rojas
 */
public class ServidorBMP extends Servidor{
    DatosBMP dato_procesar;
    int tiempo_procesamiento;
    
    public ServidorBMP(){
        this.dato_procesar = null;
        this.tiempo_procesamiento = -1;
    }
    @Override
    public boolean estaDisponible(){
        return this.dato_procesar == null;
    }
    
    public void asignar(DatosBMP ingreso){
        this.dato_procesar = ingreso;
        this.tiempo_procesamiento = 1;
    }
    
    public DatosBMP retirar(){
        DatosBMP retorno = this.dato_procesar;
        this.tiempo_procesamiento = -1;
        this.dato_procesar = null;
        
        return retorno;
    }
}
