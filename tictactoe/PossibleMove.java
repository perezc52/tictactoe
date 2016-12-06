/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author lucy
 */
public class PossibleMove {
    private int way;
    private int rowType;
    private int score;
    
    PossibleMove(int way, int rowType, int score)
    {
        this.way = way;
        this.rowType = rowType;
        this.score = score;
    }

    /**
     * @return the way
     */
    public int getWay() {
        return way;
    }

    /**
     * @param way the way to set
     */
    public void setWay(int way) {
        this.way = way;
    }

    /**
     * @return the rowType
     */
    public int getRowType() {
        return rowType;
    }

    /**
     * @param rowType the rowType to set
     */
    public void setRowType(int rowType) {
        this.rowType = rowType;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
}
