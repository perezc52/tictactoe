
package tictactoe;

import javafx.application.Application;
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
    
    private PlayerStub p1;
    private RegisterMenu r1;
    private DifficultyMenu d1;
    private LoginMenu l1;
    private HistoryMenu h1;
    
    @Override
    public void start(Stage primaryStage) {

        
        
        //GUI
        
        Scene menuScene;
        Scene poScene;
        Scene registerScene;
        Scene loginScene;
        Scene diffScene;
        Scene historyScene;
        
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
        
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(menuScene);
        primaryStage.show();
        
        
        //Player options scene
        
        VBox poLayout = new VBox(20);
        
        Label playerNum = new Label("Player 1");
        Button login = new Button("Login");
        Button register = new Button("Register");
        Button guest = new Button("Play as Guest");
        Button goBack = new Button("Back to Main Menu");
        
        poLayout.getChildren().addAll(playerNum, login, register, guest, goBack);
        poLayout.setPadding(new Insets(10, 10, 10, 10));
        poLayout.setAlignment(Pos.CENTER);

        poScene = new Scene(poLayout, 300, 250);
        
        //Register Scene
        
        VBox registerMenuLayout = new VBox(15);
    
        Label registerLabel = new Label("Pick a username:");
        TextField txtRegisterUsername = new TextField();
        Button registerGoBack = new Button("Back to player options");
        Button registerConfirm = new Button("Confirm");

        registerMenuLayout.getChildren().addAll(registerLabel, txtRegisterUsername, registerConfirm, registerGoBack);
        registerMenuLayout.setPadding(new Insets(10, 10, 10, 10));
        
        registerScene = new Scene(registerMenuLayout, 300, 180);
        
        //Login Scene
        
        ListView<String> listOfPlayers;
        Label loginLabel;
        Button backToPo;
        Button confirm;
        
        listOfPlayers = new ListView<>();
        loginLabel = new Label("Pick your username");
        backToPo = new Button("Back to Player Options");
        confirm = new Button("Confirm");
        
        VBox loginVBox = new VBox(10);
        HBox loginHBox = new HBox(50);
        
        loginHBox.getChildren().addAll(backToPo, confirm);
        loginVBox.getChildren().addAll(loginLabel, listOfPlayers, loginHBox);
        loginVBox.setPadding(new Insets(10, 10, 10, 10));
        loginVBox.setAlignment(Pos.CENTER);
        
        loginScene = new Scene(loginVBox, 300, 250);
        
        
        //History Scene
        
        TableView<PlayerStub> table;
        
        TableColumn<PlayerStub, String> nameColumn = new TableColumn<>("Player");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        
        TableColumn<PlayerStub, String> winsColumn = new TableColumn<>("Wins");
        winsColumn.setMinWidth(100);
        winsColumn.setCellValueFactory(new PropertyValueFactory<>("numOfWins"));
        
        TableColumn<PlayerStub, String> lossColumn = new TableColumn<>("Losses");
        lossColumn.setMinWidth(100);
        lossColumn.setCellValueFactory(new PropertyValueFactory<>("numOfLoss"));
        
        TableColumn<PlayerStub, Double> ratioColumn = new TableColumn<>("Win/Loss Ratio");
        ratioColumn.setMinWidth(120);
        ratioColumn.setCellValueFactory(new PropertyValueFactory<>("ratio"));
        
        table = new TableView<>();
        table.getColumns().addAll(nameColumn, winsColumn, lossColumn, ratioColumn);
        
        Button clearHistory, historyToMenu;
        clearHistory = new Button("Clear History");
        historyToMenu = new Button("Back To Main Menu");
        
        HBox historyHBox = new HBox(260);
        VBox historyVBox = new VBox(10);
        
        historyHBox.getChildren().addAll(clearHistory, historyToMenu);
        historyHBox.setPadding(new Insets(10, 10, 10, 10));
        historyVBox.getChildren().addAll(table, historyHBox);
        
        historyScene = new Scene(historyVBox);
        
   
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
        
        
        //Button Actions
        
        //Main Menu Buttons
        viewHistory.setOnAction(e -> OpenHistoryMenu(primaryStage, historyScene));
        onePlayer.setOnAction(e -> primaryStage.setScene(poScene));
        twoPlayers.setOnAction(e -> primaryStage.setScene(poScene));
        quit.setOnAction(e -> primaryStage.close());
        
        //Player Option Buttons
        login.setOnAction(e -> OpenLoginMenu(primaryStage, loginScene));
        register.setOnAction(e -> OpenRegisterMenu(primaryStage, registerScene));
        guest.setOnAction(e -> System.out.println("Playing as Guest"));
        goBack.setOnAction(e -> primaryStage.setScene(menuScene));
        
        //Login Menu Buttons
        backToPo.setOnAction(e -> primaryStage.setScene(poScene));
        
        
        //Register Menu Buttons
        registerGoBack.setOnAction(e -> primaryStage.setScene(poScene));
        
        //History Menu Buttons
        historyToMenu.setOnAction(e -> primaryStage.setScene(menuScene));
        
        
        
        }
    
    
    
    //Methods
        

    public PlayerStub OpenLoginMenu(Stage primaryStage, Scene loginScene) {
            
            PlayerStub pLogin = new PlayerStub();
            primaryStage.setScene(loginScene);
            return pLogin;
    }
        
    public PlayerStub OpenRegisterMenu(Stage primaryStage, Scene registerScene) {
            
            PlayerStub pRegister = new PlayerStub();
            primaryStage.setScene(registerScene);
            return pRegister;
    }
        
    public void OpenHistoryMenu(Stage window, Scene historyScene) {
            
            window.setScene(historyScene);
    }
    
    

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void initializeBoardScene()
    {
        
    }
}
