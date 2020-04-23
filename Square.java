
public class Square {
    private int column;
    private int row;

    public Square(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public boolean isAtLastRow(int color){
        if(color == 0 && )
    }

    public boolean isEmpty(){
        if(this == null){
            return true;
        }
        return false;
    }

    public boolean isAtSameColumn(Square s){
        if(this.column == s.column){
            return true;
        }
        return false;
    }
    
}