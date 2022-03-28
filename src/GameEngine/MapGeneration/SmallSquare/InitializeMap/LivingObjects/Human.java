package GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects;

import GameEngine.Contracts.IInflictable;
import GameEngine.MapGeneration.SmallSquare.Models.MapObject;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.Player.EquipWeaponFailedException;
import GameEngine.Player.PlayerObject;
import GameEngine.Utils.ItemNotFoundException;
import GameEngine.Utils.ObjectNotFoundException;

public abstract class Human extends PlayerObject implements IInflictable {
    private String name;
    private int _health = 100;

    private final int _maxHealth = 100;

    public Human(String name) {
        this.name = name;
    }

    public int getHealth() {
        return _health;
    }

    public void addHealth(int num) {
        _health += num;
        if(_health > _maxHealth)
            _health = _maxHealth;

    }

    @Override
    public int inflict(int damage) throws FatalBlowException {
        _health -= damage;
        if(_health <= 0)
            throw new FatalBlowException();
        return damage;
    }

    public String getName() {
        return name;
    }

    abstract public String equip(String weapon) throws ItemNotFoundException, EquipWeaponFailedException;
    public abstract String attack(MapObject object) throws FatalBlowException;
    public abstract String consumeItem(String itemTitle) throws ItemNotFoundException, InvalidObjectException;
    public abstract String useItem(String itemTitle, String roomObject) throws ItemNotFoundException, InvalidObjectException, ObjectNotFoundException;
}
