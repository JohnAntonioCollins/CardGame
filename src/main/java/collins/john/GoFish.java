package collins.john;

/**
 * Created by johncollins on 1/29/17.
 */
public class GoFish extends Game{
    Player player1sBook;
    Player player2sBook;
    String greet;
    String info;
    String computerAsk;
    String computerAnswer;


    public GoFish() {
        player1sBook = new Player("player one's books");
        player2sBook = new Player("player two's books");
        this.deal(player1, 7);
        this.deal(player2, 7);
        greet = "The game is GoFish!";

        info = "You are "+player1.getName()+" and the computer is "+player2.getName();
        //display player1's cards on one line
        computerAsk = "Do you have any "+player2.getHighestCardValue()+"'s?";
        //wait for user to say 'yes' or 'no'
        player2.receiveCardsOfAskedValue(player1, player2.getHighestCardValue());
        //display refresh player1's cards on one line

    }




}
