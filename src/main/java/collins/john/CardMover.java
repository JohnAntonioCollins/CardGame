package collins.john;

import java.util.Collections;

/**
 * Created by johncollins on 1/28/17.
 * CardMover is an abstract class that makes a shuffled deck.
 */
public class CardMover
{
    Deck deck;

    public CardMover()
    {
        deck = new Deck();
        shuffleDeck();
    }

    protected void shuffleDeck()
    {
        Collections.shuffle(deck.cards);
        for (int i = 0; i < deck.cards.size() - 1; i++)
        {
            if (deck.get(i).getCardValue() == 0)
            {
                Collections.swap(deck.cards, i, 0);
            }
        }
    }

    protected void deal(Player player, int quantityOfCards)
    {
        int cardsToDeal = 1;
        if (this.deck.size() > 1)
        {
            do
            {
                player.hand.add(this.deck.cards.get(1));
                this.deck.cards.remove(1);
                cardsToDeal++;
            } while (cardsToDeal <= quantityOfCards);
        }
    }

    public void moveCardFromPlayerByIndex(Player from, Player to, int fromIndex)
    {
        to.hand.add(from.hand.get(fromIndex));
        from.hand.remove(fromIndex);
    }

    public void moveCardsByValue(Player from, Player to, int value)
    {
        for (int j = 0; j < from.hand.size(); j++)
        {
            if (from.hand.get(j).getCardValue() == value)
            {
                moveCardFromPlayerByIndex(from, to, j);
                j--;
                if(from.hand.size() < 1){break;}
            }
        }
    }

    public void moveCardsByValue(BunchOfCards from, BunchOfCards to, int value)
    {
        for (int i = 0; i < from.size(); i++)
        {
            if (from.get(i).getCardValue() == value)
            {
                to.cards.add(from.get(i));
                from.cards.remove(from.get(i));
                i--;
                if(from.size() < 1){break;}
            }
        }
    }

    public void moveSomeCards(Player sender, Player receiver, int quantityOfCards)
    {
        int cardsMoved = 1;
        do
        {
            receiver.hand.add(sender.hand.get(1));
            sender.hand.remove(1);
            cardsMoved++;
        } while (cardsMoved <= quantityOfCards);
    }


}
