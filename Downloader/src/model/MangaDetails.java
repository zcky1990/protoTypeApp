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
public class MangaDetails {
    private String altName;
    private String genre;
    private String author;
    private String artist;
    private String status;
    private String rank; 
    private String summary;
    private String rating;
    private String urlImageCover;
    private ArrayList<Chapter> chapters;

    public MangaDetails(String altName,String genre,String author,String artist,String status,String rank,String summary,String rating,String urlImageCover ){
        this.altName = altName;
        this.genre = genre;
        this.author = author;
        this.artist = artist;
        this.status = status;
        this.rank = rank;
        this.summary = summary;
        this.rating = rating;
        this.urlImageCover = urlImageCover;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }
       
    public String getAltName() {
        return altName;
    }

    public void setAltName(String altName) {
        this.altName = altName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getUrlImageCover() {
        return urlImageCover;
    }

    public void setUrlImageCover(String urlImageCover) {
        this.urlImageCover = urlImageCover;
    }

}
