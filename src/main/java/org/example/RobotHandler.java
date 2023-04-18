package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class RobotHandler implements Runnable {
    private Socket clientSocket;
//    private Robot robot;

    public RobotHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
//        this.robot = new Robot(0, 0, Direction.NORTH); // create a new robot object
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            OutputStream out = clientSocket.getOutputStream();

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                String outputLine;
                if (inputLine.equals("MOVE")) {
                    System.out.println("Moved");
                    outputLine = "OK";
                } else if (inputLine.equals("LEFT")) {
//                    robot.turnLeft();
                    outputLine = "OK";
                } else if (inputLine.equals("RIGHT")) {
//                    robot.turnRight();
                    outputLine = "OK";
                } else if (inputLine.equals("REPORT")) {
                    outputLine = "Status";
                } else {
                    outputLine = "INVALID COMMAND";
                }

                out.write(outputLine.getBytes());
                out.write('\n');
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

