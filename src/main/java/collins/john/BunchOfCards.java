package collins.john;

import java.util.ArrayList;

/**
 * Created by johncollins on 1/28/17.
 */
public class BunchOfCards
{
    protected ArrayList<Card> cards = new ArrayList<Card>(1);


    public void add(Card card)
    {
        cards.add(card);
    }

    public Card get(int index)
    {
        return cards.get(index);
    }

    public void remove(int index)
    {
        cards.remove(index);
    }

    public void clear()
    {
        cards.clear();
    }

    public int size()
    {
        return cards.size();
    }

    public int valueOfNewestCard() { return get(indexOfNewestCard()).getCardValue();}

    public int indexOfNewestCard() { return this.cards.size() - 1; }

    public String getAllCardsNow()
    {
        String currentCards = "";
        String twoSpaces = "  ";
        for (Card card : cards)
        {
            currentCards += card.getCardName() + twoSpaces;
        }
        return currentCards;
    }

    public int getQuantityOfCards()
    {
        return cards.size();
    }

    public int getHighestCardValue()
    {
        int highestCardValue = 0;
        for (Card card : cards)
        {
            if (card.getCardValue() > highestCardValue)
            {
                highestCardValue = card.getCardValue();
            }
        }
        return highestCardValue;
    }

    public boolean hasCard(int askedValue)
    {
        for (Card card : cards)
        {
            if (card.getCardValue() == askedValue)
            {
                return true;
            }
        }
        return false;
    }


    public boolean hasCardGroup(int askedValue, int minQuantity)
    {
        int matches = 0;
        if (cards.size() < minQuantity) {return false;}
        for (Card card : cards)
        {
            if (card.getCardValue() == askedValue) matches++;
        }
        if (matches >= minQuantity)
        {
            return true;
        }
        return false;

    }

}
