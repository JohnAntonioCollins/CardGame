package collins.john;

import java.util.ArrayList;

/**
 * Created by johncollins on 1/28/17.
 */
public class CollectionOfCards {
    protected ArrayList<Card> cards = new ArrayList<Card>();


    public Card getCardAtIndex(int i) {
        return this.cards.get(i);
    }
    public String getAllCardsNow() {
        String currentCards = "";
        for (int i = 0; i < cards.size() - 1; i++) {
            currentCards += cards.get(i).getCardName() + "\n";
        }
        return currentCards;
    }// end getDeckNow
    public int getQuantityOfCards(){
        return cards.size();
    }
}
