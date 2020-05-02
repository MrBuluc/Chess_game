
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
        else if (this.rank.equals("ROOK")) {
            Rook rook = new Rook(this.color, this.location);
            rook.move(destination, board);
        }
        else if (this.rank.equals("KNIGHT")) {
            Knight knight = new Knight(this.color, this.location);
            knight.move(destination, board);
        }
        else if (this.rank.equals("BISHOP")) {
            Bishop bishop = new Bishop(this.color, this.location);
            bishop.move(destination, board);
        }
        else if (this.rank.equals("QUEEN")) {
            Queen queen = new Queen(this.color, this.location);
            queen.move(destination, board);
        }
        else if (this.rank.equals("KING")) {
            King king = new King(this.color, this.location);
            king.move(destination, board);
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
        else if(this.rank.equals("KNIGHT")){
            Knight knight = new Knight(this.color, this.location);
            return knight.canMove(destination, board);
        }
        else if(this.rank.equals("BISHOP")){
            Bishop bishop = new Bishop(this.color, this.location);
            return bishop.canMove(destination, board);
        }
        else if(this.rank.equals("QUEEN")){
            Queen queen = new Queen(this.color, this.location);
            return queen.canMove(destination, board);
        }
        else{
            King king = new King(this.color,this.location);
            return king.canMove(destination, board);
        }
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