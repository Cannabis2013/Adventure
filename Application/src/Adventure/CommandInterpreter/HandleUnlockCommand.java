package Adventure.CommandInterpreter;

import Adventure.ScreenMessages.PrintMessages;
import GameEngine.BuildMap.Rooms.WrongKeyException;
import GameEngine.GameEngine;
import GameEngine.Restrictions.DoorNotFoundException;
import GameEngine.Utils.ItemNotFoundException;

public class HandleUnlockCommand {
    private boolean isOrientationValid(String command){
        switch (command){
            case "north","east", "south", "west", "n", "e", "s", "w" : return true;
            default: return false;
        }
    }

    private void unlockDoor(String orientation, String key, PrintMessages printer, GameEngine engine){
        try {
            engine.unlock(orientation,key);
            printer.printDoorUnlocked();
        } catch (IllegalArgumentException e){
            printer.printBadCommand();
        } catch (WrongKeyException e){
            printer.printWrongKey();
        } catch (ItemNotFoundException e) {
            printer.printItemNotInInventory();
        } catch (DoorNotFoundException e) {
            printer.printDoorNotFound();
        }
    }

    private boolean isValidFormat(String command){
        return command.matches("unlock [A-z]+ [A-z]+");
    }

    public void handle(String cmd, PrintMessages printer, GameEngine engine){
        if(!isValidFormat(cmd)){
            printer.printBadCommand();
            return;
        }
        var reducedCmd = cmd.substring(7);
        var orientation = reducedCmd.substring(0,reducedCmd.indexOf(" "));
        var key = reducedCmd.substring(reducedCmd.indexOf(" ") + 1);
        if(isOrientationValid(orientation))
            unlockDoor(orientation,key,printer,engine);
        else
            printer.printBadCommand();
    }
}
