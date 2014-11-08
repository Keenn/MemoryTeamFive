package TeamFive;

import java.util.Scanner;

/**
 *
 * @author Keenn
 */
public interface Player {

    public int pickCard(Scanner sc, GameHandler gameHandler);

    public void addScore(int score);

    public int getScore();

    public void addnumOfTries(int tries);

    public int getNumOfTries();

    public void addNumPairsFound(int found);

    public int getNumPairsFound();

    public void reset();
}
