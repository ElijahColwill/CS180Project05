package main;

import main.User;

import java.util.ArrayList;
/**
 * A main.Profile Class that handled the creation of a main.User's profile and stores the information
 * for retrieval by the user or application.
 *
 * <p>Purdue University -- CS18000 -- Fall 2020 -- Project 05</p>
 *
 * @author Elijah Colwill
 * @version December 01, 2020
 */
public class Profile {
    private String bio = "UNKNOWN";
    private String location = "UNKNOWN";
    private String interests = "UNKNOWN";
    private int phoneNum = 0;
    private String email = "UNKNOWN";

    private String owner;

    private ArrayList<User> friendList;

    /**
     * Constructor that creates main.Profile class with minimum required information.
     * @param owner String that holds the userName of the user who owns the profile.
     * @param bio String that holds biography of profile.
     * @param email String that holds email of user creating profile.
     * @param friendList ArrayList that contains the main.User's list of friends.
     */
    public Profile(String owner, String bio, String email, ArrayList<User> friendList) {
        this.owner = owner;
        this.bio = bio;
        this.email = email;
        this.friendList = friendList;
    }

    /**
     * Constructor that creates main.Profile class with minimum required information and
     * a location.
     * @param owner String that holds the userName of the user who owns the profile.
     * @param bio String that holds biography of profile.
     * @param email String that holds email of user creating profile.
     * @param friendList ArrayList that contains the main.User's list of friends.
     * @param location String that holds location of user creating profile.
     */
    public Profile(String owner, String bio, String email, ArrayList<User> friendList,
                   String location) {
        this(owner, bio, email, friendList);
        this.location = location;
    }

    /**
     * Constructor that creates main.Profile class with minimum required information and
     * a location and interest section.
     * @param owner String that holds the userName of the user who owns the profile.
     * @param bio String that holds biography of profile.
     * @param email String that holds email of user creating profile.
     * @param friendList ArrayList that contains the main.User's list of friends.
     * @param location String that holds location of user creating profile.
     * @param interests String that holds interests/hobbies of user creating profile.
     */
    public Profile(String owner, String bio, String email, ArrayList<User> friendList,
                   String location, String interests) {
        this(owner, bio, email, friendList, location);
        this.interests = interests;
    }

    /**
     * Constructor that creates main.Profile class with minimum required information and
     * a location, an interest section and a phone number.
     * @param owner String that holds the userName of the user who owns the profile.
     * @param bio String that holds biography of profile.
     * @param email String that holds email of user creating profile.
     * @param friendList ArrayList that contains the main.User's list of friends.
     * @param location String that holds location of user creating profile.
     * @param interests String that holds interests/hobbies of user creating profile.
     * @param phoneNum Phone Number with no formatting of user creating profile.
     */
    public Profile(String owner, String bio, String email, ArrayList<User> friendList,
                   String location, String interests, int phoneNum) {
        this(owner, bio, email, friendList, location, interests);
        this.phoneNum = phoneNum;
    }

    /**
     * Accessor method for bio.
     * @return bio String that holds biography of profile.
     */
    public String getBio() {
        return bio;
    }

    /**
     * Accessor method for location.
     * @return location String that holds location of user creating profile.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Accessor method for interests.
     * @return interests String that holds interests/hobbies of user creating profile.
     */
    public String getInterests() {
        return interests;
    }

    /**
     * Accessor method for phoneNum.
     * @return phoneNum Phone Number with no formatting of user creating profile.
     */
    public int getPhoneNum() {
        return phoneNum;
    }

    /**
     * Accessor method for email.
     * @return email String that holds email of user creating profile.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Accessor method for owner.
     * @return owner String that holds the userName of the user who owns the profile.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Accessor method for friendList.
     * @return friendList ArrayList that contains the main.User's list of friends.
     */
    public ArrayList<User> getFriendList() {
        return friendList;
    }

    /**
     * Mutator method for bio.
     * @param bio String that holds biography of profile.
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * Mutator method for location.
     * @param location String that holds location of user creating profile.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Mutator method for interests.
     * @param interests String that holds interests/hobbies of user creating profile.
     */
    public void setInterests(String interests) {
        this.interests = interests;
    }

    /**
     * Mutator method for phoneNum.
     * @param phoneNum Phone Number with no formatting of user creating profile.
     */
    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * Mutator method for email.
     * @param email String that holds email of user creating profile.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Mutator method for friendList.
     * @param friendList ArrayList that contains the main.User's list of friends.
     */
    public void setFriendList(ArrayList<User> friendList) {
        this.friendList = friendList;
    }

    /**
     * Method that outputs basic profile information as String for debugging purposes.
     * @return Formatted String with owner, bio, and email of user.
     */
    public String profileString() {
        return String.format("Owner: %s Bio: %s Email: %s", owner, bio, email);
    }
}
