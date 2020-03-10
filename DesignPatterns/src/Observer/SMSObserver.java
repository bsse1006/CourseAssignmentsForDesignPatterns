package Observer;

public class SMSObserver implements IObserver
{
    @Override
    public void getNotification() {
        System.out.println("Ami sms e notification paisi");
    }
}
