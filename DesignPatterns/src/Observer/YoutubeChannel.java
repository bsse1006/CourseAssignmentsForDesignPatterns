package Observer;

import java.util.ArrayList;

public class YoutubeChannel
{
    ArrayList<IObserver> listOfSubscribers = new ArrayList<>();

    public void videoUpload ()
    {
        sendNotification();
    }

    public void unsubscribe (IObserver observer)
    {
        listOfSubscribers.remove(observer);
    }

    public void subscribe (IObserver observer)
    {
        listOfSubscribers.add(observer);
    }

    public void sendNotification ()
    {
        for(IObserver observer: listOfSubscribers)
        {
            observer.getNotification();
        }
    }
}
