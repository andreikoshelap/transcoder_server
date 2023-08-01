package com.kn.koshelap.transcoder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "filter_condition")
public class FilterCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="field_name")
    private String fieldName;

    @Column(name="condition_operator")
    private String conditionOperator;

    @Column(name="property_value")
    private String propertyValue;

    @ManyToOne
    @JoinColumn(name = "filter_id", referencedColumnName = "id")
    private Filter filter;

}
