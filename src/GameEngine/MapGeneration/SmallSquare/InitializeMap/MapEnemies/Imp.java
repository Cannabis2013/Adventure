package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapEnemies;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Ranged.AK47;
import GameEngine.MapGeneration.SmallSquare.Map.Rooms.Room;

public class Imp extends Enemy {
    public Imp(Room currentRoom) {
        super("imp");
        _health = 100;
        _weapon = new AK47();
        _currentRoom = currentRoom;
        _hitChance = 0.5;
    }
}
