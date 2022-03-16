package Adventure.StringBuilders.BadCommand;

import ConsolePrintFormatter.FilledTextBox.BuildFilledBox;
import java.awt.*;

public class BuildBadCmdMessage {
    private String assembleMessage(){
        var msg = "!!!!Bad command. Please try again.!!!!";
        return msg;
    }

    private String formatMessage(String msg){
        var csiBuilder = new BuildFilledBox(msg);
        csiBuilder.setBackroundColor(new Color(255, 0, 0));
        csiBuilder.setMargins(0,1);
        return csiBuilder.build().toString();
    }

    public String build(){
        var msg = assembleMessage();
        var formattedMsg = formatMessage(msg);
        return formattedMsg;
    }
}
