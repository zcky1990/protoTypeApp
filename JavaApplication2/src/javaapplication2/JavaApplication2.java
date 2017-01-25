/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import javaapplication2.test.downloadListener;

/**
 *
 * @author soeltan_z
 */
public class JavaApplication2 implements downloadListener{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JavaApplication2 test = new JavaApplication2();
        System.out.println(test.getDownloadManga());
    }

    @Override
    public String getDownloadManga() {
       return  testMangaValue;
    }

    
    
}
