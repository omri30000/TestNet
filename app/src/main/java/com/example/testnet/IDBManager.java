package com.example.testnet;

public interface IDBManager {

    //User related methods
    public String insertUser(User user) throws Exception;
    public User getUserFromId(String userId);
    public boolean isUserDetailsValid(User user);
    public String getUserType(String identifier) throws Exception;

}
