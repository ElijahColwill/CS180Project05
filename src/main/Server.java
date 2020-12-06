package main;

import java.io.*;
import java.net.*;

/**
 * Server
 *
 * A multithreaded server that connects clients via Client Handlers.
 *
 *
 * @author Sindhuja Kancharla
 * @version December 3, 2020
 *
 */

public class Server {

    /**
     * Method that created all fields and initialized a ClientHandler thread for each user.
     * Testing:
     * Verify that when testing overall project, Server creates a thread for ClientHandler operations.
     * @param args String[] Default parameter for main method.
     */
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(2400);

        while (true) {

            Socket socket = null;

            socket = serverSocket.accept();

            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread t = new ClientHandler(socket, reader, writer);

            t.start();

        }

    }

}
