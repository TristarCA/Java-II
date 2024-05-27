package May27Exercise;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class Numbers {
    @XmlElement(name="guesses")
    private List<Guess> guesses = new ArrayList<>();

    public List<Guess> getGuesses() {return guesses;}
}
