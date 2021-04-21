package com.example.testnet;

public interface IDBManager {

    //User related methods
    public void insertUser(User user) throws Exception;
    public String authenticate();
    public User getUserFromId(String userId);
    public boolean isUserDetailsValid(User user);

}
