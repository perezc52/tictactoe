/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
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
    public MediumComputer()
    {
        super("MediumComputer");
        //this.currentPlayer= player;
        /*create a new empty array list*/
        openSquares = new ArrayList<>();
    }
   
    @Override
    public Position makeMove(byte [][] allSquares, byte [][] scores, byte playerNo)
    {
        byte sign;
        Position bestMove = new Position();
        byte bestScore = 0;
        Random xy = new Random();
        
        
        if (playerNo == 1)
            sign = 1;
        else
            sign = -1;
        
        for (int way = 0; way < 2; way++) //0 forward 1 backward
        {
            for (int rowType = 0; rowType < NUMBER_OF_ROWS * 2 + 2; rowType++) //[row1, row2, row3, row4, row5 col1, col2, col3, col4, col5 diag1, diag2]
            {
                if (scores[way][rowType] == 3 * (sign * -1)) //see enemy score
                {
                    byte lowerBound;
                    byte upperBound;
                    
                    if (way == 0)
                    {
                        lowerBound = 0;
                        upperBound = 4;
                    }
                    else
                    {
                        lowerBound = 1;
                        upperBound = 5;
                    }
                    if (rowType < 5) //horizontal
                    {
                        for (int col = lowerBound; col < upperBound; col++) //loop through game
                        {
                            if (allSquares[rowType][col] == 0)
                                return new Position(rowType, col);
                        }
                    }
                    else if (rowType > 4 && rowType < 10)
                    {
                        for (int row = lowerBound; row < upperBound; row++) //loop through game
                        {
                            if (allSquares[row][rowType - 5] == 0)
                                return new Position(row, rowType - 5);
                        }
                    }
                    else if (rowType == 10) //top left to bottom right diagonal
                    {
                        for (int i = lowerBound; i < upperBound; i++)
                        {
                            if (allSquares [i][i] == 0)
                                return new Position(i,i);
                        }
                    }
                    else //top right to bottom left diagonal
                    {
                        for (int i = upperBound - 1; i > lowerBound - 1; i--)
                        {
                            if (allSquares [i][i] == 0)
                                return new Position(i,i);
                        }
                    }
                }
                else if ((scores[way][rowType] == 2 * (sign * -1)))
                {
                    byte lowerBound;
                    byte upperBound;
                    
                    lowerBound = 1;
                    upperBound = 4;

                    if (rowType < 5) //horizontal
                    {
                        for (int col = lowerBound; col < upperBound; col++) //loop through game
                        {
                            if (allSquares[rowType][col] == 0)

                                if (bestScore < 2)
                                {
                                    bestScore = 2;
                                    bestMove = new Position(rowType, col);
                                }
                                
                        }
                    }
                    else if (rowType > 4 && rowType < 10)
                    {   
                        for (int row = lowerBound; row < upperBound; row++) //loop through game
                        {
                            if (allSquares[row][rowType - 5] == 0)
                            {
                                if (bestScore < 2)
                                {
                                    bestScore = 2;
                                    bestMove = new Position(row, rowType - 5);
                                }
                            }
                        }
                    }
                    else if (rowType == 10) //top left to bottom right diagonal
                    {
                        for (int i = lowerBound; i < upperBound; i++)
                        {
                            if (allSquares [i][i] == 0)
                            {
                                if (bestScore < 2)
                                {
                                    bestScore = 2;
                                    bestMove = new Position(i, i);
                                }
                            }
                        }
                    }
                    else //top right to bottom left diagonal
                    {
                        for (int i = upperBound - 1; i > lowerBound - 1; i--)
                        {
                            if (allSquares [i][i] == 0)
                            {
                                if (bestScore < 2)
                                {
                                    bestScore = 2;
                                    bestMove = new Position(i, i);
                                }
                            }
                        }
                    }
                }
                else if ((scores[way][rowType] == 1 * (sign * -1)))
                {
                    //put it to the right
                    byte lowerBound;
                    byte upperBound;
                    
                    if (way == 0)
                    {
                        lowerBound = 0;
                        upperBound = 4;
                    }
                    else
                    {
                        lowerBound = 1;
                        upperBound = 5;
                    }

                    if (rowType < 5) //horizontal
                    {
                        for (int col = lowerBound; col < upperBound; col++) //loop through game
                        {
                            if (allSquares[rowType][col] == 0)

                                if (bestScore < 1)
                                {
                                    bestScore = 1;
                                    bestMove = new Position(rowType, col);
                                }
                                
                        }
                    }
                    else if (rowType > 4 && rowType < 10)
                    {   
                        for (int row = lowerBound; row < upperBound; row++) //loop through game
                        {
                            if (allSquares[row][rowType - 5] == 0)
                            {
                                if (bestScore < 1)
                                {
                                    bestScore = 1;
                                    bestMove = new Position(row, rowType - 5);
                                }
                            }
                        }
                    }
                    else if (rowType == 10) //top left to bottom right diagonal
                    {
                        for (int i = lowerBound; i < upperBound; i++)
                        {
                            if (allSquares [i][i] == 0)
                            {
                                if (bestScore < 1)
                                {
                                    bestScore = 1;
                                    bestMove = new Position(i, i);
                                }
                            }
                        }
                    }
                    else //top right to bottom left diagonal
                    {
                        for (int i = upperBound - 1; i > lowerBound - 1; i--)
                        {
                            if (allSquares [i][i] == 0)
                            {
                                if (bestScore < 1)
                                {
                                    bestScore = 1;
                                    bestMove = new Position(i, i);
                                }
                            }
                        }
                    }
                }
            }
        }
        
        if (bestScore == 0)
        {
            setOpenSquares(allSquares);
            xy = new Random();
            return openSquares.get(xy.nextInt(openSquares.size()));  
        }
        else
        {
            return bestMove;
        }
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
//   public int setMove(int currentPlayer, int score[i][j])
//   {
//    if(currentPlayer == 2)
//    {
//       for (int i = 0; i < 2; i++)
//        {
//            for (int j = 0; j < NUMBER_OF_SCORES; j++)
//               {  
//                    /* access the row or column that has a absoulte score of 2 or 3  */
//                   if (Math.abs(scores[i][j]) == 2 )
//                    {
//                        /*get the 2nd empty square box in a row or column*/
//                       for (int x = 0; x >= NUMBER_OF_SCORES; x++ )
//                        {
//                            if (i == 0 && j == 1)
//                            {
//                                /*occupy by the square by player 2*/
//                                 x = x - 1;
//                            }             
//                        }   
//                    }
//                       /*if 3 in a row occupied by player 1*/                      
//                    else if(Math.abs(scores[i][j]) == 3)
//                     {
//                        for (int x = 0; x >=NUMBER_OF_SCORES;x++ )
//                         { 
//                           if (i == 0 && j == 1)
//                            {
//                             x = -1;   
//                            }
//                         }
//                     }
//         }
//   }
 //   }
 //  }
  
//   else if(currentPlayer == 1)
//    {
//       for (int i = 0; i < 2; i++)
//        {
//            for (int j = 0; j < NUMBER_OF_SCORES; j++)
//                {  
//                    /* access the row or column that has a absoulte score of 2 or 3  */
//                   if (Math.abs(scores[i][j]) == -2 )
//                    {
//                        /*get the 2nd empty square box in a row or column*/
//                       for (int x = 0; x >= NUMBER_OF_SCORES; x++ )
//                        {
//                            if (i == 0 && j == 1)
//                             {
//                                /*occupy by the square by player 1*/
//                                 x = 1;
//                            }             
//                        }   
//                    }
//                       /*if 3 in a row occupied by player 2*/                      
//                    else if(Math.abs(scores[i][j]) == -3)
//                     {
//                        for (int x = 0; x >=NUMBER_OF_SCORES;x++ )
//                         { 
//                           if (i == 0 && j == 1)
//                            {
//                             x = 1;   
//                            }
//                         }
//                     }
//         }
//////   }
  
////   }
    
   
   
    
    
    
    
    
    
}
