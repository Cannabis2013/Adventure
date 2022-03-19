package GameEngine.BuildMap;

import java.util.ArrayList;
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

    private int bound(ArrayList<Room> rooms){
        return  (int) Math.sqrt(rooms.size() + 1);
    }


    private void tryConnectWest(ArrayList<Room> rooms, int index, Room room, int x, int y){
        if(x > 0){
            var eastOf = rooms.get(index - 1);
            room.setWest(eastOf);
        }
    }

    private void tryConnectNorth(ArrayList<Room> rooms,int index, Room room, int x, int y){
        if(y >0)
        {
            var indexOfNorthRoom = index - bound(rooms);
            var northRoom = rooms.get(indexOfNorthRoom);
            room.setNorth(northRoom);
        }
    }

    private void connectNormals(ArrayList<Room> rooms,int index, int x, int y){
        if(x >= bound(rooms))
        {
            x = 0;
            y++;
        }
        if(index >= rooms.size())
            return;
        var room = rooms.get(index);
        tryConnectWest(rooms,index,room,x,y);
        tryConnectNorth(rooms,index,room,x,y);
        connectNormals(rooms,++index,++x,y);
    }

    private void randomizeConnections(Room room, ArrayList<Room> rooms){
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

    private void promoteMedian(ArrayList<Room> rooms){
        var median = (rooms.size() / 2);
        var room = rooms.get(median);
        room.promote();
        room.disconnect();
        randomizeConnections(room,rooms);
    }

    public void connect(ArrayList<Room> rooms) throws IllegalArgumentException {
        if(!isSquare(rooms.size()))
            throw new IllegalArgumentException();
        connectNormals(rooms,0,0,0);
        promoteMedian(rooms);
    }
}
