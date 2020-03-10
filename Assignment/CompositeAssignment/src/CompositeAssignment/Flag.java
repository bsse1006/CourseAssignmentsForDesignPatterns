package CompositeAssignment;

public class Flag extends CompositeShape
{
    MyRectangle myRectangle;
    MyCircle myCircle;
    public Flag(double height, double width)
    {
        this.myRectangle = new MyRectangle(height,width);

        this.myCircle = new MyCircle(width/5,100+(width*(4.0/10)),100+(height/2));

        buildShape();
    }

    public void buildShape ()
    {
        shapes.add(myRectangle);
        shapes.add(myCircle);
    }
}