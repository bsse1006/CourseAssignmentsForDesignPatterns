package Strategy;

public class BkashStrategy implements IPaymentMethod
{
    @Override
    public void pay() {
        System.out.println("Bkash e payment korbo");
    }
}
