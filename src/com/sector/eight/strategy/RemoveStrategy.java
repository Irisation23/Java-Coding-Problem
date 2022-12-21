package com.sector.eight.strategy;

/**
 * 해당 인터페이스는 주어진 문자열에서 어떤 문자를 제거하는 전략을 통합한다.
 */
@FunctionalInterface
public interface RemoveStrategy {
    String execute(String s);
}
