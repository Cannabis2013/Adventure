package Adventure.StringBuilders.CommandLine;

import ConsolePrintFormatter.FilledTextBox.BuildFilledBox;

import java.awt.*;

public class BuildCommandMessage {
    public String build(){
        var builder = new BuildFilledBox("Command->");
        builder.setBackroundColor(new Color(35, 138, 79));
        builder.setMargins(0,0);
        return builder.build().toString();
    }
}
