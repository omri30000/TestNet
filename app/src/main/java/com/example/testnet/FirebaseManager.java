package com.example.testnet;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

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
     * @return the new user's identifier as it appears in the database
     */
    public String insertUser(User user) throws Exception {
        String userIdentifier = "";
        if (isUserDetailsValid(user)){
            userIdentifier = this.myRef.child("users").push().getKey();
            this.myRef.child("users").child(userIdentifier).setValue(user);
        }
        else{
            throw new Exception("Couldn't insert user to the database");
        }
        return userIdentifier;
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

    /**
     * The method will check whether a user is registered as a student or a teacher
     * @param identifier is the user identifier in the database
     * @return the user's type ("Student"/"Teacher")
     */
    public String getUserType(String identifier) throws Exception{
        final String[] userType = new String[1];
        final boolean[] isValid = new boolean[1];
        isValid[0] = true;

        this.myRef.child("users").child(identifier).child("userType")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        userType[0] = snapshot.getValue(String.class);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        isValid[0] = false;
                    }
                });

        if (!isValid[0]) throw new Exception("user identifier doesn't exist");

        return userType[0];
    }
}
