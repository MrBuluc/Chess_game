public class ChessBoard {
    final static String[] harf = { "A", "B", "C", "D", "E", "F", "G", "H" };
    private boolean flag = true;
    private Square[][] squares = new Square[8][8];

    public ChessBoard() {
        squares[0][0] = new Square("A", 8, new Rook(1, "A8"));
        squares[1][0] = new Square("B", 8, new Knight(1, "B8"));
        squares[2][0] = new Square("C", 8, new Bishop(1, "C8"));
        squares[3][0] = new Square("D", 8, new Queen(1, "D8"));
        squares[4][0] = new Square("E", 8, new King(1, "E8"));
        squares[5][0] = new Square("F", 8, new Bishop(1, "F8"));
        squares[6][0] = new Square("G", 8, new Knight(1, "G8"));
        squares[7][0] = new Square("H", 8, new Rook(1, "H8"));

        squares[0][1] = new Square("A", 7, new Pawn(1, "A7"));
        squares[1][1] = new Square("B", 7, new Pawn(1, "B7"));
        squares[2][1] = new Square("C", 7, new Pawn(1, "C7"));
        squares[3][1] = new Square("D", 7, new Pawn(1, "D7"));
        squares[4][1] = new Square("E", 7, new Pawn(1, "E7"));
        squares[5][1] = new Square("F", 7, new Pawn(1, "F7"));
        squares[6][1] = new Square("G", 7, new Pawn(1, "G7"));
        squares[7][1] = new Square("H", 7, new Pawn(1, "H7"));

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

        squares[0][6] = new Square("A", 2, new Pawn(0, "A2"));
        squares[1][6] = new Square("B", 2, new Pawn(0, "B2"));
        squares[2][6] = new Square("C", 2, new Pawn(0, "C2"));
        squares[3][6] = new Square("D", 2, new Pawn(0, "D2"));
        squares[4][6] = new Square("E", 2, new Pawn(0, "E2"));
        squares[5][6] = new Square("F", 2, new Pawn(0, "F2"));
        squares[6][6] = new Square("G", 2, new Pawn(0, "G2"));
        squares[7][6] = new Square("H", 2, new Pawn(0, "H2"));

        squares[0][7] = new Square("A", 1, new Rook(0, "A1"));
        squares[1][7] = new Square("B", 1, new Knight(0, "B1"));
        squares[2][7] = new Square("C", 1, new Bishop(0, "C1"));
        squares[3][7] = new Square("D", 1, new Queen(0,  "D1"));
        squares[4][7] = new Square("E", 1, new King(0, "E1"));
        squares[5][7] = new Square("F", 1, new Bishop(0, "F1"));
        squares[6][7] = new Square("G", 1, new Knight(0, "G1"));
        squares[7][7] = new Square("H", 1, new Rook(0, "H1"));
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
        else if(rank.equals("B")){
            Square[] squares = new Square[7];
            int lCol = location.intColumn();
            int lRow = location.getRow();
            int tCol = targetLocation.intColumn();
            int tRow = targetLocation.getRow();
            int rDif = Math.abs(tRow - lRow);
            if(tCol > lCol && tRow > lRow){
                for(int i = 0; i < rDif; i++){
                    lRow++;
                    lCol++;
                    String col = stringColumn(lCol);
                    String to = col + lRow;
                    squares[i] = getSquareAt(to);
                }
            }
            else if(tCol < lCol && tRow > lRow){
                for(int i = 0; i < rDif; i++){
                    lRow++;
                    lCol--;
                    String col = stringColumn(lCol);
                    String to = col + lRow;
                    squares[i] = getSquareAt(to);
                }
            }
            else if(tCol < lCol && tRow < lRow){
                for(int i = 0; i < rDif; i++){
                    lRow--;
                    lCol--;
                    String col = stringColumn(lCol);
                    String to = col + lRow;
                    squares[i] = getSquareAt(to);
                }
            }
            else{
                for(int i = 0; i < rDif; i++){
                    lRow--;
                    lCol++;
                    String col = stringColumn(lCol);
                    String to = col + lRow;
                    squares[i] = getSquareAt(to);
                }
            }return squares;
        }
        else{
            //Square[] squares = new Square[1];
            return null;
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
                    squares[i][j] = new Square(col, row, new Queen(color, (col+row)));
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
                if (square.getColumn().equals(col) && square.getRow() == row) {
                    if (pie instanceof Pawn) {
                        squares[i][j] = new Square(col, row, new Pawn(pie.getColor(), pie.getLocation()));
                    }
                    else if (pie instanceof Bishop) {
                        squares[i][j] = new Square(col, row, new Bishop(pie.getColor(), pie.getLocation()));
                    }
                    else if (pie instanceof King) {
                        squares[i][j] = new Square(col, row, new King(pie.getColor(), pie.getLocation()));
                    }
                    else if (pie instanceof Knight) {
                        squares[i][j] = new Square(col, row, new Knight(pie.getColor(), pie.getLocation()));
                    }
                    else if (pie instanceof Queen) {
                        squares[i][j] = new Square(col, row, new Queen(pie.getColor(), pie.getLocation()));
                    }
                    else if (pie instanceof Rook) {
                        squares[i][j] = new Square(col, row, new Rook(pie.getColor(), pie.getLocation()));
                    }
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
                Piece p =getPieceAt(har + row);
                if (p == null) {
                    brdStr += " |  ";
                } else {
                    if (p instanceof Rook) {
                        brdStr += p.getColor() == 0 ? " | R" : " | r";
                    } else if (p instanceof Knight) {
                        brdStr += p.getColor() == 0 ? " | N" : " | n";
                    } else if (p instanceof Bishop) {
                        brdStr += p.getColor() == 0 ? " | B" : " | b";
                    } else if (p instanceof Queen) {
                        brdStr += p.getColor() == 0 ? " | Q" : " | q";
                    } else if (p instanceof King) {
                        brdStr += p.getColor() == 0 ? " | K" : " | k";
                    } else if (p instanceof Pawn) {
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