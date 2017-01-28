import collins.john.Card;
import collins.john.Deck;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by johncollins on 1/27/17.
 */
public class CardGameTests {


    Card testCard = new Card(3, 'C');
    Deck testDeck = new Deck();

    @Test
    public void CardClassUnitTest(){

        String actual = testCard.getCard();
        String expected = "3C";

        assertEquals("should return cARD 3C", "3C", actual);
    }
    /*@Test
    public void DeckClassUnitTest(){
        Deck testDeck = new Deck();
        String actual = "";
        for (Card i : testDeck
             ) {actual += i.getCard();
        }
        String expected = "1C";
        assertEquals("should return string of cards; '1C2C3C...10S11S12S", expected, actual);
    }
    */
    @Test
    public void getDeckIndexTest(){
        String actual = testDeck.getDeckIndex(52).getCard();
        String expected = "13S";

        assertEquals("should return '13S'", expected, actual);


    }
}
