public class ChessBoard {
    final static String[] harf = { "A", "B", "C", "D", "E", "F", "G", "H" };
    private boolean flag = true;
    private Square[][] squares = new Square[8][8];

    public ChessBoard() {
        squares[0][0] = new Square("A", 8, new Piece(1, "ROOK", "A8"));
        squares[1][0] = new Square("B", 8, null);
        squares[2][0] = new Square("C", 8, null);
        squares[3][0] = new Square("D", 8, null);
        squares[4][0] = new Square("E", 8, null);
        squares[5][0] = new Square("F", 8, null);
        squares[6][0] = new Square("G", 8, null);
        squares[7][0] = new Square("H", 8, new Piece(1, "ROOK", "H8"));

        squares[0][1] = new Square("A", 7, new Piece(1, "PAWN", "A7"));
        squares[1][1] = new Square("B", 7, new Piece(1, "PAWN", "B7"));
        squares[2][1] = new Square("C", 7, new Piece(1, "PAWN", "C7"));
        squares[3][1] = new Square("D", 7, new Piece(1, "PAWN", "D7"));
        squares[4][1] = new Square("E", 7, new Piece(1, "PAWN", "E7"));
        squares[5][1] = new Square("F", 7, new Piece(1, "PAWN", "F7"));
        squares[6][1] = new Square("G", 7, new Piece(1, "PAWN", "G7"));
        squares[7][1] = new Square("H", 7, new Piece(1, "PAWN", "H7"));

        squares[0][2] = new Square("A", 6, null);
        squares[1][2] = new Square("B", 6, null);
        squares[2][2] = new Square("C", 6, null);
        squares[3][2] = new Square("D", 6, null);
        squares[4][2] = new Square("E", 6, null);
        squares[5][2] = new Square("F", 6, null);
        squares[6][2] = new Square("G", 6, null);
        squares[7][2] = new Square("H", 6, null);

        squares[0][3] = new Square("A", 5, null);
        squares[1][3] = new Square("B", 5, null);
        squares[2][3] = new Square("C", 5, null);
        squares[3][3] = new Square("D", 5, null);
        squares[4][3] = new Square("E", 5, null);
        squares[5][3] = new Square("F", 5, null);
        squares[6][3] = new Square("G", 5, null);
        squares[7][3] = new Square("H", 5, null);

        squares[0][4] = new Square("A", 4, null);
        squares[1][4] = new Square("B", 4, null);
        squares[2][4] = new Square("C", 4, null);
        squares[3][4] = new Square("D", 4, null);
        squares[4][4] = new Square("E", 4, null);
        squares[5][4] = new Square("F", 4, null);
        squares[6][4] = new Square("G", 4, null);
        squares[7][4] = new Square("H", 4, null);

        squares[0][5] = new Square("A", 3, null);
        squares[1][5] = new Square("B", 3, null);
        squares[2][5] = new Square("C", 3, null);
        squares[3][5] = new Square("D", 3, null);
        squares[4][5] = new Square("E", 3, null);
        squares[5][5] = new Square("F", 3, null);
        squares[6][5] = new Square("G", 3, null);
        squares[7][5] = new Square("H", 3, null);

        squares[0][6] = new Square("A", 2, new Piece(0, "PAWN", "A2"));
        squares[1][6] = new Square("B", 2, new Piece(0, "PAWN", "B2"));
        squares[2][6] = new Square("C", 2, new Piece(0, "PAWN", "C2"));
        squares[3][6] = new Square("D", 2, new Piece(0, "PAWN", "D2"));
        squares[4][6] = new Square("E", 2, new Piece(0, "PAWN", "E2"));
        squares[5][6] = new Square("F", 2, new Piece(0, "PAWN", "F2"));
        squares[6][6] = new Square("G", 2, new Piece(0, "PAWN", "G2"));
        squares[7][6] = new Square("H", 2, new Piece(0, "PAWN", "H2"));

        squares[0][7] = new Square("A", 1, new Piece(0, "ROOK", "A1"));
        squares[1][7] = new Square("B", 1, null);
        squares[2][7] = new Square("C", 1, null);
        squares[3][7] = new Square("D", 1, null);
        squares[4][7] = new Square("E", 1, null);
        squares[5][7] = new Square("F", 1, null);
        squares[6][7] = new Square("G", 1, null);
        squares[7][7] = new Square("H", 1, new Piece(0, "ROOK", "H1"));
    }

    public boolean isWhitePlaying() {
        return flag;
    }

    
    public boolean isGameEnded() {
        int whites = 0;
        int blacks = 0;
        for(int i = 0; i< 8; i++){
            for(int j = 0; j<8; j++){
                Square square = squares[i][j];
                if(square.getPiece() != null){
                    int color = square.getPiece().getColor();
                    if(color == 0){
                        whites++;
                    }
                    else{
                        blacks++;
                    }
                }
            }
        }
        return whites == 0 || blacks == 0;
    }
    
    public void nextPlayer(){
        flag = flag ? false : true;
    }
     

