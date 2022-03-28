package GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons.Ranged;

import GameEngine.Contracts.IInflictable;
import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.FatalBlowException;

public class Mag7 extends RangeWeapon{
    public Mag7() {
        super("shotgun", "Mag7");
        _ammo = 7;
        _damage = 10;
    }

    @Override
    public String attack(IObjectEntity targetObject) throws FatalBlowException {
        if(targetObject instanceof IInflictable){
            var target = (IInflictable) targetObject;
            useAmmo();
            target.inflict(_damage);
        }
        return "BANG!";
    }
}
