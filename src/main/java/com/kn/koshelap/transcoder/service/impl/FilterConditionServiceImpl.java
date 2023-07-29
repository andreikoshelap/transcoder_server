package com.kn.koshelap.transcoder.service.impl;

import static com.kn.koshelap.transcoder.enums.Condition.ALL_CONDITIONS;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kn.koshelap.transcoder.domain.Capital;
import com.kn.koshelap.transcoder.domain.FilterCondition;
import com.kn.koshelap.transcoder.dto.FilterConditionDto;
import com.kn.koshelap.transcoder.dto.FilterConditionDtoList;
import com.kn.koshelap.transcoder.repository.FilterRepository;
import com.kn.koshelap.transcoder.service.FilterConditionService;

@Service
public class FilterConditionServiceImpl implements FilterConditionService {

    @Autowired
    private FilterRepository repository;
    @Autowired
    private  MappingService mapper;
    @Override
    public List<String> getFieldNameList() {
        return findAllFields(Capital.class).stream().map(Field::getName).collect(Collectors.toList());
    }

    @Override
    public List<String> getConditionList() {
        return ALL_CONDITIONS;
    }

    @Override
    public FilterConditionDtoList getAllFilters() {
        List<FilterCondition> list = repository.findAll();
        return FilterConditionDtoList.builder()
                .filterList(mapper.mapAsList(list, FilterConditionDto.class)).build();
    }

    private List<Field> findAllFields(Class<?> entityClass) {
        if (entityClass == Object.class) {
            return Collections.emptyList();
        }
        List<Field> result = new ArrayList<>(findAllFields(entityClass.getSuperclass()));
        result.addAll(Arrays.asList(entityClass.getDeclaredFields()));
        return result;
    }
}
