
public class ChessBoard {
    //final static int rows = 10;
    //final static int cols = 9;
    final static String[] harf = {"A","B","C","D","E","F","G","H"};
    //Square[][] squares = new Square[3][7];
    

    public ChessBoard() {
       
    }

    //public boolean isWhitePlaying(){}

    //public boolean isGameEnded() {}

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