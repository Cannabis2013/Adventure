package ConsolePrintFormatter.FramedTextBox;

import ConsolePrintFormatter.ConsoleObjects.ConsoleObject;
import ConsolePrintFormatter.FramedTextBox.AddFrame.AddFrame;
import ConsolePrintFormatter.Utils.LineTools.LineMerger;
import ConsolePrintFormatter.Utils.LineTools.StringSplitter;
import ConsolePrintFormatter.Utils.Normalize.NormalizeStringLines;
import ConsolePrintFormatter.Utils.Padding.CreatePadding;

public class BuildFramedTextBox {
    private final String _str;
    private int _verticalPadding = 0;
    private int _horizontalPadding = 0;
    private int _verticalMargin = 0;
    private int _horizontalMargin = 0;

    StringSplitter _splitString = new StringSplitter();
    NormalizeStringLines _normalize = new NormalizeStringLines();
    CreatePadding _surroundWithSpaces = new CreatePadding();
    AddFrame _addFrame = new AddFrame();
    LineMerger _mergeLines = new LineMerger();

    public BuildFramedTextBox(String str) {
        _str = str;
    }

    public void setPadding(int horizontal, int vertical){
        _verticalPadding = vertical;
        _horizontalPadding = horizontal;
    }

    public void setMargins(int horizontal, int vertical){
        _horizontalMargin = horizontal;
        _verticalMargin = vertical;
    }

    public ConsoleObject build(){
        var lines = _splitString.split(_str);
        var normalizedLines = _normalize.normalize(lines);
        _surroundWithSpaces.create(normalizedLines, _verticalPadding, _horizontalPadding);
        var merged = _mergeLines.merge(normalizedLines);
        var result = _addFrame.add(merged);
        return new ConsoleObject(result);
    }
}
