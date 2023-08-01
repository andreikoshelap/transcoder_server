package com.kn.koshelap.transcoder.service;

import java.util.List;

import com.kn.koshelap.transcoder.dto.FilterConditionDts;
import com.kn.koshelap.transcoder.dto.FilterConditionDtsList;
import com.kn.koshelap.transcoder.dto.search.FilterSearchDto;

public interface FilterConditionService {
    List<String> getFieldNameList();
    List<String> getConditionList();
    FilterConditionDtsList getAllFilters();
    FilterConditionDtsList find(FilterSearchDto searchDto);
    FilterConditionDts save(FilterConditionDts filterConditionDts);
    void delete(Long id);

}
