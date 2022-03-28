package GameEngine.Contracts;

import GameEngine.Contracts.IRoom;

import java.util.List;

public interface IMap {
    List<IRoom> rooms();
    IRoom initialRoom();
    void setInitialRoom(IRoom room);
}
