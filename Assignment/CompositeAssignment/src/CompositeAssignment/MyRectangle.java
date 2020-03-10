package CompositeAssignment;

public class MyRectangle extends CompositeShape
{
    MyLine myLine1;
    MyLine myLine2;
    MyLine myLine3;
    MyLine myLine4;

    public MyRectangle(double height, double width)
    {
        this.myLine1 = new MyLine(100,100,100,
                100+height);
        this.myLine2 = new MyLine(100,100,100+width,
                100);
        this.myLine3 = new MyLine(100+width,100,100
                +width,
                100+height);
        this.myLine4 = new MyLine(100,100+height,100+
                width,
                100+height);

        buildShape();
    }

    public void buildShape ()
    {
        shapes.add(myLine1);
        shapes.add(myLine2);
        shapes.add(myLine3);
        shapes.add(myLine4);
    }
}
