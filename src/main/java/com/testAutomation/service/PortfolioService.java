package com.testAutomation.service;

import com.testAutomation.model.PortfolioItem;

import java.util.List;

public interface PortfolioService {
    PortfolioItem getItemById(Long id);
    PortfolioItem addItem(PortfolioItem item);
    List<PortfolioItem> getAllItems();
}