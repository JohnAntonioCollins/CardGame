package collins.john;

/**
 * Created by johncollins on 1/27/17.
 */
public class Deck extends CollectionOfCards{

    public Deck(){
        this.makeDeck();
    }
    //private ArrayList<Card> deck = cards;
    public void makeDeck() {
        Card card = new Card(0, 'e');// 'error card' 0e
        cards.add(card);
        for (int i = 1; i < 55; i++) {
            if (i < 14) {
                card = new Card(i, 'C');
                cards.add(card);
            }
            if (i >= 14 && i < 27) {

                card = new Card(i - 13, 'D');
                cards.add(card);
            }
            if (i >= 27 && i < 40) {

                card = new Card(i - 26, 'H');
                cards.add(card);
            }
            if (i >= 40 && i < 53) {

                card = new Card(i - 39, 'S');
                cards.add(card);
            }
            if (i >= 53 && i < 55) {

                card = new Card(i - 52, 'R');// jokeR 1, jokeR 2.
                cards.add(card);
            }
        }
        return;
    }//end makeDeck
}
