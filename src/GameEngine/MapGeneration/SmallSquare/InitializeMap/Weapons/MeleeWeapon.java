package GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons;

import GameEngine.Contracts.IInflictable;
import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.InvalidObjectException;

public abstract class MeleeWeapon extends Weapon {
    public MeleeWeapon(String shortTitle, String title) {
        super(shortTitle, title);
    }

    private int hit(){
        return 0;
    }

    private int hit(IInflictable target){
        return 0;
    }

    @Override
    public int attack(IObjectEntity target) throws FatalBlowException, InvalidObjectException {
        if(target == null)
            return hit();
        else if(!(target instanceof IInflictable))
            throw new InvalidObjectException();
        var inflictableTarget = (IInflictable) target;
        return hit(inflictableTarget);
    }

    @Override
    public String presentate() {
        return String.format("%s (Damage: %d)", _title, _damage);
    }
}
