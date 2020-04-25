
public class Square {
    private String column;
    private int row;

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
                Square A8 = new Square("A", 8);
                Rook rookA8 = new Rook(1, A8);
                return rookA8.toString();
            }
            else if(column.equals("B")){
                Square B8 = new Square("B", 8);
                Knight knightB8 = new Knight(1, B8);
                return knightB8.toString();
            }
            else if(column.equals("C")){
                Square C8 = new Square("C", 8);
                Bishop bishopC8 = new Bishop(1, C8);
                return bishopC8.toString();
            }
            else if(column.equals("D")){
                Square D8 = new Square("D", 8);
                Queen queenD8 = new Queen(1, D8);
                return queenD8.toString();
            }
            else if(column.equals("E")){
                Square E8 = new Square("E", 8);
                King kingE8 = new King(1, E8);
                return kingE8.toString();
            }
            else if(column.equals("F")){
                Square F8 = new Square("F", 8);
                Bishop bishopF8 = new Bishop(1, F8);
                return bishopF8.toString();
            }
            else if(column.equals("G")){
                Square G8 = new Square("G", 8);
                Knight knightG8 = new Knight(1, G8);
                return knightG8.toString();
            }
            else if(column.equals("H")){
                Square H8 = new Square("H", 8);
                Rook rookH8 = new Rook(1, H8);
                return rookH8.toString();
            }
            else{
                return "";
            }
        }
        else if(row == 7){
            Square A7 = new Square("A", 7);
            Square B7 = new Square("B", 7);
            Square C7 = new Square("C", 7);
            Square D7 = new Square("D", 7);
            Square E7 = new Square("E", 7);
            Square F7 = new Square("F", 7);
            Square G7 = new Square("G", 7);
            Square H7 = new Square("H", 7);

            Pawn pawnA7 = new Pawn(1, A7);
            Pawn pawnB7 = new Pawn(1, B7);
            Pawn pawnC7 = new Pawn(1, C7);
            Pawn pawnD7 = new Pawn(1, D7);
            Pawn pawnE7 = new Pawn(1, E7);
            Pawn pawnF7 = new Pawn(1, F7);
            Pawn pawnG7 = new Pawn(1, G7);
            Pawn pawnH7 = new Pawn(1, H7);

            return "p";
        }
        else if(row < 7 && row > 2){
            return " ";
        }
        else if(row == 2){
            Square A2 = new Square("A", 2);
            Square B2 = new Square("B", 2);
            Square C2 = new Square("C", 2);
            Square D2 = new Square("D", 2);
            Square E2 = new Square("E", 2);
            Square F2 = new Square("F", 2);
            Square G2 = new Square("G", 2);
            Square H2 = new Square("H", 2);

            Pawn pawnA2 = new Pawn(0, A2);
            Pawn pawnB2 = new Pawn(0, B2);
            Pawn pawnC2 = new Pawn(0, C2);
            Pawn pawnD2 = new Pawn(0, D2);
            Pawn pawnE2 = new Pawn(0, E2);
            Pawn pawnF2 = new Pawn(0, F2);
            Pawn pawnG2 = new Pawn(0, G2);
            Pawn pawnH2 = new Pawn(0, H2);

            return "P";
        }
        else if(row == 1){
            if(column.equals("A")){
                Square A1 = new Square("A", 1);
                Rook rookA1 = new Rook(0, A1);
                return rookA1.toString();
            }
            else if(column.equals("B")){
                Square B1 = new Square("B", 1);
                Knight knightB1 = new Knight(0, B1);
                return knightB1.toString();
            }
            else if(column.equals("C")){
                Square C1 = new Square("C", 1);
                Bishop bishopC1 = new Bishop(0, C1);
                return bishopC1.toString();
            }
            else if(column.equals("D")){
                Square D1 = new Square("D", 1);
                Queen queenD1 = new Queen(0, D1);
                return queenD1.toString();
            }
            else if(column.equals("E")){
                Square E1 = new Square("E", 1);
                King kingE1 = new King(0, E1);
                return kingE1.toString();
            }
            else if(column.equals("F")){
                Square F1 = new Square("F", 1);
                Bishop bishopF1 = new Bishop(0, F1);
                return bishopF1.toString();
            }
            else if(column.equals("G")){
                Square G1 = new Square("G", 1);
                Knight knightG1 = new Knight(0, G1);
                return knightG1.toString();
            }
            else if(column.equals("H")){
                Square H1 = new Square("H", 1);
                Rook rookH1 = new Rook(0, H1);
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

    
    
}