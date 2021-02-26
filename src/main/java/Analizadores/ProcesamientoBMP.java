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
    
    public int cantidad_ciclos(){
        int ciclos = 0;
        
        if (this.cola_bmp.size > 3){
            ciclos = 3;
	}
	else{
            ciclos = this.cola_bmp.size;
	}
        return ciclos;
    }
    
    public void llenarServidor(DatosBMP dato_procesar, int num_servidor){
        switch (num_servidor){
                case 0:
                    this.servidor1.asignar(dato_procesar);
                    break;
                
                case 1:
                    this.servidor2.asignar(dato_procesar);
                    break;
                
                case 2:
                    this.servidor3.asignar(dato_procesar);
                    break;
            }
    }
    
    public void procesarBMP() throws Exception{
        DatosBMP dato_procesar;
        
        for (int i = 0; i < this.cantidad_ciclos(); i++){
            if (this.cola_bmp.frente.info_bmp.valor_bmp > 100){
                if (this.cola_bmp.frente.info_bmp.valor_bmp >= this.cola_bmp.fondo.info_bmp.valor_bmp){
                    dato_procesar = this.cola_bmp.desencolarFrente().info_bmp;
                }
                else{
                    dato_procesar = this.cola_bmp.desencolarFondo().info_bmp;
                }
            } 
            else{
                dato_procesar = this.cola_bmp.desencolarFrente().info_bmp;
            }
            this.llenarServidor(dato_procesar, i);
        }
    }
}
