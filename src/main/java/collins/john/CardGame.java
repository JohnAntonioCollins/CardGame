package collins.john;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by johncollins on 1/20/17.
 */
public class CardGame {

    public static void main(String[] args) {

        GoFish goFish = new GoFish();
        Scanner p1scan = new Scanner(System.in);
        Scanner p2scan = new Scanner(System.in);


        System.out.println(goFish.greet);
        System.out.println(goFish.info);
        System.out.println(goFish.showHand());

        do {
            goFish.randomAskedCard();
            System.out.println(goFish.computerAsk());
            p2scan.nextLine();
            goFish.compareAndExchange(goFish.player2, goFish.player1, goFish.askedCard);
            goFish.moveMatchesToBook(goFish.player2, goFish.player2sBook, goFish.askedCard);
            System.out.println(goFish.getPlayersBooks(goFish.player2sBook));

            System.out.println(goFish.yourTurn);
            System.out.println(goFish.showHand());

            System.out.println(goFish.playerAsk);

            try { int errorCounter = p1scan.nextInt();

                if (!(errorCounter > 0 && errorCounter < 14)) {
                    System.out.println("I don't think the cards are numbered that way.\nChoose a card in your hand.");
                    p1scan.nextLine();
                }
                goFish.setAskedCard(errorCounter);

            } catch (InputMismatchException ex) {
                System.out.println("I don't understand that. Enter a card value between 1 and 13 next time.");

            }

            //goFish.setAskedCard(p1scan.nextInt());
            p1scan.nextLine();

            goFish.compareAndExchange(goFish.player1, goFish.player2, goFish.askedCard);
            goFish.moveMatchesToBook(goFish.player1, goFish.player1sBook, goFish.askedCard);
            System.out.println(goFish.showHand());
            System.out.println(goFish.getPlayersBooks(goFish.player1sBook));
            //scanner.nextLine();
            System.out.println(goFish.waitForUser);
            p1scan.nextLine();

        }
        while (goFish.getQuantityLeftInDeck() > 1 && goFish.player2.cards.size() > 0 && goFish.player1.cards.size() > 0);
    }
}
