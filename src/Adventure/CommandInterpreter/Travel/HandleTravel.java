package Adventure.CommandInterpreter.Travel;

import Adventure.ScreenMessages.PrintRoomDetails;
import GameEngine.GameEngine;
import GameEngine.Contracts.DoorIsLockedException;
import GameEngine.Player.BadDirectionException;
import GameEngine.Player.NoDoorAtOrientationException;

public class HandleTravel {
    private PrintTravelMessages _printer = new PrintTravelMessages();
    private PrintRoomDetails _printRoomDetails = new PrintRoomDetails();

    private boolean validateOrientation(String command){
        switch (command){
            case "north","east", "south", "west", "n", "e", "s", "w" : return true;
            default: return false;
        }
    }

    private String translate(String input){
        switch (input){
            case "north", "n" -> {return "north";}
            case "east", "e" -> {return "east";}
            case "south", "s" -> {return "south";}
            case "west", "w" -> {return "west";}
            default -> {return "";}
        }
    }

    private void travelTo(String orientation, GameEngine engine){
        try {
            engine.travel(translate(orientation));
            var description = engine.roomDescription();
            var doorTitles = engine.doorNames();
            var items = engine.roomItems();
            _printRoomDetails.print(description,items, doorTitles);
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
