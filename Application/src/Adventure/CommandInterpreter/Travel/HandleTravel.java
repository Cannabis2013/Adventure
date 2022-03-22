package Adventure.CommandInterpreter.Travel;

import Adventure.ScreenMessages.PrintMessages;
import GameEngine.BuildMap.Rooms.DoorIsLockedException;
import GameEngine.GameEngine;
import GameEngine.MapLogistics.BadDirectionException;
import GameEngine.MapLogistics.NoDoorAtOrientationException;

public class HandleTravel {
    private PrintTravelMessages _printer = new PrintTravelMessages();

    private boolean validateOrientation(String command){
        switch (command){
            case "north","east", "south", "west", "n", "e", "s", "w" : return true;
            default: return false;
        }
    }

    private void travelTo(String orientation, GameEngine engine){
        try {
            engine.traverseTo(orientation);
            var description = engine.roomDescription();
            var items = engine.roomItems();
            _printer.printRoomInfo(description,items);
        } catch (IllegalArgumentException e){
            _printer.printBadCommand();
        } catch (BadDirectionException | NoDoorAtOrientationException e){
            _printer.printBadOrientation();
        } catch (DoorIsLockedException e){
            _printer.printLockedDoor();
        }
    }

    public void handle(String command, GameEngine engine){
        if(!command.matches("go [A-z]+")){
            _printer.printBadCommand();
            return;
        }
        var orientation = command.substring(3);
        if(!validateOrientation(orientation))
            _printer.printBadCommand();
        else
            travelTo(orientation,engine);
    }
}
