/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeamFive;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Keenn
 */
public class Board {

    private final int size;

    public Board(int size) {
        this.size = size;
    }

    /**
     * This method is responsoble for shuffeling the list of cards.
     *
     * @param deck
     * @return
     */
    public List<Card> shuffleBoard(List<Card> deck) {
        Card tempCard;
        int rngNum;

        Random rng = new Random();

        for (int i = 0; i < 5; i++) {                   // Repeate 5times
            for (int x = 0; x < deck.size(); x++) {     // Swap process

                tempCard = deck.get(x);               // A hold place for the card that gonna swap
                rngNum = rng.nextInt(deck.size());      // Get a random number from 0 to deck size
                deck.set(x, deck.get(rngNum));         // the place [x] is replace with place [rng_num] 
                deck.set(rngNum, tempCard);              // the place[rng]is replace with temp_card so it wont get duplicated  

            }
        }

        return deck;
    }

    public List<Card> initCardsColor() {
        int index = 0;
        List<Card> deck = new ArrayList<>();
        String[] colors = {"Rose", "Rose", "Cyan", "Cyan", "Aero", "Aero", "Pink", "Pink", "Blue", "Blue", "Red", "Red", "Amber", "Amber", "Grey", "Grey", "Azura", "Azura", "Beige", "Beige", "Brown", "Brown",
            "Green", "Green", "Olive", "Olive", "Brass", "Brass", "Purple", "Purple", "Violet", "Violet", "Orange", "Orange", "Crimson", "Crimson",};

        if (size % 2 == 0) { //if the size is even

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    deck.add(new Card(colors[index], index));
                    index++;
                }
            }
        } else {
            System.err.println("Error in Card.setColorBoard()");
            System.err.println("Error! The size must be even");
            System.exit(size);
        }

        return deck;

    }

    public List<Card> initCardsNum() {
        List<Card> deck = new ArrayList<>();

        for (int i = 0; i < size * size / 2; i++) {
            deck.add(new Card(Integer.toString(i), i));
            deck.add(new Card(Integer.toString(i), i));
        }
        return deck;
    }
    /**
     * This method prints all the cards in the list.
     *
     * @param deck
     * @param showCard
     */
    public void printAllCard(List<Card> deck) {
        int i = 0;
        for (Card card : deck) {
            if (i % size == 0) { //new line
                System.out.println("\n");
            }
            card.showCard(true);
            i++;
        }
        System.out.println();
    }

    /**
     * This method is responible for showing the flipped cards.
     *
     * @param deck
     * @param cardNum
     */
    public void printHiddenCard(List<Card> deck, int cardNum) {

        for (int i = 0; i < deck.size(); i++) {

            if (i % size == 0) {
                System.out.println("\n");
            }

            if (i == cardNum) {
                deck.get(i).showCard(true);

            } else {
                System.out.printf("[ %2d]", i);
            }
        }
        System.out.println();
    }

    public void printHiddenCard(List<Card> deck, boolean showCardNum) {

        for (int i = 1; i < deck.size() + 1; i++) {

            if (i % size - 1 == 0) {
                System.out.println("\n");
            }
            if (showCardNum) {
                System.out.printf("[/%3d/]", i);

            } else {
                System.out.print("[/?/]");

            }
        }
        System.out.println();
    }
}
