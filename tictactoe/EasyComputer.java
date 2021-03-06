/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.Button;
import static tictactoe.MainMenu.NUMBER_OF_COLUMNS;
import static tictactoe.MainMenu.NUMBER_OF_ROWS;

/**
 *
 * @author lucy
 */
public class EasyComputer extends ComputerPlayer implements Serializable, Movable{
    private Random xy;
    //Random y;
    private ArrayList<Position> openSquares;
    
    
    public EasyComputer()
    {
        super("EasyComputer");
        xy = new Random();
        openSquares = new ArrayList<>();
        //y = new Random();   
    }
    
    
    @Override
    public Position makeMove(byte [][] allSquares, byte [][] scores, byte playerNo)
    {
        setOpenSquares(allSquares);
        Position pickedSquare = getOpenSquares().get(xy.nextInt(getOpenSquares().size()));
        
//        int[] arr = new int[2];
//        arr[0] = pickedSquare.getX();
//        arr[1] = pickedSquare.getY();
        
        return pickedSquare;
    }
    //private void performCalculations

    /**
     * @return the openSquares
     */
    public ArrayList<Position> getOpenSquares() {
        return openSquares;
    }

    /**
     * @param openSquares the openSquares to set
     */
    public void setOpenSquares(byte [][] allSquares) {
        openSquares.clear();
        
        for (byte i = 0; i < NUMBER_OF_ROWS; i++)
        {
            for (byte j = 0; j < NUMBER_OF_COLUMNS; j++)
            {
                if (allSquares[i][j] == 0)
                    openSquares.add(new Position(i, j));
            }
        }
    }
}
