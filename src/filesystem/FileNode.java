/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filesystem;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 *
 * @author Daniel
 */
public class FileNode extends Node{
    
    private String extention;
    private String content;

    public FileNode(String pName, int pKey, ArrayList<Integer> pSectors, String pExtention, String pContent) {

        super(pName, pKey, pSectors);
        this.extention = pExtention;
        this.content = pContent;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
