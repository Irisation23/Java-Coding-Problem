package com.sector.eight.filter;

import java.util.ArrayList;
import java.util.List;

public class Trucks {

    List<Melon> melons;
    public void loadMelons(int number) {
         melons = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            melons.add(new Melon("gac", 10, "korea"));
        }
    }

    public List<Melon> getMelons() {
        return melons;
    }
}
