package GameEngine.MapGeneration.SmallSquare.InitializeMap;

import GameEngine.MapGeneration.SmallSquare.Models.Room;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapDescriptions.AddMapDescriptions;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapRestrictions.AddAccessRestrictions;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.Teleporter.AddTeleportDevice;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.AddWeapons;
import java.util.List;

/*
    Add room descriptions
    Add objects like keys, weapons, and other stuff, to rooms at random.
    Also restricts map rooms. Ex. add locks to the boss room in the middle
 */

public class InitializeMap {
    private AddMapDescriptions _addDescriptions = new AddMapDescriptions();
    private AddAccessRestrictions _addAccessRestrictions = new AddAccessRestrictions();
    private AddTeleportDevice _addTeleport = new AddTeleportDevice();
    private AddWeapons _addWeapons = new AddWeapons();
    public void initialize(List<Room> rooms){
        _addDescriptions.add(rooms);
        _addAccessRestrictions.add(rooms);
        _addTeleport.add(rooms);
        _addWeapons.add(rooms);
    }
}
