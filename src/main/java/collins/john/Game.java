package collins.john;

import java.util.Collections;

/**
 * Created by johncollins on 1/28/17.
 */
public class Game {
    //abstract class with card compare and sort methods
    //SHUFFLE
    //DEAL
    //sets rules of game
    //does calculations of game
    //moves cards as per rules & calculations

    Deck deck;
    Player player;
    int cardsToDeal = 0;

    public Game() {
        deck = new Deck();
        shuffleDeck();
        player = new Player("Player One");
    }

    public void deal(int quantityOfCards) {
        do {
            this.player.cards.add(this.deck.cards.get(cardsToDeal));
            cardsToDeal++;
        }
        while (cardsToDeal < quantityOfCards);
    }

    private void shuffleDeck() {
        Collections.shuffle(deck.cards);
        for (int i = 0; i < deck.cards.size() - 1; i++) {
            if (deck.getCardAtIndex(i).getCardValue() == 0) {
                Collections.swap(deck.cards, i, 0);
            }

        }
    }
}
