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
public class BoardBlock {
    private byte [][] block;
    private byte numberOfXs;
    private byte numberOfOs;
    private byte numberOfRows;
    private byte numberOfCols;
    private byte start;
    private byte end;
    
    BoardBlock(byte [][] gameState, byte type, byte position) //0 = [5][2] 1 = [2][5] //position 0 left, bottom 1 right,top
    {
        numberOfXs = 0;
        numberOfOs = 0;
        if (type == 0)
        {
            numberOfRows = 5;
            numberOfCols = 2; 
            
            block = new byte[numberOfRows][numberOfCols];
            
//            if (position == 0)
//            {
//                start = 0;
//                end = 2;
//            }
//            else
//            {
//                start = 3;
//                end = 5;
//            }
//                
//            for (int i = start; i < end; i++)
//            {
//                for (int j = 0; j < numberOfCols; j++)
//                {
//                    block[i][j] = 
//                }
//            }
        }
        else
        {
            numberOfRows = 2;
            numberOfCols = 5; 
            
            block = new byte[numberOfRows][numberOfCols];
            
            
            
            
        }
        
        
        
    }
    private void countXsAndOs()
    {
        for (int i = 0; i < numberOfRows; i++)
        {
            for (int j = 0; j < numberOfCols; j++)
            {
                switch (block[i][j]) {
                    case 1:
                        setNumberOfXs((byte) (getNumberOfXs() + 1));
                        break;
                    case 2:
                        setNumberOfOs((byte) (getNumberOfOs() + 1));
                        break;
                    default:
                        continue;
                }
            }
        }
    }

    /**
     * @return the numberOfXs
     */
    public byte getNumberOfXs() {
        return numberOfXs;
    }

    /**
     * @param numberOfXs the numberOfXs to set
     */
    public void setNumberOfXs(byte numberOfXs) {
        this.numberOfXs = numberOfXs;
    }

    /**
     * @return the numberOfOs
     */
    public byte getNumberOfOs() {
        return numberOfOs;
    }

    /**
     * @param numberOfOs the numberOfOs to set
     */
    public void setNumberOfOs(byte numberOfOs) {
        this.numberOfOs = numberOfOs;
    }
}
