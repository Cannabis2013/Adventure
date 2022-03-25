package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.Food;

import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.Consumable;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.MapGeneration.MapBuilders.Map.MapObject;
import GameEngine.Player.Player;

public class Food extends Consumable {
    private int hp_change;
    public Food(String title, int hp) {
        super("Food", title);
        hp_change = hp;
    }

    public String consume(MapObject object) throws InvalidObjectException {
        if(!(object instanceof Player))
            throw new InvalidObjectException();
        var player = (Player) object;
        player.addHealth(hp_change);
        player.inventory().remove(this);
        return title() + " " + hp_change + "hp";
    }
}
