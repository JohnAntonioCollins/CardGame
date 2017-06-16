package collins.john;

/**
 * Created by johncollins on 1/28/17.
 */
public class Player extends CollectionOfCards {


    public String getName() {
        return name;
    }

    private String name;

    public Player(String playerName) {
        this.name = playerName;
    }

    public boolean hasCard(int askedValue) {
        for (int i = 0; i < this.cards.size(); i++) {
            if (this.getCardAtIndex(i).getCardValue() == askedValue) {
                return true;
            }
        }
        return false;
    }
    public boolean hasMatches(int askedValue){
        int matches = 0;
        for (int i = 0; i < this.cards.size(); i++) {
            if (this.getCardAtIndex(i).getCardValue() == askedValue) {
                matches++;
            }
            if (matches > 3){
                return true;
            }
        }
        return false;

    }

}

