
public class Pawn extends Piece{
    boolean initialLocation = true;
    private int color, row;
    private String column, rank;
    private Square location;
    
    public Pawn(int color, Square location, String rank) {
        super(color, location, rank);
        this.color = color;
        this.location = location;
        this.rank = rank;
    }

    @Override
    public boolean canMove(String to) {
        boolean validMove = false;
        Square targetLocation = location.getBoard().getSquareAt(to);
        if(targetLocation == null){
            return false;
        }
        int rowDistance = targetLocation.getRowDistance(location);
        if (this.location.isAtSameColumn(targetLocation)) {
            if (color == 0 && rowDistance > 0 && rowDistance <= 2) {
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
        return validMove;
    }

    @Override
    public void move(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        //promoteToQueen
        if (targetLocation.isAtLastRow(color)) {
            targetLocation.putNewQueen(color);
        } else {
            targetLocation.setPiece(this);
        } //clear previous location
        location.clear();
        //update current location
        location = targetLocation;
        location.getBoard().nextPlayer();
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    
}