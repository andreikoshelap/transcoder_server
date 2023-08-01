package com.kn.koshelap.transcoder.service;

import java.util.List;

import com.kn.koshelap.transcoder.domain.FieldAttribute;
import com.kn.koshelap.transcoder.dto.FilterConditionDto;
import com.kn.koshelap.transcoder.dto.FilterConditionDtsList;
import com.kn.koshelap.transcoder.dto.search.FilterSearchDto;

public interface FilterConditionService {
    List<FieldAttribute> getFieldNameList();
    List<String> getConditionList();
    FilterConditionDtsList getAllFilters();
    FilterConditionDtsList find(FilterSearchDto searchDto);
    FilterConditionDto save(FilterConditionDto filterConditionDto);
    void delete(Long id);

}
