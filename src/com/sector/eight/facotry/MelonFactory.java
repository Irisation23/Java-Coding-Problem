package com.sector.eight.facotry;

import java.util.Map;
import java.util.function.Supplier;

public class MelonFactory {

    private static final Map<String, Supplier<Fruit>> MELONS = Map.of("Gac", Gac::new, "Hemi", Hemi::new,
            "Cantaloupe", Cantaloupe::new);

    private static final TriFunction<String, Integer, String, Melon> MELON = Melon::new;

    public static Fruit newInstance(Class<?> clazz) {
        switch (clazz.getSimpleName()) {
            case "Gac":
                return new Gac();
            case "Hemi":
                return new Hemi();
            case "Cantaloupe":
                return new Cantaloupe();
            default:
                throw new IllegalArgumentException("Invalid clazz argument: " + clazz);
        }
    }

    public static Fruit newInstance(String name, int weight, String color) {
        return MELON.apply(name, weight, name);
    }

    public static Fruit newInstanceSupplierVersion(Class<?> clazz) {
        Supplier<Fruit> supplier = MELONS.get(clazz.getSimpleName());

        if (supplier == null) {
            throw new IllegalArgumentException("Invalid clazz argument:" + clazz);
        }

        return supplier.get();
    }
}
