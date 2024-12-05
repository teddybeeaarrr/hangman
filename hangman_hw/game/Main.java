package game;

public class Main {
    public static void main(String[] args) {
        Session session = new Session();
        ConsoleHangman game = new ConsoleHangman();
        game.run(session);
    }
}
