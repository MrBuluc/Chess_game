
public class Rook extends Piece {
    private int color;
    private String locatio;
    private boolean attacking = false;

    public Rook(int color, String locatio) {
        super(color, "ROOK", locatio);
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
        if(location.isAtSameColumn(targetLocation) || location.isAtSameRow(targetLocation)){
            //rook is moving, check all squares in front, behind, right or left are empty
            Square[] between = board.getSquaresBetween(location, targetLocation, "R", this.color);
            boolean zero = between[0] != null ? between[0].isEmpty() : true;
            boolean one = between[1] != null ? between[1].isEmpty() : true;
            boolean two = between[2] != null ? between[2].isEmpty() : true;
            boolean tree = between[3] != null ? between[3].isEmpty() : true;
            boolean four = between[4] != null ? between[4].isEmpty() : true;
            boolean five = between[5] != null ? between[5].isEmpty() : true;
            boolean six = between[6] != null ? between[6].isEmpty() : true;
            validMove = targetLocation.isEmpty() && zero && one && two && tree && four && five && six;
            return validMove;
        }// attacking
        else if(!targetLocation.isEmpty()){
            int color = targetLocation.getPiece().getColor();
            if(this.color != color){
                attacking = true;
                validMove = attacking;
            }
            else{
                return validMove;
            }
        }
        return validMove;
    }

   /*  public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    } */

    
}