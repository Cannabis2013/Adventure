package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Consumables.Food;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Consumables.Consumable;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;
import GameEngine.Player.PlayerObject;

public class Banana extends Item implements Consumable {
    private int _hpChange;
    public Banana() {
        super("banana");
        _hpChange = 20;
    }

    public String consume(PlayerObject player) {
        player.addHealth(_hpChange);
        return title() + " " + _hpChange + "hp";
    }

    @Override
    public String presentate() {
        return String.format("%s (+%d hp)",_title, _hpChange);
    }
}
