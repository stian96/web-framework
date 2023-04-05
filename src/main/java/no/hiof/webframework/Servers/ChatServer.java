package no.hiof.webframework.Servers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer implements Runnable {
    private ServerSocket server;
    private boolean isDone;

    private final List<Connection> connectionList;

    public ChatServer() {
        this.connectionList = new ArrayList<>();
        this.isDone = false;
    }

    @Override
    public void run() {
        try {
            server = new ServerSocket(8080);
            ExecutorService pool = Executors.newCachedThreadPool();
            while (!isDone)
            {
                Socket client = server.accept();
                Connection handler = new Connection(client, this);
                connectionList.add(handler);
                pool.execute(handler);
            }
        }
        catch (IOException e) {
            stopServer();
        }
    }

    public void broadcast(String message) {
        for (Connection ch : connectionList) {
            if (ch != null) {
                ch.sendMessage(message);
            }
        }
    }

    public void stopServer() {
        try {
            isDone = true;
            if (!server.isClosed()) {
                server.close();
            }
            for (Connection ch : connectionList) {
                ch.stop();
            }
        }
        catch (IOException e) {
            // TODO: handle
        }

    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.run();
    }
}
