package GameEngine.Contracts;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;

public interface IInflictable {
    int inflict(int damage) throws FatalBlowException;
}
