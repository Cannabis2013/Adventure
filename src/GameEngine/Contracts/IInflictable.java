package GameEngine.Contracts;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;
import GameEngine.Player.Exceptions.DodgedAttackException;

public interface IInflictable {
    int inflict(int damage) throws FatalBlowException, DodgedAttackException;
}
