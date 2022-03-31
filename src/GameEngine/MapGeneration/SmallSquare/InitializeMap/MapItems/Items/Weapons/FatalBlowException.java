package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons;

public class FatalBlowException extends Exception{
    @Override
    public String getMessage() {
        return "Fatal shot!";
    }
}
