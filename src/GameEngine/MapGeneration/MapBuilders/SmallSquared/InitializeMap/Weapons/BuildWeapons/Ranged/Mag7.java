package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.Weapons.BuildWeapons.Ranged;

import GameEngine.MapGeneration.MapBuilders.Map.MapObject;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.LivingObjects.Organism;

public class Mag7 extends RangeWeapon{
    public Mag7() {
        super("shotgun", "Mag7");
        _ammo = 7;
        _damage = 10;
    }

    @Override
    public String attack(MapObject targetObject) throws FatalBlowException {
        if(targetObject instanceof Organism){
            var target = (Organism) targetObject;
            useAmmo();
            target.takeHealth(_damage);
        }
        return "BANG!";
    }
}
