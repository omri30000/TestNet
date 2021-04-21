package com.example.testnet;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseManager implements IDBManager{

    private FirebaseDatabase database;
    private final DatabaseReference myRef;

    FirebaseManager() {
        this.database = FirebaseDatabase.getInstance();
        this.myRef = database.getReference();
    }

    //----------  User related methods  -------------

    /**
     * The function will insert a new user to the database
     * @param user the new user to be inserted
     * @throws Exception might be thrown if the user's details are invalid
     */
    public void insertUser(User user) throws Exception {
        if (isUserDetailsValid(user)){
            myRef.child("users").push().setValue(user);
        }
        else{
            throw new Exception("Couldn't insert user to the database");
        }
    }

    public String authenticate()
    {
        return "";
    }

    public User getUserFromId(String userId)
    {
        return new User();
    }

    /**
     * The function will check if the user's details are valid in registration
     * @param user the object contains the user's details
     * @return true or false if the details are valid
     */
    public boolean isUserDetailsValid(User user){
        //todo: check given values of username, password, email (maybe with RegEx?)
        return true;
    }
}
