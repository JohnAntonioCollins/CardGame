package collins.john;

import java.util.Collections;

/**
 * Created by johncollins on 1/28/17.
 * Game is an abstract class that makes a shuffled deck, a player, and has a deal function.
 */
public class Game {
    Deck deck;
    Player player1;
    Player player2;
    //int cardsToDeal = 1;

    public Game() {
        deck = new Deck();
        shuffleDeck();
        player1 = new Player("Player One");
        player2 = new Player("Player two");
    }

    private void shuffleDeck() {
        Collections.shuffle(deck.cards);
        for (int i = 0; i < deck.cards.size() - 1; i++) {
            if (deck.getCardAtIndex(i).getCardValue() == 0) {
                Collections.swap(deck.cards, i, 0);
            }

        }
    }

    public void deal(Player player, int quantityOfCards) {
        int cardsToDeal = 1;

        do {
            player.hand.add(this.deck.cards.get(1));
            this.deck.cards.remove(1);
            cardsToDeal++;
        }
        while (cardsToDeal <= quantityOfCards);
    }
    public void moveCards(Player from, Player to, int quantityOfCards) {
        int cardsMoved = 1;
        do {
            to.hand.add(from.hand.get(1));
            from.hand.remove(1);
            cardsMoved++;
        }
        while (cardsMoved <= quantityOfCards);
    }
}
