package networking;

import GameObjects.GameBoard;
import GameObjects.GameFrame;

import javax.swing.*;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class Server extends Thread {
    private static int port = 6666;
    private ServerSocket serverSocket;
    protected Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Message serverMessage;

    private void createWaitingDialog(GameFrame frame) {
        JDialog dialog = new JDialog();
        JOptionPane optionPane = new JOptionPane("waiting for other player to join ...",
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                null,
                new Object[]{},
                null);

        dialog.setTitle("Message");

        dialog.setModal(true);
        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();
        dialog.setLocationRelativeTo(frame);

        Thread disposeDialog = new Thread(() -> {
            try {
                socket = serverSocket.accept();
                dialog.dispose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        disposeDialog.start();
        dialog.setVisible(true);
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(6666);
            GameFrame frame = new GameFrame();
            frame.createAndShowGUI();

            createWaitingDialog(frame);
            JOptionPane.showMessageDialog(null, "Place your ships !", ""
                    , JOptionPane.INFORMATION_MESSAGE);

//            Message message = new Message(x , y , ismissed);
//            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
//            outputStream.writeObject(message);
//
//            inputStream = new ObjectInputStream(socket.getInputStream());
//            serverMessage = (Message) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void handleClientConnection(Socket clientSide) {
        // Setup streams and start handling client communication
        try (ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {

            // Example of sending a message
            // Message Logic here

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void closeServer(){
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            if (socket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().start();
    }
}