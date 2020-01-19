package com.kaungmyatmin.haulio.model;

import com.google.gson.annotations.SerializedName;

public class User {
    private String id;
    private String profilePic;
    private String name;


    //-------- getter and setter --------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

