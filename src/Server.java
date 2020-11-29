import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {

    private static int portNum;     //port number
    private static ArrayList<User> userList = new ArrayList<User>();       //array list that holds all the existing users

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(portNum);      //server socket creation

            Socket socket = serverSocket.accept();                      //socket creation

            File userListFile = new File("userList");           //file that stores user object information

            File friendsList = new File("friendsList");     //file that stores user's friends list

            FileReader userListReader = new FileReader(userListFile);       //file reader for userList
            FileReader friendsListReader = new FileReader(friendsList); //file reader for friendsList

            BufferedReader userReader = new BufferedReader(userListReader); //buffered reader for userList

            String line = userReader.readLine();

            //reading all the users from the userList and initialising the userList array list
            while (line != null) {

                String[] userData = line.split(",");

                String fullNameData = userData[0];
                String usernameData = userData[1];
                String passwordData = userData[2];

                User user = new User(fullNameData, usernameData, passwordData);
                userList.add(user);             //adding the user to the userList array

                line = userReader.readLine();   //reads next line
            }

            userReader.close();
            userListReader.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            //find out if its login or sign-up
            //receives a 1 if its login and 2 if its a sign-up.

            int choice = Integer.parseInt(reader.readLine());   //1 or 2 for determining login or sign-up

            //if sign-up, creates a new user account

            if (choice == 2) {

                if (reader.readLine() != null) {

                    boolean usernameExists = false;

                    String username = reader.readLine();        //gets username from client

                    for (int i = 0; i < userList.size(); i++) {     //checking to see if username already exists

                        if (username.equalsIgnoreCase(userList.get(i).getUserName())) {

                            usernameExists = true;
                            writer.write("Username already taken!");
                        }
                    }

                    if (!usernameExists) {      //if the username is unique and not taken already


                        String password = reader.readLine();        //gets password from client

                        String name = reader.readLine();            //gets user's name from client

                        User1 newUser = new User1(username, password, name);      //creates a user object

                        newUser.writeUserToFile(newUser);           //writes user data to file for storage

                        writer.write("Success");                //writes back to client
                    }

                }
            }

            //if the user is logging in

            if (choice == 1) {

                boolean invalidUsername = true;

                if (reader.readLine() != null) {

                    String username = reader.readLine();    //username entered by client

                    String password = reader.readLine();    //password entered by client

                    for (int i = 0; i < userList.size(); i++) {

                        if (username.equalsIgnoreCase(userList.get(i).getUserName()) &&
                                password.equalsIgnoreCase(userList.get(i).getPassword())) {

                            invalidUsername = false;
                        }
                    }
                }

                if (invalidUsername == false) {         //if the user entered the correct login details

                    writer.write("success");

                } else {                                //if the user didn't enter the correct login details

                    writer.write("incorrect username or password");
                }
            }

        } catch (IOException ioe) {
            ioe.getMessage();
        }

    }
}
