package com.ribastore.estoque.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ribastore.estoque.RibastoreEstoqueApplication;
import com.ribastore.estoque.service.EstoqueService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = RibastoreEstoqueApplication.class)
public class OAuth2IntegrationTest {

    @MockBean
    private EstoqueService service;
    
    
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;
    
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
          .addFilter(springSecurityFilterChain).build();
    }
    
    @Test
    public void retornaTodoOEstoqueSemOAuth2() throws Exception {
        mockMvc.perform(get("/estoque"))
          .andExpect(status().isOk());
    }
    
   

}
