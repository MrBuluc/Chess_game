
public class CChess {
    public static void main(String[] args) {
        CChessBoard brd = new CChessBoard();
        System.out.println(brd);
      }
    }
    class CChessBoard {
      //final static int rows = 19;
      //final static int cols = 19;
      final static String[] harf = {"A","B","C","D","E","F","G","H"};
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
            for (int col = 0; col < 8; col++) {
                brdStr += " | .";
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