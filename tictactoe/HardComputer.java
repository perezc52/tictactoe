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
//import java.util.Arrays;
//import java.util.HashSet;
import java.util.Random;
//import java.util.Set;
//import static tictactoe.MediumComputer.NUMBER_OF_COLUMNS;
//import static tictactoe.MediumComputer.NUMBER_OF_ROWS;



/**
 *
 * @author lucy
 */
public class HardComputer extends ComputerPlayer implements Serializable, Movable {
    
    private byte [][] gameState;
    private byte [][] gameScore;
    private ArrayList<Position> openSquares;
    private byte fakeTurn;
    private int numberOfOpenSquares;
    Position bestMove;

    
    public HardComputer()
    {
        super("HardComputer");
        openSquares = new ArrayList<>();
        bestMove = new Position();
    }
    
    @Override
    public Position makeMove(byte [][] allSquares, byte [][] scores, byte playerNo)
    {
        bestMove = new Position();
        byte sign;
        //Position bestMove = new Position();
        byte bestScore = 0;
        Random xy = new Random();
        
        //build your board if you dont have to block
        if (allSquares[2][2] == 0)
        {
            System.out.println("Middle picked" + bestScore);
            return new Position(2,2);
        }
        
        if (playerNo == 1)
            sign = 1;
        else
            sign = -1;
        
        int lowerBound;
        int upperBound;
        
        for (int way = 0; way < 2; way++)
        {
            lowerBound = way;
            upperBound = way + 4;
            
            for (int rowType = 0; rowType < 16; rowType++)
            {
                if (scores[way][rowType] == 3 * (sign * -1) && bestScore < 3) //see enemy score
                {
                    if (rowType < 5) //horizontal
                    {
                        if (checkHorizontalBestScore(allSquares, rowType, lowerBound, upperBound))
                        {bestScore = 3; } 
                    }
                    else if (rowType > 4 && rowType < 10)
                    {
                        if (checkVerticalBestScore(allSquares, rowType, lowerBound, upperBound))
                        { bestScore = 3;}
                    }
                    else if (rowType == 10) //top left to bottom right diagonal
                    {
                        if (checkDiagonal1BestScore(allSquares, rowType, lowerBound, upperBound))
                        { bestScore = 3;}
                    }
                    else if (rowType == 11) //top right to bottom left diagonal
                    {
                        if (checkDiagonal2BestScore(allSquares, rowType, lowerBound, upperBound))
                            bestScore = 3;
                    }
                    else if (rowType == 12) //1
                    {
                        if(checkMiniDiagonal1BestScore(allSquares))
                        {bestScore = 3;}
                    }
                    else if (rowType == 13) //2
                    {
                        if(checkMiniDiagonal2BestScore(allSquares))
                        {bestScore = 3;}
                    }
                    else if (rowType == 14)//3
                    {
                        if(checkMiniDiagonal3BestScore(allSquares))
                        { bestScore = 3;}
                    }
                    else if (rowType == 15)//4
                    {
                        if(checkMiniDiagonal4BestScore(allSquares))
                        {bestScore = 3;}
                    }
                    else
                    {
                        System.out.println("FATAL ERROR NOTHING PICKED FOR " + bestScore);
                    }
                }
                else if (scores[way][rowType] == 3 * (sign) && bestScore < 4) //see your score
                {
                    if (rowType < 5) //horizontal
                    {
                        if (checkHorizontalBestScore(allSquares, rowType, lowerBound, upperBound))
                            return bestMove;
                    }
                    else if (rowType > 4 && rowType < 10)
                    {
                        if (checkVerticalBestScore(allSquares, rowType, lowerBound, upperBound))
                            return bestMove;
                    }
                    else if (rowType == 10) //top left to bottom right diagonal
                    {
                        if (checkDiagonal1BestScore(allSquares, rowType, lowerBound, upperBound))
                            return bestMove;
                    }
                    else if (rowType == 11) //top right to bottom left diagonal
                    {
                        if (checkDiagonal2BestScore(allSquares, rowType, lowerBound, upperBound))
                            return bestMove;
                    }
                    else if (rowType == 12)
                    {
                        if(checkMiniDiagonal1BestScore(allSquares))
                            return bestMove;                        
                    }
                    else if (rowType == 13)
                    {
                        if(checkMiniDiagonal2BestScore(allSquares))
                            return bestMove; 
                    }
                    else if (rowType == 14)
                    {
                        if(checkMiniDiagonal3BestScore(allSquares))
                            return bestMove; 
                    }
                    else if (rowType == 15)
                    {
                        if(checkMiniDiagonal4BestScore(allSquares))
                            return bestMove; 
                    }
                    else
                    {
                        System.out.println("FATAL ERROR NOTHING PICKED FOR " + bestScore);
                    }
                    
                }
                else if ((scores[way][rowType] == 2 * (sign * -1)) && bestScore < 2)
                {
                    //get best row to defend
                    int bestRow = getBestRowToDefend(scores, playerNo, way);

                    if (bestRow < 5) //horizontal
                    {
                        if (checkHorizontalBestScore(allSquares, bestRow, lowerBound, upperBound))
                        {bestScore = 2;}
                    }
                    else if (bestRow > 4 && bestRow < 10)
                    {
                        if (checkVerticalBestScore(allSquares, bestRow, lowerBound, upperBound))
                        {bestScore = 2;}
                    }
                    else if (bestRow == 10) //top left to bottom right diagonal
                    {
                        if (checkDiagonal1BestScore(allSquares, bestRow, lowerBound, upperBound))
                        {bestScore = 2;}
                    }
                    else if (bestRow == 11) //top right to bottom left diagonal
                    {
                        if (checkDiagonal2BestScore(allSquares, bestRow, lowerBound, upperBound))
                        {bestScore = 2;}
                    }
                    else if (bestRow == 12)
                    {
                        if(checkMiniDiagonal1BestScore(allSquares))
                            bestScore = 2;                      
                    }
                    else if (bestRow == 13)
                    {
                        if(checkMiniDiagonal2BestScore(allSquares))
                        {bestScore = 2;}
                    }
                    else if (bestRow == 14)
                    {
                        if(checkMiniDiagonal3BestScore(allSquares))
                        {bestScore = 2; }
                    }
                    else if (bestRow == 15)
                    {
                        if(checkMiniDiagonal4BestScore(allSquares))
                        { bestScore = 2; }
                    }
                    else
                    {
                        System.out.println("FATAL ERROR NOTHING PICKED FOR " + bestScore);
                    }
                }
                else if ((scores[way][rowType] == 1 * (sign * -1)) && bestScore < 1)
                {
                    //get best row to defend
                    int bestRow = getBestRowToDefend(scores, playerNo, way); //this only goes for one way... not good

                    if (bestRow < 5) //horizontal
                    {
                        if (checkHorizontalBestScore(allSquares, bestRow, lowerBound, upperBound))
                        {bestScore = 1;}
                    }
                    else if (bestRow > 4 && bestRow < 10)
                    {
                        if (checkVerticalBestScore(allSquares, bestRow, lowerBound, upperBound))
                        {bestScore = 1;}
                    }
                    else if (bestRow == 10) //top left to bottom right diagonal
                    {
                        if (checkDiagonal1BestScore(allSquares, bestRow, lowerBound, upperBound))
                        {bestScore = 1;}
                    }
                    else if (bestRow == 11) //top right to bottom left diagonal
                    {
                        if (checkDiagonal2BestScore(allSquares, bestRow, lowerBound, upperBound))
                        {bestScore = 1;}
                    }
                    else if (bestRow == 12)
                    {
                        if(checkMiniDiagonal1BestScore(allSquares))
                        {bestScore = 1;    }                  
                    }
                    else if (bestRow == 13)
                    {
                        if(checkMiniDiagonal2BestScore(allSquares))
                        {bestScore = 1;}
                    }
                    else if (bestRow == 14)
                    {
                        if(checkMiniDiagonal3BestScore(allSquares))
                        {bestScore = 1; }
                    }
                    else if (bestRow == 15)
                    {
                        if(checkMiniDiagonal4BestScore(allSquares))
                        {bestScore = 1; }
                    }
                    else
                    {
                        System.out.println("FATAL ERROR NOTHING PICKED FOR " + bestScore);
                    }
                }
            }
        }
        
        if (bestScore == 0) //empty board
        {
            setOpenSquares(allSquares);
            xy = new Random();
            //return openSquares.get(xy.nextInt(openSquares.size()));  
            System.out.println("Random picked" + bestScore);
            bestMove = openSquares.get(xy.nextInt(openSquares.size()));
        }

        System.out.println(bestScore);
        return bestMove;

        
    }
    
