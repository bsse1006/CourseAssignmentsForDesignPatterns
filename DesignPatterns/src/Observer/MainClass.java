package Observer;

public class MainClass
{
    public static void main(String[] args) {
        YoutubeChannel youtubeChannel = new YoutubeChannel();

        IObserver observer = new AccountObserver();
        youtubeChannel.subscribe(observer);

        observer = new EmailObserver();
        youtubeChannel.subscribe(observer);

        observer = new SMSObserver();
        youtubeChannel.subscribe(observer);

        youtubeChannel.sendNotification();
    }
}
