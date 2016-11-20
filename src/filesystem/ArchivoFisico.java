package filesystem;

/**
 * Created by Humberto on 20/11/2016.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class ArchivoFisico {
    private final String nombreArchivo;
    private final String extension;
    private String contenido;
    private Formatter x;
    private File archivo;

    public ArchivoFisico(String pNombre, String pExtension){
        this.extension = pExtension;
        this.nombreArchivo = pNombre + "." + this.extension;
    }



    public String getContenido() {
        return contenido;
    }

    public void crearArchivo(){
        this.archivo = new File(this.nombreArchivo);
        if (this.archivo.exists()){
            System.out.println("El archivo ya existe, ¿desea sobreescribirlo? S/N: ");
            Scanner input = new Scanner(System.in);
            String respuesta = input.next();
            String res = respuesta.toLowerCase();
            if (res.equals("s")){
                try{
                    this.x = new Formatter(this.nombreArchivo);
                    System.out.println("Se creó el archivo " + this.nombreArchivo);
                    escribirArchivo("prueba n+1");
                    cerrarArchivo();
                }catch(FileNotFoundException e){
                    System.out.println("Error al crear el archivo");
                }
            }
            else{
                System.out.println("Archivo no creado");
            }
        }
        else{
            try{
                this.x = new Formatter(this.nombreArchivo);
                System.out.println("Se creó el archivo " + this.nombreArchivo);
                escribirArchivo("prueba n+1");
                cerrarArchivo();
            }catch(FileNotFoundException e){
                System.out.println("Error al crear el archivo");
            }
        }
    }

    public void escribirArchivo(String pContenido){
        this.contenido = pContenido;
        this.x.format("%s", this.contenido);
    }

    public void cerrarArchivo(){
        this.x.close();
    }
}
