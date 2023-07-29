package com.kn.koshelap.transcoder.service;
import com.kn.koshelap.transcoder.dto.CapitalDtoList;
import com.kn.koshelap.transcoder.dto.search.CapitalSearchDto;

public interface CapitalService {
    CapitalDtoList find(CapitalSearchDto searchDto);

    CapitalDtoList findAll();
}
