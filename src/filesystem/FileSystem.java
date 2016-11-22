/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filesystem;


import com.sun.org.apache.xpath.internal.SourceTree;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @version 1.0
 */
public class FileSystem {

    /**
     * @param args the command line arguments
     */
    private static int key_counter = 0;
    private static DirectoryNode root;
    private static DirectoryNode currentNode = null;
    private static String currentPath;
    private static List<Integer> sectores;
    private static int sector_size = 0;
    private static int sector_quantity = 0;


    public static void createDisk() {
        System.out.println("Cantidad de sectores: ");
        sector_quantity = Integer.parseInt(getInput());

        System.out.println("Tamaño de cada sector: ");
        String tamSector = getInput();
        sector_size = Integer.parseInt(tamSector);

        sectores = Arrays.asList(new Integer[sector_quantity]);
        for (int i = 0; i < sector_quantity; i++){
            sectores.set(i, 0);
        }
        root = new DirectoryNode("root", 0, sectores); //se crea el root apenas se crea el disco
    }


    public static void createFile() {
        System.out.print("Nombre del archivo: ");
        String name = getInput();
        System.out.print("Extensión del archivo: ");
        String extention = getInput();
        System.out.print("Contenido del archivo: ");
        String content = getInput();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String creationDate = dtf.format(now);
        key_counter++;
        FileNode node = new FileNode(name, key_counter, sectores, extention, content, creationDate);
        if (currentNode == null){
            currentNode = new DirectoryNode("root", 0, sectores);
            currentNode.addChild(node);
        }
        else{
            currentNode.addChild(node);
        }
    }

    public static void createDirectory() {

        System.out.print("Nombre del directorio: ");
        String name = getInput();
        key_counter++;
        DirectoryNode node = new DirectoryNode(name, key_counter, sectores);
        if (currentNode == null){
            currentNode = new DirectoryNode("root", 0, sectores);
            currentNode.addChild(node);
        }
        else{
            currentNode.addChild(node);
        }
    }

    public static void showChildsDirectory() {
        if(currentNode != null){
            ArrayList<Node> childs = currentNode.getChilds();
            System.out.println("Directorio de: " + currentNode.getName());
            for (int i = 0; i < childs.size(); i++) {
                Node child = childs.get(i);
                if (child instanceof FileNode){
                    System.out.println("<ARCH> "+ i + ". " + child.getName()+"."+((FileNode) child).getExtention());
                }else{
                    System.out.println("<DIR> "+ i + ". " + child.getName());
                }
            }
        }
    }

    public static void changeDirectory() {
        System.out.println("Índice del directorio: ");
        try{
            int index = Integer.parseInt(getInput());
            Node child = currentNode.getChildIndex(index);
            if (child instanceof FileNode){
                System.out.println("No se puede seleccionar un archivo como directorio");
            }else{
                currentNode = (DirectoryNode) child;
                currentPath +="/"+child.getName();
            }
        }catch(Exception e){
            System.out.println("Índice no válido.");
        }


    }

    public static void changeFileContent() {
        System.out.println("Índice del archivo: ");
        try{
            int index = Integer.parseInt(getInput());
            Node child = currentNode.getChildIndex(index);
            if (child instanceof DirectoryNode){
                System.out.println("No se puede cambiar el contenido del directorio");
            }else{
                FileNode file = (FileNode) child;
                //String content = file.getContent();
                System.out.println("Nuevo contenido: ");
                String newContent = getInput();
                file.setContent(newContent);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String modificationDate = dtf.format(now);
                file.setModificationDate(modificationDate);
                System.out.println("Contenido de "+ file.getName() + " modificado con éxito");
            }
        }catch(Exception e){
            System.out.println("Índice no válido.");
        }
    }

    public static void showContentFile(){
        System.out.println("Índice del archivo: ");
        try{
            int index = Integer.parseInt(getInput());
            Node child = currentNode.getChildIndex(index);
            if (child instanceof DirectoryNode){
                System.out.println("No se puede ver el contenido del directorio");
            }else{
                FileNode file = (FileNode) child;
                //String content = file.getContent();
                System.out.println("Contenido de "+ file.getName() + " es:");
                System.out.println(file.getContent());
            }
        }catch(Exception e){
            System.out.println("Índice no válido.");
        }
    }

    public static void showProperties(){
        System.out.println("Índice del archivo: ");
        try{
            int index = Integer.parseInt(getInput());
            Node child = currentNode.getChildIndex(index);
            FileNode file = (FileNode) child;
            System.out.println("*****Propiedades del archivo");
            System.out.println("*****Nombre: " + file.getName());
            System.out.println("*****Extensión: " + file.getExtention());
            System.out.println("*****Tamaño: "+ file.getSize());
            System.out.println("*****Fecha de creación: " + file.getCreationDate());
            System.out.println("*****Fecha de modificación " + file.getModificationDate());
        }catch(Exception e){
            System.out.println("Índice no válido.");
        }
    }

    public static void copyFile(){
        System.out.println("Índice del archivo: ");
        try {
            int index = Integer.parseInt(getInput());
            Node child = currentNode.getChildIndex(index);
            FileNode file = (FileNode) child;
            copyMenu();
            String copyType = getInput();
            switch (copyType){
                case "1":

                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Copiado no válido");
            }
        }
        catch (Exception e){
            System.out.println("Índice no válido.");
        }
    }

    public static void copyMenu(){
        System.out.println("Opciones");
        System.out.println("1. Real a Virtual");
        System.out.println("2. Virtual a Real");
        System.out.println("3. Virtual a Virtual");
        System.out.print("Opción: ");
    }


    public static void menu(String pOpcion){
        String opcion = pOpcion;
        switch (opcion){
            case "CREATE":
                createDisk();
                break;
            case "FILE":
                createFile();
                break;
            case "MKDIR":
                createDirectory();
                break;
            case "CambiarDIR":
                changeDirectory();
                break;
            case "ListaDIR":
                showChildsDirectory();
                break;
            case "ModFILE":
                changeFileContent();
                break;
            case "VerPropiedades":
                showProperties();
                break;
            case "ContFile":
                showContentFile();
                break;
            case "CoPY":
                copyFile();
                break;
            case "MoVer":
                break;
            case "ReMove":
                break;
            case "FIND":
                break;
            case "TREE":
                break;
            case "DISCO VIRTUAL":
                break;
            default:
                System.out.println("Instrucción no válida");
        }
    }

    public static String getInput(){
        Scanner input = new Scanner(System.in);
        String inputString = input.next();
        return inputString;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        //root = new DirectoryNode("root", 0, sectores); //se crea el root apenas inicia la aplicación

        Scanner input = new Scanner(System.in);
        while (true) {
            showChildsDirectory();
            System.out.print("Opción: ");
            String opcion = input.next();
            menu(opcion);
            //System.out.println(currentNode);
        }

    }

}
