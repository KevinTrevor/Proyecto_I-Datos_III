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
public class Cola {
    public Nodo frente;
    public Nodo fondo;
    public int size;
    public int limite;
    
    public Cola(){
        
        frente = null;
        fondo = null;
        size = 0;
        limite = 100;
    }
    
    public boolean esVacio(){
        return frente == null;
    }
    
    public boolean estaLleno(){
        return size == limite;
    }
    
    public void encolar(DatosSueno usuario) throws Exception{
        if(!estaLleno()){
            Nodo nuevo_nodo = new Nodo();
            nuevo_nodo.ingresar(usuario);
            if (!esVacio()){
                fondo.siguiente = nuevo_nodo;
                size++;
            }
            else{
                frente = nuevo_nodo;
                size++;
            }
            fondo = nuevo_nodo;
        }
        else{
            throw new Exception("Cola Llena");  
        }   
    }
    
    public void encolar(DatosBMP usuario) throws Exception{
        if(!estaLleno()){
            Nodo nuevo_nodo = new Nodo();
            nuevo_nodo.ingresar(usuario);
            if (!esVacio()){
                fondo.siguiente = nuevo_nodo;
                size++;
            }
            else{
                frente = nuevo_nodo;
                size++;
            }
            fondo = nuevo_nodo;
        }
        else{
            throw new Exception("Cola Llena");  
        }   
    }
    
    public void encolar(DatosPasos usuario) throws Exception{
        if(!estaLleno()){
            Nodo nuevo_nodo = new Nodo();
            nuevo_nodo.ingresar(usuario);
            if (!esVacio()){
                fondo.siguiente = nuevo_nodo;
                size++;
            }
            else{
                frente = nuevo_nodo;
                size++;
            }
            fondo = nuevo_nodo;
        }
        else{
            throw new Exception("Cola Llena");  
        }   
    }
    
    public Nodo desencolar() throws Exception{
        Nodo nodo_retorno;
        if(esVacio()){
            throw new Exception("Cola Vacía");
        }
        else{
            nodo_retorno = frente;
            frente = frente.siguiente;
            nodo_retorno.siguiente = null;
            size--;
        }
        return nodo_retorno;
    }
     
}
