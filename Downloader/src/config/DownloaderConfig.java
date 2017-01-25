/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import static downloader.MangaDownloader.util;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author soeltan_z
 */
public class DownloaderConfig {
    private String mangaSite;
    private String manga_list;
    private String manga_url;
    private String description;
    private String chapter;
    private String pages;
    private String image;
    
    public void setMangaConfig(String defaultMangaSite) throws JSONException, IOException{
        String test = util.requestFile("config_manga");
        if(test.equalsIgnoreCase("fileNotFound")){
            util.generateConfig();
            test = util.requestFile("config_manga");
        }
        JSONArray config;
        if(!test.equalsIgnoreCase("fileNotFound")){
            config = new JSONArray(test);
        }else {
            config = new JSONArray();
        }
        for(int i = 0 ; i < config.length(); i++){
            JSONObject mangaConfig = config.getJSONObject(i);
            String siteManga = mangaConfig.getString("manga_site");
            String url = mangaConfig.getString("manga_url");
            JSONObject siteConfig = mangaConfig.getJSONObject("config");
            if(siteManga.equalsIgnoreCase(defaultMangaSite)){
                this.mangaSite = siteManga;
                this.manga_url = url;
                this.manga_list = siteConfig.getString("manga_list");
                this.description = siteConfig.getString("description");
                this.chapter = siteConfig.getString("chapter");
                this.pages = siteConfig.getString("pages");
                this.image = siteConfig.getString("image");
                break;
            }
        }
    }

    public String getMangaSite() {
        return mangaSite;
    }

    public void setMangaSite(String mangaSite) {
        this.mangaSite = mangaSite;
    }

    public String getManga_list() {
        return manga_list;
    }

    public void setManga_list(String manga_list) {
        this.manga_list = manga_list;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getManga_url() {
        return manga_url;
    }

    public void setManga_url(String manga_url) {
        this.manga_url = manga_url;
    }
    
    
}
