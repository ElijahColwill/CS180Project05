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
                System.out.println(message);

                if (message.equals("sign in")) {
                    String signInUsername = reader.readLine();
                    String signInPassword = reader.readLine();
                    writer.write("Success");
                    writer.println();
                    writer.flush();
                    System.out.println("sent response");
                }

                if (message.equals("sign up")) {
                    String signUpUsername = reader.readLine();
                    String signUpPassword = reader.readLine();
                    String signUpName = reader.readLine();
                    String signUpEmail = reader.readLine();
                    writer.write("Success");
                    writer.println();
                    writer.flush();
                    System.out.println("sent response");
                }

                if (message.equals("change profile")) {
                    String changeProfileName = reader.readLine();
                    String changeProfileUsername = reader.readLine();
                    String changeProfileEmail = reader.readLine();
                    String changeProfilePassword = reader.readLine();
                    String changeProfileLocation = reader.readLine();
                    String changeProfileBio = reader.readLine();
                    String changeProfileInterests = reader.readLine();
                    writer.write("Success");
                    writer.println();
                    writer.flush();
                    System.out.println("sent response");
                }

                if (message.equals("delete account")) {
                    writer.write("Success");
                    writer.println();
                    writer.flush();
                    System.out.println("sent response");
                }

                if (message.equals("Information for user")) {
                    writer.write("Info");
                    writer.println();
                    writer.flush();
                    System.out.println("sent response");
                }

            } catch (IOException e) {

            }
        }
    }

}
