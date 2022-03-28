package GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons.Ranged;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.FatalBlowException;

public class DesertEagle extends RangeWeapon {
    public DesertEagle() {
        super("Pistol", "desert eagle");
        _damage = 3;
        _ammo = 7;
    }

    @Override
    public String attack(IObjectEntity targetObject) throws FatalBlowException {
        return "BANG";
    }
}
