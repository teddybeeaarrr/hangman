package game;

import java.util.Scanner;

public class ConsoleHangman {
    public void run (Session session) {

        System.out.println("игра началась! у вас есть 5 жизней");
        System.out.println("чтобы сдаться, напишите команду 'сдаюсь' в поле ввода");

        Scanner in = new Scanner(System.in);

        while (true) {

            System.out.println("\nслово: " + session.getUserAnswer());
            System.out.println("введите букву: ");

            String request = in.nextLine();

            if (request.equals("сдаюсь")) {
                System.out.println("вы сдались...");
                System.out.println("правильным ответом было слово " + session.getAnswer());
                break;
            } else {
                char letter = request.charAt(0);
                boolean letterWasUsed = false;
                for (int i = 0; i < session.getLettersUsed().size(); i++) {
                    if (letter == session.getLettersUsed().get(i)) {
                        letterWasUsed = true;
                        break;
                    }
                }
                if (letterWasUsed) {
                    System.out.println("вы уже вводили эту букву");
                    continue;
                }

                session.guess(letter);
                if (session.getAnswer().equals(session.getUserAnswer())) {
                    System.out.println("\nпоздравляю, вы великолепный!!");
                    break;
                } else if (session.getAttemptsLeft() == 0) {
                    System.out.println("\nпупупу... вы проиграли");
                    System.out.println("правильным ответом было слово " + session.getAnswer());
                    break;
                }
            }
        }
        in.close();
    }
}
