package game;

import java.util.Random;

public class Dictionary {

    private final String[] dictionary = {"инкапсуляция", "полиморфизм", "наследование", "помогите", "пожалуйста"};

    public Dictionary() {}

    public String randomWord() {
        Random rand = new Random();
        return dictionary[rand.nextInt(dictionary.length)];
    }

}