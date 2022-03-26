package GameEngine.MapGeneration.MapBuilders.SmallSquared.InitializeMap.LivingObjects;

public class FatalBlowException extends Exception{
    @Override
    public String getMessage() {
        return "Fatal shot!";
    }
}
