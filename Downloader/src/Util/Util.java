/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soeltan_z
 */
public class Util {
    public void generateConfig(){
        String config = "[\n" +
                        "  {\n" +
                        "    \"manga_site\": \"MangaHere\",\n" +
                        "    \"manga_url\":\"http://www.mangahere.co/mangalist/\",\n" +
                        "    \"config\": {\n" +
                        "      \"manga_list\": \"manga_info\",\n" +
                        "      \"description\": \"manga_detail_top\",\n" +
                        "      \"chapter\": \"detail_list\",\n" +
                        "      \"pages\": \"wid60\",\n" +
                        "      \"image\": \"viewer\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "]";
         try{
            PrintWriter writer = new PrintWriter("config_manga", "UTF-8");
            writer.println(config);
            writer.close();
         } catch (IOException e) {

        }
    }
    
    public String requestFile(String fileName){
		File file = new File(fileName);
		FileInputStream fis = null;
                try {
                    fis = new FileInputStream(file);
                } catch (FileNotFoundException ex) {
                    return "fileNotFound";
                }
	
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line;
		String textStr = "";
		try {
			while ((line = br.readLine()) != null) {
				textStr = textStr + line;
			} 
		
			br.close();
		} catch (IOException e) {

		}
		try {
			br.close();
			fis.close();
		} catch (IOException e) {

		}
		return textStr;
	}
}
