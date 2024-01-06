package com.mecorp.backend.populator;

public interface Populator<S, T> {
    void populate(S source, T target);
}
