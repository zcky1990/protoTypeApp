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
import model.Chapter;
import model.Manga;
import model.MangaDetails;
import model.Pages;
import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author soeltan_z
 */
public class MangaDownloaderAPI {
    
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
    
    
    public ArrayList<Manga> getMangaList (Document doc, String classId) throws JSONException{
    ArrayList<Manga> mangaList = new ArrayList<Manga>();
    Elements listManga = doc.getElementsByClass(classId);
    for (Element mangalist : listManga) {
      String linkHref = mangalist.attr("href");
      String linkText = mangalist.text();
      Manga manga = new Manga(linkHref, linkText);
      mangaList.add(manga);
    }
    return mangaList;
    }
    
    
    public MangaDetails getMangaDescription (String url, String classId) throws JSONException{
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
        
        MangaDetails manga = new MangaDetails(altName,genre,author,artist,status,rank,summary,rating,urlImageCover );
        return manga;
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
     

    public ArrayList<Chapter> getMangaChapter(String Url, String id) throws JSONException{
         Document detailsManga = connectToMangaSite(Url);
         Elements mangaChapters = detailsManga.getElementsByClass(id).select("ul").select("a");
        ArrayList<Chapter> chapterList = new ArrayList<Chapter>();
         for(Element chap : mangaChapters){
             String urlChapter = chap.attr("href");
             String titleChapter = chap.text();
             Chapter chapters = new Chapter(urlChapter,titleChapter);
             chapterList.add(chapters);
         }
        return chapterList;
    }
    
    public Pages getChapterPageList (String url, String classId){
        
    ArrayList<String> pageList = new ArrayList<String>();
    Document doc = connectToMangaSite(url);
    Elements pages = doc.select("select[class='"+classId+"']").first().getAllElements();
    for(Element page : pages){
        String urlPage = page.val();
        if(!urlPage.equalsIgnoreCase("")){
             pageList.add(urlPage);
        }
    }
    Pages pageChapter = new Pages(pageList);
    return pageChapter;
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

