package no.hiof.webframework.Servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection implements Runnable {
    private final Socket client;
    private BufferedReader in;
    private PrintWriter out;

    private ChatServer chatServer;

    public Connection(Socket client, ChatServer server) {
        this.client = client;
        try {
            this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            this.out = new PrintWriter(client.getOutputStream(), true);
            this.chatServer = server;
        }
        catch (IOException e) {
            // TODO: handle
        }
    }


    @Override
    public void run() {
        try {
            out.println("Enter name: ");
            String name = in.readLine();
            printServerInfo(name);

            String message;
            while ((message = in.readLine()) != null)
            {
                if (message.startsWith("quit")) {
                    chatServer.broadcast(name + " left the chat!");
                    stop();
                }
                else {
                    chatServer.broadcast(name + ": " + message);
                }
            }
        }
        catch (IOException e) {
            stop();
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public void stop() {
        try {
            in.close();
            out.close();
            if (!client.isClosed()) {
                client.close();
            }
        }
        catch (IOException e) {
            // TODO: handle
        }
    }

    public void printServerInfo(String name) {
        System.out.println(name + " connected!");
        System.out.println(name + " joined the chat!");
    }
}
