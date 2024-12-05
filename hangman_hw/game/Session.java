package game;

import java.util.ArrayList;

public class Session {

    private final String answer;
    private final char[] userAnswer;
    private ArrayList<Character> lettersUsed;
    private int attemptsLeft;

    public Session() {
        Dictionary dict = new Dictionary();
        answer = dict.randomWord();
        userAnswer = new char[answer.length()];
        for (int i = 0; i < answer.length(); i++) {
            userAnswer[i] = '_';
        }
        attemptsLeft = 5;
        lettersUsed = new ArrayList<Character>(33);
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public String getAnswer() {
        return answer;
    }

    public String getUserAnswer() {
        return new String(userAnswer);
    }

    public ArrayList<Character> getLettersUsed() {
        return lettersUsed;
    }

    public void guess(char letter) {
        lettersUsed.add(letter);
        boolean success = false;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == letter) {
                userAnswer[i] = letter;
                success = true;
            }
        }
        if (success) {
            System.out.println("такая буква есть!");
        } else {
            attemptsLeft--;
            System.out.println("увы, мимо...");
            System.out.println("осталось жизней: " + attemptsLeft);
            }
        }

    }