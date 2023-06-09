package XXLChess.Interfaces;

public interface ICoordinate {
    int getRow();
    void setRow(int row);
    int getColumn();
    void setColumn(int column);
    int getXInPixels();
    int getYInPixels();
    boolean isValidCoordinate();
    double getDistanceTo(ICoordinate coordinate);
}
