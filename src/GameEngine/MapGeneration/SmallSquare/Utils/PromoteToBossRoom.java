package GameEngine.MapGeneration.SmallSquare.Utils;

import GameEngine.MapGeneration.SmallSquare.Models.Room;
import GameEngine.Contracts.IRoom;

import java.util.List;
import java.util.Random;

public class PromoteToBossRoom {
    private void connect(Room room, List<Room> rooms, int bound){
        var rand = new Random();
        int median = rooms.size() / 2;
        var northOf = rooms.get(median - bound);
        var eastOf = rooms.get(median+1);
        var southOf = rooms.get(median + bound);
        var westOf = rooms.get(median-1);
        var num = rand.nextInt(4) + 1;
        switch (num){
            case 1 -> room.setNorth(northOf);
            case 2 -> room.setEast(eastOf);
            case 3 -> room.setSouth(southOf);
            case 4 -> room.setWest(westOf);
        }
    }

    public void promote(List<Room> rooms, int bound){
        var median = (rooms.size() / 2);
        var room = rooms.get(median);
        var rm = rooms.stream().map(r -> {
            if(r.id() == room.id())
                return new Room(IRoom.RoomType.BOSS_ROOM,room.map());
            return r;
        });
        room.promote();
        room.disconnect();
        connect(room,rooms,bound);
    }
}
