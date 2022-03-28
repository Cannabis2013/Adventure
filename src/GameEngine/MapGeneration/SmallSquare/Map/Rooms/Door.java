package GameEngine.MapGeneration.SmallSquare.Map.Rooms;

import GameEngine.Contracts.DoorIsLockedException;
import GameEngine.Contracts.IRoom;
import GameEngine.MapGeneration.SmallSquare.Map.MapObject;

public class Door extends MapObject {
    private int lockID;
    private boolean locked = false;

    private Node _node1, _node2;

    public Door(Node node1, Node Node2) {
        super("door");
        this._node1 = node1;
        this._node2 = Node2;
    }

    public Node other(Node thisNode){
        if(_node1.equals(thisNode))
            return _node2;
        else if(_node2.equals(thisNode))
            return _node1;
        else
            return null;
    }

    public IRoom getOther(IRoom thisRoom) throws DoorIsLockedException {
        if(locked)
            throw new DoorIsLockedException();
        if(_node1.equals(thisRoom))
            return _node2;
        else if(_node2.equals(thisRoom))
            return _node1;
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
