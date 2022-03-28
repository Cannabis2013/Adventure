package GameEngine.Contracts;

import GameEngine.MapGeneration.SmallSquare.Models.Node;

public interface IDoor {
    Node other(Node thisNode);

    IRoom getOther(IRoom thisRoom) throws DoorIsLockedException;

    boolean isLocked();

    void lock(int lockID);

    void unlock(int lockID);
}
