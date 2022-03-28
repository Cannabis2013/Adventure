package GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects;

public class FatalBlowException extends Exception{
    @Override
    public String getMessage() {
        return "Fatal shot!";
    }
}
