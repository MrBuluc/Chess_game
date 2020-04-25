
public class King extends Piece {

    public King(int color, Square location) {
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
            return "K";
        }
        else{
            return "k";
        }
    }

    

}