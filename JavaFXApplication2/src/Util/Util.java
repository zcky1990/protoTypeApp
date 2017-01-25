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

/**
 *
 * @author soeltan_z
 */
public class Util {
    
    public String requestFile(String fileName){
		File file = new File(fileName);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
                    
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
