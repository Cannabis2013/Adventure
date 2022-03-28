package GameEngine.Player;

import GameEngine.Contracts.IInflictable;
import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.Map.MapObject;
import GameEngine.Player.Actions.ConsumeItem;
import GameEngine.Player.Actions.EnterDoorAtOrientation;
import GameEngine.Player.Actions.EquipWeapon;
import GameEngine.Player.Actions.UseItem;
import GameEngine.Player.Exceptions.EquipWeaponFailedException;
import GameEngine.Player.Exceptions.ItemNotConsumableException;
import GameEngine.Player.Exceptions.TargetNotFoundException;
import GameEngine.Player.Exceptions.UsableNotFoundException;
import GameEngine.Utils.ItemNotFoundException;
import GameEngine.Utils.ObjectNotFoundException;

public abstract class PlayerObject implements IObjectEntity, IInflictable {
    protected EnterDoorAtOrientation _traverseTo = new EnterDoorAtOrientation();
    protected EquipWeapon _equipWeapon = new EquipWeapon();
    protected UseItem _useItem = new UseItem();
    protected ConsumeItem _consumeItem = new ConsumeItem();
    private int _health = 100;
    private final int _maxHealth = 100;

    @Override
    public int id() {return 0;}

    @Override
    public String title() {return "Player";}

    public int getHealth() {return _health;}

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

    abstract public String equip(String weapon) throws ItemNotFoundException, EquipWeaponFailedException, ObjectNotFoundException;
    public abstract String attack(MapObject object) throws FatalBlowException, InvalidObjectException;
    public abstract String consumeItem(String itemTitle) throws ItemNotFoundException, InvalidObjectException, ObjectNotFoundException, ItemNotConsumableException;
    public abstract String useItem(String itemTitle, String roomObject) throws InvalidObjectException, UsableNotFoundException, TargetNotFoundException;
}
