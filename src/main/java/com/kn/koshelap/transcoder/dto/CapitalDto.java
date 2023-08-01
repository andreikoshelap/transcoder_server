package com.kn.koshelap.transcoder.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CapitalDto {

    private String title;
    private Long population;
    private BigDecimal lat;
    private BigDecimal lng;
    private Timestamp foundingDate;
    private Timestamp messageDate;

}
