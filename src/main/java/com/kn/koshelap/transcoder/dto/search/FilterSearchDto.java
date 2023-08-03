package com.kn.koshelap.transcoder.dto.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class FilterSearchDto {
    private String fieldName;;
    private Long filterId;;
}
