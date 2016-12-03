/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.Serializable;

/**
 *
 * @author lucy
 */
public class HardComputer extends ComputerPlayer implements Serializable, Movable {
   
    int emptySquares;
    int rowScore;
    private int scores [][];
    
    public HardComputer()
    {
        super("HardComputer");
    }
    
    @Override
    public Position makeMove(byte [][] allSquares)
    {
        return null;
    }

    
    /*defense*/
    /*check for 2 or 3 in a row or column occupied squares by the opponent*/
   public int setMove(int currentPlayer, int rowScore)
   {
   if(currentPlayer == 1){
       if(rowScore == 1 && emptySquares == 3 )||(rowScore == 2 && emptySquares == 2 )|| (rowScore == 3 && emptySquares == 1 ){
          for(int x = 0; x <= 4; x++){
            x = rowScore;  
              if (rowscore == 0){
                  row[i] = 1;
                }
            }
        }
   }  
       
   
   if(currentPlayer == 2){
       if(rowScore == 2 && emptySquares == 3 )||(rowScore == 4 && emptySquares == 2 )|| (rowScore == 6 && emptySquares == 1 ){
          for(int x = 0; x <= 4; x++){
            x = rowScore;  
              if (rowscore == 0){
                  row[i] = 2;
                }
            }
        }
   } 
   


}
