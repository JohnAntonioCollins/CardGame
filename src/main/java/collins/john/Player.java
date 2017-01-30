package collins.john;

/**
 * Created by johncollins on 1/28/17.
 */
public class Player extends CollectionOfCards {
    //ArrayList hand = cards;

    public String getName() {
        return name;
    }

    private String name;

    public Player(String playerName){
        this.name = playerName;
    }

    public void receiveCardsOfAskedValue(Player sender, int askedValue){
        for (int i = 0; i < sender.cards.size(); i++) {
            if(sender.getCardAtIndex(i).getCardValue() == askedValue){
                this.cards.add(sender.getCardAtIndex(i));
                sender.cards.remove(i);
            }
        }
    }


}
