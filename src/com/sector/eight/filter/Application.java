package com.sector.eight.filter;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        filtering();
    }

    private static void filtering() {
        Trucks trucks = new Trucks();
        trucks.loadMelons(100);

        List<Melon> melons = trucks.getMelons();

        Filters.filterMelons(melons, new GacMelonPredicate());
        Filters.filterMelons(melons, new HugeMelonPredicate());

        List<Melon> euroeansLamda = Filters.filterMelons(melons, m -> "korea".equalsIgnoreCase(m.getOrigin()));

        List<Melon> watermelons = Filters.filter(melons, (Melon m) -> "Watermelon".equalsIgnoreCase(m.getType()));
        List<Integer> number = Arrays.asList(1, 13, 15, 2, 67);
        List<Integer> smallThan10 = Filters.filter(number, i -> i < 10);
    }
}
