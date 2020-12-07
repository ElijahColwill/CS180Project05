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

## Testing
Classes that have indicated that they have Standard Model testing follow said model for the entire class. In GUI Classes, different testing  
methods were utilized to accurately debug and verify the classes, and the implementation of that testing will be described step by step  
for each class.

### Standard Model
- Test that class exists and inherits correct superclass.
- Fields were checked with JUnit tests to check for the following:
  - Field Exits
  - Correct Field Type
  - Correct Access Modifier
- Methods were checked with JUnit tests to check for the following:
  - Method Exists
  - Correct Method Type
  - Correct Access Modifier
  - Implementation Tests: Valid Input for all methods, Invalid Input when necessary

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
- getTemp()
  - Accessor method for temp.
  - Return:
    - temp Variable that holds temp user for ClientHandler.
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
- setTemp()
  - Mutator method for temp.
  - Parameters:
    - temp Variable that holds temp user for ClientHandler.
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
Standard Model

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
Standard Model

### FriendRequest Class
Description:  
FriendRequest class that stores the sender and recipient user of request to make managing  
request lists in User classes easier.

Authors:  
Elijah Colwill

Methods:  
- FriendRequest()
  - Constructor that creates instance of FriendRequest class.
  - Parameters:
    - sender User that sent the request.
    - recipient User receiving the request.
- getSender()
  - Accessor method for sender.
  - Return:
    - sender User that sent the request.
- getRecipient()
  - Accessor method for recipient.
  - Return:
    - recipient User receiving the request.

Testing:  
Standard Model
  
### FriendNotFoundException Exception (extends Exception)
Description:  
FriendNotFoundException exception to handle errors in friend request system.

Authors:  
Elijah Colwill

Methods:
- FriendNotFoundException()
  - No parameter Constructor that references super constructor of exception class.
- FriendNotFoundException()
  - Constructor with message that references super constructor of exception class.
  - Parameters:
    - message String of custom error message.

Testing:  
Standard Model
  
### Client Class
Description:
A class run by the user to be able to interact with the server using a GUI.

Authors:
Henry Peng
Kevin Choe

Methods:
- Client(int portNum)
  - Initializes a Client class with a specified port number.
  - Parameters:
    - port number of the server.
- main (String[] args)
  - Main class run by the user, starts the GUI.
- sendMessage (String message)
  - Sends specified message to the server
  - Parameters:
    - message String to send to server
- receiveMessage ()
  - Reads message from the server and returns the String read.
  - Returns:
    - String read from server
- actionPerformed (ActionEvent e)
  - Adds functionality for the buttons in the GUI.
  - Parameters:
    - action event that is being listened to
- showHomeFrame ()
  - Creates a HomeFrame and adds action listeners.
- showSignUpFrame ()
  - Creates a SignUpFrame and adds action listeners.
- showProfileFrame (String username, boolean isRestricted)
  - Creates a ProfileFrame for the user specified and adds action listeners. Also, creates a RestrictedProfileFrame if isRestricted is true.
  - Parameters:
    - username of the current user, and whether or not the user viewing it should have controll over the profile
- showEditProfileFrame (String username)
  - Creates an EditProfileFrame for the user specified and adds action listeners.
  - Parameters:
    - username of the current user
- showFirendsListFrame (String username)
  - Creates a FriendsListFrame for the user specified and adds action listeners.
  - Parameters:
    - username of the current user
- showIncomingFriendRequestFrame (String username)
  - Creates an IncomingFriendRequestFrame for the user specified and adds action listeners.
  - Parameters:
    - username of the current user
- showOutgoingFriendRequestFrame (String username)
  - Creates an OutgoingFriendRequestFrame for the user specified and adds action listeners.
  - Parameters:
    - username of the current user
- showSendFriendRequestFrame (String username)
  - Creates a SendFriendRequest for the user specified and adds action listeners.
  - Parameters:
    - username of the current user
- showViewRequestFrame ()
  - Creates a ViewRequestFrame and adds action listeners.
- run()
  - run method that is run when the program is started.
- setTemp()
  - Mutator method for temp variable.
  - Parameters:
    - temp New value of variable temp.
