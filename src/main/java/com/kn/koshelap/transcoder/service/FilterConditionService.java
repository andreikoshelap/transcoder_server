package com.kn.koshelap.transcoder.service;

import java.util.List;

import com.kn.koshelap.transcoder.dto.FilterConditionDtoList;
import com.kn.koshelap.transcoder.dto.search.FilterSearchDto;

public interface FilterConditionService {
    List<String> getFieldNameList();
    List<String> getConditionList();
    FilterConditionDtoList getAllFilters();
    FilterConditionDtoList find(FilterSearchDto searchDto);

}
