/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores;

/**
 *
 * @author yara
 */
public class BloquePasos extends Bloque{
    /** Atributos de la Clase BloquePasos*/
    String[] datos_Pasos;
    String[] datos_dia;
    
    @Override
    public void obtenerDatos(String datos){
        /** Método para obtener datos a traves de una cadena*/
        if (datos.length() > 7){
            this.datos_Pasos = datos.split(",");
        } 
        else {
            this.datos_dia = datos.split(",");
        }
    }
    
    public int getSize(){
        return this.datos_Pasos.length;
    }
}
