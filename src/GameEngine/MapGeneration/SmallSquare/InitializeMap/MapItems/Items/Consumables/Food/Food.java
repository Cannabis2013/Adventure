package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Consumables.Food;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Consumables.Consumable;
import GameEngine.Player.PlayerObject;

public class Food extends Consumable {
    private int hp_change;
    public Food(int hp) {
        super("food");
        hp_change = hp;
    }

    public String consume(PlayerObject player) {
        player.addHealth(hp_change);
        return title() + " " + hp_change + "hp";
    }
}
