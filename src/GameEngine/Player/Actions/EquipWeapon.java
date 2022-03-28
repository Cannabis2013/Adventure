package GameEngine.Player.Actions;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Weapon;
import GameEngine.Player.Exceptions.EquipWeaponFailedException;
import GameEngine.Player.InventoryBag.Bag;
import GameEngine.Utils.FindObjectFromList;
import GameEngine.Utils.ItemNotFoundException;
import java.util.List;

public class EquipWeapon {
    public Weapon equip(String weaponTitle , Weapon currentEquipped, Bag bag) throws ItemNotFoundException, EquipWeaponFailedException {
        var weaponToEquip = bag.take(weaponTitle);
        if(!(weaponToEquip instanceof Weapon)){
            bag.add(weaponToEquip);
            throw new EquipWeaponFailedException();
        }
        if(currentEquipped != null)
            bag.add(currentEquipped);
        return (Weapon) weaponToEquip;
    }
}
