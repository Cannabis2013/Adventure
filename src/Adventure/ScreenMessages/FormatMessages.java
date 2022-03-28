package Adventure.ScreenMessages;

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

    public String formatNegativeResponse(String msg){
        var csiBuilder = new BuildFilledBox(msg);
        csiBuilder.setBackroundColor(new Color(255, 0, 0));
        csiBuilder.setMargins(0,1);
        return csiBuilder.build().toString();
    }

    public String formatWhiteOnLightGreen(String msg){
        var builder = new BuildFilledBox( msg);
        builder.setBackroundColor(new Color(35, 138, 79));
        builder.setMargins(0,0);
        return builder.build().toString();
    }

    public String formatWhiteOnDarkRedLoose(String msg){
        var csiBuilder = new BuildFilledBox(msg);
        csiBuilder.setBackroundColor(new Color(106, 17, 17));
        csiBuilder.setTextColor(new Color(255, 255, 255));
        csiBuilder.setMargins(0,2);
        csiBuilder.setPadding(2,1);
        return csiBuilder.build().toString();
    }

    public String formatWhiteOnDarkRedTight(String msg){
        var csiBuilder = new BuildFilledBox(msg);
        csiBuilder.setBackroundColor(new Color(106, 17, 17));
        csiBuilder.setTextColor(new Color(255, 255, 255));
        csiBuilder.setMargins(0,2);
        return csiBuilder.build().toString();
    }

    public String formatWhiteOnRedLoose(String msg){
        var builder = new BuildFilledBox(msg);
        builder.setBackroundColor(new Color(255, 4, 4));
        builder.setTextColor(new Color(255,255,255));
        builder.setPadding(4,2);
        builder.setMargins(0,1);
        return builder.build().toString();
    }

    public String formatWhiteOnRedTight(String msg){
        var builder = new BuildFilledBox(msg);
        builder.setBackroundColor(new Color(255, 4, 4));
        builder.setTextColor(new Color(255,255,255));
        builder.setMargins(0,1);
        return builder.build().toString();
    }

    public String formatWhiteOnBrownLoose(String description){
        var builder = new BuildFilledBox(description);
        builder.setBackroundColor(new Color(92, 37, 1));
        builder.setTextColor(new Color(255, 255, 255));
        builder.setPadding(4,2);
        builder.setMargins(0,1);
        return builder.build().toString();
    }

    public String formatWhiteOnBrownTight(String description){
        var builder = new BuildFilledBox(description);
        builder.setBackroundColor(new Color(92, 37, 1));
        builder.setTextColor(new Color(255, 255, 255));
        builder.setMargins(0,1);
        return builder.build().toString();
    }

    public String formatWhiteOnGreenLoose(String items){
        var builder = new BuildFilledBox(items);
        builder.setBackroundColor(new Color(30, 54, 8));
        builder.setPadding(4,2);
        builder.setMargins(0,1);
        return builder.build().toString();
    }

    public String formatWhiteOnGreenTight(String items){
        var builder = new BuildFilledBox(items);
        builder.setBackroundColor(new Color(30, 54, 8));
        builder.setMargins(0,1);
        return builder.build().toString();
    }
}
