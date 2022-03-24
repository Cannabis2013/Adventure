package GameEngine.InitializeMap.Weapons.BuildWeapons.Ranged;

import GameEngine.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapObjects.MapObject;

public class DesertEagle extends RangeWeapon {
    public DesertEagle() {
        super("Pistol", "Desert Eagle");
        _damage = 3;
        _ammo = 7;
    }

    @Override
    public String attack(MapObject targetObject) throws FatalBlowException {
        return null;
    }
}
