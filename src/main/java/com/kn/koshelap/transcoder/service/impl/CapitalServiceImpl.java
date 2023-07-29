package com.kn.koshelap.transcoder.service.impl;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kn.koshelap.transcoder.domain.Capital;
import com.kn.koshelap.transcoder.dto.CapitalDto;
import com.kn.koshelap.transcoder.dto.CapitalDtoList;
import com.kn.koshelap.transcoder.dto.search.CapitalSearchDto;
import com.kn.koshelap.transcoder.repository.CapitalRepository;
import com.kn.koshelap.transcoder.service.CapitalService;

@Service
public class CapitalServiceImpl implements CapitalService {
    private final CapitalRepository repository;
    private final MappingService mapper;

    public CapitalServiceImpl(CapitalRepository repository, MappingService mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CapitalDtoList find(CapitalSearchDto searchDto) {
        List<Capital> capitals = repository.findAll(
                Specification
                        .where(hasName(searchDto.getTitle()))
                        .and(hasTimePurchase(searchDto.getFoundingDate().toString())));
        return CapitalDtoList.builder()
                .capitalList(mapper.mapAsList(capitals, CapitalDto.class))
                .build();
    }

    @Override
    public CapitalDtoList findAll() {
        List<Capital> list  = repository.findAll();
        return CapitalDtoList.builder()
                .capitalList(mapper.mapAsList(list, CapitalDto.class)).build();
    }

    static Specification<Capital> hasName(String name) {
        return (ticket, cq, cb) -> {
            if (name == null) {
                return null;
            } else {
                return cb.like(ticket.get("ticket_number"), "%" + name + "%");
            }
        };
    }
    static Specification<Capital> hasTimePurchase(String timePurchase) {
        return (ticket, cq, cb) -> {
            if (timePurchase == null) {
                return null;
            } else {
                return cb.like(ticket.get("time_purchase"), "%" + timePurchase + "%");
            }
        };
    }
}
