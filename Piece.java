
public class Piece {
    private int color;
    private Square location;
    private String rank;

    public Piece(int color, Square s1, String rank) {
        this.color = color;
        this.location = s1;
        this.rank = rank;
    }
    

    public void move(String destination){
        if(this.rank.equals("Pawn")){
           Pawn pawn = (Pawn)this;
           pawn.move(destination);
        }
        if(this.rank.equals("ROOK")){
            Rook rook = (Rook)this;
            rook.move(destination);
        }
    }

    public boolean canMove(String destination){
        return true;
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

    
}