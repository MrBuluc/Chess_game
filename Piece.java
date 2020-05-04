
public abstract class Piece{
    private int color;
    private String location;

    public Piece(int color, String location) {
        this.color = color;
        this.location = location;
    }

    public abstract void move(String destination, ChessBoard board);
       

    public abstract boolean canMove(String destination, ChessBoard board);

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}