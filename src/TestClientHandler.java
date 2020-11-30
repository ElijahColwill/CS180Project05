import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TestClientHandler extends Thread {

    final Socket s;
    final BufferedReader reader;
    final PrintWriter writer;

    public TestClientHandler(Socket s, BufferedReader r, PrintWriter w) {
        this.s = s;
        this.reader = r;
        this.writer = w;
    }

    public void run() {
        System.out.println("Connected");

        while (true) {
            try {
                String message = reader.readLine();
                if (message != null) {
                    System.out.println(message);
                    writer.write("Success");
                    writer.println();
                    writer.flush();
                    System.out.println("sent response");
                }
            } catch (IOException e) {

            }
        }
    }

}
