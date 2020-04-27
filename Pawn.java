
public class Pawn extends Piece{
    boolean initialLocation = true;
    private int color, row;
    private String column, rank;
    private Square location;
    boolean attacking = false;
    
    public Pawn(int color, Square location, String rank) {
        super(color, location, rank);
        this.color = color;
        this.location = location;
        this.rank = rank;
    }

    @Override
    public boolean canMove(String to, ChessBoard board) {
        boolean validMove = false;
        Square targetLocation = board.getSquareAt(to);
        if(targetLocation == null){
            return validMove;
        }
        int rowDistance = targetLocation.getRowDistance(location);
        if (this.location.isAtSameColumn(targetLocation)) {
            if (color == 0 && rowDistance > 0 && rowDistance <= 2) {
                if (rowDistance == 2) {
                    if (initialLocation) {
                        //pawn is moving twice, check two squares in front are empty
                        Square[] between = board.getSquaresBetween(location, targetLocation,
                         "P", this.color);
                        validMove = targetLocation.isEmpty() && between[0].isEmpty();
                        initialLocation = false;
                    }
                } else {
                    validMove = targetLocation.isEmpty();
                } return validMove;
            } else if (color == 1 && rowDistance < 0 && rowDistance >= -2) {
                if (rowDistance == -2) {
                    if (initialLocation) {
                        //pawn is moving twice, check two squares in front are empty
                        Square[] between = board.getSquaresBetween(location, targetLocation,
                         "P", this.color);
                        validMove = targetLocation.isEmpty() && between[0].isEmpty();
                    }
                } else {
                    validMove = targetLocation.isEmpty();
                } return validMove;
            } // attacking diagonals
        } else if (this.location.isNeighborColumn(targetLocation)) {
            String col = targetLocation.getColumn();
            int row = targetLocation.getRow();
            String from = col + row;
            int color = board.getPieceAt(from).getColor();
            if (color == 0 && rowDistance == 1) {
                attacking = !targetLocation.isEmpty() &&  color == 1;
                validMove = attacking;
            } else if (color == 1 && rowDistance == -1) {
                attacking = !targetLocation.isEmpty() && color == 0;
                validMove = attacking;
            }
        }
        return validMove;
    }

    @Override
    public void move(String to, ChessBoard board) {
        Square targetLocation = board.getSquareAt(to);
         //clear previous location
         board.removeList(this.location, this.color);
         //update current location
         this.location = targetLocation;
        //promoteToQueen
        if (targetLocation.isAtLastRow(color)) {
            board.putNewQueen(color, targetLocation);
        }
        else if(attacking) {
            board.removeList(targetLocation, this.color);
            board.setPiece(this);
        }
        else{
            board.setPiece(this);
        }
       
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

}