- getTemp()
  - Accessor method for temp variable.
  - Return:
    - String value of variable temp.
  
Testing:
The program was run with a TestServer initially and later the actual server to test the functionality of the program.
- Client()
  - Verify that portNun, reader, and writer fields are set correctly.
- main()
  - Verify that instance of Client class is created when class initialized with correct information.
- sendMessage()
  - Verify that when testing overall project, server receives message sent when method is called.
  - Verify that string parameter sends the correct text.
- receiveMessage()
  - Verify that when testing overall project, Server sends correct message and Client receives that same message sent without a significant delay.
  - Verify that returned message equals the message sent by Server.
- actionPerformed()
  - Verify that method connects to Server and GUI and is triggered when action is performed.
  - Verify that homeFrame.signInButton sends correct message and initializes/disposes correct Frames.
  - Verify that homeFrame.signUpButton sends correct message and initializes/disposes correct Frames.
  - Verify that homeFrame.exitButton disposes correct Frames.
  - Verify that signUpFrame.signUpButton sends correct message and initializes/disposes correct Frames.
  - Verify that signUpFrame.backButton sends correct message and initializes/disposes correct Frames.
  - Verify that profileFrame.editProfileButton sends correct message and initializes/disposes correct Frames.
  - Verify that profileFrame.viewFriendsButton sends correct message and initializes/disposes correct Frames.
  - Verify that profileFrame.addFriendButton sends correct message and initializes/disposes correct Frames.
  - Verify that profileFrame.viewRequestsButton sends correct message and initializes/disposes correct Frames.
  - Verify that profileFrame.signOutButton sends correct message and initializes/disposes correct Frames.
  - Verify that editProfileFrame.updateProfileButton sends correct message and initializes/disposes correct Frames.
  - Verify that editProfileFrame.deleteAccountButton sends correct message and initializes/disposes correct Frames.
  - Verify that editProfileFrame.backButton sends correct message and initializes/disposes correct Frames.
  - Verify that friendsListFrame.backButton sends correct message and initializes/disposes correct Frames.
  - Verify that friendsListFrame.viewProfileButton sends correct message and initializes/disposes correct Frames.
  - Verify that incomingFriendRequestsFrame.backButton sends correct message and initializes/disposes correct Frames.
  - Verify that incomingFriendRequestsFrame.acceptRequestButton sends correct message and initializes/disposes correct Frames.
  - Verify that incomingFriendRequestsFrame.denyRequestButton sends correct message and initializes/disposes correct Frames.
  - Verify that outgoingFriendRequestsFrame.backButton sends correct message and initializes/disposes correct Frames.
  - Verify that outgoingFriendRequestsFrame.nextButton sends correct message and initializes/disposes correct Frames.
  - Verify that outgoingFriendRequestsFrame.cancelRequestButton sends correct message and initializes/disposes correct Frames.
  - Verify that sendFriendRequestFrame.backButton sends correct message and initializes/disposes correct Frames.
  - Verify that sendFriendRequestFrame.sendRequestButton sends correct message and initializes/disposes correct Frames.
  - Verify that profileFrameRestricted.backButton sends correct message and initializes/disposes correct Frames.
  - Verify that profileFrameRestricted.viewFriendsButton sends correct message and initializes/disposes correct Frames.
  - Verify that viewRequestsFrame.incomingRequestsButton sends correct message and initializes/disposes correct Frames.
  - Verify that viewRequestsFrame.outgoingRequestsButton sends correct message and initializes/disposes correct Frames.
  - Verify that viewRequestsFrame.backButton sends correct message and initializes/disposes correct Frames.
  - Verify that successFrame.closeButton disposes correct Frames.
  - Verify that errorFrame.closeButton disposes correct Frames.
- showHomeFrame()
  - Verify that homeFrame is initialized with correct actionListeners.
- showSignUpFrame()
  - Verify that signUpFrame is initialized with correct actionListeners.
- showProfileFrame()
  - Verify that profileFrame is initialized with correct actionListeners.
  - Verify that username is passed to Server.
  - Verify that client allows/denys editing based on isRestricted.
- showEditProfileFrame()
  - Verify that editProfileFrame is initialized with correct actionListeners.
  - Verify that correct user is being edited.
