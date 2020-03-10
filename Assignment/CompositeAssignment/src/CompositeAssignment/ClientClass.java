package CompositeAssignment;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClientClass extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
// Create a pane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        Button circleButton = new Button("MyCircle");
        Button recButton = new Button("MyRectangle");
        Button flagButton = new Button("Flag");
        Button lineButton = new Button("MyLine");

        circleButton.setOnAction(new CircleHandler(primaryStage));
        recButton.setOnAction(new RecHandler(primaryStage));
        flagButton.setOnAction(new FlagHandler(primaryStage));
        lineButton.setOnAction(new LineHandler(primaryStage));

// Place nodes in the pane
        pane.add(circleButton, 0, 0);
        pane.add(recButton, 0, 1);
        pane.add(flagButton, 0, 2);
        pane.add(lineButton, 0, 3);
// Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowGridPane"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        System.out.println("launch application");
        Application.launch(args);
    }
}

/*public class MainClass
{
    public static void main(String[] args)
    {
        MyRectangle rectangle = new MyRectangle();
        rectangle.buildShape();
        rectangle.draw();
        System.out.println("-----------------------");
        Flag flag = new Flag();
        flag.buildShape();
        flag.draw();




    }
}*/
