package com.sector.eight.strategy;

public class WhitespaceRemover implements RemoveStrategy {

    // 여백을 제거하는 전략
    @Override
    public String execute(String s) {
        return s.replaceAll("\\s", "");
    }
}
