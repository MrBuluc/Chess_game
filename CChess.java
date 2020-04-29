
public class CChess {
    public static void main(String[] args) {
      String to = "d2";
        String toUpper = to.toUpperCase();
        toUpper += " ";
        String col = toUpper.substring(0, 1);
        int row = Integer.parseInt(toUpper.substring(1, 2));
        System.out.println(col);
        System.out.println(row);
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