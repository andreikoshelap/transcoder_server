package com.kn.koshelap.transcoder.service.impl;

import static com.kn.koshelap.transcoder.enums.Condition.ALL_CONDITIONS;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kn.koshelap.transcoder.domain.Capital;
import com.kn.koshelap.transcoder.domain.FilterCondition;
import com.kn.koshelap.transcoder.dto.FilterConditionDto;
import com.kn.koshelap.transcoder.dto.FilterConditionDtoList;
import com.kn.koshelap.transcoder.dto.search.FilterSearchDto;
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

    @Override
    public FilterConditionDto save(FilterConditionDto filterConditionDto) {
        return mapper.map(repository.save(mapper.map(filterConditionDto, FilterCondition.class)), FilterConditionDto.class);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public FilterConditionDtoList find(FilterSearchDto searchDto) {
        List<FilterCondition> criterion = repository.findAll(
                Specification
                        .where(hasName(searchDto.getFieldName()))
                        .and(hasFilterId(searchDto.getFilterId())));
        return FilterConditionDtoList.builder()
                .filterList(mapper.mapAsList(criterion, FilterConditionDto.class))
                .build();
    }
    static Specification<FilterCondition> hasName(String fieldName) {
        return (criteria, cq, cb) -> {
            if (fieldName == null) {
                return null;
            } else {
                return cb.like(criteria.get("field_name"), "%" + fieldName + "%");
            }
        };
    }
    static Specification<FilterCondition> hasFilterId(Long filterId) {
        return (criteria, cq, cb) -> {
            if (filterId == null) {
                return null;
            } else {
                return cb.equal(criteria.get("filter").get("id"),  filterId );
            }
        };
    }
}
