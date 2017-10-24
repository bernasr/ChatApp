import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by JGVSaramago on 24/10/2017.
 */
public class Server {

    private static final int PORT = 8080;
    private ArrayList<ServerInputStream> clients = new ArrayList<ServerInputStream>();
    private int clientscount = 0;

    public static void main(String[] args) {
        try {
            new Server().startServing();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startServing() throws IOException {
        ServerSocket s = null;
        Socket socket = null;
        try {
            s = new ServerSocket(PORT);
            while (true) {
                socket = s.accept();
                ServerInputStream client = new ServerInputStream(socket, this, clientscount);
                clientscount++;
                clients.add(client);
                client.start();
            }
        } finally { // executa quer existe exception ou nao
            if (socket != null) socket.close();
            if (s != null) s.close();
        }
    }

    public void sendMessagesToClients(Message m, int senderID){
        for (ServerInputStream client: clients){
            if (client.getID() != senderID)
                client.sendMessagesToClient(m);
        }
    }

}
