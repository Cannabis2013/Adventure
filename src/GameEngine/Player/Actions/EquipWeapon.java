package GameEngine.Player.Actions;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Weapon;
import GameEngine.Player.Exceptions.EquipWeaponFailedException;
import GameEngine.Utils.FindObjectFromList;
import GameEngine.Utils.ItemNotFoundException;
import java.util.List;

public class EquipWeapon {
    public Weapon equip(String weaponTitle ,Weapon currentEquipped,FindObjectFromList _findObject, List<Item> _inventory) throws ItemNotFoundException, EquipWeaponFailedException {
        var weaponToEquip = _findObject.findItemByTitle(_inventory,weaponTitle);
        if(!(weaponToEquip instanceof Weapon))
            throw new EquipWeaponFailedException();
        _inventory.remove(weaponToEquip);
        if(currentEquipped != null)
            _inventory.add(currentEquipped);
        return (Weapon) weaponToEquip;
    }
}
