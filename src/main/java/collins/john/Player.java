package collins.john;

/**
 * Created by johncollins on 1/28/17.
 */
public class Player {

    public BunchOfCards hand = new BunchOfCards();
    public BunchOfCards book = new BunchOfCards();

    private String name;

    public Player(String playerName) {
        this.name = playerName;
    }

    public String getName() {
        return name;
    }

}

