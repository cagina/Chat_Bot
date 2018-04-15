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
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


/**
 *
 * @author Açt
 */
public  class Tweet {
    
    private final senticnet4_HashMap yeni;
    
    public Tweet() throws FileNotFoundException, UnsupportedEncodingException, IOException
    {
      this.yeni = new senticnet4_HashMap();
    }
    public double get_TweetPolarity(String NameProduct) throws FileNotFoundException, IOException
    {
        double polarity=0;
            
        BufferedReader r=new BufferedReader(new FileReader(""+NameProduct+".txt"));
        
        int ch;  
        
        String line=""; 
        
        int control = 0;
        
        int tweet_count = 0;
        
        ArrayList<String> div = new ArrayList();
        
        while((ch=r.read())!=-1){
            
            if(ch ==','|| ch == '.' || ch =='\'')
            {ch = ' ';}
            line+=(char)ch;
            if(ch =='\n')
            {++control;}    
            if(ch == '@' && control>0)
            {   
         
                ++tweet_count;
                polarity+= senticnet_search(div);
                div.clear();
                control = 0 ;
             
            }
            if(ch == ' ' || ch =='\n')
            { div.add(line.replaceAll("\"", ""));   line = "";}
            

       }
       return polarity/tweet_count;
    }
    public double senticnet_search(ArrayList<String> div)
    {
        double polarity = 0.0;        
         String tweet = " ";
        for(int j = 1 ; j< div.size()-1;j++)
        {   
         
            if(!div.get(j).equals(" "))
            {
                    tweet+=""+div.get(j).replaceAll("\\s+","");
                    polarity+=yeni.getValue(tweet.toUpperCase());
                     for(int i = j+1 ;i<div.size()-1;i++)
                         
                     {
                          if(!div.get(i).equals(" "))
                          {
                              tweet+=""+div.get(i).replaceAll("\\s+","");
                              polarity+=yeni.getValue(tweet.toUpperCase());
                          }
                    }
            }
                
             tweet="";    
        }
      
    
    return polarity;
    
    }        
            
    public String getBest_tweet(String NameProduct) throws FileNotFoundException, IOException
    {
      
        BufferedReader r=new BufferedReader(new FileReader(""+NameProduct+".txt"));
        
        int ch; 
        
        String best_tweet=""; 
        
        int temporary=-1; 
        
        String line=""; 
        
        int control = 0;
        
        ArrayList<String> div = new ArrayList();
        
        while((ch=r.read())!=-1){
            
            if(ch ==',')
            {ch = ' ';}
            line+=(char)ch;
            if(ch =='\n')
            {++control;}    
            if(ch == '@' && control>0)
            {   
                if(temporary<(int) Double.parseDouble(div.get(div.size()-1).replaceAll(" ",".")) )
                     {
                       best_tweet = "";
                       for(int i = 0 ; i< div.size()-1;i++)
                        best_tweet+=div.get(i);
                       {temporary=(int) Double.parseDouble(div.get(div.size()-1).replaceAll(" ","."));}
                        div.clear();
                     }
                
                control = 0 ;
         
                div.clear();
            }
            if(ch == ' ' || ch =='\n')
            { div.add(line);   line = "";}
        }
       
        return best_tweet;
    
    }
     
    public void getTweet_WrietTxt(String NameofProduct) throws FileNotFoundException, UnsupportedEncodingException
    {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
        .setOAuthConsumerKey("")
        .setOAuthConsumerSecret("")
        .setOAuthAccessToken("")
        .setOAuthAccessTokenSecret("");
        Twitter twitter = new TwitterFactory(cb.build()).getInstance();
 
   try {
        
           
            Query query = new Query("#"+NameofProduct).lang("en");
            query.setResultType(Query.POPULAR);
            QueryResult result;
            int sayac=0;
              PrintWriter writer = new PrintWriter(""+NameofProduct+".txt", "UTF-8");
            do{
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                tweets.stream().map((tweet) -> {
                    writer.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText()+" - "+tweet.getFavoriteCount());
                    return tweet;
                }).forEachOrdered((tweet) -> {
                    System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText() +" - "+tweet.getFavoriteCount());
                });
                writer.close();
                sayac++;
            } while ((query = result.nextQuery()) != null && sayac<11);
            System.exit(0);
        } catch (TwitterException te) {
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    
    
    }
     
}
