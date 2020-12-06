package tests;

import main.*;
import client.*;
import gui.*;
import assets.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.Socket;
import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Main testing class for entire project, implements JUnit tests to test
 * Class declarations, Field and Method declarations, access modifiers, and
 * return types/parameters when applicable.
 *
 * <p>Purdue University -- CS18000 -- Fall 2020 -- Project 05</p>
 *
 * @author Elijah Colwill
 * @version December 06, 2020
 */
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
     * @author Elijah Colwill
     * @version December 06, 2020
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
            if (fields.length < 17) {
                fail("Client class requires seventeen fields.");
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
                Field errorFrame = Client.class.getDeclaredField("errorFrame");
                if (errorFrame.getType() != gui.ErrorFrame.class) {
                    fail("Ensure that errorFrame in class Client is of type gui.ErrorFrame.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field errorFrame in class Client.");
                e.printStackTrace();
                return;
            }

            try {
                Field successFrame = Client.class.getDeclaredField("successFrame");
                if (successFrame.getType() != gui.SuccessFrame.class) {
                    fail("Ensure that successFrame in class Client is of type gui.SuccessFrame.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field successFrame in class Client.");
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
                Method main = Client.class.getDeclaredMethod("main", String[].class);
                if (main.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method main in class Client is public and static.");
                    return;
                }
                if (!main.getReturnType().equals(void.class)) {
                    fail("Ensure that your getSender method in class Client returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the main method that is public and static and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method sendMessage = Client.class.getDeclaredMethod("sendMessage", String.class);
                if (sendMessage.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your method sendMessage in class Client is private.");
                    return;
                }
                if (!sendMessage.getReturnType().equals(void.class)) {
                    fail("Ensure that your sendMessage method in class Client returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the sendMessage method that is private and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method receiveMessage = Client.class.getDeclaredMethod("receiveMessage");
                if (receiveMessage.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that your method receiveMessage in class Client is private.");
                    return;
                }
                if (!receiveMessage.getReturnType().equals(String.class)) {
                    fail("Ensure that your receiveMessage method in class Client returns a String.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the receiveMessage method that is private and returns a String.");
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

        @Test(timeout = 1_000)
        public void editProfileFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = EditProfileFrame.class;
            className = "EditProfileFrame";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends JFrame.", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void editProfileFrameClassSetupTest() {
            Field[] fields = EditProfileFrame.class.getDeclaredFields();
            if (fields.length < 33) {
                fail("EditProfileFrame class requires thirty three fields.");
                return;
            }

            try {
                Field frameContainer = EditProfileFrame.class.getDeclaredField("frameContainer");
                if (frameContainer.getType() != Container.class) {
                    fail("Ensure that frameContainer in class EditProfileFrame is of type Container.");
                    return;
                }
                if (frameContainer.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that frameContainer in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field frameContainer in class EditProfileFrame " +
                        "that is of type Container and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerPanel = EditProfileFrame.class.getDeclaredField("headerPanel");
                if (headerPanel.getType() != JPanel.class) {
                    fail("Ensure that headerPanel in class EditProfileFrame is of type JPanel.");
                    return;
                }
                if (headerPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerPanel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerPanel in class EditProfileFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field contentPanel = EditProfileFrame.class.getDeclaredField("contentPanel");
                if (contentPanel.getType() != JPanel.class) {
                    fail("Ensure that contentPanel in class EditProfileFrame is of type JPanel.");
                    return;
                }
                if (contentPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that contentPanel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field contentPanel in class EditProfileFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field editProfilePanel = EditProfileFrame.class.getDeclaredField("editProfilePanel");
                if (editProfilePanel.getType() != JPanel.class) {
                    fail("Ensure that editProfilePanel in class EditProfileFrame is of type JPanel.");
                    return;
                }
                if (editProfilePanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that editProfilePanel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field editProfilePanel in class EditProfilePanel " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field namePanel = EditProfileFrame.class.getDeclaredField("namePanel");
                if (namePanel.getType() != JPanel.class) {
                    fail("Ensure that namePanel in class EditProfileFrame is of type JPanel.");
                    return;
                }
                if (namePanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that namePanel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field namePanel in class editProfilePanel " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field usernamePanel = EditProfileFrame.class.getDeclaredField("usernamePanel");
                if (usernamePanel.getType() != JPanel.class) {
                    fail("Ensure that usernamePanel in class EditProfileFrame is of type JPanel.");
                    return;
                }
                if (usernamePanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that usernamePanel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field usernamePanel in class editProfilePanel " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field emailPanel = EditProfileFrame.class.getDeclaredField("emailPanel");
                if (emailPanel.getType() != JPanel.class) {
                    fail("Ensure that emailPanel in class EditProfileFrame is of type JPanel.");
                    return;
                }
                if (emailPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that emailPanel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field usernamePanel in class editProfilePanel " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field passwordPanel = EditProfileFrame.class.getDeclaredField("passwordPanel");
                if (passwordPanel.getType() != JPanel.class) {
                    fail("Ensure that passwordPanel in class EditProfileFrame is of type JPanel.");
                    return;
                }
                if (passwordPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that passwordPanel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field passwordPanel in class editProfilePanel " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field locationPanel = EditProfileFrame.class.getDeclaredField("locationPanel");
                if (locationPanel.getType() != JPanel.class) {
                    fail("Ensure that locationPanel in class EditProfileFrame is of type JPanel.");
                    return;
                }
                if (locationPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that locationPanel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field locationPanel in class editProfilePanel " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field bioPanel = EditProfileFrame.class.getDeclaredField("bioPanel");
                if (bioPanel.getType() != JPanel.class) {
                    fail("Ensure that bioPanel in class EditProfileFrame is of type JPanel.");
                    return;
                }
                if (bioPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that bioPanel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field bioPanel in class editProfilePanel " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field interestsPanel = EditProfileFrame.class.getDeclaredField("interestsPanel");
                if (interestsPanel.getType() != JPanel.class) {
                    fail("Ensure that interestsPanel in class EditProfileFrame is of type JPanel.");
                    return;
                }
                if (interestsPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that interestsPanel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field interestsPanel in class editProfilePanel " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field navigationPanel = EditProfileFrame.class.getDeclaredField("navigationPanel");
                if (navigationPanel.getType() != JPanel.class) {
                    fail("Ensure that navigationPanel in class EditProfileFrame is of type JPanel.");
                    return;
                }
                if (navigationPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that navigationPanel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field navigationPanel in class editProfilePanel " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field logoLabel = EditProfileFrame.class.getDeclaredField("logoLabel");
                if (logoLabel.getType() != JLabel.class) {
                    fail("Ensure that logoLabel in class EditProfileFrame is of type JLabel.");
                    return;
                }
                if (logoLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that logoLabel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field logoLabel in class editProfilePanel " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerLabel = EditProfileFrame.class.getDeclaredField("headerLabel");
                if (headerLabel.getType() != JLabel.class) {
                    fail("Ensure that headerLabel in class EditProfileFrame is of type JLabel.");
                    return;
                }
                if (headerLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerLabel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerLabel in class editProfilePanel " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field editProfileLabel = EditProfileFrame.class.getDeclaredField("editProfileLabel");
                if (editProfileLabel.getType() != JLabel.class) {
                    fail("Ensure that editProfileLabel in class EditProfileFrame is of type JLabel.");
                    return;
                }
                if (editProfileLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that editProfileLabel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field editProfileLabel in class editProfilePanel " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field editProfileDescriptionLabel = EditProfileFrame.class.getDeclaredField("editProfileDescriptionLabel");
                if (editProfileDescriptionLabel.getType() != JLabel.class) {
                    fail("Ensure that editProfileDescriptionLabel in class EditProfileFrame is of type JLabel.");
                    return;
                }
                if (editProfileDescriptionLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that editProfileDescriptionLabel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field editProfileDescriptionLabel in class editProfilePanel " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field nameLabel = EditProfileFrame.class.getDeclaredField("nameLabel");
                if (nameLabel.getType() != JLabel.class) {
                    fail("Ensure that nameLabel in class EditProfileFrame is of type JLabel.");
                    return;
                }
                if (nameLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that nameLabel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field nameLabel in class editProfilePanel " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field usernameLabel = EditProfileFrame.class.getDeclaredField("usernameLabel");
                if (usernameLabel.getType() != JLabel.class) {
                    fail("Ensure that usernameLabel in class EditProfileFrame is of type JLabel.");
                    return;
                }
                if (usernameLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that usernameLabel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field usernameLabel in class editProfilePanel " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field emailLabel = EditProfileFrame.class.getDeclaredField("emailLabel");
                if (emailLabel.getType() != JLabel.class) {
                    fail("Ensure that emailLabel in class EditProfileFrame is of type JLabel.");
                    return;
                }
                if (emailLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that emailLabel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field emailLabel in class editProfilePanel " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field passwordLabel = EditProfileFrame.class.getDeclaredField("passwordLabel");
                if (passwordLabel.getType() != JLabel.class) {
                    fail("Ensure that passwordLabel in class EditProfileFrame is of type JLabel.");
                    return;
                }
                if (passwordLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that passwordLabel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field passwordLabel in class editProfilePanel " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field locationLabel = EditProfileFrame.class.getDeclaredField("locationLabel");
                if (locationLabel.getType() != JLabel.class) {
                    fail("Ensure that locationLabel in class EditProfileFrame is of type JLabel.");
                    return;
                }
                if (locationLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that locationLabel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field locationLabel in class editProfilePanel " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field bioLabel = EditProfileFrame.class.getDeclaredField("bioLabel");
                if (bioLabel.getType() != JLabel.class) {
                    fail("Ensure that bioLabel in class EditProfileFrame is of type JLabel.");
                    return;
                }
                if (bioLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that bioLabel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field bioLabel in class editProfilePanel " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field interestsLabel = EditProfileFrame.class.getDeclaredField("interestsLabel");
                if (interestsLabel.getType() != JLabel.class) {
                    fail("Ensure that interestsLabel in class EditProfileFrame is of type JLabel.");
                    return;
                }
                if (interestsLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that interestsLabel in class EditProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field interestsLabel in class editProfilePanel " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field updateProfileButton = EditProfileFrame.class.getDeclaredField("updateProfileButton");
                if (updateProfileButton.getType() != JButton.class) {
                    fail("Ensure that updateProfileButton in class EditProfileFrame is of type JButton.");
                    return;
                }
                if (updateProfileButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that updateProfileButton in class EditProfileFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field updateProfileButton in class editProfilePanel " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field deleteAccountButton = EditProfileFrame.class.getDeclaredField("deleteAccountButton");
                if (deleteAccountButton.getType() != JButton.class) {
                    fail("Ensure that deleteAccountButton in class EditProfileFrame is of type JButton.");
                    return;
                }
                if (deleteAccountButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that deleteAccountButton in class EditProfileFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field deleteAccountButton in class editProfilePanel " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field backButton = EditProfileFrame.class.getDeclaredField("backButton");
                if (backButton.getType() != JButton.class) {
                    fail("Ensure that backButton in class EditProfileFrame is of type JButton.");
                    return;
                }
                if (backButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that backButton in class EditProfileFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field backButton in class editProfilePanel " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field nameField = EditProfileFrame.class.getDeclaredField("nameField");
                if (nameField.getType() != JTextField.class) {
                    fail("Ensure that nameField in class EditProfileFrame is of type JTextField.");
                    return;
                }
                if (nameField.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that nameField in class EditProfileFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field nameField in class editProfilePanel " +
                        "that is of type JTextField and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field usernameField = EditProfileFrame.class.getDeclaredField("usernameField");
                if (usernameField.getType() != JTextField.class) {
                    fail("Ensure that usernameField in class EditProfileFrame is of type JTextField.");
                    return;
                }
                if (usernameField.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that usernameField in class EditProfileFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field usernameField in class editProfilePanel " +
                        "that is of type JTextField and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field emailField = EditProfileFrame.class.getDeclaredField("emailField");
                if (emailField.getType() != JTextField.class) {
                    fail("Ensure that emailField in class EditProfileFrame is of type JTextField.");
                    return;
                }
                if (emailField.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that emailField in class EditProfileFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field emailField in class editProfilePanel " +
                        "that is of type JTextField and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field passwordField = EditProfileFrame.class.getDeclaredField("passwordField");
                if (passwordField.getType() != JPasswordField.class) {
                    fail("Ensure that passwordField in class EditProfileFrame is of type JPasswordField.");
                    return;
                }
                if (passwordField.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that passwordField in class EditProfileFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field passwordField in class editProfilePanel " +
                        "that is of type JPasswordField and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field locationField = EditProfileFrame.class.getDeclaredField("locationField");
                if (locationField.getType() != JTextField.class) {
                    fail("Ensure that locationField in class EditProfileFrame is of type JTextField.");
                    return;
                }
                if (locationField.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that locationField in class EditProfileFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field locationField in class editProfilePanel " +
                        "that is of type JTextField and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field bioField = EditProfileFrame.class.getDeclaredField("bioField");
                if (bioField.getType() != JTextField.class) {
                    fail("Ensure that bioField in class EditProfileFrame is of type JTextField.");
                    return;
                }
                if (bioField.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that bioField in class EditProfileFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field bioField in class editProfilePanel " +
                        "that is of type JTextField and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field interestsField = EditProfileFrame.class.getDeclaredField("interestsField");
                if (interestsField.getType() != JTextField.class) {
                    fail("Ensure that interestsField in class EditProfileFrame is of type JTextField.");
                    return;
                }
                if (interestsField.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that interestsField in class EditProfileFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field interestsField in class editProfilePanel " +
                        "that is of type JTextField and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<EditProfileFrame> constructor = EditProfileFrame.class.getDeclaredConstructor(String.class,
                        String.class, String.class, String.class, String.class, String.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class EditProfileFrame is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 6 parameters and is public in class EditProfileFrame.");
                e.printStackTrace();
                return;
            }

            try {
                Method presetFields = EditProfileFrame.class.getDeclaredMethod("presetFields", String.class,
                        String.class, String.class, String.class, String.class, String.class);
                if (presetFields.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method presetFields in class EditProfileFrame is pubic.");
                    return;
                }
                if (!presetFields.getReturnType().equals(void.class)) {
                    fail("Ensure that your presetFields method in class EditProfileFrame returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the presetFields method that is public and static and returns void.");
                e.printStackTrace();
                return;
            }

        }

        @Test(timeout = 1_000)
        public void errorFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = ErrorFrame.class;
            className = "ErrorFrame";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends JFrame.", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void errorFrameClassSetupTest() {
            Field[] fields = ErrorFrame.class.getDeclaredFields();
            if (fields.length < 7) {
                fail("ErrorFrame class requires seven fields.");
                return;
            }

            try {
                Field frameContainer = ErrorFrame.class.getDeclaredField("frameContainer");
                if (frameContainer.getType() != Container.class) {
                    fail("Ensure that frameContainer in class ErrorFrame is of type Container.");
                    return;
                }
                if (frameContainer.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that frameContainer in class ErrorFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field frameContainer in class ErrorFrame " +
                        "that is of type Container and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field titlePanel = ErrorFrame.class.getDeclaredField("titlePanel");
                if (titlePanel.getType() != JPanel.class) {
                    fail("Ensure that titlePanel in class ErrorFrame is of type JPanel.");
                    return;
                }
                if (titlePanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that titlePanel in class ErrorFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field titlePanel in class ErrorFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field contentPanel = ErrorFrame.class.getDeclaredField("contentPanel");
                if (contentPanel.getType() != JPanel.class) {
                    fail("Ensure that contentPanel in class ErrorFrame is of type JPanel.");
                    return;
                }
                if (contentPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that contentPanel in class ErrorFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field contentPanel in class ErrorFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field errorIconLabel = ErrorFrame.class.getDeclaredField("errorIconLabel");
                if (errorIconLabel.getType() != JLabel.class) {
                    fail("Ensure that errorIconLabel in class ErrorFrame is of type JLabel.");
                    return;
                }
                if (errorIconLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that errorIconLabel in class ErrorFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field errorIconLabel in class ErrorFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field errorTitleLabel = ErrorFrame.class.getDeclaredField("errorTitleLabel");
                if (errorTitleLabel.getType() != JLabel.class) {
                    fail("Ensure that errorTitleLabel in class ErrorFrame is of type JLabel.");
                    return;
                }
                if (errorTitleLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that errorTitleLabel in class ErrorFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field errorTitleLabel in class ErrorFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field errorMessageLabel = ErrorFrame.class.getDeclaredField("errorMessageLabel");
                if (errorMessageLabel.getType() != JLabel.class) {
                    fail("Ensure that errorMessageLabel in class ErrorFrame is of type JLabel.");
                    return;
                }
                if (errorMessageLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that errorMessageLabel in class ErrorFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field errorMessageLabel in class ErrorFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field closeButton = ErrorFrame.class.getDeclaredField("closeButton");
                if (closeButton.getType() != JButton.class) {
                    fail("Ensure that closeButton in class ErrorFrame is of type JButton.");
                    return;
                }
                if (closeButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that closeButton in class ErrorFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field closeButton in class ErrorFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<ErrorFrame> constructor = ErrorFrame.class.getDeclaredConstructor(String.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class ErrorFrame is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 1 parameter and is public in class ErrorFrame.");
                e.printStackTrace();
                return;
            }

        }

        @Test(timeout = 1_000)
        public void friendsListFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = FriendsListFrame.class;
            className = "FriendsListFrame";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends JFrame.", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void friendsListFrameClassSetupTest() {
            Field[] fields = FriendsListFrame.class.getDeclaredFields();
            if (fields.length < 10) {
                fail("FriendsListFrame class requires ten fields.");
                return;
            }

            try {
                Field frameContainer = FriendsListFrame.class.getDeclaredField("frameContainer");
                if (frameContainer.getType() != Container.class) {
                    fail("Ensure that frameContainer in class FriendsListFrame is of type Container.");
                    return;
                }
                if (frameContainer.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that frameContainer in class FriendsListFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field frameContainer in class FriendsListFrame " +
                        "that is of type Container and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerPanel = FriendsListFrame.class.getDeclaredField("headerPanel");
                if (headerPanel.getType() != JPanel.class) {
                    fail("Ensure that headerPanel in class FriendsListFrame is of type JPanel.");
                    return;
                }
                if (headerPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerPanel in class FriendsListFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerPanel in class FriendsListFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field contentPanel = FriendsListFrame.class.getDeclaredField("contentPanel");
                if (contentPanel.getType() != JPanel.class) {
                    fail("Ensure that contentPanel in class FriendsListFrame is of type JPanel.");
                    return;
                }
                if (contentPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that contentPanel in class FriendsListFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field contentPanel in class FriendsListFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field navigationPanel = FriendsListFrame.class.getDeclaredField("navigationPanel");
                if (navigationPanel.getType() != JPanel.class) {
                    fail("Ensure that navigationPanel in class FriendsListFrame is of type JPanel.");
                    return;
                }
                if (navigationPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that navigationPanel in class FriendsListFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field navigationPanel in class FriendsListFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field logoLabel = FriendsListFrame.class.getDeclaredField("logoLabel");
                if (logoLabel.getType() != JLabel.class) {
                    fail("Ensure that logoLabel in class FriendsListFrame is of type JLabel.");
                    return;
                }
                if (logoLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that logoLabel in class FriendsListFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field logoLabel in class FriendsListFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerLabel = FriendsListFrame.class.getDeclaredField("headerLabel");
                if (headerLabel.getType() != JLabel.class) {
                    fail("Ensure that headerLabel in class FriendsListFrame is of type JLabel.");
                    return;
                }
                if (headerLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerLabel in class FriendsListFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerLabel in class FriendsListFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field friendsListLabel = FriendsListFrame.class.getDeclaredField("friendsListLabel");
                if (friendsListLabel.getType() != JLabel.class) {
                    fail("Ensure that friendsListLabel in class FriendsListFrame is of type JLabel.");
                    return;
                }
                if (friendsListLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that friendsListLabel in class FriendsListFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field friendsListLabel in class FriendsListFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field friendsListDescriptionLabel = FriendsListFrame.class.getDeclaredField("friendsListDescriptionLabel");
                if (friendsListDescriptionLabel.getType() != JLabel.class) {
                    fail("Ensure that friendsListDescriptionLabel in class FriendsListFrame is of type JLabel.");
                    return;
                }
                if (friendsListDescriptionLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that friendsListDescriptionLabel in class FriendsListFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field friendsListDescriptionLabel in class FriendsListFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field viewProfileButton = FriendsListFrame.class.getDeclaredField("viewProfileButton");
                if (viewProfileButton.getType() != JButton.class) {
                    fail("Ensure that viewProfileButton in class FriendsListFrame is of type JButton.");
                    return;
                }
                if (viewProfileButton.getModifiers() != (Modifier.PUBLIC)) {
                    fail("Ensure that viewProfileButton in class FriendsListFrame has modifiers public.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field viewProfileButton in class FriendsListFrame " +
                        "that is of type JButton and is public.");
                e.printStackTrace();
                return;
            }

            try {
                Field backButton = FriendsListFrame.class.getDeclaredField("backButton");
                if (backButton.getType() != JButton.class) {
                    fail("Ensure that backButton in class FriendsListFrame is of type JButton.");
                    return;
                }
                if (backButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that backButton in class FriendsListFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field backButton in class FriendsListFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<FriendsListFrame> constructor = FriendsListFrame.class.getDeclaredConstructor(String[].class, String[].class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class FriendsListFrame is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 2 parameters and is public in class FriendsListFrame.");
                e.printStackTrace();
                return;
            }

        }

        @Test(timeout = 1_000)
        public void homeFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = HomeFrame.class;
            className = "HomeFrame";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends JFrame.", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void homeFrameClassSetupTest() {
            Field[] fields = HomeFrame.class.getDeclaredFields();
            if (fields.length < 21) {
                fail("HomeFrame class requires twenty one fields.");
                return;
            }

            try {
                Field frameContainer = HomeFrame.class.getDeclaredField("frameContainer");
                if (frameContainer.getType() != Container.class) {
                    fail("Ensure that frameContainer in class HomeFrame is of type Container.");
                    return;
                }
                if (frameContainer.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that frameContainer in class HomeFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field frameContainer in class HomeFrame " +
                        "that is of type Container and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerPanel = HomeFrame.class.getDeclaredField("headerPanel");
                if (headerPanel.getType() != JPanel.class) {
                    fail("Ensure that headerPanel in class HomeFrame is of type JPanel.");
                    return;
                }
                if (headerPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerPanel in class HomeFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerPanel in class HomeFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field contentPanel = HomeFrame.class.getDeclaredField("contentPanel");
                if (contentPanel.getType() != JPanel.class) {
                    fail("Ensure that contentPanel in class HomeFrame is of type JPanel.");
                    return;
                }
                if (contentPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that contentPanel in class HomeFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field contentPanel in class HomeFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field signUpPanel = HomeFrame.class.getDeclaredField("signUpPanel");
                if (signUpPanel.getType() != JPanel.class) {
                    fail("Ensure that signUpPanel in class HomeFrame is of type JPanel.");
                    return;
                }
                if (signUpPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that signUpPanel in class HomeFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field signUpPanel in class HomeFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field signInPanel = HomeFrame.class.getDeclaredField("signInPanel");
                if (signInPanel.getType() != JPanel.class) {
                    fail("Ensure that signInPanel in class HomeFrame is of type JPanel.");
                    return;
                }
                if (signInPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that signInPanel in class HomeFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field signInPanel in class HomeFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field signInFieldPanel = HomeFrame.class.getDeclaredField("signInFieldPanel");
                if (signInFieldPanel.getType() != JPanel.class) {
                    fail("Ensure that signInFieldPanel in class HomeFrame is of type JPanel.");
                    return;
                }
                if (signInFieldPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that signInFieldPanel in class HomeFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field signInFieldPanel in class HomeFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field navigationPanel = HomeFrame.class.getDeclaredField("navigationPanel");
                if (navigationPanel.getType() != JPanel.class) {
                    fail("Ensure that navigationPanel in class HomeFrame is of type JPanel.");
                    return;
                }
                if (navigationPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that navigationPanel in class HomeFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field navigationPanel in class HomeFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field logoLabel = HomeFrame.class.getDeclaredField("logoLabel");
                if (logoLabel.getType() != JLabel.class) {
                    fail("Ensure that logoLabel in class HomeFrame is of type JLabel.");
                    return;
                }
                if (logoLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that logoLabel in class HomeFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field logoLabel in class HomeFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerLabel = HomeFrame.class.getDeclaredField("headerLabel");
                if (headerLabel.getType() != JLabel.class) {
                    fail("Ensure that headerLabel in class HomeFrame is of type JLabel.");
                    return;
                }
                if (headerLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerLabel in class HomeFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerLabel in class HomeFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field signUpLabel = HomeFrame.class.getDeclaredField("signUpLabel");
                if (signUpLabel.getType() != JLabel.class) {
                    fail("Ensure that signUpLabel in class HomeFrame is of type JLabel.");
                    return;
                }
                if (signUpLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that signUpLabel in class HomeFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field signUpLabel in class HomeFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field signUpDescriptionLabel = HomeFrame.class.getDeclaredField("signUpDescriptionLabel");
                if (signUpDescriptionLabel.getType() != JLabel.class) {
                    fail("Ensure that signUpDescriptionLabel in class HomeFrame is of type JLabel.");
                    return;
                }
                if (signUpDescriptionLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that signUpDescriptionLabel in class HomeFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field signUpDescriptionLabel in class HomeFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field signInLabel = HomeFrame.class.getDeclaredField("signInLabel");
                if (signInLabel.getType() != JLabel.class) {
                    fail("Ensure that signInLabel in class HomeFrame is of type JLabel.");
                    return;
                }
                if (signInLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that signInLabel in class HomeFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field signInLabel in class HomeFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field usernameLabel = HomeFrame.class.getDeclaredField("usernameLabel");
                if (usernameLabel.getType() != JLabel.class) {
                    fail("Ensure that usernameLabel in class HomeFrame is of type JLabel.");
                    return;
                }
                if (usernameLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that usernameLabel in class HomeFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field usernameLabel in class HomeFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field passwordLabel = HomeFrame.class.getDeclaredField("passwordLabel");
                if (passwordLabel.getType() != JLabel.class) {
                    fail("Ensure that passwordLabel in class HomeFrame is of type JLabel.");
                    return;
                }
                if (passwordLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that passwordLabel in class HomeFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field passwordLabel in class HomeFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field signUpButton = HomeFrame.class.getDeclaredField("signUpButton");
                if (signUpButton.getType() != JButton.class) {
                    fail("Ensure that signUpButton in class HomeFrame is of type JButton.");
                    return;
                }
                if (signUpButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that signUpButton in class HomeFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field signUpButton in class HomeFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field signInButton = HomeFrame.class.getDeclaredField("signInButton");
                if (signInButton.getType() != JButton.class) {
                    fail("Ensure that signInButton in class HomeFrame is of type JButton.");
                    return;
                }
                if (signInButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that signInButton in class HomeFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field signInButton in class HomeFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field exitButton = HomeFrame.class.getDeclaredField("exitButton");
                if (exitButton.getType() != JButton.class) {
                    fail("Ensure that exitButton in class HomeFrame is of type JButton.");
                    return;
                }
                if (exitButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that exitButton in class HomeFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field exitButton in class HomeFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field enterButton = HomeFrame.class.getDeclaredField("enterButton");
                if (enterButton.getType() != JButton.class) {
                    fail("Ensure that enterButton in class HomeFrame is of type JButton.");
                    return;
                }
                if (enterButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that enterButton in class HomeFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field enterButton in class HomeFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field usernameField = HomeFrame.class.getDeclaredField("usernameField");
                if (usernameField.getType() != JTextField.class) {
                    fail("Ensure that usernameField in class HomeFrame is of type JTextField.");
                    return;
                }
                if (usernameField.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that usernameField in class HomeFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field usernameField in class HomeFrame " +
                        "that is of type JTextField and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field passwordField = HomeFrame.class.getDeclaredField("passwordField");
                if (passwordField.getType() != JPasswordField.class) {
                    fail("Ensure that passwordField in class HomeFrame is of type JPasswordField.");
                    return;
                }
                if (passwordField.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that passwordField in class HomeFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field passwordField in class HomeFrame " +
                        "that is of type JTextField and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<HomeFrame> constructor = HomeFrame.class.getDeclaredConstructor();
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class HomeFrame is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes no parameters and is public in class HomeFrame.");
                e.printStackTrace();
                return;
            }

        }

        @Test(timeout = 1_000)
        public void incomingFriendRequestsFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = IncomingFriendRequestsFrame.class;
            className = "IncomingFriendRequestsFrame";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends JFrame.", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void incomingFriendRequestsFrameClassSetupTest() {
            Field[] fields = IncomingFriendRequestsFrame.class.getDeclaredFields();
            if (fields.length < 18) {
                fail("IncomingFriendRequestsFrame class requires eighteen fields.");
                return;
            }

            try {
                Field frameContainer = IncomingFriendRequestsFrame.class.getDeclaredField("frameContainer");
                if (frameContainer.getType() != Container.class) {
                    fail("Ensure that frameContainer in class IncomingFriendRequestsFrame is of type Container.");
                    return;
                }
                if (frameContainer.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that frameContainer in class IncomingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field frameContainer in class IncomingFriendRequestsFrame " +
                        "that is of type Container and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerPanel = IncomingFriendRequestsFrame.class.getDeclaredField("headerPanel");
                if (headerPanel.getType() != JPanel.class) {
                    fail("Ensure that headerPanel in class IncomingFriendRequestsFrame is of type JPanel.");
                    return;
                }
                if (headerPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerPanel in class IncomingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerPanel in class IncomingFriendRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field contentPanel = IncomingFriendRequestsFrame.class.getDeclaredField("contentPanel");
                if (contentPanel.getType() != JPanel.class) {
                    fail("Ensure that contentPanel in class IncomingFriendRequestsFrame is of type JPanel.");
                    return;
                }
                if (contentPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that contentPanel in class IncomingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field contentPanel in class IncomingFriendRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field requestPanel = IncomingFriendRequestsFrame.class.getDeclaredField("requestPanel");
                if (requestPanel.getType() != JPanel.class) {
                    fail("Ensure that requestPanel in class IncomingFriendRequestsFrame is of type JPanel.");
                    return;
                }
                if (requestPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that requestPanel in class IncomingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field requestPanel in class IncomingFriendRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field imagePanel = IncomingFriendRequestsFrame.class.getDeclaredField("imagePanel");
                if (imagePanel.getType() != JPanel.class) {
                    fail("Ensure that imagePanel in class IncomingFriendRequestsFrame is of type JPanel.");
                    return;
                }
                if (imagePanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that imagePanel in class IncomingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field imagePanel in class IncomingFriendRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field namePanel = IncomingFriendRequestsFrame.class.getDeclaredField("namePanel");
                if (namePanel.getType() != JPanel.class) {
                    fail("Ensure that namePanel in class IncomingFriendRequestsFrame is of type JPanel.");
                    return;
                }
                if (namePanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that namePanel in class IncomingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field namePanel in class IncomingFriendRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field buttonPanel = IncomingFriendRequestsFrame.class.getDeclaredField("buttonPanel");
                if (buttonPanel.getType() != JPanel.class) {
                    fail("Ensure that buttonPanel in class IncomingFriendRequestsFrame is of type JPanel.");
                    return;
                }
                if (buttonPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that buttonPanel in class IncomingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field buttonPanel in class IncomingFriendRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field navigationPanel = IncomingFriendRequestsFrame.class.getDeclaredField("navigationPanel");
                if (navigationPanel.getType() != JPanel.class) {
                    fail("Ensure that navigationPanel in class IncomingFriendRequestsFrame is of type JPanel.");
                    return;
                }
                if (navigationPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that navigationPanel in class IncomingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field navigationPanel in class IncomingFriendRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field logoLabel = IncomingFriendRequestsFrame.class.getDeclaredField("logoLabel");
                if (logoLabel.getType() != JLabel.class) {
                    fail("Ensure that logoLabel in class IncomingFriendRequestsFrame is of type JLabel.");
                    return;
                }
                if (logoLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that logoLabel in class IncomingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field logoLabel in class IncomingFriendRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerLabel = IncomingFriendRequestsFrame.class.getDeclaredField("headerLabel");
                if (headerLabel.getType() != JLabel.class) {
                    fail("Ensure that headerLabel in class IncomingFriendRequestsFrame is of type JLabel.");
                    return;
                }
                if (headerLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerLabel in class IncomingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerLabel in class IncomingFriendRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field incomingFriendRequestsLabel = IncomingFriendRequestsFrame.class.getDeclaredField("incomingFriendRequestsLabel");
                if (incomingFriendRequestsLabel.getType() != JLabel.class) {
                    fail("Ensure that incomingFriendRequestsLabel in class IncomingFriendRequestsFrame is of type JLabel.");
                    return;
                }
                if (incomingFriendRequestsLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that incomingFriendRequestsLabel in class IncomingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field incomingFriendRequestsLabel in class IncomingFriendRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field incomingFriendRequestsDescriptionLabel = IncomingFriendRequestsFrame.class.getDeclaredField("incomingFriendRequestsDescriptionLabel");
                if (incomingFriendRequestsDescriptionLabel.getType() != JLabel.class) {
                    fail("Ensure that incomingFriendRequestsDescriptionLabel in class IncomingFriendRequestsFrame is of type JLabel.");
                    return;
                }
                if (incomingFriendRequestsDescriptionLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that incomingFriendRequestsDescriptionLabel in class IncomingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field incomingFriendRequestsDescriptionLabel in class IncomingFriendRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field imageLabel = IncomingFriendRequestsFrame.class.getDeclaredField("imageLabel");
                if (imageLabel.getType() != JLabel.class) {
                    fail("Ensure that imageLabel in class IncomingFriendRequestsFrame is of type JLabel.");
                    return;
                }
                if (imageLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that imageLabel in class IncomingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field imageLabel in class IncomingFriendRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field nameLabel = IncomingFriendRequestsFrame.class.getDeclaredField("nameLabel");
                if (nameLabel.getType() != JLabel.class) {
                    fail("Ensure that nameLabel in class IncomingFriendRequestsFrame is of type JLabel.");
                    return;
                }
                if (nameLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that nameLabel in class IncomingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field nameLabel in class IncomingFriendRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field usernameLabel = IncomingFriendRequestsFrame.class.getDeclaredField("usernameLabel");
                if (usernameLabel.getType() != JLabel.class) {
                    fail("Ensure that usernameLabel in class IncomingFriendRequestsFrame is of type JLabel.");
                    return;
                }
                if (usernameLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that usernameLabel in class IncomingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field usernameLabel in class IncomingFriendRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field acceptRequestButton = IncomingFriendRequestsFrame.class.getDeclaredField("acceptRequestButton");
                if (acceptRequestButton.getType() != JButton.class) {
                    fail("Ensure that acceptRequestButton in class IncomingFriendRequestsFrame is of type JButton.");
                    return;
                }
                if (acceptRequestButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that acceptRequestButton in class IncomingFriendRequestsFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field acceptRequestButton in class IncomingFriendRequestsFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field denyRequestButton = IncomingFriendRequestsFrame.class.getDeclaredField("denyRequestButton");
                if (denyRequestButton.getType() != JButton.class) {
                    fail("Ensure that denyRequestButton in class IncomingFriendRequestsFrame is of type JButton.");
                    return;
                }
                if (denyRequestButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that denyRequestButton in class IncomingFriendRequestsFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field denyRequestButton in class IncomingFriendRequestsFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field backButton = IncomingFriendRequestsFrame.class.getDeclaredField("backButton");
                if (backButton.getType() != JButton.class) {
                    fail("Ensure that backButton in class IncomingFriendRequestsFrame is of type JButton.");
                    return;
                }
                if (backButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that backButton in class IncomingFriendRequestsFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field backButton in class IncomingFriendRequestsFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<IncomingFriendRequestsFrame> constructor = IncomingFriendRequestsFrame.class.getDeclaredConstructor(String.class, String.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class IncomingFriendRequestsFrame is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 2 parameters and is public in class IncomingFriendRequestsFrame.");
                e.printStackTrace();
                return;
            }

        }

        @Test(timeout = 1_000)
        public void outgoingFriendRequestsFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = OutgoingFriendRequestsFrame.class;
            className = "OutgoingFriendRequestsFrame";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends JFrame.", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void outgoingFriendRequestsFrameClassSetupTest() {
            Field[] fields = OutgoingFriendRequestsFrame.class.getDeclaredFields();
            if (fields.length < 18) {
                fail("OutgoingFriendRequestsFrame class requires eighteen fields.");
                return;
            }

            try {
                Field frameContainer = OutgoingFriendRequestsFrame.class.getDeclaredField("frameContainer");
                if (frameContainer.getType() != Container.class) {
                    fail("Ensure that frameContainer in class OutgoingFriendRequestsFrame is of type Container.");
                    return;
                }
                if (frameContainer.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that frameContainer in class OutgoingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field frameContainer in class OutgoingFriendRequestsFrame " +
                        "that is of type Container and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerPanel = OutgoingFriendRequestsFrame.class.getDeclaredField("headerPanel");
                if (headerPanel.getType() != JPanel.class) {
                    fail("Ensure that headerPanel in class OutgoingFriendRequestsFrame is of type JPanel.");
                    return;
                }
                if (headerPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerPanel in class OutgoingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerPanel in class OutgoingFriendRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field contentPanel = OutgoingFriendRequestsFrame.class.getDeclaredField("contentPanel");
                if (contentPanel.getType() != JPanel.class) {
                    fail("Ensure that contentPanel in class OutgoingFriendRequestsFrame is of type JPanel.");
                    return;
                }
                if (contentPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that contentPanel in class OutgoingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field contentPanel in class OutgoingFriendRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field requestPanel = OutgoingFriendRequestsFrame.class.getDeclaredField("requestPanel");
                if (requestPanel.getType() != JPanel.class) {
                    fail("Ensure that requestPanel in class OutgoingFriendRequestsFrame is of type JPanel.");
                    return;
                }
                if (requestPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that requestPanel in class OutgoingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field requestPanel in class OutgoingFriendRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field imagePanel = OutgoingFriendRequestsFrame.class.getDeclaredField("imagePanel");
                if (imagePanel.getType() != JPanel.class) {
                    fail("Ensure that imagePanel in class OutgoingFriendRequestsFrame is of type JPanel.");
                    return;
                }
                if (imagePanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that imagePanel in class OutgoingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field imagePanel in class OutgoingFriendRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field namePanel = OutgoingFriendRequestsFrame.class.getDeclaredField("namePanel");
                if (namePanel.getType() != JPanel.class) {
                    fail("Ensure that namePanel in class OutgoingFriendRequestsFrame is of type JPanel.");
                    return;
                }
                if (namePanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that namePanel in class OutgoingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field namePanel in class OutgoingFriendRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field buttonPanel = OutgoingFriendRequestsFrame.class.getDeclaredField("buttonPanel");
                if (buttonPanel.getType() != JPanel.class) {
                    fail("Ensure that buttonPanel in class OutgoingFriendRequestsFrame is of type JPanel.");
                    return;
                }
                if (buttonPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that buttonPanel in class OutgoingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field buttonPanel in class OutgoingFriendRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field navigationPanel = OutgoingFriendRequestsFrame.class.getDeclaredField("navigationPanel");
                if (navigationPanel.getType() != JPanel.class) {
                    fail("Ensure that navigationPanel in class OutgoingFriendRequestsFrame is of type JPanel.");
                    return;
                }
                if (navigationPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that navigationPanel in class OutgoingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field navigationPanel in class OutgoingFriendRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field logoLabel = OutgoingFriendRequestsFrame.class.getDeclaredField("logoLabel");
                if (logoLabel.getType() != JLabel.class) {
                    fail("Ensure that logoLabel in class OutgoingFriendRequestsFrame is of type JLabel.");
                    return;
                }
                if (logoLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that logoLabel in class OutgoingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field logoLabel in class OutgoingFriendRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerLabel = OutgoingFriendRequestsFrame.class.getDeclaredField("headerLabel");
                if (headerLabel.getType() != JLabel.class) {
                    fail("Ensure that headerLabel in class OutgoingFriendRequestsFrame is of type JLabel.");
                    return;
                }
                if (headerLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerLabel in class OutgoingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerLabel in class OutgoingFriendRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field outgoingFriendRequestsLabel = OutgoingFriendRequestsFrame.class.getDeclaredField("outgoingFriendRequestsLabel");
                if (outgoingFriendRequestsLabel.getType() != JLabel.class) {
                    fail("Ensure that outgoingFriendRequestsLabel in class OutgoingFriendRequestsFrame is of type JLabel.");
                    return;
                }
                if (outgoingFriendRequestsLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that outgoingFriendRequestsLabel in class OutgoingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field outgoingFriendRequestsLabel in class OutgoingFriendRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field outgoingFriendRequestsDescriptionLabel = OutgoingFriendRequestsFrame.class.getDeclaredField("outgoingFriendRequestsDescriptionLabel");
                if (outgoingFriendRequestsDescriptionLabel.getType() != JLabel.class) {
                    fail("Ensure that outgoingFriendRequestsDescriptionLabel in class OutgoingFriendRequestsFrame is of type JLabel.");
                    return;
                }
                if (outgoingFriendRequestsDescriptionLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that outgoingFriendRequestsDescriptionLabel in class OutgoingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field outgoingFriendRequestsDescriptionLabel in class OutgoingFriendRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field imageLabel = OutgoingFriendRequestsFrame.class.getDeclaredField("imageLabel");
                if (imageLabel.getType() != JLabel.class) {
                    fail("Ensure that imageLabel in class OutgoingFriendRequestsFrame is of type JLabel.");
                    return;
                }
                if (imageLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that imageLabel in class OutgoingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field imageLabel in class OutgoingFriendRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field nameLabel = OutgoingFriendRequestsFrame.class.getDeclaredField("nameLabel");
                if (nameLabel.getType() != JLabel.class) {
                    fail("Ensure that nameLabel in class OutgoingFriendRequestsFrame is of type JLabel.");
                    return;
                }
                if (nameLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that nameLabel in class OutgoingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field nameLabel in class OutgoingFriendRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field usernameLabel = OutgoingFriendRequestsFrame.class.getDeclaredField("usernameLabel");
                if (usernameLabel.getType() != JLabel.class) {
                    fail("Ensure that usernameLabel in class OutgoingFriendRequestsFrame is of type JLabel.");
                    return;
                }
                if (usernameLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that usernameLabel in class OutgoingFriendRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field usernameLabel in class OutgoingFriendRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field cancelRequestButton = OutgoingFriendRequestsFrame.class.getDeclaredField("cancelRequestButton");
                if (cancelRequestButton.getType() != JButton.class) {
                    fail("Ensure that cancelRequestButton in class OutgoingFriendRequestsFrame is of type JButton.");
                    return;
                }
                if (cancelRequestButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that cancelRequestButton in class OutgoingFriendRequestsFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field cancelRequestButton in class OutgoingFriendRequestsFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field backButton = OutgoingFriendRequestsFrame.class.getDeclaredField("backButton");
                if (backButton.getType() != JButton.class) {
                    fail("Ensure that backButton in class OutgoingFriendRequestsFrame is of type JButton.");
                    return;
                }
                if (backButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that backButton in class OutgoingFriendRequestsFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field backButton in class OutgoingFriendRequestsFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field nextButton = OutgoingFriendRequestsFrame.class.getDeclaredField("nextButton");
                if (nextButton.getType() != JButton.class) {
                    fail("Ensure that nextButton in class OutgoingFriendRequestsFrame is of type JButton.");
                    return;
                }
                if (nextButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that nextButton in class OutgoingFriendRequestsFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field nextButton in class OutgoingFriendRequestsFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<OutgoingFriendRequestsFrame> constructor = OutgoingFriendRequestsFrame.class.getDeclaredConstructor(String.class, String.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class OutgoingFriendRequestsFrame is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 2 parameters and is public in class OutgoingFriendRequestsFrame.");
                e.printStackTrace();
                return;
            }

        }

        @Test(timeout = 1_000)
        public void profileFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = ProfileFrame.class;
            className = "ProfileFrame";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends JFrame.", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void profileFrameClassSetupTest() {
            Field[] fields = ProfileFrame.class.getDeclaredFields();
            if (fields.length < 26) {
                fail("ProfileFrame class requires twenty six fields.");
                return;
            }

            try {
                Field frameContainer = ProfileFrame.class.getDeclaredField("frameContainer");
                if (frameContainer.getType() != Container.class) {
                    fail("Ensure that frameContainer in class ProfileFrame is of type Container.");
                    return;
                }
                if (frameContainer.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that frameContainer in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field frameContainer in class ProfileFrame " +
                        "that is of type Container and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerPanel = ProfileFrame.class.getDeclaredField("headerPanel");
                if (headerPanel.getType() != JPanel.class) {
                    fail("Ensure that headerPanel in class ProfileFrame is of type JPanel.");
                    return;
                }
                if (headerPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerPanel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerPanel in class ProfileFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field contentPanel = ProfileFrame.class.getDeclaredField("contentPanel");
                if (contentPanel.getType() != JPanel.class) {
                    fail("Ensure that contentPanel in class ProfileFrame is of type JPanel.");
                    return;
                }
                if (contentPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that contentPanel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field contentPanel in class ProfileFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field profilePanel = ProfileFrame.class.getDeclaredField("profilePanel");
                if (profilePanel.getType() != JPanel.class) {
                    fail("Ensure that profilePanel in class ProfileFrame is of type JPanel.");
                    return;
                }
                if (profilePanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that profilePanel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field profilePanel in class ProfileFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field imagePanel = ProfileFrame.class.getDeclaredField("imagePanel");
                if (imagePanel.getType() != JPanel.class) {
                    fail("Ensure that imagePanel in class ProfileFrame is of type JPanel.");
                    return;
                }
                if (imagePanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that imagePanel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field imagePanel in class ProfileFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field namePanel = ProfileFrame.class.getDeclaredField("namePanel");
                if (namePanel.getType() != JPanel.class) {
                    fail("Ensure that namePanel in class ProfileFrame is of type JPanel.");
                    return;
                }
                if (namePanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that namePanel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field namePanel in class ProfileFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field buttonPanel = ProfileFrame.class.getDeclaredField("buttonPanel");
                if (buttonPanel.getType() != JPanel.class) {
                    fail("Ensure that buttonPanel in class ProfileFrame is of type JPanel.");
                    return;
                }
                if (buttonPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that buttonPanel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field buttonPanel in class ProfileFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field friendButtonPanel = ProfileFrame.class.getDeclaredField("friendButtonPanel");
                if (friendButtonPanel.getType() != JPanel.class) {
                    fail("Ensure that friendButtonPanel in class ProfileFrame is of type JPanel.");
                    return;
                }
                if (friendButtonPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that friendButtonPanel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field friendButtonPanel in class ProfileFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field informationPanel = ProfileFrame.class.getDeclaredField("informationPanel");
                if (informationPanel.getType() != JPanel.class) {
                    fail("Ensure that informationPanel in class ProfileFrame is of type JPanel.");
                    return;
                }
                if (informationPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that informationPanel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field informationPanel in class ProfileFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field navigationPanel = ProfileFrame.class.getDeclaredField("navigationPanel");
                if (navigationPanel.getType() != JPanel.class) {
                    fail("Ensure that navigationPanel in class ProfileFrame is of type JPanel.");
                    return;
                }
                if (navigationPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that navigationPanel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field navigationPanel in class ProfileFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field logoLabel = ProfileFrame.class.getDeclaredField("logoLabel");
                if (logoLabel.getType() != JLabel.class) {
                    fail("Ensure that logoLabel in class ProfileFrame is of type JLabel.");
                    return;
                }
                if (logoLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that logoLabel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field logoLabel in class ProfileFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerLabel = ProfileFrame.class.getDeclaredField("headerLabel");
                if (headerLabel.getType() != JLabel.class) {
                    fail("Ensure that headerLabel in class ProfileFrame is of type JLabel.");
                    return;
                }
                if (headerLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerLabel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerLabel in class ProfileFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }


            try {
                Field imageLabel = ProfileFrame.class.getDeclaredField("imageLabel");
                if (imageLabel.getType() != JLabel.class) {
                    fail("Ensure that imageLabel in class ProfileFrame is of type JLabel.");
                    return;
                }
                if (imageLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that imageLabel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field imageLabel in class ProfileFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field nameLabel = ProfileFrame.class.getDeclaredField("nameLabel");
                if (nameLabel.getType() != JLabel.class) {
                    fail("Ensure that nameLabel in class ProfileFrame is of type JLabel.");
                    return;
                }
                if (nameLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that nameLabel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field nameLabel in class ProfileFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field usernameLabel = ProfileFrame.class.getDeclaredField("usernameLabel");
                if (usernameLabel.getType() != JLabel.class) {
                    fail("Ensure that usernameLabel in class ProfileFrame is of type JLabel.");
                    return;
                }
                if (usernameLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that usernameLabel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field usernameLabel in class ProfileFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field locationHeaderLabel = ProfileFrame.class.getDeclaredField("locationHeaderLabel");
                if (locationHeaderLabel.getType() != JLabel.class) {
                    fail("Ensure that locationHeaderLabel in class ProfileFrame is of type JLabel.");
                    return;
                }
                if (locationHeaderLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that locationHeaderLabel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field locationHeaderLabel in class ProfileFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field locationLabel = ProfileFrame.class.getDeclaredField("locationLabel");
                if (locationLabel.getType() != JLabel.class) {
                    fail("Ensure that locationLabel in class ProfileFrame is of type JLabel.");
                    return;
                }
                if (locationLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that locationLabel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field locationLabel in class ProfileFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field bioHeaderLabel = ProfileFrame.class.getDeclaredField("bioHeaderLabel");
                if (bioHeaderLabel.getType() != JLabel.class) {
                    fail("Ensure that bioHeaderLabel in class ProfileFrame is of type JLabel.");
                    return;
                }
                if (bioHeaderLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that bioHeaderLabel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field bioHeaderLabel in class ProfileFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field bioLabel = ProfileFrame.class.getDeclaredField("bioLabel");
                if (bioLabel.getType() != JLabel.class) {
                    fail("Ensure that bioLabel in class ProfileFrame is of type JLabel.");
                    return;
                }
                if (bioLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that bioLabel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field bioLabel in class ProfileFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field interestsHeaderLabel = ProfileFrame.class.getDeclaredField("interestsHeaderLabel");
                if (interestsHeaderLabel.getType() != JLabel.class) {
                    fail("Ensure that interestsHeaderLabel in class ProfileFrame is of type JLabel.");
                    return;
                }
                if (interestsHeaderLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that interestsHeaderLabel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field interestsHeaderLabel in class ProfileFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field interestsLabel = ProfileFrame.class.getDeclaredField("interestsLabel");
                if (interestsLabel.getType() != JLabel.class) {
                    fail("Ensure that interestsLabel in class ProfileFrame is of type JLabel.");
                    return;
                }
                if (interestsLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that interestsLabel in class ProfileFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field interestsLabel in class ProfileFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field editProfileButton = ProfileFrame.class.getDeclaredField("editProfileButton");
                if (editProfileButton.getType() != JButton.class) {
                    fail("Ensure that editProfileButton in class ProfileFrame is of type JButton.");
                    return;
                }
                if (editProfileButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that editProfileButton in class ProfileFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field editProfileButton in class ProfileFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field viewFriendsButton = ProfileFrame.class.getDeclaredField("viewFriendsButton");
                if (viewFriendsButton.getType() != JButton.class) {
                    fail("Ensure that viewFriendsButton in class ProfileFrame is of type JButton.");
                    return;
                }
                if (viewFriendsButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that viewFriendsButton in class ProfileFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field viewFriendsButton in class ProfileFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field addFriendButton = ProfileFrame.class.getDeclaredField("addFriendButton");
                if (addFriendButton.getType() != JButton.class) {
                    fail("Ensure that addFriendButton in class ProfileFrame is of type JButton.");
                    return;
                }
                if (addFriendButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that addFriendButton in class ProfileFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field addFriendButton in class ProfileFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field viewRequestsButton = ProfileFrame.class.getDeclaredField("viewRequestsButton");
                if (viewRequestsButton.getType() != JButton.class) {
                    fail("Ensure that viewRequestsButton in class ProfileFrame is of type JButton.");
                    return;
                }
                if (viewRequestsButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that viewRequestsButton in class ProfileFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field viewRequestsButton in class ProfileFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field signOutButton = ProfileFrame.class.getDeclaredField("signOutButton");
                if (signOutButton.getType() != JButton.class) {
                    fail("Ensure that signOutButton in class ProfileFrame is of type JButton.");
                    return;
                }
                if (signOutButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that signOutButton in class ProfileFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field signOutButton in class ProfileFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<ProfileFrame> constructor = ProfileFrame.class.getDeclaredConstructor(String.class, String.class, String.class,
                        String.class, String.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class ProfileFrame is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 5 parameters and is public in class ProfileFrame.");
                e.printStackTrace();
                return;
            }

        }

        @Test(timeout = 1_000)
        public void profileFrameRestrictedClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = ProfileFrameRestricted.class;
            className = "ProfileFrameRestricted";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends JFrame.", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void profileFrameRestrictedClassSetupTest() {
            Field[] fields = ProfileFrameRestricted.class.getDeclaredFields();
            if (fields.length < 23) {
                fail("ProfileFrameRestricted class requires twenty three fields.");
                return;
            }

            try {
                Field frameContainer = ProfileFrameRestricted.class.getDeclaredField("frameContainer");
                if (frameContainer.getType() != Container.class) {
                    fail("Ensure that frameContainer in class ProfileFrameRestricted is of type Container.");
                    return;
                }
                if (frameContainer.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that frameContainer in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field frameContainer in class ProfileFrameRestricted " +
                        "that is of type Container and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerPanel = ProfileFrameRestricted.class.getDeclaredField("headerPanel");
                if (headerPanel.getType() != JPanel.class) {
                    fail("Ensure that headerPanel in class ProfileFrameRestricted is of type JPanel.");
                    return;
                }
                if (headerPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerPanel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerPanel in class ProfileFrameRestricted " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field contentPanel = ProfileFrameRestricted.class.getDeclaredField("contentPanel");
                if (contentPanel.getType() != JPanel.class) {
                    fail("Ensure that contentPanel in class ProfileFrameRestricted is of type JPanel.");
                    return;
                }
                if (contentPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that contentPanel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field contentPanel in class ProfileFrameRestricted " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field profilePanel = ProfileFrameRestricted.class.getDeclaredField("profilePanel");
                if (profilePanel.getType() != JPanel.class) {
                    fail("Ensure that profilePanel in class ProfileFrameRestricted is of type JPanel.");
                    return;
                }
                if (profilePanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that profilePanel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field profilePanel in class ProfileFrameRestricted " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field imagePanel = ProfileFrameRestricted.class.getDeclaredField("imagePanel");
                if (imagePanel.getType() != JPanel.class) {
                    fail("Ensure that imagePanel in class ProfileFrameRestricted is of type JPanel.");
                    return;
                }
                if (imagePanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that imagePanel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field imagePanel in class ProfileFrameRestricted " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field namePanel = ProfileFrameRestricted.class.getDeclaredField("namePanel");
                if (namePanel.getType() != JPanel.class) {
                    fail("Ensure that namePanel in class ProfileFrameRestricted is of type JPanel.");
                    return;
                }
                if (namePanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that namePanel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field namePanel in class ProfileFrameRestricted " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field buttonPanel = ProfileFrameRestricted.class.getDeclaredField("buttonPanel");
                if (buttonPanel.getType() != JPanel.class) {
                    fail("Ensure that buttonPanel in class ProfileFrameRestricted is of type JPanel.");
                    return;
                }
                if (buttonPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that buttonPanel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field buttonPanel in class ProfileFrameRestricted " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field friendButtonPanel = ProfileFrameRestricted.class.getDeclaredField("friendButtonPanel");
                if (friendButtonPanel.getType() != JPanel.class) {
                    fail("Ensure that friendButtonPanel in class ProfileFrameRestricted is of type JPanel.");
                    return;
                }
                if (friendButtonPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that friendButtonPanel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field friendButtonPanel in class ProfileFrameRestricted " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field informationPanel = ProfileFrameRestricted.class.getDeclaredField("informationPanel");
                if (informationPanel.getType() != JPanel.class) {
                    fail("Ensure that informationPanel in class ProfileFrameRestricted is of type JPanel.");
                    return;
                }
                if (informationPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that informationPanel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field informationPanel in class ProfileFrameRestricted " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field navigationPanel = ProfileFrameRestricted.class.getDeclaredField("navigationPanel");
                if (navigationPanel.getType() != JPanel.class) {
                    fail("Ensure that navigationPanel in class ProfileFrameRestricted is of type JPanel.");
                    return;
                }
                if (navigationPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that navigationPanel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field navigationPanel in class ProfileFrameRestricted " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field logoLabel = ProfileFrameRestricted.class.getDeclaredField("logoLabel");
                if (logoLabel.getType() != JLabel.class) {
                    fail("Ensure that logoLabel in class ProfileFrameRestricted is of type JLabel.");
                    return;
                }
                if (logoLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that logoLabel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field logoLabel in class ProfileFrameRestricted " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerLabel = ProfileFrameRestricted.class.getDeclaredField("headerLabel");
                if (headerLabel.getType() != JLabel.class) {
                    fail("Ensure that headerLabel in class ProfileFrameRestricted is of type JLabel.");
                    return;
                }
                if (headerLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerLabel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerLabel in class ProfileFrameRestricted " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }


            try {
                Field imageLabel = ProfileFrameRestricted.class.getDeclaredField("imageLabel");
                if (imageLabel.getType() != JLabel.class) {
                    fail("Ensure that imageLabel in class ProfileFrameRestricted is of type JLabel.");
                    return;
                }
                if (imageLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that imageLabel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field imageLabel in class ProfileFrameRestricted " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field nameLabel = ProfileFrameRestricted.class.getDeclaredField("nameLabel");
                if (nameLabel.getType() != JLabel.class) {
                    fail("Ensure that nameLabel in class ProfileFrameRestricted is of type JLabel.");
                    return;
                }
                if (nameLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that nameLabel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field nameLabel in class ProfileFrameRestricted " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field usernameLabel = ProfileFrameRestricted.class.getDeclaredField("usernameLabel");
                if (usernameLabel.getType() != JLabel.class) {
                    fail("Ensure that usernameLabel in class ProfileFrameRestricted is of type JLabel.");
                    return;
                }
                if (usernameLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that usernameLabel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field usernameLabel in class ProfileFrameRestricted " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field locationHeaderLabel = ProfileFrameRestricted.class.getDeclaredField("locationHeaderLabel");
                if (locationHeaderLabel.getType() != JLabel.class) {
                    fail("Ensure that locationHeaderLabel in class ProfileFrameRestricted is of type JLabel.");
                    return;
                }
                if (locationHeaderLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that locationHeaderLabel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field locationHeaderLabel in class ProfileFrameRestricted " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field locationLabel = ProfileFrameRestricted.class.getDeclaredField("locationLabel");
                if (locationLabel.getType() != JLabel.class) {
                    fail("Ensure that locationLabel in class ProfileFrameRestricted is of type JLabel.");
                    return;
                }
                if (locationLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that locationLabel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field locationLabel in class ProfileFrameRestricted " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field bioHeaderLabel = ProfileFrameRestricted.class.getDeclaredField("bioHeaderLabel");
                if (bioHeaderLabel.getType() != JLabel.class) {
                    fail("Ensure that bioHeaderLabel in class ProfileFrameRestricted is of type JLabel.");
                    return;
                }
                if (bioHeaderLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that bioHeaderLabel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field bioHeaderLabel in class ProfileFrameRestricted " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field bioLabel = ProfileFrameRestricted.class.getDeclaredField("bioLabel");
                if (bioLabel.getType() != JLabel.class) {
                    fail("Ensure that bioLabel in class ProfileFrameRestricted is of type JLabel.");
                    return;
                }
                if (bioLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that bioLabel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field bioLabel in class ProfileFrameRestricted " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field interestsHeaderLabel = ProfileFrameRestricted.class.getDeclaredField("interestsHeaderLabel");
                if (interestsHeaderLabel.getType() != JLabel.class) {
                    fail("Ensure that interestsHeaderLabel in class ProfileFrameRestricted is of type JLabel.");
                    return;
                }
                if (interestsHeaderLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that interestsHeaderLabel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field interestsHeaderLabel in class ProfileFrameRestricted " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field interestsLabel = ProfileFrameRestricted.class.getDeclaredField("interestsLabel");
                if (interestsLabel.getType() != JLabel.class) {
                    fail("Ensure that interestsLabel in class ProfileFrameRestricted is of type JLabel.");
                    return;
                }
                if (interestsLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that interestsLabel in class ProfileFrameRestricted has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field interestsLabel in class ProfileFrameRestricted " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field viewFriendsButton = ProfileFrameRestricted.class.getDeclaredField("viewFriendsButton");
                if (viewFriendsButton.getType() != JButton.class) {
                    fail("Ensure that viewFriendsButton in class ProfileFrameRestricted is of type JButton.");
                    return;
                }
                if (viewFriendsButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that viewFriendsButton in class ProfileFrameRestricted has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field viewFriendsButton in class ProfileFrameRestricted " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field backButton = ProfileFrameRestricted.class.getDeclaredField("backButton");
                if (backButton.getType() != JButton.class) {
                    fail("Ensure that backButton in class ProfileFrameRestricted is of type JButton.");
                    return;
                }
                if (backButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that backButton in class ProfileFrameRestricted has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field backButton in class ProfileFrameRestricted " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<ProfileFrameRestricted> constructor = ProfileFrameRestricted.class.getDeclaredConstructor(String.class, String.class, String.class,
                        String.class, String.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class ProfileFrameRestricted is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 5 parameters and is public in class ProfileFrameRestricted.");
                e.printStackTrace();
                return;
            }

        }

        @Test(timeout = 1_000)
        public void sendFriendRequestFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = SendFriendRequestFrame.class;
            className = "SendFriendRequestFrame";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends JFrame.", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void sendFriendRequestFrameClassSetupTest() {
            Field[] fields = SendFriendRequestFrame.class.getDeclaredFields();
            if (fields.length < 11) {
                fail("SendFriendRequestFrame class requires eleven fields.");
                return;
            }

            try {
                Field frameContainer = SendFriendRequestFrame.class.getDeclaredField("frameContainer");
                if (frameContainer.getType() != Container.class) {
                    fail("Ensure that frameContainer in class SendFriendRequestFrame is of type Container.");
                    return;
                }
                if (frameContainer.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that frameContainer in class SendFriendRequestFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field frameContainer in class SendFriendRequestFrame " +
                        "that is of type Container and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerPanel = SendFriendRequestFrame.class.getDeclaredField("headerPanel");
                if (headerPanel.getType() != JPanel.class) {
                    fail("Ensure that headerPanel in class SendFriendRequestFrame is of type JPanel.");
                    return;
                }
                if (headerPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerPanel in class SendFriendRequestFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerPanel in class SendFriendRequestFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field contentPanel = SendFriendRequestFrame.class.getDeclaredField("contentPanel");
                if (contentPanel.getType() != JPanel.class) {
                    fail("Ensure that contentPanel in class SendFriendRequestFrame is of type JPanel.");
                    return;
                }
                if (contentPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that contentPanel in class SendFriendRequestFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field contentPanel in class SendFriendRequestFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field navigationPanel = SendFriendRequestFrame.class.getDeclaredField("navigationPanel");
                if (navigationPanel.getType() != JPanel.class) {
                    fail("Ensure that navigationPanel in class SendFriendRequestFrame is of type JPanel.");
                    return;
                }
                if (navigationPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that navigationPanel in class SendFriendRequestFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field navigationPanel in class SendFriendRequestFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field logoLabel = SendFriendRequestFrame.class.getDeclaredField("logoLabel");
                if (logoLabel.getType() != JLabel.class) {
                    fail("Ensure that logoLabel in class SendFriendRequestFrame is of type JLabel.");
                    return;
                }
                if (logoLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that logoLabel in class SendFriendRequestFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field logoLabel in class SendFriendRequestFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerLabel = SendFriendRequestFrame.class.getDeclaredField("headerLabel");
                if (headerLabel.getType() != JLabel.class) {
                    fail("Ensure that headerLabel in class SendFriendRequestFrame is of type JLabel.");
                    return;
                }
                if (headerLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerLabel in class SendFriendRequestFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerLabel in class SendFriendRequestFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field sendFriendRequestLabel = SendFriendRequestFrame.class.getDeclaredField("sendFriendRequestLabel");
                if (sendFriendRequestLabel.getType() != JLabel.class) {
                    fail("Ensure that sendFriendRequestLabel in class SendFriendRequestFrame is of type JLabel.");
                    return;
                }
                if (sendFriendRequestLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that sendFriendRequestLabel in class SendFriendRequestFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field sendFriendRequestLabel in class SendFriendRequestFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field sendFriendRequestDescriptionLabel = SendFriendRequestFrame.class.getDeclaredField("sendFriendRequestDescriptionLabel");
                if (sendFriendRequestDescriptionLabel.getType() != JLabel.class) {
                    fail("Ensure that sendFriendRequestDescriptionLabel in class SendFriendRequestFrame is of type JLabel.");
                    return;
                }
                if (sendFriendRequestDescriptionLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that sendFriendRequestDescriptionLabel in class SendFriendRequestFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field sendFriendRequestDescriptionLabel in class SendFriendRequestFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }


            try {
                Field sendRequestButton = SendFriendRequestFrame.class.getDeclaredField("sendRequestButton");
                if (sendRequestButton.getType() != JButton.class) {
                    fail("Ensure that sendRequestButton in class SendFriendRequestFrame is of type JButton.");
                    return;
                }
                if (sendRequestButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that sendRequestButton in class SendFriendRequestFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field sendRequestButton in class SendFriendRequestFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field backButton = SendFriendRequestFrame.class.getDeclaredField("backButton");
                if (backButton.getType() != JButton.class) {
                    fail("Ensure that backButton in class SendFriendRequestFrame is of type JButton.");
                    return;
                }
                if (backButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that backButton in class SendFriendRequestFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field backButton in class SendFriendRequestFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field userComboBox = SendFriendRequestFrame.class.getDeclaredField("userComboBox");
                if (userComboBox.getType() != JComboBox.class) {
                    fail("Ensure that userComboBox in class SendFriendRequestFrame is of type JComboBox.");
                    return;
                }
                if (userComboBox.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that userComboBox in class SendFriendRequestFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field userComboBox in class SendFriendRequestFrame " +
                        "that is of type JComboBox and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<SendFriendRequestFrame> constructor = SendFriendRequestFrame.class.getDeclaredConstructor(String[].class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class SendFriendRequestFrame is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 1 parameter and is public in class SendFriendRequestFrame.");
                e.printStackTrace();
                return;
            }

        }

        @Test(timeout = 1_000)
        public void signUpFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = SignUpFrame.class;
            className = "SignUpFrame";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends JFrame.", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void signUpFrameClassSetupTest() {
            Field[] fields = SignUpFrame.class.getDeclaredFields();
            if (fields.length < 23) {
                fail("SignUpFrame class requires twenty three fields.");
                return;
            }

            try {
                Field frameContainer = SignUpFrame.class.getDeclaredField("frameContainer");
                if (frameContainer.getType() != Container.class) {
                    fail("Ensure that frameContainer in class SignUpFrame is of type Container.");
                    return;
                }
                if (frameContainer.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that frameContainer in class SignUpFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field frameContainer in class SignUpFrame " +
                        "that is of type Container and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerPanel = SignUpFrame.class.getDeclaredField("headerPanel");
                if (headerPanel.getType() != JPanel.class) {
                    fail("Ensure that headerPanel in class SignUpFrame is of type JPanel.");
                    return;
                }
                if (headerPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerPanel in class SignUpFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerPanel in class SignUpFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field contentPanel = SignUpFrame.class.getDeclaredField("contentPanel");
                if (contentPanel.getType() != JPanel.class) {
                    fail("Ensure that contentPanel in class SignUpFrame is of type JPanel.");
                    return;
                }
                if (contentPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that contentPanel in class SignUpFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field contentPanel in class SignUpFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field signUpPanel = SignUpFrame.class.getDeclaredField("signUpPanel");
                if (signUpPanel.getType() != JPanel.class) {
                    fail("Ensure that signUpPanel in class SignUpFrame is of type JPanel.");
                    return;
                }
                if (signUpPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that signUpPanel in class SignUpFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field signUpPanel in class SignUpFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field namePanel = SignUpFrame.class.getDeclaredField("namePanel");
                if (namePanel.getType() != JPanel.class) {
                    fail("Ensure that namePanel in class SignUpFrame is of type JPanel.");
                    return;
                }
                if (namePanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that namePanel in class SignUpFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field namePanel in class SignUpFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field usernamePanel = SignUpFrame.class.getDeclaredField("usernamePanel");
                if (usernamePanel.getType() != JPanel.class) {
                    fail("Ensure that usernamePanel in class SignUpFrame is of type JPanel.");
                    return;
                }
                if (usernamePanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that usernamePanel in class SignUpFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field usernamePanel in class SignUpFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field emailPanel = SignUpFrame.class.getDeclaredField("emailPanel");
                if (emailPanel.getType() != JPanel.class) {
                    fail("Ensure that emailPanel in class SignUpFrame is of type JPanel.");
                    return;
                }
                if (emailPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that emailPanel in class SignUpFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field emailPanel in class SignUpFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field passwordPanel = SignUpFrame.class.getDeclaredField("passwordPanel");
                if (passwordPanel.getType() != JPanel.class) {
                    fail("Ensure that passwordPanel in class SignUpFrame is of type JPanel.");
                    return;
                }
                if (passwordPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that passwordPanel in class SignUpFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field passwordPanel in class SignUpFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field navigationPanel = SignUpFrame.class.getDeclaredField("navigationPanel");
                if (navigationPanel.getType() != JPanel.class) {
                    fail("Ensure that navigationPanel in class SignUpFrame is of type JPanel.");
                    return;
                }
                if (navigationPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that navigationPanel in class SignUpFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field navigationPanel in class SignUpFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field logoLabel = SignUpFrame.class.getDeclaredField("logoLabel");
                if (logoLabel.getType() != JLabel.class) {
                    fail("Ensure that logoLabel in class SignUpFrame is of type JLabel.");
                    return;
                }
                if (logoLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that logoLabel in class SignUpFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field logoLabel in class SignUpFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerLabel = SignUpFrame.class.getDeclaredField("headerLabel");
                if (headerLabel.getType() != JLabel.class) {
                    fail("Ensure that headerLabel in class SignUpFrame is of type JLabel.");
                    return;
                }
                if (headerLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerLabel in class SignUpFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerLabel in class SignUpFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field signUpLabel = SignUpFrame.class.getDeclaredField("signUpLabel");
                if (signUpLabel.getType() != JLabel.class) {
                    fail("Ensure that signUpLabel in class SignUpFrame is of type JLabel.");
                    return;
                }
                if (signUpLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that signUpLabel in class SignUpFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field signUpLabel in class SignUpFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field signUpDescriptionLabel = SignUpFrame.class.getDeclaredField("signUpDescriptionLabel");
                if (signUpDescriptionLabel.getType() != JLabel.class) {
                    fail("Ensure that signUpDescriptionLabel in class SignUpFrame is of type JLabel.");
                    return;
                }
                if (signUpDescriptionLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that signUpDescriptionLabel in class SignUpFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field signUpDescriptionLabel in class SignUpFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field nameLabel = SignUpFrame.class.getDeclaredField("nameLabel");
                if (nameLabel.getType() != JLabel.class) {
                    fail("Ensure that nameLabel in class SignUpFrame is of type JLabel.");
                    return;
                }
                if (nameLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that nameLabel in class SignUpFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field nameLabel in class SignUpFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field usernameLabel = SignUpFrame.class.getDeclaredField("usernameLabel");
                if (usernameLabel.getType() != JLabel.class) {
                    fail("Ensure that usernameLabel in class SignUpFrame is of type JLabel.");
                    return;
                }
                if (usernameLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that usernameLabel in class SignUpFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field usernameLabel in class SignUpFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field emailLabel = SignUpFrame.class.getDeclaredField("emailLabel");
                if (emailLabel.getType() != JLabel.class) {
                    fail("Ensure that emailLabel in class SignUpFrame is of type JLabel.");
                    return;
                }
                if (emailLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that emailLabel in class SignUpFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field emailLabel in class SignUpFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field passwordLabel = SignUpFrame.class.getDeclaredField("passwordLabel");
                if (passwordLabel.getType() != JLabel.class) {
                    fail("Ensure that passwordLabel in class SignUpFrame is of type JLabel.");
                    return;
                }
                if (passwordLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that passwordLabel in class SignUpFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field passwordLabel in class SignUpFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field signUpButton = SignUpFrame.class.getDeclaredField("signUpButton");
                if (signUpButton.getType() != JButton.class) {
                    fail("Ensure that signUpButton in class SignUpFrame is of type JButton.");
                    return;
                }
                if (signUpButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that signUpButton in class SignUpFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field signUpButton in class SignUpFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field backButton = SignUpFrame.class.getDeclaredField("backButton");
                if (backButton.getType() != JButton.class) {
                    fail("Ensure that backButton in class SignUpFrame is of type JButton.");
                    return;
                }
                if (backButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that backButton in class SignUpFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field backButton in class SignUpFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field nameField = SignUpFrame.class.getDeclaredField("nameField");
                if (nameField.getType() != JTextField.class) {
                    fail("Ensure that nameField in class SignUpFrame is of type JTextField.");
                    return;
                }
                if (nameField.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that nameField in class SignUpFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field nameField in class SignUpFrame " +
                        "that is of type JTextField and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field usernameField = SignUpFrame.class.getDeclaredField("usernameField");
                if (usernameField.getType() != JTextField.class) {
                    fail("Ensure that usernameField in class SignUpFrame is of type JTextField.");
                    return;
                }
                if (usernameField.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that usernameField in class SignUpFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field usernameField in class SignUpFrame " +
                        "that is of type JTextField and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field emailField = SignUpFrame.class.getDeclaredField("emailField");
                if (emailField.getType() != JTextField.class) {
                    fail("Ensure that emailField in class SignUpFrame is of type JTextField.");
                    return;
                }
                if (emailField.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that emailField in class SignUpFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field emailField in class SignUpFrame " +
                        "that is of type JTextField and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field passwordField = SignUpFrame.class.getDeclaredField("passwordField");
                if (passwordField.getType() != JPasswordField.class) {
                    fail("Ensure that passwordField in class SignUpFrame is of type JPasswordField.");
                    return;
                }
                if (passwordField.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that passwordField in class SignUpFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field passwordField in class SignUpFrame " +
                        "that is of type JPasswordField and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<SignUpFrame> constructor = SignUpFrame.class.getDeclaredConstructor();
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class SignUpFrame is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes no parameters and is public in class SignUpFrame.");
                e.printStackTrace();
                return;
            }

        }

        @Test(timeout = 1_000)
        public void successFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = SuccessFrame.class;
            className = "SuccessFrame";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends JFrame.", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void successFrameClassSetupTest() {
            Field[] fields = SuccessFrame.class.getDeclaredFields();
            if (fields.length < 7) {
                fail("SuccessFrame class requires seven fields.");
                return;
            }

            try {
                Field frameContainer = SuccessFrame.class.getDeclaredField("frameContainer");
                if (frameContainer.getType() != Container.class) {
                    fail("Ensure that frameContainer in class SuccessFrame is of type Container.");
                    return;
                }
                if (frameContainer.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that frameContainer in class SuccessFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field frameContainer in class SuccessFrame " +
                        "that is of type Container and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field titlePanel = SuccessFrame.class.getDeclaredField("titlePanel");
                if (titlePanel.getType() != JPanel.class) {
                    fail("Ensure that titlePanel in class SuccessFrame is of type JPanel.");
                    return;
                }
                if (titlePanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that titlePanel in class SuccessFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field titlePanel in class SuccessFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field contentPanel = SuccessFrame.class.getDeclaredField("contentPanel");
                if (contentPanel.getType() != JPanel.class) {
                    fail("Ensure that contentPanel in class SuccessFrame is of type JPanel.");
                    return;
                }
                if (contentPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that contentPanel in class SuccessFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field contentPanel in class SuccessFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field successIconLabel = SuccessFrame.class.getDeclaredField("successIconLabel");
                if (successIconLabel.getType() != JLabel.class) {
                    fail("Ensure that successIconLabel in class SuccessFrame is of type JLabel.");
                    return;
                }
                if (successIconLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that successIconLabel in class SuccessFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field successIconLabel in class SuccessFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field successTitleLabel = SuccessFrame.class.getDeclaredField("successTitleLabel");
                if (successTitleLabel.getType() != JLabel.class) {
                    fail("Ensure that successTitleLabel in class SuccessFrame is of type JLabel.");
                    return;
                }
                if (successTitleLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that successTitleLabel in class SuccessFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field successTitleLabel in class SuccessFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field successMessageLabel = SuccessFrame.class.getDeclaredField("successMessageLabel");
                if (successMessageLabel.getType() != JLabel.class) {
                    fail("Ensure that successMessageLabel in class SuccessFrame is of type JLabel.");
                    return;
                }
                if (successMessageLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that successMessageLabel in class SuccessFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field successMessageLabel in class SuccessFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field closeButton = SuccessFrame.class.getDeclaredField("closeButton");
                if (closeButton.getType() != JButton.class) {
                    fail("Ensure that closeButton in class SuccessFrame is of type JButton.");
                    return;
                }
                if (closeButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that closeButton in class SuccessFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field closeButton in class SuccessFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<SuccessFrame> constructor = SuccessFrame.class.getDeclaredConstructor(String.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class SuccessFrame is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 1 parameter and is public in class SuccessFrame.");
                e.printStackTrace();
                return;
            }

        }

        @Test(timeout = 1_000)
        public void viewRequestsFrameClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = ViewRequestsFrame.class;
            className = "ViewRequestsFrame";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends JFrame.", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void viewRequestsFrameClassSetupTest() {
            Field[] fields = ViewRequestsFrame.class.getDeclaredFields();
            if (fields.length < 12) {
                fail("ViewRequestsFrame class requires twelve fields.");
                return;
            }

            try {
                Field frameContainer = ViewRequestsFrame.class.getDeclaredField("frameContainer");
                if (frameContainer.getType() != Container.class) {
                    fail("Ensure that frameContainer in class ViewRequestsFrame is of type Container.");
                    return;
                }
                if (frameContainer.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that frameContainer in class ViewRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field frameContainer in class ViewRequestsFrame " +
                        "that is of type Container and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerPanel = ViewRequestsFrame.class.getDeclaredField("headerPanel");
                if (headerPanel.getType() != JPanel.class) {
                    fail("Ensure that headerPanel in class ViewRequestsFrame is of type JPanel.");
                    return;
                }
                if (headerPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerPanel in class ViewRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerPanel in class ViewRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field contentPanel = ViewRequestsFrame.class.getDeclaredField("contentPanel");
                if (contentPanel.getType() != JPanel.class) {
                    fail("Ensure that contentPanel in class ViewRequestsFrame is of type JPanel.");
                    return;
                }
                if (contentPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that contentPanel in class ViewRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field contentPanel in class ViewRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field buttonPanel = ViewRequestsFrame.class.getDeclaredField("buttonPanel");
                if (buttonPanel.getType() != JPanel.class) {
                    fail("Ensure that buttonPanel in class ViewRequestsFrame is of type JPanel.");
                    return;
                }
                if (buttonPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that buttonPanel in class ViewRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field buttonPanel in class ViewRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field navigationPanel = ViewRequestsFrame.class.getDeclaredField("navigationPanel");
                if (navigationPanel.getType() != JPanel.class) {
                    fail("Ensure that navigationPanel in class ViewRequestsFrame is of type JPanel.");
                    return;
                }
                if (navigationPanel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that navigationPanel in class ViewRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field navigationPanel in class ViewRequestsFrame " +
                        "that is of type JPanel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field logoLabel = ViewRequestsFrame.class.getDeclaredField("logoLabel");
                if (logoLabel.getType() != JLabel.class) {
                    fail("Ensure that logoLabel in class ViewRequestsFrame is of type JLabel.");
                    return;
                }
                if (logoLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that logoLabel in class ViewRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field logoLabel in class ViewRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field headerLabel = ViewRequestsFrame.class.getDeclaredField("headerLabel");
                if (headerLabel.getType() != JLabel.class) {
                    fail("Ensure that headerLabel in class ViewRequestsFrame is of type JLabel.");
                    return;
                }
                if (headerLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that headerLabel in class ViewRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field headerLabel in class ViewRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field viewRequestsLabel = ViewRequestsFrame.class.getDeclaredField("viewRequestsLabel");
                if (viewRequestsLabel.getType() != JLabel.class) {
                    fail("Ensure that viewRequestsLabel in class ViewRequestsFrame is of type JLabel.");
                    return;
                }
                if (viewRequestsLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that viewRequestsLabel in class ViewRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field viewRequestsLabel in class ViewRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field viewRequestsDescriptionLabel = ViewRequestsFrame.class.getDeclaredField("viewRequestsDescriptionLabel");
                if (viewRequestsDescriptionLabel.getType() != JLabel.class) {
                    fail("Ensure that viewRequestsDescriptionLabel in class ViewRequestsFrame is of type JLabel.");
                    return;
                }
                if (viewRequestsDescriptionLabel.getModifiers() != (Modifier.PRIVATE + Modifier.FINAL)) {
                    fail("Ensure that viewRequestsDescriptionLabel in class ViewRequestsFrame has modifiers private and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field viewRequestsDescriptionLabel in class ViewRequestsFrame " +
                        "that is of type JLabel and is private and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field incomingRequestsButton = ViewRequestsFrame.class.getDeclaredField("incomingRequestsButton");
                if (incomingRequestsButton.getType() != JButton.class) {
                    fail("Ensure that incomingRequestsButton in class ViewRequestsFrame is of type JButton.");
                    return;
                }
                if (incomingRequestsButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that incomingRequestsButton in class ViewRequestsFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field incomingRequestsButton in class ViewRequestsFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field outgoingRequestsButton = ViewRequestsFrame.class.getDeclaredField("outgoingRequestsButton");
                if (outgoingRequestsButton.getType() != JButton.class) {
                    fail("Ensure that outgoingRequestsButton in class ViewRequestsFrame is of type JButton.");
                    return;
                }
                if (outgoingRequestsButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that outgoingRequestsButton in class ViewRequestsFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field outgoingRequestsButton in class ViewRequestsFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field backButton = ViewRequestsFrame.class.getDeclaredField("backButton");
                if (backButton.getType() != JButton.class) {
                    fail("Ensure that backButton in class ViewRequestsFrame is of type JButton.");
                    return;
                }
                if (backButton.getModifiers() != (Modifier.PUBLIC + Modifier.FINAL)) {
                    fail("Ensure that backButton in class ViewRequestsFrame has modifiers public and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field backButton in class ViewRequestsFrame " +
                        "that is of type JButton and is public and final.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<ViewRequestsFrame> constructor = ViewRequestsFrame.class.getDeclaredConstructor();
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class ViewRequestsFrame is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes no parameters and is public in class ViewRequestsFrame.");
                e.printStackTrace();
                return;
            }

        }

        @Test(timeout = 1_000)
        public void serverClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Server.class;
            className = "Server";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends Object.", Object.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void serverClassSetupTest() {
            Field[] fields = Server.class.getDeclaredFields();
            if (fields.length > 0) {
                fail("Server class should have no fields.");
                return;
            }

            try {
                Method main = Server.class.getDeclaredMethod("main", String[].class);
                if (main.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method main in class Server is public and static.");
                    return;
                }
                if (!main.getReturnType().equals(void.class)) {
                    fail("Ensure that your main method in class Server returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the main method that is public and static and returns void in Server.");
                e.printStackTrace();
                return;
            }

        }

        @Test(timeout = 1_000)
        public void clientHandlerClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = ClientHandler.class;
            className = "ClientHandler";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends Thread.", Thread.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void clientHandlerClassSetupTest() {
            Field[] fields = ClientHandler.class.getDeclaredFields();
            if (fields.length < 5) {
                fail("ClientHandler class requires five fields.");
                return;
            }

            try {
                Field s = ClientHandler.class.getDeclaredField("s");
                if (s.getType() != Socket.class) {
                    fail("Ensure that s in class ClientHandler is of type Socket.");
                    return;
                }
                if (s.getModifiers() != (Modifier.FINAL)) {
                    fail("Ensure that s in class ClientHandler has modifier final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field s in class Socket " +
                        "that is of type Socket and is final.");
                e.printStackTrace();
                return;
            }

            try {
                Field reader = ClientHandler.class.getDeclaredField("reader");
                if (reader.getType() != BufferedReader.class) {
                    fail("Ensure that reader in class ClientHandler is of type BufferedReader.");
                    return;
                }
                if (reader.getModifiers() != (Modifier.FINAL)) {
                    fail("Ensure that reader in class ClientHandler has modifier final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field reader in class ClientHandler " +
                        "that is of type BufferedReader and is final.");
                e.printStackTrace();
                return;
            }

            try {
                Field writer = ClientHandler.class.getDeclaredField("writer");
                if (writer.getType() != PrintWriter.class) {
                    fail("Ensure that writer in class ClientHandler is of type PrintWriter.");
                    return;
                }
                if (writer.getModifiers() != (Modifier.FINAL)) {
                    fail("Ensure that writer in class ClientHandler has modifier final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field writer in class ClientHandler " +
                        "that is of type PrintWriter and is final.");
                e.printStackTrace();
                return;
            }

            try {
                Field userList = ClientHandler.class.getDeclaredField("userList");
                if (userList.getType() != ArrayList.class) {
                    fail("Ensure that userList in class ClientHandler is of type ArrayList.");
                    return;
                }
                if (userList.getModifiers() != (Modifier.PRIVATE + Modifier.STATIC)) {
                    fail("Ensure that userList in class ClientHandler has modifier private and static.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field userList in class ClientHandler " +
                        "that is of type ArrayList and is private and static.");
                e.printStackTrace();
                return;
            }

            try {
                Field profilesList = ClientHandler.class.getDeclaredField("profilesList");
                if (profilesList.getType() != ArrayList.class) {
                    fail("Ensure that profilesList in class ClientHandler is of type ArrayList.");
                    return;
                }
                if (profilesList.getModifiers() != (Modifier.PRIVATE + Modifier.STATIC)) {
                    fail("Ensure that profilesList in class ClientHandler has modifier private and static.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field profilesList in class ClientHandler " +
                        "that is of type ArrayList and is private and static.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<ClientHandler> constructor = ClientHandler.class.getDeclaredConstructor(Socket.class,
                        BufferedReader.class, PrintWriter.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class ClientHandler is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 3 parameters and is public in class ClientHandler.");
                e.printStackTrace();
                return;
            }

            try {
                Method run = ClientHandler.class.getDeclaredMethod("run");
                if (run.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method run in class ClientHandler is public.");
                    return;
                }
                if (!run.getReturnType().equals(void.class)) {
                    fail("Ensure that your run method in class ClientHandler returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the run method that is public and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method readUsersList = ClientHandler.class.getDeclaredMethod("readUsersList");
                if (readUsersList.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method readUsersList in class ClientHandler is public.");
                    return;
                }
                if (!readUsersList.getReturnType().equals(ArrayList.class)) {
                    fail("Ensure that your readUsersList method in class ClientHandler returns ArrayList.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the readUsersList method that is public and returns ArrayList.");
                e.printStackTrace();
                return;
            }

            try {
                Method messageToClient = ClientHandler.class.getDeclaredMethod("messageToClient", String.class);
                if (messageToClient.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method messageToClient in class ClientHandler is public.");
                    return;
                }
                if (!messageToClient.getReturnType().equals(void.class)) {
                    fail("Ensure that your messageToClient method in class ClientHandler returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the messageToClient method that is public and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method readFromProfileFile = ClientHandler.class.getDeclaredMethod("readFromProfileFile", String.class);
                if (readFromProfileFile.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method readFromProfileFile in class ClientHandler is public.");
                    return;
                }
                if (!readFromProfileFile.getReturnType().equals(Profile.class)) {
                    fail("Ensure that your readFromProfileFile method in class ClientHandler returns Profile.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the readFromProfileFile method that is public and returns Profile.");
                e.printStackTrace();
                return;
            }

            try {
                Method writeProfileToFile = ClientHandler.class.getDeclaredMethod("writeProfileToFile", String.class, Profile.class);
                if (writeProfileToFile.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method writeProfileToFile in class ClientHandler is public.");
                    return;
                }
                if (!writeProfileToFile.getReturnType().equals(void.class)) {
                    fail("Ensure that your writeProfileToFile method in class ClientHandler returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the writeProfileToFile method that is public and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method initialiseFriendsList = ClientHandler.class.getDeclaredMethod("initialiseFriendsList", String[].class);
                if (initialiseFriendsList.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method initialiseFriendsList in class ClientHandler is public.");
                    return;
                }
                if (!initialiseFriendsList.getReturnType().equals(ArrayList.class)) {
                    fail("Ensure that your initialiseFriendsList method in class ClientHandler returns ArrayList.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the initialiseFriendsList method that is public and returns ArrayList.");
                e.printStackTrace();
                return;
            }

        }

        @Test
        public void clientHandlerClassImplementationTest() {
            try {
                ClientHandler testClientHandler = new ClientHandler(new Socket("localhost", 2400), new BufferedReader(new FileReader("testFileClient.txt")), new PrintWriter("testFileClientOutput.txt"));

                testClientHandler.readUsersList();

            } catch (Exception e) {
                fail("Error in creating ClientHandler Class: Some fields or methods not functional or present.");
                return;
            }
        }

        @Test(timeout = 1_000)
        public void constantsClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Constants.class;
            className = "Constants";

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();
            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `"+ className +"` is public.", Modifier.isPublic(modifiers));
            Assert.assertTrue("Ensure that `"+ className +"` is final.", Modifier.isFinal(modifiers));
            Assert.assertFalse("Ensure that `"+ className +"` is not abstract.", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `"+ className +"` extends Object.", Object.class, superclass);
            Assert.assertEquals("Ensure that `"+ className +"` implements no interfaces.", 0, superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void constantsClassSetupTest() {
            Field[] fields = Constants.class.getDeclaredFields();
            if (fields.length < 23) {
                fail("Constants class requires twenty three fields.");
                return;
            }

            try {
                Field LOGO_64 = Constants.class.getDeclaredField("LOGO_64");
                if (LOGO_64.getType() != ImageIcon.class) {
                    fail("Ensure that LOGO_64 in class Constants is of type ImageIcon.");
                    return;
                }
                if (LOGO_64.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that LOGO_64 in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field LOGO_64 in class Constants " +
                        "that is of type ImageIcon and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field LOGO_128 = Constants.class.getDeclaredField("LOGO_128");
                if (LOGO_128.getType() != ImageIcon.class) {
                    fail("Ensure that LOGO_128 in class Constants is of type ImageIcon.");
                    return;
                }
                if (LOGO_128.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that LOGO_128 in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field LOGO_128 in class Constants " +
                        "that is of type ImageIcon and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field LOGO_256 = Constants.class.getDeclaredField("LOGO_256");
                if (LOGO_256.getType() != ImageIcon.class) {
                    fail("Ensure that LOGO_256 in class Constants is of type ImageIcon.");
                    return;
                }
                if (LOGO_256.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that LOGO_256 in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field LOGO_256 in class Constants " +
                        "that is of type ImageIcon and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field LOGO_512 = Constants.class.getDeclaredField("LOGO_512");
                if (LOGO_512.getType() != ImageIcon.class) {
                    fail("Ensure that LOGO_512 in class Constants is of type ImageIcon.");
                    return;
                }
                if (LOGO_512.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that LOGO_512 in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field LOGO_512 in class Constants " +
                        "that is of type ImageIcon and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field ERROR_64 = Constants.class.getDeclaredField("ERROR_64");
                if (ERROR_64.getType() != ImageIcon.class) {
                    fail("Ensure that ERROR_64 in class Constants is of type ImageIcon.");
                    return;
                }
                if (ERROR_64.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that ERROR_64 in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field ERROR_64 in class Constants " +
                        "that is of type ImageIcon and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field USER_100 = Constants.class.getDeclaredField("USER_100");
                if (USER_100.getType() != ImageIcon.class) {
                    fail("Ensure that USER_100 in class Constants is of type ImageIcon.");
                    return;
                }
                if (USER_100.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that USER_100 in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field USER_100 in class Constants " +
                        "that is of type ImageIcon and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field SUCCESS_64 = Constants.class.getDeclaredField("SUCCESS_64");
                if (SUCCESS_64.getType() != ImageIcon.class) {
                    fail("Ensure that SUCCESS_64 in class Constants is of type ImageIcon.");
                    return;
                }
                if (SUCCESS_64.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that SUCCESS_64 in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field SUCCESS_64 in class Constants " +
                        "that is of type ImageIcon and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field SETTINGS_48 = Constants.class.getDeclaredField("SETTINGS_48");
                if (SETTINGS_48.getType() != ImageIcon.class) {
                    fail("Ensure that SETTINGS_48 in class Constants is of type ImageIcon.");
                    return;
                }
                if (SETTINGS_48.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that SETTINGS_48 in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field SETTINGS_48 in class Constants " +
                        "that is of type ImageIcon and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field HEADER_BACKGROUND_COLOR = Constants.class.getDeclaredField("HEADER_BACKGROUND_COLOR");
                if (HEADER_BACKGROUND_COLOR.getType() != Color.class) {
                    fail("Ensure that HEADER_BACKGROUND_COLOR in class Constants is of type Color.");
                    return;
                }
                if (HEADER_BACKGROUND_COLOR.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that HEADER_BACKGROUND_COLOR in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field HEADER_BACKGROUND_COLOR in class Constants " +
                        "that is of type Color and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field HEADER_BORDER_COLOR = Constants.class.getDeclaredField("HEADER_BORDER_COLOR");
                if (HEADER_BORDER_COLOR.getType() != Color.class) {
                    fail("Ensure that HEADER_BORDER_COLOR in class Constants is of type Color.");
                    return;
                }
                if (HEADER_BORDER_COLOR.getModifiers() != (Modifier.PRIVATE + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that HEADER_BORDER_COLOR in class Constants has modifiers private, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field HEADER_BORDER_COLOR in class Constants " +
                        "that is of type Color and is private, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field BACKGROUND_COLOR = Constants.class.getDeclaredField("BACKGROUND_COLOR");
                if (BACKGROUND_COLOR.getType() != Color.class) {
                    fail("Ensure that BACKGROUND_COLOR in class Constants is of type Color.");
                    return;
                }
                if (BACKGROUND_COLOR.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that BACKGROUND_COLOR in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field BACKGROUND_COLOR in class Constants " +
                        "that is of type Color and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field BUTTON_BORDER_COLOR = Constants.class.getDeclaredField("BUTTON_BORDER_COLOR");
                if (BUTTON_BORDER_COLOR.getType() != Color.class) {
                    fail("Ensure that BUTTON_BORDER_COLOR in class Constants is of type Color.");
                    return;
                }
                if (BUTTON_BORDER_COLOR.getModifiers() != (Modifier.PRIVATE + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that BUTTON_BORDER_COLOR in class Constants has modifiers private, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field BUTTON_BORDER_COLOR in class Constants " +
                        "that is of type Color and is private, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field NAVIGATION_BORDER_COLOR = Constants.class.getDeclaredField("NAVIGATION_BORDER_COLOR");
                if (NAVIGATION_BORDER_COLOR.getType() != Color.class) {
                    fail("Ensure that NAVIGATION_BORDER_COLOR in class Constants is of type Color.");
                    return;
                }
                if (NAVIGATION_BORDER_COLOR.getModifiers() != (Modifier.PRIVATE + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that NAVIGATION_BORDER_COLOR in class Constants has modifiers private, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field NAVIGATION_BORDER_COLOR in class Constants " +
                        "that is of type Color and is private, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field GRAY_COLOR = Constants.class.getDeclaredField("GRAY_COLOR");
                if (GRAY_COLOR.getType() != Color.class) {
                    fail("Ensure that GRAY_COLOR in class Constants is of type Color.");
                    return;
                }
                if (GRAY_COLOR.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that GRAY_COLOR in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field GRAY_COLOR in class Constants " +
                        "that is of type Color and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field YELLOW_COLOR = Constants.class.getDeclaredField("YELLOW_COLOR");
                if (YELLOW_COLOR.getType() != Color.class) {
                    fail("Ensure that YELLOW_COLOR in class Constants is of type Color.");
                    return;
                }
                if (YELLOW_COLOR.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that YELLOW_COLOR in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field YELLOW_COLOR in class Constants " +
                        "that is of type Color and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field ERROR_COLOR = Constants.class.getDeclaredField("ERROR_COLOR");
                if (ERROR_COLOR.getType() != Color.class) {
                    fail("Ensure that ERROR_COLOR in class Constants is of type Color.");
                    return;
                }
                if (ERROR_COLOR.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that ERROR_COLOR in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field ERROR_COLOR in class Constants " +
                        "that is of type Color and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field HEADER_BORDER = Constants.class.getDeclaredField("HEADER_BORDER");
                if (HEADER_BORDER.getType() != Border.class) {
                    fail("Ensure that HEADER_BORDER in class Constants is of type Border.");
                    return;
                }
                if (HEADER_BORDER.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that HEADER_BORDER in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field HEADER_BORDER in class Constants " +
                        "that is of type Border and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field HEADER_BORDER = Constants.class.getDeclaredField("HEADER_BORDER");
                if (HEADER_BORDER.getType() != Border.class) {
                    fail("Ensure that HEADER_BORDER in class Constants is of type Border.");
                    return;
                }
                if (HEADER_BORDER.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that HEADER_BORDER in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field HEADER_BORDER in class Constants " +
                        "that is of type Border and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field BUTTON_BORDER = Constants.class.getDeclaredField("BUTTON_BORDER");
                if (BUTTON_BORDER.getType() != Border.class) {
                    fail("Ensure that BUTTON_BORDER in class Constants is of type Border.");
                    return;
                }
                if (BUTTON_BORDER.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that BUTTON_BORDER in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field BUTTON_BORDER in class Constants " +
                        "that is of type Border and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field NAVIGATION_BORDER = Constants.class.getDeclaredField("NAVIGATION_BORDER");
                if (NAVIGATION_BORDER.getType() != Border.class) {
                    fail("Ensure that NAVIGATION_BORDER in class Constants is of type Border.");
                    return;
                }
                if (NAVIGATION_BORDER.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that NAVIGATION_BORDER in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field NAVIGATION_BORDER in class Constants " +
                        "that is of type Border and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field HEADER_FONT = Constants.class.getDeclaredField("HEADER_FONT");
                if (HEADER_FONT.getType() != Font.class) {
                    fail("Ensure that HEADER_FONT in class Constants is of type Font.");
                    return;
                }
                if (HEADER_FONT.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that HEADER_FONT in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field HEADER_FONT in class Constants " +
                        "that is of type Font and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field SUB_HEADER_FONT = Constants.class.getDeclaredField("SUB_HEADER_FONT");
                if (SUB_HEADER_FONT.getType() != Font.class) {
                    fail("Ensure that SUB_HEADER_FONT in class Constants is of type Font.");
                    return;
                }
                if (SUB_HEADER_FONT.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that SUB_HEADER_FONT in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field SUB_HEADER_FONT in class Constants " +
                        "that is of type Font and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field SUB_SUB_HEADER_FONT = Constants.class.getDeclaredField("SUB_SUB_HEADER_FONT");
                if (SUB_SUB_HEADER_FONT.getType() != Font.class) {
                    fail("Ensure that SUB_SUB_HEADER_FONT in class Constants is of type Font.");
                    return;
                }
                if (SUB_SUB_HEADER_FONT.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that SUB_SUB_HEADER_FONT in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field SUB_SUB_HEADER_FONT in class Constants " +
                        "that is of type Font and is public, static and final.");
                e.printStackTrace();
                return;
            }

            try {
                Field MAIN_FONT = Constants.class.getDeclaredField("MAIN_FONT");
                if (MAIN_FONT.getType() != Font.class) {
                    fail("Ensure that MAIN_FONT in class Constants is of type Font.");
                    return;
                }
                if (MAIN_FONT.getModifiers() != (Modifier.PUBLIC + + Modifier.STATIC + Modifier.FINAL)) {
                    fail("Ensure that MAIN_FONT in class Constants has modifiers public, static, and final.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field MAIN_FONT in class Constants " +
                        "that is of type Font and is public, static and final.");
                e.printStackTrace();
                return;
            }

        }



    }
}