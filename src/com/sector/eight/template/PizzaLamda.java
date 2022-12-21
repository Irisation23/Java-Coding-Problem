package com.sector.eight.template;

import java.util.function.Consumer;

public class PizzaLamda {
    public void make(Pizza pizza, Consumer<Pizza> addTopIngredients) {
        makeDough(pizza);
        addTopIngredients.accept(pizza);
        bake(pizza);
    }

    private void makeDough(Pizza p) {
        System.out.println("도우 만들기");
    }

    private void bake(Pizza p) {
        System.out.println("피자 굽기");
    }
}
