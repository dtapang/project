package com.korea.project.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ProjectResourceDetail {
    private Integer id;
    private Byte editable;
    private String extracolsvalue;
    private String itemid;
    private Integer price;
    private Integer quantity;
/*
    @ManyToOne
    @JoinColumn(name = "projectid")
    private Project projectByProjectId;

    public Project getProjectByProjectId() {
        return projectByProjectId;
    }

    public void setProjectByProjectId(Project projectByProjectId) {
        this.projectByProjectId = projectByProjectId;
    }

    public Resource getResourceByResourceId() {
        return resourceByResourceId;
    }

    public void setResourceByResourceId(Resource resourceByResourceId) {
        this.resourceByResourceId = resourceByResourceId;
    }

    @OneToOne
    @JoinColumn(name="resourceid")
    private Resource resourceByResourceId;

*/

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "editable", nullable = false)
    public Byte getEditable() {
        return editable;
    }

    public void setEditable(Byte editable) {
        this.editable = editable;
    }

    @Basic
    @Column(name = "extracolsvalue", nullable = true, length = 1000)
    public String getExtracolsvalue() {
        return extracolsvalue;
    }

    public void setExtracolsvalue(String extracolsvalue) {
        this.extracolsvalue = extracolsvalue;
    }

    @Basic
    @Column(name = "itemid", nullable = true, length = 50)
    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    @Basic
    @Column(name = "price", nullable = true)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
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
