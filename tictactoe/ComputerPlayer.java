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
public abstract class ComputerPlayer extends Player implements Serializable, Movable{
    public ComputerPlayer(String username)
    {
        super(username);
    }
}
