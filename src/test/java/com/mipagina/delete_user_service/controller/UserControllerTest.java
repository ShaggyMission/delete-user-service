package com.mipagina.delete_user_service.controller;

import com.mipagina.delete_user_service.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testDeleteUserSuccess() throws Exception {
        // Simular que no lanza excepción
        Mockito.doNothing().when(userService).deleteUserById(anyString());

        mockMvc.perform(delete("/users/123"))
                .andExpect(status().isOk())
                .andExpect(content().string("User successfully deleted"));
    }

    @Test
    public void testDeleteUserNotFound() throws Exception {
        // Simular excepción IllegalArgumentException (usuario no encontrado)
        Mockito.doThrow(new IllegalArgumentException("User with ID 123 not found"))
                .when(userService).deleteUserById("123");

        mockMvc.perform(delete("/users/123"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found"));
    }

    @Test
    public void testDeleteUserInternalError() throws Exception {
        // Simular excepción general
        Mockito.doThrow(new RuntimeException("DB error"))
                .when(userService).deleteUserById("123");

        mockMvc.perform(delete("/users/123"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Error deleting user: DB error"));
    }
}
