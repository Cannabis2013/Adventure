package Adventure.StringBuilders.Intro;

import ConsolePrintFormatter.FilledTextBox.BuildFilledBox;

import java.awt.*;

public class BuildIntroMessage {

    private String assembleMessage(){
        var msg = """
                Welcome to Doom V - A new adventure through hell
                
                In this brand new evolution of Doom, our hero again stands between peace and harmony 
                and total destruction and submission.
                
                The Cyberdemon and the Spider Mastermind has yet again, crawled up from the deep hell 
                to bring havoc on Earth. Only you, a skilled marine from the 5. Bullshit Brigade, has
                what it takes to blast these beasts back to hell, where they belong.
                
                Developers:
                    Programming: Martin Hansen, Stefan "I do not know his middlename" "and his surname"
                    Console formatting: Martin Hansen
                    Ideas: Martin, Stefan
                    
                Copyright: Nope, but we sure damn gets pissed if someone dares to steal our product.
                """;
        return msg;
    }

    private String formatMessage(String msg){
        var csiBuilder = new BuildFilledBox(msg);
        csiBuilder.setBackroundColor(new Color(106, 17, 17));
        csiBuilder.setTextColor(new Color(255, 255, 255));
        csiBuilder.setMargins(0,2);
        csiBuilder.setPadding(2,1);
        return csiBuilder.build().toString();
    }

    public String build(){
        var msg = assembleMessage();
        var formattedMsg = formatMessage(msg);
        return formattedMsg;
    }
}
