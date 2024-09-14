package com.casa.demospring.demo.controller;

import com.casa.demospring.demo.entities.User;
import com.casa.demospring.demo.exceptions.RestCustomException;
import com.casa.demospring.demo.repositories.UserRepository;
import com.casa.demospring.demo.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @InjectMocks
    private RestCustomException restCustomException;

    @Test
    void testFindAll() throws Exception {
        List<User> users = List.of(
                new User(1L, "John Doe", "john@example.com","123456","123456"));
        when(userService.findAll()).thenReturn(users);

        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                .setControllerAdvice(restCustomException)
                .build();

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk());
    }
}
