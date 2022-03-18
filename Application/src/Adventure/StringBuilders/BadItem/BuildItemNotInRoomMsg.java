package Adventure.StringBuilders.BadItem;

import ConsolePrintFormatter.FilledTextBox.BuildFilledBox;
import java.awt.*;

public class BuildItemNotInRoomMsg {

    private String assembleMsg(String itemTitle){
        String msg = String.format("There is nothing like %s to take around here",itemTitle);
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
