package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapEnemies;

import GameEngine.Contracts.IInflictable;
import GameEngine.Contracts.IPresentable;
import GameEngine.Contracts.IRoom;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Weapon;
import GameEngine.MapGeneration.SmallSquare.Map.MapObject;

public abstract class Demon extends MapObject implements IInflictable, IPresentable {
    private final IRoom _currentRoom;
    protected Weapon _equippedWeapon;
    enum State {ALIVE, DEAD}

    private State _state = State.ALIVE;

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
        _state = State.DEAD;
        throw new FatalBlowException();
    }

    public abstract String attack(MapObject object) throws InvalidObjectException, FatalBlowException;

    @Override
    public String presentate() {
        return String.format("%s (HP: %d) [%s]",_title,_health, _state);
    }
}
