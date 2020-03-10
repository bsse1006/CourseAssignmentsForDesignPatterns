package Strategy;

public class RocketStrategy implements IPaymentMethod
{
    @Override
    public void pay() {
        System.out.println("Rocket e payment korbo");
    }
}
