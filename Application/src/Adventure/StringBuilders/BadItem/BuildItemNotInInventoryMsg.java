package Adventure.StringBuilders.BadItem;

import ConsolePrintFormatter.FilledTextBox.BuildFilledBox;

import java.awt.*;

public class BuildItemNotInInventoryMsg {
    private String assembleMsg(String itemTitle){
        String msg = String.format("You don't have anything like %s in your inventory",itemTitle);
        return msg;
    }

    private String formatMsg(String msg){
        var csiBuilder = new BuildFilledBox(msg);
        csiBuilder.setBackroundColor(new Color(255, 0, 0));
        csiBuilder.setMargins(0,1);
        return csiBuilder.build().toString();
    }

    public String build(String itemTitle){
        String msg = assembleMsg(itemTitle);
        String formatted = formatMsg(msg);
        return formatted;
    }
}
