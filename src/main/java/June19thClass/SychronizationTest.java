package June19thClass;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.synchronizedList;
import static java.util.Collections.unmodifiableList;

public class SychronizationTest {
    public static void main(String[] args) {
        List<Integer> scores = new ArrayList();
        scores.add(10); scores.add(11); scores.add(12); scores.add(13);

        // Next line can be different types of lists for different effects

        List<Integer> syncList = unmodifiableList(scores);

        System.out.println(syncList);
        syncList.add(14);
        System.out.println(syncList);
    }
}
