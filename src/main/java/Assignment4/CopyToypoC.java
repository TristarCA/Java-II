package Assignment4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CopyToypoC {
    public static void main(String[] args) {
        Character[] characters =
                {'H', 'o', 'w', 'a', 'r', 'e', 'y', 'o', 'u', '?'};

        List<Character> list1 = new LinkedList<>(Arrays.asList(characters));

        List<Character> list2 = new LinkedList<>();


        Iterator<Character> iterator1 = list1.iterator();
        int index = list1.size()-1;
        while(iterator1.hasNext()) {
            Character character = list1.get(index);
            list2.add(character);
            if (index > 0) {
                index--;
            } else {
                break;
            }
        }
        System.out.println(list2);
        System.out.println(list1);
    }
}
