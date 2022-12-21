package com.sector.eight.strategy;

public class Application {

    public static void main(String[] args) {
        String text = "This is a text from 20 April 2050";

        // noNr1 과 noNr은 동작이 같다.
        // 구현체를 클래스 내부에서 지정하는 noNr1 보다는 익명 클래스를 이용한 람다로 표현하는게 좋음.
        String noNr1 = Remover.remove(text, new NumberRemove());
        String noNr = Remover.remove(text, s -> s.replaceAll("\\d", ""));

        String noWr = Remover.remove(text, s -> s.replaceAll("\\s", ""));
    }
}