    public void setOpenSquares(byte [][] allSquares)
    {
        openSquares.clear();
    
        for (int i = 0; i < NUMBER_OF_ROWS; i++)
        {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++)
            {
                if (allSquares[i][j] == 0)
                    openSquares.add(new Position(i, j));
            }
        }
    }
    
    private byte [][] getTrimmedTallLeft()
    {
        byte [][] trimmedState = new byte[5][2];
        byte trimRow = 0;
        byte trimCol = 0;
        
        for (int row = 0; row < 5; row++)
        {
            for (int col = 0; col < 2; col++)
            {
                trimmedState[trimRow++][trimCol++] = gameState[row][col];
            }
        }
        
        return trimmedState;
    }
    
    private byte [][] getTrimmedTallRight()
    {
        byte [][] trimmedState = new byte[5][2];
        byte trimRow = 0;
        byte trimCol = 0;
        
        for (int row = 0; row < 5; row++)
        {
            for (int col = 3; col < 5; col++)
            {
                trimmedState[trimRow++][trimCol++] = gameState[row][col];
            }
        }
        
        return trimmedState;
    }
    private byte [][] getTrimmedShortBottom()
    {
        byte [][] trimmedState = new byte[2][5];
        byte trimRow = 0;
        byte trimCol = 0;
        
        for (int row = 3; row < 5; row++)
        {
            for (int col = 0; col < 5; col++)
            {
                trimmedState[trimRow++][trimCol++] = gameState[row][col];
            }
        }
        
        return trimmedState;
    }
    private byte [][] getTrimmedShortTop()
    {
        byte [][] trimmedState = new byte[2][5];
        byte trimRow = 0;
        byte trimCol = 0;
        
        for (int row = 0; row < 2; row++)
        {
            for (int col = 0; col < 5; col++)
            {
                trimmedState[trimRow++][trimCol++] = gameState[row][col];
            }
        }
        
        return trimmedState;
    }
    
    private int getBestRowToDefend(byte [][] scores, byte playerNo, int way)
    {
        int total = 0;
        int bestWay = 0;
        int bestType = 0;
        
        boolean diagonalFound = false;
        
        
        for (int rowType = 10; rowType < 16; rowType++)
        {
            if (playerNo == 1)
            {
                if (scores[way][rowType] > total)
                {
                    total = scores[way][rowType];
                    //bestWay = i;
                    bestType = rowType;
                    diagonalFound = true;
                }
            }
            else
            {
                if (scores[way][rowType] < total)
                {
                    total = scores[way][rowType];
                    //bestWay = i;
                    bestType = rowType;
                    diagonalFound = true;
                }
            }
        }
        
        if (!diagonalFound)
        {
            for (int rowType = 0; rowType < 10; rowType++)
            {
                if (playerNo == 1)
                {
                    if (scores[way][rowType] > total)
                    {
                        total = scores[way][rowType];
                        //bestWay = i;
                        bestType = rowType;
                    }
                }
                else
                {
                    if (scores[way][rowType] < total)
                    {
                        total = scores[way][rowType];
                        //bestWay = i;
                        bestType = rowType;
                    }
                }
            }
        }

        return bestType;
    }
    
    private boolean checkHorizontalBestScore(byte [][] allSquares, int rowType, int lowerBound, int upperBound)
    {
        boolean found = false;
        
        for (int col = lowerBound; col < upperBound; col++) //loop through game
        {
            if (allSquares[rowType][col] == 0)
            {
                bestMove = new Position(rowType, col);
                found = true;
            }
        }
        
        return found;
    }
    private boolean checkVerticalBestScore(byte [][] allSquares, int rowType, int lowerBound, int upperBound)
    {
        boolean found = false;
        
        for (int row = lowerBound; row < upperBound; row++) //loop through game
        {
            if (allSquares[row][rowType - 5] == 0)
            {
                bestMove = new Position(row, rowType - 5);
                found = true;
            }
        }
        
        return found;
    }
    private boolean checkDiagonal1BestScore(byte [][] allSquares, int rowType, int lowerBound, int upperBound)
    {
        boolean found = false;
        
        for (int i = lowerBound; i < upperBound; i++)
        {
            if (allSquares [i][i] == 0)
            {
                bestMove = new Position(i, i);
                found = true;
            }
        }
        
        return found;
    }
     private boolean checkDiagonal2BestScore(byte [][] allSquares, int rowType, int lowerBound, int upperBound)
    {
        boolean found = false;
        
        for (int i = upperBound - 1; i > lowerBound - 1; i--)
        {
            if (allSquares [i][i] == 0)
            {
                bestMove = new Position(i, i);
                found = true;
            }
        }
        
        return found;
    }
    private boolean checkMiniDiagonal1BestScore(byte [][] allSquares)
    {
        boolean found = false;
        
        int row = 4;
        int col = 1;

        while (col < 5)
        {
            if (allSquares [row][col] == 0)
            {
                bestMove = new Position(row, col);
                found = true;
            }
            row--;
            col++;
        }
        
        return found;
    }
    private boolean checkMiniDiagonal2BestScore(byte [][] allSquares)
    {
        boolean found = false;
        
        int row = 4;
        int col = 3;

        while (col > -1)
        {
            if (allSquares [row][col] == 0)
            {
                bestMove = new Position(row, col);
                found = true;
            }
            row--;
            col--;
        }
        
        return found;
    }
    
    private boolean checkMiniDiagonal3BestScore(byte [][] allSquares)
    {
        boolean found = false;
        
        int row = 3;
        int col = 0;

        while (row > - 1)
        {
            if (allSquares [row][col] == 0)
            {
                bestMove = new Position(row, col);
                found = true;
            }
            row--;
            col++;
        }
        
        return found;
    }
    private boolean checkMiniDiagonal4BestScore(byte [][] allSquares)
    {
        boolean found = false;
        
        int row = 0;
        int col = 1;

        while (col < 5)
        {
            if (allSquares [row][col] == 0)
            {
                bestMove = new Position(row, col);
                found = true;
            }
            row++;
            col++;

        }
        
        return found;
    }
    
}
