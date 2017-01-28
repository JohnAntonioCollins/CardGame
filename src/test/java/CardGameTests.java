import collins.john.Card;
import collins.john.Deck;
import collins.john.Hand;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by johncollins on 1/27/17.
 */
public class CardGameTests {

    Card testCard;
    Deck testDeck;
    Hand testHand;
    @Before
    public void setUp() throws Exception {
        testCard = new Card(3, 'C');
        testDeck = new Deck();
        testHand = new Hand();
    }
    @Test
    public void getCardTest(){
        String actual = testCard.getCard();
        String expected = "3C";
        assertEquals("should return cARD 3C", "3C", actual);
    }
    @Test
    public void getDeckIndexTest(){
        String actual = testDeck.getCardAtIndex(54).getCard();
        String expected = "2R";

        assertEquals("should return '2R', last card, Joker", expected, actual);
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
    @Test
    public void getDeckNowTest(){
        String actual = testDeck.getAllCardsNow();//full deck including error card and jokers
        //System.out.println(testDeck.getDeckNow());
        String expected = "0e"+"\n"+"1C"+"\n"+"2C"+"\n"+"3C"+"\n"+"4C"+"\n"+"5C"+"\n"+"6C"+"\n"+"7C"+"\n"+"8C"+"\n"+"9C"+"\n"+"10C"+"\n"+"11C"+"\n"+"12C"+"\n"+"13C"+"\n"+"1D"+"\n"+"2D"+"\n"+"3D"+"\n"+"4D"+"\n"+"5D"+"\n"+"6D"+"\n"+"7D"+"\n"+"8D"+"\n"+"9D"+"\n"+"10D"+"\n"+"11D"+"\n"+"12D"+"\n"+"13D"+"\n"+"1H"+"\n"+"2H"+"\n"+"3H"+"\n"+"4H"+"\n"+"5H"+"\n"+"6H"+"\n"+"7H"+"\n"+"8H"+"\n"+"9H"+"\n"+"10H"+"\n"+"11H"+"\n"+"12H"+"\n"+"13H"+"\n"+"1S"+"\n"+"2S"+"\n"+"3S"+"\n"+"4S"+"\n"+"5S"+"\n"+"6S"+"\n"+"7S"+"\n"+"8S"+"\n"+"9S"+"\n"+"10S"+"\n"+"11S"+"\n"+"12S"+"\n"+"13S"+"\n"+"1R"+"\n"+"2R"+"\n";
        //System.out.println(expected);
        assertEquals("should return list of cards now in deck", expected, actual);
    }
    @Test
    public void HandgetQauntityOfCardsTest(){
        int actual = testHand.getQuantityOfCards();
        int expected = 0;
        assertEquals("hand should start empty, 0", expected, actual);
    }
    @Test
    public void DiscardgetQauntityOfCardsTest(){
        String actual = testHand.getDiscardedCards();
        String expected = "";
        assertEquals("should return empty string because there's no data in an empty arrayList", expected, actual);
    }
}
