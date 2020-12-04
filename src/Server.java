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

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(2400);

        while (true) {

            Socket socket = null;

            try {

                socket = serverSocket.accept();

                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                Thread t = new ClientHandler(socket, reader, writer);

                t.start();

            } catch (Exception e) {
                socket.close();
                e.printStackTrace();
            }

        }

    }

}
