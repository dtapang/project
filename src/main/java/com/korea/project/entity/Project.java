package com.korea.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "project", schema = "korea")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "code", nullable = false, length = 50)
    private String code;
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("projects")
    @JoinColumn(name="owner", nullable = false, referencedColumnName = "id", insertable=false, updatable=false)
    private User owner;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
                Objects.equals(name, project.name) &&
                Objects.equals(code, project.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code);
    }

    @OneToMany(targetEntity = ProjectResourceDetail.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="projectid", referencedColumnName = "id", nullable = false , insertable=false, updatable=false)
    private List<ProjectResourceDetail> projectResourceDetails;

    public List<ProjectResourceDetail> getProjectResourceDetails() {
        return projectResourceDetails;
    }

    public void setProjectResourceDetails(List<ProjectResourceDetail> project) {
        this.projectResourceDetails = project;
    }
}