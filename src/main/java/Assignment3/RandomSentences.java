package Assignment3;

import java.util.ArrayList;
import java.util.Random;

public class RandomSentences {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<String> article = new ArrayList<>();
        ArrayList<String> noun = new ArrayList<>();
        ArrayList<String> verb = new ArrayList<>();
        ArrayList<String> preposition = new ArrayList<>();
        StringBuilder story = new StringBuilder();
        article.add("a");
        article.add("the");
        article.add("one");
        article.add("some");
        article.add("any");
        noun.add("boy");
        noun.add("girl");
        noun.add("dog");
        noun.add("town");
        noun.add("car");
        verb.add("drove");
        verb.add("jumped");
        verb.add("ran");
        verb.add("walked");
        verb.add("skipped");
        preposition.add("to");
        preposition.add("from");
        preposition.add("over");
        preposition.add("under");
        preposition.add("on");

        for (int i = 0; i <= 20; i++) {
            int articleIndex = rand.nextInt(5);
            String articleWord = article.get(articleIndex);
            int nounIndex = rand.nextInt(5);
            String nounWord = noun.get(nounIndex);
            int verbIndex = rand.nextInt(5);
            String verbWord = verb.get(verbIndex);
            int prepositionIndex = rand.nextInt(5);
            String prepositionWord = preposition.get(prepositionIndex);
            int article2Index = rand.nextInt(5);
            String article2Word = article.get(articleIndex);
            int noun2Index = rand.nextInt(5);
            String noun2Word = noun.get(nounIndex);
        }
    }
}
