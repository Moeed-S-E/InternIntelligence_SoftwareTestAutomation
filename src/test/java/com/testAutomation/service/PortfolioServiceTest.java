package com.testAutomation.service;

import com.testAutomation.model.PortfolioItem;
import com.testAutomation.service.impl.PortfolioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PortfolioServiceTest {

    @InjectMocks
    private PortfolioServiceImpl portfolioService;

    @BeforeEach
    void setUp() {
        portfolioService = new PortfolioServiceImpl();
    }

    @Test
    void testAddItem_Success() {
        // Arrange
        PortfolioItem item = new PortfolioItem(null, "Stock", "Tech stock", 100.0);

        // Act
        PortfolioItem result = portfolioService.addItem(item);

        // Assert
        assertNotNull(result.getId());
        assertEquals("Stock", result.getName());
        assertEquals(1L, result.getId());
    }

    @Test
    void testGetItemById_ItemExists() {
        // Arrange
        PortfolioItem item = new PortfolioItem(null, "Stock", "Tech stock", 100.0);
        portfolioService.addItem(item);

        // Act
        PortfolioItem result = portfolioService.getItemById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Stock", result.getName());
    }

    @Test
    void testGetAllItems() {
        // Arrange
        portfolioService.addItem(new PortfolioItem(null, "Stock1", "Desc1", 100.0));
        portfolioService.addItem(new PortfolioItem(null, "Stock2", "Desc2", 200.0));

        // Act
        List<PortfolioItem> result = portfolioService.getAllItems();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Stock1", result.get(0).getName());
    }
}