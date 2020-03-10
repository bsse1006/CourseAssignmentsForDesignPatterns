package CompositeAssignment;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

class RecHandler implements EventHandler<ActionEvent> {

    Stage primaryStage;

    public RecHandler(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void handle(ActionEvent e) {
        // Create a pane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);


// Place nodes in the pane
        pane.add(new Label("Height"), 0, 0);
        TextField txt = new TextField();
        pane.add(txt, 1, 0);
        pane.add(new Label("Width"), 0, 1);
        TextField txt1 = new TextField();
        pane.add(txt1, 1, 1);

        Button btAdd = new Button("Draw");
        btAdd.setOnAction(event -> {

            Pane cpane = new Pane();

            MyRectangle myRectangle = new MyRectangle(Double.parseDouble(txt.getText()),
                    Double.parseDouble(txt1.getText()));

            myRectangle.draw(cpane);

            Scene scene = new Scene(cpane);
            primaryStage.setTitle("ShowGridPane"); // Set the stage title
            primaryStage.setScene(scene); // Place the scene in the stage
            primaryStage.show();
        });
        pane.add(btAdd, 1, 2);
        GridPane.setHalignment(btAdd, HPos.RIGHT);
// Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowGridPane"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}