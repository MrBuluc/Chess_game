
public class Bishop extends Piece {

    public Bishop(int color, Square location) {
        super(color, location);
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
            return "B";
        }
        else{
            return "b";
        }
    }

    
}