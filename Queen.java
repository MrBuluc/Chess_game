
public class Queen extends Piece {
    private int color, row;
    private String column, rank;
    private Square location;
    
    public Queen(int color, Square location, String rank) {
        super(color, location, rank);
        this.color = color;
        this.location = location;
        this.rank = rank;
    }
    
    @Override
    public void move(String destination, ChessBoard board) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean canMove(String destination, ChessBoard board) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String toString() {
        if(super.getColor() == 0){
            return "Q";
        }
        else{
            return "q";
        }
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square location) {
        this.location = location;
    }

    

}