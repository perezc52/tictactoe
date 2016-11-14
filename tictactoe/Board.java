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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Board{
    
    public static final int NUMBER_OF_ROWS = 5;
    public static final int NUMBER_OF_COLUMNS = 5;
    public static final int NUMBER_OF_SCORES = 2 * NUMBER_OF_ROWS + 2;
    private static byte currentTurn;
    private static byte totalNumberOfTurns;
    private static int [] scores;
    private static byte [][] squares;
    private static Button [][] gridButtons;
    private static Stage window;
    
    private static Label turnLabel;
    
    //Buttons
    private static Button surrenderButton;
    private static Button mainMenuButton;
    
    //layouts
    private static GridPane gameGrid;
    private static HBox hBox;
    private static VBox vBox;
    private static BorderPane borderPane;
//    
//    //private Player p1
//    //private Player p2
//    
    private static Scene scene;
    private static Button justClickedBtn;
    
    public static int display()
    {
        currentTurn = 1;
        totalNumberOfTurns = 0;
        scores = new int[NUMBER_OF_SCORES];
        squares = new byte[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS]; //java arrays are row major
        gridButtons = new Button[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        
        
        //initialize the arrays
        for (int i = 0; i < NUMBER_OF_SCORES; i++)
        {
            scores[i] = 0;
        }
        
        for (int i = 0; i < NUMBER_OF_ROWS; i++)
        {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++)
            {
                squares[i][j] = 0;
                gridButtons[i][j] = new Button("R" + Integer.toString(i) + "C" + Integer.toString(j));
            }
        }
        
        //initialize stage
        window = new Stage();
        window.setTitle("Game");
        window.setMinWidth(500);
        window.initModality(Modality.APPLICATION_MODAL);
        
        
        //initialize grid & set grid constraints
        gameGrid = new GridPane();
        gameGrid.setPadding(new Insets(10,10,10,10));
        gameGrid.setAlignment(Pos.CENTER);
        gameGrid.setHgap(10);
        gameGrid.setVgap(10);

        for (int i = 0; i < NUMBER_OF_ROWS; i++)
        {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++)
            {
                gameGrid.setConstraints(gridButtons[i][j], j, i);//set constraints are column major
                gameGrid.getChildren().addAll(gridButtons[j][i]);
            }
        }
        
        //initialize label
        turnLabel = new Label("It is " + Integer.toString(currentTurn) + "'s turn");
        turnLabel.setPadding(new Insets(10,10,10,10));
        //turnLabel.setAlignment(Pos.CENTER);

        
        //initialize buttons
        surrenderButton = new Button("Surrender");
        mainMenuButton = new Button("Return to Main Menu");
        
        //initialize hBox
        hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10,10,10,10));
        //strangely you can't do this via borderPane
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(surrenderButton, mainMenuButton);
        
        //initialize border pane
        borderPane = new BorderPane();
        //borderPane.getChildren().addAll(turnLabel, gameGrid, hBox);
        borderPane.setTop(turnLabel);
        borderPane.setCenter(gameGrid);
        borderPane.setBottom(hBox);
        
        borderPane.setAlignment(turnLabel, Pos.CENTER);
        //borderPane.setAlignment(gameGrid, Pos.CENTER);
        //borderPane.setAlignment(hBox, Pos.CENTER);
        
        scene = new Scene(borderPane, 500, 500);
        window.setScene(scene);
        
        
        //button events
        for (int i = 0; i < NUMBER_OF_ROWS; i++)
        {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++)
            {
                gridButtons[i][j].setOnAction(createTileHandler(i,j));
            }
        }
        
        mainMenuButton.setOnAction(e -> {
            if (BinaryQuestionBox.display("Wait", "Are you sure you want to return to the Main Menu? This will count as a loss to the current player's turn.") == true)
            {
                if (currentTurn == 1)
                    currentTurn = 2;
                else
                    currentTurn = 1;
                
                window.close();
            }
        });
        
        window.showAndWait();
        System.out.println("Board called");
        
        
        return currentTurn; //this might not work
    }
    
    //http://stackoverflow.com/questions/34189259/how-can-i-get-the-indexes-of-each-button-clicked-for-my-program
    private static EventHandler<ActionEvent> createTileHandler(int row, int col) {
        return event -> tileHandler(row, col);
    }
    private static void tileHandler (int row, int col){
    
        System.out.println(String.format("Clicked tile at (%d,%d)", row, col));
        
        if (squares[row][col] == 0)
        {
            //set byte array
            squares[row][col] = currentTurn;
            
            //update visual representation
            gridButtons[row][col].setText(Byte.toString(currentTurn));
            
            //increment numberOfTurns (used for draw function)
            totalNumberOfTurns++;
          
            //perform operations on scores array for checkForWin method
            performScoreArrayOperations(row, col);
            
            if (checkForDraw())
            {
                System.out.println("Game ends in a draw");
            }
            else if (checkForWin())
            {
                System.out.println("Player " + currentTurn + " wins");
            }
            else
            {
                if (currentTurn == 1)
                    currentTurn = 2;
                else
                    currentTurn = 1;
                 
                turnLabel.setText("It is " + Integer.toString(currentTurn) + "'s turn");

            }
        } 
        else
            System.out.println("Square taken");
    }
    
    private static boolean checkForDraw()
    {
        if (totalNumberOfTurns == NUMBER_OF_ROWS * NUMBER_OF_COLUMNS)
            return true;
        else
            return false;
    }
    
    //AS OF 11/13/2016 THIS DOES NOT WORK ON ALL CASES
    private static boolean checkForWin()
    {
        for (int i = 0; i < NUMBER_OF_SCORES; i++)
        {
            if (Math.abs(scores[i]) == 4)
                return true;
        }
        
        return false;
    }
    
    //http://stackoverflow.com/questions/4198955/how-to-find-the-winner-of-a-tic-tac-toe-game-of-any-size
    private static void performScoreArrayOperations(int row, int col)
    {
        int score;
            
        if (currentTurn == 1)
            score = 1;
        else
            score = -1;

        scores[row] += score;
        scores[NUMBER_OF_ROWS + col] += score;
        if (row == col)
            scores[2 * NUMBER_OF_ROWS] += score;
        if (NUMBER_OF_ROWS - 1 - col == row)
            scores[2 * NUMBER_OF_ROWS + 1] += score;
    }
}