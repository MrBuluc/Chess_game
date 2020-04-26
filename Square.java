
public class Square {
    private String column;
    private int row;
    private ChessBoard board;

    public Square(String column, int row) {
        this.column = column;
        this.row = row;
    }

    //public boolean isAtLastRow(int color){}

    public boolean isEmpty() {
        return this == null;
    }

    public boolean isAtSameColumn(Square s) {
        if (this.column.equals(s.column)) {
            return true;
        }
        return false;
    }


    @Override
    public String toString() {

        if(row == 8){
            if(column.equals("A")){
                Rook rookA8 = new Rook(1, "A", 8);
                return rookA8.toString();
            }
            else if(column.equals("B")){
                Knight knightB8 = new Knight(1, "B", 8);
                return knightB8.toString();
            }
            else if(column.equals("C")){
                Bishop bishopC8 = new Bishop(1, "C", 8);
                return bishopC8.toString();
            }
            else if(column.equals("D")){
                Queen queenD8 = new Queen(1, "D", 8);
                return queenD8.toString();
            }
            else if(column.equals("E")){
                King kingE8 = new King(1, "E", 8);
                return kingE8.toString();
            }
            else if(column.equals("F")){
                Bishop bishopF8 = new Bishop(1, "F", 8);
                return bishopF8.toString();
            }
            else if(column.equals("G")){
                Knight knightG8 = new Knight(1, "G", 8);
                return knightG8.toString();
            }
            else if(column.equals("H")){
                Rook rookH8 = new Rook(1, "H", 8);
                return rookH8.toString();
            }
            else{
                return "";
            }
        }
        else if(row == 7){
            
            Pawn pawnA7 = new Pawn(1, "A", 7);
            Pawn pawnB7 = new Pawn(1, "B", 7);
            Pawn pawnC7 = new Pawn(1, "C", 7);
            Pawn pawnD7 = new Pawn(1, "D", 7);
            Pawn pawnE7 = new Pawn(1, "E", 7);
            Pawn pawnF7 = new Pawn(1, "F", 7);
            Pawn pawnG7 = new Pawn(1, "G", 7);
            Pawn pawnH7 = new Pawn(1, "H", 7);

            return "p";
        }
        else if(row < 7 && row > 2){
            return " ";
        }
        else if(row == 2){
            Pawn pawnA2 = new Pawn(0, "A", 2);
            Pawn pawnB2 = new Pawn(0, "B", 2);
            Pawn pawnC2 = new Pawn(0, "C", 2);
            Pawn pawnD2 = new Pawn(0, "D", 2);
            Pawn pawnE2 = new Pawn(0, "E", 2);
            Pawn pawnF2 = new Pawn(0, "F", 2);
            Pawn pawnG2 = new Pawn(0, "G", 2);
            Pawn pawnH2 = new Pawn(0, "H", 2);

            return "P";
        }
        else if(row == 1){
            if(column.equals("A")){
                Rook rookA1 = new Rook(0, "A", 1);
                return rookA1.toString();
            }
            else if(column.equals("B")){
                Knight knightB1 = new Knight(0, "B", 1);
                return knightB1.toString();
            }
            else if(column.equals("C")){
                Bishop bishopC1 = new Bishop(0, "C", 1);
                return bishopC1.toString();
            }
            else if(column.equals("D")){
                Queen queenD1 = new Queen(0, "D", 1);
                return queenD1.toString();
            }
            else if(column.equals("E")){
                King kingE1 = new King(0, "E", 1);
                return kingE1.toString();
            }
            else if(column.equals("F")){
                Bishop bishopF1 = new Bishop(0, "F", 1);
                return bishopF1.toString();
            }
            else if(column.equals("G")){
                Knight knightG1 = new Knight(0, "G", 1);
                return knightG1.toString();
            }
            else if(column.equals("H")){
                Rook rookH1 = new Rook(0, "H", 1);
                return rookH1.toString();
            }
            else{
                return "";
            }
        }
        else{
            return "";
        }
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
    
    
}