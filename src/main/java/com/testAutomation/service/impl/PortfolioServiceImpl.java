package com.testAutomation.service.impl;

import com.testAutomation.model.PortfolioItem;
import com.testAutomation.service.PortfolioService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

@Service
public class PortfolioServiceImpl implements PortfolioService {
    private final List<PortfolioItem> items = new ArrayList<>();

    @Override
    public PortfolioItem getItemById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public PortfolioItem addItem(PortfolioItem item) {
        item.setId((long) (items.size() + 1)); // Simple ID generation
        items.add(item);
        return item;
    }

    @Override
    public List<PortfolioItem> getAllItems() {
        return new ArrayList<>(items);
    }
}