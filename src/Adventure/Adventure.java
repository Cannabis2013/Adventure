package Adventure;

import Adventure.CommandInterpreter.Attack.HandleAttack;
import Adventure.CommandInterpreter.Attack.PlayerIsDeadException;
import Adventure.CommandInterpreter.EquipWeapon.HandleEquipWeapon;
import Adventure.CommandInterpreter.General.HandleGeneral;
import Adventure.CommandInterpreter.ItemInteraction.HandleInteraction;
import Adventure.CommandInterpreter.ItemUsage.HandleUseItem;
import Adventure.CommandInterpreter.Travel.HandleTravel;
import Adventure.ScreenMessages.PrintHelp;
import Adventure.ScreenMessages.PrintMessages;
import GameEngine.GameEngine;

import java.util.Scanner;

public class Adventure{
    private final PrintMessages printer = new PrintMessages();
    private final PrintHelp _printHelp = new PrintHelp();
    private final GameEngine _engine = new GameEngine();
    private final Scanner inputReader = new Scanner(System.in);
    private final HandleTravel _handleGo = new HandleTravel();
    private final HandleGeneral _handleGeneral = new HandleGeneral();
    private final HandleInteraction _handleInteraction = new HandleInteraction();
    private final HandleUseItem _handleUseItem = new HandleUseItem();
    private final HandleEquipWeapon _handleEquip = new HandleEquipWeapon();
    private final HandleAttack _handleAttack = new HandleAttack();

    public void interpretCommand(String command) throws PlayerIsDeadException {
        if(command.startsWith("go"))
            _handleGo.handle(command, _engine);
        else if(command.startsWith("take"))
            _handleInteraction.handleTake(command, _engine);
        else if(command.startsWith("drop"))
            _handleInteraction.handleDrop(command, _engine);
        else if (command.startsWith("eat"))
            _handleInteraction.handleEat(command, _engine);
        else if(command.startsWith("use"))
            _handleUseItem.handleUse(command, _engine);
        else if(command.startsWith("equip"))
            _handleEquip.handleEquip(command,_engine);
        else if(command.startsWith("attack"))
            _handleAttack.handleAttack(command,_engine);
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
        int code = 1;
        while (code != 0){
            code = 2;
            _engine.init();
            printer.printIntro();
            pressButton();
            _printHelp.print();
            pressButton();
            _handleGeneral.handle("look",_engine);
            while (code == 2)
            {
                printer.printCommandLine();
                var command = readCommand();
                try {
                    interpretCommand(command);
                } catch (PlayerIsDeadException e) {
                    pressButton();
                    code = 1;
                }
            }
        }
    }
}
