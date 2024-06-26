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

        for (int i = 0; i < 20; i++) {
            int articleIndex = rand.nextInt(5);
            for (int j = 0; j < (article.get(articleIndex).toCharArray().length); j++) {
                if (j == 0) {
                    char c = (article.get(articleIndex).toCharArray())[j];
                    story.append(Character.toUpperCase(c));
                } else {
                    char c = (article.get(articleIndex).toCharArray())[j];
                    story.append(c);
                }
            }
            story.append(' ');
            int nounIndex = rand.nextInt(5);
            story.append(noun.get(nounIndex)).append(' ');
            int verbIndex = rand.nextInt(5);
            story.append(verb.get(verbIndex)).append(' ');
            int prepositionIndex = rand.nextInt(5);
            story.append(preposition.get(prepositionIndex)).append(' ');
            int article2Index = rand.nextInt(5);
            story.append(article.get(article2Index)).append(' ');
            int noun2Index = rand.nextInt(5);
            story.append(noun.get(noun2Index)).append(". ");
        }
        System.out.println(story);
    }
}
