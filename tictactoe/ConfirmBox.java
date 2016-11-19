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
public class ConfirmBox {
    private static Label messageLabel;
    private static Button OKButton;
    private static Stage window;
    private static Scene scene;
    
    //layouts
    private static VBox vBox;
    
    public static void display(String title, String message)
    {
        window = new Stage();
        window.setMinHeight(200);
        window.setMinWidth(300);
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);
        
        messageLabel = new Label(message);
        messageLabel.setPadding(new Insets(10,10,10,10));
        
        OKButton = new Button("OK");
        OKButton.setPadding(new Insets(10,10,10,10));
        OKButton.setOnAction(e -> window.close());
        
        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        
        vBox.getChildren().addAll(messageLabel, OKButton);
        scene = new Scene(vBox);
        
        window.setScene(scene);
        window.showAndWait();
    }
}
