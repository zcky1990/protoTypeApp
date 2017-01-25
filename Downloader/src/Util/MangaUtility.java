/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Manga;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.nodes.Document;

/**
 *
 * @author soeltan_z
 */
public class MangaUtility {
    
    public void generateMangaList(String mangaSite, String mangaUrl, String classId) throws JSONException{
        MangaDownloaderAPI zaki = new MangaDownloaderAPI();
        Document doc = zaki.connectToMangaSite(mangaUrl);
        ArrayList<Manga> mangaList = zaki.getMangaList(doc, classId);
        
        try{
            PrintWriter writer = new PrintWriter(mangaSite, "UTF-8");
            generateText(writer,mangaList );
            writer.close();
         } catch (IOException e) {

        }

    }
    
   public void generateText(PrintWriter writer, ArrayList<Manga> mangaList) throws JSONException{
       JSONArray list = new JSONArray();
       for(int i = 0 ; i < mangaList.size(); i++){
            Manga manga = mangaList.get(i);
            String title = manga.getTitle();
            String mangaUrl = manga.getUrlManga();
            JSONObject mang = new JSONObject();
            mang.put("title", title);
            mang.put("manga_url", mangaUrl);
            list.put(mang);
       }
       writer.println(list);
   }
   
   public ArrayList<Manga> readMangaList(String mangaSite) throws JSONException, IOException{
   Util util = new Util();
   ArrayList<Manga>  mangaList = new ArrayList<Manga>();
   String list = util.requestFile(mangaSite);
   JSONArray listManga;
   
   if(!list.equalsIgnoreCase("fileNotFound")){
        listManga = new JSONArray(list);
   }else {
       listManga = new JSONArray();
   }
   
   for(int i = 0 ; i < listManga.length(); i++){
        JSONObject manga = listManga.getJSONObject(i);
        String title = manga.getString("title");
        String manga_url = manga.getString("manga_url");
        Manga mangaBook = new Manga( manga_url, title);
        mangaList.add(mangaBook);
   }
   return mangaList;
   }
}
