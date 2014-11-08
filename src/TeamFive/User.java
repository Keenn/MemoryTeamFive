
package TeamFive;

import java.util.Scanner;

/**
 *
 * @author Keenn
 */
public class User implements Player{

    private int score;
    private final String name;

    public User(String name) {
        this.name = name;
        this.score = 0;
    }

    @Override
    public int pickCard(Scanner sc, GameHandler gameHandler) {

        System.out.println("Pick a Card");
        return gameHandler.getUserInt(sc, 0, 0);

    }

    @Override
    public void addScore(int score) {
        this.score += score;

    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void resetScore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
