import java.io.*;
import java.net.*;

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
