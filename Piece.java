
public class Piece {
    private int color;
    private Square location;
    private static int siyah = 0; 
    private static int beyaz = 0;
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

    public static int getSiyah() {
        return siyah;
    }

    public static void setSiyah(int siyah) {
        Piece.siyah = siyah;
    }

    public static int getBeyaz() {
        return beyaz;
    }

    public static void setBeyaz(int beyaz) {
        Piece.beyaz = beyaz;
    }

    
}