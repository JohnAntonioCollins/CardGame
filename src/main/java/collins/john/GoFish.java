package collins.john;

/**
 * Created by johncollins on 1/29/17.
 */
public class GoFish extends Game {
    Player player1sBook;
    Player player2sBook;
    String greet;
    String info;
    String computerAsk;
    //String computerAnswer;
    String playerAsk;
    String waitForUser;
    String yourTurn;
    int askedCard;
    //boolean hasCard;


    public GoFish() {

        player1sBook = new Player("player one's books");
        player2sBook = new Player("player two's books");

        greet = " The game is GoFish! \n";
        this.shuffleDeck();
        this.deal(player1, 7);
        this.deal(player2, 7);

        info = "You are " + player1.getName() + " and the computer is " + player2.getName()+".\n";

        askedCard = player2.getHighestCardValue();
        computerAsk = " Do you have any " + askedCard + "'s?";
        waitForUser = "\n (press enter when ready) \n";
        yourTurn = "\n OK, now it's your turn. \n";


        playerAsk = "What card are you asking for? \n \n " + "(enter a card value)\n\n";
        //player1.askCompareAndExchange(player2, askedValue);

        //player2.askCompareAndExchange(player1);


        //display refresh player1's cards on one line

    }
    public String getPlayersBooks(Player whosBooks){
        return whosBooks.getName()+" "+whosBooks.getAllCardsNow();
    }

    public int getQuantityLeftInDeck(){
        return deck.getQuantityOfCards();
    }

    public void setAskedCard(int askedCard) {
        this.askedCard = askedCard;
    }

    public String showHand() {
        return "\n your hand:      < " + player1.getAllCardsNow() + ">\n";

    }

    public void compareAndExchange(Player asking, Player beingAsked, int askedValue) {
        if (beingAsked.hasAskedValue(askedValue)) {

            for (int i = 0; i < beingAsked.cards.size(); i++) {

                if (beingAsked.getCardAtIndex(i).getCardValue() == askedValue) {

                    moveSpecificCard(beingAsked, asking, i);
                    //beingAsked.cards.remove(i);
                    i--;
                }
            }
        } else {
            this.deal(asking, 1);
        }

    }


}
