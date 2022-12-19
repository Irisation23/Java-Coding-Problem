package com.sector.eight.executearound;

import java.io.IOException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws IOException {
        run();
    }

    private static void run() throws IOException {
        double singleDouble = Doubles.read((Scanner sc) -> getFirst(sc));
        double sumAllDoubles = Doubles.read((Scanner sc) -> sumAll(sc));

    }

    private static double getFirst(Scanner scanner) {
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        }

        return Double.NaN;
    }

    private static double sumAll(Scanner scanner) {
        double sum = 0.0d;

        while (scanner.hasNextDouble()) {
            sum += scanner.nextDouble();
        }

        return sum;
    }
}
