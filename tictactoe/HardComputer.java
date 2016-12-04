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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



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
    }
    
    @Override
    public Position makeMove(byte [][] allSquares, byte [][] scores, byte playerNo)
    {
//        gameState = allSquares;
//        this.gameScore = gameScore;
//        fakeTurn = 1;
//        numberOfOpenSquares = 0;
//        setOpenSquares();
//        
//        return getScoreFromBestTurn();
        
        return null;
        
    }
    
//    public void setOpenSquares() {
//        openSquares.clear();
//        //int numberOfOpenSquares = 0;
//        
//        for (byte i = 0; i < NUMBER_OF_ROWS; i++)
//        {
//            for (byte j = 0; j < NUMBER_OF_COLUMNS; j++)
//            {
//                if (gameState[i][j] == 0)
//                {
//                    openSquares.add(new Position(i, j));
//                    numberOfOpenSquares++;
//                }
//            }
//        }
//    }
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
