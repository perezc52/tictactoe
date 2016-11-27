
package tictactoe;



public class HistoryMenu {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tic Tac Toe Game");
GridPane grid = new GridPane();
grid.setAlignment(Pos.CENTER);
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(25, 25, 25, 25));


Button btn = new Button("View History");
HBox hbBtn = new HBox(10);
hbBtn.setAlignment(Pos.BOTTOM_LEFT);
hbBtn.getChildren().add(btn);
grid.add(hbBtn, 1, 4);


final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);


 btn.setOnAction(new EventHandler<ActionEvent>() // View History is clicked 
{

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.RED);
                actiontarget.setText("Showing list of players’ history");
            }
        });

//add and fix remaining code 

Void initializeHistoryList();
Void populateGrid();




 
}
