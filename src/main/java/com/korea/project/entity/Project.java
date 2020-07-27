package com.korea.project.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String extracolsname;
    private String extracolstype;
    private String name;
    private String code;


    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 45)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) &&
                Objects.equals(extracolsname, project.extracolsname) &&
                Objects.equals(extracolstype, project.extracolstype) &&
                Objects.equals(name, project.name) &&
                Objects.equals(code, project.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, extracolsname, extracolstype, name, code);
    }
}
