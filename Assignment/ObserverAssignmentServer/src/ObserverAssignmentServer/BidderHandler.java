package ObserverAssignmentServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class BidderHandler implements Runnable {

    private ObjectOutputStream ob = null;
    private ObjectInputStream ib = null;
    private Socket client;

    BidderHandler(Socket client, ObjectInputStream ib, ObjectOutputStream ob) {
        this.client = client;
        this.ib = ib;
        this.ob = ob;
    }

    void getNotification(int currentBid) throws IOException {
        String notification = "Current bid is " + currentBid;
        ob.writeObject(notification);
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    @Override
    public void run() {
        String received;
        while (true)
        {
            try
            {
                ob.writeObject("Enter your bid or logout: ");
                received = (String) ib.readObject();

                if(received.equals("logout")){
                    AuctionHandler.removeBidder(this);
                    this.client.close();
                    break;
                }
                else if (isInteger(received))
                {
                    AuctionHandler.setCurrentBid(Integer.parseInt(received));
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

    }
}
