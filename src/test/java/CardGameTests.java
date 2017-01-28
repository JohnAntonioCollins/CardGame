import collins.john.Card;
import collins.john.Deck;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by johncollins on 1/27/17.
 */
public class CardGameTests {

    Card testCard;
    Deck testDeck;
    @Before
    public void setUp() throws Exception {
        testCard = new Card(3, 'C');
        testDeck = new Deck();
    }
    @Test
    public void getCardTest(){
        String actual = testCard.getCard();
        String expected = "3C";
        assertEquals("should return cARD 3C", "3C", actual);
    }
    @Test
    public void getDeckIndexTest(){
        String actual = testDeck.getDeckIndex(52).getCard();
        String expected = "13S";

        assertEquals("should return '13S'", expected, actual);
    }
    @Test
    public void getCardValueTest(){
        int actual = testCard.getCardValue();
        int expected = 3;
        assertEquals("should return testCard's cardValue field.", expected, actual);
    }
    @Test
    public void getCardSuitTest(){
        char actual = testCard.getSuit();
        char expected = 'C';
        assertEquals("should return the suit of the card", expected, actual);
    }
}
