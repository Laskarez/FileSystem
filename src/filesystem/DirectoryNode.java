/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filesystem;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class DirectoryNode extends Node{
    
    private ArrayList<Node> childs;

    public DirectoryNode(String pName, int pKey) {
        super(pName, pKey);
    }
    
    public void addChild(Node child){
        childs.add(child);
    }
    
    public Node getChildIndex(int index){
        return childs.get(index);
    }
    
}
