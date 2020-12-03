package tests;// import org.junit.framework.TestCase;
import main.FriendRequest;
import main.Profile;
import main.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

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
            className = "main.User";

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
                fail("main.User class requires seven fields.");
                return;
            }

            try {
                Field fullName = User.class.getDeclaredField("fullName");
                if (fullName.getType() != String.class) {
                    fail("Ensure that fullName in class main.User is of type String.");
                    return;
                }
                if (fullName.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that fullName in class main.User has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field fullName in class main.User " +
                        "that is of type String and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Field userName = User.class.getDeclaredField("userName");
                if (userName.getType() != String.class) {
                    fail("Ensure that userName in class main.User is of type String.");
                    return;
                }
                if (userName.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that userName in class main.User has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field userName in class main.User " +
                        "that is of type String and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Field password = User.class.getDeclaredField("password");
                if (password.getType() != String.class) {
                    fail("Ensure that password in class main.User is of type String.");
                    return;
                }
                if (password.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that password in class main.User has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field password in class main.User " +
                        "that is of type String and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Field profile = User.class.getDeclaredField("profile");
                if (profile.getType() != Profile.class) {
                    fail("Ensure that profile in class main.User is of type main.Profile.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field profile in class main.User.");
                e.printStackTrace();
                return;
            }

            try {
                Field sentRequests = User.class.getDeclaredField("sentRequests");
                if (sentRequests.getType() != ArrayList.class) {
                    fail("Ensure that sentRequests in class main.User is of type ArrayList.");
                    return;
                }
                if (sentRequests.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that sentRequests in class main.User has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field sentRequests in class main.User " +
                        "that is of type ArrayList and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Field receivedRequests = User.class.getDeclaredField("receivedRequests");
                if (receivedRequests.getType() != ArrayList.class) {
                    fail("Ensure that receivedRequests in class main.User is of type ArrayList.");
                    return;
                }
                if (receivedRequests.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that receivedRequests in class main.User has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field receivedRequests in class main.User " +
                        "that is of type ArrayList and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Field friendList = User.class.getDeclaredField("friendList");
                if (friendList.getType() != ArrayList.class) {
                    fail("Ensure that friendList in class main.User is of type ArrayList.");
                    return;
                }
                if (friendList.getModifiers() != Modifier.PRIVATE) {
                    fail("Ensure that friendList in class main.User has modifier private.");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field friendList in class main.User " +
                        "that is of type ArrayList and is private.");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<User> constructor = User.class.getDeclaredConstructor(String.class, String.class,
                        String.class);
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class main.User is public.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes 3 parameters and is public in class main.User.");
                e.printStackTrace();
                return;
            }

            try {
                Method getFullName = User.class.getDeclaredMethod("getFullName");
                if (getFullName.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getFullName in class main.User is public.");
                    return;
                }
                if (!getFullName.getReturnType().equals(String.class)) {
                    fail("Ensure that your getFullName method in class main.User returns a String.");
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
                    fail("Ensure that your method getUserName in class main.User is public.");
                    return;
                }
                if (!getUserName.getReturnType().equals(String.class)) {
                    fail("Ensure that your getUserName method in class main.User returns a String.");
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
                    fail("Ensure that your method getPassword in class main.User is public.");
                    return;
                }
                if (!getPassword.getReturnType().equals(String.class)) {
                    fail("Ensure that your getPassword method in class main.User returns a String.");
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
                    fail("Ensure that your method getProfile in class main.User is public.");
                    return;
                }
                if (!getProfile.getReturnType().equals(Profile.class)) {
                    fail("Ensure that your getProfile method in class main.User returns a main.Profile.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the getProfile method that is public and returns a main.Profile.");
                e.printStackTrace();
                return;
            }

            try {
                Method getFriendList = User.class.getDeclaredMethod("getFriendList");
                if (getFriendList.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getFriendList in class main.User is public.");
                    return;
                }
                if (!getFriendList.getReturnType().equals(ArrayList.class)) {
                    fail("Ensure that your getFriendList method in class main.User returns an ArrayList.");
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
                    fail("Ensure that your method getSentRequests in class main.User is public.");
                    return;
                }
                if (!getSentRequests.getReturnType().equals(ArrayList.class)) {
                    fail("Ensure that your getSentRequests method in class main.User returns a ArrayList.");
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
                    fail("Ensure that your method getReceivedRequests in class main.User is public.");
                    return;
                }
                if (!getReceivedRequests.getReturnType().equals(ArrayList.class)) {
                    fail("Ensure that your getReceivedRequests method in class main.User returns a ArrayList.");
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
                    fail("Ensure that your method setFullName in class main.User is public.");
                    return;
                }
                if (!setFullName.getReturnType().equals(void.class)) {
                    fail("Ensure that your setFullName method in class main.User returns void.");
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
                    fail("Ensure that your method setUserName in class main.User is public.");
                    return;
                }
                if (!setUserName.getReturnType().equals(void.class)) {
                    fail("Ensure that your setUserName method in class main.User returns void.");
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
                    fail("Ensure that your method setPassword in class main.User is public.");
                    return;
                }
                if (!setPassword.getReturnType().equals(void.class)) {
                    fail("Ensure that your setPassword method in class main.User returns void.");
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
                    fail("Ensure that your method writeUserToFile in class main.User is public.");
                    return;
                }
                if (!writeUserToFile.getReturnType().equals(void.class)) {
                    fail("Ensure that your writeUserToFile method in class main.User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the writeUserToFile method that is public, takes 1 parameter of type main.User and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method sendFriendRequest = User.class.getDeclaredMethod("sendFriendRequest", User.class);
                if (sendFriendRequest.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method sendFriendRequest in class main.User is public.");
                    return;
                }
                if (!sendFriendRequest.getReturnType().equals(void.class)) {
                    fail("Ensure that your sendFriendRequest method in class main.User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the sendFriendRequest method that is public, takes 1 parameter of type main.User and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method removeFriendRequest = User.class.getDeclaredMethod("removeFriendRequest", User.class);
                if (removeFriendRequest.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method removeFriendRequest in class main.User is public.");
                    return;
                }
                if (!removeFriendRequest.getReturnType().equals(void.class)) {
                    fail("Ensure that your removeFriendRequest method in class main.User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the removeFriendRequest method that is public, takes 1 parameter of type main.User and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method addReceivedRequest = User.class.getDeclaredMethod("addReceivedRequest", FriendRequest.class);
                if (addReceivedRequest.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method addReceivedRequest in class main.User is public.");
                    return;
                }
                if (!addReceivedRequest.getReturnType().equals(void.class)) {
                    fail("Ensure that your addReceivedRequest method in class main.User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the addReceivedRequest method that is public, takes 1 parameter of type main.FriendRequest and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method removeReceivedRequest = User.class.getDeclaredMethod("removeReceivedRequest", FriendRequest.class);
                if (removeReceivedRequest.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method removeReceivedRequest in class main.User is public.");
                    return;
                }
                if (!removeReceivedRequest.getReturnType().equals(void.class)) {
                    fail("Ensure that your removeReceivedRequest method in class main.User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the removeReceivedRequest method that is public, takes 1 parameter of type main.FriendRequest and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method acceptFriend = User.class.getDeclaredMethod("acceptFriend", User.class);
                if (acceptFriend.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method acceptFriend in class main.User is public.");
                    return;
                }
                if (!acceptFriend.getReturnType().equals(void.class)) {
                    fail("Ensure that your acceptFriend method in class main.User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the acceptFriend method that is public, takes 1 parameter of type main.User and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method denyFriend = User.class.getDeclaredMethod("denyFriend", User.class);
                if (denyFriend.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method denyFriend in class main.User is public.");
                    return;
                }
                if (!denyFriend.getReturnType().equals(void.class)) {
                    fail("Ensure that your denyFriend method in class main.User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the denyFriend method that is public, takes 1 parameter of type main.User and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method removeFriend = User.class.getDeclaredMethod("removeFriend", User.class);
                if (removeFriend.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method removeFriend in class main.User is public.");
                    return;
                }
                if (!removeFriend.getReturnType().equals(void.class)) {
                    fail("Ensure that your removeFriend method in class main.User returns void.");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the removeFriend method that is public, takes 1 parameter of type main.User and returns void.");
                e.printStackTrace();
                return;
            }

            try {
                Method createProfile = User.class.getDeclaredMethod("createProfile", String.class, String.class);
                if (createProfile.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method createProfile in class main.User is public.");
                    return;
                }
                if (!createProfile.getReturnType().equals(void.class)) {
                    fail("Ensure that your createProfile method in class main.User returns void.");
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
                    fail("Ensure that your method createProfile in class main.User is public.");
                    return;
                }
                if (!createProfile.getReturnType().equals(void.class)) {
                    fail("Ensure that your createProfile method in class main.User returns void.");
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
                    fail("Ensure that your method createProfile in class main.User is public.");
                    return;
                }
                if (!createProfile.getReturnType().equals(void.class)) {
                    fail("Ensure that your createProfile method in class main.User returns void.");
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
                    fail("Ensure that your method createProfile in class main.User is public.");
                    return;
                }
                if (!createProfile.getReturnType().equals(void.class)) {
                    fail("Ensure that your createProfile method in class main.User returns void.");
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
                    fail("Ensure that your method deleteProfile in class main.User is public.");
                    return;
                }
                if (!deleteProfile.getReturnType().equals(void.class)) {
                    fail("Ensure that your deleteProfile method in class main.User returns void.");
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
                Assert.assertEquals("Make sure getFullName() returns the correct field.","fullName",testUser.getFullName());
                Assert.assertEquals("Make sure getUserName() returns the correct field.","userName",testUser.getUserName());
                Assert.assertEquals("Make sure getPassword() returns the correct field.","password",testUser.getPassword());
                Assert.assertEquals("Make sure getProfile() returns the correct field.",null,testUser.getProfile());
                Assert.assertEquals("Make sure getFriendList() returns the correct field.",testEmpty,testUser.getFriendList());
                Assert.assertEquals("Make sure getSentRequests() returns the correct field.",testEmpty,testUser.getSentRequests());
                Assert.assertEquals("Make sure getReceivedRequests() returns the correct field.",testEmpty,testUser.getReceivedRequests());

                testUser.setFullName("fullNameReset");
                testUser.setUserName("userNameReset");
                testUser.setPassword("passwordReset");

                Assert.assertEquals("Make sure setFullName() sets the fullName variable.","fullNameReset",testUser.getFullName());
                Assert.assertEquals("Make sure setUserName() sets the userName variable.","userNameReset",testUser.getUserName());
                Assert.assertEquals("Make sure setPassword() sets the password variable.","passwordReset",testUser.getPassword());

                testUser.writeUserToFile(testUser);

                FileOutputStream fileOutputStream = new FileOutputStream("testFile.txt");
                PrintWriter writer = new PrintWriter(fileOutputStream);
                writer.println(testUser.getUserName() + "," + testUser.getPassword() + "," + testUser.getFullName());
                fileOutputStream.close();
                writer.close();
                assertEquals("Ensure file outputs correct information in writeUserToFile()", new File("testFile.txt"), new File("userListFIle.txt"));
            } catch (Exception e) {
                fail("Error in creating main.User Class: Some fields or methods not functional or present.");
                return;
            }
        }

//        @Test(timeout = 1000)
//        public void testSongDeclarations() {
//            Field[] songFields = Song.class.getDeclaredFields();
//            if (songFields.length < 5) {
//                fail("Ensure that you have implemented all required fields in class Song!");
//                return;
//            }
//
//            try {
//                Field sLength = Song.class.getDeclaredField("songLengthInSeconds");
//                if (!sLength.getType().equals(int.class)) {
//                    fail("Ensure that your field songLengthInSeconds is of type int!");
//                    return;
//                }
//                if (sLength.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
//                    fail("Ensure that your field songLengthInSeconds is private and final!");
//                    return;
//                }
//            } catch (NoSuchFieldException e) {
//                fail("Ensure that you have a field songLengthInSeconds in class Song that is private, final, and is of" +
//                        "type int!");
//                e.printStackTrace();
//            }
//
//            try {
//                Field songName = Song.class.getDeclaredField("songName");
//                if (!songName.getType().equals(String.class)) {
//                    fail("Ensure that your field songName is of type String!");
//                    return;
//                }
//                if (songName.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
//                    fail("Ensure that your field songName is private and final!");
//                    return;
//                }
//            } catch (NoSuchFieldException e) {
//                fail("Ensure that you have a field songName in class Song that is private, final, and is of" +
//                        "type String!");
//                e.printStackTrace();
//            }
//
//            try {
//                Field mainArtist = Song.class.getDeclaredField("mainArtist");
//                if (!mainArtist.getType().equals(Artist.class)) {
//                    fail("Ensure that your field mainArtist is of type Artist!");
//                    return;
//                }
//                if (mainArtist.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
//                    fail("Ensure that your field mainArtist is private and final!");
//                    return;
//                }
//            } catch (NoSuchFieldException e) {
//                fail("Ensure that you have a field mainArtist in class Song that is private, final, and is of" +
//                        "type Artist!");
//                e.printStackTrace();
//            }
//
//            try {
//                Field mainArtist = Song.class.getDeclaredField("accompanyingArtists");
//                if (!mainArtist.getType().equals(Artist[].class)) {
//                    fail("Ensure that your field accompanyingArtists is of type Artist[]!");
//                    return;
//                }
//                if (mainArtist.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
//                    fail("Ensure that your field accompanyingArtists is private and final!");
//                    return;
//                }
//            } catch (NoSuchFieldException e) {
//                fail("Ensure that you have a field accompanyingArtists in class Song that is private, final, and is of" +
//                        "type Artist[]!");
//                e.printStackTrace();
//            }
//
//            try {
//                Field songGenre = Song.class.getDeclaredField("songGenre");
//                if (!songGenre.getType().equals(String.class)) {
//                    fail("Ensure that your field songGenre is of type String!");
//                    return;
//                }
//                if (songGenre.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
//                    fail("Ensure that your field songGenre is private and final!");
//                    return;
//                }
//            } catch (NoSuchFieldException e) {
//                fail("Ensure that you have a field songGenre in class Song that is private, final, and is of" +
//                        "type String!");
//                e.printStackTrace();
//            }
//
//            try {
//                Constructor<Song> songConstructor = Song.class.getDeclaredConstructor(String.class, int.class, String.class,
//                        Artist.class, Artist[].class);
//                if (songConstructor.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your five parameter constructor in class Song is public!");
//                    return;
//                }
//            } catch (NoSuchMethodException e) {
//                fail("Ensure you have a constructor in class Song that is public, and takes 5 parameters - a String, an int," +
//                        "a String, an Artist, and an Artist[]!");
//                e.printStackTrace();
//                return;
//            }
//
//            try {
//                Constructor<Song> songConstructor = Song.class.getDeclaredConstructor(Song.class);
//                if (songConstructor.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your copy constructor in class Song is public!");
//                    return;
//                }
//            } catch (NoSuchMethodException e) {
//                fail("Ensure you have a constructor in class Song that is public, and takes 1 parameter of a Song!");
//                e.printStackTrace();
//                return;
//            }
//
//            try {
//                Constructor<Song> songConstructor = Song.class.getDeclaredConstructor();
//                if (songConstructor.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your default constructor in class Song is public!");
//                    return;
//                }
//            } catch (NoSuchMethodException e) {
//                fail("Ensure you have a constructor in class Song that is public, and takes 0 parameters!");
//                e.printStackTrace();
//                return;
//            }
//
//            try {
//                Method method = Song.class.getDeclaredMethod("getAccompanyingArtists");
//                if (!method.getReturnType().equals(Artist[].class)) {
//                    fail("Ensure that your method getAccompanyingArtists in class Song returns an Artist[]!");
//                    return;
//                }
//
//                if (method.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your method getAccompanyingArtists in class Song is public!");
//                    return;
//                }
//
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a method getAccompanyingArtists in class Song that is public, takes no" +
//                        "parameters, and returns an Artist[]!");
//                e.printStackTrace();
//            }
//
//            try {
//                Method method = Song.class.getDeclaredMethod("getMainArtist");
//                if (!method.getReturnType().equals(Artist.class)) {
//                    fail("Ensure that your method getMainArtist in class Song returns an Artist!");
//                    return;
//                }
//
//                if (method.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your method getMainArtist in class Song is public!");
//                    return;
//                }
//
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a method getMainArtist in class Song that is public, takes no" +
//                        "parameters, and returns an Artist!");
//                e.printStackTrace();
//            }
//
//            try {
//                Method method = Song.class.getDeclaredMethod("getSongLengthInSeconds");
//                if (!method.getReturnType().equals(int.class)) {
//                    fail("Ensure that your method getSongLengthInSeconds in class Song returns an int!");
//                    return;
//                }
//
//                if (method.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your method getSongLengthInSeconds in class Song is public!");
//                    return;
//                }
//
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a method getSongLengthInSeconds in class Song that is public, takes no" +
//                        "parameters, and returns an int!");
//                e.printStackTrace();
//            }
//
//            try {
//                Method method = Song.class.getDeclaredMethod("getSongLengthInMinutesAndSeconds");
//                if (!method.getReturnType().equals(String.class)) {
//                    fail("Ensure that your method getSongLengthInSeconds in class Song returns an String!");
//                    return;
//                }
//
//                if (method.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your method getSongLengthInMinutesAndSeconds in class Song is public!");
//                    return;
//                }
//
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a method getSongLengthInMinutesAndSeconds in class Song that is public, takes no" +
//                        "parameters, and returns a String!");
//                e.printStackTrace();
//            }
//
//            try {
//                Method method = Song.class.getDeclaredMethod("getSongGenre");
//                if (!method.getReturnType().equals(String.class)) {
//                    fail("Ensure that your method getSongGenre in class Song returns an String!");
//                    return;
//                }
//
//                if (method.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your method getSongGenre in class Song is public!");
//                    return;
//                }
//
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a method getSongGenre in class Song that is public, takes no" +
//                        "parameters, and returns a String!");
//                e.printStackTrace();
//            }
//
//            try {
//                Method equals = Song.class.getDeclaredMethod("equals", Object.class);
//                if (!equals.getReturnType().equals(boolean.class)) {
//                    fail("Ensure that your method equals in class Song returns a boolean!");
//                    return;
//                }
//
//                if (equals.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your method equals in class Song is public!");
//                    return;
//                }
//
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a method equals in class Song that is public, takes one" +
//                        "parameter of an Object, and returns a boolean!");
//                e.printStackTrace();
//            }
//
//            try {
//                Method method = Song.class.getDeclaredMethod("getSongName");
//                if (!method.getReturnType().equals(String.class)) {
//                    fail("Ensure that your method getSongName in class Song returns an String!");
//                    return;
//                }
//
//                if (method.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your method getSongName in class Song is public!");
//                    return;
//                }
//
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a method getSongName in class Song that is public, takes no" +
//                        "parameters, and returns a String!");
//                e.printStackTrace();
//            }
//        }
//
//        @Test(timeout = 1000)
//        public void testArtistDeclarations() {
//            Field[] artistFields = Artist.class.getDeclaredFields();
//            if (artistFields.length < 4) {
//                fail("Ensure that you have implemented all required fields in class Artist!");
//                return;
//            }
//
//            try {
//                Field artistName = Artist.class.getDeclaredField("artistName");
//                if (!artistName.getType().equals(String.class)) {
//                    fail("Ensure that your field artistName in class Artist is of type String!");
//                    return;
//                }
//
//                if (artistName.getModifiers() != (Modifier.FINAL + Modifier.PRIVATE)) {
//                    fail("Ensure that your field artistName in class Artist is private and final!");
//                    return;
//                }
//
//            } catch (NoSuchFieldException e) {
//                fail("Ensure that you have the field artistName that is of type String and is private and final in class Artist!");
//                e.printStackTrace();
//            }
//
//            try {
//                Field artistGenre = Artist.class.getDeclaredField("artistGenre");
//                if (!artistGenre.getType().equals(String.class)) {
//                    fail("Ensure that your field artistGenre in class Artist is of type String!");
//                    return;
//                }
//
//                if (artistGenre.getModifiers() != (Modifier.PRIVATE)) {
//                    fail("Ensure that your field artistGenre in class Artist is private!");
//                    return;
//                }
//
//            } catch (NoSuchFieldException e) {
//                fail("Ensure that you have the field artistGenre that is of type String and is private!");
//                e.printStackTrace();
//            }
//
//
//            try {
//                Field songs = Artist.class.getDeclaredField("artistSongs");
//                if (!songs.getType().equals(Song[].class)) {
//                    fail("Ensure that your field artistSongs in class Artist is of type Song[]!");
//                    return;
//                }
//
//                if (songs.getModifiers() != (Modifier.PRIVATE)) {
//                    fail("Ensure that your field artistSongs in class Artist is private!");
//                    return;
//                }
//
//            } catch (NoSuchFieldException e) {
//                fail("Ensure that you have the field artistSongs that is of type Song[] and is private!");
//                e.printStackTrace();
//            }
//
//            try {
//                Field songs = Artist.class.getDeclaredField("appearsOnSongs");
//                if (!songs.getType().equals(Song[].class)) {
//                    fail("Ensure that your field appearsOnSongs in class Artist is of type Song[]!");
//                    return;
//                }
//
//                if (songs.getModifiers() != (Modifier.PRIVATE)) {
//                    fail("Ensure that your field appearsOnSongs in class Artist is private!");
//                    return;
//                }
//
//            } catch (NoSuchFieldException e) {
//                fail("Ensure that you have the field appearsOnSongs that is of type Song[] and is private!");
//                e.printStackTrace();
//            }
//
//            Constructor<?>[] cons = Artist.class.getDeclaredConstructors();
//            if (cons.length != 3) {
//                fail("Be sure to implement all three required constructors in Artist.java!");
//                return;
//            }
//
//            try {
//                Constructor<Artist> cons1 =
//                        Artist.class.getDeclaredConstructor(String.class, String.class);
//                if (cons1.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your two String parameter constructor in Artist is public!");
//                    return;
//                }
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a constructor in class Artist that takes two Strings as parameters!");
//                e.printStackTrace();
//            }
//
//            try {
//                Constructor<Artist> cons1 =
//                        Artist.class.getDeclaredConstructor(Artist.class);
//                if (cons1.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your copy constructor in Artist is public!");
//                    return;
//                }
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a constructor in class Artist that takes an Artist object as a parameter!");
//                e.printStackTrace();
//            }
//
//            try {
//                Constructor<Artist> cons1 =
//                        Artist.class.getDeclaredConstructor(String.class);
//                if (cons1.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your one String parameter constructor in Artist is public!");
//                    return;
//                }
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a constructor in class Artist that takes one Strings as parameters!");
//                e.printStackTrace();
//            }
//
//            try {
//                Method recordOwn = Artist.class.getDeclaredMethod("recordOwnSong", Song.class);
//                if (recordOwn.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your method recordOwnSong in class Artist is public!");
//                    return;
//                }
//                if (!recordOwn.getReturnType().equals(void.class)) {
//                    fail("Ensure that your method recordOwnSong in class Artist returns nothing (void)!");
//                    return;
//                }
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a method recordOwnSong in class Artist that is public, " +
//                        "takes a single parameter of a Song object, and returns nothing (void)!");
//                e.printStackTrace();
//            }
//
//            try {
//                Method recordFeat = Artist.class.getDeclaredMethod("recordFeaturedSong", Song.class);
//                if (recordFeat.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your method recordFeaturedSong in class Artist is public!");
//                    return;
//                }
//                if (!recordFeat.getReturnType().equals(void.class)) {
//                    fail("Ensure that your method recordFeaturedSong in class Artist returns nothing (void)!");
//                    return;
//                }
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a method recordFeaturedSong in class Artist that is public, " +
//                        "takes a single parameter of a Song object, and returns nothing (void)!");
//                e.printStackTrace();
//            }
//
//            try {
//                Method calculateArtistGenre = Artist.class.getDeclaredMethod("calculateArtistGenre");
//                if (calculateArtistGenre.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your method calculateArtistGenre in class Artist is public!");
//                    return;
//                }
//                if (!calculateArtistGenre.getReturnType().equals(void.class)) {
//                    fail("Ensure that your method calculateArtistGenre in class Artist returns nothing (void)!");
//                    return;
//                }
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a method calculateArtistGenre in class Artist that is public, " +
//                        "takes no parameters, and returns nothing (void)!");
//                e.printStackTrace();
//            }
//
//            try {
//                Method equals = Artist.class.getDeclaredMethod("equals", Object.class);
//                if (equals.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your method equals in class Artist is public!");
//                    return;
//                }
//                if (!equals.getReturnType().equals(boolean.class)) {
//                    fail("Ensure that your method equals in class Artist returns a boolean!");
//                    return;
//                }
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a method equals in class Artist that is public, " +
//                        "takes one parameter of an Object, and returns a boolean!");
//                e.printStackTrace();
//            }
//
//            try {
//                Method get = Artist.class.getDeclaredMethod("getAppearsOnSongs");
//                if (get.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your method getAppearsOnSongs in class Artist is public!");
//                    return;
//                }
//                if (!get.getReturnType().equals(Song[].class)) {
//                    fail("Ensure that your method getAppearsOnSongs in class Artist returns a Song[]!");
//                    return;
//                }
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a method getAppearsOnSongs in class Artist that is public, " +
//                        "takes no parameters and returns a Song[]!");
//                e.printStackTrace();
//            }
//
//            try {
//                Method get = Artist.class.getDeclaredMethod("getArtistGenre");
//                if (get.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your method getArtistGenre in class Artist is public!");
//                    return;
//                }
//                if (!get.getReturnType().equals(String.class)) {
//                    fail("Ensure that your method getArtistGenre in class Artist returns a String!");
//                    return;
//                }
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a method getArtistGenre in class Artist that is public, " +
//                        "takes no parameters and returns a String!");
//                e.printStackTrace();
//            }
//
//            try {
//                Method get = Artist.class.getDeclaredMethod("getArtistName");
//                if (get.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your method getArtistName in class Artist is public!");
//                    return;
//                }
//                if (!get.getReturnType().equals(String.class)) {
//                    fail("Ensure that your method getArtistName in class Artist returns a String!");
//                    return;
//                }
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a method getArtistName in class Artist that is public, " +
//                        "takes no parameters and returns a String!");
//                e.printStackTrace();
//            }
//
//            try {
//                Method get = Artist.class.getDeclaredMethod("getArtistSongs");
//                if (get.getModifiers() != Modifier.PUBLIC) {
//                    fail("Ensure that your method getArtistSongs in class Artist is public!");
//                    return;
//                }
//                if (!get.getReturnType().equals(Song[].class)) {
//                    fail("Ensure that your method getArtistSongs in class Artist returns a Song[]!");
//                    return;
//                }
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a method getArtistSongs in class Artist that is public, " +
//                        "takes no parameters and returns a Song[]!");
//                e.printStackTrace();
//            }
//        }
//
//        @Test(timeout = 1000)
//        public void testExceptionDeclarations(){
//            try {
//                Constructor<InvalidSongFormatException> cons1 = InvalidSongFormatException.class.getDeclaredConstructor();
//                if(cons1.getModifiers() != Modifier.PUBLIC){
//                    fail("Ensure that your no parameter constructor in class InvalidSongFormatException is public!");
//                    return;
//                }
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a no parameter constructor in class InvalidSongFormatException!");
//                e.printStackTrace();
//            }
//
//            try {
//                Constructor<InvalidSongFormatException> cons1 = InvalidSongFormatException.class.getDeclaredConstructor(String.class);
//                if(cons1.getModifiers() != Modifier.PUBLIC){
//                    fail("Ensure that your one parameter constructor in class InvalidSongFormatException is public!");
//                    return;
//                }
//            } catch (NoSuchMethodException e) {
//                fail("Ensure that you have a one parameter constructor, that has a String as its parameter," +
//                        " in class InvalidSongFormatException!");
//                e.printStackTrace();
//            }
//        }

    }
}