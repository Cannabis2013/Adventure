package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Usables;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;

public interface IUsable {
    String useOn(IObjectEntity obj) throws InvalidObjectException;
}
