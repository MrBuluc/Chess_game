
public class King extends Piece {
    private int color;
    private String locatio;
    private boolean attacking = false;

    public King(int color, String locatio) {
        super(color, locatio);
        this.color = color;
        this.locatio = locatio;
    }
    
    @Override
    public void move(String destination, ChessBoard board) {
        Square location = board.getSquareAt(locatio);
        Square target = board.getSquareAt(destination);
        if(attacking){
            board.removeList(target);
            board.setPiece(this, target);
        }
        else{
            board.setPiece(this, target);
        }
        //clear previous location
        board.removeList(location);
        //update current location
        location = target;
        board.nextPlayer();

    }

    @Override
    public boolean canMove(String destination, ChessBoard board) {
        boolean validMove = false;
        Square location = board.getSquareAt(this.locatio);
        Square targetLocation = board.getSquareAt(destination);
        int intLcol = location.intColumn();
        int lRow = location.getRow();
        int intTcol = targetLocation.intColumn();
        int tRow = targetLocation.getRow();
        int colDif = Math.abs(intLcol - intTcol);
        int rowDif = Math.abs(lRow - tRow);
        if((location.isAtSameColumn(targetLocation) || location.isAtSameRow(targetLocation)) && 
        ((lRow + 1) == tRow || (intLcol + 1) == intTcol || (lRow - 1) == tRow || (intLcol - 1) == intTcol)){
            //King is moving, check all squares in front, behind, right or left are empty
            validMove = targetLocation.isEmpty();
            if(!targetLocation.isEmpty()){
                int color = targetLocation.getPiece().getColor();
                if(this.color != color){
                    attacking = !validMove;
                }
                else{
                    return validMove;
                }
            }
            return attacking ? attacking : validMove;
        }
        else if((colDif == rowDif) && ((((lRow + 1) == tRow) && ((intLcol + 1) == intTcol)) || 
        (((lRow - 1) == tRow) && ((intLcol + 1) == intTcol)) || 
        (((lRow - 1) == tRow) && ((intLcol - 1) == intTcol)) ||
        (((lRow + 1) == tRow) && ((intLcol - 1) == intTcol)))){
            //King is moving, check all squares diagonals are empty
            validMove = targetLocation.isEmpty();
            if(!targetLocation.isEmpty()){
                int color = targetLocation.getPiece().getColor();
                if(this.color != color){
                    attacking = !validMove;
                }
                else{
                    return validMove;
                }
            }
            return attacking ? attacking : validMove;
        }
        return validMove;
    }
}