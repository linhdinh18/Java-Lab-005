/**
 *
 * @author Trevor Hartman
 * @author Linh Dinh
 *
 * @since Version 1.0
 *
 */
import java.util.Scanner;

public class Game {
    Player p1;
    Player p2;
    Dice die;
    public Game(Player p1, Player p2, Dice die){
        this.p1 = p1;
        this.p2 = p2;
        this.die = die;
    }

    public void play() {
        Player current = this.p1;
        takeTurn(current);
        current = nextPlayer(current);
        takeTurn(current);
        System.out.println(announceWinner());

    }

    public Player nextPlayer(Player current) {
        if(current == this.p1){
            return this.p2;
        } else {
            return this.p1;
        }

    }

    public void takeTurn(Player player) {
        player.toss(this.die);
    }

    public String announceWinner() {
        System.out.println(p1.getName() + " scored " + p1.getScore() + " points.");
        System.out.println(p2.getName() + " scored " + p2.getScore() + " points.");

        if (p1.getScore() > p2.getScore()) {
            return "The winner is " + p1.getName();
        } else if (p2.getScore() > p1.getScore()) {
           return "The winner is " + p2.getName();
        } else {
            return "It's a tie!";
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number of sides: ");
        int sides = input.nextInt();
        Dice die = new Dice(sides);
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");
        Game game = new Game(p1, p2, die);
        game.play();


    }
}
