package com.kn.koshelap.transcoder.dto.search;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CapitalSearchDto {

    private String title;
    private Long population;
    private BigDecimal lat;
    private BigDecimal lng;
    private Timestamp foundingDate;
}
