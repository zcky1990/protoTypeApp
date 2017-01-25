/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import Util.MangaDownloaderAPI;
import Util.MangaDownloaderController;
import Util.MangaUtility;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Chapter;
import model.Manga;
import model.MangaDetails;
import model.Pages;
import org.json.JSONArray;
import org.json.JSONException;
import org.jsoup.nodes.Document;

/**
 *
 * @author soeltan_z
 */
public class JavaFXApplication2 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws JSONException {
        Button btn = new Button();
        
            MangaUtility test = new MangaUtility();
           // test.generateMangaList("MangaHere","http://www.mangahere.co/mangalist/","manga_info" );
        
            ArrayList<Manga> mangaListArray = test.readMangaList("MangaHere");
            System.out.println(mangaListArray.get(7).getTitle());
            System.out.println(mangaListArray.get(7).getUrlManga());
        
        //try layout
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        BorderPane border = new BorderPane();
        BorderPane innerBorder = new BorderPane();
        
        //kotak Vertical
        VBox vboxbot = new VBox();
        vboxbot.getStyleClass().add("vbox");
        innerBorder.setBottom(vboxbot);
        
        VBox vboxtop = new VBox();
        vboxtop.getStyleClass().add("vbox");
        innerBorder.setTop(vboxtop);
        border.setRight(innerBorder);
        
        //kotak horizontal
        HBox hbox = new HBox();
        hbox.getStyleClass().add("hbox");
        border.setLeft(hbox);
        
        //button
        Button buttonCurrent = new Button("Current");
        buttonCurrent.setPrefSize(100, 20);
        buttonCurrent.setText("Say 'Hello World'");
        
        buttonCurrent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vboxtop.getChildren().add(new Text(mangaListArray.get(7).getTitle()));
            }
        });
        
        //text
        Text t = new Text();
        t.setText("This is a text sample");
        
        hbox.getChildren().add(buttonCurrent);
        hbox.getChildren().add(t);
        
        Scene scene = new Scene(border);
        scene.getStylesheets().add("css/layout.css");
        
        //add scene to stage
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JSONException {
           
//        MangaDownloaderController test = new MangaDownloaderController();
//        Document doc = test.connectToMangaSite("http://www.mangahere.co/mangalist/");
//        JSONArray mangaList = test.getMangaList(doc, "manga_info");
//        test.getMangaDescription(mangaList.getJSONObject(0).getString("url"),"manga_detail_top");
//        JSONArray chapterManga = test.getMangaChapter(mangaList.getJSONObject(0).getString("url"),"detail_list");
//        String url = chapterManga.getJSONObject(0).getString("chapter_url");
//        System.err.println("url chapter " + url);
//        ArrayList<String> pages = test.getChapterPageList(url , "wid60");
//        test.getImage(pages.get(0), "viewer");
        
//            MangaUtility test = new MangaUtility();
//            test.generateMangaList("MangaHere","http://www.mangahere.co/mangalist/","manga_info" );
//        
//            ArrayList<Manga> mangaListArray = test.readMangaList("MangaHere");
//            System.out.println(mangaListArray.get(7).getTitle());
//            System.out.println(mangaListArray.get(7).getUrlManga());
      
//        MangaDownloaderAPI zaki = new MangaDownloaderAPI();
//        Document doc = zaki.connectToMangaSite("http://www.mangahere.co/mangalist/");
//        ArrayList<Manga> mangaList = zaki.getMangaList(doc, "manga_info");
//        System.out.println(mangaList.get(0).getTitle());
//        
//        //get Manga List
//        Manga manga = mangaList.get(4);
//        System.out.println(manga.getUrlManga());
//        
//        //get Manga Description
//        MangaDetails detailsManga = zaki.getMangaDescription( manga.getUrlManga(),"manga_detail_top");
//        manga.setMangaDetails(detailsManga);
//        System.out.println(manga.getMangaDetails().getAltName());
//        
//        //get manga Chapters
//        ArrayList<Chapter> mangaChapter = zaki.getMangaChapter(manga.getUrlManga(), "detail_list");
//        manga.getMangaDetails().setChapters(mangaChapter);
//        System.out.println(manga.getMangaDetails().getChapters().get(2).getChapterTitle());
//        System.out.println(manga.getMangaDetails().getChapters().get(2).getUrlChapter());
//        
//        //get chapter Pages
//        Pages chapterPages = zaki.getChapterPageList(manga.getMangaDetails().getChapters().get(2).getUrlChapter(), "wid60");
//        manga.getMangaDetails().getChapters().get(2).setPage(chapterPages);
//        System.out.println(manga.getMangaDetails().getChapters().get(2).getPage().getPageMangaUrl().get(9));
//        
//        //load Image
//        String url = zaki.getImage(manga.getMangaDetails().getChapters().get(2).getPage().getPageMangaUrl().get(9), "viewer");
//        System.out.println(url);

        launch(args);
    }
    
}
