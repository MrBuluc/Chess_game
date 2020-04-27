import java.util.ArrayList;

public class Square {
    private String column;
    private int row;
    private Piece piece;

    public Square(String column, int row, Piece piece) {
        this.column = column;
        this.row = row;
        this.piece = piece;
    }

    public boolean isEmpty() {
        return this.piece == null;
    }

    public boolean isAtSameColumn(Square s) {
        if (this.column.equals(s.getColumn())) {
            return true;
        }
        return false;
    }

    public int getRowDistance(Square location) {
        return (this.row - location.getRow());
    }

    public boolean isNeighborColumn(Square targetLocation) {
        ArrayList<String> neighborColumn = new ArrayList<String>();
        if (this.column.equals("A")) {
            neighborColumn.add("B");
        } else if (this.column.equals("B")) {
            neighborColumn.add("A");
            neighborColumn.add("C");
        } else if (this.column.equals("C")) {
            neighborColumn.add("B");
            neighborColumn.add("D");
        } else if (this.column.equals("D")) {
            neighborColumn.add("C");
            neighborColumn.add("E");
        } else if (this.column.equals("E")) {
            neighborColumn.add("D");
            neighborColumn.add("F");
        } else if (this.column.equals("F")) {
            neighborColumn.add("E");
            neighborColumn.add("G");
        } else if (this.column.equals("G")) {
            neighborColumn.add("F");
            neighborColumn.add("H");
        } else {
            neighborColumn.add("G");
        }
        return neighborColumn.contains(targetLocation.getColumn());
    }

    public boolean isAtLastRow(int color) {
        if (color == 0 && this.row == 8) {
            return true;
        } else if (color == 1 && this.row == 1) {
            return true;
        }
        return false;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /*@Override
    public boolean equals(Square obj) {
        return (this.column.equals(obj.getColumn()) && this.row == obj.row && this.piece.equals(
            obj.getPiece()));
    }*/
}