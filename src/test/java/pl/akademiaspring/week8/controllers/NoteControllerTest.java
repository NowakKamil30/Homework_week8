package pl.akademiaspring.week8.controllers;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class NoteControllerTest {

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void init() throws Exception {
        mockMvc.perform(put("/note/{id}", 1)
                .content("{\"note\": \"dsdfsdfasfas\"}")
                .header("Content-Type", "application/json"));
        mockMvc.perform(put("/note/{id}", 2)
                .content("{\"note\": \"dsasfas\"}")
                .header("Content-Type", "application/json"));
        mockMvc.perform(put("/note/{id}", 3)
                .content("{\"note\": \"dss\"}")
                .header("Content-Type", "application/json"));
    }


    @Test
    void addNoteToList() throws Exception {
        mockMvc.perform(post("/note")
                .content("{\"note\": \"dsdfsdfasfas\"}")
                .header("Content-Type", "application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.note", Is.is("dsdfsdfasfas")));
    }

    @Test
    void checkFindNoteById() throws Exception {
        mockMvc.perform(get("/note/{id}", 2))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Is.is(2)));
    }

    @Test
    void checkNoteListNotEmpty() throws Exception {
        mockMvc.perform(get("/note"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    void checkFindByNotFoundId() throws Exception {
        mockMvc.perform(get("/note/{id}", Integer.MAX_VALUE))
                .andExpect(status().isNoContent());
    }

    @Test
    void putNote() throws Exception {
        mockMvc.perform(put("/note/{id}", 1)
                .content("{\"note\": \"new\"}")
                .header("Content-Type", "application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.note", Is.is("new")));
    }

    @Test
    void deleteNoteExist() throws Exception {
        mockMvc.perform(delete("/note/{id}", 1))
                .andExpect(status().isAccepted());
    }

}