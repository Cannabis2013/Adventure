package ApplicationBuilder.AssembleMapBuilder.BuildMap;

import ApplicationBuilder.AssembleMapBuilder.BuildMap.BuildRooms.Room;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.BuildRooms.Rooms;
import ApplicationBuilder.AssembleMapBuilder.Contracts.BuildMap.AbstractBuildMap;

import java.util.Random;

public class BuildMap extends AbstractBuildMap {

    private void initializeMap(Rooms room) {
        _updateRoomDescriptions.updateRecursive(room.room1);
        _updateSpecialRoomDescriptions.update(room.room5);
    }

    public void connectSpecial(Rooms rooms)
    {
        var room5 = rooms.room5;
        var rand = new Random();

        var num = rand.nextInt(4) + 1;
        switch (num){
            case 1 -> room5.setNorth(rooms.room2);
            case 2 -> room5.setEast(rooms.room6);
            case 3 -> rooms.room5.setSouth(rooms.room8);
            case 4 -> rooms.room5.setWest(rooms.room4);
        }
    }

    private void connectRooms(Rooms rooms){
        rooms.room1.setEast(rooms.room2);
        rooms.room2.setEast(rooms.room3);
        rooms.room3.setSouth(rooms.room6);
        rooms.room6.setSouth(rooms.room9);
        rooms.room9.setWest(rooms.room8);
        rooms.room8.setWest(rooms.room7);
        rooms.room7.setNorth(rooms.room4);
        rooms.room4.setNorth(rooms.room1);
    }

    @Override
    public Room build(){
        var rooms = _roomBuilder.buildRooms();
        connectRooms(rooms);
        connectSpecial(rooms);
        initializeMap(rooms);
        return rooms.room1;
    }
}
