package ObserverAssignmentServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class AuctionHandler
{
    private ServerSocket server = null;
    final static int serverPort = 1234;

    public AuctionHandler() throws IOException {
        server = new ServerSocket(serverPort);
        System.out.println("Auction server port number: " + serverPort);
        listenForBidders();
    }

    private void listenForBidders ()
    {
        while(true) {
            try {
                Socket client = null;
                ObjectOutputStream ob = null;
                ObjectInputStream ib = null;

                client = server.accept();

                ob = new ObjectOutputStream(client.getOutputStream());
                ib = new ObjectInputStream(client.getInputStream());

                BidderHandler bidderHandler = new BidderHandler(client, ib, ob);

                addBidder(bidderHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void addBidder (BidderHandler bidder)
    {
        listOfBidders.add(bidder);
        Thread thread = new Thread(bidder);
        thread.start();
    }

    private static ArrayList<BidderHandler> listOfBidders = new ArrayList<>();
    private static int currentBid = 0;

    public static void sendNotification () throws IOException {
        for(BidderHandler bidder: listOfBidders)
        {
            bidder.getNotification(currentBid);
        }
        System.out.println("Current bid is " + currentBid);
    }

    synchronized public static void setCurrentBid(int currentBid) throws IOException {
        if(currentBid> AuctionHandler.currentBid) {
            AuctionHandler.currentBid = currentBid;
            sendNotification();
        }
    }

    public static void removeBidder (BidderHandler bidder)
    {
        listOfBidders.remove(bidder);
    }
}