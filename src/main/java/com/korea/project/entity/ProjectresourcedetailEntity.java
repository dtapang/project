package com.korea.project.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "projectresourcedetail", schema = "korea")
public class ProjectresourcedetailEntity {
    private Integer id;
    private Integer projectid;
    private Integer resourceid;
    private Byte editable;
    private String itemid;
    private Integer price;
    private Integer quantity;
    private String extracolsvalue;

    @Id
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

    @Basic
    @Column(name = "editable", nullable = false)
    public Byte getEditable() {
        return editable;
    }

    public void setEditable(Byte editable) {
        this.editable = editable;
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
    @Column(name = "price", nullable = true, precision = 0)
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

    @Basic
    @Column(name = "extracolsvalue", nullable = true, length = 1000)
    public String getExtracolsvalue() {
        return extracolsvalue;
    }

    public void setExtracolsvalue(String extracolsvalue) {
        this.extracolsvalue = extracolsvalue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectresourcedetailEntity that = (ProjectresourcedetailEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(projectid, that.projectid) &&
                Objects.equals(resourceid, that.resourceid) &&
                Objects.equals(editable, that.editable) &&
                Objects.equals(itemid, that.itemid) &&
                Objects.equals(price, that.price) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(extracolsvalue, that.extracolsvalue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectid, resourceid, editable, itemid, price, quantity, extracolsvalue);
    }
}
