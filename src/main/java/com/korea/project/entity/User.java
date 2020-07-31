package com.korea.project.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Column(name = "joindate", nullable = false)
    private Timestamp joindate;

    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "role", nullable = true)
    private Integer role;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    //private Project userProjects;
    /**/
    @OneToMany(targetEntity = Project.class, cascade = CascadeType.REMOVE, mappedBy = "owner")
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<Project> projects = new ArrayList<>();


    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }



    public Timestamp getJoindate() {
        return joindate;
    }

    public void setJoindate(Timestamp joindate) {
        this.joindate = joindate;
    }



    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(joindate, user.joindate) &&
                Objects.equals(lastname, user.lastname) &&
                Objects.equals(password, user.password) &&
                Objects.equals(role, user.role) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, joindate, lastname, password, role, username);
    }

 /*
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "owner", nullable = false)
    public Project getUserProjects() {
        return userProjects;
    }

    public void setUserProjects(Project userProjects) {
        this.userProjects = userProjects;
    }
       */
}
