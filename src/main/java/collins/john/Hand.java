package collins.john;

import java.util.ArrayList;

/**
 * Created by johncollins on 1/28/17.
 */
public class Hand extends CollectionOfCards{
   ArrayList<Card> hand = cards;
   CollectionOfCards discard = new CollectionOfCards();
   public String getDiscardedCards(){
      return discard.getAllCardsNow();
   }
}

