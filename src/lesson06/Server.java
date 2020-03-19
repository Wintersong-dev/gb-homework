package lesson06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int PORT = 9876;

    public static void main (String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        DataOutputStream out;
        DataInputStream in;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");
            socket = server.accept();
            System.out.println("Клиент подключен");

            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        System.out.println(in.readUTF());
                    }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }).start();

            Scanner sc = new Scanner(System.in);
            String str;
            while (true) {
                str = sc.nextLine();
                out.writeUTF(str);
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
