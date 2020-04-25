
public class Pawn extends Piece{
    boolean initialLocation = true;
    public Pawn(int color, String column, int row) {
        super(color, new Square(column,row));
    }
    @Override
    public boolean canMove(String to) {
        return true;
        boolean validMove = false;
        Square targetLocation = location.getBoard().getSquareAt(to);
        int rowDistance = targetLocation.getRowDistance(location);
        if (this.location.isAtSameColumn(targetLocation)) {
            if (color == ChessBoard.WHITE && rowDistance > 0 && rowDistance <= 2) {
                if (rowDistance == 2) {
                    if (initialLocation) {
                        //pawn is moving twice, check two squares in front are empty
                        Square[] between = location.getBoard().getSquaresBetween(location, targetLocation);
                        validMove = targetLocation.isEmpty() && between[0].isEmpty();
                    }
                } else {
                    validMove = targetLocation.isEmpty();
                } return validMove;
            } else if (color == ChessBoard.BLACK && rowDistance < 0 && rowDistance >= -2) {
                if (rowDistance == -2) {
                    if (initialLocation) {
                        //pawn is moving twice, check two squares in front are empty
                        Square[] between = location.getBoard().getSquaresBetween(location, targetLocation);
                        validMove = targetLocation.isEmpty() && between[0].isEmpty();
                    }
                } else {
                    validMove = targetLocation.isEmpty();
                }
            } // attacking diagonals
        } else if (this.location.isNeighborColumn(targetLocation)) {
            if (color == ChessBoard.WHITE && rowDistance == 1) {
                validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() ==
                ChessBoard.BLACK;
                int siyah = super.getSiyah() + 1;
                super.setSiyah(siyah);
            } else if (color == ChessBoard.BLACK && rowDistance == -1) {
                validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() ==
                ChessBoard.WHITE;
                int beyaz = super.getBeyaz() + 1;
                super.setBeyaz(beyaz);
            }
        }
        return validMove;*/
    }

    @Override
    public void move(String to) {
        /*Square targetLocation = location.getBoard().getSquareAt(to);
        //promoteToQueen
        if (targetLocation.isAtLastRow(color)) {
            targetLocation.putNewQueen(color);
        } else {
            targetLocation.setPiece(this);
        } //clear previous location
        location.clear();
        //update current location
        location = targetLocation;
        location.getBoard().nextPlayer();*/
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