package com.springsecurity.demo.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class SignUpControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void signUpForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/signup"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string(containsString("_csrf")));
    }

    @Test
    void processSignUp() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/signup")
                .param("username", "ejh")
                .param("password", "123")
                .with(csrf()))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }

}