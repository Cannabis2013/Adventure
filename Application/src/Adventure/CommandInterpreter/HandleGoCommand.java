package Adventure.CommandInterpreter;

import Adventure.ScreenMessages.PrintMessages;
import GameEngine.BuildMap.Rooms.DoorIsLockedException;
import GameEngine.GameEngine;
import GameEngine.MapLogistics.BadDirectionException;
import GameEngine.MapLogistics.NoDoorAtOrientationException;

public class HandleGoCommand {
    private boolean validateOrientation(String command){
        switch (command){
            case "north","east", "south", "west", "n", "e", "s", "w" : return true;
            default: return false;
        }
    }

    private void travelTo(String orientation, PrintMessages printMessage, GameEngine engine){
        try {
            engine.traverseTo(orientation);
            printMessage.printRoomInfo(engine.roomDescription(),engine.roomItems());
        } catch (IllegalArgumentException e){
            printMessage.printBadCommand();
        } catch (BadDirectionException | NoDoorAtOrientationException e){
            printMessage.printBadDirection();
        } catch (DoorIsLockedException e){
            printMessage.printLockedDoorMsg();
        }
    }

    public void handle(String command, PrintMessages printMessage, GameEngine engine){
        if(!command.matches("go [A-z]+")){
            printMessage.printBadCommand();
            return;
        }
        var orientation = command.substring(3);
        if(!validateOrientation(orientation))
            printMessage.printBadCommand();
        else
            travelTo(orientation,printMessage,engine);
    }
}
