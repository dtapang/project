package com.korea.project.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "project_resource_detail", schema = "korea", catalog = "")
public class ProjectResourceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Byte editable;
    private String extracolsvalue;
    private String itemid;
    private Integer price;
    private Integer quantity;

    @ManyToOne(targetEntity = Project.class)
    @JoinColumn(name="projectid", referencedColumnName = "id", insertable=false, updatable=false)
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @ManyToOne(targetEntity = Resource.class)
    @JoinColumn(name = "resourceid" , referencedColumnName = "id", insertable=false, updatable=false)
    private Resource resource;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "editable", nullable = false)
    public Byte getEditable() {
        return editable;
    }

    public void setEditable(Byte editable) {
        this.editable = editable;
    }

    @Column(name = "extracolsvalue", nullable = true, length = 1000)
    public String getExtracolsvalue() {
        return extracolsvalue;
    }

    public void setExtracolsvalue(String extracolsvalue) {
        this.extracolsvalue = extracolsvalue;
    }

    @Column(name = "itemid", nullable = true, length = 50)
    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    @Column(name = "price", nullable = true)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Column(name = "quantity", nullable = true)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectResourceDetail that = (ProjectResourceDetail) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(editable, that.editable) &&
                Objects.equals(extracolsvalue, that.extracolsvalue) &&
                Objects.equals(itemid, that.itemid) &&
                Objects.equals(price, that.price) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, editable, extracolsvalue, itemid, price, quantity);
    }

}
