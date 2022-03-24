package Adventure.CommandInterpreter.EquipWeapon;

import Adventure.ScreenMessages.FormatMessages;

public class PrintEquipMessages {
    private FormatMessages _formatter = new FormatMessages();

    public void printBadCommand(){
        var msg = "!!!! Bad command. Please try again. !!!!";
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printWeaponEquipFailed(){
        var msg = "Can't equip. Not weapon.";
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }

    public void printItemNotInInventory(String itemTitle){
        var msg = String.format("You don't have anything like %s in your inventory",itemTitle);
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }
}
