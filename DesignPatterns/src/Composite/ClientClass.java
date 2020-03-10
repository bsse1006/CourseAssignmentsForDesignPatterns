package Composite;

public class ClientClass
{
    public static void main(String[] args)
    {
        Rectangle rectangle = new Rectangle();
        rectangle.buildShape();
        rectangle.draw();
        System.out.println("-----------------------");
        Flag flag = new Flag();
        flag.buildShape();
        flag.draw();
    }
}
