package com.zero.amsadmin;

public class UserID {

    public String userId;

    public <T extends UserID> T withId(final String id) {
        this.userId = id;
        return (T) this;
    }
}
