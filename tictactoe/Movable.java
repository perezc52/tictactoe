/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.lang.reflect.Array;

/**
 *
 * @author lucy
 */
public interface Movable {
    public Position makeMove(byte [][] allSquares);
}
