package Analizadores;
import Estructuras_de_Datos.*;
/**
    @author Kevin Rojas
 */
public class ProcesamientoPasos{
    /** Atributos de la Clase ProcesamientoPasos*/
    Cola pila_pasos = new Cola();
    Cola historial = new Cola();
    Dipolo mejor_dia = new Dipolo();
    
    public void asignarDatos(BloquePasos bloque)throws Exception{
        /** Método que transforma y asigna datos a los atributos*/
        int dia_inicio = Integer.parseInt(bloque.datos_dia[0].trim());
        int dia_fin = Integer.parseInt(bloque.datos_dia[1].trim());
        
        for (int i=0; i < (dia_fin + 1) - dia_inicio; i++){
            DatosPasos nuevo_paso = new DatosPasos();
            nuevo_paso.ingresarDatos(bloque.datos_Pasos[i].trim(), dia_inicio + i);
            pila_pasos.encolar(nuevo_paso);
        }
    }
    
    public void vaciar_MejorDia() throws Exception{
        while (!this.mejor_dia.esVacio()){
            this.mejor_dia.desencolarFrente();
        }
    }
    
    public int seleccionar_MejorDia(int dia_evaluado) throws Exception{
        int seleccion = -1;
        for (int i = 0; i < this.mejor_dia.size; i++){
            if (seleccion > 0){
                this.mejor_dia.encolarFrente(this.mejor_dia.desencolarFondo().info_pasos);
            }
            else{
                if (dia_evaluado < this.mejor_dia.fondo.info_pasos.pasos_dados){
                    seleccion = this.mejor_dia.fondo.info_pasos.dia;
                    this.mejor_dia.encolarFrente(this.mejor_dia.desencolarFondo().info_pasos);
                }
                else{
                    this.mejor_dia.encolarFrente(this.mejor_dia.desencolarFondo().info_pasos);
                }    
            }
        }
        return seleccion;
    }
    
    public DatosPasos procesamientoPasos() throws Exception{
        DatosPasos dia_evaluado = this.pila_pasos.desencolar().info_pasos;
        
        if (!this.mejor_dia.esVacio()){
            dia_evaluado.mejor_diaAnterior = seleccionar_MejorDia(dia_evaluado.pasos_dados);
        
            if (dia_evaluado.pasos_dados > this.mejor_dia.frente.info_pasos.pasos_dados){
                vaciar_MejorDia();
                this.mejor_dia.encolarFrente(dia_evaluado);
            }
            else{
                this.mejor_dia.encolarFondo(dia_evaluado);
            }
        }
        else{
            this.mejor_dia.encolarFondo(dia_evaluado);
        }
        
        return dia_evaluado;
    }
}
