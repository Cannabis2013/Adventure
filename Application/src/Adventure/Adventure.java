package Adventure;

import Adventure.StringBuilders.BadCommand.BuildBadCmdMessage;
import Adventure.StringBuilders.Descriptions.BuildDescriptMessage;
import Adventure.StringBuilders.Help.BuildHelpMessage;
import Adventure.StringBuilders.CommandLine.BuildCommandMessage;
import Adventure.MapBuilder.MapBuilder;
import Adventure.MapLogistics.MapTraverseTo;
import Adventure.Printer.Printer;
import Adventure.Room.Room;
import Adventure.StringBuilders.Intro.BuildIntroMessage;

import java.util.Scanner;

public class Adventure {
    Printer printer = new Printer();
    Scanner inputReader = new Scanner(System.in);
    MapBuilder mapBuilder = new MapBuilder();
    MapTraverseTo traverseTo = new MapTraverseTo();
    BuildCommandMessage buildCommandLineMsg = new BuildCommandMessage();
    BuildHelpMessage buildHelpMsg = new BuildHelpMessage();
    BuildDescriptMessage buildDescriptionMsg = new BuildDescriptMessage();
    BuildIntroMessage buildIntroMsg = new BuildIntroMessage();
    BuildBadCmdMessage buildBadCmdMsg = new BuildBadCmdMessage();
    Room currentRoom;

    private void printIntro(){
        String msg = buildIntroMsg.build();
        printer.printLine(msg);
    }

    private void printHelp()
    {
        String helpStr = buildHelpMsg.build();
        printer.printLine(helpStr);
    }

    private void printDescription(){
        var description = currentRoom.getDescription();
        var str = buildDescriptionMsg.build(description);
        printer.printLine(str);
    }

    private void printBadCommand(){
        var badCmdMsg = buildBadCmdMsg.build();
        printer.printLine(badCmdMsg);
    }

    private void handleGoCommand(String orientation){
        try {
            currentRoom = traverseTo.traverse(orientation,currentRoom);
            printDescription();
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

    private String readCommand(){
        var inputLine = buildCommandLineMsg.build();
        printer.print(inputLine);
        String command = inputReader.nextLine();
        return command;
    }

    public Adventure(){
        currentRoom = mapBuilder.build();
    }

    public void run(){
        printIntro();
        printer.print("Press any key to continue");
        inputReader.nextLine();
        printHelp();
        while (true)
        {
            var command = readCommand();
            interpretCommand(command);
        }
    }
}
