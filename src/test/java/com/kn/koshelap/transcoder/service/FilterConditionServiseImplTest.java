package com.kn.koshelap.transcoder.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.kn.koshelap.transcoder.domain.FilterCondition;
import com.kn.koshelap.transcoder.service.impl.FilterConditionServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class FilterConditionServiseImplTest {

    @InjectMocks
    private FilterConditionServiceImpl filterConditionService;

    @Spy
    private FilterCondition filterCondition;
    @Before
    public void setup() {
    }
}