- showFriendsListFrame()
  - Verify that friendsListFrame is initialized with correct actionListeners.
  - Verify that the correct user is being displayed.
- showIncomingFriendRequestFrame()
  - Verify that incomingFriendRequestFrame is initialized with correct actionListeners.
  - Verify that the correct user is being displayed.
- showOutgoingFriendRequestFrame()
  - Verify that outgoingFriendRequestFrame is initialized with correct actionListeners.
  - Verify that the correct user is being displayed.
- showSendFriendRequestFrame()
  - Verify that sendFriendRequestFrame is initialized with correct actionListeners.
  - Verify that the correct user if being called.
- showViewRequestsFrame()
  - Verify that viewRequestsFrame is initialized with correct actionListeners.
- run()
  - Verify that when testing overall project for a variety of functions, the correct Frame is always called depending on user action.
  - Verify all actionListeners are added to correct buttons and are working.
- setTemp()
  - Verify that correct field is set with intended value from clientHandler.
- getTemp()
  - Verify that correct field is returned with intended value from ClientHandler.

### ClientHandler Class
Description:  
This class contains the code implementation for all the client-server interactions inside a run method.  
This class was NOT tested with Standard Model because the run method (which utilizes Concurrency) is the basis  
for all other called methods in the class, which means it is not realistically possible to run implementation tests.  
All other JUnit tests (CLass/Declaration/Fields/Methods) still present.  

Authors:  
Sindhuja Kancharla, Henrik Berg, Henry Peng

Methods:  
- ClientHandler()
  - Constructor that creates instance of Client Handler with three parameters.
  - Parameters:
    - s Socket of server
    - r BufferedReader to read messages from Server.
    - w PrintWriter to write messages to Server.
- run()
  - Run method of ClientHandler to receive and send messages to/from Client.
- readUsersList()
  - This method initialises the UserList array by reading from a file.
  - Return:
    - ArrayList<User> list of users from file
- messageToClient()
  - This method writes back to the client.
  - Parameters:
    - message String message that needs to be written to the client.
- readFromProfileFile()
  - This method reads data from a file to initialise the user's Profile.
  - Parameters:
    - username a String that contains the username.
- writeProfileToFile()
  - This method creates a new file for each profile object to store the data.
  - Parameters:
    - username String of username of Profile to be written
    - profile Profile to be written to file.
- initialiseFriendsList()
  - This method initializes the friends list array of the user.
  - Parameters:
    - friendsListData a string array of friends' usernames.
  - Return:
    - ArrayList<User> of list of friends.
  
Testing:  
- ClientHandler()
  - Verify that correct variables are set with intended values when creating instance of ClientHandler.
- run()
  - Verify that correct fields such as newUser/newProfile are created with intended values.
  - Verify that correct messages are read and sent to server for all statements.
  - Verify that Sign Up case takes in all fields, sets fields to correct values
   initializes correct user a profile and sends correct message to Client.
  - Verify that Sign In case matches correct information with correct user, gets the correct User class,
   and sends correct message to Client.
  - Verify that Change Profile case changes correct values based on User input, writes information to file,
   and sends correct message to Client.
  - Verify that Delete Account case removes the correct User from userList and sends correct message to Client.
  - Verify that Information for User case retrieves and returns the correct user, and the correct information
   for specified user, and sends correct message to Client.
  - Verify that Friends for User case retrieves the correct User, finds the correct friends from
   friendList, and sends the correct message for Client.
  - Verify that Get all users case retrieves all users in Server and sends the correct message to Client.
  - Verify that Send Request case creates the correct request in both Users and gets the correct information from Client.
  - Verify that Incoming Friend Request for User case retrieves the incoming Requests and sends correct information to Client.
  - Verify that Outgoing Friend Request for User case retrieves the outgoing Requests and sends correct information to Client.
  - Verify that Cancel Request case removes request from both users and sends receives correct information from Client.
  - Verify that Accept Request case adds correct friend to correct users friendList, receives correct information from Client,
   sends correct information to Client, and removes request from correct lists.
  - Verify that Deny Request case receives correct information from Client,
  - sends correct information to Client, and removes request from correct lists.
  - Verify that Get Temp case retrieves the correct value and receives and sends correct information to/from Client.
  - Verify that Set Temp case sets the correct value and receives/sends correct information to/from Client.
  - Verify that exception handling works as intended.
