package tests;

import main.FriendNotFoundException;
import main.User;
import org.junit.jupiter.api.Test;

public class UserTest {
    public static void main(String[] args) {
        User u1 = new User("Name 1", "userName1", "password1");
        User u2 = new User("Name 2", "userName2", "password2");
        User u3 = new User("Name 3", "userName3", "password3");
        User u4 = new User("Name 4", "userName4", "password4");
        u1.createProfile("Bio 1", "email1@purdue.edu", "Location 1");
        u2.createProfile("Bio 2", "email2@purdue.edu", "Location 2");
        u3.createProfile("Bio 3", "email3@purdue.edu", "Location 3");
        u4.createProfile("Bio 4", "email4@purdue.edu", "Location 4");
        System.out.println("-- User Field Tests: ---");
        try {
            System.out.println(u1.getSentRequests().size());
            System.out.println(u2.getReceivedRequests().size());
            u1.sendFriendRequest(u2);
            System.out.println(u1.getSentRequests().size());
            System.out.println(u2.getReceivedRequests().size());
            u2.denyFriend(u1);
            System.out.println(u1.getSentRequests().size());
            System.out.println(u2.getReceivedRequests().size());
            u2.sendFriendRequest(u3);
            u1.sendFriendRequest(u2);
            u3.sendFriendRequest(u2);
            System.out.println(u2.getSentRequests().size());
            System.out.println(u3.getReceivedRequests().size());
            System.out.println(u2.getReceivedRequests().size());
            System.out.println(u3.getSentRequests().size());
            System.out.println("-- User Friend Tests: ---");
            System.out.println(u2.getFriendList().size());
            System.out.println(u3.getFriendList().size());
            System.out.println(u2.getFriendList().size());
            System.out.println(u3.getFriendList().size());
        } catch (FriendNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getFullName() {
    }

    @Test
    void getUserName() {
    }

    @Test
    void getPassword() {
    }

    @Test
    void getProfile() {
    }

    @Test
    void getFriendList() {
    }

    @Test
    void getSentRequests() {
    }

    @Test
    void getReceivedRequests() {
    }

    @Test
    void setFullName() {
    }

    @Test
    void setUserName() {
    }

    @Test
    void setPassword() {
    }

    @Test
    void writeUserToFile() {
    }

    @Test
    void sendFriendRequest() {
    }

    @Test
    void removeFriendRequest() {
    }

    @Test
    void addReceivedRequest() {
    }

    @Test
    void removeReceivedRequest() {
    }

    @Test
    void acceptFriend() {
    }

    @Test
    void denyFriend() {
    }

    @Test
    void removeFriend() {
    }

    @Test
    void createProfile() {
    }

    @Test
    void testCreateProfile() {
    }

    @Test
    void testCreateProfile1() {
    }

    @Test
    void testCreateProfile2() {
    }

    @Test
    void deleteProfile() {
    }
}
