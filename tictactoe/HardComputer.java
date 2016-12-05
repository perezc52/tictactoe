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
            for (int rowType = 0; rowType < 12; rowType++)
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
                                {
                                    bestScore = 3;
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
                                bestScore = 3;
                                bestMove = new Position(i, i);
                            }
                        }
                    }
                }
                else if (scores[way][rowType] == 3 * (sign)) //see your score
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
                    
                    //get best row to defend
                    int bestRow = getBestRowToDefend(scores, playerNo, way);

                    if (bestRow < 5) //horizontal
                    {
                        for (int col = lowerBound; col < upperBound; col++) //loop through game
                        {
                            if (allSquares[bestRow][col] == 0)
                            {
                                if (bestScore < 1)
                                {
                                    bestScore = 1;
                                    bestMove = new Position(bestRow, col);
                                }
                                
                            }
                        }
                    }
                    else if (bestRow > 4 && bestRow < 10)
                    {   
                        for (int row = lowerBound; row < upperBound; row++) //loop through game
                        {
                            if (allSquares[row][bestRow - 5] == 0)
                            {
                                if (bestScore < 1)
                                {
                                    bestScore = 1;
                                    bestMove = new Position(row, bestRow - 5);
                                }
                            }
                        }
                    }
                    else if (bestRow == 10) //top left to bottom right diagonal
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
        
        if (bestScore == 0) //empty board
        {
            setOpenSquares(allSquares);
            xy = new Random();
            //return openSquares.get(xy.nextInt(openSquares.size()));  
            if (allSquares[2][2] == 0)
                return new Position(2,2);
            else
                return openSquares.get(xy.nextInt(openSquares.size()));
        }
        else
        {
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
        //int bestWay = 0;
        int bestType = 0;
        
            for (int j = 0; j < 5; j++)
            {
                if (playerNo == 1)
                {
                    if (scores[way][j] > total)
                    {
                        total = scores[way][j];
                        //bestWay = i;
                        bestType = j;
                    }
                }
                else
                {
                    if (scores[way][j] < total)
                    {
                        total = scores[way][j];
                        //bestWay = i;
                        bestType = j;
                    }
                }
            }
        
        //int [] arr = {bestWay, bestType};
        return bestType;
    }
//    
//    public Position getScoreFromBestTurn()
//    {
//        byte [] nextMoveScores = new byte[numberOfOpenSquares];
//        
//        for (int i = 0; i < numberOfOpenSquares; i++)
//        {
//            nextMoveScores[i] = performScoreArrayOperations(openSquares.get(i).getX(), openSquares.get(i).getY());
//        }
//        
//        byte maxScore = 0; //what if there are 2?
//        Position maxMove = new Position();
//        
//        for (int i = 0; i < numberOfOpenSquares; i++)
//        {
//            if (nextMoveScores[i] > maxScore)
//            {
//                maxScore = nextMoveScores[i];
//                maxMove.setX(openSquares.get(i).getX());
//                maxMove.setY(openSquares.get(i).getY());
//            }
//        }
//        
//        return maxMove;
//    }
//    
//    //http://stackoverflow.com/questions/4198955/how-to-find-the-winner-of-a-tic-tac-toe-game-of-any-size
//    private byte performScoreArrayOperations(int row, int col)
//    {
//        byte score;
//        byte [][] possibleGameScoreResult = gameScore;
//            
//        if (fakeTurn == 1)
//            score = 1;
//        else
//            score = -1;
//        
//        
//        switch (col) {
//            case NUMBER_OF_ROWS - 1:
//                possibleGameScoreResult[1][row] += score;
//                break;
//            case 0:
//                possibleGameScoreResult[0][row] += score;
//                break;
//            default:
//                possibleGameScoreResult[0][row] += score;
//                possibleGameScoreResult[1][row] += score;
//                break;
//        }
//        
//        
//        switch (row) {
//            case NUMBER_OF_ROWS - 1:
//                possibleGameScoreResult[1][NUMBER_OF_ROWS + col] += score;
//                break;
//            case 0:
//                possibleGameScoreResult[0][NUMBER_OF_ROWS + col] += score;
//                break;
//            default:
//                possibleGameScoreResult[0][NUMBER_OF_ROWS + col] += score;
//                possibleGameScoreResult[1][NUMBER_OF_ROWS + col] += score;
//                break;
//        }
//        
//        if ((row == NUMBER_OF_ROWS - 1) && (col == NUMBER_OF_ROWS - 1))
//        {
//            if (row == col)
//                possibleGameScoreResult[1][2 * NUMBER_OF_ROWS] += score;
//            if (NUMBER_OF_ROWS - 1 - col == row)
//                possibleGameScoreResult[1][2 * NUMBER_OF_ROWS + 1] += score;
//        }
//        else if ((row == 0) && (col == 0))
//        {
//            if (row == col)
//                possibleGameScoreResult[0][2 * NUMBER_OF_ROWS] += score;
//            if (NUMBER_OF_ROWS - 1 - col == row)
//                possibleGameScoreResult[0][2 * NUMBER_OF_ROWS + 1] += score;
//        }
//        else
//        {
//            if (row == col)
//            {
//                possibleGameScoreResult[0][2 * NUMBER_OF_ROWS] += score;
//                possibleGameScoreResult[1][2 * NUMBER_OF_ROWS] += score;
//            }
//                
//            if (NUMBER_OF_ROWS - 1 - col == row)
//            {
//                possibleGameScoreResult[0][2 * NUMBER_OF_ROWS + 1] += score;
//                possibleGameScoreResult[1][2 * NUMBER_OF_ROWS + 1] += score;
//            }
//        }
//        
//        return possibleGameScoreResult;
//    }
}
