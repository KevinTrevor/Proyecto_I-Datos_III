package Analizadores;

/**
    @author Kevin Rojas
 */
public class DatosBMP extends Datos{
    /** Atributos de la Clase DatosBMP*/
    int valor_bmp;
    int dia;
    String unidad;
    
    public DatosBMP(){
        /** Método constructor de la Clase DatosBMP*/
        valor_bmp = 0;
        dia = 0;
        unidad = "bmp";
    }
    
    @Override
    public void ingresarDatos(String datos, int dia){
        /** Método que transforma y asigna datos a los atributos*/
        
        this.valor_bmp = Integer.parseInt(datos);
        this.dia = dia;
    }
}
