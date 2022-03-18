package Adventure.StringBuilders.BadDirection;

import ConsolePrintFormatter.FilledTextBox.BuildFilledBox;

import java.awt.*;

public class BuildBadDirectionMessage {
    private String assembleMsg(){
        var msg = "you can not go that way";
        return msg;
    }

    private String formatMsg(String msg){
        var csiBuilder = new BuildFilledBox(msg);
        csiBuilder.setBackroundColor(new Color(255, 0, 0));
        csiBuilder.setMargins(0,1);
        return csiBuilder.build().toString();
    }

    public String build(){
        var msg = assembleMsg();
        var formMsg = formatMsg(msg);
        return formMsg;
    }
}
