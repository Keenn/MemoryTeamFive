package TeamFive;

import java.util.Scanner;

/**
 *
 * @author Keenn
 */
public class User implements Player {

    private int score, numPairsFound, numOfTries;
    private final String name;

    public User(String name) {
        this.name = name;
        this.score = 0;
        this.numPairsFound = 0;
        this.numOfTries = 0;
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
    public void addnumOfTries(int tries) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumOfTries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addNumPairsFound(int found) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumPairsFound() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
