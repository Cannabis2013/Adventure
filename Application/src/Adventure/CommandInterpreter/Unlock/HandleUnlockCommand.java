package Adventure.CommandInterpreter.Unlock;

import Adventure.ScreenMessages.PrintMessages;
import GameEngine.BuildMap.Rooms.WrongKeyException;
import GameEngine.GameEngine;
import GameEngine.Restrictions.DoorNotFoundException;
import GameEngine.Utils.ItemNotFoundException;

public class HandleUnlockCommand {
    private PrintUnlockMessages _printer = new PrintUnlockMessages();

    private boolean isOrientationValid(String command){
        switch (command){
            case "north","east", "south", "west", "n", "e", "s", "w" : return true;
            default: return false;
        }
    }

    private void unlockDoor(String orientation, String key, GameEngine engine){
        try {
            engine.unlock(orientation,key);
            _printer.printDoorUnlocked();
        } catch (IllegalArgumentException e){
            _printer.printBadCommand();
        } catch (WrongKeyException e){
            _printer.printWrongKey();
        } catch (ItemNotFoundException e) {
            _printer.printKeyNotFound();
        } catch (DoorNotFoundException e) {
            _printer.printDoorNotFound();
        }
    }

    private boolean isValidFormat(String command){
        return command.matches("unlock [A-z]+ [A-z]+");
    }

    public void handle(String cmd, GameEngine engine){
        if(!isValidFormat(cmd)){
            _printer.printBadCommand();
            return;
        }
        var reducedCmd = cmd.substring(7);
        var orientation = reducedCmd.substring(0,reducedCmd.indexOf(" "));
        var key = reducedCmd.substring(reducedCmd.indexOf(" ") + 1);
        if(isOrientationValid(orientation))
            unlockDoor(orientation,key,engine);
        else
            _printer.printBadCommand();
    }
}
