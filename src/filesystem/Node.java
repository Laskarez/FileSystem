/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filesystem;

import java.util.ArrayList;

/**
 *
 * 
 */
public class Node {
    
    private String name;
    private int key;
    private ArrayList<Integer> sectors ;

    public Node(String pName, int pKey, ArrayList<Integer> pSectors) {
        this.name = pName;
        this.key = pKey;
        this.sectors = pSectors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public ArrayList getSectors() {
        return sectors;
    }

    public void setSector(ArrayList<Integer> sectors) {
        this.sectors = sectors;
    }
}
