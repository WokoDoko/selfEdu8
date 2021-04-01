package ru.geekbrains;

import java.io.*;
import java.net.*;

public class ChatServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            System.out.println("Server has been started!");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) {

                String message = in.readUTF();
                System.out.println("Received: " + message);
                out.writeUTF("Echo: " + message);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
