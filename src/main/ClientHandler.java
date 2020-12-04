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
/*
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());*/

                //Thread t = new Client(portNum);

                //t.start();

                User newUser = null;

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

                            newUser = new User(name, username, password);      //creates a user object

                            Profile newProfile;                             //creates a profile object for the user

                            newUser.writeUserToFile(newUser);           //writes user data to file for storage

                            writer.write("Success");                //writes back to client

                            //creating a profile object using data entered by the user through the GUI
                            //receives all the user profile data as one line separated by commas (without spaces) up
                            //to the friendsList array list. The friendsList can be sent separately in another line
                            //with the friend usernames separated by commas.

                            String basicProfileInfo = reader.readLine();
                            String[] basicProfileArray = basicProfileInfo.split(",");

                            String ownerName = basicProfileArray[0];
                            String bio = basicProfileArray[1];
                            String email = basicProfileArray[2];
                            String locationInfo = "";
                            String interestsInfo = "";
                            int phoneNumber = 0;

                            String listOfFriends = reader.readLine();   //string of friends usernames
                            String[] arrayOfFriends = listOfFriends.split(",");

                            for (int i = 0; i < arrayOfFriends.length; i++) {

                                for (int j = 0; j < userList.size(); j++) {

                                    if (arrayOfFriends[i].equalsIgnoreCase(userList.get(j).getUserName())) {

                                        newUser.getFriendList().add(userList.get(j));   //adds the user to the friendsList
                                    }
                                }
                            }

                            //if the user enters other data such as phone number, location, interests, etc:

                            if (reader.readLine() != null) {

                                String moreProfileInfo = reader.readLine();
                                String[] moreProfileArray = moreProfileInfo.split(",");

                                if (moreProfileArray.length == 1) {

                                    locationInfo = moreProfileArray[0];

                                    newProfile = new Profile(ownerName, bio, email, newUser.getFriendList(), locationInfo);

                                } else if (moreProfileArray.length == 2) {

                                    locationInfo = moreProfileArray[0];
                                    interestsInfo = moreProfileArray[1];

                                    newProfile = new Profile(ownerName, bio, email, newUser.getFriendList(), locationInfo, interestsInfo);

                                } else if (moreProfileArray.length == 3) {

                                    locationInfo = moreProfileArray[0];
                                    interestsInfo = moreProfileArray[1];
                                    phoneNumber = Integer.parseInt(moreProfileArray[2]);

                                    newProfile = new Profile(ownerName, bio, email, newUser.getFriendList(), locationInfo,
                                            interestsInfo, phoneNumber);

                                }

                            } else {

                                newProfile = new Profile(ownerName, bio, email, newUser.getFriendList());
                            }

                            File newProfileInfo = new File(username + "Profile.txt");   //creates a new file for each user

                            FileOutputStream fos = new FileOutputStream(newProfileInfo);        //file output stream

                            PrintWriter profileInfoWriter = new PrintWriter(fos);               //print writer

                            profileInfoWriter.println(username);
                            profileInfoWriter.println(ownerName + "," + bio + "," + email);
                            profileInfoWriter.println(listOfFriends);

                            if (locationInfo != null) {

                                profileInfoWriter.write(locationInfo + ",");
                            }

                            if (interestsInfo != null) {

                                profileInfoWriter.write(interestsInfo + ",");
                            }

                            if (phoneNumber != 0) {

                                profileInfoWriter.write(phoneNumber);
                            }
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

                        writer.write("Success");

                    } else {                                //if the user didn't enter the correct login details

                        writer.write("incorrect username or password");
                    }
                }

                //edit profile
                String deleteMessage = reader.readLine();

                //if the user wishes to delete their account
                if (deleteMessage.equalsIgnoreCase("delete account")) {

                    userList.remove(newUser);       //removes user from the userList array
                    writer.write("Success");

                    //overwriting the User List file
                    for (int i = 0; i < userList.size(); i++) {

                        userList.get(i).writeUserToFile(userList.get(i));
                    }
                }

            } catch (IOException ioe) {
                ioe.getMessage();

            } catch (NumberFormatException nfe) {
                nfe.getMessage();
            }
        }
    }
}
