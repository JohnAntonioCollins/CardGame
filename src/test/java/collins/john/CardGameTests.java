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
    CollectionOfCards testHand;
    Game testGame;
    Player testPlayer1;
    Player testPlayer2;

    @Before
    public void setUp() throws Exception {
        testCard = new Card(3, 'C');
        testDeck = new Deck();
        testHand = new CollectionOfCards();
        testGame = new Game();
        testPlayer1 = new Player("Player1");
        testPlayer2 = new Player("Player2");
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
        int actual = testHand.getQuantityOfCards();
        int expected = 0;
        assertEquals("hand should start empty, 0", expected, actual);
    }

    @Test
    public void doesGameDealCorrectQuantityTest() {
        testGame.deal(testGame.player1, 5);
        int actual = testGame.player1.cards.size();
        int expected = 5;
        assertEquals("should deal 5 random cards to testPlayer", expected, actual);
    }
    @Test
    public void doesGameRemoveDealtCardsFromDeck(){
        testGame.deal(testGame.player1, 5);
        int actual = testGame.deck.cards.size();
        int expected = 50;
        assertEquals("deck should have 50 items after 5 cards dealt", expected, actual);
    }

    @Test
    public void doesGameShuffleTest() {
        boolean actual = testDeck.getCardAtIndex(0).getCardName()
                .equals(
                        testGame.deck.getCardAtIndex(0).getCardName())
                &&
                testGame.deck.getAllCardsNow() != testDeck.getAllCardsNow();
        boolean expected = true;
        assertEquals("if true: deck is shuffled and 'error' card is index 0", expected, actual);
    }

    @Test
    public void getPlayersNameTest() {
        String actual = testGame.player1.getName();
        String expected = "Player One";
        assertEquals("should be name field of given Player", expected, actual);
    }
    @Test
    public void Does_moveCards_moveCorrectQauntity_Test(){
        testGame.deal(testPlayer1, 10);
        testGame.moveCards(testPlayer1, testPlayer2, 7);
        int actual = testPlayer2.hand.size();
        int expected = 7;
        assertEquals("Should give player2 7 of player1's cards", expected, actual);
    }
    @Test
    public void Does_moveCards_leaveCorrectQauntity_Test(){
        testGame.deal(testPlayer1, 10);
        testGame.moveCards(testPlayer1, testPlayer2, 7);
        int actual = testPlayer1.hand.size();
        int expected = 3;
        assertEquals("Should leave player1 3 cards", expected, actual);
    }
}
