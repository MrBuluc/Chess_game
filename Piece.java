
public class Piece {
    private int color;
    private Square location;
    private String rank;

    public Piece(int color, Square s1, String rank) {
        this.color = color;
        this.location = s1;
        this.rank = rank;
    }

    public void move(String destination, ChessBoard board) {
        if (this.rank.equals("PAWN")) {
            Pawn pawn = new Pawn(this.color, this.location, this.rank);
            pawn.move(destination, board);
        }
        if (this.rank.equals("ROOK")) {
            Rook rook = (Rook) this;
            rook.move(destination, board);
        }
    }

    public boolean canMove(String destination, ChessBoard board) {
        if (this.rank.equals("PAWN")) {
            Pawn pawn = new Pawn(this.color, this.location, this.rank);
            return pawn.canMove(destination, board);
        }
        return false;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square location) {
        this.location = location;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Color: "+ this.color+ " Square: "+ this.location+ " Rank: "+ this.rank;
    }

    
}