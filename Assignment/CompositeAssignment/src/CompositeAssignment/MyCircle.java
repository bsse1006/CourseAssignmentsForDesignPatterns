package CompositeAssignment;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyCircle implements IShape
{
    double radius;
    double x;
    double y;

    public MyCircle(double radius, double x, double y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public void draw (Pane pane)
    {
        Circle circle = new Circle();
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle.setRadius(radius);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.RED);
// Create a pane to hold the circle
        pane.getChildren().add(circle);
    }
}
