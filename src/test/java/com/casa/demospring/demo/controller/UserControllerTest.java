package com.casa.demospring.demo.controller;

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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    private MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @InjectMocks
    private RestCustomException restCustomException;

    @Test
    void testFindAll() throws Exception {
        // Configura o mock para lançar a exceção
        when(userService.findAll()).thenThrow(new RuntimeException("Test Exception"));

        // Configura o MockMvc com o Controller e o ControllerAdvice
        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                .setControllerAdvice(restCustomException)
                .build();

        // Faz a requisição e verifica se o status code é 418 (I_AM_A_TEAPOT)
        mockMvc.perform(get("/users"))
                .andExpect(status().isIAmATeapot());
    }
}
