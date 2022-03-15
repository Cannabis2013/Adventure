package Adventure;

import Adventure.HelpScreen.HelpStringBuilder;
import Adventure.MapBuilder.MapBuilder;
import Adventure.MapLogistics.MapCanTraverseTo;
import Adventure.MapLogistics.MapTraverseTo;
import Adventure.Printer.Printer;
import Adventure.Room.Room;

import java.util.Scanner;

public class Adventure {
    Printer printer = new Printer();
    Scanner inputReader = new Scanner(System.in);
    MapBuilder mapBuilder = new MapBuilder();
    MapTraverseTo traverseTo = new MapTraverseTo();
    HelpStringBuilder helpStringBuilder = new HelpStringBuilder();
    Room currentRoom;

    private void printHelp()
    {
        String helpStr = helpStringBuilder.build();
        printer.printLine(helpStr);
    }

    private void printDescription(){
        printer.printLine(currentRoom.description);
    }

    private void printBadCommand(){
        printer.printLine("Bad command. Please try again");
    }

    private void handleGoCommand(String orientation){
        try {
            currentRoom = traverseTo.traverseTo(orientation,currentRoom);
        } catch (IllegalArgumentException e){
            printBadCommand();
        } catch (IllegalStateException e){
            printer.printLine("you can not go that way");
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

    public Adventure(){
        currentRoom = mapBuilder.build();
    }

    public void run(){
        boolean isRunning = true;
        while (isRunning)
        {
            String command = inputReader.nextLine();
            interpretCommand(command);
        }
    }
}
