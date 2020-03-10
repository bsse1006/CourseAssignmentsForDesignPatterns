package ObserverAssignmentClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import static java.lang.System.exit;

public class MainClass {

    static int serverPort;

    public static void main(String args[]) throws UnknownHostException, IOException
    {
        System.out.println("Enter server port number: ");
        Scanner cin = new Scanner(System.in);
        serverPort = Integer.parseInt(cin.nextLine());

        InetAddress ip = InetAddress.getByName("localhost");

        Socket client = new Socket(ip, serverPort);

        ObjectInputStream ib = new ObjectInputStream(client.getInputStream());
        ObjectOutputStream ob = new ObjectOutputStream(client.getOutputStream());

        Thread send = new Thread(new Runnable()
        {
            @Override
            public void run() {
                while (true) {
                    String msg = cin.nextLine();
                    try {
                        ob.writeObject(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (msg.equals("logout"))
                        exit(0);
                }
            }
        });

        Thread receive = new Thread(new Runnable()
        {
            @Override
            public void run() {
                while (true) {
                    try {
                        String msg = (String) ib.readObject();
                        System.out.println(msg);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        send.start();
        receive.start();
    }
}

