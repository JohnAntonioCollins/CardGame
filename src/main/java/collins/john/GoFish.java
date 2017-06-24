package collins.john;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by johncollins on 1/29/17.
 */
public class GoFish extends CardMover
{
    String sayWhatGame;
    String sayRulesOfGame;
    String promptForEnterKey;
    String sayYourTurn;
    String promptPlayerToAskComputer;
    String describeHowCardMoved;
    String gameOverMessage;

    boolean isGameOver;

    Player player1;
    Player player2;
    Player player1sBook;
    Player player2sBook;
    Scanner computerScan;
    Scanner playerScan;
    int askedCardValue;

    public GoFish()
    {
        isGameOver = false;
        player1 = new Player("Human");
        player2 = new Player("Computer");
        computerScan = new Scanner(System.in);
        playerScan = new Scanner(System.in);

        sayWhatGame = " The game is GoFish! \n";
        sayRulesOfGame = "You are " + player1.getName() + " and the computer is " + player2.getName() + ".\n\n" + "We're playing for books of four cards.";
        promptForEnterKey = "\n    (press enter when ready) \n";
        sayYourTurn = "\n     OK, now it's your turn. \n";
        promptPlayerToAskComputer = "   What card are you asking for? \n \n " + "     (enter a card value)\n\n";
        describeHowCardMoved = "~card moved from player to other player~";

    }

    public void playGame()
    {
        setUpAndDeal();
        do
        {   //TODO: gather methods into player's turns methods
            //player2sTurn();
            computerAsksPlayer();
            getCardAskedOrDrawFromDeck(player1, player2);
            moveMatchesToBook(player2, askedCardValue);
            moveMatchesToBook(player2, player2.hand.valueOfNewestCard());
            System.out.println(getPlayersBooks(player2));
            System.out.println("\n" + deck.getQuantityOfCards() + " cards remain in the deck.");
            //end player2sTurn

            //player1sTurn();
            System.out.println(sayYourTurn);
            System.out.println(showPlayer1sHand());
            System.out.println(promptPlayerToAskComputer);

            playerAsksComputer();
            getCardAskedOrDrawFromDeck(player2, player1);
            moveMatchesToBook(player1, askedCardValue);
            //TODO: fix this method, tries index -1 if hand is empty.
            moveMatchesToBook(player1, player1.hand.valueOfNewestCard());
            System.out.println(showPlayer1sHand());
            System.out.println(getPlayersBooks(player1));
            System.out.println("\n" + deck.getQuantityOfCards() + " cards remain in the deck.");
            System.out.println(promptForEnterKey);
            computerScan.nextLine();
            //end player1sTurn

        } while (!gameOverCondition());
        sayGAME_OVERmessage();

    }



    public void setUpAndDeal()
    {
        System.out.println(sayWhatGame);
        System.out.println(sayRulesOfGame);
        shuffleDeck();
        deal(player1, 7);
        deal(player2, 7);
        System.out.println(showPlayer1sHand());
    }

    public void computerAsksPlayer()
    {
        setAskedCardToRandomCardInPlayer2sHand();
        System.out.println(" Do you have any " + this.askedCardValue + "'s?");
        playerScan.nextLine();
    }

    public void setAskedCardToRandomCardInPlayer2sHand()
    {
        int randomIndex = (int) (Math.random() * (player2.hand.size() - 1));
        askedCardValue = player2.hand.get(randomIndex).getCardValue();
    }

    public void getCardAskedOrDrawFromDeck(Player asked, Player asking)
    {
        if (asked.hand.hasCard(askedCardValue))
        {
            moveCardsByValue(asked, asking, askedCardValue);
            System.out.println(describeHowCardMoved);
        } else
        {
            deal(asking, 1);
            System.out.println("~card drawn from deck~");
        }

    }

    public void moveMatchesToBook(Player player, int matchValue)
    {
        if(hasBook(player, matchValue))
        {
            moveCardsByValue(player.hand, player.book, matchValue);
            System.out.println("~cards moved to book~");
        }
    }

    public String getPlayersBooks(Player whosBooks)
    {
        return "\n  " + whosBooks.getName() + "'s books: ~  " + whosBooks.book.getAllCardsNow() + "~";
    }

    public String showPlayer1sHand()
    {
        return "\n" + player1.getName() + "'s cards:      < " + player1.hand.getAllCardsNow() + ">\n";
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

    public void setAskedCardValue(int askedCardValue)
    {
        this.askedCardValue = askedCardValue;
    }


    public boolean gameOverCondition()
    {
        if (getQuantityLeftInDeck() < 1)
        {
            isGameOver = true;
            gameOverMessage = "Deck is empty";
        }
        if (player2.hand.size() < 1)
        {
            isGameOver = true;
            gameOverMessage = player2.getName() + " is out of cards";
        }
        if (player1.hand.size() < 1)
        {
            isGameOver = true;
            gameOverMessage = player1.getName() + " is out of cards";
        }
        return isGameOver;
    }

    public int getQuantityLeftInDeck()
    {
        return deck.getQuantityOfCards() -1;
    }

    public void sayGAME_OVERmessage()
    {
        System.out.println("GAME OVER  \n" + gameOverMessage);
    }

    public boolean hasBook(Player player, int matchValue)
    {
        if (player.hand.hasCardGroup(matchValue, 4) && player.hand.size() > 3)
        {
            return true;
        }
        return false;
    }

}
