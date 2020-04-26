import java.util.HashSet;
import java.util.Set;

public class ChessBoard {
    //final static int rows = 10;
    //final static int cols = 9;
    final static String[] harf = {"A","B","C","D","E","F","G","H"};
    private boolean flag = true;
    private Set<Piece> piecesWhite = new HashSet<>();
    private Set<Piece> piecesBlack = new HashSet<>();
    
    public ChessBoard() {
        piecesBlack.add(new Piece(1, new Square("A", 8), "ROOK"));
        piecesBlack.add(new Piece(1, new Square("B", 8), "KNIGHT"));
        piecesBlack.add(new Piece(1, new Square("C", 8), "BISHOP"));
        piecesBlack.add(new Piece(1, new Square("D", 8), "QUEEN"));
        piecesBlack.add(new Piece(1, new Square("E", 8), "KING"));
        piecesBlack.add(new Piece(1, new Square("F", 8), "BISHOP"));
        piecesBlack.add(new Piece(1, new Square("G", 8), "KNIGHT"));
        piecesBlack.add(new Piece(1, new Square("H", 8), "ROOK"));

        for(String har : harf){
            piecesBlack.add(new Piece(1, new Square(har, 7), "PAWN"));
        }

        piecesWhite.add(new Piece(0, new Square("A", 1), "ROOK"));
        piecesWhite.add(new Piece(0, new Square("B", 1), "KNIGHT"));
        piecesWhite.add(new Piece(0, new Square("C", 1), "BISHOP"));
        piecesWhite.add(new Piece(0, new Square("D", 1), "QUEEN"));
        piecesWhite.add(new Piece(0, new Square("E", 1), "KING"));
        piecesWhite.add(new Piece(0, new Square("F", 1), "BISHOP"));
        piecesWhite.add(new Piece(0, new Square("G", 1), "KNIGHT"));
        piecesWhite.add(new Piece(0, new Square("H", 1), "ROOK"));

        for(String har : harf){
            piecesWhite.add(new Piece(0, new Square(har, 2), "PAWN"));
        }    
    }
    

    public boolean isWhitePlaying(){
        return flag;
    }

    /*public boolean isGameEnded() {
        King pieces = new King(0, "A", 1);
        if(pieces.getBeyaz() == 16 || pieces.getSiyah() == 16){
            return true;
        }
        return false;
    }*/

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