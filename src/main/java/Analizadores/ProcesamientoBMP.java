/*
    Asignatura: Algoritmos y Estructuras de Datos III
    Hecho por: Kevin Rojas y Nestor Aguilar
    C.I: 29.582.382 y 28.316.308
    Email: kevintrevor0905@gmail.com y 
 */
package Analizadores;
import Estructuras_de_Datos.*;

/**
    @author Kevin Rojas and Nestor Aguilar
 */
public class ProcesamientoBMP {
    /** Atributos de la Clase ProcesamientoBMP*/
    Dipolo cola_bmp;
    Dipolo ordenamiento;
    
    ServidorBMP servidor1;
    ServidorBMP servidor2;
    ServidorBMP servidor3;
    
    public ProcesamientoBMP(){
        /** Método Constructor de la Clase ProcesamientoBMP*/
        this.cola_bmp = new Dipolo();
        this.ordenamiento = new Dipolo();
        this.servidor1 = new ServidorBMP();
        this.servidor2 = new ServidorBMP();
        this.servidor3 = new ServidorBMP();
    }
  
    public void asignarDatos(BloqueBMP bloque) throws Exception{
        /** Método que transforma y asigna datos a los atributos*/
        
        int dia_bmp = Integer.parseInt(bloque.datos_dia[0].trim());
        
        for (int i= 0; i < bloque.getSize(); i++){
            DatosBMP nuevo_bmp = new DatosBMP();
            nuevo_bmp.ingresarDatos(bloque.datos_BMP[i], dia_bmp);
            this.cola_bmp.encolarFondo(nuevo_bmp);
        }
    }
    
    public int cantidad_ciclos(){
        /** Método que retorna la cantidad de ciclos que deben hacerse en el procesamiento
         3 si es mayor o igual a 3
         cola_bmp.size si es menor que 3 */
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
        /** Método que ordena los datos BMP si su valor es mayor que 100*/
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
        /** Método que asigna un DatosBMP a un servidor*/
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
        /** Método que devuelve un booleano si los servidores están llenos
         true si lo están
         false si no lo están*/
        return (!this.servidor1.estaDisponible() && !this.servidor2.estaDisponible() && !this.servidor3.estaDisponible());
    }
    
    public void procesarBMP() throws Exception{
        /** Método que procesa la cola_bmp llena de DatosBMP y llena los servidores*/
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
}
