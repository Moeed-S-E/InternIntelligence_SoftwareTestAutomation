package com.testAutomation.controller;

import com.testAutomation.model.PortfolioItem;
import com.testAutomation.service.PortfolioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {
    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioItem> getItem(@PathVariable Long id) {
        PortfolioItem item = portfolioService.getItemById(id);
        return item != null ? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PortfolioItem> addItem(@RequestBody PortfolioItem item) {
        PortfolioItem createdItem = portfolioService.addItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @GetMapping
    public ResponseEntity<List<PortfolioItem>> getAllItems() {
        return ResponseEntity.ok(portfolioService.getAllItems());
    }
}