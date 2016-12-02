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
    public HardComputer()
    {
        super("HardComputer");
    }
    
    @Override
    public Position makeMove(byte [][] allSquares)
    {
        return null;
    }
}
