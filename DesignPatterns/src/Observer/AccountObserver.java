package Observer;

public class AccountObserver implements IObserver
{
    @Override
    public void getNotification() {
        System.out.println("Ami dashboard e notification paisi");
    }
}
