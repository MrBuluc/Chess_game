
public class King extends Piece {
    private int color, row;
    private String column, rank;
    private Square location;
    
    public King(int color, Square location, String rank) {
        super(color, location, rank);
        this.color = color;
        this.location = location;
        this.rank = rank;
    }
    
    @Override
    public void move(String destination) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean canMove(String destination) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String toString() {
        if(super.getColor() == 0){
            return "K";
        }
        else{
            return "k";
        }
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    

}