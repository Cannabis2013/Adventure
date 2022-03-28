package Adventure.ScreenMessages;

import java.util.List;

public class PrintRoomDetails {
    FormatMessages _formatter = new FormatMessages();

    private String addEquipped(String msg, String weapon){
        if(weapon.isBlank())
            msg += "No weapons equipped" + "\n";
        else
            msg += "Equipped weapon:" + "\n";
        msg += weapon + "\n\n";
        return msg;
    }

    private String addEnemies(String msg, List<String> enemies){
        if (enemies.isEmpty())
            msg += "No enemies are present in this room...";
        else
            msg += "Enemies in this room:";
        msg += "\n";
        msg += enemies.stream().reduce("", (str, title) -> str + title + "\n");
        msg += "\n";
        return msg;
    }

    private String addItems(String msg, List<String> items){
        if(items.isEmpty())
            msg += "There seems to be no items of value in this room";
        else
            msg += "Items in this room:";
        msg += "\n";
        msg += items.stream().reduce("",(str,title) -> str + title + "\n");
        msg += "\n";
        return msg;
    }

    public void print(String description, List<String> enemies,
                      List<String> itemTitles, String doorTitles,
                      String equipped){
        var msg = description + "\n\n";
        msg = addEquipped(msg,equipped);
        msg = addEnemies(msg,enemies);
        msg = addItems(msg, itemTitles);
        msg += "Access details:";
        msg += "\n";
        msg += doorTitles;
        var formatted = _formatter.formatWhiteOnBrownLoose(msg);
        System.out.println(formatted);
    }
}
