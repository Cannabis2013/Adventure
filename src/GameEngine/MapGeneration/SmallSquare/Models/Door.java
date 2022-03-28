package GameEngine.MapGeneration.SmallSquare.Models;

import GameEngine.Contracts.DoorIsLockedException;
import GameEngine.Contracts.IRoom;

public class Door extends MapObject implements GameEngine.Contracts.IDoor {
    private int lockID;
    private boolean locked = false;

    private Node _node1, _node2;

    public Door(Node node1, Node Node2) {
        super("door");
        this._node1 = node1;
        this._node2 = Node2;
    }

    @Override
    public Node other(Node thisNode){
        if(_node1.equals(thisNode))
            return _node2;
        else if(_node2.equals(thisNode))
            return _node1;
        else
            return null;
    }

    @Override
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

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public void lock(int lockID) {
        this.locked = true;
        this.lockID = lockID;
    }

    @Override
    public void unlock(int lockID) {
        if(this.lockID == lockID)
            locked = false;
    }
}
