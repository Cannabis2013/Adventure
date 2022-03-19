package Adventure;

import Adventure.CommandInterpreter.CommandInterpreter;
import Adventure.ScreenMessages.PrintMessages;
import java.util.Scanner;

public class Adventure{
    private PrintMessages printMessage = new PrintMessages();
    private Scanner inputReader = new Scanner(System.in);
    private CommandInterpreter interpreter = new CommandInterpreter();

    protected String readCommand(){
        String command = inputReader.nextLine();
        return command;
    }

    private void pressButton(){
        printMessage.printPressButtonCommand();
        inputReader.nextLine();
    }

    public void run(){
        printMessage.printIntro();
        pressButton();
        printMessage.printHelp();
        pressButton();
        while (true)
        {
            printMessage.printCommandLine();
            var command = readCommand();
            interpreter.interpret(command,printMessage);
        }
    }
}
