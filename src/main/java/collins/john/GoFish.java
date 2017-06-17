package collins.john;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by johncollins on 1/29/17.
 */
public class GoFish extends Game
{
    String sayWhatGame;
    String sayRulesOfGame;
    String promptForEnterKey;
    String sayYourTurn;
    String promptPlayerToAskComputer;
    String describeHowCardMoved;

    Player player1sBook;
    Player player2sBook;
    Scanner computerScan;
    Scanner playerScan;
    int askedCardValue;

    public GoFish()
    {
        sayWhatGame = " The game is GoFish! \n";
        sayRulesOfGame = "You are " + player1.getName() + " and the computer is " + player2.getName() + ".\n\n" + "We're playing for books of four cards.";
        promptForEnterKey = "\n (press enter when ready) \n";
        sayYourTurn = "\n OK, now it's your turn. \n";
        promptPlayerToAskComputer = "What card are you asking for? \n \n " + "(enter a card value)\n\n";
        describeHowCardMoved = "~card moved from player to other player~";

        player1 = new Player("Player One");
        player2 = new Player("Computer");
        player1sBook = new Player("player one's books");
        player2sBook = new Player("player two's books");
        computerScan = new Scanner(System.in);
        playerScan = new Scanner(System.in);
    }

    public void playGame()
    {
        System.out.println(sayWhatGame);
        System.out.println(sayRulesOfGame);
        shuffleDeck();
        deal(player1, 7);
        deal(player2, 7);
        System.out.println(showPlayer1sHand());
        do
        {
            computerAsksPlayer();
            transferMatchingCards(player2, player1, askedCardValue);
            moveMatchesToBook(player2, player2sBook, askedCardValue);
            moveMatchesToBook(player2, player2sBook, player2.valueOfNewestCard());
            System.out.println(getPlayersBooks(player2sBook));

            System.out.println(sayYourTurn);
            System.out.println(showPlayer1sHand());
            System.out.println(promptPlayerToAskComputer);

            playerAsksComputer();
            transferMatchingCards(player1, player2, askedCardValue);
            moveMatchesToBook(player1, player1sBook, askedCardValue);
            moveMatchesToBook(player1, player1sBook, player1.valueOfNewestCard());
            System.out.println(showPlayer1sHand());
            System.out.println(getPlayersBooks(player1sBook));
            System.out.println(promptForEnterKey);
            computerScan.nextLine();

        } while (getQuantityLeftInDeck() > 1 && player2.cards.size() > 0 && player1.cards.size() > 0);

        System.out.println("GAME OVER");
        if (getQuantityLeftInDeck() < 1)
        {
            System.out.println("Deck is empty.");
        }
        if (player1.cards.size() < 1)
        {
            System.out.println(player1.getName() + " is out of cards");
        }
        if (player2.cards.size() < 1)
        {
            System.out.println(player2.getName() + " is out of cards");
        }
    }

    public void playerAsksComputer()
    {
        try
        {
            int userAskedCard = computerScan.nextInt();
            if (!(userAskedCard > 0 && userAskedCard < 14))
            {
                System.out.println("I don't think the cards are numbered that way.\n Choose a card in your hand.");
                computerScan.nextLine();
            }
            setAskedCardValue(userAskedCard);
            computerScan.nextLine();
        } catch (InputMismatchException ex)
        {
            System.out.println("I don't understand that. Enter a card value between 1 and 13.");
            playerAsksComputer();
        }
    }

    public void computerAsksPlayer()
    {
        setAskedCardToRandomCardInPlayer2sHand();
        System.out.println(" Do you have any " + this.askedCardValue + "'s?");
        playerScan.nextLine();
    }

    public void setAskedCardToRandomCardInPlayer2sHand()
    {
        int randomIndex = (int) (Math.random() * (player2.cards.size() - 1));
        askedCardValue = player2.cards.get(randomIndex).getCardValue();
    }

    public void randomTestTest()
    {
        int randomIndex = (int) Math.random() * (player2.cards.size() - 1);
        askedCardValue = player2.cards.get(randomIndex).getCardValue();
    }

    public String getPlayersBooks(Player whosBooks)
    {
        return whosBooks.getName() + ": ~ " + whosBooks.getAllCardsNow() + " ~";
    }

    public int getQuantityLeftInDeck()
    {
        return deck.getQuantityOfCards();
    }

    public void setAskedCardValue(int askedCardValue)
    {
        this.askedCardValue = askedCardValue;
    }

    public String showPlayer1sHand()
    {
        return "\n" + player1.getName() + "'s hand:      < " + player1.getAllCardsNow() + ">\n";
    }

    public void transferMatchingCards(Player asking, Player beingAsked, int askedValue)
    {
        if (beingAsked.hasCard(askedValue))
        {
            for (int i = 0; i < beingAsked.cards.size(); i++)
            {
                boolean print = false;

                if (beingAsked.getCardAtIndex(i).getCardValue() == askedValue)
                {
                    moveCardFromPlayerByIndex(beingAsked, asking, i);
                    i--;
                    print = true;
                }
                if (print) {System.out.println(describeHowCardMoved);}
            }
        } else
        {
            deal(asking, 1);
            System.out.println("~player drew from deck~" + "\n");
        }
    }

    public void moveMatchesToBook(Player player, Player book, int matchValue)
    {
        if (player.hasMatches(matchValue))
        {
            describeHowCardMoved = "~card moved to book~";
            transferMatchingCards(book, player, matchValue);
            describeHowCardMoved = "~card moved from player to other player~";
        }
    }

}
