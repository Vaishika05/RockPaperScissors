package rockPaperScissors;

import java.util.ArrayList;
import java.util.Random;

public class Computer {
    String choice = "";

    public String selectRandomImage() {
        ArrayList<String> choices = new ArrayList<>();
        choices.add("Rock");
        choices.add("Paper");
        choices.add("Scissors");

        Random random = new Random();
        choice = choices.get(random.nextInt(choices.size()));
        return this.choice;
    }

}
