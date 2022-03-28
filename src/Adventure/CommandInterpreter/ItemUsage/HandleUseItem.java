package Adventure.CommandInterpreter.ItemUsage;

import GameEngine.GameEngine;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;
import GameEngine.Player.Exceptions.ItemNotUsableException;
import GameEngine.Player.Exceptions.TargetNotFoundException;
import GameEngine.Player.Exceptions.UsableNotFoundException;
import GameEngine.Utils.ItemNotFoundException;

import java.util.regex.Pattern;

public class HandleUseItem {
    PrintUsageMessages _printer = new PrintUsageMessages();

    private void multiArguments(String command, GameEngine engine){
        var args = command.substring(4);
        var pattern = Pattern.compile("(^[A-z 0-9^]+(?= at))|(\\w+ \\w*$)");
        var matcher = pattern.matcher(args);
        matcher.find();
        var item = matcher.group(0);
        matcher.find();
        var target = matcher.group(0);
        try {
            var result = engine.useItem(item,target);
            _printer.printResult(result);
        } catch (InvalidObjectException e) {
            _printer.printInvalidObject();
        } catch (UsableNotFoundException e) {
            _printer.printUsableNotFound(item);
        } catch (TargetNotFoundException e) {
            _printer.printTargetNotFound();
        }
    }

    private void singleArgument(String command, GameEngine engine){
        var item = command.substring(4);
        try {
            var result = engine.useItem(item);
            _printer.printResult(result);
        } catch (InvalidObjectException e) {
            _printer.printInvalidObject();
        }  catch (ItemNotUsableException e) {
            _printer.printNotUsable(item);
        } catch (ItemNotFoundException e) {
            _printer.printUsableNotFound(item);
        }
    }

    public void handleUse(String command, GameEngine engine){

        if(command.matches("^use [A-z 0-9]+ at \\w+\\s*\\w+$"))
            multiArguments(command,engine);
        else
            singleArgument(command,engine);
    }
}
