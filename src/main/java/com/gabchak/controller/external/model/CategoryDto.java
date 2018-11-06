package com.gabchak.controller.external.model;

import javax.validation.constraints.NotNull;

public class CategoryDto {

    @NotNull
    private String name;
    private Long id;

    private CategoryDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static CategoryDto empty() {
        return new CategoryDto();
    }
}
