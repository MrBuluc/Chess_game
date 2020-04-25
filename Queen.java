
public class Queen extends Piece {

    public Queen(int color, Square location) {
        super(color,location);
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
            return "Q";
        }
        else{
            return "q";
        }
    }

    

}