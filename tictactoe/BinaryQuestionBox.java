/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author lucy
 */
public class BinaryQuestionBox {
    
    private static Label messageLabel;
    private static Button yesButton;
    private static Button noButton;
    private static Stage window;
    private static Scene scene;
    
    private static boolean answer;
    
    //layouts
    private static VBox vBox;
    private static HBox hBox;
    
    public static boolean display(String title, String message)
    {
        window = new Stage();
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);
        
        messageLabel = new Label(message);
        messageLabel.setPadding(new Insets(10,10,10,10));
        
        yesButton = new Button("Yes");
        noButton = new Button("No");
        
        yesButton.setOnAction(e -> {
            answer = true; 
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });
        
        hBox = new HBox();
        vBox = new VBox();
        
        hBox.setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);
        
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10,10,10,10));
        
        hBox.getChildren().addAll(yesButton, noButton);
        //hBox.getChildren().addAll(yesButton);
        vBox.getChildren().addAll(messageLabel, hBox);

        scene = new Scene(vBox);
        window.setScene(scene);
        window.showAndWait();
        
        return answer;
    }
}