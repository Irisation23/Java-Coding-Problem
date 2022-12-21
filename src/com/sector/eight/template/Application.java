package com.sector.eight.template;

public class Application {

    public static void main(String[] args) {
        Pizza nPizza = new Pizza();
        PizzaMaker nMaker = new NeapolitanPizza();
        nMaker.addTopIngredients(nPizza);

        Pizza lamdaPizza = new Pizza();
        new PizzaLamda().make(lamdaPizza, (Pizza p) -> System.out.println("추가: 토마토와 비트, 양파, 앤초비, 허브"));
    }
}
