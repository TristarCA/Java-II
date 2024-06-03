package June3Class;

import java.util.Random;

public class Scrambler {
    public static void main(String[] args) {
        String name = "Tristan Norman";
        Random rand = new Random();
        char[] list = name.toCharArray();
        for (int i=0; i<20; i++) {
            int index = rand.nextInt(name.length());
            char randChar = (char) rand.nextInt(97, 122);
            list[index] = randChar;
            System.out.println(list);
        }
        StringBuilder newName = new StringBuilder();
        for (char c : list) {
            newName.append(c);
        }
        System.out.println(newName);
    }
}
