
public class Pawn extends Piece{
    boolean initialLocation = true;
    private int color;
    private String locatio;
    private boolean attacking = false;
    
    public Pawn(int color, String locatio) {
        super(color, "PAWN", locatio);
        this.color = color;
        this.locatio = locatio;
    }

    @Override
    public boolean canMove(String to, ChessBoard board) {
        boolean validMove = false;
        Square location = board.getSquareAt(this.locatio);
        Square targetLocation = board.getSquareAt(to);
        int rowDistance = targetLocation.getRowDistance(location);
        if (location.isAtSameColumn(targetLocation)) {
            if (this.color == 0 && rowDistance > 0 && rowDistance <= 2) {
                if (rowDistance == 2) {
                    if (initialLocation) {
                        //pawn is moving twice, check two squares in front are empty
                        Square[] between = board.getSquaresBetween(location, targetLocation, "P",
                        this.color);
                        validMove = targetLocation.isEmpty() && between[0].isEmpty();
                        initialLocation = false;
                    }
                }
                else {
                    validMove = targetLocation.isEmpty();
                    initialLocation = false;
                }
                return validMove;
            } else if (this.color == 1 && rowDistance < 0 && rowDistance >= -2) {
                if (rowDistance == -2) {
                    if (initialLocation) {
                        //pawn is moving twice, check two squares in front are empty
                        Square[] between = board.getSquaresBetween(location, targetLocation,
                         "P", this.color);
                        validMove = targetLocation.isEmpty() && between[0].isEmpty();
                        initialLocation = false;
                    }
                }
                else {
                    validMove = targetLocation.isEmpty();
                    initialLocation = false;
                }
                return validMove;
            } // attacking diagonals
        } else if (location.isNeighborColumn(targetLocation)) {
            int color = board.getPieceAt(to).getColor();
            if (this.color == 0 && rowDistance == 1) {
                attacking = !targetLocation.isEmpty() &&  color == 1;
                validMove = attacking;
            } else if (this.color == 1 && rowDistance == -1) {
                attacking = !targetLocation.isEmpty() && color == 0;
                validMove = attacking;
            }
        }
        return validMove;
    }

    @Override
    public void move(String to, ChessBoard board) {
        Square location = board.getSquareAt(locatio);
        Square targetLocation = board.getSquareAt(to);
        //promoteToQueen
        if (targetLocation.isAtLastRow(this.color)) {
            board.putNewQueen(this.color, targetLocation);
        }
        else if(attacking) {
            board.removeList(targetLocation);
            board.setPiece(this, targetLocation);
        }
        else{
            board.setPiece(this, targetLocation);
        }
        //clear previous location
        board.removeList(location);
        //update current location
        location = targetLocation;
        board.nextPlayer();
}

    @Override
    public String toString() {
        if(super.getColor() == 0){
            return "P";
        }
        else{
            return "p";
        }
    }

}