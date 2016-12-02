
package tictactoe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class MainMenu extends Application {
    
    private Player [] players;
    //private RegisterMenu r1;
    //private DifficultyMenu d1;
    //private LoginMenu l1;
    //private HistoryMenu h1;
    
    //GUI
        
    private Scene menuScene;
    private Scene poScene;
    private Scene registerScene;
    private Scene loginScene;
    private Scene diffScene;
    private Scene historyScene;
    private Scene boardScene;
    
    private Stage window;
    
    //board variables
    public static final int NUMBER_OF_ROWS = 5;
    public static final int NUMBER_OF_COLUMNS = 5;
    public static final int NUMBER_OF_SCORES = 2 * NUMBER_OF_ROWS + 2;
    
    private byte currentTurn;
    private byte totalNumberOfTurns;
    private int [][] scores; //0 forward 1 backward
    private byte [][] squares;
    private Button [][] gridButtons;
    
    //Label turnLabel;

    //Player variables
    private HashMap<String, Player> playerMap;
    
    
    public MainMenu()
    {
        players = new Player[2];
        
//        currentTurn = 1;
//        totalNumberOfTurns = 0;
        scores = new int[2][NUMBER_OF_SCORES];
        squares = new byte[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS]; //java arrays are row major
        gridButtons = new Button[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        
        
//        //initialize the score array
//        initializeScoresArray();
//        
//        //initialize squares and button arrays
//        for (int i = 0; i < NUMBER_OF_ROWS; i++)
//        {
//            for (int j = 0; j < NUMBER_OF_COLUMNS; j++)
//            {
//                squares[i][j] = 0;
//                gridButtons[i][j] = new Button("R" + Integer.toString(i) + "C" + Integer.toString(j));
//            }
//        }
        
        //deserialize a playerMap from computer or create it if it does not exist
        deserializePlayerMap();
        playerMap.put("EasyComputer", new EasyComputer());
        playerMap.put("MediumComputer", new MediumComputer());
        playerMap.put("HardComputer", new HardComputer());
        //System.out.println(playerMap.get("jojo").getNumberOfWins());
        
        //window.setTitle("Game");
        //window.setMinWidth(500);
    }
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        initializeMainMenuScene();
        //initializeHistoryScene();
        initializeDifficultyScene();
        //initializeBoardScene();
        
        //serialize on rude closing of program
        window.setOnCloseRequest(e -> {
            e.consume();
            serializePlayerMap();
            window.close();
        });
        }
    
    
    
    //Methods
        

    public Player OpenLoginMenu(Stage primaryStage, Scene loginScene) {
            
        Player pLogin = new Player();
        primaryStage.setScene(loginScene);
        return pLogin;
    }
        
    public Player OpenRegisterMenu(Stage primaryStage, Scene registerScene) {
            
        Player pRegister = new Player();
        primaryStage.setScene(registerScene);
        return pRegister;
    }
        
    /*public void OpenHistoryMenu(Stage window, Scene historyScene) {
        //deserializePlayerMap();    
        initializeHist
        window.setScene(historyScene);
    }*/
    
    

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void initializeBoardVariables()
    {
        currentTurn = 1;
        totalNumberOfTurns = 0;
        
        //initialize the score array
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < NUMBER_OF_SCORES; j++)
            {
                scores[i][j] = 0;
            } 
        }
        
        //initialize squares and button arrays
        for (int i = 0; i < NUMBER_OF_ROWS; i++)
        {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++)
            {
                squares[i][j] = 0;
                gridButtons[i][j] = new Button("R" + Integer.toString(i) + "C" + Integer.toString(j));
            }
        }
    }
    
    public void initializeBoardScene()
    {
        initializeBoardVariables();
        
        //Buttons
        Button surrenderButton;
        Button mainMenuButton;
        
        //Label
        Label turnLabel;

        //layouts
        GridPane gameGrid;
        HBox hBox;
        VBox vBox;
        BorderPane borderPane;
        
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
                GridPane.setConstraints(gridButtons[i][j], j, i);//set constraints are column major
                gameGrid.getChildren().addAll(gridButtons[j][i]);
            }
        }
        
        //initialize label
        turnLabel = new Label("It is " + players[currentTurn - 1].getUsername() + "'s turn");
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
        
        BorderPane.setAlignment(turnLabel, Pos.CENTER);
        //borderPane.setAlignment(gameGrid, Pos.CENTER);
        //borderPane.setAlignment(hBox, Pos.CENTER);

        //button events
        for (int i = 0; i < NUMBER_OF_ROWS; i++)
        {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++)
            {
                gridButtons[i][j].setOnAction(createTileHandler(i,j, turnLabel));
            }
        }
        
        if (players[currentTurn - 1] instanceof ComputerPlayer)
                {
                    Position p = players[currentTurn - 1].makeMove(squares);
                    tileHandler(p.getX(), p.getY(), turnLabel);
                    //turnLabel.setText("It is " + players[currentTurn - 1].getUsername() + "'s turn");

                }
        
        mainMenuButton.setOnAction(e -> {
            if (BinaryQuestionBox.display("Wait", "Are you sure you want to return to the Main Menu? This will count as a loss to the current player's turn.") == true)
            {
                if (currentTurn == 1)
                    currentTurn = 2;
                else
                    currentTurn = 1;
                
                window.setScene(menuScene);
            }
        });
        
        boardScene = new Scene(borderPane, 500, 500);
