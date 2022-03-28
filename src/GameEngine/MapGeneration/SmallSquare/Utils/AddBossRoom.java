package GameEngine.MapGeneration.SmallSquare.Utils;

import GameEngine.Contracts.IMap;
import GameEngine.MapGeneration.SmallSquare.Map.BossRoom;
import GameEngine.MapGeneration.SmallSquare.Map.Room;

import java.util.List;
import java.util.Random;

public class AddBossRoom {
    private void connect(Room room,List<Room> rooms, int bound){
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

    public void set(IMap map, List<Room> rooms, int bound){
        var median = (rooms.size() / 2);
        var medianRoom = rooms.get(median);
        medianRoom.disconnect();
        rooms.remove(median);
        medianRoom.promote();
        var bossRoom = new BossRoom(map);
        connect(bossRoom,rooms,bound);
        rooms.add(bossRoom);
    }
}
