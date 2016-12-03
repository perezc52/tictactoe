/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.Serializable;
import java.util.ArrayList;
import static tictactoe.MainMenu.NUMBER_OF_COLUMNS;
import static tictactoe.MainMenu.NUMBER_OF_ROWS;
import javafx.scene.control.Button;
import static tictactoe.MainMenu.NUMBER_OF_SCORES;


/**
 *author @usha
 *
 */
public class MediumComputer extends ComputerPlayer implements Serializable, Movable{

/*current player for the medium AI*/
int currentPlayer;
/*occupied player squares*/
private int score[][];
/*empty squares*/
private ArrayList<Position> openSquares;
public static final int NUMBER_OF_ROWS = 5;
public static final int NUMBER_OF_COLUMNS = 5;
/*score of total number of squares*/
public static final int NUMBER_OF_SCORES = 2 * NUMBER_OF_ROWS + 2;
    
/* player 1 or 2 as AI */
    public MediumComputer(int player)
    {
        super("MediumComputer");
        this.currentPlayer= player;
        /*create a new empty array list*/
        openSquares = new ArrayList<>();
    }
   
    @Override
    public Position makeMove(byte [][] allSquares)
    {
        return null;
    }
    
    
  /*modifier for setting a new empty board */
    public void setOpenSquares(byte [][] allSquares){
    openSquares.clear();
    
     for (int i = 0; i < NUMBER_OF_ROWS; i++)
        {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++)
            {
                /*set squares to 0*/
                if (allSquares[i][j] == 0)
                    openSquares.add(new Position(i, j));
            }
        }
    }
    
    /* attack : check for 2 or 3 in a row or column sqaures occupied squares by the opponent*/
   public int setMove(int currentPlayer, int score[i][j])
   {
    if(currentPlayer == 2)
    {
       for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < NUMBER_OF_SCORES; j++)
                {  
                    /* access the row or column that has a absoulte score of 2 or 3  */
                   if (Math.abs(scores[i][j]) == 2 )
                    {
                        /*get the 2nd empty square box in a row or column*/
                       for (int x = 0; x >= NUMBER_OF_SCORES; x++ )
                        {
                            if (i == 0 && j == 1)
                             {
                                /*occupy by the square by player 2*/
                                 x = -1;
                            }             
                        }   
                    }
                       /*if 3 in a row occupied by player 1*/                      
                    else if(Math.abs(scores[i][j]) == 3)
                     {
                        for (int x = 0; x >=NUMBER_OF_SCORES;x++ )
                         { 
                           if (i == 0 && j == 1)
                            {
                             x = -1;   
                            }
                         }
                     }
         }
   }
  
   else if(currentPlayer == 1)
    {
       for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < NUMBER_OF_SCORES; j++)
                {  
                    /* access the row or column that has a absoulte score of 2 or 3  */
                   if (Math.abs(scores[i][j]) == -2 )
                    {
                        /*get the 2nd empty square box in a row or column*/
                       for (int x = 0; x >= NUMBER_OF_SCORES; x++ )
                        {
                            if (i == 0 && j == 1)
                             {
                                /*occupy by the square by player 1*/
                                 x = 1;
                            }             
                        }   
                    }
                       /*if 3 in a row occupied by player 2*/                      
                    else if(Math.abs(scores[i][j]) == -3)
                     {
                        for (int x = 0; x >=NUMBER_OF_SCORES;x++ )
                         { 
                           if (i == 0 && j == 1)
                            {
                             x = 1;   
                            }
                         }
                     }
         }
   }
  
   }
    
   
   
    
    
    
    
    
    
}
