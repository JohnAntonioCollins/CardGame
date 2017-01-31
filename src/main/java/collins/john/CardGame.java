package collins.john;

import java.util.Scanner;

/**
 * Created by johncollins on 1/20/17.
 */
public class CardGame {

    public static void main(String[] args) {

 GoFish goFish = new GoFish();
        Scanner scanner = new Scanner(System.in);

        System.out.println(goFish.greet);
        System.out.println(goFish.showHand());

do {
    System.out.println(goFish.computerAsk);
    scanner.nextLine();
    goFish.setAskedCard(goFish.player2.getHighestCardValue());
    goFish.compareAndExchange(goFish.player2, goFish.player1, goFish.askedCard);
    goFish.compareAndExchange(goFish.player2sBook, goFish.player2, goFish.askedCard);
    System.out.println(goFish.getPlayersBooks(goFish.player2sBook));


    System.out.println(goFish.yourTurn);
    System.out.println(goFish.showHand());

    System.out.println(goFish.playerAsk);
    goFish.setAskedCard(scanner.nextInt());
    goFish.compareAndExchange(goFish.player1, goFish.player2, goFish.askedCard);
    goFish.compareAndExchange(goFish.player1sBook, goFish.player1, goFish.askedCard);
    System.out.println(goFish.showHand());
    System.out.println(goFish.getPlayersBooks(goFish.player1sBook));
    scanner.nextLine();
    System.out.println(goFish.waitForUser);

}
while(goFish.getQuantityLeftInDeck() > 1 || goFish.player1.getQuantityOfCards() != 0 || goFish.player2.getQuantityOfCards() != 0);




        /*
        goFish.player2.askCompareAndExchange(goFish.player1, goFish.player2.getHighestCardValue());

        System.out.println("\n your hand:      < "+goFish.player1.getAllCardsNow()+">");

        System.out.println(goFish.playerAsk);
        goFish.askedValue = goFishScan.nextInt();

        goFish.player1.askCompareAndExchange(goFish.player2, goFish.askedValue);


        System.out.println("\n your hand:      < "+goFish.player1.getAllCardsNow()+">");
*/




    }
}
