/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charlie
 */
public class Manager {
      List<Favorites> favList = new ArrayList();
    
    /** 
     *
     
     * @return
     */
    public List<Favorites> getFavWeb(){
        try {
            loadFav();
            System.out.println("file Found");
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("file not found");
        }
       return favList;
   }
    
    private  void loadFav() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("Favorites.txt");
        BufferedReader br = new BufferedReader (fr);
        String ln;
                
        while((ln = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(ln,",");
            
            Favorites fav = new Favorites();
           fav.setWebsite(st.nextToken());
            fav.setCategory(st.nextToken());
            favList.add(fav);
            
        }
        System.out.println("List Size " + favList.size());
   
    }
}
