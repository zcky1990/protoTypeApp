/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author soeltan_z
 */
public class MangaDownloaderController {
    
    public Document connectToMangaSite (String url){
        Document doc = null;
        try {
            doc = Jsoup.connect(url).header("Accept-Encoding", "gzip, deflate")
            .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
            .maxBodySize(0)
            .timeout(600000)
            .get();
        } catch (IOException ex) {
            Logger.getLogger(MangaDownloaderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doc;
    }
    
    
    public JSONArray getMangaList (Document doc, String classId) throws JSONException{
    JSONArray mangaList = new JSONArray();
    Elements listManga = doc.getElementsByClass(classId);

    for (Element manga : listManga) {
      String linkHref = manga.attr("href");
      String linkText = manga.text();
      JSONObject mangaUrl = new JSONObject ();
      mangaUrl.put("url", linkHref);
      mangaUrl.put("title", linkText);
      mangaList.put(mangaUrl);
    }
    return mangaList;
    }
    
    
    public JSONObject getMangaDescription (String url, String classId) throws JSONException{
        JSONObject mangaDetails = new JSONObject();
        Document detailsManga = connectToMangaSite(url);
        Elements details = detailsManga.getElementsByClass(classId);
        
        String altName =  getDesc(detailsManga,"alternative name" );
        String genre  = getDesc(detailsManga,"genre" );
        String author  = getDescAutorsOrArtistsOrSummary(detailsManga,"author" );
        String artist  =  getDescAutorsOrArtistsOrSummary(detailsManga,"artist");
        String status  =  getDesc(detailsManga,"status");
        String rank  = getDesc(detailsManga,"rank");
        String summary  = getDescAutorsOrArtistsOrSummary(detailsManga,"summary").replaceAll("Show less","");

        String rating = detailsManga.getElementsByClass("scores").first().text();
        String urlImageCover = getMangaCover(details);
        
        mangaDetails.put("img_url", urlImageCover);
        mangaDetails.put("rate", rating);
        mangaDetails.put("alt_Name", altName);
        mangaDetails.put("genre", genre);
        mangaDetails.put("author", author);
        mangaDetails.put("artist", artist);
        mangaDetails.put("status", status);
        mangaDetails.put("rank", rank);
        mangaDetails.put("summary", summary);
        return mangaDetails;
    }
    
    public String getMangaCover (Elements mangaDetails){
       Elements mangaCover = mangaDetails.select("img");
       String url = mangaCover.attr("abs:src");
     return url;
    }
    
    public String getDesc (Document detailsManga ,String textName){
        Element name = detailsManga.getElementsContainingOwnText(textName).first().parent();
        name.children().remove();
    return name.text();
    }
    
     public String getDescAutorsOrArtistsOrSummary (Document detailsManga ,String textName){
        Element name = detailsManga.getElementsContainingOwnText(textName).first().parent();
        name.children().first().remove();
    return name.text();
    }
     
     
    public JSONArray getMangaChapter(String Url, String id) throws JSONException{
        JSONArray mangaChapterList = new JSONArray();
         Document detailsManga = connectToMangaSite(Url);
         Elements mangaChapters = detailsManga.getElementsByClass(id).select("ul").select("a");
         for(Element chapter : mangaChapters){
             String urlChapter = chapter.attr("href");
             String titleChapter = chapter.text();
             JSONObject chap = new JSONObject();
             chap.put("chapter_url", urlChapter);
             chap.put("chapter_title", titleChapter);
             mangaChapterList.put(chap);
         }
        return mangaChapterList;
    }
    
    public ArrayList<String> getChapterPageList (String url, String classId){
    ArrayList<String> pageList = new ArrayList<String>();
    Document doc = connectToMangaSite(url);
    Elements pages = doc.select("select[class='"+classId+"']").first().getAllElements();
    for(Element page : pages){
        String urlPage = page.val();
        if(!urlPage.equalsIgnoreCase("")){
             pageList.add(urlPage);
        }
    }
    return pageList;
    }
    
    public String getImage(String urlPage, String id){
        Document doc = connectToMangaSite(urlPage);
        Elements imageUrl = doc.getElementById(id).select("img");
        String urlImage = "";
        for(Element img: imageUrl){
            String url = img.attr("src");
            if(url.toLowerCase().contains(".jpg")||url.toLowerCase().contains(".png")){
                urlImage = img.attr("src");
                break;
            }
        }
        return urlImage;
    }
}
