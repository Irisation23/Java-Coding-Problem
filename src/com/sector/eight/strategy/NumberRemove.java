package com.sector.eight.strategy;

public class NumberRemove implements RemoveStrategy {

    // 수를 제거하는 전략
    @Override
    public String execute(String s) {
        return s.replaceAll("\\d", "");
    }
}
