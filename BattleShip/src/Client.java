import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends Thread {
    private String ip;
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Message clientMessage;

    public static void main(String[] args) {
        String ip = "";
        new Client().start();
    }

    @Override
    public void run() {
        try {
            socket = new Socket(InetAddress.getByName("localhost"), 6666);
//            inputStream = new ObjectInputStream(socket.getInputStream());
//            outputStream = new ObjectOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
