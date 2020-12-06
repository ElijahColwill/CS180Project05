package main;

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

                userList = readUsersList();        //initialises the userList array using data from a file.

                User newUser = null;
                Profile newProfile = null;

                String message = reader.readLine();   //determining login or sign-up

                while (message != null) {

                    //if sign-up, creates a new user account

                    if (message.equalsIgnoreCase("sign up")) {

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

                            newProfile = new Profile(name, "", emailId,
                                    newUser.getFriendList(), "", "");   //creates a profile object for the user

                            writeProfileToFile(username, newProfile);           //writes profile data to file

                            profilesList.add(newProfile);       //adding the profile to the ProfilesList array


                            messageToClient("Success");                //writes back to client

                        }
                    }

                    //if the user is logging in/signing in

                    if (message.equalsIgnoreCase("sign in")) {

                        boolean invalidUsername = true;

                        String username = reader.readLine();    //username entered by client

                        String password = reader.readLine();    //password entered by client

                        for (int i = 0; i < userList.size(); i++) {

                            if (username.equalsIgnoreCase(userList.get(i).getUserName()) &&
                                    password.equalsIgnoreCase(userList.get(i).getPassword())) {

                                invalidUsername = false;
                            }
                        }

                        newProfile = readFromProfileFile(username);     //assigning the profile object to the user

                        if (invalidUsername == false) {         //if the user entered the correct login details

                            messageToClient("Success");

                        } else {                                //if the user didn't enter the correct login details

                            messageToClient("incorrect username or password");
                        }
                    }


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

                        //setting the new data changed by user

                        newProfile.setBio(bioField);
                        newProfile.setEmail(emailField);
                        newProfile.setLocation(locationField);
                        newProfile.setInterests(interestsField);

                        writeProfileToFile(usernameField, newProfile);      //writes changes to file

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

                        String nameOfUser = newProfile.getOwner();
                        String userEmail = newProfile.getEmail();
                        String userLocation = newProfile.getLocation();
                        String userBio = newProfile.getBio();
                        String userInterests = newProfile.getInterests();

                        messageToClient(String.format("%s\n%s\n%s\n%s\n%s\n%s",nameOfUser, currentUsername,
                                userEmail, userLocation, userBio, userInterests));


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

                            allUsers.append(userList.get(i).getUserName() + ",");
                        }

                        messageToClient(String.valueOf(allUsers));
                    }

                    //accepting friend request
                    if (message.equalsIgnoreCase("Accept request")) {

                        String currentUsername = reader.readLine();
                        String temp = reader.readLine();        //temp is the other user
                        boolean userExists =  false;

                        User currentFriend = null;

                        for (int i = 0; i < userList.size(); i++) {

                            if (temp.equalsIgnoreCase(userList.get(i).getUserName())) {

                                userExists = true;
                                currentFriend = userList.get(i);        //gets the friend user object
                            }
                        }

                        if (userExists) {

                            newUser.getFriendList().add(currentFriend);     //adding friend to the user's friends list
                            messageToClient("Success");

                        } else {

                            messageToClient("User not found");
                        }

                    }

                    //denying friend request
                    if (message.equalsIgnoreCase("Deny request")) {

                        String currentUsername = reader.readLine();
                        String temp = reader.readLine();

                        messageToClient("Success");
                    }

                    message = reader.readLine();


                }


            } catch (IOException ioe) {
                ioe.getMessage();

            } catch (NumberFormatException nfe) {
                nfe.getMessage();
            }
        }
    }

    /**
     * This method initialises the UserList array by reading from a file.
     */
    public ArrayList<User> readUsersList() {

        try {

            String home = System.getProperty("user.home");

            File userListFile = new File(home + File.separator + "userListFile");           //file that stores user object information

            FileReader userFileReader = new FileReader(userListFile);       //file reader for userList

            BufferedReader userReader = new BufferedReader(userFileReader); //buffered reader for userList

            String line = userReader.readLine();

            //reading all the users from the userList and initialising the userList array list
            while (line != null && !line.equalsIgnoreCase("")) {

                String[] userData = line.split(",");

                String fullNameData = userData[2];
                String usernameData = userData[0];
                String passwordData = userData[1];

                User user = new User(fullNameData, usernameData, passwordData);
                userList.add(user);             //adding the user to the userList array

                line = userReader.readLine();   //reads next line
            }

            userReader.close();
            userFileReader.close();

        } catch (FileNotFoundException fne) {

            fne.getMessage();

        } catch (IOException ioe) {

            ioe.getMessage();
        }

        return userList;
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

    /**
     * This method reads data from a file to initialise the user's Profile.
     * @param username a String that contains the username.
     */
    public Profile readFromProfileFile(String username) {

        Profile profile = null;

        try {

            String home = System.getProperty("user.home");

            File profileDataFile = new File(home + File.separator + username + ".profile.txt");
            FileReader profileFileReader = new FileReader(profileDataFile);
            BufferedReader reader = new BufferedReader(profileFileReader);

            String userUsername = reader.readLine();

            String userData = reader.readLine();

            if (userData != null) {

                String[] basicUserData = userData.split(",");

                String owner = basicUserData[0];
                String bio = basicUserData[1];
                String email = basicUserData[2];

                String[] friendsData = reader.readLine().split(",");

                ArrayList<User> listOfFriends = initialiseFriendsList(friendsData);     //gets the array list of friends

                //location, interests, phoneNum

                if (reader.readLine() != null) {

                    String[] otherUserData = reader.readLine().split(",");

                    if (otherUserData.length == 1) {

                        String location = otherUserData[0];

                        profile = new Profile(owner, bio, email, listOfFriends, location);

                    } else if (otherUserData.length == 2) {

                        String location = otherUserData[0];
                        String interests = otherUserData[1];

                        profile = new Profile(owner, bio, email, listOfFriends, location, interests);

                    } else if (otherUserData.length == 3) {

                        String location = otherUserData[0];
                        String interests = otherUserData[1];
                        int phoneNum = Integer.parseInt(otherUserData[2]);

                        profile = new Profile(owner, bio, email, listOfFriends, location, interests, phoneNum);
                    }

                } else {

                    profile = new Profile(owner, bio, email, listOfFriends);
                }

            }

            reader.close();
            profileFileReader.close();  //commit these changes

        } catch (FileNotFoundException fne) {

            fne.getMessage();

        } catch (IOException ioe) {

            ioe.getMessage();
        }

        return profile;

    }



    /**
     * This method creates a new file for each profile object to store the data.
     * @param profile
     */
    public void writeProfileToFile(String username, Profile profile) {

        StringBuilder listOfFriends = new StringBuilder();

        try {

            String home = System.getProperty("user.home");

            File profileDataFile = new File(home + File.separator + username + ".profile.txt");    //creating a new file
            FileOutputStream fileOutputStream = new FileOutputStream(profileDataFile);
            PrintWriter printWriter = new PrintWriter(fileOutputStream);

            printWriter.println(username);
            printWriter.println(profile.getOwner() + "," + profile.getBio() + "," + profile.getEmail());

            for (int i = 0; i < profile.getFriendList().size(); i++) {

                listOfFriends.append(profile.getFriendList().get(i).getUserName() + ",");
            }

            printWriter.println(String.valueOf(listOfFriends));         //writes friends' usernames to the file

            if (profile.getLocation() != null) {

                printWriter.write(profile.getLocation() + ",");

                if (profile.getInterests() != null) {

                    printWriter.write(profile.getInterests() + ",");

                    if (String.valueOf(profile.getPhoneNum()) != null) {

                        printWriter.write(profile.getPhoneNum());
                    }
                }
            }

            printWriter.flush();
            fileOutputStream.close();
            printWriter.close();

        } catch (FileNotFoundException fne) {

            fne.getMessage();

        } catch (IOException ioe) {

            ioe.getMessage();
        }

    }

    /**
     * This method initializes the friends list array of the user.
     * @param friendsListData a string array of friends' usernames.
     * @return an Array List of type user
     */
    public ArrayList<User> initialiseFriendsList(String[] friendsListData) {

        ArrayList<User> listOfFriends = new ArrayList<User>();

        for (int i = 0; i < friendsListData.length; i++) {

            for (int j = 0; j < userList.size(); j++) {

                if (friendsListData[i].equalsIgnoreCase(userList.get(j).getUserName())) {

                    listOfFriends.add(userList.get(j));
                }
            }
        }

        return listOfFriends;
    }
}
