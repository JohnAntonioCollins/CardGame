package collins.john;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by johncollins on 1/20/17.
 */
public class CardGame
{

    public static void main(String[] args)
    {

        GoFish goFish = new GoFish();
        Scanner p1scan = new Scanner(System.in);
        Scanner p2scan = new Scanner(System.in);


        System.out.println(goFish.greet);
        System.out.println(goFish.info);
        System.out.println(goFish.showHand());

        do
        {
            goFish.setAskedCardToRandomCardInPlayer2Hand();
            System.out.println(goFish.computerAsk());
            p2scan.nextLine();
            goFish.transferMatchingCards(goFish.player2, goFish.player1, goFish.askedCard);

            goFish.moveMatchesToBook(goFish.player2, goFish.player2sBook, goFish.askedCard);
            goFish.moveMatchesToBook(goFish.player2, goFish.player2sBook, goFish.player2.valueOfNewestCard());

            System.out.println(goFish.getPlayersBooks(goFish.player2sBook));

            System.out.println(goFish.yourTurn);
            System.out.println(goFish.showHand());

            System.out.println(goFish.playerAsk);

            try
            {
                int userAskedCard = p1scan.nextInt();

                if (!(userAskedCard > 0 && userAskedCard < 14))
                {
                    System.out.println("I don't think the cards are numbered that way.\nChoose a card in your hand.");
                    p1scan.nextLine();
                }
                goFish.setAskedCard(userAskedCard);

            } catch (InputMismatchException ex)
            {
                System.out.println("I don't understand that. Enter a card value between 1 and 13 next time.");

            }

            p1scan.nextLine();

            goFish.transferMatchingCards(goFish.player1, goFish.player2, goFish.askedCard);
            goFish.moveMatchesToBook(goFish.player1, goFish.player1sBook, goFish.askedCard);
            goFish.moveMatchesToBook(goFish.player1, goFish.player1sBook, goFish.player1.valueOfNewestCard());
            System.out.println(goFish.showHand());
            System.out.println(goFish.getPlayersBooks(goFish.player1sBook));

            System.out.println(goFish.waitForUser);
            p1scan.nextLine();

        }
        while (goFish.getQuantityLeftInDeck() > 1 && goFish.player2.cards.size() > 0 && goFish.player1.cards.size() > 0);

        System.out.println("GAME OVER");
        if (goFish.getQuantityLeftInDeck() < 1)
        {
            System.out.println("Deck is empty.");
        }
        if (goFish.player2.cards.size() < 1)
        {
            System.out.println("Player 2 is out of cards");
        }
        if (goFish.player1.cards.size() < 1)
        {
            System.out.println("Player 1 is out of cards");
        }

    }
}