- readUsersList()
  - Verify that correct users list is retrieves from file with all correct value.
  - Verify that correct ArrayList<User> is returned.
- messageToClient()
   - Verify that correct message is sent to Client through testing of overall Project.
- readFromProfileFile()
    - Verify that correct file is called and correct information from file is retrieved.
    - Verify that correct profile information is read and returned.
- writeProfileToFile()
    - Verify that correct information is formatted and received.
    - Verify that correct information is written to intended file.
- initialiseFriendsList()
    - Verify that correct user is called, the correct Friends are retrieved for said user, and the correct
    information in an ArrayList<User> is returned.

### Server Class
Description:  
A multithreaded server that connects clients via Client Handlers.

Authors:  
Sindhuja Kancharla

Methods:  
- main (String[] args)
  - Main method, initializes sockets/readers/writers.

Testing:  
- Verify that when testing overall project, Server creates a thread for ClientHandler operations.

### MainTests Class
Description:  
Main testing class for entire project, implements JUnit tests to test Class declarations, Field  
and Method declarations, access modifiers, and return types/parameters when applicable.

Authors:  
Elijah Colwill

Methods:  
The following structure was applied to the class:
- Main Method
- TestCase Class inside of MainTests that contains:
  - Setup Methods (outputStart, restoreInputandOutput, getOutput, receiveInput)
  - For each class in project:
    - *classname*DeclarationTest: tests modifiers, superclass, inheritance, abstraction of clas
    - *classname*SetUpTest: tests number of fields, each field's existence, return type, and modifiers, and each methods parameters, return types, and modifiers
    - *classname*ImplementationTest: tests for each method, valid input for all methods and invalid input when necessary **(only for classes following Standard Model)**

Testing:  
N/A (This class is the Testing Class, Standard Debugging was done on each method)

### Constants Class
Description:  
Global constants for the application.

Authors:   
Henrik Berg

Methods:  
N/A

Testing:  
Standard Model

### EditProfileFrame Class
Description:  
Edit profile frame for the application.

Authors:  
Henrik Berg

Methods:  
- EditProfileFrame()
  - Constructor that creates a frame that allows the user to edit their profile.
  - Parameters:
    - fullName the full name of the user editing the profile.
    - username the username of the user editing the profile.
    - email the email of the user editing the profile.
    - location the location of the user editing the profile.
    - bio the biography of the user editing the profile.
    - interests the interests of the user editing the profile.
- presetFields()
  - Pre-fills all the text fields with existing information about the user.
  - Parameters:
    - name the full name of the user editing the profile.
    - username the username of the user editing the profile.
    - email the email of the user editing the profile.
    - location the location of the user editing the profile.
    - bio the biography of the user editing the profile.
    - interests the interests of the user editing the profile.

Testing:  
- EditProfileFrame()
  - Verify that window has correct title Social | Edit Profile
  - Verify that a Frame is created that contains a header with social Icon/Text, middle content and footer with back button.
  - Verify that Frame contains correct text and all buttons/text fields.
  - Verify actionListeners in dependant classes exist for buttons.
  - Verify that all text fields take input and have correct text next to them
- presetFields()
  - Verify that fields are preset with information from User when testing overall project.

### ErrorFrame Class
Description:  
Home frame for the application.

Authors:  
Henrik Berg

Methods:  
- ErrorFrame()
  - Constructor that creates an error frame, letting the user know an error occurred.
  - Parameters:
    - message the error message that is displayed on the frame.

Testing:  
- ErrorFrame()
  - Verify that window has correct title Social | Error
  - Verify that a Frame is created that contains correct layout.
  - Verify that Frame contains Error Icon, Label, and the correct message when testing overall project.
  - Verify that close button is present and in correct location.
  - Verify actionListeners in dependant classes exist for buttons.

### FriendsListFrame Class
Description:  
Friends list frame for the application.

Authors:  
Henrik Berg

