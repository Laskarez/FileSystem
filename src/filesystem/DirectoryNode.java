/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filesystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class DirectoryNode extends Node{
    
    private ArrayList<Node> childs = new ArrayList<>();

    public DirectoryNode(String pName, int pKey, List<Integer> pSectors) {
        super(pName, pKey, pSectors);

    }
    
    public void addChild(Node child){
        childs.add(child);
    }

    public Node getChildIndex(int index){
        return childs.get(index);
    }

    public ArrayList<Node> getChilds(){
        return childs;
    }
    
}
