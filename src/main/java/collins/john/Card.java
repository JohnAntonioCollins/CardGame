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

    public String getCard(){
        String cARD = ((Integer.toString(this.cardValue) + this.suit));
        return cARD;
        }

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }
}