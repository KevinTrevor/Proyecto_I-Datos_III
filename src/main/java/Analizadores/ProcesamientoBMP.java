package Analizadores;
import Estructuras_de_Datos.*;

/**
    @author Kevin Rojas
 */
public class ProcesamientoBMP {
    /** Atributos de la Clase ProcesamientoBMP*/
    Dipolo cola_bmp;
    Dipolo ordenamiento;
    
    ServidorBMP servidor1;
    ServidorBMP servidor2;
    ServidorBMP servidor3;
    
    public ProcesamientoBMP(){
        this.cola_bmp = new Dipolo();
        this.ordenamiento = new Dipolo();
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
        int ciclos;
        
        if (this.cola_bmp.size >= 3){
            ciclos = 3;
	}
	else{
            ciclos = this.cola_bmp.size;
	}
        return ciclos;
    }
    
    public void ordenarDatos(DatosBMP nuevo_dato) throws Exception{
       if (this.ordenamiento.esVacio()){
           this.ordenamiento.encolarFrente(nuevo_dato);
       }
       else{
           if (nuevo_dato.valor_bmp > 100){
               if (nuevo_dato.valor_bmp > this.ordenamiento.frente.info_bmp.valor_bmp){
                   this.ordenamiento.encolarFrente(nuevo_dato);
               }
               else{
                   if (this.ordenamiento.fondo.info_bmp.valor_bmp > nuevo_dato.valor_bmp){
                        this.ordenamiento.encolarFondo(nuevo_dato);
                   }
                   else{
                       DatosBMP retirado = this.ordenamiento.desencolarFondo().info_bmp;
                       this.ordenamiento.encolarFondo(nuevo_dato);
                       this.ordenamiento.encolarFondo(retirado);
                   }
               }
           }
           else{
               ordenamiento.encolarFondo(nuevo_dato);
           }
       }
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
    
    public boolean servidoresLlenos(){
        return (!this.servidor1.estaDisponible() && !this.servidor2.estaDisponible() && !this.servidor3.estaDisponible());
    }
    
    public void procesarBMP() throws Exception{
        DatosBMP dato_procesar;
        int num_servidor = 0;
        int num_ciclo = this.cantidad_ciclos();
        
        for (int i = 0; i < num_ciclo; i++){
            if (this.cola_bmp.size == 1) {
                dato_procesar = this.cola_bmp.desencolarFrente().info_bmp;
            }
            else{
                if (this.cola_bmp.frente.info_bmp.valor_bmp > 100 || this.cola_bmp.fondo.info_bmp.valor_bmp > 100){
                    if (this.cola_bmp.frente.info_bmp.valor_bmp > this.cola_bmp.fondo.info_bmp.valor_bmp){
                        dato_procesar = this.cola_bmp.desencolarFrente().info_bmp;
                    }
                    else{
                        dato_procesar = this.cola_bmp.desencolarFondo().info_bmp;
                    }     
                }
                else{
                    dato_procesar = this.cola_bmp.desencolarFrente().info_bmp;
                }
            }
             
            this.ordenarDatos(dato_procesar);
        }
        while (!this.ordenamiento.esVacio()){
            this.llenarServidor(this.ordenamiento.desencolarFrente().info_bmp, num_servidor);
            num_servidor++;
        }
    }
    
   /* public static void main(String[] args) throws Exception{
        ProcesamientoBMP prueba = new ProcesamientoBMP();
        
        DatosBMP nuevo_BMP1 = new DatosBMP();
        nuevo_BMP1.ingresarDatos("110", 1);
        
        DatosBMP nuevo_BMP2 = new DatosBMP();
        nuevo_BMP2.ingresarDatos("107", 1);
        
        DatosBMP nuevo_BMP3 = new DatosBMP();
        nuevo_BMP3.ingresarDatos("108", 1);
        
        prueba.cola_bmp.encolarFondo(nuevo_BMP1);
        prueba.cola_bmp.encolarFondo(nuevo_BMP2);
        prueba.cola_bmp.encolarFondo(nuevo_BMP3);
        
        prueba.procesarBMP();
        
        System.out.println(prueba.servidor1.dato_procesar.valor_bmp);
       
    }*/
}
