package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.LivingObjects;

import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.MapGeneration.MapBuilders.Map.MapObject;
import GameEngine.Player.EquipWeaponFailedException;
import GameEngine.Utils.ItemNotFoundException;
import GameEngine.Utils.ObjectNotFoundException;

public abstract class Human extends Organism {
    private String name;

    public Human(String name) {
        super(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public String equip(String weapon) throws ItemNotFoundException, EquipWeaponFailedException;
    public abstract String attack(MapObject object) throws FatalBlowException;
    public abstract String consumeItem(String itemTitle) throws ItemNotFoundException, InvalidObjectException;
    public abstract String useItem(String itemTitle, String roomObject) throws ItemNotFoundException, InvalidObjectException, ObjectNotFoundException;
}
