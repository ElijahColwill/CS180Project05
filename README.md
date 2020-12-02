# CS 180 Project 5 - Social Network (Option 2)
## Elijah Colwill, Henrik Berg, Henry Peng, Kevin Choe, Sindhuja Kancharla

## Introduction
This project implements Option 2 Specified by the Project 5 Requirements for CS 18000 - Fall 2020 at Purdue University.  
The project centers around creating a social network with users creating Profiles displaying information such as contact information and  
hobbies and interests, as well as a Friends system with the capacity to send, view, and accept/deny requests.  
**Notable Features Include:**  
- Implementation of Network I/O by allowing multiple users to connect to a server and preserving a user's data after they log off.
- Ability to create, edit and delete Users and Profiles. A User can only edit their own Profile.
- Implementation of GUI for all user interactions and error handling.
- Implementation of Concurrency in the Server to handle multiple users.
- Friend Request System between users with the abiity to view Friends List, and send/recieve/view/accept/deny requests.

## Documentation
Documentation in the README includes a description of each class (Abridged documentation found in the class Javadocs) and details on testing preformed.

## Class Descriptions

### User Class
Description:  
A User class that creates a user based on sign up parameters and allows the creation and deletion  
of a Profile along with management of a Friends list and sent and received friends Requests.

Authors:  
Elijah Colwill

Methods:
- User()
  - Constructor that creates user class with Sign Up Information.
  - Parameters:
    - fullName String that holds name of person creating User.
    - userName String that holds username of user being created.
    - password String that holds password of user being created.
- getFullName()
  - Accessor method for fullName.
  - Return:
    - fullName String that holds name of person creating User.
- getUserName()
  - Accessor method for userName.
  - Return:
    - userName String that holds username of user being created.
- getPassword()
  - Accessor method for password.
  - Return:
    - password String that holds password of user being created.
- getProfile()
  - Accessor method for profile.
  - Return:
    - profile Profile object that holds information for a User's profile.
- getFriendList()
  - Accessor method for friendList.
  - Return:
    - friendList ArrayList that holds friends of the User.
- getSentRequests()
  - Accessor method for sentRequests.
  - Return:
    - receivedRequests ArrayList that holds friend requests that the User has received.
- setFUllName()
  - Mutator method for fullName.
  - Parameters:
    - fullName String that holds name of person creating User.
- setUserName()
  - Mutator method for userName.
  - Parameters:
    - userName String that holds username of user being created.
- setPassword()
  - Mutator method for password.
  - Parameters:
    - password String that holds password of user being created.
- writeUserToFile()
  - This method writes the user details to a file for storing this data.
  - Parameters:
    - user User object whose data is being stored.
- sendFriendRequest()
  - Method that sends a friend request object to the user specified.
  - Parameters:
    - user User object that is being sent a friend request.
- removeFriendRequest()
  - Method that revokes a sent request to the User specified.
  - Parameters:
    - user User object that is no longer being sent a friend request.
- addReceivedRequest()
  - Method that receives a friend request and adds it to pending requests.
  - Parameters:
    - request FriendRequest that holds the sender and recipient users.
- removeReceivedRequest()
  - Method that removes a friend request that is pending action from user.
  - Parameters:
    - request FriendRequest that holds the sender and recipient users.
- acceptFriend()
  - Method that accepts a pending friend request and changes appropriate arrays. Adds friend to friendList.
  - Parameters:
    - user User that is being accepted from pending received requests.
- denyFriend()
  - Method that denies a pending friend request and changes appropriate arrays.
  - Parameters:
    - user User that is being denied from pending received requests.
- removeFriend()
  - Method that removes a friend from friendList.
  - Parameters:
    - user User that is being removes from User's friends.
- createProfile()
  - Method that creates the User's profile based on given parameters, the Username and Friends List.
  - Parameters:
    - bio String that holds biography of User.
    - email String that holds email address of User.
- createProfile()
  - Method that creates the User's profile based on given parameters, the Username and Friends List.
  - Parameters:
    - bio String that holds biography of User.
    - email String that holds email address of User.
    - location String that holds location of User.
- createProfile()
  - Method that creates the User's profile based on given parameters, the Username and Friends List.
  - Parameters:
    - bio String that holds biography of User.
    - email String that holds email address of User.
    - location String that holds location of User.
    - interests String that holds interests/hobbies of User.
- createProfile()
  - Method that creates the User's profile based on given parameters, the Username and Friends List.
  - Parameters:
    - bio String that holds biography of User.
    - email String that holds email address of User.
    - location String that holds location of User.
    - interests String that holds interests/hobbies of User.
    - phoneNum int that holds Phone Number of User.
- deleteProfile()
  - Method that deletes the User's profile and information.
    
Testing:
- Test that User class exists and inherits Object superclass.
- Fields were checked with JUnit tests to check for the following:
  - Field Exits
  - Correct Field Type
  - Correct Access Modifier
- Methods were checked with JUnit tests to check for the following:
  - Method Exists
  - Correct Method Type
  - Correct Access Modifies
  - Implementation Tests: Valid and Invalid Input

