import java.util.HashSet;
import java.util.Set;

public class ChessBoard {
    //final static int rows = 10;
    //final static int cols = 9;
    final static String[] harf = {"A","B","C","D","E","F","G","H"};
    private boolean flag = true;
    private Set<Piece> pieces = new HashSet<>();
    public ChessBoard() {
        pieces.add(new Piece(0, new Square("A", 1), "ROOK"));
    }

    public boolean isWhitePlaying(){
        return flag;
    }

    public boolean isGameEnded() {
        King pieces = new King(0, "A", 1);
        if(pieces.getBeyaz() == 16 || pieces.getSiyah() == 16){
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
        String letter = fromUpper.substring(0, 1);
        int num = Integer.parseInt(fromUpper.substring(1, 2));
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
                if(row < 9 && row > 6){
                    brdStr += " | "+ new Square(har, row);
                }
                else if(row < 7 && row > 2){
                    brdStr += " |  ";
                }
                else{
                    brdStr += " | "+ new Square(har, row);
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