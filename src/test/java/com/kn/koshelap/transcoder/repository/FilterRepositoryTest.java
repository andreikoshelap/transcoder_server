package com.kn.koshelap.transcoder.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kn.koshelap.transcoder.domain.Filter;
import com.kn.koshelap.transcoder.domain.FilterCondition;

@DataJpaTest
public class FilterRepositoryTest {

        @Autowired
        private FilterRepository filterRepository;

        @BeforeEach
        public void setup() {
            List<FilterCondition> criterion = new ArrayList<>(List.of(
                    new FilterCondition(1L, "population", "MORE", "300000", new Filter(1L, "Test")),
                    new FilterCondition(2L, "id", "LESS", "100", new Filter(1L, "Test"))));

            filterRepository.saveAll(criterion);
        }

        @AfterEach
        public void tearDown() {
            filterRepository.deleteAll();
        }

        @Test
        public void findAllFilterConditions() {
            List<FilterCondition> filters = filterRepository.findAll();
            assertThat(filters).isNotEmpty().extracting(FilterCondition::getFieldName).contains("population");

        }



}