    public Piece getPieceAt(String from) {
        String fromUpper = from.toUpperCase();
        fromUpper += " ";
        String col = fromUpper.substring(0, 1);
        int row = Integer.parseInt(fromUpper.substring(1, 2));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = squares[i][j];
                if (square.getColumn().equals(col) && square.getRow() == row) {
                    return square.getPiece();
                }
            }
        }
        return null;
    }

    
    public Square getSquareAt(String to){ 
        String toUpper = to.toUpperCase();
        toUpper += " ";
        String col = toUpper.substring(0, 1);
        int row = Integer.parseInt(toUpper.substring(1, 2));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = squares[i][j];
                if (square.getColumn().equals(col) && square.getRow() == row) {
                    return square;
                }
            }
        }
        return null;
    }
    
    public Square[] getSquaresBetween(Square location, Square targetLocation, String rank, int color){
        if(rank.equals("P")){
            if(color == 0){
                Square[] squares = new Square[1];
                String to = location.getColumn() + (location.getRow() + 1);
                squares[0] = getSquareAt(to);
                return squares; }
            else{
                Square[] squares = new Square[1];
                String to = location.getColumn() + (location.getRow() - 1);
                squares[0] = getSquareAt(to);
                return squares;
            }
        }
        else if(rank.equals("R")){
            Square[] squares = new Square[7];
            if(location.isAtSameColumn(targetLocation)){
                int row = location.getRow();
                int rowDif = targetLocation.getRowDistance(location);
                if(rowDif > 0){
                    row++;
                    for(int i = 0; i < rowDif; i++){
                        String to = targetLocation.getColumn() + row;
                        squares[i] = getSquareAt(to);
                        row++;
                    }
                }
                else{
                    row--;
                    rowDif = Math.abs(rowDif); 
                    for(int i = 0; i < rowDif; i++){
                        String to = targetLocation.getColumn() + row;
                        squares[i] = getSquareAt(to);
                        row--;
                    }
                    
                }return squares;
               
            }
            else{
                String col = targetLocation.getColumn();
                int intTCol = targetLocation.intColumn();
                int intLCol = location.intColumn();
                int colDif = intTCol - intLCol;
                if(colDif > 0){
                    intLCol++;
                    col = stringColumn(intLCol);
                    for(int i = 0; i < colDif; i++){
                        String to = col + targetLocation.getRow();
                        squares[i] = getSquareAt(to);
                        intLCol++;
                        col = stringColumn(intLCol);
                    }
                }
                else{
                    intLCol--;
                    col = stringColumn(intLCol);
                    colDif = Math.abs(colDif);
                    for(int i = 0; i < colDif; i++){
                        String to = col + targetLocation.getRow();
                        squares[i] = getSquareAt(to);
                        intLCol--;
                        col = stringColumn(intLCol);
                    }
                }
            }return squares;
            
        }
        else{
            Square[] squares = new Square[1];
            return squares;
        }
    }

    public String stringColumn(int col){
        if(col == 1){
            return "A";
        }if(col == 2){
            return "B";
        }if(col == 3){
            return "C";
        }if(col == 4){
            return "D";
        }if(col == 5){
            return "E";
        }if(col == 6){
            return "F";
        }if(col == 7){
            return "G";
        }if(col == 8){
            return "H";
        }
        else{
            return null;
        }
    }

    public int drctnDetector(Square location, Square target){
        if(location.isAtSameColumn(target)){
            int locationRow = location.getRow();
            int targetRow = target.getRow();
            if(targetRow > locationRow){
                return 1;
            }
            else{
                return -1;
            }
        }
        else{
            int locationColumn = location.getColumn().hashCode();
            int targetColumn = target.getColumn().hashCode();
            if(targetColumn > locationColumn){
                return 2;
            }
            else{
                return -2;
            }
        }
    }
    
    public void removeList(Square target){
        String col = target.getColumn();
        int row = target.getRow();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = squares[i][j];
                if (square.equals(target)){
                    squares[i][j] = new Square(col, row, null);
                }
            }
        }
    }
    
    public void putNewQueen(int color, Square target){
        String col = target.getColumn();
        int row = target.getRow();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = squares[i][j];
                if (square.equals(target)){
                    squares[i][j] = new Square(col, row, new Piece(color, "QUEEN", (col+row)));
                }
            }
        }
    }
    
    public void setPiece(Piece piec, Square target){
        String col = target.getColumn();
        int row = target.getRow();
        Piece pie = getPieceAt(piec.getLocation());
        pie.setLocation(col+row);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = squares[i][j];
                if (square.equals(target)){
                    squares[i][j] = new Square(col, row, pie);
                }
            }
        }
    }
     

    @Override
    public String toString() {
        String brdStr = "";
        brdStr += " ";
        for (String har : harf) {
            brdStr += "   " + har;
        }
        brdStr += "\n";
        for (int row = 8; row > 0; row--) {
            brdStr += "  ---------------------------------\n";
            brdStr += row;
            for (String har : harf) {
                Piece p = getPieceAt(har + row);
                if (p == null) {
                    brdStr += " |  ";
                } else {
                    if (p.getRank().equals("ROOK")) {
                        brdStr += p.getColor() == 0 ? " | R" : " | r";
                    } else if (p.getRank().equals("KNIGHT")) {
                        brdStr += p.getColor() == 0 ? " | K" : " | k";
                    } else if (p.getRank().equals("BISHOP")) {
                        brdStr += p.getColor() == 0 ? " | B" : " | b";
                    } else if (p.getRank().equals("QUEEN")) {
                        brdStr += p.getColor() == 0 ? " | Q" : " | q";
                    } else if (p.getRank().equals("KING")) {
                        brdStr += p.getColor() == 0 ? " | K" : " | k";
                    } else if (p.getRank().equals("PAWN")) {
                        brdStr += p.getColor() == 0 ? " | P" : " | p";
                    }
                }
            }

            brdStr += " | " + row;
            brdStr += "\n";
        }
        brdStr += "  ---------------------------------\n";
        brdStr += " ";
        for (String har : harf) {
            brdStr += "   " + har;
        }
        return brdStr;
    }

}