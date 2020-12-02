import org.junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import static org.junit.Assert.fail;

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

        @Test(timeout = 1000)
        public void testMusicAnalyzerDeclarations() {
            Field[] fields = MusicAnalyzer.class.getDeclaredFields();
            if (fields.length < 3) {
                fail("Ensure that you have implemented the three required fields!");
                return;
            }

            try {
                Field artistArray = MusicAnalyzer.class.getDeclaredField("artists");
                if (artistArray.getType() != Artist[].class) {
                    fail("Ensure that your field artists in class MusicAnalyzer is of type Artist[]!");
                    return;
                }
                if (artistArray.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
                    fail("Ensure that your field artists in class MusicAnalyzer is private and static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field artists in class MusicAnalyzer " +
                        "that is of type Artist[], is private, and static!");
                e.printStackTrace();
                return;
            }

            try {
                Field songArray = MusicAnalyzer.class.getDeclaredField("songs");
                if (songArray.getType() != Song[].class) {
                    fail("Ensure that your field songs in class MusicAnalyzer is of type Artist[]!");
                    return;
                }
                if (songArray.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
                    fail("Ensure that your field songs in class MusicAnalyzer is private and static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field songs in class MusicAnalyzer " +
                        "that is of type Song[], is private, and static!");
                e.printStackTrace();
                return;
            }

            try {
                Field musicAnalyzer = MusicAnalyzer.class.getDeclaredField("musicAnalyzer");
                if (musicAnalyzer.getType() != MusicAnalyzer.class) {
                    fail("Ensure that your field musicAnalyzer in class MusicAnalyzer is of type MusicAnalyzer!");
                    return;
                }
                if (musicAnalyzer.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
                    fail("Ensure that your field musicAnalyzer in class MusicAnalyzer is private and static!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field musicAnalyzer in class MusicAnalyzer " +
                        "that is of type musicAnalyzer, is private, and static!");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<MusicAnalyzer> constructor = MusicAnalyzer.class.getDeclaredConstructor();
                if (constructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your constructor in class MusicAnalyzer is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor that takes no parameters and is public in class MusicAnalyzer!");
                e.printStackTrace();
                return;
            }

            try {
                Method showMenu = MusicAnalyzer.class.getDeclaredMethod("showMenu");
                if (showMenu.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method showMenu in class MusicAnalyzer is public and static!");
                    return;
                }
                if (!showMenu.getReturnType().equals(void.class)) {
                    fail("Ensure that your showMenu method in class MusicAnalyzer returns nothing (void)!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have the showMenu method from the starter code in class MusicAnalyzer!");
                e.printStackTrace();
                return;
            }

            try {
                Method initMethod = MusicAnalyzer.class.getDeclaredMethod("performInitialization", Scanner.class);
                if (!initMethod.getReturnType().equals(void.class)) {
                    fail("Ensure that your method performInitialization in class MusicAnalyzer returns nothing (void)!");
                    return;
                }
                if (initMethod.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method performInitialization in class MusicAnalyzer is public and static!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method performInitialization in class MusicAnalyzer that is public, static, " +
                        "returns nothing (void) and takes one parameter of a Scanner object!");
                e.printStackTrace();
                return;
            }

            try {
                Method processFile = MusicAnalyzer.class.getDeclaredMethod("processFile", String.class);
                if (!processFile.getReturnType().equals(void.class)) {
                    fail("Ensure that your method processFile in class MusicAnalyzer returns nothing (void)!");
                    return;
                }
                if (processFile.getModifiers() != Modifier.PUBLIC + Modifier.STATIC) {
                    fail("Ensure that your method processFile in class MusicAnalyzer is public and static!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method processFile in class MusicAnalyzer that is public, static, " +
                        "returns nothing (void), and takes one parameter of a String!");
                e.printStackTrace();
                return;
            }

            try {
                Method addArtist = MusicAnalyzer.class.getDeclaredMethod("addArtist", Artist.class);
                if (addArtist.getReturnType() != int.class) {
                    fail("Ensure that your method addArtist in class MusicAnalyzer returns an int!");
                    return;
                }
                if (addArtist.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method addArtist in class MusicAnalyzer is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method addArtist in class MusicAnalyzer that is public, returns" +
                        "an int, and has one parameter of an Artist!");
                e.printStackTrace();
                return;
            }

            try {
                Method addSong = MusicAnalyzer.class.getDeclaredMethod("addSong", Song.class);
                if (addSong.getReturnType() != void.class) {
                    fail("Ensure that your method addSong in class MusicAnalyzer returns nothing (void)!");
                    return;
                }
                if (addSong.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method addSong in class MusicAnalyzer is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method addSong in class MusicAnalyzer that is public, returns" +
                        "nothing (void), and has one parameter of a Song!");
                e.printStackTrace();
                return;
            }

            try {
                Method listSongsByArtist = MusicAnalyzer.class.getDeclaredMethod("listSongsByArtist", String.class);
                if (listSongsByArtist.getReturnType() != void.class) {
                    fail("Ensure that your method listSongsByArtist in class MusicAnalyzer returns nothing (void)!");
                    return;
                }
                if (listSongsByArtist.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method listSongsByArtist in class MusicAnalyzer is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method listSongsByArtist in class MusicAnalyzer that is public, returns" +
                        "nothing (void), and has one parameter of a String!");
                e.printStackTrace();
                return;
            }

            try {
                Method listFeaturesOnSong = MusicAnalyzer.class.getDeclaredMethod("listFeaturesOnSong", String.class);
                if (listFeaturesOnSong.getReturnType() != void.class) {
                    fail("Ensure that your method listFeaturesOnSong in class MusicAnalyzer returns nothing (void)!");
                    return;
                }
                if (listFeaturesOnSong.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method listFeaturesOnSong in class MusicAnalyzer is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method listFeaturesOnSong in class MusicAnalyzer that is public, returns" +
                        "nothing (void), and has one parameter of a String!");
                e.printStackTrace();
                return;
            }

            try {
                Method findMainArtistOnSong = MusicAnalyzer.class.getDeclaredMethod("findMainArtistOnSong", String.class);
                if (findMainArtistOnSong.getReturnType() != void.class) {
                    fail("Ensure that your method findMainArtistOnSong in class MusicAnalyzer returns nothing (void)!");
                    return;
                }
                if (findMainArtistOnSong.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method findMainArtistOnSong in class MusicAnalyzer is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method findMainArtistOnSong in class MusicAnalyzer that is public, returns" +
                        "nothing (void), and has one parameter of a String!");
                e.printStackTrace();
                return;
            }

            try {
                Method countSongsByArtist = MusicAnalyzer.class.getDeclaredMethod("countSongsByArtist", String.class);
                if (countSongsByArtist.getReturnType() != void.class) {
                    fail("Ensure that your method countSongsByArtist in class MusicAnalyzer returns nothing (void)!");
                    return;
                }
                if (countSongsByArtist.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method countSongsByArtist in class MusicAnalyzer is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method countSongsByArtist in class MusicAnalyzer that is public, returns" +
                        "nothing (void), and has one parameter of a String!");
                e.printStackTrace();
                return;
            }

            try {
                Method findSongLength = MusicAnalyzer.class.getDeclaredMethod("findSongLength", String.class);
                if (findSongLength.getReturnType() != void.class) {
                    fail("Ensure that your method findSongLength in class MusicAnalyzer returns nothing (void)!");
                    return;
                }
                if (findSongLength.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method findSongLength in class MusicAnalyzer is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method findSongLength in class MusicAnalyzer that is public, returns" +
                        "nothing (void), and has one parameter of a String!");
                e.printStackTrace();
                return;
            }

            try {
                Method findArtistGenre = MusicAnalyzer.class.getDeclaredMethod("findArtistGenre", String.class);
                if (findArtistGenre.getReturnType() != void.class) {
                    fail("Ensure that your method findArtistGenre in class MusicAnalyzer returns nothing (void)!");
                    return;
                }
                if (findArtistGenre.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method findArtistGenre in class MusicAnalyzer is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method findArtistGenre in class MusicAnalyzer that is public, returns" +
                        "nothing (void), and has one parameter of a String!");
                e.printStackTrace();
                return;
            }

            try {
                Method findArtistsAndFeatures = MusicAnalyzer.class.getDeclaredMethod("findArtistsAndFeatures",
                        String.class, String[].class);
                if (findArtistsAndFeatures.getReturnType() != void.class) {
                    fail("Ensure that your method findArtistsAndFeatures in class MusicAnalyzer returns nothing (void)!");
                    return;
                }
                if (findArtistsAndFeatures.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method findArtistsAndFeatures in class MusicAnalyzer is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method findArtistsAndFeatures in class MusicAnalyzer that is public, returns" +
                        "nothing (void), and has two parameters of a String and String[]!");
                e.printStackTrace();
                return;
            }

            try {
                Method exportByArtist = MusicAnalyzer.class.getDeclaredMethod("exportByArtist", Scanner.class, String.class);
                if (exportByArtist.getReturnType() != void.class) {
                    fail("Ensure that your method exportByArtist in class MusicAnalyzer returns nothing (void)!");
                    return;
                }
                if (exportByArtist.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method exportByArtist in class MusicAnalyzer is public!");
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method exportByArtist in class MusicAnalyzer that is public, returns" +
                        "nothing (void), and has two parameters of a Scanner and a String!");
                e.printStackTrace();
            }
        }

        @Test(timeout = 1000)
        public void testSongDeclarations() {
            Field[] songFields = Song.class.getDeclaredFields();
            if (songFields.length < 5) {
                fail("Ensure that you have implemented all required fields in class Song!");
                return;
            }

            try {
                Field sLength = Song.class.getDeclaredField("songLengthInSeconds");
                if (!sLength.getType().equals(int.class)) {
                    fail("Ensure that your field songLengthInSeconds is of type int!");
                    return;
                }
                if (sLength.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                    fail("Ensure that your field songLengthInSeconds is private and final!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field songLengthInSeconds in class Song that is private, final, and is of" +
                        "type int!");
                e.printStackTrace();
            }

            try {
                Field songName = Song.class.getDeclaredField("songName");
                if (!songName.getType().equals(String.class)) {
                    fail("Ensure that your field songName is of type String!");
                    return;
                }
                if (songName.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                    fail("Ensure that your field songName is private and final!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field songName in class Song that is private, final, and is of" +
                        "type String!");
                e.printStackTrace();
            }

            try {
                Field mainArtist = Song.class.getDeclaredField("mainArtist");
                if (!mainArtist.getType().equals(Artist.class)) {
                    fail("Ensure that your field mainArtist is of type Artist!");
                    return;
                }
                if (mainArtist.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                    fail("Ensure that your field mainArtist is private and final!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field mainArtist in class Song that is private, final, and is of" +
                        "type Artist!");
                e.printStackTrace();
            }

            try {
                Field mainArtist = Song.class.getDeclaredField("accompanyingArtists");
                if (!mainArtist.getType().equals(Artist[].class)) {
                    fail("Ensure that your field accompanyingArtists is of type Artist[]!");
                    return;
                }
                if (mainArtist.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                    fail("Ensure that your field accompanyingArtists is private and final!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field accompanyingArtists in class Song that is private, final, and is of" +
                        "type Artist[]!");
                e.printStackTrace();
            }

            try {
                Field songGenre = Song.class.getDeclaredField("songGenre");
                if (!songGenre.getType().equals(String.class)) {
                    fail("Ensure that your field songGenre is of type String!");
                    return;
                }
                if (songGenre.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
                    fail("Ensure that your field songGenre is private and final!");
                    return;
                }
            } catch (NoSuchFieldException e) {
                fail("Ensure that you have a field songGenre in class Song that is private, final, and is of" +
                        "type String!");
                e.printStackTrace();
            }

            try {
                Constructor<Song> songConstructor = Song.class.getDeclaredConstructor(String.class, int.class, String.class,
                        Artist.class, Artist[].class);
                if (songConstructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your five parameter constructor in class Song is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure you have a constructor in class Song that is public, and takes 5 parameters - a String, an int," +
                        "a String, an Artist, and an Artist[]!");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<Song> songConstructor = Song.class.getDeclaredConstructor(Song.class);
                if (songConstructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your copy constructor in class Song is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure you have a constructor in class Song that is public, and takes 1 parameter of a Song!");
                e.printStackTrace();
                return;
            }

            try {
                Constructor<Song> songConstructor = Song.class.getDeclaredConstructor();
                if (songConstructor.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your default constructor in class Song is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure you have a constructor in class Song that is public, and takes 0 parameters!");
                e.printStackTrace();
                return;
            }

            try {
                Method method = Song.class.getDeclaredMethod("getAccompanyingArtists");
                if (!method.getReturnType().equals(Artist[].class)) {
                    fail("Ensure that your method getAccompanyingArtists in class Song returns an Artist[]!");
                    return;
                }

                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getAccompanyingArtists in class Song is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getAccompanyingArtists in class Song that is public, takes no" +
                        "parameters, and returns an Artist[]!");
                e.printStackTrace();
            }

            try {
                Method method = Song.class.getDeclaredMethod("getMainArtist");
                if (!method.getReturnType().equals(Artist.class)) {
                    fail("Ensure that your method getMainArtist in class Song returns an Artist!");
                    return;
                }

                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getMainArtist in class Song is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getMainArtist in class Song that is public, takes no" +
                        "parameters, and returns an Artist!");
                e.printStackTrace();
            }

            try {
                Method method = Song.class.getDeclaredMethod("getSongLengthInSeconds");
                if (!method.getReturnType().equals(int.class)) {
                    fail("Ensure that your method getSongLengthInSeconds in class Song returns an int!");
                    return;
                }

                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getSongLengthInSeconds in class Song is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getSongLengthInSeconds in class Song that is public, takes no" +
                        "parameters, and returns an int!");
                e.printStackTrace();
            }

            try {
                Method method = Song.class.getDeclaredMethod("getSongLengthInMinutesAndSeconds");
                if (!method.getReturnType().equals(String.class)) {
                    fail("Ensure that your method getSongLengthInSeconds in class Song returns an String!");
                    return;
                }

                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getSongLengthInMinutesAndSeconds in class Song is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getSongLengthInMinutesAndSeconds in class Song that is public, takes no" +
                        "parameters, and returns a String!");
                e.printStackTrace();
            }

            try {
                Method method = Song.class.getDeclaredMethod("getSongGenre");
                if (!method.getReturnType().equals(String.class)) {
                    fail("Ensure that your method getSongGenre in class Song returns an String!");
                    return;
                }

                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getSongGenre in class Song is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getSongGenre in class Song that is public, takes no" +
                        "parameters, and returns a String!");
                e.printStackTrace();
            }

            try {
                Method equals = Song.class.getDeclaredMethod("equals", Object.class);
                if (!equals.getReturnType().equals(boolean.class)) {
                    fail("Ensure that your method equals in class Song returns a boolean!");
                    return;
                }

                if (equals.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method equals in class Song is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method equals in class Song that is public, takes one" +
                        "parameter of an Object, and returns a boolean!");
                e.printStackTrace();
            }

            try {
                Method method = Song.class.getDeclaredMethod("getSongName");
                if (!method.getReturnType().equals(String.class)) {
                    fail("Ensure that your method getSongName in class Song returns an String!");
                    return;
                }

                if (method.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getSongName in class Song is public!");
                    return;
                }

            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getSongName in class Song that is public, takes no" +
                        "parameters, and returns a String!");
                e.printStackTrace();
            }
        }

        @Test(timeout = 1000)
        public void testArtistDeclarations() {
            Field[] artistFields = Artist.class.getDeclaredFields();
            if (artistFields.length < 4) {
                fail("Ensure that you have implemented all required fields in class Artist!");
                return;
            }

            try {
                Field artistName = Artist.class.getDeclaredField("artistName");
                if (!artistName.getType().equals(String.class)) {
                    fail("Ensure that your field artistName in class Artist is of type String!");
                    return;
                }

                if (artistName.getModifiers() != (Modifier.FINAL + Modifier.PRIVATE)) {
                    fail("Ensure that your field artistName in class Artist is private and final!");
                    return;
                }

            } catch (NoSuchFieldException e) {
                fail("Ensure that you have the field artistName that is of type String and is private and final in class Artist!");
                e.printStackTrace();
            }

            try {
                Field artistGenre = Artist.class.getDeclaredField("artistGenre");
                if (!artistGenre.getType().equals(String.class)) {
                    fail("Ensure that your field artistGenre in class Artist is of type String!");
                    return;
                }

                if (artistGenre.getModifiers() != (Modifier.PRIVATE)) {
                    fail("Ensure that your field artistGenre in class Artist is private!");
                    return;
                }

            } catch (NoSuchFieldException e) {
                fail("Ensure that you have the field artistGenre that is of type String and is private!");
                e.printStackTrace();
            }


            try {
                Field songs = Artist.class.getDeclaredField("artistSongs");
                if (!songs.getType().equals(Song[].class)) {
                    fail("Ensure that your field artistSongs in class Artist is of type Song[]!");
                    return;
                }

                if (songs.getModifiers() != (Modifier.PRIVATE)) {
                    fail("Ensure that your field artistSongs in class Artist is private!");
                    return;
                }

            } catch (NoSuchFieldException e) {
                fail("Ensure that you have the field artistSongs that is of type Song[] and is private!");
                e.printStackTrace();
            }

            try {
                Field songs = Artist.class.getDeclaredField("appearsOnSongs");
                if (!songs.getType().equals(Song[].class)) {
                    fail("Ensure that your field appearsOnSongs in class Artist is of type Song[]!");
                    return;
                }

                if (songs.getModifiers() != (Modifier.PRIVATE)) {
                    fail("Ensure that your field appearsOnSongs in class Artist is private!");
                    return;
                }

            } catch (NoSuchFieldException e) {
                fail("Ensure that you have the field appearsOnSongs that is of type Song[] and is private!");
                e.printStackTrace();
            }

            Constructor<?>[] cons = Artist.class.getDeclaredConstructors();
            if (cons.length != 3) {
                fail("Be sure to implement all three required constructors in Artist.java!");
                return;
            }

            try {
                Constructor<Artist> cons1 =
                        Artist.class.getDeclaredConstructor(String.class, String.class);
                if (cons1.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your two String parameter constructor in Artist is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor in class Artist that takes two Strings as parameters!");
                e.printStackTrace();
            }

            try {
                Constructor<Artist> cons1 =
                        Artist.class.getDeclaredConstructor(Artist.class);
                if (cons1.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your copy constructor in Artist is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor in class Artist that takes an Artist object as a parameter!");
                e.printStackTrace();
            }

            try {
                Constructor<Artist> cons1 =
                        Artist.class.getDeclaredConstructor(String.class);
                if (cons1.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your one String parameter constructor in Artist is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a constructor in class Artist that takes one Strings as parameters!");
                e.printStackTrace();
            }

            try {
                Method recordOwn = Artist.class.getDeclaredMethod("recordOwnSong", Song.class);
                if (recordOwn.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method recordOwnSong in class Artist is public!");
                    return;
                }
                if (!recordOwn.getReturnType().equals(void.class)) {
                    fail("Ensure that your method recordOwnSong in class Artist returns nothing (void)!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method recordOwnSong in class Artist that is public, " +
                        "takes a single parameter of a Song object, and returns nothing (void)!");
                e.printStackTrace();
            }

            try {
                Method recordFeat = Artist.class.getDeclaredMethod("recordFeaturedSong", Song.class);
                if (recordFeat.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method recordFeaturedSong in class Artist is public!");
                    return;
                }
                if (!recordFeat.getReturnType().equals(void.class)) {
                    fail("Ensure that your method recordFeaturedSong in class Artist returns nothing (void)!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method recordFeaturedSong in class Artist that is public, " +
                        "takes a single parameter of a Song object, and returns nothing (void)!");
                e.printStackTrace();
            }

            try {
                Method calculateArtistGenre = Artist.class.getDeclaredMethod("calculateArtistGenre");
                if (calculateArtistGenre.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method calculateArtistGenre in class Artist is public!");
                    return;
                }
                if (!calculateArtistGenre.getReturnType().equals(void.class)) {
                    fail("Ensure that your method calculateArtistGenre in class Artist returns nothing (void)!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method calculateArtistGenre in class Artist that is public, " +
                        "takes no parameters, and returns nothing (void)!");
                e.printStackTrace();
            }

            try {
                Method equals = Artist.class.getDeclaredMethod("equals", Object.class);
                if (equals.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method equals in class Artist is public!");
                    return;
                }
                if (!equals.getReturnType().equals(boolean.class)) {
                    fail("Ensure that your method equals in class Artist returns a boolean!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method equals in class Artist that is public, " +
                        "takes one parameter of an Object, and returns a boolean!");
                e.printStackTrace();
            }

            try {
                Method get = Artist.class.getDeclaredMethod("getAppearsOnSongs");
                if (get.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getAppearsOnSongs in class Artist is public!");
                    return;
                }
                if (!get.getReturnType().equals(Song[].class)) {
                    fail("Ensure that your method getAppearsOnSongs in class Artist returns a Song[]!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getAppearsOnSongs in class Artist that is public, " +
                        "takes no parameters and returns a Song[]!");
                e.printStackTrace();
            }

            try {
                Method get = Artist.class.getDeclaredMethod("getArtistGenre");
                if (get.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getArtistGenre in class Artist is public!");
                    return;
                }
                if (!get.getReturnType().equals(String.class)) {
                    fail("Ensure that your method getArtistGenre in class Artist returns a String!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getArtistGenre in class Artist that is public, " +
                        "takes no parameters and returns a String!");
                e.printStackTrace();
            }

            try {
                Method get = Artist.class.getDeclaredMethod("getArtistName");
                if (get.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getArtistName in class Artist is public!");
                    return;
                }
                if (!get.getReturnType().equals(String.class)) {
                    fail("Ensure that your method getArtistName in class Artist returns a String!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getArtistName in class Artist that is public, " +
                        "takes no parameters and returns a String!");
                e.printStackTrace();
            }

            try {
                Method get = Artist.class.getDeclaredMethod("getArtistSongs");
                if (get.getModifiers() != Modifier.PUBLIC) {
                    fail("Ensure that your method getArtistSongs in class Artist is public!");
                    return;
                }
                if (!get.getReturnType().equals(Song[].class)) {
                    fail("Ensure that your method getArtistSongs in class Artist returns a Song[]!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a method getArtistSongs in class Artist that is public, " +
                        "takes no parameters and returns a Song[]!");
                e.printStackTrace();
            }
        }

        @Test(timeout = 1000)
        public void testExceptionDeclarations(){
            try {
                Constructor<InvalidSongFormatException> cons1 = InvalidSongFormatException.class.getDeclaredConstructor();
                if(cons1.getModifiers() != Modifier.PUBLIC){
                    fail("Ensure that your no parameter constructor in class InvalidSongFormatException is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a no parameter constructor in class InvalidSongFormatException!");
                e.printStackTrace();
            }

            try {
                Constructor<InvalidSongFormatException> cons1 = InvalidSongFormatException.class.getDeclaredConstructor(String.class);
                if(cons1.getModifiers() != Modifier.PUBLIC){
                    fail("Ensure that your one parameter constructor in class InvalidSongFormatException is public!");
                    return;
                }
            } catch (NoSuchMethodException e) {
                fail("Ensure that you have a one parameter constructor, that has a String as its parameter," +
                        " in class InvalidSongFormatException!");
                e.printStackTrace();
            }
        }

    }
}