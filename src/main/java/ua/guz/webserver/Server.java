package ua.guz.webserver;

import ua.guz.webserver.service.SocketHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private String resourceLocation;

    public Server(int port) {
        this.port = port;
    }

    public void setResourceLocation(String resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            SocketHandler socketHandler = new SocketHandler(socket, resourceLocation);
            socketHandler.process();
        }
    }
}
