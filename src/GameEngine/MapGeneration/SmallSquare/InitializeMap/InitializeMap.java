package GameEngine.MapGeneration.SmallSquare.InitializeMap;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapEnemies.AddEnemies;
import GameEngine.MapGeneration.SmallSquare.Map.Rooms.Room;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapDescriptions.AddMapDescriptions;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapRestrictions.AddAccessRestrictions;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.AddItemsToRooms;
import java.util.List;

/*
    Add room descriptions
    Add objects like keys, weapons, and other stuff, to rooms at random.
    Also restricts map rooms. Ex. add locks to the boss room in the middle
 */

public class InitializeMap {
    private AddMapDescriptions _addDescriptions = new AddMapDescriptions();
    private AddAccessRestrictions _addAccessRestrictions = new AddAccessRestrictions();
    private AddItemsToRooms _addItems = new AddItemsToRooms();
    private AddEnemies _addEnemies = new AddEnemies();
    public void initialize(List<Room> rooms){
        _addDescriptions.add(rooms);
        _addAccessRestrictions.add(rooms);
        _addItems.add(rooms);
        _addEnemies.add(rooms);
    }
}
