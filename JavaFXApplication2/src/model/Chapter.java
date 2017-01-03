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
public class Chapter {
    private String urlChapter;
    private String chapterTitle;
    private Pages pages;

    public Chapter(String urlChapter, String chapterTitle){
        this.urlChapter = urlChapter;
        this.chapterTitle = chapterTitle;
    }
    
    public Pages getPage() {
        return pages;
    }

    public void setPage(Pages page) {
        this.pages = page;
    }
       
    public String getUrlChapter() {
        return urlChapter;
    }

    public void setUrlChapter(String urlChapter) {
        this.urlChapter = urlChapter;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }
    
}
