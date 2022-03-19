package GameEngine.BuildMap.Rooms;

public class WrongKeyException extends Exception{
    @Override
    public String getMessage() {
        return "It's the wrong key";
    }
}
