package com.kn.koshelap.transcoder.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FieldAttribute {
    private String fieldName;
    private String fieldType;

}
