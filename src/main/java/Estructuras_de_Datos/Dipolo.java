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
        return this.frente == null;
    }
    
    public boolean estaLleno(){
        return this.size == this.limite;
    }
    
    public void encolarFondo(DatosSueno info) throws Exception{
        if (!estaLleno()){
            Nodo nuevo_nodo = new Nodo();
            nuevo_nodo.ingresar(info);
            if (!esVacio()){
                this.fondo.siguiente = nuevo_nodo;
                this.fondo = this.fondo.siguiente;
                
            }
            else{
                this.frente = nuevo_nodo;
                this.fondo = this.frente;
            }
            this.size++;
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
                nuevo_nodo.siguiente = this.frente;
                this.frente = nuevo_nodo;
               
            }
            else{
                this.frente = nuevo_nodo;
                this.fondo = frente;
            }
            this.size++;
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
                this.fondo.siguiente = nuevo_nodo;
                this.fondo = fondo.siguiente;
                
            }
            else{
                this.frente = nuevo_nodo;
                this.fondo = this.frente;
            }
            this.size++;
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
                nuevo_nodo.siguiente = this.frente;
                this.frente = nuevo_nodo;
               
            }
            else{
                this.frente = nuevo_nodo;
                this.fondo = frente;
            }
            this.size++;
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
                this.fondo.siguiente = nuevo_nodo;
                this.fondo = this.fondo.siguiente;
                
            }
            else{
                this.frente = nuevo_nodo;
                this.fondo = this.frente;
            }
            this.size++;
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
                this.frente = nuevo_nodo;
                this.fondo = this.frente;
            }
            this.size++;
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
            nodo_retorno = this.frente;
            this.frente = this.frente.siguiente;
            nodo_retorno.siguiente = null;
            this.size--;
        }
        return nodo_retorno;
    }
    
    public Nodo desencolarFondo() throws Exception{
        Nodo nodo_retorno;
        if (!esVacio()){
            if (frente == fondo){
                nodo_retorno = fondo;
                this.frente = null;
                this.fondo = null;
            }
            else{
                Nodo nodo_auxiliar = this.frente;
                
                while (nodo_auxiliar.siguiente != this.fondo){
                    nodo_auxiliar = nodo_auxiliar.siguiente;
                }
                nodo_auxiliar.siguiente = null;
                nodo_retorno = this.fondo;
                this.fondo = nodo_auxiliar;
            }
            this.size--;
        }
        else{
            throw new Exception("Dipolo vacío");
        }
        return nodo_retorno;
    }
    
    public static void main(String[] args) throws Exception{
        DatosBMP nuevo_valor = new DatosBMP();
        Dipolo nuevo_dipolo = new Dipolo();
        
        nuevo_dipolo.encolarFondo(nuevo_valor);
    }
}
