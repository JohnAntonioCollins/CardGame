package collins.john;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by johncollins on 1/27/17.
 */
public class CardGameTests {

    Card testCard;
    Deck testDeck;
    CollectionOfCards testHandetc;
    Game testGame;

    @Before
    public void setUp() throws Exception {
        testCard = new Card(3, 'C');
        testDeck = new Deck();
        testHandetc = new CollectionOfCards();
        testGame = new Game();
    }

    @Test
    public void getCardNameTest() {
        String actual = testCard.getCardName();
        String expected = "3C";
        assertEquals("should return cARD 3C", "3C", actual);
    }

    @Test
    public void getDeckIndexTest() {
        String actual = testDeck.getCardAtIndex(54).getCardName();
        String expected = "2R";

        assertEquals("should return '2R', last card, Joker", expected, actual);
    }

    @Test
    public void getCardValueTest() {
        int actual = testCard.getCardValue();
        int expected = 3;
        assertEquals("should return testCard's cardValue field.", expected, actual);
    }

    @Test
    public void getCardSuitTest() {
        char actual = testCard.getSuit();
        char expected = 'C';
        assertEquals("should return the suit of the card", expected, actual);
    }

    @Test
    public void getAllCardsNowTest() {
        String actual = testDeck.getAllCardsNow();//full deck including error card and jokers
        //System.out.println(testDeck.getDeckNow());
        String expected = "0e" + "\n" + "1C" + "\n" + "2C" + "\n" + "3C" + "\n" + "4C" + "\n" + "5C" + "\n" + "6C" + "\n" + "7C" + "\n" + "8C" + "\n" + "9C" + "\n" + "10C" + "\n" + "11C" + "\n" + "12C" + "\n" + "13C" + "\n" + "1D" + "\n" + "2D" + "\n" + "3D" + "\n" + "4D" + "\n" + "5D" + "\n" + "6D" + "\n" + "7D" + "\n" + "8D" + "\n" + "9D" + "\n" + "10D" + "\n" + "11D" + "\n" + "12D" + "\n" + "13D" + "\n" + "1H" + "\n" + "2H" + "\n" + "3H" + "\n" + "4H" + "\n" + "5H" + "\n" + "6H" + "\n" + "7H" + "\n" + "8H" + "\n" + "9H" + "\n" + "10H" + "\n" + "11H" + "\n" + "12H" + "\n" + "13H" + "\n" + "1S" + "\n" + "2S" + "\n" + "3S" + "\n" + "4S" + "\n" + "5S" + "\n" + "6S" + "\n" + "7S" + "\n" + "8S" + "\n" + "9S" + "\n" + "10S" + "\n" + "11S" + "\n" + "12S" + "\n" + "13S" + "\n" + "1R" + "\n" + "2R" + "\n";
        //System.out.println(expected);
        assertEquals("should return list of cards now in deck", expected, actual);
    }

    @Test
    public void HandgetQauntityOfCardsTest() {
        int actual = testHandetc.getQuantityOfCards();
        int expected = 0;
        assertEquals("hand should start empty, 0", expected, actual);
    }

    @Test
    public void dealTest() {
        //tests several things in Game class
        testGame.deal(5);
        int actual = testGame.player.cards.size();
        int expected = 5;
        assertEquals("should deal 5 random cards to testPlayer", expected, actual);
    }

    @Test
    public void doesGameShuffleTest() {
        boolean actual = testDeck.getCardAtIndex(0).getCardName()
                .equals(
                testGame.deck.getCardAtIndex(0).getCardName())
                &&
                testGame.deck.getAllCardsNow() != testDeck.getAllCardsNow();

        System.out.println(testGame.deck.getAllCardsNow());
        System.out.println(testDeck.getAllCardsNow());
        boolean expected = true;
       /*
        boolean actual = testGame.deck.getAllCardsNow() != testDeck.getAllCardsNow()
                && testGame.deck.getCardAtIndex(0).getCardName()
                == testDeck.getCardAtIndex(0).getCardName();
                */
        assertEquals("if true: deck is shuffled and 'error' card is index 0", expected, actual);
    }
}