Methods:  
- FriendListFrame()
  - Constructor that creates a frame that allows the user to see all their friends.
  - Parameters:
    - names String[] the names of all the user's friends.
    - usernames String[] the usernames of all the user's friends.

Testing:  
- FriendListFrame()
  - Verify that window has correct title Social | Friends List
  - Verify that a Frame is created that contains a header with social Icon/Text, middle content and footer with back button.
  - Verify that view profile button is present for users.
  - Verify that for friends, correct Names, Usernames, and Profile Icon is present.
  - Verify that Correct title and description are present at top of content area.
  - Verify actionListeners in dependant classes exist for buttons.

### HomeFrame Class
Description:  
Home frame for the application.

Authors:  
Henrik Berg

Methods:  
HomeFrame()
- Constructor that creates the home frame.

Testing:  
- HomeFrame()
  - Verify that window has correct title Social | Welcome
  - Verify that a Frame is created that contains a header with social Icon/Text, middle content and footer with exit button.
  - Verify that content area has Sign In and Sign Up titles with divider and descriptions
  - Verify that Username and Password fields take input, are present, and have correct text next to them.
  - Verify actionListeners in dependant classes exist for buttons.

### IncomingFriendRequestsFrame Class
Description:  
Constructor that creates a frame for each incoming friend request.

Authors:  
Henrik Berg

Methods:  
- IncomingFriendRequestsFrame()
  - Constructor that creates a frame for each incoming friend request.
  - Parameters:
    - fullName String the full name of the user that requested you as a friend.
    - username String the username of the user that requested you as a friend.

Testing:  
- IncomingFriendRequestsFrame()
  - Verify that window has correct title Social | Incoming Friend Requests
  - Verify that a Frame is created that contains a header with social Icon/Text, middle content and footer with back button.
  - Verify that Incoming Friend Requests title and text is present in content area.
  - Verify that Friend Request is present with profile icon, Name and user name
  - Verify that Accept and Deny Request buttons are present with correct text.
  - Verify actionListeners in dependant classes exist for buttons.

### OutgoingFriendRequestsFrame Class
Description:  
Outgoing friend requests frame for the application.

Authors:  
Henrik Berg

Methods:  
- OutgoingFriendRequestsFrame()
  - Constructor that creates a frame for each outgoing friend request.
  - Parameters:
    - fullName String the full name of the user that you requested as a friend.
    - username String the username of the user that you requested as a friend.

Testing:  
- OutgoingFriendRequestsFrame()
  - Verify that window has correct title Social | Outgoing Friend Requests
  - Verify that a Frame is created that contains a header with social Icon/Text, middle content and footer with back button.
  - Verify that Outgoing Friend Requests title and text is present in content area.
  - Verify that Friend Request is present with profile icon, Name and user name
  - Verify that Cancel Request button is present with correct text.
  - Verify actionListeners in dependant classes exist for buttons.

### ProfileFrame Class
Description:  
Profile frame for the application.

Authors: 
Henrik Berg

Methods:  
- ProfileFrame()
  - Constructor that creates a frame for a user's profile.
  - Parameters:
    - fullName String the full name of the user.
    - username String the username of the user.
    - location String the location of the user.
    - bio String the biography of the user.
    - interests String the interests of the user.

Testing:  
- ProfileFrame()
  - Verify that window has correct title Social | Profile
  - Verify that a Frame is created that contains a header with social Icon/Text, middle content and footer with sign out button.
  - Verify that profile name, username, Profile Icon, and edit profile button are present with correct text.
  - Verify that below profile information is area for Location/Bio/Interests with correct text for the User.
  - Verify that in bottom of content area View Friends, Add Friend and View Request buttons exist with correct text.
  - Verify actionListeners in dependant classes exist for buttons.

