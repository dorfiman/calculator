package com.dorfi.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorApplicationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testSuccess() throws Exception {
        reset();

        add(1);
        assertResult(1);

        add(5);
        assertResult(6);

        multiply(2);
        assertResult(12);

        divide(3);
        assertResult(4);

        subtract(3);
        assertResult(1);
    }

    @Test
    void testDivideByZero() throws Exception {
        reset();
        add(1);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/divide/0"))
                .andExpect(MockMvcResultMatchers.status().isNotAcceptable()).andReturn();
        assertEquals("/ by zero", result.getResponse().getContentAsString());
    }

    void reset() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/reset"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private void add(int value) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/add/" + value))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private void subtract(int value) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/subtract/" + value))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private void multiply(int value) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/multiply/" + value))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private void divide(int value) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/divide/" + value))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private void assertResult(int value) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/result"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("" + value));
    }

}