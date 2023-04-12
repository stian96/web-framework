package no.hiof.webframework.Servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private boolean isDone;

    public Client() {
        try {
            client = new Socket("127.0.0.1", 8080);
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }
        catch (IOException e) {
            shutdown();
        }
        this.isDone = false;
    }

    @Override
    public void run() {
        InputHandler inputHandler = new InputHandler();
        Thread thread = new Thread(inputHandler);
        thread.start();

        String inMessage;
        try {
            while ((inMessage = in.readLine()) != null)
            {
                System.out.println(inMessage);

            }
        }
        catch (IOException e) {
            shutdown();
        }

    }

    public void shutdown() {
        isDone = true;
        try {
            in.close();
            out.close();
            if (!client.isClosed()) {
                client.close();
            }
        }
        catch (IOException e) {
            // handle
        }
    }

    class InputHandler implements Runnable {

        @Override
        public void run() {
            try {
                BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
                while (!isDone)
                {
                    String message = inReader.readLine();
                    if (message.equals("quit")) {
                        inReader.close();
                        shutdown();
                    }
                    else {
                        out.println(message);
                    }
                }
            }
            catch (IOException e) {
                shutdown();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
