package com.sector.eight.template;

public abstract class PizzaMaker {
    public void make(Pizza pizza) {
        makeDough(pizza);
        addTopIngredients(pizza);
        bake(pizza);
    }

    private void makeDough(Pizza pizza) {
        System.out.println("도우 만들기");
    }

    private void bake(Pizza pizza) {
        System.out.println("피자 굽기");
    }

    public abstract void addTopIngredients(Pizza pizza);
}
