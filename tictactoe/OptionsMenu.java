/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author lucy
 */
public class OptionsMenu {
     //Player options scene
    private static Scene poScene;
    private static Scene registerScene;
    private static Scene loginScene;

    private static Stage window;
    
    private static Player playerToReturn = null;
    
    private static HashMap<String, Player> playerMap;
    
    
    public static Player display(HashMap<String, Player> hMap, int playerNo)
    {
        //initialize window
        window = new Stage();
        window.setTitle("Player Options");
        window.initModality(Modality.APPLICATION_MODAL);
        
        //initialize hash map
        playerMap = hMap;
        
        //initialize register and login scene
        initializeRegisterScene();
        initializeLoginScene();
        
        //layouts and controls
        VBox poLayout = new VBox(20);

        Label playerNum = new Label("Player " + playerNo);
        Button login = new Button("Login");
        Button register = new Button("Register");
        Button guest = new Button("Play as Guest");
        Button goBack = new Button("Back to Main Menu");

        //Player Option Buttons
        login.setOnAction(e -> window.setScene(loginScene));
        register.setOnAction(e -> window.setScene(registerScene));
        guest.setOnAction(e -> {
            int noOfGuests = 0;
//            Set<String> pList = new ArrayList<>();
//            pList = playerMap.keySet();
            for (String x : playerMap.keySet())
            {
                if (x.contains("Guest"))
                {
                    noOfGuests++;
                }
            }
            System.out.println("Playing as Guest");
            ConfirmBox.display("Guest", "Playing as Guest " + noOfGuests);
            playerToReturn = new Player("Guest " + noOfGuests);
            playerMap.put(playerToReturn.getUsername(), playerToReturn);
            window.close();
            
        });
        goBack.setOnAction(e -> window.close());

        poLayout.getChildren().addAll(playerNum, login, register, guest, goBack);
        poLayout.setPadding(new Insets(10, 10, 10, 10));
        poLayout.setAlignment(Pos.CENTER);

        poScene = new Scene(poLayout, 300, 250);
        
        window.setScene(poScene);
        window.showAndWait();
        
        return playerToReturn;
    }
    
    public static void initializeRegisterScene()
    {
        //Register Scene
        
        VBox registerMenuLayout = new VBox(15);
    
        Label registerLabel = new Label("Pick a username:");
        TextField txtRegisterUsername = new TextField();
        Button registerGoBack = new Button("Back to player options");
        Button registerConfirm = new Button("Confirm");
        
        //Register Menu Buttons
        registerGoBack.setOnAction(e -> window.setScene(poScene));
        
        registerConfirm.setOnAction(e -> {
           //check if taken
           
           String userInput = txtRegisterUsername.getText();
           
           if (playerMap.containsKey(userInput))
           {
               ConfirmBox.display("Error", "Username already taken");
           }
           else
           {
               Player p = new Player(userInput);
               playerMap.put(userInput, p);
               ConfirmBox.display("Success", "Player " + userInput + " has registered");
               playerToReturn = playerMap.get(userInput);
               window.close();
           }
        });

        registerMenuLayout.getChildren().addAll(registerLabel, txtRegisterUsername, registerConfirm, registerGoBack);
        registerMenuLayout.setPadding(new Insets(10, 10, 10, 10));
        
        registerScene = new Scene(registerMenuLayout, 300, 180);
    }
    
    public static void initializeLoginScene()
    {
        //Login Scene
        
        ListView<String> listOfPlayers;
        Label loginLabel;
        Button backToPo;
        Button confirm;
        
        listOfPlayers = new ListView<>();
        ObservableList<String> pList;//
        loginLabel = new Label("Pick your username");
        backToPo = new Button("Back to Player Options");
        confirm = new Button("Confirm");
        
        for (String x : playerMap.keySet())
        {
            listOfPlayers.getItems().add(x);
        }
        
         //Login Menu Buttons
        backToPo.setOnAction(e -> window.setScene(poScene));
        
        confirm.setOnAction(e -> {
            String selectedPlayer = listOfPlayers.getSelectionModel().getSelectedItems().get(0);
            
            
            if (selectedPlayer == null)
            {
                ConfirmBox.display("Error", "You did not select a player");
            }
            else
            {
                playerToReturn = playerMap.get(selectedPlayer);
                window.close();
            }
            
        });
        
        VBox loginVBox = new VBox(10);
        HBox loginHBox = new HBox(50);
        
        loginHBox.getChildren().addAll(backToPo, confirm);
        loginVBox.getChildren().addAll(loginLabel, listOfPlayers, loginHBox);
        loginVBox.setPadding(new Insets(10, 10, 10, 10));
        loginVBox.setAlignment(Pos.CENTER);
        
        loginScene = new Scene(loginVBox, 300, 250);
    }
}
