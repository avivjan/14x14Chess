package XXLChess.Implementations;

import XXLChess.Interfaces.ICoordinate;

public class Coordinate implements ICoordinate {
    private int row;
    private int column;
    private static int cellSize = 48;
    private static int numOfRows;
    private static int numOfCols;;

    private Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static Coordinate createInstance(int x, int y, boolean inPixels) {
        if (inPixels) {
            if (!isOnBoard(x, y)) {

                // Clicked on the sidebar
                System.out.println("Clicked on the sidebar");
                return null;
            } else {
                int row = y / cellSize;
                int column = x / cellSize;
                return new Coordinate(column, row);
            }
        } else {
            return new Coordinate(x, y);
        }
    }


    @Override
    public int getRow() {
        return row;
    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public int getXInPixels() {
        return row * cellSize;
    }

    @Override
    public int getYInPixels() {
        return column * cellSize;
    }

    public static void SetNumOfRows(int numOfRows) {
        Coordinate.numOfRows = numOfRows;
    }

    public static void SetNumOfCols(int numOfCols) {
        Coordinate.numOfCols = numOfCols;
    }

    @Override
    public String toString() {
        return "Row: " + row + " Column: " + column;
    }

    @Override
    public boolean isValidCoordinate() {
        return row >= 0 && row < numOfRows && column >= 0 && column < numOfCols;
    }
    @Override
    public double getDistanceTo(ICoordinate coordinate) {
        int x1 = getXInPixels();
        int y1 = getYInPixels();
        int x2 = coordinate.getXInPixels();
        int y2 = coordinate.getYInPixels();
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }


    public static boolean isOnBoard(int getXInPixels, int getYInPixels) {
        return getXInPixels >= 0 && getXInPixels < numOfCols * cellSize && getYInPixels >= 0
                && getYInPixels < numOfRows * cellSize;
    }

}
