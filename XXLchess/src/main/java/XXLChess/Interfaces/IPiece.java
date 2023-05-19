package XXLChess.Interfaces;

import java.util.List;

public interface IPiece {
    List<ICell> getOptionalMovements(IBoard board) throws Exception;
    void startMoving(ICell cell) throws Exception;
    void capture();
    IPlayer getOwningPlayer();
    ICoordinate getCoordinate();
    void setCoordinate(ICoordinate coordinate); 
    boolean isCaptured();
}
