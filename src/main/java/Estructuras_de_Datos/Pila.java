package Estructuras_de_Datos;
import Analizadores.*;
/*
    Asignatura: Algoritmos y Estructuras de Datos III
    Hecho por: Kevin Rojas
    C.I: 29.582.382
    Email: kevintrevor0905@gmail.com
 */

/*
    @author Kevin Rojas
*/
public class Pila {
    public Nodo tope;
    public int size;
    public int limite;
    
    public Pila(){
        tope = null;
        size = 0;
        limite = 100;
    }
    
    public boolean esVacio(){
        return tope == null;
    }
    
    public boolean estaLleno(){
        return size == limite;
    }
    
    public void push(DatosSueno info) throws Exception{
        if (estaLleno()){
            throw new Exception("Cola Llena");
        }
        else{
            Nodo nuevo_nodo = new Nodo(); 
            nuevo_nodo.ingresar(info);
            if (esVacio()){
               tope = nuevo_nodo;
            }
            else{
                nuevo_nodo.siguiente = tope;
                tope = nuevo_nodo;
            }
            size++;
        }
    }
    
    public void push(DatosPasos info) throws Exception{
        if (estaLleno()){
            throw new Exception("Cola Llena");
        }
        else{
            Nodo nuevo_nodo = new Nodo(); 
            nuevo_nodo.ingresar(info);
            if (esVacio()){
               tope = nuevo_nodo;
            }
            else{
                nuevo_nodo.siguiente = tope;
                tope = nuevo_nodo;
            }
            size++;
        }
    }
    
    public void push(DatosBMP info) throws Exception{
        if (estaLleno()){
            throw new Exception("Cola Llena");
        }
        else{
            Nodo nuevo_nodo = new Nodo(); 
            nuevo_nodo.ingresar(info);
            if (esVacio()){
               tope = nuevo_nodo;
            }
            else{
                nuevo_nodo.siguiente = tope;
                tope = nuevo_nodo;
            }
            size++;
        }
    }
    
    public Nodo pop() throws Exception{
        /* Método que elimina y devuelve el valor del nodo tope */
        Nodo nodo_retorno;
        if (esVacio()){
            throw new Exception("Cola Vacía");
        }
        else{
            nodo_retorno = tope;
            tope = tope.siguiente;
            nodo_retorno.siguiente = null;
            
            size--;
        }
        return nodo_retorno;
    }
}
