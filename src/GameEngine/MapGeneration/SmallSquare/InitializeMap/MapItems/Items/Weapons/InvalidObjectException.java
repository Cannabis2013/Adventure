package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons;

public class InvalidObjectException extends Exception{
    @Override
    public String getMessage() {
        return "Not player";
    }
}
