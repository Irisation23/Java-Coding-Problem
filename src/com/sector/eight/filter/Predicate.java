package com.sector.eight.filter;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
