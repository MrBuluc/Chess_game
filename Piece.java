
public abstract class Piece {
    private int color;
    private Square location;

    public Piece(int color, Square s1) {
        this.color = color;
        this.location = s1;
    }
    

    public abstract void move(String destination);
    public abstract boolean canMove(String destination);

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

    
}