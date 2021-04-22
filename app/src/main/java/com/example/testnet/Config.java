package com.example.testnet;

import android.app.Application;

public class Config extends Application {
    private String userIdentifier;

    public String getUserIdentifier() {
        return this.userIdentifier;
    }

    public void setUserIdentifier(String id) {
        this.userIdentifier = id;
    }
}