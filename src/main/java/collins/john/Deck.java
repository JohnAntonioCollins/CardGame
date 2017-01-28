package collins.john;

import java.util.ArrayList;

/**
 * Created by johncollins on 1/27/17.
 */
public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();

    public Deck() {
        for (int i = 0; i < 53; i++) {
            if (i < 14) {
                Card card = new Card(i, 'C');
                deck.add(card);
            }
            if (i >= 14 && i < 27) {

                Card card = new Card(i-13, 'D');
                deck.add(card);
            }
            if (i >= 27 && i < 40) {

                Card card = new Card(i-26, 'H');
                deck.add(card);
            }
            if (i >= 40) {

                Card card = new Card(i-39, 'S');
                deck.add(card);
            }
        }
        return;
    }//end Deck

    public Card getDeckIndex(int i) {
        return deck.get(i);
    }
    /*
    putCard(){

    }

    takeCard(){}
    */
}
