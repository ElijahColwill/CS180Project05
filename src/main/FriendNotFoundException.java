package main;

/**
 * FriendNotFoundException exception to handle errors in friend request system.
 *
 * <p>Purdue University -- CS18000 -- Fall 2020 -- Project 05</p>
 *
 * @author Elijah Colwill
 * @version December 01, 2020
 */
public class FriendNotFoundException extends Exception {

    /**
     * No parameter Constructor that references super constructor of exception class.
     */
    public FriendNotFoundException() {
        super();
    }

    /**
     * Constructor with message that references super constructor of exception class.
     * @param message String of custom error message.
     */
    public FriendNotFoundException(String message) {
        super(message);
    }
}