//        window.setScene(boardScene);
//        window.show();
//        System.out.println("Board called");
        
        
        //return currentTurn; //this might not work
    }
    
    
    //http://stackoverflow.com/questions/34189259/how-can-i-get-the-indexes-of-each-button-clicked-for-my-program
    private EventHandler<ActionEvent> createTileHandler(int row, int col, Label turnLabel) {
        return event -> {
        tileHandler(row, col, turnLabel);
        turnLabel.setText("It is " + players[currentTurn - 1].getUsername() + "'s turn");
                };
    }
    private void tileHandler (int row, int col, Label turnLabel){
    
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
                System.out.println("Game ends in a draw.");
                ConfirmBox.display("Game Over", "Game ends in a draw.");
                window.setScene(menuScene);

            }
            else if (checkForWin(row, col))
            {
                System.out.println("Player " + players[currentTurn - 1].getUsername() + " wins");
                ConfirmBox.display("Game Over", "Player " + players[currentTurn - 1].getUsername() + " wins");
                if (currentTurn == 1)
                {
                    players[currentTurn - 1].incrementWin();
                    players[currentTurn].incrementLoss();
                    
                    playerMap.put(players[currentTurn - 1].getUsername(), players[currentTurn - 1]);
                    playerMap.put(players[currentTurn].getUsername(), players[currentTurn]);
                    window.setScene(menuScene);
                }
                else
                {
                    players[currentTurn - 1].incrementWin();
                    players[currentTurn - 2].incrementLoss();
                    
                    playerMap.put(players[currentTurn - 1].getUsername(), players[currentTurn - 1]);
                    playerMap.put(players[currentTurn - 2].getUsername(), players[currentTurn - 2]);
                    window.setScene(menuScene);
                }
                
            }
            else
            {
                if (currentTurn == 1)
                    currentTurn = 2;
                else
                    currentTurn = 1;
                 
                turnLabel.setText("It is " + players[currentTurn - 1].getUsername() + "'s turn");
                
                if (players[currentTurn - 1] instanceof ComputerPlayer)
                {
                    Position p = players[currentTurn - 1].makeMove(squares);
                    tileHandler(p.getX(), p.getY(), turnLabel);
                }
            }
        } 
        else
            System.out.println("Square taken");
    }
    
    private boolean checkForDraw()
    {
        if (totalNumberOfTurns == NUMBER_OF_ROWS * NUMBER_OF_COLUMNS)
            return true;
        else
            return false;
    }
    
    private boolean checkForWin(int row, int col)
    {
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < NUMBER_OF_SCORES; j++)
            {  
                if (Math.abs(scores[i][j]) == 4)
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    //http://stackoverflow.com/questions/4198955/how-to-find-the-winner-of-a-tic-tac-toe-game-of-any-size
    private void performScoreArrayOperations(int row, int col)
    {
        int score;
            
        if (currentTurn == 1)
            score = 1;
        else
            score = -1;
        
        
        switch (col) {
            case NUMBER_OF_ROWS - 1:
                scores[1][row] += score;
                break;
            case 0:
                scores[0][row] += score;
                break;
            default:
                scores[0][row] += score;
                scores[1][row] += score;
                break;
        }
        
        
        switch (row) {
            case NUMBER_OF_ROWS - 1:
                scores[1][NUMBER_OF_ROWS + col] += score;
                break;
            case 0:
                scores[0][NUMBER_OF_ROWS + col] += score;
                break;
            default:
                scores[0][NUMBER_OF_ROWS + col] += score;
                scores[1][NUMBER_OF_ROWS + col] += score;
                break;
        }
        
        if ((row == NUMBER_OF_ROWS - 1) && (col == NUMBER_OF_ROWS - 1))
        {
            if (row == col)
                scores[1][2 * NUMBER_OF_ROWS] += score;
            if (NUMBER_OF_ROWS - 1 - col == row)
                scores[1][2 * NUMBER_OF_ROWS + 1] += score;
        }
        else if ((row == 0) && (col == 0))
        {
            if (row == col)
                scores[0][2 * NUMBER_OF_ROWS] += score;
            if (NUMBER_OF_ROWS - 1 - col == row)
                scores[0][2 * NUMBER_OF_ROWS + 1] += score;
        }
        else
        {
            if (row == col)
            {
                scores[0][2 * NUMBER_OF_ROWS] += score;
                scores[1][2 * NUMBER_OF_ROWS] += score;
            }
                
            if (NUMBER_OF_ROWS - 1 - col == row)
            {
                scores[0][2 * NUMBER_OF_ROWS + 1] += score;
                scores[1][2 * NUMBER_OF_ROWS + 1] += score;
            }
        }
    }

    public byte[][] getGameState()
    {
        byte [][] allSquares = new byte[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        
        for (int i = 0; i < NUMBER_OF_ROWS; i++)
        {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++)
            {
                allSquares[i][j] = squares[i][j];
            }
        }
        
        return allSquares;
    }
    
    public void initializeMainMenuScene()
    {
        //Main Menu Scene

        Label title = new Label("Tic-Tac-Toe");; 
        Button onePlayer, twoPlayers, viewHistory, quit;
        onePlayer = new Button("1 Player");
        twoPlayers = new Button("2 Players");
        viewHistory = new Button("View History");       
        quit = new Button("Quit");
        
        HBox bottom = new HBox(25);
        bottom.getChildren().addAll(onePlayer, twoPlayers, viewHistory, quit);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(10,10,50,10));
        
        HBox center = new HBox();
        center.getChildren().add(title);
        center.setAlignment(Pos.CENTER);
              
        BorderPane mainMenuLayout = new BorderPane();
        mainMenuLayout.setBottom(bottom);
        mainMenuLayout.setCenter(center);
        
        
        menuScene = new Scene(mainMenuLayout, 500, 200);
        
        window.setTitle("Tic-Tac-Toe");
        window.setScene(menuScene);
        window.show();
        
        //Main Menu Buttons
        viewHistory.setOnAction(e -> {
            initializeHistoryScene();
            window.setScene(historyScene);
            //OpenHistoryMenu(window, historyScene);
        });
        onePlayer.setOnAction(e -> window.setScene(poScene));
        twoPlayers.setOnAction(e -> 
        {
            players[0] = OptionsMenu.display(playerMap, 1);
            players[1] = OptionsMenu.display(playerMap, 2);
            
            System.out.println("p1 " + players[0].getUsername());
            System.out.println("p2 " + players[1].getUsername());
            
            System.out.printf("%s", playerMap.keySet());
            
            //serializePlayerMap();
            initializeBoardScene();
            window.setScene(boardScene);
//            if (players[currentTurn - 1] instanceof EasyComputer)
//                {
//                    Position p = players[currentTurn - 1].makeMove(squares);
//                    tileHandler(p.getX(), p.getY(), turnLabel);
//                    //turnLabel.setText("It is " + players[currentTurn - 1].getUsername() + "'s turn");
//
//                }
        });
        quit.setOnAction(e -> {
            serializePlayerMap();
            window.close();
    });
    }
    
    
    public void initializeHistoryScene()
    {
        //deserializePlayerMap();
        
        //History Scene
        
        TableView<Player> table;
        
        TableColumn<Player, String> nameColumn = new TableColumn<>("Player");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        
        TableColumn<Player, Integer> winsColumn = new TableColumn<>("Wins");
        winsColumn.setMinWidth(100);
        winsColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfWins"));
        
        TableColumn<Player, Integer> lossColumn = new TableColumn<>("Losses");
        lossColumn.setMinWidth(100);
        lossColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfLosses"));
        
        TableColumn<Player, Double> ratioColumn = new TableColumn<>("Win/Loss Ratio");
        ratioColumn.setMinWidth(120);
        ratioColumn.setCellValueFactory(new PropertyValueFactory<>("winLossRatio"));
        
        table = new TableView<>();
        
        //populate table
//        ObservableList<Player> pList = FXCollections.observableArrayList();
//        pList.addAll(playerMap.values());
//        //pList.add(playerMap.get("jojo"));
        //System.out.printf("%s", playerMap.get("jojo"));
        
        table.getItems().addAll(playerMap.values());
        
        //table.getColumns().addAll(nameColumn, winsColumn, lossColumn, ratioColumn);
        table.getColumns().addAll(nameColumn, winsColumn, lossColumn, ratioColumn);
        
        Button clearHistory, historyToMenu;
        clearHistory = new Button("Clear History");
        historyToMenu = new Button("Back To Main Menu");
        
        //History Menu Buttons
        historyToMenu.setOnAction(e -> window.setScene(menuScene));
        
        clearHistory.setOnAction(e -> {
            if (BinaryQuestionBox.display("Wait", "This will delete all player objects. Are you sure you wish to do this?") == true)
            {
                playerMap.clear();
                playerMap.put("EasyComputer", new EasyComputer());
                playerMap.put("MediumComputer", new MediumComputer());
                playerMap.put("HardComputer", new HardComputer());
            }
                    });
        
        HBox historyHBox = new HBox(260);
        VBox historyVBox = new VBox(10);
        
        historyHBox.getChildren().addAll(clearHistory, historyToMenu);
        historyHBox.setPadding(new Insets(10, 10, 10, 10));
        historyVBox.getChildren().addAll(table, historyHBox);
        
        historyScene = new Scene(historyVBox);
    }
    
    public void initializeDifficultyScene()
    {
        //Difficulty Scene
        
        Label diffLabel = new Label("Select Difficulty of the AI");
        Button easy = new Button("Easy");
        Button medium = new Button("Medium");
        Button hard = new Button("Hard");
        
        VBox diffVBox = new VBox(10);
        HBox diffHBox = new HBox(10);
        
        diffHBox.getChildren().addAll(easy, medium, hard);
        diffVBox.getChildren().addAll(diffLabel, diffHBox);
        
        diffScene = new Scene(diffVBox);
    }
    
    public void serializePlayerMap()
    {
        try 
        {
            FileOutputStream fileOut = new FileOutputStream("player_map.es");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(playerMap);
            out.close();
            fileOut.close();
        } 
        catch (FileNotFoundException ex1) 
        {
            System.err.println(ex1.getMessage());
        } catch (IOException ex1) {
            System.err.println(ex1.getMessage());
        }
    }
    
    private void deserializePlayerMap()
    {
        //deserialize a playerMap from computer or create it if it does not exist
        playerMap = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("player_map.es");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            playerMap = (HashMap<String, Player>)in.readObject();
            in.close();
            fileIn.close();
            
        } 
        catch (FileNotFoundException ex) 
        {
            playerMap = new HashMap<>();
            try 
            {
                FileOutputStream fileOut = new FileOutputStream("player_map.es");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(playerMap);
                out.close();
                fileOut.close();
                ConfirmBox.display("First Time?", "A necessary file was created in your directory");
            } 
            catch (FileNotFoundException ex1) 
            {
                System.err.println(ex1.getMessage());
            } catch (IOException ex1) {
                System.err.println(ex1.getMessage());
            }
        } 
        catch (IOException ex) 
        {
            System.err.println(ex.getMessage());
        } 
        catch (ClassNotFoundException ex) 
        {
            System.err.println(ex.getMessage());
        }
    }
}
