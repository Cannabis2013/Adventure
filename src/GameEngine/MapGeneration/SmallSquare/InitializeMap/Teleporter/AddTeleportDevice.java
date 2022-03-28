package GameEngine.MapGeneration.SmallSquare.InitializeMap.Teleporter;

import GameEngine.MapGeneration.SmallSquare.Models.Room;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Item;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.RandomRoomsPopulator;
import GameEngine.Contracts.IRoom;

import java.util.ArrayList;
import java.util.List;

public class AddTeleportDevice extends RandomRoomsPopulator {
    private List<Item> buildTeleporters(int count){
        var teleporters = new ArrayList<Item>();
        for (var i = 0;i <count;i++)
            teleporters.add(new TeleportDevice());
        return teleporters;
    }

    public void add(List<Room> rooms){
        var normals = rooms.stream()
                .filter(r -> r.getRoomType() == IRoom.RoomType.NORMAL_ROOM
                && !r.isSealed()).toList();
        var teleporters = buildTeleporters(2);
        teleporters.add(new TeleportDevice());
        addItems(normals,teleporters);
    }
}
