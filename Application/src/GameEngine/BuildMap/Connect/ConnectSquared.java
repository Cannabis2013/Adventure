package GameEngine.BuildMap.Connect;

import GameEngine.BuildMap.Rooms.DoorIsLockedException;
import GameEngine.BuildMap.Rooms.Room;

import java.util.List;
import java.util.Random;

public class ConnectSquared {
    private boolean isSquare(int count){
        if(count < 9)
            return false;
        else if(count % 2 == 0)
            return false;
        var root = Math.sqrt(count);
        int flooredRoot = (int) root;
        double diff = root - flooredRoot;
        return diff == 0;
    }

    private int bound(List<Room> rooms){
        return  (int) Math.sqrt(rooms.size() + 1);
    }

    private void tryConnectWest(List<Room> rooms, int index, Room room, int x){
        if(x > 0){
            var eastOf = rooms.get(index - 1);
            room.setWest(eastOf);
        }
    }

    private void tryConnectNorth(List<Room> rooms,int index, Room room,int y){
        if(y >0)
        {
            var indexOfNorthRoom = index - bound(rooms);
            var northRoom = rooms.get(indexOfNorthRoom);
            room.setNorth(northRoom);
        }
    }

    private void connectNormals(List<Room> rooms,int index, int x, int y){
        if(x >= bound(rooms))
        {
            x = 0;
            y++;
        }
        if(index >= rooms.size())
            return;
        var room = rooms.get(index);
        tryConnectWest(rooms,index,room,x);
        tryConnectNorth(rooms,index,room,y);
        connectNormals(rooms,++index,++x,y);
    }

    private void randomizeConnections(Room room, List<Room> rooms){
        var rand = new Random();
        int median = rooms.size() / 2;
        var bound = bound(rooms);
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

    private void promoteMedian(List<Room> rooms) throws DoorIsLockedException {
        var median = (rooms.size() / 2);
        var room = rooms.get(median);
        room.promote();
        room.disconnect();
        randomizeConnections(room,rooms);
    }

    public void connect(List<Room> rooms) throws IllegalArgumentException {
        if(!isSquare(rooms.size()))
            throw new IllegalArgumentException();
        connectNormals(rooms,0,0,0);
        try {
            promoteMedian(rooms);
        } catch (DoorIsLockedException e) {
            e.printStackTrace();
        }
    }
}
