import java.io.*;
import java.net.Socket;

/**
 * Created by JGVSaramago on 24/10/2017.
 */
public class ServerInputStream extends Thread{

    private int ID;
    private Socket socket;
    private Server server;
    ObjectInputStream in;
    ObjectOutputStream out;

    public ServerInputStream(Socket socket, Server server, int ID) {
        this.socket = socket;
        this.server = server;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    @Override
    public void run() {
        Message m = null;
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream()); //autoFlush envia automaticamente
            while (true) {
               m = (Message) in.readObject();
                   if (m.getMessage().equals("FIM")) break;
               System.out.println(m.getMessage());
               server.sendMessagesToClients(m, ID);
            }
        } catch (IOException e) {
            System.out.println("User "+m.getUsername()+" disconnected from the chat.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendMessagesToClient(Message message) {
        try {
            out.writeObject(message);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
