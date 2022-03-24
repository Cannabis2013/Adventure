package Adventure.CommandInterpreter.EquipWeapon;

import GameEngine.GameEngine;
import GameEngine.Player.EquipWeaponFailedException;
import GameEngine.Utils.ItemNotFoundException;

public class HandleEquipWeapon {
    PrintEquipMessages _printer = new PrintEquipMessages();

    private void handle(String command, GameEngine engine){
        var itemName = command.substring(6);
        try {
            engine.equipWeapon(itemName);
            _printer.printItemEquipped(itemName);
        } catch (EquipWeaponFailedException e) {
            _printer.printWeaponEquipFailed();
        } catch (ItemNotFoundException e) {
            _printer.printItemNotInInventory(itemName);
        }
    }

    public void handleEquip(String command, GameEngine engine){
        if(!command.matches("equip \\w+\\s*\\w*$"))
            _printer.printBadCommand();
        else
            handle(command,engine);
    }
}
