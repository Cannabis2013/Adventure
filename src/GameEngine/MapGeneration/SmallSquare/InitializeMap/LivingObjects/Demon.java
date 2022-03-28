package GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects;

import GameEngine.Contracts.IInflictable;
import GameEngine.Contracts.IRoom;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.Weapon;
import GameEngine.MapGeneration.SmallSquare.Models.MapObject;

public abstract class Demon extends MapObject implements IInflictable {
    private final IRoom _currentRoom;
    protected Weapon _equippedWeapon;

    public Demon(String title, IRoom room) {
        super(title);
        _currentRoom = room;
    }

    protected int _health = 100;

    public int getHealth() {
        return _health;
    }

    public void addHealth(int num) {
        if(_health < 100)
            _health += num;
    }

    public void takeHealth(int value) throws FatalBlowException {
        _health -= value;
        if(_health <= 0)
            die();
    }

    public void die() throws FatalBlowException {
        var weapon = _equippedWeapon;
        _equippedWeapon = null;
        _currentRoom.addItem(weapon);
        throw new FatalBlowException();
    }

    public abstract String attack(MapObject object) throws InvalidObjectException, FatalBlowException;
}
