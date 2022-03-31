package Adventure.CommandInterpreter.ItemInteraction;

import GameEngine.GameEngine;
import GameEngine.Player.Exceptions.ItemNotConsumableException;
import GameEngine.Player.Exceptions.PlayerHealthFullException;
import GameEngine.Utils.ItemNotFoundException;

public class HandleInteraction {
    private PrintInteractionMessages _printer = new PrintInteractionMessages();

    private void takeOneItem(String itemTitle, GameEngine engine){
        try {
            engine.takeItem(itemTitle);
            _printer.printItemTaken(itemTitle);
        } catch (ItemNotFoundException e) {
            _printer.printItemNotInRoom(itemTitle);
        }
    }

    public void handleTake(String command, GameEngine engine){
        if(!command.matches("take [A-z 0-9]*\\b$")){
            _printer.printBadCommand();
            return;
        }
        String itemTitle = command.substring(5);
        if(itemTitle.equals("all"))
            engine.takeAll();
        else
            takeOneItem(itemTitle,engine);

    }

    public void handleDrop(String command,  GameEngine gameEngine){
        String args = command.substring(5);
        try {
            var itemTitle = gameEngine.dropItem(args);
            _printer.printItemDropped(itemTitle);
        } catch (ItemNotFoundException e) {
            _printer.printItemNotInInventory(args);
        }
    }

    public void handleEat(String command, GameEngine gameEngine) {
        String arg = command.substring(4);
        try {
            String itemTitle = gameEngine.eatItem(arg);
            _printer.printItemEaten(itemTitle);
        }  catch (ItemNotConsumableException e) {
            _printer.printItemNotConsumable(arg);
        } catch (ItemNotFoundException e) {
            _printer.printItemNotInInventory(arg);
        } catch (PlayerHealthFullException e) {
            _printer.printPlayerNotHungry();
        }
    }
}
