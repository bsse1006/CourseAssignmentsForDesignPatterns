package TemplateMethod;

public class ClientClass
{
    public static void main (String [] args)
    {
        TourPackage tp = new LuxuryPackage();
        tp.hire();
        System.out.println("----------------------------");
        tp = new EconomyPackage();
        tp.hire();
        System.out.println("----------------------------");
        tp = new DeluxePackage();
        tp.hire();
    }
}
