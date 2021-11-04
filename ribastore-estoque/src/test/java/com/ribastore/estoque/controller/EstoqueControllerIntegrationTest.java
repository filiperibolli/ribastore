package com.ribastore.estoque.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ribastore.estoque.model.Produto;
import com.ribastore.estoque.service.EstoqueService;

@RunWith(SpringRunner.class)
@WebMvcTest(EstoqueController.class)
public class EstoqueControllerIntegrationTest {
	
    @Autowired
    private MockMvc mvc;

    @MockBean
    private EstoqueService service;
    
    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
      throws Exception {
        
    	ArrayList<Produto> produtos = new ArrayList<Produto>();
    	Produto tibiaCoin = new Produto(1L, "tibia coin", "tibia", 100L);
    	produtos.add(tibiaCoin);

    	when(service.getEstoque()).thenReturn(produtos);

        mvc.perform(get("/estoque")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk());
    }

}
