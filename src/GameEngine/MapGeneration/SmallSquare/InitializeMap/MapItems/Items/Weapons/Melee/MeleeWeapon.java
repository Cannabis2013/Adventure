package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Melee;

import GameEngine.Contracts.IInflictable;
import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Weapon;
import GameEngine.Player.Exceptions.DodgedAttackException;

public abstract class MeleeWeapon extends Weapon {
    public MeleeWeapon(String title) {
        super(title);
    }

    private int hit(){
        return 0;
    }

    private int hit(IInflictable target) throws FatalBlowException, DodgedAttackException {
        return target.inflict(_damage);
    }

    @Override
    public int attack(){
        return hit();
    }

    @Override
    public int attack(IObjectEntity target) throws FatalBlowException, InvalidObjectException, DodgedAttackException {
        if(!(target instanceof IInflictable))
            throw new InvalidObjectException();
        var inflictableTarget = (IInflictable) target;
        return hit(inflictableTarget);
    }

    @Override
    public String presentate() {
        return String.format("%s (Damage: %d)", title(), _damage);
    }
}
