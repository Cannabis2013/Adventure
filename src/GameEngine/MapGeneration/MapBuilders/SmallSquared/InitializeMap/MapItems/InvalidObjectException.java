package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.MapItems;

public class InvalidObjectException extends Exception{
    @Override
    public String getMessage() {
        return "Not player";
    }
}
