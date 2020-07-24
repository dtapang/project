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
public class Resource {
    private Integer id;
    private String code;
    private String name;
    private Collection<Projectresourcedetail> projectresourcedetailsById;
    private Resource resourceByParentid;
    private Collection<Resource> resourcesById;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "code", nullable = false, length = 45)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "name", nullable = false, length = 45)
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
        Resource resource = (Resource) o;
        return Objects.equals(id, resource.id) &&
                Objects.equals(code, resource.code) &&
                Objects.equals(name, resource.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name);
    }

    @OneToMany(mappedBy = "resourceByResourceid")
    public Collection<Projectresourcedetail> getProjectresourcedetailsById() {
        return projectresourcedetailsById;
    }

    public void setProjectresourcedetailsById(Collection<Projectresourcedetail> projectresourcedetailsById) {
        this.projectresourcedetailsById = projectresourcedetailsById;
    }

    @ManyToOne
    @JoinColumn(name = "parentid", referencedColumnName = "id")
    public Resource getResourceByParentid() {
        return resourceByParentid;
    }

    public void setResourceByParentid(Resource resourceByParentid) {
        this.resourceByParentid = resourceByParentid;
    }

    @OneToMany(mappedBy = "resourceByParentid")
    public Collection<Resource> getResourcesById() {
        return resourcesById;
    }

    public void setResourcesById(Collection<Resource> resourcesById) {
        this.resourcesById = resourcesById;
    }
}
