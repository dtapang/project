package com.korea.project.models;

public class ResourceCatalogResponse {
    private String code;
    private String category;

    public ResourceCatalogResponse(String code, String category) {
        this.code=code;
        this.category=category;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
