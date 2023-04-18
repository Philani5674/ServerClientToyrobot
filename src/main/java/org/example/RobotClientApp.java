package org.example;

import java.io.IOException;
import java.util.Scanner;

public class RobotClientApp {
    public static void main(String[] args) {
        RobotClient client = new RobotClient("localhost", 8080);

        try {
            client.connect();
            System.out.println("Connected to server on " + client.getHost() + ":" + client.getPort());

            Scanner scanner = new Scanner(System.in);
            String inputLine;
            while (!(inputLine = scanner.nextLine()).equals("off")) {
                String outputLine = client.sendCommand(inputLine);
                System.out.println(outputLine);
            }

            scanner.close();
            client.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

