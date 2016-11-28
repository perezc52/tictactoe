/*
 * takes in the current username and verify for registered users
 * New player: instance of Player object and store in the arrayList
 * Returning user: access the stored player object
 */

package tictactoe;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author usha
 */
public class Player implements Serializable {
    /**
     * @param args the command line arguments
     */
    
    private String username;
    private int numberOfLosses;
    private int numberOfWins;
  //  image visualRepresentation;
    
    
    /* created player object classes */
    ArrayList <Player> playerList;
    
    /*default constructor*/
    public Player (){
        this.username = "mufasa";
        this.numberOfLosses = 0;
        this.numberOfWins = 0;
        
    }
    
    /* para arg: username of the current player */
    public Player(String userName, int winDefault, int lossDefault)
    {
    
    /*class global variable access the current username value*/
    this.username = userName;
    this.numberOfWins = winDefault;
    this.numberOfLosses = lossDefault;
    }
    
    public Player(String username)
    {
        this.username = username;
        this.numberOfWins = 0;
        this.numberOfLosses = 0;
    }
    
    
    public String getUserName ( ){
      
    //username = userName.toString();
    return username;
    }
    
    
    /* get number of total wins for the player*/
    public int getNumberOfWin(){
//       /*access player class needed*/
//        player.getClass();
        
        /* return player's value for number of wins*/
        return
        this.numberOfWins;
                
    }
    
    public int getNumberOfLoss(){
//    /*access player class needed*/
//        player.getClass();
        
        /* return player's value for number of Losses*/
        return
        this.numberOfLosses;
  
    }
    
  
    double getWinLossRatio(){
    
    
    double winLossRatio = numberOfWins/numberOfLosses;
    return
         winLossRatio;   
    }
    
     
    /*increment by one when won */
    public void incrementWin(){
    
        numberOfWins++;
    
    }
    
    /*increment by one when loss*/
    public void incrementLoss(){
        
        numberOfLosses++;
        
    }
    
  //  void setVisualRepresentation(){}
    
  //  image getVisialRepresenation(){}   

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
}