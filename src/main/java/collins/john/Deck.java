package collins.john;

import java.util.ArrayList;

/**
 * Created by johncollins on 1/27/17.
 */
public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();

    public Deck() {
        Card card = new Card(0, 'e');// 'error card' 0e
        deck.add(card);
        for (int i = 1; i < 56; i++) {
            if (i < 14) {
                card = new Card(i, 'C');
                deck.add(card);
            }
            if (i >= 14 && i < 27) {

                card = new Card(i-13, 'D');
                deck.add(card);
            }
            if (i >= 27 && i < 40) {

                card = new Card(i-26, 'H');
                deck.add(card);
            }
            if (i >= 40 && i < 53) {

                card = new Card(i-39, 'S');
                deck.add(card);
            }
            if (i >= 53 && i < 56) {

                card = new Card(i - 52, 'R');
                deck.add(card);
            }
        }
        return;
    }//end Deck

    public Card getDeckIndex(int i) {
        return deck.get(i);
    }
    public String getDeckNow() {
        String currentDeck = "";
        for (int i = 0; i < deck.size() - 1; i++) {
            currentDeck += deck.get(i).getCard() + "\n";
        }
        return currentDeck;//deck.get(deck.size()-1).getCard();//should return 'error card' 55e
    }



    /*
    putCard(){

    }

    takeCard(){}
    */
}
