import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Client Handler
 *
 * This class contains the code implementation for all the client-server interactions inside a run method.
 *
 *
 * @author Sindhuja Kancharla
 * @version December 3, 2020
 *
 */

public class ClientHandler extends Thread {

    final Socket s;
    final BufferedReader reader;
    final PrintWriter writer;

    private static ArrayList<User> userList = new ArrayList<User>();       //array list that holds all the existing users
    private static ArrayList<Profile> profilesList = new ArrayList<Profile>();  //array list that holds all the existing profiles

    public ClientHandler(Socket s, BufferedReader r, PrintWriter w) {
        this.s = s;
        this.reader = r;
        this.writer = w;
    }

    @Override
    public void run() {

        while (true) {

            try {

                File userListFile = new File("userList");           //file that stores user object information

                File friendsList = new File("friendsList");     //file that stores user's friends list

                FileReader userFileReader = new FileReader(userListFile);       //file reader for userList
                FileReader friendsListReader = new FileReader(friendsList); //file reader for friendsList

                BufferedReader userReader = new BufferedReader(userFileReader); //buffered reader for userList

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
                userFileReader.close();

                User newUser = null;

                String choice = reader.readLine();   //determining login or sign-up

                //if sign-up, creates a new user account

                if (choice.equalsIgnoreCase("sign up")) {

                    if (reader.readLine() != null) {

                        boolean usernameExists = false;

                        String username = reader.readLine();        //gets username from client

                        for (int i = 0; i < userList.size(); i++) {     //checking to see if username already exists

                            if (username.equalsIgnoreCase(userList.get(i).getUserName())) {

                                usernameExists = true;
                                messageToClient("Username already taken");
                            }
                        }

                        if (!usernameExists) {      //if the username is unique and not taken already


                            String password = reader.readLine();        //gets password from client

                            String name = reader.readLine();            //gets user's name from client

                            String emailId = reader.readLine();         //gets email from client

                            newUser = new User(name, username, password);      //creates a user object

                            userList.add(newUser);                      //adding the new user to the User List

                            newUser.writeUserToFile(newUser);           //writes user data to file for storage

                            messageToClient("Success");                //writes back to client

                        }
                    }
                }

                //if the user is logging in/signing in

                if (choice.equalsIgnoreCase("sign in")) {

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

                        messageToClient("Success");

                    } else {                                //if the user didn't enter the correct login details

                        messageToClient("incorrect username or password");
                    }
                }

                String message = reader.readLine();             //reading from client

                //edit profile

                //if the user wishes to edit their profile

                if (message.equalsIgnoreCase("change profile")) {

                    String nameField = reader.readLine();
                    String usernameField = reader.readLine();
                    String emailField = reader.readLine();
                    String passwordField = reader.readLine();
                    String locationField = reader.readLine();
                    String bioField = reader.readLine();
                    String interestsField = reader.readLine();

                    Profile newProfile = new Profile(nameField, bioField, emailField,
                            newUser.getFriendList(), locationField, interestsField);   //creates a profile object for the user

                    profilesList.add(newProfile);       //adding the profile to the ProfilesList array

                    messageToClient("Success");
                }

                //if the user wishes to delete their account
                if (message.equalsIgnoreCase("delete account")) {

                    userList.remove(newUser);       //removes user from the userList array
                    messageToClient("Success");

                    //overwriting the User List file
                    for (int i = 0; i < userList.size(); i++) {

                        userList.get(i).writeUserToFile(userList.get(i));
                    }
                }

                //user wants to view profile
                if (message.equalsIgnoreCase("Information for user")) {

                    String currentUsername = reader.readLine();         //gets username from client
                    String currentOwner = null;

                    boolean userFound = false;

                    for (int i = 0; i < userList.size(); i++) {

                        if (currentUsername.equalsIgnoreCase(userList.get(i).getUserName())) {

                            userFound = true;
                            currentOwner = userList.get(i).getFullName();
                        }
                    }

                    if (!userFound) {       //if the user isn't found/ doesn't exist

                        messageToClient("User does not exist");
                    }

                    for (int j = 0; j < profilesList.size(); j++) {

                        if (currentOwner.equalsIgnoreCase(profilesList.get(j).getOwner())) {

                            String nameOfUser = profilesList.get(j).getOwner();
                            String userEmail = profilesList.get(j).getEmail();
                            String userLocation = profilesList.get(j).getLocation();
                            String userBio = profilesList.get(j).getBio();
                            String userInterests = profilesList.get(j).getInterests();

                            messageToClient(String.format("%s\n%s\n%s\n%s\n%s\n%s",nameOfUser, currentUsername,
                                                userEmail, userLocation, userBio, userInterests));
                        }
                    }
                }

                //to display friends list
                if (message.equalsIgnoreCase("Friends for user")) {

                    String currentUsername = reader.readLine();         //gets the username from the client
                    User currentUser = null;
                    StringBuilder friendsUsernames = new StringBuilder();
                    StringBuilder friendsNames = new StringBuilder();

                    for (int i = 0; i < userList.size(); i++) {

                        if (currentUsername.equalsIgnoreCase(userList.get(i).getUserName())) {

                            currentUser = userList.get(i);
                        }
                    }

                    //gets all the usernames of the friends
                    for (int j = 0; j < currentUser.getFriendList().size(); j++) {

                        friendsNames.append(currentUser.getFriendList().get(j).getFullName() + ",");      //string of names
                        friendsUsernames.append(currentUser.getFriendList().get(j).getUserName() + ",");  //string of usernames
                    }

                    messageToClient(String.valueOf(friendsUsernames) + "\n" + String.valueOf(friendsNames));
                }

                //incoming or outgoing friend request
                if (message.equalsIgnoreCase("Incoming friend request for user") ||
                        message.equalsIgnoreCase("Outgoing friend request for user")) {

                    String currentUsername = reader.readLine();
                    boolean userExists = false;

                    for (int i = 0; i < userList.size(); i++) {

                        if (currentUsername.equalsIgnoreCase(userList.get(i).getUserName())) {

                            userExists = true;
                            String userFullName = userList.get(i).getFullName();

                            messageToClient(String.format("User exists\n%s\n%s", userFullName, currentUsername));
                        }
                    }

                    if (!userExists) {          //if the user doesn't exist

                        messageToClient("User does not exist");
                    }
                }

                //displaying all users
                if (message.equalsIgnoreCase("Get all users")) {

                    StringBuilder allUsers = new StringBuilder();

                    for (int i = 0; i < userList.size(); i++) {

                        allUsers.append(userList.get(i).getUserName());
                    }

                    messageToClient(String.valueOf(allUsers));
                }

            } catch (IOException ioe) {
                ioe.getMessage();

            } catch (NumberFormatException nfe) {
                nfe.getMessage();
            }
        }
    }

    /**
     * This method writes back to the client.
     * @param message String message that needs to be written to the client.
     */
    public void messageToClient(String message) {

        writer.write(message);
        writer.println();
        writer.flush();
    }
}
