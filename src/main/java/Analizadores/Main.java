package Analizadores;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
    @author Kevin Rojas
 */
public class Main {
    static BloqueBMP analizadorBMP = new BloqueBMP();
    static BloqueSueno analizadorSueno = new BloqueSueno();
    static BloquePasos analizadorPasos = new BloquePasos();
   
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("./data.txt"));
        String analisis = null;
        Main app = new Main();
        
        while(scan.hasNext()) {
            String line = scan.nextLine();
            if ("BMP".equals(line) || "SUENO".equals(line) || "PASOS".equals(line) || "#".equals(line) || "0 0".equals(line)){
                analisis = line;
                
                switch (analisis){
                    case "#":
                        System.out.println("Entro a #");
                        for (int i= 0; i < app.analizadorBMP.getSize(); i++){
                            System.out.println("Tamaño: "+app.analizadorBMP.getSize());
                            System.out.println(app.analizadorBMP.datos_BMP[i]);
                        }    
                        for (int i= 0; i < app.analizadorSueno.getSize(); i++){
                            System.out.println(app.analizadorSueno.datos_Sueno[i]);
                        }    
                        for (int i= 0; i < app.analizadorPasos.getSize(); i++){
                            System.out.println(app.analizadorPasos.datos_Pasos[i]);
                        }    
                        break;
                        
                    case "0 0":
                        System.out.println("Fin");
                        System.out.println(line);
                        break;
                }
            }
            else{
                switch (analisis){
                    case "BMP":
                        
                        app.analizadorBMP.obtenerDatos(line);
                        break;
                    
                    case "SUENO":
                        
                        app.analizadorSueno.obtenerDatos(line);
                        break;
                    
                    case "PASOS": 
                       
                        app.analizadorPasos.obtenerDatos(line);
                       
                        break;
        
                }
            }
        }
    }    
}
   
