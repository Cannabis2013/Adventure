package GameEngine.InitializeMap.LivingObjects;

import GameEngine.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.MapObjects.MapObject;
import GameEngine.Player.EquipWeaponFailedException;
import GameEngine.Utils.ItemNotFoundException;
import GameEngine.Utils.ObjectNotFoundException;

public abstract class Human extends Organism {
    private String name;

    public Human(String name) {
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
