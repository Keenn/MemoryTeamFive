/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeamFive;

/**
 *
 * @author Keenn
 */
public class Card {

    private final String cardName;
    private final int cardNum;
    private boolean flipped;

    public Card(String theBack, int cardID) {
        this.cardName = theBack;
        this.cardNum = cardID;
        this.flipped = false;
    }

    public String getCardBack() {
        return this.cardName;
    }

    public int getCardNum() {
        return this.cardNum;
    }

    public boolean getFlipped() {
        return this.flipped;
    }

    public void seFlipped(boolean flipp) {
        this.flipped = flipp;
    }

    public void showCard(boolean showing) {
        if (showing) {
            System.out.printf(" [ %2s] ", cardName);

        } else {
            System.out.printf(" [ Id:%s] ", cardNum);
        }

    }
}
