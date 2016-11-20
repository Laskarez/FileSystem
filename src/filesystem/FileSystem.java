/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filesystem;

import com.sun.glass.ui.SystemClipboard;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @version 1.0
 */
public class FileSystem {

    /**
     * @param args the command line arguments
     */
    private static int key_counter = 0;
    private static DirectoryNode root = null;
    private static DirectoryNode currentNode = null;
    private static String currentPath;


    public void createDisk(int sector_size, int sector_quantity) {

    }

    public void createFile(String name, String extention, String content) {
        ArrayList<Integer> sectors = new ArrayList<>();
        key_counter++;
        FileNode node = new FileNode(name, key_counter, sectors, extention, content);
        currentNode.addChild(node);
    }

    public void createDirectory(String name) {
        ArrayList<Integer> sectors = new ArrayList<>();
        key_counter++;
        DirectoryNode node = new DirectoryNode(name, key_counter, sectors);
        currentNode.addChild(node);
    }

    public void showChildsDirectory() {
        ArrayList<Node> childs = currentNode.getChilds();
        for (int i = 0; i < childs.size(); i++) {
            Node child = childs.get(i);
            if (child instanceof FileNode){
                System.out.println(i + child.getName()+"."+((FileNode) child).getExtention());
            }else{
                System.out.println(i + child.getName());
            }
        }
    }

    public void changeDirectory(int index) {
        Node child = currentNode.getChildIndex(index);
        if (child instanceof FileNode){
            System.out.println("No se puede seleccionar un archivo como directorio");
        }else{
            currentNode = (DirectoryNode) child;
            currentPath +="/"+child.getName();
        }
    }

    public void changeFileContent(int index) {
        Node child = currentNode.getChildIndex(index);
        if (child instanceof DirectoryNode){
            System.out.println("No se puede cambiar el contenido de un directorio");
        }else{
            FileNode file = (FileNode) child;
            String content = file.getContent();
        }
    }






    public static void main(String[] args) {
        // TODO code application logic here
    }

}
