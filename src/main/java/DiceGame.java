import implementations.CircularLinkedList;

import java.util.Random;

class Player {
    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int value) {
        score += value;
    }
}

public class DiceGame {
    private CircularLinkedList<Player> players;
    private int numRounds;

    public DiceGame(int numPlayers, int numRounds) {
        this.players = new CircularLinkedList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.insertLast(new Player("Player " + i, 0)); // Initialize each player's score to 0
        }
        this.numRounds = numRounds;
    }

    public void play() {
        Random random = new Random();

        for (int round = 1; round <= numRounds; round++) {
            int count = 0;
            System.out.println("Round " + round + ":");

            while (count < players.getSize()){
                int diceValue = random.nextInt(6) + 1;
                System.out.print(diceValue+ " ");
                players.getNext().addToScore(diceValue);
                count++;
            }
            System.out.println();
        }
    }

    public void displayScores() {
        System.out.println("Final scores:");
        int count = 0;
        while (count < players.getSize()){
            Player player = players.getNext();
            System.out.println(player.getName() + ": " + player.getScore() );
            count++;
        }
    }

    public static void main(String[] args) {
        int numPlayers = 3;
        int numRounds = 5;

        DiceGame diceGame = new DiceGame(numPlayers, numRounds);
        diceGame.play();
        diceGame.displayScores();
    }
}






