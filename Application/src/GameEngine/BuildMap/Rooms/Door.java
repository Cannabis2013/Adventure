package GameEngine.BuildMap.Rooms;

import GameEngine.MapObjects.MapObject;

public class Door extends MapObject {
    private int lockID;
    private boolean locked = false;
    private static int _doorIndex = 0;

    private Room room1,room2;

    public Door(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
        _title = String.format("door %d",++_doorIndex);
    }

    public Room getOther(Room thisRoom) throws DoorIsLockedException {
        if(locked)
            throw new DoorIsLockedException();
        if(room1.equals(thisRoom))
            return room2;
        else if(room2.equals(thisRoom))
            return room1;
        else
            throw new DoorIsLockedException();
    }

    public boolean isLocked() {
        return locked;
    }

    public void lock(int lockID) {
        this.locked = true;
        this.lockID = lockID;
    }

    public void unlock(int lockID) {
        if(this.lockID == lockID)
            locked = false;
    }
}
