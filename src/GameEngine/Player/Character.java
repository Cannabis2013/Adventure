package GameEngine.Player;

import GameEngine.Contracts.IInflictable;
import GameEngine.Contracts.IObjectEntity;
import GameEngine.Contracts.IPresentable;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Weapon;
import GameEngine.MapGeneration.SmallSquare.Map.Map;
import GameEngine.MapGeneration.SmallSquare.Map.Rooms.Room;
import GameEngine.Player.Actions.ConsumeItem;
import GameEngine.Player.Actions.EnterDoorAtOrientation;
import GameEngine.Player.Actions.EquipWeapon;
import GameEngine.Player.Actions.UseItem;
import GameEngine.Player.Exceptions.WeaponNotEquippedException;
import GameEngine.Player.InventoryBag.Bag;

public class Character implements IObjectEntity, IInflictable, IPresentable {
    private String _title;
    private static int _id;
    protected EnterDoorAtOrientation _traverseTo = new EnterDoorAtOrientation();
    protected EquipWeapon _equipWeapon = new EquipWeapon();
    protected UseItem _useItem = new UseItem();
    protected ConsumeItem _consumeItem = new ConsumeItem();
    protected Room _currentRoom;
    protected Weapon _weapon;
    protected Bag _bag = new Bag();
    protected int _health = 100;
    private final int _maxHealth = 100;
    private enum State {ALIVE, DEAD}
    private State _state = State.ALIVE;

    protected Character(String title) {
        _id++;
        _title = String.format("%s %d",title,_id);
    }

    @Override
    public int id() {return _id;}

    public int health() {return _health;}

    public void addHealth(int num) {
        _health += num;
        if(_health > _maxHealth)
            _health = _maxHealth;
    }

    @Override
    public int inflict(int damage) throws FatalBlowException {
        _health -= damage;
        if(_health <= 0)
            die();
        return damage;
    }

    @Override
    public String presentate() {
        return String.format("%s (HP: %d, weapon: %s) [%s]",_title,_health,_weapon.type(),_state);
    }

    @Override
    public String title(){
        return _title;
    }

    public Weapon equipped(){return _weapon;}

    public Map getCurrentMap(){return _currentRoom.map();}

    public void die() throws FatalBlowException {
        var weapon = _weapon;
        _weapon = null;
        _currentRoom.addItem(weapon);
        _currentRoom.demons().remove(this);
        _state = State.DEAD;
        throw new FatalBlowException();
    }

    public String attack(IObjectEntity object) throws FatalBlowException, InvalidObjectException, WeaponNotEquippedException {
        if(_weapon == null)
            throw new WeaponNotEquippedException();
        return String.format("%d",_weapon.attack(object));
    }
}
