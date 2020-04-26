
public class Square {
    private String column;
    private int row;
    private ChessBoard board;
    private boolean piece;

    public Square(String column, int row, boolean piece) {
        this.column = column;
        this.row = row;
        this.piece = piece;
    }

    //public boolean isAtLastRow(int color){}

    public boolean isEmpty() {
        return this == null;
    }

    public boolean isAtSameColumn(Square s) {
        if (this.column.equals(s.getColumn())) {
            return true;
        }
        return false;
    }

    public int getRowDistance(Square location){
        return this.row - location.getRow();
    }

    public ChessBoard getBoard() {
        return board;
    }

    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean isPiece() {
        return piece;
    }

    public void setPiece(boolean piece) {
        this.piece = piece;
    }

}