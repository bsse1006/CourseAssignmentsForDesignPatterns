package Strategy;

public class ClientClass
{
    public static void main (String [] args)
    {
        Shopping shopping = new Shopping(new RocketStrategy());
        shopping.getPaymentMethod().pay();
        System.out.println("-----------------------");
        shopping = new Shopping(new BkashStrategy());
        shopping.getPaymentMethod().pay();
    }
}
