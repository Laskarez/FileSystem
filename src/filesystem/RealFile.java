package filesystem;

/**
 * Created by Humberto on 20/11/2016.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class RealFile {
    private final String nombreArchivo;
    private final String extension;
    private String contenido;
    private String fechaCreacion;
    private String fechaModificacion;
    private long tamaño;
    private Formatter x;
    private File archivo;

    public RealFile(String pNombre, String pExtension, String pContenido){
        this.extension = pExtension;
        this.nombreArchivo = pNombre + "." + this.extension;
        this.contenido = pContenido;
        this.fechaCreacion = "";
        this.fechaModificacion = "";
        this.tamaño = 0;
    }



    public String getContenido() {
        return contenido;
    }

    public void crearArchivo(){
        this.archivo = new File(this.nombreArchivo);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        if (this.archivo.exists()){
            System.out.println("El archivo ya existe, ¿desea sobreescribirlo? S/N: ");
            Scanner input = new Scanner(System.in);
            String respuesta = input.next();
            String res = respuesta.toLowerCase();
            this.fechaCreacion = dtf.format(now);
            if (res.equals("s")){
                try{
                    this.x = new Formatter(this.nombreArchivo);
                    this.fechaCreacion = dtf.format(now);
                    System.out.println("Se creó el archivo " + this.nombreArchivo);
                    escribirArchivo("prueba n+1");
                    this.tamaño = archivo.length();
                    this.fechaCreacion = dtf.format(now);
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

    public void verPropiedades(){
        System.out.println("*****Propiedades del archivo*****");
        System.out.println("*****Nombre: " + this.nombreArchivo);
        System.out.println("*****Extensión: " + this.extension);
        System.out.println("*****Tamaño: "+ this.tamaño);
        System.out.println("*****Fecha de creación: " + this.fechaCreacion);
        System.out.println("*****Fecha de modificación" + this.fechaModificacion);
    }
}
