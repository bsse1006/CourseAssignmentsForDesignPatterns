package Observer;

public class EmailObserver implements IObserver
{
    @Override
    public void getNotification() {
        System.out.println("Ami email e notification paisi");
    }
}
