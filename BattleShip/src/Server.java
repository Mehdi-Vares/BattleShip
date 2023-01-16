import GameObjects.GameFrame;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import javax.swing.*;

public class Server extends Thread {
    private static int port = 6666;
    private ServerSocket serverSocket;
    protected Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Message serverMessage;

    public static void main(String[] args) {
        new Server().start();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(6666);
            GameFrame frame = new GameFrame();
            frame.createAndShowGUI();
//            Thread.sleep(500);
//
//            JDialog dialog = new JDialog();
//            JOptionPane optionPane = new JOptionPane("waiting for other player to join ...",
//                    JOptionPane.INFORMATION_MESSAGE,
//                    JOptionPane.DEFAULT_OPTION,
//                    null,
//                    new Object[]{},
//                    null);
//
//            dialog.setTitle("Message");
//
//            dialog.setModal(true);
//            dialog.setContentPane(optionPane);
//            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
//            dialog.pack();
//            dialog.setLocationRelativeTo(frame);
//
//            Thread disposeDialog = new Thread(() -> {
//                try {
//                    socket = serverSocket.accept();
//                    dialog.dispose();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//
//            disposeDialog.start();
//            dialog.setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                socket.close();
//                serverSocket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

    }

}

