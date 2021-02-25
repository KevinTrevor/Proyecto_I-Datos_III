package Analizadores;

/**
    @author Kevin Rojas
 */
public class DatosSueno extends Datos{
    /** Atributos de la Clase DatosSueño*/
    public int tiempo_inicio;
    public int tiempo_fin;
    public int tipo_de_sueño;
    public int dia;
    public int tiempo_total_dormido;
    String unidad;
    
    public DatosSueno(){
        /** Método constructor de la Clase DatosSueño*/
        this.tiempo_inicio = 0;
        this.tiempo_fin = 0;
        this.tipo_de_sueño = 0;
        this.dia = 0;
        this.tiempo_total_dormido = 0;
        this.unidad = "sueño";
    }
    
    private int calcularTiempoTotal(){
        int resultado = 0;
        int contador = this.tiempo_inicio;
        
        while (contador != this.tiempo_fin){
            if (contador == 1439){
                contador = 1;
            }
            else{
                contador++;
            }
            resultado++;
        }
        return resultado;
    }
    
    @Override
    public void ingresarDatos(String datos, int dia){
        /** Método que transforma y asigna datos a los atributos*/
        
        String[] datos_sueño = datos.split("-");
        
        this.tiempo_inicio = Integer.parseInt(datos_sueño[0]);
        this.tiempo_fin = Integer.parseInt(datos_sueño[1]);
        this.tiempo_total_dormido = this.calcularTiempoTotal();
        this.tipo_de_sueño = Integer.parseInt(datos_sueño[2]);
        this.dia = dia;
    }
    
}
