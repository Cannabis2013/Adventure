package ConsolePrintFormatter.Utils.Padding;

import java.util.List;

public class AddHorizontalSpaces {

    void replaceLine(List<String> list, int index, String str){
        list.remove(index);
        list.add(index,str);
    }

    String prependSpace(String str, int count){
        var sb = new StringBuilder();
        for (var i = 0;i < count;i++)
            sb.append(" ");
        sb.append(str);
        return sb.toString();
    }

    String appendSpace(String str, int count){
        var sb = new StringBuilder(str);
        for (var i = 0;i < count;i++)
            sb.append(" ");
        return sb.toString();
    }

    void addLeftPadding(List<String> lines, int pad){
        for (var i = 0;i < lines.size();i++){
            var line = lines.get(i);
            var newLine = prependSpace(line,pad);
            replaceLine(lines,i,newLine);
        }
    }

    void addRightPadding(List<String> lines, int pad){
        for (var i = 0;i < lines.size();i++){
            var line = lines.get(i);
            var newLine = appendSpace(line,pad);
            replaceLine(lines,i,newLine);
        }
    }
}
