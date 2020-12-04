
/**
 * FriendRequest class that stores the sender and recipient user of request
 * to make managing request lists in User classes easier.
 *
 * <p>Purdue University -- CS18000 -- Fall 2020 -- Project 05</p>
 *
 * @author Elijah Colwill
 * @version December 01, 2020
 */
public class FriendRequest {
    private User sender;
    private User recipient;

    /**
     * Constructor that creates instance of FriendRequest class.
     * @param sender User that sent the request.
     * @param recipient User receiving the request.
     */
    public FriendRequest(User sender, User recipient) {
        this.sender = sender;
        this.recipient = recipient;
        try {
            recipient.addReceivedRequest(this);
        } catch (FriendNotFoundException e) {
            e.getMessage();
        }
    }

    /**
     * Accessor method for sender.
     * @return sender User that sent the request.
     */
    public User getSender() {
        return sender;
    }

    /**
     * Accessor method for recipient.
     * @return recipient User receiving the request.
     */
    public User getRecipient() {
        return recipient;
    }

}
