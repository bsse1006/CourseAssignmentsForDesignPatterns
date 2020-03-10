package CompositeAssignment;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public abstract class CompositeShape implements IShape
{
    ArrayList<IShape> shapes = new ArrayList<>();

    public abstract void buildShape();

    public void draw (Pane pane)
    {
        for (IShape shape: shapes)
        {
            shape.draw(pane);
        }
    }
}
