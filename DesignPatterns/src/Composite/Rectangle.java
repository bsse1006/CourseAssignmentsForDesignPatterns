package Composite;

public class Rectangle extends CompositeShape
{
    public void buildShape ()
    {
        shapes.add(new Line());
        shapes.add(new Line());
        shapes.add(new Line());
        shapes.add(new Line());
    }
}
