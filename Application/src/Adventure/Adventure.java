package Adventure;

import Adventure.CommandInterpreter.*;
import Adventure.ScreenMessages.PrintMessages;
import GameEngine.GameEngine;
import java.util.Scanner;

public class Adventure{
    private PrintMessages printer = new PrintMessages();
    private Scanner inputReader = new Scanner(System.in);
    private GameEngine engine = new GameEngine();
    private HandleGoCommand _handleGo = new HandleGoCommand();
    private HandleGeneralCommand _handleGeneral = new HandleGeneralCommand();
    private HandleInteractionCommands _handleInteraction = new HandleInteractionCommands();
    private HandleUnlockCommand _handleUnlock = new HandleUnlockCommand();

    public void interpretCommand(String command){
        if(command.startsWith("go"))
            _handleGo.handle(command, printer, engine);
        else if(command.startsWith("take"))
            _handleInteraction.handleTakeCommand(command, printer, engine);
        else if(command.startsWith("drop"))
            _handleInteraction.handleDrop(command, printer, engine);
        else if(command.startsWith("unlock"))
            _handleUnlock.handle(command, printer, engine);
        else
            _handleGeneral.handle(command, printer, engine);
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
        printer.printHelp();
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
