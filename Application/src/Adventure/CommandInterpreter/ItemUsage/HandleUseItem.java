package Adventure.CommandInterpreter.ItemUsage;

import GameEngine.GameEngine;
import GameEngine.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.Utils.ItemNotFoundException;
import GameEngine.Utils.ObjectNotFoundException;
import java.util.regex.Pattern;

public class HandleUseItem {
    PrintUsageMessages _printer = new PrintUsageMessages();

    private void multiArguments(String command, GameEngine engine){
        var args = command.substring(4);
        var pattern = Pattern.compile("(^\\w+)|(\\w+ \\w*$)");
        var matcher = pattern.matcher(args);
        matcher.find();
        var item = matcher.group(0);
        matcher.find();
        var target = matcher.group(0);
        try {
            engine.useItem(item,target);
        } catch (InvalidObjectException e) {
            _printer.printInvalidObject();
        } catch (ItemNotFoundException e) {
            _printer.printItemNotInInventory(item);
        } catch (ObjectNotFoundException e) {
            _printer.printObjectNotFound();
        }
    }

    private void singleArgument(String command, GameEngine engine){
        var item = command.substring(4);
        try {
            engine.useItem(item);
        } catch (InvalidObjectException e) {
            _printer.printInvalidObject();
        } catch (ItemNotFoundException e) {
            _printer.printItemNotInInventory(item);
        }
    }

    public void handleUse(String command, GameEngine engine){

        if(command.matches("use [A-z]* at \\w+\\s*\\w*$"))
            multiArguments(command,engine);
        else if(command.matches("use [A-z]*$"))
            singleArgument(command,engine);
        else
            _printer.printBadCommand();
    }
}
