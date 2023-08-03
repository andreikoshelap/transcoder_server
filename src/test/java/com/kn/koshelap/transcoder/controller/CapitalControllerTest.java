package com.kn.koshelap.transcoder.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.kn.koshelap.transcoder.dto.search.CapitalSearchDto;
import com.kn.koshelap.transcoder.service.CapitalService;

@WebMvcTest(CapitalController.class)
public class CapitalControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private CapitalService service;

    @Test
    public void findAllCapitals() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/capital/search")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"page\":1,\"pageSize\":10}")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertThat(response).isNotNull();
        verify(service).find(any(CapitalSearchDto.class));
    }

}