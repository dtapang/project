package com.korea.project.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "project_resource_detail", schema = "korea", catalog = "")
@Entity
public class ProjectResourceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private Integer projectid;
    private Integer resourceid;

    @ManyToOne(targetEntity = Project.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "projectid", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    private Project projectByProjectid;



    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "projectid", nullable = false)
    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    @Basic
    @Column(name = "resourceid", nullable = false)
    public Integer getResourceid() {
        return resourceid;
    }

    public void setResourceid(Integer resourceid) {
        this.resourceid = resourceid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectResourceDetail that = (ProjectResourceDetail) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(projectid, that.projectid) &&
                Objects.equals(resourceid, that.resourceid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectid, resourceid);
    }


    public Project getProjectByProjectid() {
        return projectByProjectid;
    }


    public void setProjectByProjectid(Project projectByProjectid) {
        this.projectByProjectid = projectByProjectid;
    }
}
