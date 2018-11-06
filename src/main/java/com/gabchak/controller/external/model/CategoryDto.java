package com.gabchak.controller.external.model;

import javax.validation.constraints.NotNull;

public class CategoryDto {

    @NotNull
    private String name;

    public CategoryDto(String name) {
        this.name = name;
    }

    private CategoryDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static CategoryDto empty() {
        return new CategoryDto();
    }
}
