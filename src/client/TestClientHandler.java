package client;

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

        int incC = 0;
        int outC = 0;

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
                    writer.write("exists\nusername\nname\nemail\nlocation\nbio\ninterests");
                    writer.println();
                    writer.flush();
                    System.out.println("sent response");
                }

                if (message.equals("Friends for user")) {
                    writer.write("Full name 1,Full name 2\nUsername 1,Username 2");
                    writer.println();
                    writer.flush();
                    System.out.println("sent response");
                }

                String[] incNames = {"name 1", "name 2", "name 3"};
                String[] incUsernames = {"username 1", "username 2", "username 3"};
                if (message.equals("Incoming friend request for user")) {
                    writer.write(String.format("Exists\n%s\n%s", incNames[incC], incUsernames[incC]));
                    writer.println();
                    writer.flush();
                    System.out.println("sent response");
                    if (incC == incNames.length - 1) {
                        incC = 0;
                    } else {
                        incC++;
                    }
                }

                String[] outNames = {"name 1", "name 2", "name 3"};
                String[] outUsernames = {"username 1", "username 2", "username 3"};
                if (message.equals("Outgoing friend request for user")) {
                    writer.write(String.format("Exists\n%s\n%s", outNames[outC], outUsernames[outC]));
                    writer.println();
                    writer.flush();
                    if (outC == outNames.length - 1) {
                        outC = 0;
                    } else {
                        outC++;
                    }
                    System.out.println("sent response");
                }

                if (message.equals("Get all users")) {
                    writer.write("user1,user2");
                    writer.println();
                    writer.flush();
                    System.out.println("sent response");
                }

                if (message.equals("Cancel request")) {
                    String user1 = reader.readLine();
                    String user2 = reader.readLine();
                    writer.write("Success");
                    writer.println();
                    writer.flush();
                    System.out.println("sent response");
                }

                if (message.equals("Accept request")) {
                    String user1 = reader.readLine();
                    String user2 = reader.readLine();
                    writer.write("Success");
                    writer.println();
                    writer.flush();
                    System.out.println("sent response");
                }

                if (message.equals("Deny request")) {
                    String user1 = reader.readLine();
                    String user2 = reader.readLine();
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
