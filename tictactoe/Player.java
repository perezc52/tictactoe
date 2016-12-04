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
public class Player implements Serializable, Movable {
    /**
     * @param args the command line arguments
     */
    
    private String username;
    private int numberOfLosses;
    private int numberOfWins;
    private double winLossRatio;
    //public static int guestNumber = 0;
    private static final long serialVersionUID = 1L;
  //  image visualRepresentation;
    
    
    /* created player object classes */
    //ArrayList <Player> playerList;
    
    /*default constructor*/
    public Player (){
        this.username = "mufasa";
        this.numberOfLosses = 0;
        this.numberOfWins = 0;
        this.winLossRatio = 0;
        
    }
    
    /* para arg: username of the current player */
//    public Player(String userName, int winDefault, int lossDefault)
//    {
//    
//    /*class global variable access the current username value*/
//    this.username = userName;
//    this.numberOfWins = winDefault;
//    this.numberOfLosses = lossDefault;
//    this.winLossRatio = 0;
//    }
    
    public Player(String username)
    {
        this.username = username;
        this.numberOfWins = 0;
        this.numberOfLosses = 0;
        this.winLossRatio = 0;
    }
    
    
    public String getUsername ( ){
      
    //username = userName.toString();
    return username;
    }
    
    
    /* get number of total wins for the player*/
    public int getNumberOfWins(){
//       /*access player class needed*/
//        player.getClass();
        
        /* return player's value for number of wins*/
        return
        this.numberOfWins;
                
    }
    
    public int getNumberOfLosses(){
//    /*access player class needed*/
//        player.getClass();
        
        /* return player's value for number of Losses*/
        return
        this.numberOfLosses;
  
    }
    
  
    public double getWinLossRatio(){
    
        return winLossRatio;   
    }
    
     
    /*increment by one when won */
    public void incrementWin(){
    
        numberOfWins++;
        setWinLossRatio();
    
    }
    
    /*increment by one when loss*/
    public void incrementLoss(){
        
        numberOfLosses++;
        setWinLossRatio();
        
    }
    
  //  void setVisualRepresentation(){}
    
  //  image getVisialRepresenation(){}   

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @param winLossRatio the winLossRatio to set
     */
    public void setWinLossRatio() {
        try
        {
            this.winLossRatio = numberOfWins / numberOfLosses;
        }
        catch (ArithmeticException ex)
        {
            this.winLossRatio = numberOfWins;
        }
    }
    
    public Position makeMove(byte [][] allSquares, byte [][] scores, byte playerNo)
    {
        return null;
    }
}