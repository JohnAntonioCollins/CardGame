package collins.john;

import java.util.ArrayList;

/**
 * Created by johncollins on 1/28/17.
 */
public class CollectionOfCards {
    protected ArrayList<Card> cards = new ArrayList<Card>(1);

    private int highestCardValue = 0;



    public Card getCardAtIndex(int i) {
        return this.cards.get(i);
    }
    public String getAllCardsNow() {
        String currentCards = "";
        for (int i = 0; i < cards.size(); i++) {
            currentCards += cards.get(i).getCardName() + "  ";
        }
        return currentCards;
    }// end getDeckNow
    public int getQuantityOfCards(){
        return cards.size();
    }

    public int getHighestCardValue() {
        for (int i = 0; i < cards.size(); i++) {
            if (this.getCardAtIndex(i).getCardValue() > highestCardValue) {
                highestCardValue = this.getCardAtIndex(i).getCardValue();
            }
        }
        return highestCardValue;
    }

}
