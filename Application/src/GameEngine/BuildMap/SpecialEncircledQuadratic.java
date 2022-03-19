package GameEngine.BuildMap;

import java.util.ArrayList;

public class SpecialEncircledQuadratic {
    final ArrayList<Room> _normals;
    final Room _special;
    private int _index;
    private boolean isValid(int count){
        if(count + 1 < 9)
            return false;
        else if((count + 1) % 2 == 0)
            return false;
        var root = Math.sqrt(count + 1);
        int flooredRoot = (int) root;
        double diff = root - flooredRoot;
        return diff == 0;
    }

    private int bound(){
        return _normals.size() + 1;
    }

    private int median(){
        int root = (int) Math.sqrt(_normals.size() + 1);
        return root / 2 + 1;
    }

    private void buildSquare(int x, int y){
        if(x == median() && y == median())
            return;
        if(x >= bound() || y >= bound())
            return;
        if(_index >= _normals.size())
            return;
        var room = _normals.get(_index);
        if(room.getEast() != null && _index + 1 < _normals.size())
        {
            var eastOf = _normals.get(++_index);
            room.setEast(eastOf);
        }
        if(room.getSouth() != null && _index + 1 < _normals.size())
        {
            var eastOf = _normals.get(++_index);
            room.setEast(eastOf);
        }


    }

    public SpecialEncircledQuadratic(ArrayList<Room> normals, ArrayList<Room> specials) throws IllegalArgumentException {
        if(!isValid(normals.size()) || specials.size() != 1)
            throw new IllegalArgumentException();
        _normals = normals;
        _special = specials.get(0);
    }
    public Room connect(){

    }
}
