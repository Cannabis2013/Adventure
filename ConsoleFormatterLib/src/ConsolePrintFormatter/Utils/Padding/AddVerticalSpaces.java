package ConsolePrintFormatter.Utils.Padding;

import java.util.List;

public class AddVerticalSpaces {
    private String createEmptyLine(int length){
        var sb = new StringBuilder();
        for (var i = 0;i < length;i++)
            sb.append(" ");
        return sb.toString();
    }

    void addTopPadding(List<String> lines, int pad){
        for (var i = 0;i < pad;i++){
            var length = lines.get(0).length();
            var emptyLine = createEmptyLine(length);
            lines.add(0,emptyLine);
        }
    }

    void addBottomPadding(List<String> lines, int pad){
        for (var i = 0;i < pad;i++){
            var length = lines.get(0).length();
            var emptyLine = createEmptyLine(length);
            lines.add(emptyLine);
        }
    }
}
