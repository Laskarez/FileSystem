/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 *
 * @author Daniel
 */
public class FileNode extends Node{
    
    private String extention;
    private String content;
    private String createDate;
    private String modificationDate;
    private long size;

    public FileNode(String pName, int pKey, List<Integer> pSectors, String pExtention, String pContent, String pCreateDate) {

        super(pName, pKey, pSectors);
        this.extention = pExtention;
        this.content = pContent;
        this.createDate = pCreateDate;
        this.modificationDate = "No se ha modificado aun";
    }

    public String getExtention() {
        return extention;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String pContent){
        this.content = pContent;
    }

    public String getCreationDate() {
        return createDate;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public long getSize() { return size; }

    @Override
    public String getName() {
        return super.getName();
    }


}
