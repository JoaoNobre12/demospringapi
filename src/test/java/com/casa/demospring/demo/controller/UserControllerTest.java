package com.casa.demospring.demo.controller;

import com.casa.demospring.demo.controller.exceptions.ControllerExceptionHandler;
import com.casa.demospring.demo.entities.User;
import com.casa.demospring.demo.exceptions.RestCustomException;
import com.casa.demospring.demo.repositories.UserRepository;
import com.casa.demospring.demo.services.UserService;
import com.casa.demospring.demo.services.exceptions.ConflictException;
import com.casa.demospring.demo.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @InjectMocks
    private ControllerExceptionHandler controllerExceptionHandler;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                .setControllerAdvice(controllerExceptionHandler)
                .build();
    }

    @Test
    void testFindAll() throws Exception {
        List<User> users = List.of(
                new User(1L, "John Doe", "john@example.com","123456","123456"));
        when(userService.findAll()).thenReturn(users);

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk());
    }

    @Test
    void testFindById() throws Exception {
        User user = new User(1L, "John Doe", "john@example.com","123456","123456");
        when(userService.findById(1L)).thenReturn(user);

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testFindByIdNotFound() throws Exception {
        when(userService.findById(1L)).thenThrow(new ResourceNotFoundException(1L));

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete("/users/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testDeleteConflict() throws Exception {

        doThrow(new ConflictException(1L)).when(userService).delete(1L);

        mockMvc.perform(delete("/users/1"))
                .andExpect(status().isConflict());
    }

@Test
void testUpdate() throws Exception {
    User updatedUser = new User(1L, "John Doe Updated", "john.updated@example.com", "654321", "654321");

    when(userService.update(1L, updatedUser)).thenReturn(updatedUser);

    mockMvc.perform(put("/users/1")
            .contentType("application/json")
            .content("{\"id\":1,\"name\":\"John Doe Updated\",\"email\":\"john.updated@example.com\",\"phone\":\"654321\",\"password\":\"654321\"}"))
            .andExpect(status().isOk());
}}
