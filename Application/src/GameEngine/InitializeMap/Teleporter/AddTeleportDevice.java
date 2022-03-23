package GameEngine.InitializeMap.Teleporter;

import GameEngine.BuildMap.Rooms.Room;
import java.util.List;
import java.util.Random;

public class AddTeleportDevice {
    private int randomIndex(int bound){
        var rand = new Random();
        return rand.nextInt(bound);
    }

    public void add(List<Room> rooms){
        var normals = rooms.stream()
                .filter(r -> r.getRoomType() == Room.RoomType.Normal
                && !r.isSealed()).toList();
        var randIndex = randomIndex(normals.size());
        normals.get(randIndex).addItem(new TeleportDevice());
    }
}
