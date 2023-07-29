package com.kn.koshelap.transcoder.enums;

import java.util.List;

import com.google.common.collect.ImmutableList;

public enum Condition {
    EQUALS,
    STARTS_WITH,
    MORE,
    LESS,
    BEFORE;

    public static final List<String> ALL_CONDITIONS = ImmutableList.of(
            EQUALS.name(),
            STARTS_WITH.name(),
            MORE.name(),
            LESS.name(),
            BEFORE.name());
}
