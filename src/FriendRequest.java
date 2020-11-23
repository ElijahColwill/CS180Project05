public class FriendRequest {
    private User sender;
    private User recipient;

    public FriendRequest(User sender, User recipient) {
        this.sender = sender;
        this.recipient = recipient;
        try {
            recipient.addReceivedRequest(this);
        } catch (FriendNotFoundException e) {
            e.getMessage();
        }
    }

    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }

}
