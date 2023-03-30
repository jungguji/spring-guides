package com.example.restservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void greeting() throws Exception {
        mockMvc.perform(get("/greeting"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").value("Hello, World!"));
    }

    @Test
    void greetingWithName() throws Exception {
        //given
        String name = "중구";
        String result = "Hello, " + name + "!";
        //when
        //then
        mockMvc.perform(get("/greeting")
                .param("name", name))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").value(result));
    }
}