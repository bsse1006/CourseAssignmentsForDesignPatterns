package ObserverAssignmentServer;

import java.io.IOException;

public class MainClass
{
    public static void main(String[] args) throws IOException {
        AuctionHandler auctionHandler = new AuctionHandler();

        auctionHandler.sendNotification();
    }
}
