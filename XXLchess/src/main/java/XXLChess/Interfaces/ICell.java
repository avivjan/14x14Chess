package XXLChess.Interfaces;
import XXLChess.*;


public interface ICell {
    CellStatus getStatus();
    boolean isSelected();
    boolean canBeSelected();
    IPiece getPieceOnIt();
    void setPieceOnIt(IPiece piece);
    ICoordinate getCoordinate();
    void setStatus(CellStatus cs);
    
}