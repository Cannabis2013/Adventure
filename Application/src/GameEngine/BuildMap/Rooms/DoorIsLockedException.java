package GameEngine.BuildMap.Rooms;

public class DoorIsLockedException extends Exception{
    @Override
    public String getMessage() {
        return "The door is locked";
    }
}