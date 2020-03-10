package StrategyAssignment;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;

public class MainClass extends Application
{
    public static void main (String [] args)
    {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton r1 = new RadioButton("Convert to CSV");
        r1.setToggleGroup(toggleGroup);
        RadioButton r2 = new RadioButton("Convert to XML");
        r2.setToggleGroup(toggleGroup);
        RadioButton r3 = new RadioButton("Convert to Json");
        r3.setToggleGroup(toggleGroup);

        Button fileBrowserButton = new Button("Select File and Convert");



        fileBrowserButton.setOnAction(event -> {
            File selectedFile = null;
            FileChooser fileChooser = new FileChooser();
            selectedFile=fileChooser.showOpenDialog(null);

            IConvertionMethod convertionMethod = null;

            if(r1.isSelected())
                convertionMethod = new CsvStrategy();
            else if(r3.isSelected())
                convertionMethod = new JsonStrategy();
            else if(r2.isSelected())
                convertionMethod = new XmlStrategy();

            if(selectedFile!=null && convertionMethod != null) {
                try {
                    convertionMethod.convert(selectedFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

// Place nodes in the pane
        pane.add(fileBrowserButton, 0, 4);
        pane.add(r1,0,1);
        pane.add(r2,0,2);
        pane.add(r3,0,3);

// Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowGridPane"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
