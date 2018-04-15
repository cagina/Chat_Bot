/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_bot_projesi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;


/**
 *
 * @author açt
 */
public final class senticnet4_HashMap {
     
     private final HashMap[] source ;
     private final HashMap<String ,Double> in_map ;
    
    public senticnet4_HashMap () throws IOException
    {   
        this.source =new HashMap[27];
        this.in_map =new HashMap<>();
        setSenticnet4_HashMap();}
    
    public double getValue(String y)
    {   
       if(!y.equals(""))
       {
       
           char x = y.toUpperCase(Locale.ENGLISH).charAt(0);
           
           HashMap<String ,Double> value;
       
            if((x-64)>0 && (x-64)<27)
                value= this.source[x-64];
            else
                value= this.source[0];
       
            try {
            
                 value.get(y);
                    return (value.get(y));
        
                } catch(NullPointerException e) {
            
                    return 0.0;
                }
        }
      return 0.0;
       
    }
    
    public void locationToString(int a)
    {
         HashMap<String ,Double> value= this.source[a];
         
         value.entrySet().forEach((entry) -> {
             System.out.println(entry.getKey() + "/" + entry.getValue());
         });
    
    }
    
    public void setSenticnet4_HashMap() throws FileNotFoundException, IOException
    {
    
         try (BufferedReader in = new BufferedReader(new FileReader("senticnet4.txt"))) {
             
             String line;
             
             int location = -1;
             
             char xcpy = '3';
             
             line = in.readLine();
             
             while(true)
             {
                 String[] division = line.split("\\s+");
                 
                 if(!division[2].isEmpty())
                 {
                     char x = division[0].toUpperCase(Locale.ENGLISH).charAt(0);
                     double number = Double.parseDouble(division[2].replaceAll(" ","."));
                     
                     if(xcpy == x)
                         this.in_map.put( division[0].replaceAll("_","").toUpperCase(),number);
                     
                     else
                     {
                         ++location;
                         
                         HashMap<String,Double> flag_map=new HashMap<>();
                         
                         flag_map=(HashMap<String, Double>) this.in_map.clone();
                         
                         this.source[location]=flag_map;
                         this.in_map.clear();
                         this.in_map.put( division[0].replaceAll("_","").toUpperCase(),number);
                     }
                     xcpy=x;
                 }
                 line = in.readLine();
                 if(line == null)
                 { ++location;  this.source[location] = this.in_map;  break;    }
             }}
        
    }
    
    
}