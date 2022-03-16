package Adventure.StringBuilders.Descriptions;

import ConsolePrintFormatter.FilledTextBox.BuildFilledBox;

import java.awt.*;

public class BuildDescriptMessage {
    public String build(String str){
        var builder = new BuildFilledBox(str);
        builder.setBackroundColor(new Color(92, 37, 1));
        builder.setTextColor(new Color(255, 255, 255));
        builder.setPadding(4,2);
        builder.setMargins(0,1);
        return builder.build().toString();
    }
}
