package Strategy;

public class Shopping
{
    private IPaymentMethod paymentMethod;

    public Shopping(IPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public IPaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
