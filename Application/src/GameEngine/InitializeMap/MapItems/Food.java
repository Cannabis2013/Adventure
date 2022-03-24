package GameEngine.InitializeMap.MapItems;

import GameEngine.MapObjects.MapObject;
import GameEngine.Player.Player;

public class Food extends Item implements IConsumable<MapObject>{
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
        player.getInventory().remove(this);
        return title() + " " + hp_change + "hp";
    }
}
