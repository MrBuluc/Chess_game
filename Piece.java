
public class Piece{
    private int color;
    private String rank, location;

    public Piece(int color, String rank, String location) {
        this.color = color;
        this.rank = rank;
        this.location = location;
    }

    public void move(String destination, ChessBoard board) {
        if (this.rank.equals("PAWN")) {
            Pawn pawn = new Pawn(this.color, this.location);
            pawn.move(destination, board);
        }
        if (this.rank.equals("ROOK")) {
            Rook rook = new Rook(this.color, this.location);
            rook.move(destination, board);
        }
    }

    public boolean canMove(String destination, ChessBoard board) {
        if (this.rank.equals("PAWN")) {
            Pawn pawn = new Pawn(this.color, this.location);
            return pawn.canMove(destination, board);
        }
        else if(this.rank.equals("ROOK")){
            Rook rook = new Rook(this.color, this.location);
            return rook.canMove(destination, board);
        }
        return false;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}