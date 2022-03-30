package GameEngine.MapGeneration.SmallSquare.Map.Rooms;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.Contracts.IPresentable;

public class Door implements IObjectEntity, IPresentable {
    private int lockID;
    private boolean locked = false;
    private static int _id;
    private String _title;

    private Node _node1, _node2;

    public Door(Node node1, Node Node2) {
        _id++;
        _title = String.format("door %d",_id);
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

    public Node getOther(Node thisRoom) throws DoorIsLockedException {
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

    @Override
    public int id() {
        return _id;
    }

    @Override
    public String title() {
        return _title;
    }

    @Override
    public String presentate() {
        return String.format("%s %s",_title,isLocked() ? "(locked)" : "(not locked)");
    }
}
