package main;

import java.io.*;
import java.util.ArrayList;
/**
 * A User class that creates a user based on sign up parameters and allows the creation and deletion
 * of a Profile along with management of a Friends list and sent and received friends Requests.
 *
 * <p>Purdue University -- CS18000 -- Fall 2020 -- Project 05</p>
 *
 * @author Elijah Colwill
 * @version December 01, 2020
 */
public class User {
    private String fullName;
    private String userName;
    private String password;

    private String temp;

    Profile profile = null;

    private ArrayList<FriendRequest> sentRequests = new ArrayList<FriendRequest>();
    private ArrayList<FriendRequest> receivedRequests = new ArrayList<FriendRequest>();

    private ArrayList<User> friendList = new ArrayList<User>();

    /**
     * Constructor that creates user class with Sign Up Information.
     * @param fullName String that holds name of person creating User.
     * @param userName String that holds username of user being created.
     * @param password String that holds password of user being created.
     */
    public User(String fullName, String userName, String password) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
    }

    /**
     * Mutator method for temp.
     * @param temp Variable that holds temp user for ClientHandler.
     */
    public void setTemp(String temp) {
        this.temp = temp;
    }

    /**
     * Accessor method for temp.
     * @return Variable that holds temp user for ClientHandler.
     */
    public String getTemp() {
        return temp;
    }

    /**
     * Accessor method for fullName.
     * @return fullName String that holds name of person creating User.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Accessor method for userName.
     * @return userName String that holds username of user being created.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Accessor method for password.
     * @return password String that holds password of user being created.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Accessor method for profile.
     * @return profile Profile object that holds information for a User's profile.
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * Accessor method for friendList.
     * @return friendList ArrayList that holds friends of the User.
     */
    public ArrayList<User> getFriendList() {
        return friendList;
    }

    /**
     * Accessor method for sentRequests.
     * @return sentRequests ArrayList that holds friend requests that are pending from the User.
     */
    public ArrayList<FriendRequest> getSentRequests() {
        return sentRequests;
    }

    /**
     * Accessor method for receivedRequests.
     * @return receivedRequests ArrayList that holds friend requests that the User has received.
     */
    public ArrayList<FriendRequest> getReceivedRequests() {
        return receivedRequests;
    }

    /**
     * Mutator method for fullName.
     * @param fullName String that holds name of person creating User.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Mutator method for userName.
     * @param userName String that holds username of user being created.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Mutator method for password.
     * @param password String that holds password of user being created.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * This method writes the user details to a file for storing this data.
     * @param user the user object whose data is being stored.
     */
    public void writeUserToFile(User user) {

        try {

            String home = System.getProperty("user.home");

            FileOutputStream fileOutputStream = new FileOutputStream(home + File.separator + "userListFile", true);
            PrintWriter writer = new PrintWriter(fileOutputStream);

            writer.println(this.userName + "," + this.password + "," + this.fullName);

            writer.flush();

            fileOutputStream.close();
            writer.close();




        } catch (FileNotFoundException fne) {

            fne.getMessage();

        } catch (IOException ioe) {

            ioe.getMessage();
        }

    }

    /**
     * Method that sends a friend request object to the user specified.
     * @param user User object that is being sent a friend request.
     */
    public void sendFriendRequest(User user) throws FriendNotFoundException {
        for (int i = 0; i < sentRequests.size(); i++) {
            if (sentRequests.get(i).getRecipient().getUserName().equals(user.getUserName())) {
                throw new FriendNotFoundException("Friend Request Error: Friend Already in Requests List");
            }
        }
        sentRequests.add(new FriendRequest(this, user));
    }

    /**
     * Method that revokes a sent request to the User specified.
     * @param user User object that is no longer being sent a friend request.
     */
    public void removeFriendRequest(User user) throws FriendNotFoundException {
        for (int i = 0; i < sentRequests.size(); i++) {
            if (sentRequests.get(i).getRecipient().getUserName().equals(user.getUserName())) {
                sentRequests.get(i).getRecipient().removeReceivedRequest(sentRequests.get(i));
                sentRequests.remove(i);
                return;
            }
        }
        throw new FriendNotFoundException("Friend Request Error: Friend Not Found");
    }

    /**
     * Method that receives a friend request and adds it to pending requests.
     * @param request FriendRequest that holds the sender and recipient users.
     */
    public void addReceivedRequest(FriendRequest request) throws FriendNotFoundException {
        for (int i = 0; i < receivedRequests.size(); i++) {
            if (receivedRequests.get(i).getSender().getUserName().equals(request.getSender().getUserName())) {
                throw new FriendNotFoundException("Friend Request Error: Friend Already in Pending List");
            }
        }
        receivedRequests.add(request);
    }

    /**
     * Method that removes a friend request that is pending action from user.
     * @param request FriendRequest that holds the sender and recipient users.
     */
    public void removeReceivedRequest(FriendRequest request) throws FriendNotFoundException {
        for (int i = 0; i < receivedRequests.size(); i++) {
            if (receivedRequests.get(i).getSender().getUserName().equals(request.getSender().getUserName())) {
                receivedRequests.remove(i);
                return;
            }
        }
        throw new FriendNotFoundException("Friend Request Error: Friend Not Found in Sender's Pending List");
    }

    /**
     * Method that accepts a pending friend request and changes appropriate arrays.
     * Adds friend to friendList.
     * @param user User that is being accepted from pending received requests.
     */
    public void acceptFriend(User user) throws FriendNotFoundException {
        for (int i = 0; i < receivedRequests.size(); i++) {
            if (receivedRequests.get(i).getSender().getUserName().equals(user.getUserName())) {
                for (int j = 0; j < friendList.size(); j++) {
                    if (friendList.get(j).getUserName().equals(user.getUserName())) {
                        throw new FriendNotFoundException("Accept Friend Error: Friend already added");
                    }
                }
                friendList.add(user);
                receivedRequests.get(i).getSender().getFriendList().add(receivedRequests.get(i).getRecipient());
                receivedRequests.get(i).getSender().removeFriendRequest(receivedRequests.get(i).getRecipient());
                return;
            }
        }
        throw new FriendNotFoundException("Accept Friend Error: Friend Not In Requests");
    }

    /**
     * Method that denies a pending friend request and changes appropriate arrays.
     * @param user User that is being denied from pending received requests.
     */
    public void denyFriend(User user) throws FriendNotFoundException {
        for (int i = 0; i < receivedRequests.size(); i++) {
            if (receivedRequests.get(i).getSender().getUserName().equals(user.getUserName())) {
                receivedRequests.get(i).getSender().removeFriendRequest(receivedRequests.get(i).getRecipient());
                return;
            }
        }
        throw new FriendNotFoundException("Deny Friend Error: Friend Not In Requests");
    }

    /**
     * Method that removes a friend from friendList.
     * @param user User that is being removes from User's friends.
     */
    public void removeFriend(User user) throws FriendNotFoundException {
        for (int i = 0; i < friendList.size(); i++) {
            if (friendList.get(i).getUserName().equals(user.getUserName())) {
                friendList.remove(i);
                return;
            }
        }
        throw new FriendNotFoundException("Remove Friend Error: Friend Not Found");
    }

    /**
     * Method that creates the User's profile based on given parameters, the Username and Friends List.
     * @param bio String that holds biography of User.
     * @param email String that holds email address of User.
     */
    public void createProfile(String bio, String email) {
        profile = new Profile(userName, bio, email, friendList);
    }

    /**
     * Method that creates the User's profile based on given parameters, the Username and Friends List.
     * @param bio String that holds biography of User.
     * @param email String that holds email address of User.
     * @param location String that holds location of User.
     */
    public void createProfile(String bio, String email,
                   String location) {
        profile = new Profile(userName, bio, email, friendList, location);
    }

    /**
     * Method that creates the User's profile based on given parameters, the Username and Friends List.
     * @param bio String that holds biography of User.
     * @param email String that holds email address of User.
     * @param location String that holds location of User.
     * @param interests String that holds interests/hobbies of User.
     */
    public void createProfile(String bio, String email,
                   String location, String interests) {
        profile = new Profile(userName, bio, email, friendList, location, interests);
    }

    /**
     * Method that creates the User's profile based on given parameters, the Username and Friends List.
     * @param bio String that holds biography of User.
     * @param email String that holds email address of User.
     * @param location String that holds location of User.
     * @param interests String that holds interests/hobbies of User.
     * @param phoneNum int that holds Phone Number of User.
     */
    public void createProfile(String bio, String email,
                   String location, String interests, int phoneNum) {
        profile = new Profile(userName, bio, email, friendList, location, interests, phoneNum);
    }

    /**
     * Method that deletes the User's profile and information.
     */
    public void deleteProfile() {
        profile = null;
    }

}
