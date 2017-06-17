package collins.john;

import java.util.Collections;

/**
 * Created by johncollins on 1/28/17.
 * Game is an abstract class that makes a shuffled deck, 2 players, and has a deal function.
 */
public class Game {
    Deck deck;
    Player player1;
    Player player2;

    public Game() {
        deck = new Deck();
        shuffleDeck();
//        player1 = new Player("Player One");
//        player2 = new Player("Player two");
    }

    protected void shuffleDeck() {
        Collections.shuffle(deck.cards);
        for (int i = 0; i < deck.cards.size() - 1; i++) {
            if (deck.getCardAtIndex(i).getCardValue() == 0) {
                Collections.swap(deck.cards, i, 0);
            }
        }
    }

    protected void deal(Player player, int quantityOfCards) {
        int cardsToDeal = 1;

        do {
            player.cards.add(this.deck.cards.get(1));
            this.deck.cards.remove(1);
            cardsToDeal++;
        }
        while (cardsToDeal <= quantityOfCards);
    }
    public void moveSomeCards(Player from, Player to, int quantityOfCards) {
        int cardsMoved = 1;
        do {
            to.cards.add(from.cards.get(1));
            from.cards.remove(1);
            cardsMoved++;
        }
        while (cardsMoved <= quantityOfCards);
    }
    public void moveCardFromPlayerByIndex(Player from, Player to, int fromIndex){
                to.cards.add(from.getCardAtIndex(fromIndex));
                from.cards.remove(fromIndex);
    }
    public void moveCardsByValue(Player from, Player to, int value){
        for (int j = 0; j < from.cards.size(); j++)
            if(from.getCardAtIndex(j).getCardValue() == value){
                moveCardFromPlayerByIndex(from, to, j);
                j--;
            }
    }



}
