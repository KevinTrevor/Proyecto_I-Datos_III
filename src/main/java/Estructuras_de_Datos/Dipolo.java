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

public class Dipolo {
    public Nodo frente;
    public Nodo fondo;
    public int size;
    public int limite;
    
    public Dipolo(){
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
    
    public void encolarFondo(DatosSueno info) throws Exception{
        if (!estaLleno()){
            Nodo nuevo_nodo = new Nodo();
            nuevo_nodo.ingresar(info);
            if (!esVacio()){
                fondo.siguiente = nuevo_nodo;
                fondo = fondo.siguiente;
                
            }
            else{
                frente = nuevo_nodo;
                fondo = frente;
            }
            size++;
        }
        else{
            throw new Exception("Dipolo lleno");
        }
    }
    
    public void encolarFrente(DatosSueno info) throws Exception{
        if (!estaLleno()){
            Nodo nuevo_nodo = new Nodo();
            nuevo_nodo.ingresar(info);
            if (!esVacio()){
                nuevo_nodo.siguiente = frente;
                frente = nuevo_nodo;
               
            }
            else{
                frente = nuevo_nodo;
                fondo = frente;
            }
            size++;
        }
        else{
            throw new Exception("Dipolo lleno");
        }
    }
    
     public void encolarFondo(DatosPasos info) throws Exception{
        if (!estaLleno()){
            Nodo nuevo_nodo = new Nodo();
            nuevo_nodo.ingresar(info);
            if (!esVacio()){
                fondo.siguiente = nuevo_nodo;
                fondo = fondo.siguiente;
                
            }
            else{
                frente = nuevo_nodo;
                fondo = frente;
            }
            size++;
        }
        else{
            throw new Exception("Dipolo lleno");
        }
    }
    
    public void encolarFrente(DatosPasos info) throws Exception{
        if (!estaLleno()){
            Nodo nuevo_nodo = new Nodo();
            nuevo_nodo.ingresar(info);
            if (!esVacio()){
                nuevo_nodo.siguiente = frente;
                frente = nuevo_nodo;
               
            }
            else{
                frente = nuevo_nodo;
                fondo = frente;
            }
            size++;
        }
        else{
            throw new Exception("Dipolo lleno");
        }
    }
    
     public void encolarFondo(DatosBMP info) throws Exception{
        if (!estaLleno()){
            Nodo nuevo_nodo = new Nodo();
            nuevo_nodo.ingresar(info);
            if (!esVacio()){
                fondo.siguiente = nuevo_nodo;
                fondo = fondo.siguiente;
                
            }
            else{
                frente = nuevo_nodo;
                fondo = frente;
            }
            size++;
        }
        else{
            throw new Exception("Dipolo lleno");
        }
    }
    
    public void encolarFrente(DatosBMP info) throws Exception{
        if (!estaLleno()){
            Nodo nuevo_nodo = new Nodo();
            nuevo_nodo.ingresar(info);
            if (!esVacio()){
                nuevo_nodo.siguiente = frente;
                frente = nuevo_nodo;
               
            }
            else{
                frente = nuevo_nodo;
                fondo = frente;
            }
            size++;
        }
        else{
            throw new Exception("Dipolo lleno");
        }
    }
    
    public Nodo desencolarFrente() throws Exception{
        
        Nodo nodo_retorno;
        if (esVacio()){
            throw new Exception("Dipolo vacío");
        }
        else{
            nodo_retorno = frente;
            frente = frente.siguiente;
            nodo_retorno.siguiente = null;
            size--;
        }
        return nodo_retorno;
    }
    
    public Nodo desencolarFondo() throws Exception{
        Nodo nodo_retorno;
        if (!esVacio()){
            if (frente == fondo){
                nodo_retorno = fondo;
                frente = null;
                fondo = null;
            }
            else{
                Nodo nodo_auxiliar = frente;
                
                while (nodo_auxiliar.siguiente != fondo){
                    nodo_auxiliar = nodo_auxiliar.siguiente;
                }
                nodo_auxiliar.siguiente = null;
                nodo_retorno = fondo;
                fondo = nodo_auxiliar;
            }
            size--;
        }
        else{
            throw new Exception("Dipolo vacío");
        }
        return nodo_retorno;
    }
}
