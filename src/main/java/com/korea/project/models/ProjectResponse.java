package com.korea.project.models;

public class ProjectResponse {

    private int id;
    private String name;
    private String code;

    public ProjectResponse(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}
