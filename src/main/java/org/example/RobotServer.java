package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RobotServer {
    public static void main(String[] args) throws IOException {
        int port = 8080; // choose a port number
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // handle the client connection in a separate thread
            Thread thread = new Thread(new RobotHandler(clientSocket));
            thread.start();
        }
    }
}

