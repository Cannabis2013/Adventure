package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Consumables;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;
import GameEngine.Player.PlayerObject;

public interface Consumable{
    String consume(PlayerObject player);
}
