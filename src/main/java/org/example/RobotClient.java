package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class RobotClient {
    private String host;
    private int port;
    private Socket socket;
    private BufferedReader in;
    private OutputStream out;

    public RobotClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() throws UnknownHostException, IOException {
        socket = new Socket(host, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = socket.getOutputStream();
    }

    public void disconnect() throws IOException {
        socket.close();
    }

    public String getHost() {
        return host;
    }
    public int getPort(){
        return  port;
    }

    public String sendCommand(String command) throws IOException {
        out.write(command.getBytes());
        out.write('\n');
        out.flush();
        return in.readLine();
    }
}

