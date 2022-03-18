package Adventure.Printer;

import ConsolePrintFormatter.FilledTextBox.BuildFilledBox;
import java.awt.*;

public class FormatMessages {

    public String formatPressButton(String msg){
        var csiBuilder = new BuildFilledBox(msg);
        csiBuilder.setBackroundColor(new Color(119, 110, 110));
        csiBuilder.setTextColor(new Color(0, 0, 0));
        csiBuilder.setMargins(0,1);
        return csiBuilder.build().toString();
    }

    public String formatBadDirection(String msg){
        var csiBuilder = new BuildFilledBox(msg);
        csiBuilder.setBackroundColor(new Color(255, 0, 0));
        csiBuilder.setMargins(0,1);
        return csiBuilder.build().toString();
    }

    public String formatBadCommand(String msg){
        var csiBuilder = new BuildFilledBox(msg);
        csiBuilder.setBackroundColor(new Color(255, 0, 0));
        csiBuilder.setMargins(0,1);
        return csiBuilder.build().toString();
    }

    public String formatCommandLine(String msg){
        var builder = new BuildFilledBox( msg);
        builder.setBackroundColor(new Color(35, 138, 79));
        builder.setMargins(0,0);
        return builder.build().toString();
    }

    public String formatIntro(String msg){
        var csiBuilder = new BuildFilledBox(msg);
        csiBuilder.setBackroundColor(new Color(106, 17, 17));
        csiBuilder.setTextColor(new Color(255, 255, 255));
        csiBuilder.setMargins(0,2);
        csiBuilder.setPadding(2,1);
        return csiBuilder.build().toString();
    }

    public String formatHelp(String msg){
        var builder = new BuildFilledBox(msg);
        builder.setBackroundColor(new Color(255, 4, 4));
        builder.setTextColor(new Color(255,255,255));
        builder.setPadding(4,2);
        builder.setMargins(0,1);
        return builder.build().toString();
    }

    public String formatBadInventoryPick(String msg){
        var csiBuilder = new BuildFilledBox(msg);
        csiBuilder.setBackroundColor(new Color(255, 0, 0));
        csiBuilder.setMargins(0,1);
        return csiBuilder.build().toString();
    }

    public String formatBadRoomPick(String msg){
        var csiBuilder = new BuildFilledBox(msg);
        csiBuilder.setBackroundColor(new Color(255, 0, 0));
        csiBuilder.setMargins(0,1);
        return csiBuilder.build().toString();
    }

    public String formatRoomInfo(String description){
        var builder = new BuildFilledBox(description);
        builder.setBackroundColor(new Color(92, 37, 1));
        builder.setTextColor(new Color(255, 255, 255));
        builder.setPadding(4,2);
        builder.setMargins(0,1);
        return builder.build().toString();
    }

}
