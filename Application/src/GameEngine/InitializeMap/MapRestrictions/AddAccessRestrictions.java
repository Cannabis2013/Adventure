package GameEngine.InitializeMap.MapRestrictions;

import GameEngine.BuildMap.Rooms.Room;
import GameEngine.InitializeMap.MapItems.Item;
import GameEngine.InitializeMap.MapItems.RandomRoomsPopulator;

import java.util.List;

public class AddAccessRestrictions extends RandomRoomsPopulator {
    private MapAccessRestrictions _restrictMap = new MapAccessRestrictions();

    public void add(List<Room> rooms){
        var keys = _restrictMap.restrict(rooms)
                .stream().map(k -> (Item) k).toList();
        var normals = rooms.stream()
                .filter(r -> r.getRoomType() == Room.RoomType.Normal).toList();
        addItems(normals,keys);
    }
}
