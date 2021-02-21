package Analizadores;
import Estructuras_de_Datos.*;

/**
    @author Kevin Rojas
 */
public class RegistroPasos{
    /** Atributos de la Clase RegistroPasos*/
    Pila pila_pasos;
    Pila historial;
    
    public void asignarDatos(BloquePasos bloque)throws Exception{
        /** Método que transforma y asigna datos a los atributos*/
        int dia_inicio = Integer.parseInt(bloque.datos_dia[0]);
        int dia_fin = Integer.parseInt(bloque.datos_dia[1]);
        
        for (int i=0; i < dia_fin - dia_inicio; i++){
            DatosPasos nuevo_paso = new DatosPasos();
            nuevo_paso.ingresarDatos(bloque.datos_Pasos[i], dia_inicio + i);
            pila_pasos.push(nuevo_paso);
        }
    }
}
