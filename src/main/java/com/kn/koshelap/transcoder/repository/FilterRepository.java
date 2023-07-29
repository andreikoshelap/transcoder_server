package com.kn.koshelap.transcoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kn.koshelap.transcoder.domain.FilterCondition;

@Repository
public interface FilterRepository extends JpaRepository<FilterCondition, Long>, JpaSpecificationExecutor<FilterCondition> {

}
