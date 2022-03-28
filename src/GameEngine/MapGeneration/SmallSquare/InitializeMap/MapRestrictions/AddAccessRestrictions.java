package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapRestrictions;

import GameEngine.MapGeneration.SmallSquare.Models.Room;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Item;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.RandomRoomsPopulator;
import GameEngine.Contracts.IRoom;

import java.util.List;

public class AddAccessRestrictions extends RandomRoomsPopulator {
    private MapAccessRestrictions _restrictMap = new MapAccessRestrictions();

    public void add(List<Room> rooms){
        var keys = _restrictMap.restrict(rooms)
                .stream().map(k -> (Item) k).toList();
        var normals = rooms.stream()
                .filter(r -> r.getRoomType() == IRoom.RoomType.NORMAL_ROOM).toList();
        addItems(normals,keys);
    }
}