### Profile Class
Description:
A Profile Class that handled the creation of a User's profile and stores the information
for retrieval by the user or application.

Authors:  
Elijah Colwill 

Methods:
- Profile()
  - Constructor that creates Profile class with minimum required information.
  - Parameters:
    - owner String that holds the userName of the user who owns the profile.
    - bio String that holds biography of profile.
    - email String that holds email of user creating profile.
    - friendList ArrayList that contains the User's list of friends.
- Profile()
  - Constructor that creates Profile class with minimum required information  
  and a location.
  - Parameters:
    - owner String that holds the userName of the user who owns the profile.
    - bio String that holds biography of profile.
    - email String that holds email of user creating profile.
    - friendList ArrayList that contains the User's list of friends.
    - location String that holds location of user creating profile.
- Profile()
  - Constructor that creates Profile class with minimum required information  
  and a location and interests section.
  - Parameters:
    - owner String that holds the userName of the user who owns the profile.
    - bio String that holds biography of profile.
    - email String that holds email of user creating profile.
    - friendList ArrayList that contains the User's list of friends.
    - location String that holds location of user creating profile.
    - interests String that holds interests/hobbies of user creating profile.
- Profile()
  - Constructor that creates Profile class with minimum required information  
  and a location, an interests section and a phone number.
  - Parameters:
    - owner String that holds the userName of the user who owns the profile.
    - bio String that holds biography of profile.
    - email String that holds email of user creating profile.
    - friendList ArrayList that contains the User's list of friends.
    - location String that holds location of user creating profile.
    - interests String that holds interests/hobbies of user creating profile.
    - phoneNum Phone Number with no formatting of user creating profile.
- getBio()
  - Accessor method for bio.
  - Return:
    - bio String that holds biography of profile.
- getLocation()
  - Accessor method for location.
  - Return:
    - location String that holds location of user creating profile.
- getInterests()
  - Accessor method for interests.
  - Return:
    - interests String that holds interests/hobbies of user creating profile.
- getPhoneNum()
  - Accessor method for phoneNum.
  - Return:
    - phoneNum Phone Number with no formatting of user creating profile.
- getEmail()
  - Accessor method for email.
  - Return:
    - email String that holds email of user creating profile.
- getOwner()
  - Accessor method for owner.
  - Return:
    - owner String that holds the userName of the user who owns the profile.
- getFriendList()
  - Accessor method for friendList.
  - Return:
    - friendList ArrayList that contains the User's list of friends.
- setBio()
  - Mutator method for bio.
  - Parameters:
    - bio String that holds biography of profile.
- setLocation()
  - Mutator method for location.
  - Parameters:
    - location String that holds location of user creating profile.
- setInterests()
  - Mutator method for interests.
  - Parameters:
    - interests String that holds interests/hobbies of user creating profile.
- setPhoneNum()
  - Mutator method for phoneNum.
  - Parameters:
    - phoneNum Phone Number with no formatting of user creating profile.
- setEmail()
  - Mutator method for email.
  - Parameters:
    - email String that holds email of user creating profile.
- setOwner()
  - Mutator method for owner.
  - Parameters:
    - owner String that holds the userName of the user who owns the profile.
- setFriendList()
  - Mutator method for friendList.
  - Parameters:
    - friendList ArrayList that contains the User's list of friends.
- profileString()
  - Method that outputs basic profile information as String for debugging purposes.
  - Return:
    - Formatted String with owner, bio, and email of user.

Testing:
- Test that Profile class exists and inherits Object superclass.
- Fields were checked with JUnit tests to check for the following:
  - Field Exits
  - Correct Field Type
  - Correct Access Modifier
- Methods were checked with JUnit tests to check for the following:
  - Method Exists
  - Correct Method Type
  - Correct Access Modifies
  - Implementation Tests: Valid and Invalid Input

### FriendRequest Class
Description:

Authors:

Methods:

Testing:

### Client Class
Description:

Authors:

Methods:

Testing:

### Server Class
Description:

Authors:

Methods:

Testing:

### MainTests Class
Description:

Authors:

Methods:

Testing:

### GUI Class
Description:

Authors:

Methods:

Testing:

### HomeFrame Class
Description:

Authors:

Methods:

Testing:

### SignUpFrame Class
Description:

Authors:

Methods:

Testing:

### SuccessFrame Class
Description:

Authors:

Methods:

Testing:

### SendFriendRequestFrame Class
Description:

Authors:

Methods:

Testing:

### ProfileFrame Class
Description:

Authors:

Methods:

Testing:

### ProfileFrameRestricted Class
Description:

Authors:

Methods:

Testing:

### EditProfileFrame Class
Description:

Authors:

Methods:

Testing:

### ErrorFrame CLass
Description:

Authors:

Methods:

Testing:

### FriendsListFrame Class
Description:

Authors:

Methods:

Testing:

### ManageFriendRequestsFrame Class
Description:

Authors:

Methods:

Testing:
