package com.sector.eight.executearound;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class Doubles {
    public static double read(ScannerDoubleFunction snf) throws IOException {
        try(Scanner sc = new Scanner(Path.of("doubles.txt"), StandardCharsets.UTF_8)) {
            return snf.readDouble(sc);
        }
    }
}
