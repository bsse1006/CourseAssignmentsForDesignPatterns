package Composite;

public class Flag extends CompositeShape
{
    public void buildShape ()
    {
        Rectangle rectangle = new Rectangle();
        rectangle.buildShape();
        shapes.add(rectangle);
        shapes.add(new Circle());
    }
}