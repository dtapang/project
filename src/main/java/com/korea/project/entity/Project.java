package com.korea.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name="project")
public class Project {
    private Integer id;
    private String extracolsname;
    private String extracolstype;
    private String name;
    private User userByUserid;
    private Collection<Projectresourcedetail> projectresourcedetailsById;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "extracolsname", nullable = true, length = 1000)
    public String getExtracolsname() {
        return extracolsname;
    }

    public void setExtracolsname(String extracolsname) {
        this.extracolsname = extracolsname;
    }

    @Column(name = "extracolstype", nullable = true, length = 1000)
    public String getExtracolstype() {
        return extracolstype;
    }

    public void setExtracolstype(String extracolstype) {
        this.extracolstype = extracolstype;
    }

    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) &&
                Objects.equals(extracolsname, project.extracolsname) &&
                Objects.equals(extracolstype, project.extracolstype) &&
                Objects.equals(name, project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, extracolsname, extracolstype, name);
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false)
    public User getUserByUserid() {
        return userByUserid;
    }

    public void setUserByUserid(User userByUserid) {
        this.userByUserid = userByUserid;
    }

    @OneToMany(mappedBy = "projectByProjectid")
    public Collection<Projectresourcedetail> getProjectresourcedetailsById() {
        return projectresourcedetailsById;
    }

    public void setProjectresourcedetailsById(Collection<Projectresourcedetail> projectresourcedetailsById) {
        this.projectresourcedetailsById = projectresourcedetailsById;
    }
}
