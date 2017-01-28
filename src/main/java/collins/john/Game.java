package collins.john;

/**
 * Created by johncollins on 1/28/17.
 */
public class Game {
    //abstract class with card compare and sort methods
    //SHUFFLE
    //DEAL
    //sets rules of game
    //does calculations

    Deck deck;
    Player player;
    int cardsDealt = 1;
    public Game(){
        deck = new Deck();
       //player = new Player();
    }

    private void dealOneCard(){
        Card oneCard = deck.cards.get(cardsDealt);
        player.cards.add(oneCard);
        cardsDealt++;
    }
    public void deal(CollectionOfCards player, int quantityOfCards){
        if(cardsDealt < quantityOfCards) {
        dealOneCard();
        }


    }
}
