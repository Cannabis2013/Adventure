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
import GameEngine.Player.Exceptions.DodgedAttackException;
import GameEngine.Player.Exceptions.MissedTargetException;
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
    protected double _dodgeChange = .1;
    protected double _hitChance = 0.7;
    private final int _maxHealth = 100;

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
    public int inflict(int damage) throws FatalBlowException, DodgedAttackException {
        var r = Math.random();
        if(r <= _dodgeChange)
            throw new DodgedAttackException();
        _health -= damage;
        if(_health <= 0)
            die();
        return damage;
    }

    @Override
    public String presentate() {
        return String.format("%s (HP: %d, weapon: %s)",_title,_health,_weapon.type());
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
        throw new FatalBlowException();
    }

    public String attack(IObjectEntity object) throws FatalBlowException, InvalidObjectException, WeaponNotEquippedException, DodgedAttackException, MissedTargetException {
        if(_weapon == null)
            throw new WeaponNotEquippedException();
        if(Math.random() >= _hitChance)
            throw new MissedTargetException();
        return String.format("%d",_weapon.attack(object));
    }
}
