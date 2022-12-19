package com.sector.eight.filter;

/**
 * 고객은 자신의 아이디어와 결정을 반영할 수 있는 재고 어플리케이션을 원한다.
 * 비즈니스 요구 사항과 발전에 따라 애플리케이션도 진화해야 한다.
 */
public class Melon {

    private final String type;
    private final int weight;
    private final String origin;

    public Melon(String type, int weight, String origin) {
        this.type = type;
        this.weight = weight;
        this.origin = origin;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public String getOrigin() {
        return origin;
    }



}
