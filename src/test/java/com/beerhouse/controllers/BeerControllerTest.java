package com.beerhouse.controllers;

import com.beerhouse.controllers.BeerController;
import com.beerhouse.models.Beer;
import com.beerhouse.repositories.BeerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = BeerController.class)
public class BeerControllerTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BeerRepository beerRepository;

    @Test
    public void getByIdTest() throws Exception {
        String uri = "/beers/1";
        Mockito.when(beerRepository.findOne(1l)).thenReturn(new Beer());
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        int status = result.getResponse().getStatus();

        assertEquals(200, status);

    }

    @Test
    public void createBeerTest() throws Exception{
        String uri = "/beers";
        Beer mockBeer = new Beer("Colorado", "as", "asd", 1, "as");

        String inputJson = objectMapper.writeValueAsString(mockBeer);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson);


        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        int status = result.getResponse().getStatus();

        assertEquals(201, status);
    }

}
