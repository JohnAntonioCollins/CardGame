package collins.john;

/**
 * Created by johncollins on 1/27/17.
 */


public class Card{
    private int cardValue;
    private char suit;

    public Card(int cardValue, char suit) {
        this.cardValue = cardValue;
        this.suit = suit;
        }

    public String getCardName(){
        String card = ((Integer.toString(this.cardValue) + this.suit));
        return card;
        }

    public int getCardValue() {
        return cardValue;
    }

    public char getSuit() {
        return suit;
    }
}
