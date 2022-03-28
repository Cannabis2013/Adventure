package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Consumables;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;
import GameEngine.Player.PlayerObject;

public abstract class Consumable extends Item {
    public Consumable(String title) {
        super(title);
    }

    public abstract String consume(PlayerObject player);
}
