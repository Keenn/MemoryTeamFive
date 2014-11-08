/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeamFive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Keenn
 */
public class Demo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Card> listOfCards = new ArrayList<>();
        List<Player> listOfPlayer = new ArrayList<>();
        GameHandler gm = new GameHandler();
        Board board;

        System.out.println("_______________Board_______________");
        System.out.println("| It could have various size");
        System.out.println("\n[4x4]    [6x6]    [6x7]    [10x12]  ");

        board = new Board(4,4);
        listOfCards = board.initCardsColor();
        board.printHiddenCard(listOfCards, false);
        System.out.println("4x4");

        board = new Board(6,6);
        listOfCards = board.initCardsColor();
        board.printHiddenCard(listOfCards, false);
        System.out.println(" 6x6\n");

        board = new Board(6,7);
        listOfCards = board.initCardsNum();
        board.printHiddenCard(listOfCards, false);
        System.out.println(" 6x7\n");

        board = new Board(10,12);
        listOfCards = board.initCardsNum();
        board.printHiddenCard(listOfCards, false);
        System.out.println(" 10x12\n");

        System.out.println("_______________Board_______________");
        System.out.println("| Difference theme");

        board = new Board(4,5);
        listOfCards = board.initCardsColor();
        board.printAllCard(listOfCards);
        System.out.println("4x5 Color theme");

        board = new Board(4,4);
        listOfCards = board.initCardsNum();
        board.printAllCard(listOfCards);
        System.out.println("4x4 Number theme");

        board = new Board(4,4);
        listOfCards = board.initCardsColor();
        board.shuffleBoard(listOfCards);
        board.printAllCard(listOfCards);
        System.out.println("Shuffle 4x4 Color theme");

        board = new Board(4,4);
        listOfCards = board.initCardsNum();
        board.shuffleBoard(listOfCards);
        board.printAllCard(listOfCards);
        System.out.println("Shuffle 4x4 Number theme");

        System.out.println("\n\n_______________Player_______________");
        System.out.println("| Add player to the game \n");
        listOfPlayer = gm.addPlayer(listOfPlayer, scan);

        
        for (Player player : listOfPlayer) {
            System.out.printf("Name:%s have %d point \n", player, player.getScore());

        }
    }
}
