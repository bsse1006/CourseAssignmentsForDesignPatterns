package CompositeAssignment;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class MyLine implements IShape
{
    double startX;
    double startY;
    double endX;
    double endY;

    public MyLine(double startX, double startY, double endX, double endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public void draw (Pane pane)
    {
            Line line = new Line (startX,startY,endX,endY);
            pane.getChildren().add(line);
    }
}
