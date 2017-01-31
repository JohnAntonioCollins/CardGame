package collins.john;

import java.util.Scanner;

/**
 * Created by johncollins on 1/20/17.
 */
public class CardGame {

    public static void main(String[] args) {

 GoFish goFish = new GoFish();
        // "\n your hand:      < "+goFish.player1.getAllCardsNow()+"> \n\n (press enter when ready)";
        Scanner goFishScan = new Scanner(System.in);
        String waitForUser = "\n (press enter when ready) \n";

        System.out.println(goFish.greet);
        System.out.println("\n your hand:      < "+goFish.player1.getAllCardsNow()+">");
        System.out.println(waitForUser);
        goFishScan.nextLine();

        System.out.println(goFish.info);

        System.out.println(goFish.computerAsk);
        goFishScan.nextLine();

        /*
        goFish.player2.askCompareAndExchange(goFish.player1, goFish.player2.getHighestCardValue());

        System.out.println("\n your hand:      < "+goFish.player1.getAllCardsNow()+">");
        System.out.println("\n OK, now it's your turn. \n");

        System.out.println(goFish.playerAsk);
        goFish.askedValue = goFishScan.nextInt();

        goFish.player1.askCompareAndExchange(goFish.player2, goFish.askedValue);

        System.out.println(waitForUser);

        System.out.println("\n your hand:      < "+goFish.player1.getAllCardsNow()+">");
*/




    }
}
