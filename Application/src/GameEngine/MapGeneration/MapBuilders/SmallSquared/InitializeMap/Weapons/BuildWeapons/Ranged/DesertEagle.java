package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.Weapons.BuildWeapons.Ranged;

import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapGeneration.MapBuilders.Map.MapObject;

public class DesertEagle extends RangeWeapon {
    public DesertEagle() {
        super("Pistol", "desert eagle");
        _damage = 3;
        _ammo = 7;
    }

    @Override
    public String attack(MapObject targetObject) throws FatalBlowException {
        return "BANG";
    }
}
