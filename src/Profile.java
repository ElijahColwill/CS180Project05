import java.lang.reflect.Array;
import java.util.ArrayList;

public class Profile {
    private String bio = "UNKNOWN";
    private String location = "UNKNOWN";
    private String interests = "UNKNOWN";
    private int phoneNum = 0;
    private String email = "UNKNOWN";

    private String owner;

    private ArrayList<User> friendList;

    public Profile(String owner, String bio, String email, ArrayList<User> friendList) {
        this.owner = owner;
        this.bio = bio;
        this.email = email;
        this.friendList = friendList;
    }

    public Profile(String owner, String bio, String email, ArrayList<User> friendList,
                   String location) {
        this(owner, bio, email, friendList);
        this.location = location;
    }

    public Profile(String owner, String bio, String email, ArrayList<User> friendList,
                   String location, String interests) {
        this(owner, bio, email, friendList, location);
        this.interests = interests;
    }

    public Profile(String owner, String bio, String email, ArrayList<User> friendList,
                   String location, String interests, int phoneNum) {
        this(owner, bio, email, friendList, location, interests);
        this.phoneNum = phoneNum;
    }

    public String getBio() {
        return bio;
    }

    public String getLocation() {
        return location;
    }

    public String getInterests() {
        return interests;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public String getOwner() {
        return owner;
    }

    public ArrayList<User> getFriendList() {
        return friendList;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFriendList(ArrayList<User> friendList) {
        this.friendList = friendList;
    }

    public String profileString() {
        return String.format("Owner: %s Bio: %s Email: %s", owner, bio, email);
    }
}
