package collins.john;

/**
 * Created by johncollins on 1/29/17.
 */
public class GoFish extends Game
{
    Player player1sBook;
    Player player2sBook;
    String greet;
    String info;

    String playerAsk;
    String waitForUser;
    String yourTurn;
    int askedCard;

    String explainWhyCardMoved;


    public GoFish()
    {
        greet = " The game is GoFish! \n";
        info = "You are " + player1.getName() + " and the computer is " + player2.getName() + ".\n\n" + "We're playing for books of four cards.";
        waitForUser = "\n (press enter when ready) \n";
        yourTurn = "\n OK, now it's your turn. \n";
        playerAsk = "What card are you asking for? \n \n " + "(enter a card value)\n\n";
        explainWhyCardMoved = "~card moved from player to other player~";

        player1sBook = new Player("player one's books");
        player2sBook = new Player("player two's books");

        this.shuffleDeck();
        this.deal(player1, 7);
        this.deal(player2, 7);
    }

    public String computerAsk()
    {
        return " Do you have any " + this.askedCard + "'s?";
    }

    public void setAskedCardToRandomCardInPlayer2Hand()
    {
        int randomIndex = (int) (Math.random() * (player2.cards.size() - 1));
        this.askedCard = player2.cards.get(randomIndex).getCardValue();
    }

    public void randomTestTest()
    {
        int randomIndex = (int) Math.random() * (player2.cards.size() - 1);
        this.askedCard = player2.cards.get(randomIndex).getCardValue();
    }

    public String getPlayersBooks(Player whosBooks)
    {
        return whosBooks.getName() + ": ~ " + whosBooks.getAllCardsNow() + " ~";
    }

    public int getQuantityLeftInDeck()
    {
        return deck.getQuantityOfCards();
    }

    public void setAskedCard(int askedCard)
    {
        this.askedCard = askedCard;
    }

    public String showHand()
    {
        return "\n" + player1.getName() + "'s hand:      < " + player1.getAllCardsNow() + ">\n";
    }

    public void transferMatchingCards(Player asking, Player beingAsked, int askedValue)
    {
        if (beingAsked.hasCard(askedValue))
        {
            for (int i = 0; i < beingAsked.cards.size(); i++)
            {  boolean print = false;

                if (beingAsked.getCardAtIndex(i).getCardValue() == askedValue)
                {

                    moveCardFromPlayerByIndex(beingAsked, asking, i);
                    i--;
                    print = true;
                }
                if(print){System.out.println(explainWhyCardMoved);}
            }
        } else
        {
            this.deal(asking, 1);
            System.out.println("~player drew from deck~" + "\n");
        }
    }

    public void moveMatchesToBook(Player player, Player book, int matchValue)
    {
        if (player.hasMatches(matchValue))
        {
            explainWhyCardMoved = "~card moved to book~";
            transferMatchingCards(book, player, matchValue);
            explainWhyCardMoved = "~card moved from player to other player~";
        }
    }


}
