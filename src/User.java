import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class User {
    private String fullName;
    private String userName;
    private String password;

    Profile profile;

    private ArrayList<FriendRequest> sentRequests = new ArrayList<FriendRequest>();
    private ArrayList<FriendRequest> receivedRequests = new ArrayList<FriendRequest>();

    private ArrayList<User> friendList = new ArrayList<User>();

    public User(String fullName, String userName, String password) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Profile getProfile() {
        return profile;
    }

    public ArrayList<User> getFriendList() {
        return friendList;
    }

    public ArrayList<FriendRequest> getSentRequests() {
        return sentRequests;
    }

    public ArrayList<FriendRequest> getReceivedRequests() {
        return receivedRequests;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * This method writes the user details to a file for storing this data.
     * @param user the user object whose data is being stored.
     */
    public void writeUserToFile(User user) {

        try {

            FileOutputStream fileOutputStream = new FileOutputStream("userListFile");
            PrintWriter writer = new PrintWriter(fileOutputStream);

            writer.println(this.userName + "," + this.password + "," + this.fullName);

            fileOutputStream.close();
            writer.close();


        } catch (FileNotFoundException fne) {

            fne.getMessage();

        } catch (IOException ioe) {

            ioe.getMessage();
        }

    }

    public void sendFriendRequest(User user) throws FriendNotFoundException {
        for (int i = 0; i < sentRequests.size(); i++) {
            if (sentRequests.get(i).getRecipient().getUserName().equals(user.getUserName())) {
                throw new FriendNotFoundException("Friend Request Error: Friend Already in Requests List");
            }
        }
        sentRequests.add(new FriendRequest(this, user));
    }

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

    public void addReceivedRequest(FriendRequest request) throws FriendNotFoundException {
        for (int i = 0; i < receivedRequests.size(); i++) {
            if (receivedRequests.get(i).getSender().getUserName().equals(request.getSender().getUserName())) {
                throw new FriendNotFoundException("Friend Request Error: Friend Already in Pending List");
            }
        }
        receivedRequests.add(request);
    }

    public void removeReceivedRequest(FriendRequest request) throws FriendNotFoundException {
        for (int i = 0; i < receivedRequests.size(); i++) {
            if (receivedRequests.get(i).getSender().getUserName().equals(request.getSender().getUserName())) {
                receivedRequests.remove(i);
                return;
            }
        }
        throw new FriendNotFoundException("Friend Request Error: Friend Not Found in Sender's Pending List");
    }

    public void acceptFriend(User user) throws FriendNotFoundException {
        for (int i = 0; i < receivedRequests.size(); i++) {
            if (receivedRequests.get(i).getSender().getUserName().equals(user.getUserName())) {
                for (int j = 0; j < friendList.size(); j++) {
                    if (friendList.get(j).getUserName().equals(user.getUserName())) {
                        throw new FriendNotFoundException("Accept Friend Error: Friend already added");
                    }
                }
                friendList.add(user);
                receivedRequests.get(i).getSender().removeFriendRequest(receivedRequests.get(i).getRecipient());
                return;
            }
        }
        throw new FriendNotFoundException("Accept Friend Error: Friend Not In Requests");
    }

    public void denyFriend(User user) throws FriendNotFoundException {
        for (int i = 0; i < receivedRequests.size(); i++) {
            if (receivedRequests.get(i).getSender().getUserName().equals(user.getUserName())) {
                receivedRequests.get(i).getSender().removeFriendRequest(receivedRequests.get(i).getRecipient());
                return;
            }
        }
        throw new FriendNotFoundException("Deny Friend Error: Friend Not In Requests");
    }

    public void removeFriend(User user) throws FriendNotFoundException {
        for (int i = 0; i < friendList.size(); i++) {
            if (friendList.get(i).getUserName().equals(user.getUserName())) {
                friendList.remove(i);
                return;
            }
        }
        throw new FriendNotFoundException("Remove Friend Error: Friend Not Found");
    }

    public void createProfile(String bio, String email) {
        profile = new Profile(userName, bio, email, friendList);
    }

    public void createProfile(String bio, String email,
                   String location) {
        profile = new Profile(userName, bio, email, friendList, location);
    }

    public void createProfile(String bio, String email,
                   String location, String interests) {
        profile = new Profile(userName, bio, email, friendList, location, interests);
    }

    public void createProfile(String bio, String email,
                   String location, String interests, int phoneNum) {
        profile = new Profile(userName, bio, email, friendList, location, interests, phoneNum);
    }

    public void deleteProfile() {
        profile = null;
    }

}
