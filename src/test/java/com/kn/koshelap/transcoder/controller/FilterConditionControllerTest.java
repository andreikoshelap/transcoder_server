package com.kn.koshelap.transcoder.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
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

import com.kn.koshelap.transcoder.dto.FilterConditionDts;
import com.kn.koshelap.transcoder.dto.FilterConditionDtsList;
import com.kn.koshelap.transcoder.dto.FilterDto;
import com.kn.koshelap.transcoder.dto.search.FilterSearchDto;
import com.kn.koshelap.transcoder.service.FilterConditionService;

@WebMvcTest(FilterConditionController.class)
public class FilterConditionControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private FilterConditionService service;

    @BeforeEach
    void setup() {
        FilterConditionDtsList allComponents = getAllComponents();
        FilterSearchDto dto = new FilterSearchDto();
        dto.setFilterId(1L);

        when(service.find(dto)).thenReturn(allComponents);

    }

    private static FilterConditionDtsList getAllComponents() {
        FilterDto filter = new FilterDto(1L, "main filter");
        List<FilterConditionDts> components = new ArrayList<>(List.of(new FilterConditionDts(1L, "Tallinn", "test", "test", filter),
                new FilterConditionDts(2L, "Riga", "test", "test", filter)));
        return new FilterConditionDtsList(components);
    }

    @Test
    public void getAllCriterion() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/filter/search")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"page\":1,\"pageSize\":10}")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertThat(response).isNotNull();
        verify(service).find(any(FilterSearchDto.class));
    }

}