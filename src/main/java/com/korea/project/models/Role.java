package com.korea.project.models;

public enum Role {
    ROLE_USER(0),
    ROLE_MODERATOR(1);

    private final int id;
    Role(int id) {
        this.id = id;
    }
    public int getId(){ return id; }
}
