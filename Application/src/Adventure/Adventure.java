package Adventure;

public class Adventure extends AbstractAdventure{

    private void handleGoCommand(String orientation){
        try {
            application.traverseTo(orientation);
            printDescription();
        } catch (IllegalArgumentException e){
            printBadCommand();
        } catch (IllegalStateException e){
            printBadDirection();
        }
    }

    private void interpretCommand(String command){
        switch (command){
            case "exit" -> System.exit(0);
            case "help" -> printHelp();
            case "look" -> printDescription();
            case "go north" -> handleGoCommand("north");
            case "go east" -> handleGoCommand("east");
            case "go south" -> handleGoCommand("south");
            case "go west" -> handleGoCommand("west");
            default -> printBadCommand();
        }
    }

    @Override
    public void run(){
        printIntro();
        haltUntilPressed();
        printHelp();
        while (true)
        {
            var command = readCommand();
            interpretCommand(command);
        }
    }
}
