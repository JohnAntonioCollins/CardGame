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
    //public Player book;

    public Player(String playerName) {
        this.name = playerName;
        //this.book = new Player(playerName+"'s book");
    }

    public boolean hasAskedValue(int askedValue) {
        for (int i = 0; i < this.cards.size(); i++) {
            if (this.getCardAtIndex(i).getCardValue() == askedValue) {
                return true;
            }
        }
        return false;
    }

}

