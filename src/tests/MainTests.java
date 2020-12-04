package tests;

import main.*;
import client.*;
import gui.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTests {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCase.class);
        if (result.wasSuccessful()) {
            System.out.println("Excellent - Test ran successfully");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }

    /**
     * A set of public test cases for Social Network Project.
     *
     * <p>Purdue University -- CS18000 -- Fall 2020</p>
     *
     * @author ecolwill
     * @version December 01, 2020
     */

    public static class TestCase {
        private final PrintStream originalOutput = System.out;
        private final InputStream originalSysin = System.in;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayInputStream testIn;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayOutputStream testOut;

        @Before
        public void outputStart() {
            testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
        }

        @After
        public void restoreInputAndOutput() {
            System.setIn(originalSysin);
            System.setOut(originalOutput);
        }

        private String getOutput() {
            return testOut.toString();
        }

        @SuppressWarnings("SameParameterValue")
        private void receiveInput(String str) {
            testIn = new ByteArrayInputStream(str.getBytes());
            System.setIn(testIn);
        }

        @Test(timeout = 1_000)
        public void userClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = User.class;
            className = "User";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends Object.", Object.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void userClassSetupTest() {
            Field[] fields = User.class.getDeclaredFields();
            if (fields.length < 7) {
                fail("User class requires seven fields.");
                return;
            }

            try {
                Field fullName = User.class.getDeclaredField("fullName");
                if (fullName.getType() != String.class) {
                    fail("Ensure that fullName in class User is of type String.");
                    return;
                }
                if (fullName.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that fullName in class User has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field fullName in class User " +
                        "that is of type String and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Field userName = User.class.getDeclaredField("userName");
                if (userName.getType() != String.class) {
                    fail("Ensure that userName in class User is of type String.");
                    return;
                }
                if (userName.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that userName in class User has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field userName in class User " +
                        "that is of type String and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Field password = User.class.getDeclaredField("password");
                if (password.getType() != String.class) {
                    fail("Ensure that password in class User is of type String.");
                    return;
                }
                if (password.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that password in class User has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field password in class User " +
                        "that is of type String and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Field profile = User.class.getDeclaredField("profile");
                if (profile.getType() != Profile.class) {
                    fail("Ensure that profile in class User is of type Profile.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field profile in class User.");
                e.printStackTrace();
                return;
            }

            try {
                Field sentRequests = User.class.getDeclaredField("sentRequests");
                if (sentRequests.getType() != ArrayList.class) {
                    fail("Ensure that sentRequests in class User is of type ArrayList.");
                    return;
                }
                if (sentRequests.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that sentRequests in class User has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field sentRequests in class User " +
                        "that is of type ArrayList and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Field receivedRequests = User.class.getDeclaredField("receivedRequests");
                if (receivedRequests.getType() != ArrayList.class) {
                    fail("Ensure that receivedRequests in class User is of type ArrayList.");
                    return;
                }
                if (receivedRequests.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that receivedRequests in class User has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field receivedRequests in class User " +
                        "that is of type ArrayList and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Field friendList = User.class.getDeclaredField("friendList");
                if (friendList.getType() != ArrayList.class) {
                    fail("Ensure that friendList in class User is of type ArrayList.");
                    return;
                }
                if (friendList.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that friendList in class User has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field friendList in class User " +
                        "that is of type ArrayList and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<User> constructor = User.class.getDeclaredConstructor(String.class, String.class,
                        String.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class User is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 3 parameters and is public in class User.");
                e.printStackTrace();
                return;
            }

            try {
                Method getFullName = User.class.getDeclaredMethod("getFullName");
                if (getFullName.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getFullName in class User is public.");
                    return;
                }
                if (!getFullName.getReturnType().equals(String.class)) {
                    fail("Ensure that your getFullName method in class User returns a String.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getFullName method that is public and returns a String.");
                e.printStackTrace();
                return;
            }

            try {
                Method getUserName = User.class.getDeclaredMethod("getUserName");
                if (getUserName.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getUserName in class User is public.");
                    return;
                }
                if (!getUserName.getReturnType().equals(String.class)) {
                    fail("Ensure that your getUserName method in class User returns a String.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getUserName method that is public and returns a String.");
                e.printStackTrace();
                return;
            }

            try {
                Method getPassword = User.class.getDeclaredMethod("getPassword");
                if (getPassword.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getPassword in class User is public.");
                    return;
                }
                if (!getPassword.getReturnType().equals(String.class)) {
                    fail("Ensure that your getPassword method in class User returns a String.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getPassword method that is public and returns a String.");
                e.printStackTrace();
                return;
            }

            try {
                Method getProfile = User.class.getDeclaredMethod("getProfile");
                if (getProfile.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getProfile in class User is public.");
                    return;
                }
                if (!getProfile.getReturnType().equals(Profile.class)) {
                    fail("Ensure that your getProfile method in class User returns a Profile.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getProfile method that is public and returns a Profile.");
                e.printStackTrace();
                return;
            }

            try {
                Method getFriendList = User.class.getDeclaredMethod("getFriendList");
                if (getFriendList.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getFriendList in class User is public.");
                    return;
                }
                if (!getFriendList.getReturnType().equals(ArrayList.class)) {
                    fail("Ensure that your getFriendList method in class User returns an ArrayList.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getFriendList method that is public and returns a ArrayList.");
                e.printStackTrace();
                return;
            }

            try {
                Method getSentRequests = User.class.getDeclaredMethod("getSentRequests");
                if (getSentRequests.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getSentRequests in class User is public.");
                    return;
                }
                if (!getSentRequests.getReturnType().equals(ArrayList.class)) {
                    fail("Ensure that your getSentRequests method in class User returns a ArrayList.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getSentRequests method that is public and returns a ArrayList.");
                e.printStackTrace();
                return;
            }

            try {
                Method getReceivedRequests = User.class.getDeclaredMethod("getReceivedRequests");
                if (getReceivedRequests.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getReceivedRequests in class User is public.");
                    return;
                }
                if (!getReceivedRequests.getReturnType().equals(ArrayList.class)) {
                    fail("Ensure that your getReceivedRequests method in class User returns a ArrayList.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getReceivedRequests method that is public and returns a ArrayList.");
                e.printStackTrace();
                return;
            }

            try {
                Method setFullName = User.class.getDeclaredMethod("setFullName", String.class);
                if (setFullName.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method setFullName in class User is public.");
                    return;
                }
                if (!setFullName.getReturnType().equals(void.class)) {
                    fail("Ensure that your setFullName method in class User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the setFullName method that is public, takes 1 parameter of type String and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method setUserName = User.class.getDeclaredMethod("setUserName", String.class);
                if (setUserName.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method setUserName in class User is public.");
                    return;
                }
                if (!setUserName.getReturnType().equals(void.class)) {
                    fail("Ensure that your setUserName method in class User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the setUserName method that is public, takes 1 parameter of type String and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method setPassword = User.class.getDeclaredMethod("setPassword", String.class);
                if (setPassword.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method setPassword in class User is public.");
                    return;
                }
                if (!setPassword.getReturnType().equals(void.class)) {
                    fail("Ensure that your setPassword method in class User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the setPassword method that is public, takes 1 parameter of type String and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method writeUserToFile = User.class.getDeclaredMethod("writeUserToFile", User.class);
                if (writeUserToFile.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method writeUserToFile in class User is public.");
                    return;
                }
                if (!writeUserToFile.getReturnType().equals(void.class)) {
                    fail("Ensure that your writeUserToFile method in class User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the writeUserToFile method that is public, takes 1 parameter of type User and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method sendFriendRequest = User.class.getDeclaredMethod("sendFriendRequest", User.class);
                if (sendFriendRequest.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method sendFriendRequest in class User is public.");
                    return;
                }
                if (!sendFriendRequest.getReturnType().equals(void.class)) {
                    fail("Ensure that your sendFriendRequest method in class User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the sendFriendRequest method that is public, takes 1 parameter of type User and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method removeFriendRequest = User.class.getDeclaredMethod("removeFriendRequest", User.class);
                if (removeFriendRequest.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method removeFriendRequest in class User is public.");
                    return;
                }
                if (!removeFriendRequest.getReturnType().equals(void.class)) {
                    fail("Ensure that your removeFriendRequest method in class User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the removeFriendRequest method that is public, takes 1 parameter of type User and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method addReceivedRequest = User.class.getDeclaredMethod("addReceivedRequest", FriendRequest.class);
                if (addReceivedRequest.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method addReceivedRequest in class User is public.");
                    return;
                }
                if (!addReceivedRequest.getReturnType().equals(void.class)) {
                    fail("Ensure that your addReceivedRequest method in class User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the addReceivedRequest method that is public, takes 1 parameter of type FriendRequest and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method removeReceivedRequest = User.class.getDeclaredMethod("removeReceivedRequest", FriendRequest.class);
                if (removeReceivedRequest.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method removeReceivedRequest in class User is public.");
                    return;
                }
                if (!removeReceivedRequest.getReturnType().equals(void.class)) {
                    fail("Ensure that your removeReceivedRequest method in class User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the removeReceivedRequest method that is public, takes 1 parameter of type FriendRequest and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method acceptFriend = User.class.getDeclaredMethod("acceptFriend", User.class);
                if (acceptFriend.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method acceptFriend in class User is public.");
                    return;
                }
                if (!acceptFriend.getReturnType().equals(void.class)) {
                    fail("Ensure that your acceptFriend method in class User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the acceptFriend method that is public, takes 1 parameter of type User and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method denyFriend = User.class.getDeclaredMethod("denyFriend", User.class);
                if (denyFriend.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method denyFriend in class User is public.");
                    return;
                }
                if (!denyFriend.getReturnType().equals(void.class)) {
                    fail("Ensure that your denyFriend method in class User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the denyFriend method that is public, takes 1 parameter of type User and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method removeFriend = User.class.getDeclaredMethod("removeFriend", User.class);
                if (removeFriend.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method removeFriend in class User is public.");
                    return;
                }
                if (!removeFriend.getReturnType().equals(void.class)) {
                    fail("Ensure that your removeFriend method in class User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the removeFriend method that is public, takes 1 parameter of type User and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method createProfile = User.class.getDeclaredMethod("createProfile", String.class, String.class);
                if (createProfile.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method createProfile in class User is public.");
                    return;
                }
                if (!createProfile.getReturnType().equals(void.class)) {
                    fail("Ensure that your createProfile method in class User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the createProfile method that is public, takes 2 parameters of type String and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method createProfile = User.class.getDeclaredMethod("createProfile", String.class, String.class,
                        String.class);
                if (createProfile.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method createProfile in class User is public.");
                    return;
                }
                if (!createProfile.getReturnType().equals(void.class)) {
                    fail("Ensure that your createProfile method in class User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the createProfile method that is public, takes 3 parameters of type String and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method createProfile = User.class.getDeclaredMethod("createProfile", String.class, String.class,
                        String.class, String.class);
                if (createProfile.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method createProfile in class User is public.");
                    return;
                }
                if (!createProfile.getReturnType().equals(void.class)) {
                    fail("Ensure that your createProfile method in class User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the createProfile method that is public, takes 4 parameters of type String and returns void.");
                e.printStackTrace();
                return;
            }
            try {
                Method createProfile = User.class.getDeclaredMethod("createProfile", String.class, String.class,
                        String.class, String.class, int.class);
                if (createProfile.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method createProfile in class User is public.");
                    return;
                }
                if (!createProfile.getReturnType().equals(void.class)) {
                    fail("Ensure that your createProfile method in class User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the createProfile method that is public, takes 4 parameters of type String, " +
                        "1 parameter of type int and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method deleteProfile = User.class.getDeclaredMethod("deleteProfile");
                if (deleteProfile.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method deleteProfile in class User is public.");
                    return;
                }
                if (!deleteProfile.getReturnType().equals(void.class)) {
                    fail("Ensure that your deleteProfile method in class User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the deleteProfile method that is public and returns void.");
                e.printStackTrace();
                return;
            }

        }

        @Test(timeout = 1000)
        public void userClassImplementationTest() {
            try {
                User testUser = new User("fullName", "userName", "password");
                ArrayList<FriendRequest> testEmpty = new ArrayList<FriendRequest>();
                assertEquals("Make sure getFullName() returns the correct field.","fullName",testUser.getFullName());
                assertEquals("Make sure getUserName() returns the correct field.","userName",testUser.getUserName());
                assertEquals("Make sure getPassword() returns the correct field.","password",testUser.getPassword());
                assertEquals("Make sure getProfile() returns the correct field.",null,testUser.getProfile());
                assertEquals("Make sure getFriendList() returns the correct field.",testEmpty,testUser.getFriendList());
                assertEquals("Make sure getSentRequests() returns the correct field.",testEmpty,testUser.getSentRequests());
                assertEquals("Make sure getReceivedRequests() returns the correct field.",testEmpty,testUser.getReceivedRequests());

                testUser.setFullName("fullNameReset");
                testUser.setUserName("userNameReset");
                testUser.setPassword("passwordReset");

                assertEquals("Make sure setFullName() sets the fullName variable.","fullNameReset",testUser.getFullName());
                assertEquals("Make sure setUserName() sets the userName variable.","userNameReset",testUser.getUserName());
                assertEquals("Make sure setPassword() sets the password variable.","passwordReset",testUser.getPassword());

                testUser.writeUserToFile(testUser);

                FileOutputStream fileOutputStream = new FileOutputStream("testFile.txt");
                PrintWriter writer = new PrintWriter(fileOutputStream);
                writer.println(testUser.getUserName() + "," + testUser.getPassword() + "," + testUser.getFullName());
                fileOutputStream.close();
                writer.close();
                BufferedReader reader1 = new BufferedReader(new FileReader("testFile.txt"));
                BufferedReader reader2 = new BufferedReader(new FileReader("userListFile.txt"));
                assertEquals("Ensure file outputs correct information in writeUserToFile()", reader1.readLine(), reader2.readLine());

                User testFriendUser = new User("fullName2", "userName2", "password2");
                testUser.sendFriendRequest(testFriendUser);
                assertTrue("Ensure sent friend request is added to sender's sentRequests list.", testUser.getSentRequests().size() > 0);
                boolean SFRthrown = false;
                try {
                    testUser.sendFriendRequest(testFriendUser);
                } catch (FriendNotFoundException e) {
                    SFRthrown = true;
                }
                assertTrue("Ensure sendFriendRequest() in User throws FriendNotFoundException if already sent.", SFRthrown);

                testUser.removeFriendRequest(testFriendUser);
                assertTrue("Ensure friend request is removed from sender's sentRequests list.", testUser.getSentRequests().size() == 0);
                boolean RFRthrown = false;
                try {
                    testUser.removeFriendRequest(testFriendUser);
                } catch (FriendNotFoundException e) {
                    RFRthrown = true;
                }
                assertTrue("Ensure removeFriendRequest() in User throws FriendNotFoundException if friend not found sent.", RFRthrown);

                FriendRequest testFR = new FriendRequest(testUser, testFriendUser);

                testUser.addReceivedRequest(testFR);
                assertTrue("Ensure friend request is added to receivedRequests list.", testUser.getReceivedRequests().size() > 0);
                boolean ARRthrown = false;
                try {
                    testUser.addReceivedRequest(testFR);
                } catch (FriendNotFoundException e) {
                    ARRthrown = true;
                }
                assertTrue("Ensure addReceivedRequest() in User throws FriendNotFoundException if request already received.", ARRthrown);

                testUser.removeReceivedRequest(testFR);
                assertTrue("Ensure friend request is removed from receivedRequests list.", testUser.getReceivedRequests().size() == 0);
                boolean RRRthrown = false;
                try {
                    testUser.removeReceivedRequest(testFR);
                } catch (FriendNotFoundException e) {
                    RRRthrown = true;
                }
                assertTrue("Ensure removeReceivedRequest() in User throws FriendNotFoundException if request not found.", RRRthrown);

                testFriendUser.sendFriendRequest(testUser);
                testUser.acceptFriend(testFriendUser);
                assertTrue("Ensure friend request is removed from receivedRequests list.", testUser.getFriendList().size() > 0);
                boolean ARthrown = false;
                try {
                    testUser.acceptFriend(testUser);
                } catch (FriendNotFoundException e) {
                    ARthrown = true;
                }
                assertTrue("Ensure acceptFriend() in User throws FriendNotFoundException if request not found.", ARthrown);

                testFriendUser.sendFriendRequest(testUser);
                testUser.denyFriend(testFriendUser);
                assertTrue("Ensure friend request is removed from receivedRequests list when denied.", testUser.getReceivedRequests().size() == 0);
                boolean DRthrown = false;
                try {
                    testUser.denyFriend(testUser);
                } catch (FriendNotFoundException e) {
                    DRthrown = true;
                }
                assertTrue("Ensure denyFriend() in User throws FriendNotFoundException if request not found.", DRthrown);

                testUser.removeFriend(testFriendUser);
                assertTrue("Ensure friend is removed from friendList list when removed.", testUser.getFriendList().size() == 0);
                boolean RFthrown = false;
                try {
                    testUser.removeFriend(testUser);
                } catch (FriendNotFoundException e) {
                    RFthrown = true;
                }
                assertTrue("Ensure removeFriend() in User throws FriendNotFoundException if request not found.", RFthrown);

                testUser.createProfile("bio", "email");
                int counter = 0;
                if (testUser.getProfile().getBio().equals("bio")) {
                    counter++;
                }
                if (testUser.getProfile().getEmail().equals("email")) {
                    counter++;
                }
                if (testUser.getProfile().getOwner().equals(testUser.getUserName())) {
                    counter++;
                }
                if (testUser.getProfile().getFriendList().equals(testUser.getFriendList())) {
                    counter++;
                }
                assertTrue("Ensure basic profile constructor passed all fields to profile.", counter == 4);
                testUser.deleteProfile();
                testUser.createProfile("bio", "email", "location");
                if (testUser.getProfile().getLocation().equals("location")) {
                    counter++;
                }
                assertTrue("Ensure advanced profile constructor passes location to profile.", counter == 5);
                testUser.deleteProfile();
                testUser.createProfile("bio", "email", "location", "interests");
                if (testUser.getProfile().getInterests().equals("interests")) {
                    counter++;
                }
                assertTrue("Ensure advanced profile constructor passes location to interests.", counter == 6);
                testUser.deleteProfile();
                testUser.createProfile("bio", "email", "location", "interests", 999);
                if (testUser.getProfile().getPhoneNum() == 999) {
                    counter++;
                }
                assertTrue("Ensure advanced profile constructor passes phoneNum to profile.", counter == 7);

                testUser.deleteProfile();
                assertEquals("Ensure deleteProfile() sets the User's profile to null.", testUser.getProfile(), null);

            } catch (Exception e) {
                fail("Error in creating User Class: Some fields or methods not functional or present.");
                return;
            }
        }

        @Test(timeout = 1_000)
        public void profileClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Profile.class;
            className = "Profile";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends Object.", Object.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void profileClassSetupTest() {
            Field[] fields = Profile.class.getDeclaredFields();
            if (fields.length < 7) {
                fail("Profile class requires seven fields.");
                return;
            }

            try {
                Field bio = Profile.class.getDeclaredField("bio");
                if (bio.getType() != String.class) {
                    fail("Ensure that bio in class Profile is of type String.");
                    return;
                }
                if (bio.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that bio in class Profile has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field bio in class User " +
                        "that is of type String and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Field location = Profile.class.getDeclaredField("location");
                if (location.getType() != String.class) {
                    fail("Ensure that location in class Profile is of type String.");
                    return;
                }
                if (location.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that location in class Profile has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field location in class Profile " +
                        "that is of type String and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Field interests = Profile.class.getDeclaredField("interests");
                if (interests.getType() != String.class) {
                    fail("Ensure that interests in class Profile is of type String.");
                    return;
                }
                if (interests.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that interests in class Profile has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field interests in class Profile " +
                        "that is of type String and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Field phoneNum = Profile.class.getDeclaredField("phoneNum");
                if (phoneNum.getType() != int.class) {
                    fail("Ensure that phoneNum in class Profile is of type int.");
                    return;
                }
                if (phoneNum.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that phoneNum in class Profile has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field phoneNum in class Profile " +
                        "that is of type int and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Field email = Profile.class.getDeclaredField("email");
                if (email.getType() != String.class) {
                    fail("Ensure that email in class Profile is of type String.");
                    return;
                }
                if (email.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that email in class Profile has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field email in class Profile " +
                        "that is of type String and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Field owner = Profile.class.getDeclaredField("owner");
                if (owner.getType() != String.class) {
                    fail("Ensure that owner in class Profile is of type String.");
                    return;
                }
                if (owner.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that owner in class Profile has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field owner in class Profile " +
                        "that is of type String and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Field friendList = Profile.class.getDeclaredField("friendList");
                if (friendList.getType() != ArrayList.class) {
                    fail("Ensure that friendList in class Profile is of type ArrayList.");
                    return;
                }
                if (friendList.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that friendList in class Profile has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field friendList in class Profile " +
                        "that is of type ArrayList and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<Profile> constructor = Profile.class.getDeclaredConstructor(String.class, String.class,
                        String.class, ArrayList.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class Profile is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 4 parameters and is public in class Profile.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<Profile> constructor = Profile.class.getDeclaredConstructor(String.class, String.class,
                        String.class, ArrayList.class, String.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class Profile is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 5 parameters and is public in class Profile.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<Profile> constructor = Profile.class.getDeclaredConstructor(String.class, String.class,
                        String.class, ArrayList.class, String.class, String.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class Profile is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 6 parameters and is public in class Profile.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<Profile> constructor = Profile.class.getDeclaredConstructor(String.class, String.class,
                        String.class, ArrayList.class, String.class, String.class, int.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class Profile is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 7 parameters and is public in class Profile.");
                e.printStackTrace();
                return;
            }

            try {
                Method getBio = Profile.class.getDeclaredMethod("getBio");
                if (getBio.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getBio in class Profile is public.");
                    return;
                }
                if (!getBio.getReturnType().equals(String.class)) {
                    fail("Ensure that your getBio method in class Profile returns a String.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getBio method that is public and returns a String.");
                e.printStackTrace();
                return;
            }

            try {
                Method getBio = Profile.class.getDeclaredMethod("getBio");
                if (getBio.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getBio in class Profile is public.");
                    return;
                }
                if (!getBio.getReturnType().equals(String.class)) {
                    fail("Ensure that your getBio method in class Profile returns a String.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getBio method that is public and returns a String.");
                e.printStackTrace();
                return;
            }

            try {
                Method getLocation = Profile.class.getDeclaredMethod("getLocation");
                if (getLocation.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getLocation in class Profile is public.");
                    return;
                }
                if (!getLocation.getReturnType().equals(String.class)) {
                    fail("Ensure that your getLocation method in class Profile returns a String.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getLocation method that is public and returns a String.");
                e.printStackTrace();
                return;
            }

            try {
                Method getInterests = Profile.class.getDeclaredMethod("getInterests");
                if (getInterests.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getInterests in class Profile is public.");
                    return;
                }
                if (!getInterests.getReturnType().equals(String.class)) {
                    fail("Ensure that your getInterests method in class Profile returns a String.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getInterests method that is public and returns a String.");
                e.printStackTrace();
                return;
            }

            try {
                Method getPhoneNum = Profile.class.getDeclaredMethod("getPhoneNum");
                if (getPhoneNum.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getPhoneNum in class Profile is public.");
                    return;
                }
                if (!getPhoneNum.getReturnType().equals(int.class)) {
                    fail("Ensure that your getPhoneNum method in class Profile returns an int.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getPhoneNum method that is public and returns a String.");
                e.printStackTrace();
                return;
            }

            try {
                Method getEmail = Profile.class.getDeclaredMethod("getEmail");
                if (getEmail.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getEmail in class Profile is public.");
                    return;
                }
                if (!getEmail.getReturnType().equals(String.class)) {
                    fail("Ensure that your getEmail method in class Profile returns a String.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getEmail method that is public and returns a String.");
                e.printStackTrace();
                return;
            }

            try {
                Method getOwner = Profile.class.getDeclaredMethod("getOwner");
                if (getOwner.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getOwner in class Profile is public.");
                    return;
                }
                if (!getOwner.getReturnType().equals(String.class)) {
                    fail("Ensure that your getOwner method in class Profile returns a String.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getOwner method that is public and returns a String.");
                e.printStackTrace();
                return;
            }

            try {
                Method getFriendList = Profile.class.getDeclaredMethod("getFriendList");
                if (getFriendList.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getFriendList in class Profile is public.");
                    return;
                }
                if (!getFriendList.getReturnType().equals(ArrayList.class)) {
                    fail("Ensure that your getFriendList method in class Profile returns an ArrayList.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getFriendList method that is public and returns an ArrayList.");
                e.printStackTrace();
                return;
            }

            try {
                Method setBio = Profile.class.getDeclaredMethod("setBio", String.class);
                if (setBio.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method setBio in class Profile is public.");
                    return;
                }
                if (!setBio.getReturnType().equals(void.class)) {
                    fail("Ensure that your setBio method in class Profile returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the setBio method that is public and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method setLocation = Profile.class.getDeclaredMethod("setLocation", String.class);
                if (setLocation.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method setLocation in class Profile is public.");
                    return;
                }
                if (!setLocation.getReturnType().equals(void.class)) {
                    fail("Ensure that your setLocation method in class Profile returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the setLocation method that is public and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method setInterests = Profile.class.getDeclaredMethod("setInterests", String.class);
                if (setInterests.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method setInterests in class Profile is public.");
                    return;
                }
                if (!setInterests.getReturnType().equals(void.class)) {
                    fail("Ensure that your setInterests method in class Profile returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the setInterests method that is public and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method setPhoneNum = Profile.class.getDeclaredMethod("setPhoneNum", int.class);
                if (setPhoneNum.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method setPhoneNum in class Profile is public.");
                    return;
                }
                if (!setPhoneNum.getReturnType().equals(void.class)) {
                    fail("Ensure that your setPhoneNum method in class Profile returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the setPhoneNum method that is public and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method setEmail = Profile.class.getDeclaredMethod("setEmail", String.class);
                if (setEmail.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method setEmail in class Profile is public.");
                    return;
                }
                if (!setEmail.getReturnType().equals(void.class)) {
                    fail("Ensure that your setEmail method in class Profile returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the setEmail method that is public and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method setFriendList = Profile.class.getDeclaredMethod("setFriendList", ArrayList.class);
                if (setFriendList.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method setFriendList in class Profile is public.");
                    return;
                }
                if (!setFriendList.getReturnType().equals(void.class)) {
                    fail("Ensure that your setFriendList method in class Profile returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the setFriendList method that is public and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method profileString = Profile.class.getDeclaredMethod("profileString");
                if (profileString.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method profileString in class Profile is public.");
                    return;
                }
                if (!profileString.getReturnType().equals(String.class)) {
                    fail("Ensure that your profileString method in class Profile returns a String.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the profileString method that is public and returns a String.");
                e.printStackTrace();
                return;
            }

        }

        @Test(timeout = 1000)
        public void profileClassImplementationTest() {
            try {
                Profile testProfile = new Profile("owner", "bio", "email", new ArrayList<User>(), "location", "interests", 999);
                ArrayList<User> testEmpty = new ArrayList<User>();
                assertEquals("Make sure getBio() returns the correct field.","bio",testProfile.getBio());
                assertEquals("Make sure getLocation() returns the correct field.","location",testProfile.getLocation());
                assertEquals("Make sure getInterests() returns the correct field.","interests",testProfile.getInterests());
                assertEquals("Make sure getPhoneNum() returns the correct field.",999,testProfile.getPhoneNum());
                assertEquals("Make sure getEmail() returns the correct field.","email",testProfile.getEmail());
                assertEquals("Make sure getOwner() returns the correct field.","owner",testProfile.getOwner());
                assertEquals("Make sure getFriendList() returns the correct field.",testEmpty,testProfile.getFriendList());

                testProfile.setBio("bioReset");
                testProfile.setLocation("locationReset");
                testProfile.setInterests("interestsReset");
                testProfile.setPhoneNum(888);
                testProfile.setEmail("emailReset");
                testEmpty.add(new User("test1", "test2", "test3"));
                testProfile.setFriendList(testEmpty);

                assertEquals("Make sure setBio() sets the bio variable in Profile.", "bioReset", testProfile.getBio());
                assertEquals("Make sure setLocation() sets the location variable in Profile.", "locationReset", testProfile.getLocation());
                assertEquals("Make sure setInterests() sets the interests variable in Profile.", "interestsReset", testProfile.getInterests());
                assertEquals("Make sure setPhoneNum() sets the phoneNum variable in Profile.", 888, testProfile.getPhoneNum());
                assertEquals("Make sure setEmail() sets the email variable in Profile.", "emailReset", testProfile.getEmail());
                assertEquals("Make sure setFriendList() sets the friendList variable in Profile.", testEmpty, testProfile.getFriendList());

                assertEquals("Owner: owner Bio: bioReset Email: emailReset", testProfile.profileString());

            } catch (Exception e) {
                fail("Error in creating Profile Class: Some fields or methods not functional or present.");
                return;
            }
        }

        @Test(timeout = 1_000)
        public void friendRequestClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = FriendRequest.class;
            className = "FriendRequest";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends Object.", Object.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void friendRequestClassSetupTest() {
            Field[] fields = FriendRequest.class.getDeclaredFields();
            if (fields.length < 2) {
                fail("FriendRequest class requires two fields.");
                return;
            }

            try {
                Field sender = FriendRequest.class.getDeclaredField("sender");
                if (sender.getType() != User.class) {
                    fail("Ensure that sender in class FriendRequest is of type User.");
                    return;
                }
                if (sender.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that sender in class FriendRequest has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field sender in class FriendRequest " +
                        "that is of type User and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Field recipient = FriendRequest.class.getDeclaredField("sender");
                if (recipient.getType() != User.class) {
                    fail("Ensure that recipient in class FriendRequest is of type User.");
                    return;
                }
                if (recipient.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that recipient in class FriendRequest has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field recipient in class FriendRequest " +
                        "that is of type User and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<FriendRequest> constructor = FriendRequest.class.getDeclaredConstructor(User.class, User.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class FriendRequest is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 2 parameters and is public in class FriendRequest.");
                e.printStackTrace();
                return;
            }

            try {
                Method getSender = FriendRequest.class.getDeclaredMethod("getSender");
                if (getSender.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getSender in class FriendRequest is public.");
                    return;
                }
                if (!getSender.getReturnType().equals(User.class)) {
                    fail("Ensure that your getSender method in class FriendRequest returns a User.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getSender method that is public and returns a User.");
                e.printStackTrace();
                return;
            }

            try {
                Method getRecipient = FriendRequest.class.getDeclaredMethod("getRecipient");
                if (getRecipient.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getRecipient in class FriendRequest is public.");
                    return;
                }
                if (!getRecipient.getReturnType().equals(User.class)) {
                    fail("Ensure that your getRecipient method in class FriendRequest returns a User.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getRecipient method that is public and returns a User.");
                e.printStackTrace();
                return;
            }

        }

        @Test(timeout = 1000)
        public void friendRequestClassImplementationTest() {
            try {
                FriendRequest testFriendRequest = new FriendRequest(new User("user1", "user1", "user1"), new User("user2", "user2", "user2"));
                ArrayList<User> testEmpty = new ArrayList<User>();
                assertEquals("Make sure getSender() returns the correct field.","user1",testFriendRequest.getSender().getUserName());
                assertEquals("Make sure getRecipient() returns the correct field.","user2",testFriendRequest.getRecipient().getUserName());


            } catch (Exception e) {
                fail("Error in creating FriendRequest Class: Some fields or methods not functional or present.");
                return;
            }
        }

        @Test(timeout = 1_000)
        public void friendNotFoundExceptionClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = FriendNotFoundException.class;
            className = "FriendNotFoundException";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends Exception.", Exception.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void friendNotFoundExceptionClassSetupTest() {
            try {
                Constructor<FriendNotFoundException> constructor = FriendNotFoundException.class.getDeclaredConstructor();
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class FriendNotFoundException is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes no parameters and is public in class FriendNotFoundException.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<FriendNotFoundException> constructor = FriendNotFoundException.class.getDeclaredConstructor(String.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class FriendNotFoundException is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes a message parameter and is public in class FriendNotFoundException.");
                e.printStackTrace();
                return;
            }
        }

        @Test(timeout = 1_000)
        public void clientClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Client.class;
            className = "Client";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends JComponent.", JComponent.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements 2 interfaces.", 2, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void clientClassSetupTest() {
            Field[] fields = Client.class.getDeclaredFields();
            if (fields.length < 15) {
                fail("Client class requires fifteen fields.");
                return;
            }

            try {
                Field portNum = Client.class.getDeclaredField("portNum");
                if (portNum.getType() != int.class) {
                    fail("Ensure that portNum in class Client is of type int.");
                    return;
                }
                if (portNum.getModifiers() != (Modifier.PRIVATE + Modifier.STATIC)) {
                    fail("Ensure that portNum in class Client has modifiers private and static.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field portNum in class Client " +
                        "that is of type int and is private and static.");
                e.printStackTrace();
                return;
            }

            try {
                Field writer = Client.class.getDeclaredField("writer");
                if (writer.getType() != PrintWriter.class) {
                    fail("Ensure that writer in class Client is of type PrintWriter.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field writer in class Client.");
                e.printStackTrace();
                return;
            }

            try {
                Field reader = Client.class.getDeclaredField("reader");
                if (reader.getType() != BufferedReader.class) {
                    fail("Ensure that reader in class Client is of type BufferedReader.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field reader in class Client.");
                e.printStackTrace();
                return;
            }

            try {
                Field currentUsername = Client.class.getDeclaredField("currentUsername");
                if (currentUsername.getType() != String.class) {
                    fail("Ensure that currentUsername in class Client is of type String.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field currentUsername in class Client.");
                e.printStackTrace();
                return;
            }

            try {
                Field temp = Client.class.getDeclaredField("temp");
                if (temp.getType() != String.class) {
                    fail("Ensure that temp in class Client is of type String.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field temp in class Client.");
                e.printStackTrace();
                return;
            }

            try {
                Field homeFrame = Client.class.getDeclaredField("homeFrame");
                if (homeFrame.getType() != gui.HomeFrame.class) {
                    fail("Ensure that homeFrame in class Client is of type gui.HomeFrame.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field homeFrame in class Client.");
                e.printStackTrace();
                return;
            }

            try {
                Field signUpFrame = Client.class.getDeclaredField("signUpFrame");
                if (signUpFrame.getType() != gui.SignUpFrame.class) {
                    fail("Ensure that signUpFrame in class Client is of type gui.SignUpFrame.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field signUpFrame in class Client.");
                e.printStackTrace();
                return;
            }

            try {
                Field friendsListFrame = Client.class.getDeclaredField("friendsListFrame");
                if (friendsListFrame.getType() != gui.FriendsListFrame.class) {
                    fail("Ensure that friendsListFrame in class Client is of type gui.FriendsListFrame.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field friendsListFrame in class Client.");
                e.printStackTrace();
                return;
            }

            try {
                Field viewRequestsFrame = Client.class.getDeclaredField("viewRequestsFrame");
                if (viewRequestsFrame.getType() != gui.ViewRequestsFrame.class) {
                    fail("Ensure that viewRequestsFrame in class Client is of type gui.ViewRequestsFrame.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field viewRequestsFrame in class Client.");
                e.printStackTrace();
                return;
            }

            try {
                Field incomingFriendRequestsFrame = Client.class.getDeclaredField("incomingFriendRequestsFrame");
                if (incomingFriendRequestsFrame.getType() != gui.IncomingFriendRequestsFrame.class) {
                    fail("Ensure that incomingFriendRequestsFrame in class Client is of type gui.IncomingFriendRequestsFrame.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field incomingFriendRequestsFrame in class Client.");
                e.printStackTrace();
                return;
            }

            try {
                Field outgoingFriendRequestsFrame = Client.class.getDeclaredField("outgoingFriendRequestsFrame");
                if (outgoingFriendRequestsFrame.getType() != gui.OutgoingFriendRequestsFrame.class) {
                    fail("Ensure that outgoingFriendRequestsFrame in class Client is of type gui.OutgoingFriendRequestsFrame.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field outgoingFriendRequestsFrame in class Client.");
                e.printStackTrace();
                return;
            }

            try {
                Field sendFriendRequestFrame = Client.class.getDeclaredField("sendFriendRequestFrame");
                if (sendFriendRequestFrame.getType() != gui.SendFriendRequestFrame.class) {
                    fail("Ensure that sendFriendRequestFrame in class Client is of type gui.SendFriendRequestFrame.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field sendFriendRequestFrame in class Client.");
                e.printStackTrace();
                return;
            }

            try {
                Field profileFrame = Client.class.getDeclaredField("profileFrame");
                if (profileFrame.getType() != gui.ProfileFrame.class) {
                    fail("Ensure that profileFrame in class Client is of type gui.ProfileFrame.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field profileFrame in class Client.");
                e.printStackTrace();
                return;
            }

            try {
                Field editProfileFrame = Client.class.getDeclaredField("editProfileFrame");
                if (editProfileFrame.getType() != gui.EditProfileFrame.class) {
                    fail("Ensure that editProfileFrame in class Client is of type gui.EditProfileFrame.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field editProfileFrame in class Client.");
                e.printStackTrace();
                return;
            }

            try {
                Field editProfileFrame = Client.class.getDeclaredField("editProfileFrame");
                if (editProfileFrame.getType() != gui.EditProfileFrame.class) {
                    fail("Ensure that editProfileFrame in class Client is of type gui.EditProfileFrame.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field editProfileFrame in class Client.");
                e.printStackTrace();
                return;
            }

            try {
                Field profileFrameRestricted = Client.class.getDeclaredField("profileFrameRestricted");
                if (profileFrameRestricted.getType() != gui.ProfileFrameRestricted.class) {
                    fail("Ensure that profileFrameRestricted in class Client is of type gui.ProfileFrameRestricted.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field profileFrameRestricted in class Client.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<Client> constructor = Client.class.getDeclaredConstructor(int.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class Client is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 1 parameter and is public in class Client.");
                e.printStackTrace();
                return;
            }

            try {
                Method main = Client.class.getDeclaredMethod("main");
                if (main.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method main in class Client is public and static.");
                    return;
                }
                if (!main.getReturnType().equals(void.class)) {
                    fail("Ensure that your getSender method in class Client returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the main method that is public and static  and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method sendMessage = Client.class.getDeclaredMethod("sendMessage", String.class);
                if (sendMessage.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method sendMessage in class Client is public.");
                    return;
                }
                if (!sendMessage.getReturnType().equals(void.class)) {
                    fail("Ensure that your sendMessage method in class Client returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the sendMessage method that is public and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method receiveMessage = Client.class.getDeclaredMethod("receiveMessage");
                if (receiveMessage.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method receiveMessage in class Client is public.");
                    return;
                }
                if (!receiveMessage.getReturnType().equals(String.class)) {
                    fail("Ensure that your receiveMessage method in class Client returns a String.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the receiveMessage method that is public and returns a String.");
                e.printStackTrace();
                return;
            }

            try {
                Method actionPerformed = Client.class.getDeclaredMethod("actionPerformed", ActionEvent.class);
                if (actionPerformed.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method actionPerformed in class Client is public.");
                    return;
                }
                if (!actionPerformed.getReturnType().equals(void.class)) {
                    fail("Ensure that your actionPerformed method in class Client returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the actionPerformed method that is public and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method showHomeFrame = Client.class.getDeclaredMethod("showHomeFrame");
                if (showHomeFrame.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your method showHomeFrame in class Client is private.");
                    return;
                }
                if (!showHomeFrame.getReturnType().equals(void.class)) {
                    fail("Ensure that your showHomeFrame method in class Client returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the showHomeFrame method that is private and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method showSignUpFrame = Client.class.getDeclaredMethod("showSignUpFrame");
                if (showSignUpFrame.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your method showSignUpFrame in class Client is private.");
                    return;
                }
                if (!showSignUpFrame.getReturnType().equals(void.class)) {
                    fail("Ensure that your showSignUpFrame method in class Client returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the showSignUpFrame method that is private and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method showProfileFrame = Client.class.getDeclaredMethod("showProfileFrame", String.class, boolean.class);
                if (showProfileFrame.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your method showProfileFrame in class Client is private.");
                    return;
                }
                if (!showProfileFrame.getReturnType().equals(void.class)) {
                    fail("Ensure that your showProfileFrame method in class Client returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the showProfileFrame method that is private and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method showEditProfileFrame = Client.class.getDeclaredMethod("showEditProfileFrame", String.class);
                if (showEditProfileFrame.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your method showEditProfileFrame in class Client is private.");
                    return;
                }
                if (!showEditProfileFrame.getReturnType().equals(void.class)) {
                    fail("Ensure that your showEditProfileFrame method in class Client returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the showEditProfileFrame method that is private and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method showFriendsListFrame = Client.class.getDeclaredMethod("showFriendsListFrame", String.class);
                if (showFriendsListFrame.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your method showFriendsListFrame in class Client is private.");
                    return;
                }
                if (!showFriendsListFrame.getReturnType().equals(void.class)) {
                    fail("Ensure that your showFriendsListFrame method in class Client returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the showFriendsListFrame method that is private and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method showIncomingFriendRequestFrame = Client.class.getDeclaredMethod("showIncomingFriendRequestFrame", String.class);
                if (showIncomingFriendRequestFrame.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your method showIncomingFriendRequestFrame in class Client is private.");
                    return;
                }
                if (!showIncomingFriendRequestFrame.getReturnType().equals(void.class)) {
                    fail("Ensure that your showIncomingFriendRequestFrame method in class Client returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the showIncomingFriendRequestFrame method that is private and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method showOutgoingFriendRequestFrame = Client.class.getDeclaredMethod("showOutgoingFriendRequestFrame", String.class);
                if (showOutgoingFriendRequestFrame.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your method showOutgoingFriendRequestFrame in class Client is private.");
                    return;
                }
                if (!showOutgoingFriendRequestFrame.getReturnType().equals(void.class)) {
                    fail("Ensure that your showOutgoingFriendRequestFrame method in class Client returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the showOutgoingFriendRequestFrame method that is private and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method showSendFriendRequestFrame = Client.class.getDeclaredMethod("showSendFriendRequestFrame", String.class);
                if (showSendFriendRequestFrame.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your method showSendFriendRequestFrame in class Client is private.");
                    return;
                }
                if (!showSendFriendRequestFrame.getReturnType().equals(void.class)) {
                    fail("Ensure that your showSendFriendRequestFrame method in class Client returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the showSendFriendRequestFrame method that is private and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method showViewRequestsFrame = Client.class.getDeclaredMethod("showViewRequestsFrame");
                if (showViewRequestsFrame.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your method showViewRequestsFrame in class Client is private.");
                    return;
                }
                if (!showViewRequestsFrame.getReturnType().equals(void.class)) {
                    fail("Ensure that your showViewRequestsFrame method in class Client returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the showViewRequestsFrame method that is private and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method run = Client.class.getDeclaredMethod("run");
                if (run.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method run in class Client is public.");
                    return;
                }
                if (!run.getReturnType().equals(void.class)) {
                    fail("Ensure that your run method in class Client returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the run method that is public and returns void.");
                e.printStackTrace();
                return;
            }

        }

        @Test(timeout = 1000)
        public void clientClassImplementationTest() {
            try {
                FriendRequest testFriendRequest = new FriendRequest(new User("user1", "user1", "user1"), new User("user2", "user2", "user2"));
                ArrayList<User> testEmpty = new ArrayList<User>();
                assertEquals("Make sure getSender() returns the correct field.","user1",testFriendRequest.getSender().getUserName());
                assertEquals("Make sure getRecipient() returns the correct field.","user2",testFriendRequest.getRecipient().getUserName());


            } catch (Exception e) {
                fail("Error in creating Client Class: Some fields or methods not functional or present.");
                return;
            }
        }

    }
}