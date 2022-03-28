package GameEngine.Player.Actions;

import GameEngine.Contracts.DoorIsLockedException;
import GameEngine.Contracts.IRoom;
import GameEngine.Player.Exceptions.BadDirectionException;
import GameEngine.Player.Exceptions.NoDoorAtOrientationException;

public class EnterDoorAtOrientation {

    private IRoom tryGoNorth(IRoom currentRoom) throws DoorIsLockedException, NoDoorAtOrientationException {
        if(currentRoom.getNorth() != null)
            return currentRoom.getNorth().getOther(currentRoom);
        else
            throw new NoDoorAtOrientationException();
    }

    private IRoom tryGoEast(IRoom currentRoom) throws DoorIsLockedException, NoDoorAtOrientationException {
        if(currentRoom.getEast() != null)
            return currentRoom.getEast().getOther(currentRoom);
        else
            throw new NoDoorAtOrientationException();

    }

    private IRoom tryGoSouth(IRoom currentRoom) throws DoorIsLockedException, NoDoorAtOrientationException {
        if(currentRoom.getSouth() != null)
            return currentRoom.getSouth().getOther(currentRoom);
        else
            throw new NoDoorAtOrientationException();

    }

    private IRoom tryGoWest(IRoom currentRoom) throws DoorIsLockedException, NoDoorAtOrientationException {
        if(currentRoom.getWest() != null)
            return currentRoom.getWest().getOther(currentRoom);
        else
            throw new NoDoorAtOrientationException();

    }

    public IRoom enterAtOrientation(String orientation, IRoom currentRoom) throws DoorIsLockedException, BadDirectionException, NoDoorAtOrientationException {
        switch (orientation){
            case "north" -> {return tryGoNorth(currentRoom);}
            case "east" -> {return tryGoEast(currentRoom);}
            case "south" -> {return tryGoSouth(currentRoom);}
            case "west" -> {return tryGoWest(currentRoom);}
            default -> throw new BadDirectionException();
        }
    }
}
