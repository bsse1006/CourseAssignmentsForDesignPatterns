package Singleton;

public class EmniSingleton
{
    private static EmniSingleton emniSingleton = null;

    private EmniSingleton() {
    }

    public static EmniSingleton getInstance ()
    {
        if(emniSingleton==null)
        {
            synchronized (EmniSingleton.class)
            {
                if(emniSingleton==null)
                    emniSingleton = new EmniSingleton();
            }
        }
        return emniSingleton;
    }

    public void test ()
    {
        System.out.println("Test");
    }
}
