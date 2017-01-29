package collins.john;

import java.util.ArrayList;

/**
 * Created by johncollins on 1/28/17.
 */
public class Player extends CollectionOfCards {
    ArrayList hand = cards;

    public String getName() {
        return name;
    }

    private String name;

    public Player(String playerName){
        this.name = playerName;
    }
}
