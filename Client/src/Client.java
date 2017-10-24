import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by JGVSaramago on 24/10/2017.
 */
public class Client {

    private final String CLIENTE_NAME;
    private static final String SERVER_NAME = "localhost";
    private static final int SERVER_PORT = 8080;
    private Socket socket;
    private ObjectOutputStream out;

    public Client(String CLIENTE_NAME) {
        this.CLIENTE_NAME = CLIENTE_NAME;
        try {
            startClient();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (this != null) closeConnections();
        }
    }

    public static void main(String[] args) {
        new GUI();
        Client c = new Client("João Saramago");

    }

    private void closeConnections() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startClient() throws IOException {
        doConnections();
        startTextReceiver();
        sendText();
    }

    private void startTextReceiver() {
        ClientInputStream textReceiver = new ClientInputStream(socket);
        textReceiver.start();
    }

    private void sendText() throws IOException {
        String sendStr = "";
        while (!sendStr.equals("SAIR")){
            Message m = new Message(new Scanner(System.in).nextLine(), CLIENTE_NAME);
            out.writeObject(m);
            out.flush();
        }
        out.writeObject("FIM");
        out.flush();
        System.out.println("Done");
    }

    private void doConnections() throws IOException {
        InetAddress address = InetAddress.getByName(SERVER_NAME);
        socket = new Socket(address, SERVER_PORT);
        out = new ObjectOutputStream(socket.getOutputStream()); //autoFlush envia automaticamente

    }

}
