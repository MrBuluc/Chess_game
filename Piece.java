
public abstract class Piece {
    private int color;
    private Square s;

    public Piece(int color, Square sq) {
        this.color = color;
        this.s = sq;
    }

    public abstract void move(String destination);
    public abstract boolean canMove(String destination);

    
}