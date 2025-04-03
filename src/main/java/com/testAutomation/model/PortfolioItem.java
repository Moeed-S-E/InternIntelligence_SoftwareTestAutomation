package com.testAutomation.model;

import lombok.Data;

@Data 
public class PortfolioItem {
    private Long id;
    private String name;
    private String description;
    private double value;

    public PortfolioItem() {}

    public PortfolioItem(Long id, String name, String description, double value) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
    }
}