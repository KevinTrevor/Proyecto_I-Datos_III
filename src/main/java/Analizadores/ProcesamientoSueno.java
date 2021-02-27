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
    
    public boolean todos_servidoresDisponibles(){
        return this.servidor_Ligeros.estaDisponible() && this.servidor_Pesados.estaDisponible() && this.servidor_REM.estaDisponible();
    }
    public void asignarDatos(BloqueSueno bloque) throws Exception{
        /** Método que transforma y asigna datos a los atributos*/
        int dia_inicio = Integer.parseInt(bloque.datos_dia[0].trim());
        
        for (int i = 0; i < bloque.getSize(); i++){
            DatosSueno nuevo_sueno = new DatosSueno();
            nuevo_sueno.ingresarDatos(bloque.datos_Sueno[i], dia_inicio);
            cola_sueno.encolarFondo(nuevo_sueno);
        }
    }
    
    public void procesarSueno() throws Exception{
        switch (this.cola_sueno.frente.info_sueno.tipo_de_sueno){
            case 1:
                if (this.servidor_Ligeros.estaDisponible()){
                    this.servidor_Ligeros.asignar(this.cola_sueno.desencolarFrente().info_sueno);
                }
                else{
                    this.cola_sueno.encolarFondo(this.cola_sueno.desencolarFrente().info_sueno);
                }
                break;
            
            case 2:
                if (this.servidor_Pesados.estaDisponible()){
                    this.servidor_Pesados.asignar(this.cola_sueno.desencolarFrente().info_sueno);
                }
                else{
                    this.cola_sueno.encolarFondo(this.cola_sueno.desencolarFrente().info_sueno);
                }
                break;
            
            case 3:
                if (this.servidor_REM.estaDisponible()){
                    this.servidor_REM.asignar(this.cola_sueno.desencolarFrente().info_sueno);
                }
                else{
                    this.cola_sueno.encolarFondo(this.cola_sueno.desencolarFrente().info_sueno);
                }
                break; 
        }
    }
    
    public void reducir_tiempoServidores(){
        if (!this.servidor_Ligeros.estaDisponible()){
            if (this.servidor_Ligeros.duracion_procesamiento != 0){
                this.servidor_Ligeros.duracion_procesamiento--;
            }
        }
                            
        if (!this.servidor_Pesados.estaDisponible()){
            if (this.servidor_Pesados.duracion_procesamiento != 0){
                this.servidor_Pesados.duracion_procesamiento--;
            }
        }
                            
        if (!this.servidor_REM.estaDisponible()){
            if (this.servidor_REM.duracion_procesamiento != 0){
                this.servidor_REM.duracion_procesamiento--;
            }  
        }
    }
    
    public static void main(String[] args) throws Exception{
        DatosSueno nuevo_Sueno1 = new DatosSueno();
        DatosSueno nuevo_Sueno2 = new DatosSueno();
        DatosSueno nuevo_Sueno3 = new DatosSueno();
        DatosSueno nuevo_Sueno4 = new DatosSueno();
        DatosSueno nuevo_Sueno5 = new DatosSueno();
        DatosSueno nuevo_Sueno6 = new DatosSueno();
        Cola nueva_cola = new Cola();
        Cola nueva_resultados = new Cola();
        ProcesamientoSueno nueva_prueba = new ProcesamientoSueno();
        
        nuevo_Sueno1.ingresarDatos("1320-1400-2", 1);
        nuevo_Sueno2.ingresarDatos("1401-100-3", 1);
        nuevo_Sueno3.ingresarDatos("101-140-1", 1);
        nuevo_Sueno4.ingresarDatos("141-250-3", 1);
        nuevo_Sueno5.ingresarDatos("251-500-1", 1);
        nuevo_Sueno6.ingresarDatos("501-700-2", 1);
        
        nueva_prueba.cola_sueno.encolarFrente(nuevo_Sueno1);
        nueva_prueba.cola_sueno.encolarFrente(nuevo_Sueno2);
        nueva_prueba.cola_sueno.encolarFrente(nuevo_Sueno3);
        nueva_prueba.cola_sueno.encolarFrente(nuevo_Sueno4);
        nueva_prueba.cola_sueno.encolarFrente(nuevo_Sueno5);
        nueva_prueba.cola_sueno.encolarFrente(nuevo_Sueno6);
        
        
        boolean terminado = false;
        while (!terminado){
           if (!nueva_prueba.cola_sueno.esVacio()){
               System.out.println(nueva_prueba.cola_sueno.size);
               nueva_prueba.procesarSueno();
           }
           nueva_prueba.reducir_tiempoServidores();
          
            if (nueva_prueba.servidor_Ligeros.duracion_procesamiento == 0){
                nueva_cola.encolar(nueva_prueba.servidor_Ligeros.retirar());
            }
            
            
            if (nueva_prueba.servidor_Pesados.duracion_procesamiento == 0){
                nueva_cola.encolar(nueva_prueba.servidor_Pesados.retirar());
            }
            
            
            if (nueva_prueba.servidor_REM.duracion_procesamiento == 0){
                nueva_cola.encolar(nueva_prueba.servidor_REM.retirar());
            }
           
            
            if (nueva_prueba.todos_servidoresDisponibles()){
                terminado = true;
            }
        }    
        nueva_resultados.encolar(nueva_cola);
        System.out.println(nueva_resultados.size);
        
        while (!nueva_resultados.esVacio()){
            Cola aux = nueva_resultados.desencolar().info_cola;
            while (!aux.esVacio()){
                System.out.println("Tiempo total: "+aux.desencolar().info_sueno.tiempo_total_dormido);
            }    
        }    
    }
}
