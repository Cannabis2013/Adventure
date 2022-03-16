import Adventure.Adventure;
import ApplicationBuilder.BuildApplication;

public class Program {
    public static void main(String[] args) {
        var engine = new BuildApplication().build();
        var game = new Adventure();
        game.setEngine(engine);
        game.run();
    }
}
