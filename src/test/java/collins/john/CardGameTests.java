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
    GoFish testGoFish;

    @Before
    public void setUp() throws Exception {
        testCard = new Card(3, 'C');
        testDeck = new Deck();
        testHand = new CollectionOfCards();
        testGame = new Game();
        testGoFish = new GoFish();
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
        //String expected = "0e" + "\n" + "1C" + "\n" + "2C" + "\n" + "3C" + "\n" + "4C" + "\n" + "5C" + "\n" + "6C" + "\n" + "7C" + "\n" + "8C" + "\n" + "9C" + "\n" + "10C" + "\n" + "11C" + "\n" + "12C" + "\n" + "13C" + "\n" + "1D" + "\n" + "2D" + "\n" + "3D" + "\n" + "4D" + "\n" + "5D" + "\n" + "6D" + "\n" + "7D" + "\n" + "8D" + "\n" + "9D" + "\n" + "10D" + "\n" + "11D" + "\n" + "12D" + "\n" + "13D" + "\n" + "1H" + "\n" + "2H" + "\n" + "3H" + "\n" + "4H" + "\n" + "5H" + "\n" + "6H" + "\n" + "7H" + "\n" + "8H" + "\n" + "9H" + "\n" + "10H" + "\n" + "11H" + "\n" + "12H" + "\n" + "13H" + "\n" + "1S" + "\n" + "2S" + "\n" + "3S" + "\n" + "4S" + "\n" + "5S" + "\n" + "6S" + "\n" + "7S" + "\n" + "8S" + "\n" + "9S" + "\n" + "10S" + "\n" + "11S" + "\n" + "12S" + "\n" + "13S" + "\n" + "1R" + "\n" + "2R" + "\n";
        String expected = "0e  1C  2C  3C  4C  5C  6C  7C  8C  9C  10C  11C  12C  13C  1D  2D  3D  4D  5D  6D  7D  8D  9D  10D  11D  12D  13D  1H  2H  3H  4H  5H  6H  7H  8H  9H  10H  11H  12H  13H  1S  2S  3S  4S  5S  6S  7S  8S  9S  10S  11S  12S  13S  1R  2R  ";
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
    public void doesGameRemoveDealtCardsFromDeck() {
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
    public void Does_moveCards_moveCorrectQauntity_Test() {
        testGame.deal(testPlayer1, 10);
        testGame.moveSomeCards(testPlayer1, testPlayer2, 7);
        int actual = testPlayer2.cards.size();
        int expected = 7;
        assertEquals("Should give player2 7 of player1's cards", expected, actual);
    }

    @Test
    public void Does_moveCards_leaveCorrectQauntity_Test() {
        testGame.deal(testPlayer1, 10);
        testGame.moveSomeCards(testPlayer1, testPlayer2, 7);
        int actual = testPlayer1.cards.size();
        int expected = 3;
        assertEquals("Should leave player1 3 cards", expected, actual);
    }

    @Test
    public void GoFishConstructorTest() {
        testGoFish = new GoFish();
        int actual = testGoFish.player1.cards.size();
        int expected = 7;
        assertEquals("should return 7, cards dealt", expected, actual);
    }

    @Test
    public void getHighestCardValueTest() {

        testPlayer1 = new Player("test player");
        Card card1 = new Card(1, 'D');
        Card card2 = new Card(3, 'D');
        testPlayer1.cards.add(card1);
        testPlayer1.cards.add(testCard);
        testPlayer1.cards.add(card2);

        int actual = testPlayer1.getHighestCardValue();
        int expected = 3;
        assertEquals("should return 3, highest card in hand", expected, actual);
    }

    @Test
    public void receiveCardsOfAskedValueTest() {
        testPlayer1 = new Player("player 2");
        testPlayer2 = new Player("player 2");
        Card card1d = new Card(1, 'D');
        Card card2d = new Card(2, 'D');
        Card card3c = new Card(3, 'C');
        Card card2h = new Card(2, 'H');
        Card card2s = new Card(2, 'S');

        testPlayer1.cards.add(card1d);
        testPlayer1.cards.add(card3c);
        testPlayer1.cards.add(card2d);

        testPlayer2.cards.add(card2h);
        testPlayer2.cards.add(card2s);

        // testPlayer2.receiveCardsOfAskedValue(testPlayer1, 3);
        int actual = testPlayer2.cards.get(0).getCardValue();
        int expected = 2;
        assertEquals("should return 2, the highest value card now in p2 hand", expected, actual);

    }

    @Test
    public void checkForAskedValueTest() {
        testPlayer1 = new Player("player 1");
        testPlayer2 = new Player("player 2");
        Card card1d = new Card(1, 'D');
        Card card2d = new Card(2, 'D');
        Card card3c = new Card(3, 'C');
        Card card2h = new Card(2, 'H');
        Card card2s = new Card(2, 'S');

        testPlayer1.cards.add(card1d);
        testPlayer1.cards.add(card2d);

        testPlayer2.cards.add(card2h);
        testPlayer2.cards.add(card2s);
        testPlayer2.cards.add(card3c);

        boolean actual = testPlayer2.hasCard(3);
        boolean expected = true;
        assertEquals("should be true; p1 is asking for a 3 and p2 has a 3", expected, actual);
    }

    @Test
    public void moveSpecificCardsTest() {
        testGame = new Game();
        testPlayer1 = new Player("P1");
        testPlayer2 = new Player("P2");
        Card card1d = new Card(1, 'D');
        Card card2d = new Card(2, 'D');
        Card card3c = new Card(3, 'C');
        Card card2h = new Card(2, 'H');
        Card card2s = new Card(2, 'S');

        testPlayer1.cards.add(card1d);
        testPlayer1.cards.add(card2d);

        testPlayer2.cards.add(card2h);
        testPlayer2.cards.add(card2s);
        testPlayer2.cards.add(card3c);
        System.out.println(testPlayer1.getAllCardsNow());
        System.out.println(testPlayer2.getAllCardsNow());

        testGame.moveCardFromPlayerByIndex(testPlayer1, testPlayer2, 1);

        System.out.println(testPlayer1.getAllCardsNow());
        System.out.println(testPlayer2.getAllCardsNow());

        String actual = testPlayer2.getCardAtIndex(3).getCardName();
        String expected = "2D";
        assertEquals("should move card from p1, index 1, to p2, index 3", expected, actual);


    }

    @Test
    public void moveCardsIfValueTest() {
        testGame = new Game();
        testPlayer1 = new Player("P1");
        testPlayer2 = new Player("P2");
        Card card1d = new Card(1, 'D');
        Card card2d = new Card(2, 'D');
        Card card3c = new Card(3, 'C');
        Card card2h = new Card(2, 'H');
        Card card2s = new Card(2, 'S');

        testPlayer1.cards.add(card1d);
        testPlayer1.cards.add(card2d);

        testPlayer2.cards.add(card2h);
        testPlayer2.cards.add(card2s);
        testPlayer2.cards.add(card3c);
        //System.out.println(testPlayer1.getAllCardsNow());
        //System.out.println(testPlayer2.getAllCardsNow());

        testGame.moveCardsByValue(testPlayer2, testPlayer1, 2);

        //System.out.println(testPlayer1.getAllCardsNow());
        //System.out.println(testPlayer2.getAllCardsNow());

        String actual = testPlayer1.getAllCardsNow();
        String expected = "1D  2D  2H  2S  ";
        assertEquals("should show p2 deck with moved cards", expected, actual);

    }


    @Test
    public void GoFishDealsTest() {
        //testGoFish.transferMatchingCards(testGoFish.player1, testGoFish.player2, 2);
        int actual = testGoFish.player1.cards.size();
        int expected = 7;
        assertEquals("p1 should now have 7 cards", expected, actual);
    }


    @Test
    public void compareAndExchangeTest() {

        testGoFish.player1.cards.removeAll(testGoFish.player1.cards);
        testGoFish.player2.cards.removeAll(testGoFish.player2.cards);
        System.out.println(testGoFish.player1.getAllCardsNow());
        System.out.println(testGoFish.player2.getAllCardsNow());

        Card card1d = new Card(1, 'D');
        Card card2d = new Card(2, 'D');

        Card card3c = new Card(3, 'C');
        Card card3h = new Card(3, 'H');
        Card card3d = new Card(3, 'D');
        Card card3s = new Card(3, 'S');

        Card card2h = new Card(2, 'H');
        Card card4c = new Card(4, 'C');
        Card card4s = new Card(4, 'S');
        Card card4h = new Card(4, 'H');
        Card card4d = new Card(4, 'D');


        testGoFish.player1.cards.add(card1d);
        testGoFish.player1.cards.add(card2d);

        testGoFish.player2.cards.add(card3c);
        testGoFish.player2.cards.add(card2h);
        testGoFish.player2.cards.add(card4s);
        testGoFish.player2.cards.add(card4c);
       // testGoFish.player2.cards.add(card3c);
        testGoFish.player2.cards.add(card3d);
        testGoFish.player2.cards.add(card3s);
        testGoFish.player2.cards.add(card2h);
        testGoFish.player2.cards.add(card4h);
        testGoFish.player2.cards.add(card4d);
        testGoFish.player2.cards.add(card3h);
        //testGoFish.player2.cards.add(card3c);
        //testGoFish.player2.cards.add(card3c);

        //System.out.println(testGoFish.player1.getAllCardsNow()+"\n");
        //System.out.println(testGoFish.player2.getAllCardsNow()+"\n ____________________\n");

        testGoFish.transferMatchingCards(testGoFish.player1, testGoFish.player2, 4);

        //System.out.println(testGoFish.player1.getAllCardsNow()+"\n");
        //System.out.println(testGoFish.player2.getAllCardsNow());

        String expected = "1D  2D  4S  4C  4H  4D  ";
        String actual = testGoFish.player1.getAllCardsNow();
        assertEquals("p1 should now have all the '4' cards", expected, actual);

    }
    @Test
    public void randomCardInHandTest(){
        testGoFish.setAskedCardToRandomCardInPlayer2Hand();
        int testCounter = 0;
        //System.out.println(testGoFish.askedCard);
        //System.out.println(testGoFish.player2.getAllCardsNow());
        for (int i = 0; i < testGoFish.player2.cards.size()-1; i++) {
            if(testGoFish.player2.cards.get(i).getCardValue() == testGoFish.askedCard){
                testCounter++;
            }
        }
        boolean actual = testCounter > 0;//testGoFish.askedCard >= 1 && testGoFish.askedCard <= 13;
        boolean expected = true;
        assertEquals("should be true, at least 1 match.", expected, actual);
    }
    @Test
    public void randomCardInHandRANGETest() {
        testGoFish.setAskedCardToRandomCardInPlayer2Hand();
        //System.out.println(testGoFish.askedCard);
        //System.out.println(testGoFish.player2.getAllCardsNow());

        boolean actual = testGoFish.askedCard >= 1 && testGoFish.askedCard <= 13;
        boolean expected = true;
        assertEquals("should be true, all values are 1 to 13.", expected, actual);
    }

    @Test
    public void doesCardDrawnFromDeckThatMakesABookCauseABookToBetransferedToPlayersBooks(){

    }
}
