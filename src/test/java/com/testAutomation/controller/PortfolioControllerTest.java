package com.testAutomation.controller;

import com.testAutomation.model.PortfolioItem;
import com.testAutomation.service.PortfolioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PortfolioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // Use MockBean instead of Autowired to mock the service
    private PortfolioService portfolioService;

    @BeforeEach
    void setUp() {
        reset(portfolioService); // Reset mock state before each test
    }

    @Test
    void testAddItem_Success() throws Exception {
        String itemJson = "{\"name\":\"Stock\",\"description\":\"Tech stock\",\"value\":100.0}";
        PortfolioItem mockItem = new PortfolioItem(1L, "Stock", "Tech stock", 100.0);

        when(portfolioService.addItem(any(PortfolioItem.class))).thenReturn(mockItem);

        mockMvc.perform(post("/api/portfolio")
                .contentType(MediaType.APPLICATION_JSON)
                .content(itemJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Stock"));

        verify(portfolioService, times(1)).addItem(any(PortfolioItem.class));
    }

    @Test
    void testGetItemById_Success() throws Exception {
        PortfolioItem mockItem = new PortfolioItem(1L, "Stock", "Tech stock", 100.0);

        when(portfolioService.getItemById(1L)).thenReturn(mockItem);

        mockMvc.perform(get("/api/portfolio/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Stock"))
                .andExpect(jsonPath("$.value").value(100.0));

        verify(portfolioService, times(1)).getItemById(1L);
    }

    @Test
    void testGetAllItems() throws Exception {
        PortfolioItem mockItem = new PortfolioItem(1L, "Stock1", "Desc1", 100.0);
        List<PortfolioItem> mockItems = Collections.singletonList(mockItem);

        when(portfolioService.getAllItems()).thenReturn(mockItems);

        mockMvc.perform(get("/api/portfolio")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Stock1"));

        verify(portfolioService, times(1)).getAllItems();
    }
}