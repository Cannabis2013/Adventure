package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapEnemies;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Ranged.AK47;
import GameEngine.MapGeneration.SmallSquare.Map.Rooms.Room;
import GameEngine.Player.Character;

public class Imp extends Character {
    public Imp(Room currentRoom) {
        super("imp");
        _health = 50;
        _weapon = new AK47();
        _currentRoom = currentRoom;
    }
}
