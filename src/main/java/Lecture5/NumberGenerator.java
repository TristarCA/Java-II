package Lecture5;

import java.util.Random;

public class NumberGenerator {
    public int numberSelector() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
}