### ProfileFrameRestricted CLass
Description:  
Profile frame (restricted, can't edit) for the application.

Authors:  
Henrik Berg

Methods:  
- ProfileFrameRestricted()
  - Constructor that creates a frame for a user's profile (restricted).
  - Parameters:
    - fullName String the full name of the user.
    - username String the username of the user.
    - location String the location of the user.
    - bio String the biography of the user.
    - interests String the interests of the user.

Testing:  
- ProfileFrameRestricted()
  - Verify that window has correct title Social | Profile
  - Verify that a Frame is created that contains a header with social Icon/Text, middle content and footer with back button.
  - Verify that profile name, username, and Profile Icon are present with correct text.
  - Verify that below profile information is area for Location/Bio/Interests with correct text for the User.
  - Verify that in bottom of content area View Friends button exists with correct text.
  - Verify actionListeners in dependant classes exist for buttons.

### SendFriendRequestFrame Class
Description:  
Send friend request frame for the application.

Authors:  
Henrik Berg

Methods:  
- SendFriendRequestFrame()
  - Constructor that creates a frame to select users to add as friends.
  - Parameters:
    - users String[] the list of all available users to send friend requests to.

Testing:  
- SendFriendRequestFrame()
  - Verify that window has correct title Social | Send Friend Request
  - Verify that a Frame is created that contains a header with social Icon/Text, middle content and footer with back button.
  - Verify that Send Friend Request title is centered, in Content area, and with correct text and description underneath.
  - Verify that Drop down box is present and functional with correct options when testing overall project.
  - Verify that Send Request button is present with correct text in correct location in content area.
  - Verify actionListeners in dependant classes exist for buttons.

### SignUpFrame Class
Description:  
Sign up frame for the application.

Authors:  
Henrik berg

Methods:  
- SignUpFrame()
  - Constructor that creates a frame for a user to sign up.

Testing:  
- SignUpFrame()
  - Verify that window has correct title Social | Sign Up
  - Verify that a Frame is created that contains a header with social Icon/Text, middle content and footer with back button.
  - Verify that Sign Up title with correct description are present with correct text, centered in top of content area.
  - Verify that Text fields are all present with correct text next to them, and take input for Name/Username/Email/Password
  - Verify Password field hides text.
  - Verify Sign Up button is present below text fields.
  - Verify actionListeners in dependant classes exist for buttons.

### SuccessFrame Class
Description:  
Success frame for the application.

Authors:  
Henrik Berg

Methods:  
- SuccessFrame()
  - Constructor that creates a success frame, letting the user know their action succeeded.
  - Parameters:
    - message String the error message that is displayed on the frame.

Testing:  
- SuccessFrame()
  - Verify that window has correct title Social | Success
  - Verify that a Frame is created that contains a title and content panel.
  - Verify that correct Icon, message and Title are present for Success message.
  - Verify that close button is present.
  - Verify actionListeners in dependant classes exist for button.

### ViewRequestsFrame Class
Description:  
View requests frame for the application.

Authors:  
Henrik Berg

Methods:  
- ViewRequestsFrame()
  - Constructor that creates a frame to select incoming or outgoing friend requests.

Testing:  
- ViewRequestsFrame()
  - Verify that window has correct title Social | View Requests
  - Verify that a Frame is created that contains a header with social Icon/Text, middle content and footer with back button.
  - Verify that View Friend Requests title is present and centered at top of content area, with correct description
  - Verify that Incoming Requests and Outgoing Requests buttons are present below description, centered, and with correct text.
  - Verify actionListeners in dependant classes exist for buttons.
  
### SwingUtils Class
Description:  
Utilities for Swing classes.

Authors:  
Henrik Berg

Methods:  
- addComponent()
  - Method to add components in a GridBagLayout
  - Parameters:
    - panel the panel to add the component to.
    - component the component to add.
    - x the x coordinate of the component.
    - y the y coordinate of the component.
    - width the desired width of the component.
    - height the desired height of the component.
    - align the desired alignemnt of the component.

Testing:  
N/A (Asset class, addComponent was tested through GUI testing throughout project, testing would be redundant)

### ImageUtils Class
Description:  
Utilities for images in Swing.

Authors:  
Henrik Berk 

Methods:  
- resizeImageIcon()
  - Method to resize ImageIcons()
  - Parameters:
    - imageIcon the image icon to resize.
    - width the desired width after resizing.
    - height the desired height after resizing.
  - Return:
    - ImageIcon of resized image.

Testing:  
N/A (Asset class, resizeImageIcon was tested through GUI testing throughout project, testing would be redundant)
