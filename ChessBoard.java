import java.util.ArrayList;

public class ChessBoard {
    final static String[] harf = {"A","B","C","D","E","F","G","H"};
    private boolean flag = true;
    private ArrayList<Piece> piecesWhite = new ArrayList<Piece>();
    private ArrayList<Piece> piecesBlack = new ArrayList<Piece>();
    
    public ChessBoard() {
        piecesBlack.add(new Piece(1, new Square("A", 8, true), "ROOK"));
        piecesBlack.add(new Piece(1, new Square("B", 8, true), "KNIGHT"));
        piecesBlack.add(new Piece(1, new Square("C", 8, true), "BISHOP"));
        piecesBlack.add(new Piece(1, new Square("D", 8, true), "QUEEN"));
        piecesBlack.add(new Piece(1, new Square("E", 8, true), "KING"));
        piecesBlack.add(new Piece(1, new Square("F", 8, true), "BISHOP"));
        piecesBlack.add(new Piece(1, new Square("G", 8, true), "KNIGHT"));
        piecesBlack.add(new Piece(1, new Square("H", 8, true), "ROOK"));

        for(String har : harf){
            piecesBlack.add(new Piece(1, new Square(har, 7, true), "PAWN"));
        }

        piecesWhite.add(new Piece(0, new Square("A", 1, true), "ROOK"));
        piecesWhite.add(new Piece(0, new Square("B", 1, true), "KNIGHT"));
        piecesWhite.add(new Piece(0, new Square("C", 1, true), "BISHOP"));
        piecesWhite.add(new Piece(0, new Square("D", 1, true), "QUEEN"));
        piecesWhite.add(new Piece(0, new Square("E", 1, true), "KING"));
        piecesWhite.add(new Piece(0, new Square("F", 1, true), "BISHOP"));
        piecesWhite.add(new Piece(0, new Square("G", 1, true), "KNIGHT"));
        piecesWhite.add(new Piece(0, new Square("H", 1, true), "ROOK"));

        for(String har : harf){
            piecesWhite.add(new Piece(0, new Square(har, 2, true), "PAWN"));
        }
    }
    

    public boolean isWhitePlaying(){
        return flag;
    }

    public boolean isGameEnded() {
        if(piecesWhite.isEmpty() || piecesBlack.isEmpty()){
            return true;
        }
        return false;
    }

    public void nextPlayer(){
        flag = flag ? false : true;
    }

    public Piece getPieceAt(String from){
        String fromUpper = from.toUpperCase();
        fromUpper += " ";
        String col = fromUpper.substring(0, 1);
        int row = Integer.parseInt(fromUpper.substring(1, 2));
        for(Piece piece : piecesWhite){
            if(piece.getLocation().getColumn().equals(col) && piece.getLocation().getRow() == row){
                return piece;
            }
        }
        for(Piece piece : piecesBlack){
            if(piece.getLocation().getColumn().equals(col) && piece.getLocation().getRow() == row){
                return piece;
            }
        }
        return null;
    }

    public Square getSquareAt(String to){
        String toUpper = to.toUpperCase();
        toUpper += " ";
        String col = toUpper.substring(0, 1);
        int row = Integer.parseInt(toUpper.substring(1, 2));
        for(Piece piece : piecesWhite){
            if(piece.getLocation().getColumn().equals(col) && piece.getLocation().getRow() == row){
                return piece.getLocation();
            }
        }
        for(Piece piece : piecesBlack){
            if(piece.getLocation().getColumn().equals(col) && piece.getLocation().getRow() == row){
                return piece.getLocation();
            }
        }
        Square square = new Square(col, row, false);
        return square;
    }

    public Square[] getSquaresBetween(Square location, Square targetLocation, String rank, int color){
        if(rank.equals("P")){
            if(color == 0){
                Square[] squares = new Square[1];
                String to = location.getColumn() + (location.getRow() + 1);
                squares[0] = getSquareAt(to);
                return squares;
            }
            else{
                Square[] squares = new Square[1];
                String to = location.getColumn() + (location.getRow() - 1);
                squares[0] = getSquareAt(to);
                return squares;
            }
        }
        else{
            Square[] squares = new Square[1];
            return squares;
        }
    }

    public void removeList(Square target, int color){
        String col = target.getColumn();
        int row = target.getRow();
        String from = col + row;
        if(color == 0){
            piecesWhite.remove(getPieceAt(from));
            System.out.println("removeList metodu çalıştı");
        }
        else{
            piecesBlack.remove(getPieceAt(from));
        }
    }

    public void putNewQueen(int color, Square target) {
        if(color == 0){
            piecesWhite.add(new Piece(color, target, "QUEEN"));
        }
        else{
            piecesBlack.add(new Piece(color, target, "QUEEN"));
        }
	}

    public void setPiece(Piece piec) {
        if(piec.getColor() == 0){
            piecesWhite.add(new Piece(piec.getColor(), piec.getLocation(), piec.getRank()));
            System.out.println("setPiece çalıştı");
        }
        else{
            piecesBlack.add(new Piece(piec.getColor(), piec.getLocation(), piec.getRank()));
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
            for (String har : harf ) {
                Piece p = getPieceAt(har + row);
                if(p == null){
                    brdStr += " |  ";
                }
                else{
                    if(p.getRank().equals("ROOK")){
                        brdStr += p.getColor() == 0 ? " | R" : " | r";
                    }
                    else if(p.getRank().equals("KNIGHT")){
                        brdStr += p.getColor() == 0 ? " | K" : " | k";
                    } 
                    else if(p.getRank().equals("BISHOP")){
                        brdStr += p.getColor() == 0 ? " | B" : " | b";
                    } 
                    else if(p.getRank().equals("QUEEN")){
                        brdStr += p.getColor() == 0 ? " | Q" : " | q";
                    } 
                    else if(p.getRank().equals("KING")){
                        brdStr += p.getColor() == 0 ? " | K" : " | k";
                    } 
                    else if(p.getRank().equals("PAWN")){
                        brdStr += p.getColor() == 0 ? " | P" : " | p";
                    }
                }
            }
                
            brdStr += " | "+ row;
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