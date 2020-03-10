package Composite;

import java.util.ArrayList;

public abstract class CompositeShape implements IShape
{
    ArrayList<IShape> shapes = new ArrayList<>();

    public abstract void buildShape();

    public void draw ()
    {
        for (IShape shape: shapes)
        {
            shape.draw();
        }
    }
}
