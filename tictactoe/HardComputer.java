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

    
    public HardComputer()
    {
        super("HardComputer");
        openSquares = new ArrayList<>();
    }
    
    @Override
    public Position makeMove(byte [][] allSquares, byte [][] scores, byte playerNo)
    {
        byte sign;
        Position bestMove = new Position();
        byte bestScore = 0;
        Random xy = new Random();
        
        //build your board if you dont have to block
        
        
        if (playerNo == 1)
            sign = 1;
        else
            sign = -1;
        
        for (int way = 0; way < 2; way++)
        {
            for (int rowType = 0; rowType < 16; rowType++)
            {
                if (scores[way][rowType] == 3 * (sign * -1) && bestScore < 3) //see enemy score
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
                            {
                                bestScore = 3;
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
                                bestScore = 3;
                                bestMove = new Position(row, rowType - 5);
                            }
                        }
                    }
                    else if (rowType == 10) //top left to bottom right diagonal
                    {
                        for (int i = lowerBound; i < upperBound; i++)
                        {
                            if (allSquares [i][i] == 0)
                            {
                                bestScore = 3;
                                bestMove = new Position(i, i);
                            }
                        }
                    }
                    else if (rowType == 11) //top right to bottom left diagonal
                    {
                        for (int i = upperBound - 1; i > lowerBound - 1; i--)
                        {
                            if (allSquares [i][i] == 0)
                            {
                                bestScore = 3;
                                bestMove = new Position(i, i);
                            }
                        }
                    }
                    else if (rowType == 12) //1
                    {
                        int row = 4;
                        int col = 1;
                        
                        while (col < 5)
                        {
                            if (allSquares [row][col] == 0)
                            {
                                bestScore = 3;
                                bestMove = new Position(row, col);
                            }
                            row--;
                            col++;
                        }
                    }
                    else if (rowType == 13) //2
                    {
                        int row = 4;
                        int col = 3;
                        
                        while (col > -1)
                        {
                            if (allSquares [row][col] == 0)
                            {
                                bestScore = 3;
                                bestMove = new Position(row, col);
                            }
                            row--;
                            col--;
                        }
                    }
                    else if (rowType == 14)//3
                    {
                        int row = 3;
                        int col = 0;
                        
                        while (row > - 1)
                        {
                            if (allSquares [row][col] == 0)
                            {
                                bestScore = 3;
                                bestMove = new Position(row, col);
                            }
                            row--;
                            col++;
                            
                        }
                    }
                    else if (rowType == 15)//4
                    {
                        int row = 0;
                        int col = 1;
                        
                        while (col < 5)
                        {
                            if (allSquares [row][col] == 0)
                            {
                                bestScore = 3;
                                bestMove = new Position(row, col);
                            }
                            row++;
                            col++;
                            
                        }
                    }
                    else
                    {
                        System.out.println("FATAL ERROR NOTHING PICKED FOR " + bestScore);
                    }
                }
                else if (scores[way][rowType] == 3 * (sign) && bestScore < 4) //see your score
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
                    else if (rowType == 11) //top right to bottom left diagonal
                    {
                        for (int i = upperBound - 1; i > lowerBound - 1; i--)
                        {
                            if (allSquares [i][i] == 0)
                                return new Position(i,i);
                        }
                    }
                    else if (rowType == 12)
                    {
                        int row = 4;
                        int col = 1;
                        
                        while (col < 5)
                        {
                            if (allSquares [row][col] == 0)
                            {
                                return new Position(row, col); 
                            }
                            row--;
                            col++;
                        }
                                
                    }
                    else if (rowType == 13)
                    {
                        int row = 4;
                        int col = 3;
                        
                        while (col > -1)
                        {
                            if (allSquares [row][col] == 0)
                            {
                                 return new Position(row, col); 
                            }
                            row--;
                            col--;
                        }
                    }
                    else if (rowType == 14)
                    {
                        int row = 3;
                        int col = 0;
                        
                        while (row > - 1)
                        {
                            if (allSquares [row][col] == 0)
                            {
                                 return new Position(row, col); 
                            }
                            row--;
                            col++;
                        }
                    }
                    else if (rowType == 15)
                    {
                        int row = 0;
                        int col = 1;
                        
                        while (col < 5)
                        {
                            if (allSquares [row][col] == 0)
                            {
                                 return new Position(row, col); 
                            }
                            row++;
                            col++;
                        }
                    }
                    else
                    {
                        System.out.println("FATAL ERROR NOTHING PICKED FOR " + bestScore);
                    }
                    
                }
                else if ((scores[way][rowType] == 2 * (sign * -1)) && bestScore < 2)
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


                                    bestScore = 2;
                                    bestMove = new Position(row, rowType - 5);
                               
                            }
                        }
                    }
                    else if (rowType == 10) //top left to bottom right diagonal
                    {
                        for (int i = lowerBound; i < upperBound; i++)
                        {
                            if (allSquares [i][i] == 0)
                            {

                                    bestScore = 2;
                                    bestMove = new Position(i, i);
                                
                            }
                        }
                    }
                    else if (rowType == 11) //top right to bottom left diagonal
                    {
                        for (int i = upperBound - 1; i > lowerBound - 1; i--)
                        {
                            if (allSquares [i][i] == 0)
                            {

                                    bestScore = 2;
                                    bestMove = new Position(i, i);
                                
                            }
                        }
                    }
                    else if (rowType == 12)
                    {
                        int row = 4;
                        int col = 1;
                        
                        while (col < 5)
                        {
                            if (allSquares [row][col] == 0)
                            {

                                    bestScore = 2;
                                    bestMove = new Position(row, col);
                                
                            }
                            row--;
                            col++;
                        }
                    }
                    else if (rowType == 13)
                    {
                        int row = 4;
                        int col = 3;
                        
                        while (col > -1)
                        {
                            if (allSquares [row][col] == 0)
                            {

                                    bestScore = 2;
                                    bestMove = new Position(row, col);
                                
                            }
                            row--;
                            col--;
                        }
                    }
                    else if (rowType == 14)
                    {
                        int row = 3;
                        int col = 0;
                        
                        while (row > - 1)
                        {
                            if (allSquares [row][col] == 0)
                            {

                                    bestScore = 2;
                                    bestMove = new Position(row, col);
                                
                            }
                            row--;
                            col++;
                        }
                    }
                    else if (rowType == 15)
                    {
                        int row = 0;
                        int col = 1;
                        
                        while (col < 5)
                        {
                            if (allSquares [row][col] == 0)
                            {

                                    bestScore = 2;
                                    bestMove = new Position(row, col);
                                
                            }
                            row++;
                            col++;
                        }
                    }
                    else
                    {
                        System.out.println("FATAL ERROR NOTHING PICKED FOR " + bestScore);
                    }
                }
                else if ((scores[way][rowType] == 1 * (sign * -1)) && bestScore < 1)
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
                    
                    //get best row to defend
                    int bestRow = getBestRowToDefend(scores, playerNo, way);

                    if (bestRow < 5) //horizontal
                    {
                        for (int col = lowerBound; col < upperBound; col++) //loop through game
                        {
                            if (allSquares[bestRow][col] == 0)
                            {
                                    bestScore = 1;
                                    bestMove = new Position(bestRow, col);

                                
                            }
                        }
                    }
                    else if (bestRow > 4 && bestRow < 10)
                    {   
                        for (int row = lowerBound; row < upperBound; row++) //loop through game
                        {
                            if (allSquares[row][bestRow - 5] == 0)
                            {

                                    bestScore = 1;
                                    bestMove = new Position(row, bestRow - 5);

                            }
                        }
                    }
                    else if (bestRow == 10) //top left to bottom right diagonal
                    {
                        for (int i = lowerBound; i < upperBound; i++)
                        {
                            if (allSquares [i][i] == 0)
                            {
                                    bestScore = 1;
                                    bestMove = new Position(i, i);
                            }
                        }
                    }
                    else if (bestRow == 11) //top right to bottom left diagonal
                    {
                        for (int i = upperBound - 1; i > lowerBound - 1; i--)
                        {
                            if (allSquares [i][i] == 0)
                            {
                                    bestScore = 1;
                                    bestMove = new Position(i, i);
                            }
                        }
                    }
                    else if (bestRow == 12)
                    {
                        int row = 4;
                        int col = 1;
                        
                        while (col < 5)
                        {
                            if (allSquares [row][col] == 0)
                            {
                                    bestScore = 1;
                                    bestMove = new Position(row, col);

                                row--;
                                col++;
                            }
                        }
                                
                    }
                    else if (bestRow == 13)
                    {
                        int row = 4;
                        int col = 3;
                        
                        while (col > -1)
                        {
                            if (allSquares [row][col] == 0)
                            {

                                bestScore = 1;
                                bestMove = new Position(row, col);

                            }
                            row--;
                            col--;
                        }
                    }
                    else if (bestRow == 14)
                    {
                        int row = 3;
                        int col = 0;
                        
                        while (row > - 1)
                        {
                            if (allSquares [row][col] == 0)
                            {
                                bestScore = 1;
                                bestMove = new Position(row, col);
                            }
                            row--;
                            col++;
                        }
                    }
                    else if (bestRow == 15)
                    {
                        int row = 0;
                        int col = 1;
                        
                        while (col < 5)
                        {
                            if (allSquares [row][col] == 0)
                            {
                                bestScore = 1;
                                bestMove = new Position(row, col);
                            }
                            row++;
                            col++;
                        }
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
            if (allSquares[2][2] == 0)
            {
                System.out.println("Middle picked" + bestScore);
                return new Position(2,2);
            }
            else
            {
                System.out.println("Random picked" + bestScore);
                return openSquares.get(xy.nextInt(openSquares.size())); 
            }
        }
        else
        {
            System.out.println(bestScore);
            return bestMove;
        }
        
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
}
