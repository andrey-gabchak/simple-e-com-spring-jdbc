package com.gabchak.controller.external.model;

import javax.validation.constraints.NotNull;

public class CategoryDto {

    @NotNull
    private String name;

    public CategoryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
