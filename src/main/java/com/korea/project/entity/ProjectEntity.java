package com.korea.project.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "project", schema = "korea")
public class ProjectEntity {
    private Integer id;
    private String name;
    private String userid;
    private String extracolsname;
    private String extracolstype;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "userid", nullable = false, length = 50)
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "extracolsname", nullable = true, length = 1000)
    public String getExtracolsname() {
        return extracolsname;
    }

    public void setExtracolsname(String extracolsname) {
        this.extracolsname = extracolsname;
    }

    @Basic
    @Column(name = "extracolstype", nullable = true, length = 1000)
    public String getExtracolstype() {
        return extracolstype;
    }

    public void setExtracolstype(String extracolstype) {
        this.extracolstype = extracolstype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectEntity that = (ProjectEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(userid, that.userid) &&
                Objects.equals(extracolsname, that.extracolsname) &&
                Objects.equals(extracolstype, that.extracolstype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userid, extracolsname, extracolstype);
    }
}
