//
//package tictactoe;
//
//
//public class LoginMenu {
//     @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Tic Tac Toe Game");
//GridPane grid = new GridPane(); //create gridpane object
//grid.setAlignment(Pos.CENTER); //position at the center
//grid.setHgap(5);
//grid.setVgap(5); //spaces between rows
//grid.setPadding(new Insets(10, 10, 10, 10));//space of edges
//
//
//Text scenetitle = new Text("Login");// text cant be edited
//scenetitle.setFont(Font.font("Arial", FontWeight.NORMAL, 10));
//grid.add(scenetitle, 0, 0, 2, 1); //column 0, row 0, column spam 2, row span 1
//
//
//
//Label userName = new Label("User Name:"); //label object that cannot be edited
//grid.add(userName, 0, 1); //column 0, row 1 
//1 method
//ObservableList<String> options = 
//    FXCollections.observableArrayList(
//        "username1",
//        "username2",
//        "username3"
//    );
//ComboBox comboBox = new ComboBox(allPlayerUsernames);
//
//
//
//
//2 method 
//ComboBox comboBox = new ComboBox(allPlayerUsernames);
//ComboBox setItems (allPlayerUsernames);
//
//Label pw = new Label("Password:");//label object that cannot be edited
//grid.add(pw, 0, 2); // column 0, row 2	
//
//PasswordField pwBox = new PasswordField(); // password field that can be edited 
//grid.add(pwBox, 1, 2);  //column 1, row 2 
//grid.setGridLinesVisible(true) // optional line to make the grid lines visible 
//
//
//Button btn = new Button("Log in"); // create button to log in 
//HBox hbBtn = new HBox(5); //create hbox with spacing of 5 pixels 
//hbBtn.setAlignment(Pos.BOTTOM_RIGHT); //position bottom right as usual seen on forms
//hbBtn.getChildren().add(btn);// button is added as a child of the hbox pane
//grid.add(hbBtn, 1, 4); //column 1, row 2
//
//
//final Text actiontarget = new Text(); //test control to display the message
//        grid.add(actiontarget, 1, 6);
//
//
//
//
//
//
//button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                if (ComboBox.getValue() != null && 
//                    !ComboBox.getValue().toString().isEmpty()){
//                        notification.setText("Loggin in"
//                           + " to " + address);   
//                        ComboBox.setValue(null);
//                       if (priorityComboBox.getValue() != null && 
//                            !priorityComboBox.getValue().toString().isEmpty()){
//                                priorityComboBox.setValue(null);
//                            }
//                        subject.clear();
//                        text.clear();
//                }
//                else {
//                    notification.setText("You have not selected a username from the combobox"); 
//                }
//            }
//        });
//       
//
//
//Scene scene = new Scene(grid, 300, 200);
//primaryStage.setScene(scene);
//
//        
//        primaryStage.show();
//    }
//
//
//
//
//
//}
