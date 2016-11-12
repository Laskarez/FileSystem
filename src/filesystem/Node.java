/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filesystem;

/**
 *
 * 
 */
public class Node {
    
    private String name;
    private int key;

    public Node(String pName, int pKey) {
        this.name = pName;
        this.key = pKey;
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

}
