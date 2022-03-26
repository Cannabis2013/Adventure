package ConsolePrintFormatter.Utils.Padding;

import java.util.List;

public class CreatePadding {

    AddVerticalSpaces _addVerticalSpaces = new AddVerticalSpaces();
    AddHorizontalSpaces _addHorizontalSpaces = new AddHorizontalSpaces();

    void addVerticalPadding(List<String> lines, int pad){
        _addVerticalSpaces.addTopPadding(lines,pad);
        _addVerticalSpaces.addBottomPadding(lines,pad);
    }

    void addHorizontalPadding(List<String> lines, int pad){
        _addHorizontalSpaces.addLeftPadding(lines,pad);
        _addHorizontalSpaces.addRightPadding(lines,pad);
    }

    public List<String> create(List<String> lines, int vPad, int hPad){
        addVerticalPadding(lines,vPad);
        addHorizontalPadding(lines,hPad);
        return lines;
    }
}
