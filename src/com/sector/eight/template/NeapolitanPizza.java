package com.sector.eight.template;

public class NeapolitanPizza extends PizzaMaker {

    @Override
    public void addTopIngredients(Pizza pizza) {
        System.out.println("추가: 소스와 치즈");
    }
}
