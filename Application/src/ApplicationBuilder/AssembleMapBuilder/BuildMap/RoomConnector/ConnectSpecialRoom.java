package ApplicationBuilder.AssembleMapBuilder.BuildMap.RoomConnector;

import ApplicationBuilder.AssembleMapBuilder.BuildMap.BuildRooms.Rooms;

import java.util.Random;

public class ConnectSpecialRoom extends AbstractConnectRooms {

    public void connect(Rooms rooms)
    {
        var room5 = rooms.room5;
        var rand = new Random();
        var num = rand.nextInt(4) + 1;
        switch (num){
            case 1 -> {connectRoomNorth(room5,rooms.room2);}
            case 2 -> {connectRoomEast(room5,rooms.room6);}
            case 3 -> {connectRoomSouth(room5,rooms.room8);}
            case 4 -> {connectRoomWest(room5,rooms.room4);}
        }
    }

}
