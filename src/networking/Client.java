package networking;

import GameObjects.GameFrame;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends Thread {
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Message clientMessage;

    @Override
    public void run() {
        try (Socket socket = new Socket(InetAddress.getByName("localhost"), 6666);
             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {

            // Example of continuously reading messages
            Object message;
//            while ((message = inputStream.readObject()) != null) {
//                // Handle messages
//            }

        } catch (IOException e) {
            e.printStackTrace(); // Consider more user-friendly error handling
        }
    }


    public static void main(String[] args) {
        new Client().start();
    }
}
