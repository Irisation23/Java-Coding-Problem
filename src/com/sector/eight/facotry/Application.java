package com.sector.eight.facotry;

import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Gac gac = (Gac) MelonFactory.newInstanceSupplierVersion(Gac.class);
        Supplier<Fruit> gac2 = Gac::new;
        //위의 두 코드는 같은 행위를 한다. 하지만 이 경우는 생성자의 파라미터가 없는 기본 생성자일 경우에 가능하다. 만약 인자가 늘어나는 상황이라면?

        //상위 클래스로 리턴하는 메서드가 하위 객체로 받기 위해서는 반드시 타입 캐스팅이 필요하다.
        Melon melon = (Melon) MelonFactory.newInstance("Gac", 2000, "red");
    }
}
