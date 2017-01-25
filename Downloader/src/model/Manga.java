/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author soeltan_z
 */
public class Manga {
    private String urlManga;
    private String title;
    private MangaDetails mangaDetails;

    public Manga(String urlManga,String title){
        this.urlManga =urlManga;
        this.title = title;
    }
    
    public String getUrlManga() {
        return urlManga;
    }

    public void setUrlManga(String urlManga) {
        this.urlManga = urlManga;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MangaDetails getMangaDetails() {
        return mangaDetails;
    }

    public void setMangaDetails(MangaDetails mangaDetails) {
        this.mangaDetails = mangaDetails;
    }
   
    
}
