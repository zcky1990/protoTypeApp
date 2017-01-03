/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author soeltan_z
 */
public class Pages {
    ArrayList<String> pageMangaUrl;
    
    public Pages(ArrayList<String> urlspages){
        this.pageMangaUrl = urlspages;
    }

    public ArrayList<String> getPageMangaUrl() {
        return pageMangaUrl;
    }

    public void setPageMangaUrl(ArrayList<String> pageMangaUrl) {
        this.pageMangaUrl = pageMangaUrl;
    }
    
}
