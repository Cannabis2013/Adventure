package Adventure;

import Adventure.CommandInterpreter.General.HandleGeneralCommand;
import Adventure.CommandInterpreter.ItemInteraction.HandleInteractionCommands;
import Adventure.CommandInterpreter.ItemUsage.HandleUseItem;
import Adventure.CommandInterpreter.Travel.HandleTravel;
import Adventure.CommandInterpreter.Unlock.HandleUnlockCommand;
import Adventure.ScreenMessages.PrintHelp;
import Adventure.ScreenMessages.PrintMessages;
import GameEngine.GameEngine;

import java.util.Scanner;

public class Adventure{
    private final PrintMessages printer = new PrintMessages();
    private final Scanner inputReader = new Scanner(System.in);
    private final GameEngine _engine = new GameEngine();
    private final HandleTravel _handleGo = new HandleTravel();
    private final HandleGeneralCommand _handleGeneral = new HandleGeneralCommand();
    private final HandleInteractionCommands _handleInteraction = new HandleInteractionCommands();
    private final HandleUnlockCommand _handleUnlock = new HandleUnlockCommand();
    private final HandleUseItem _handleUseItem = new HandleUseItem();
    private final PrintHelp _printHelp = new PrintHelp();

    public void interpretCommand(String command){
        if(command.startsWith("go"))
            _handleGo.handle(command, _engine);
        else if(command.startsWith("take"))
            _handleInteraction.handleTake(command, _engine);
        else if(command.startsWith("drop"))
            _handleInteraction.handleDrop(command, _engine);
        else if (command.startsWith("eat"))
            _handleInteraction.handleEat(command, _engine);
        else if(command.startsWith("unlock"))
            _handleUnlock.handle(command, _engine);
        else if(command.startsWith("use"))
            _handleUseItem.handleUse(command, _engine);
        else
            _handleGeneral.handle(command, _engine);
    }

    protected String readCommand(){
        String command = inputReader.nextLine();
        return command;
    }

    private void pressButton(){
        printer.printPressButtonCommand();
        inputReader.nextLine();
    }

    public void run(){
        printer.printIntro();
        pressButton();
        _printHelp.print();
        pressButton();
        interpretCommand("look");
        while (true)
        {
            printer.printCommandLine();
            var command = readCommand();
            interpretCommand(command);
        }
    }
}
