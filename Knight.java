
public class Knight extends Piece {
    private int color;
    private String locatio;
    private boolean attacking = false;
    
    public Knight(int color, String locatio) {
        super(color, "KNIGHT", locatio);
        this.color = color;
        this.locatio = locatio;
    }
    @Override
    public void move(String destination, ChessBoard board) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean canMove(String destination, ChessBoard board) {
        Square location = board.getSquareAt(this.locatio);
        Square targetLocation = board.getSquareAt(destination);
        int intLcol = location.intColumn();
        int lRow = location.getRow();
        int intTcol = targetLocation.intColumn();
        int tRow = targetLocation.getRow();
        if((intLcol + 1 == intTcol || intLcol - 1 == intTcol) && (lRow + 2 == tRow || lRow - 2 == tRow)){
            // attacking
            if(!targetLocation.isEmpty()){
                int color = targetLocation.getPiece().getColor();
                if(this.color != color){
                    attacking = true;
                }
                return false;
            }
            return true;
        }
        else if((intLcol + 2 == intTcol || intLcol - 2 == intTcol) && (lRow + 1 == tRow || lRow - 1 == 
        tRow)){
            // attacking
            if(!targetLocation.isEmpty()){
                int color = targetLocation.getPiece().getColor();
                if(this.color != color){
                    attacking = true;
                }
                return false;
            }
            return true;
        }
        return false;
        
    }

}