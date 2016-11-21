/*
 * takes in the current username and verify for registered users
 * New player: instance of Player object and store in the arrayList
 * Returning user: access the stored player object
 */

package tictactoe;
import java.util.ArrayList;

/**
 *
 * @author usha
 */
public class Player {
    /**
     * @param args the command line arguments
     */
    
    String username;
    int numberOfLosses = 0;
    int numberOfWins = 0;
  //  image visualRepresentation;
    
    
    /* created player object classes */
    ArrayList <Player> playerList;
    
    /*default constructor*/
    public Player (){
    
    }
    
    /* para arg: username of the current player */
    public Player(String userName, int winDefault, int lossDefault){
    
    /*class global variable access the current username value*/
    this.username = userName;
    }
    
    
   String getUserName ( Player userName ){
      
    username = userName.toString();
    return username;
    }
    
    
    /* get number of total wins for the player*/
    int getNumberOfWin(Object player){
       /*access player class needed*/
        player.getClass();
        
        /* return player's value for number of wins*/
        return
        this.numberOfWins;
                
    }
    
    int getNumberOfLoss(Object player){
    /*access player class needed*/
        player.getClass();
        
        /* return player's value for number of Losses*/
        return
        this.numberOfLosses;
  
    }
    
  
    int getWinLossRatio(Object player){
    int winTotal= this.getNumberOfWin(player);
    int lossTotal= this.getNumberOfLoss(player);
    
    int winLossRatio = winTotal/lossTotal;
    return
         winLossRatio;   
    }
    
     
    /*increment by one when won */
    void incrementWin(Object player, int numberOfWins ){
    
        this.getNumberOfWin(player);
        numberOfWins++;
    
    }
    
    /*increment by one when loss*/
    void incrementLoss(Object player,int numberOfLoss){
        
        this.getNumberOfLoss(player);
        numberOfLoss++;
        
    }
    
  //  void setVisualRepresentation(){}
    
  //  image getVisialRepresenation(){}   
}