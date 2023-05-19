package XXLChess.Implementations;

import XXLChess.Interfaces.ICell;
import XXLChess.Interfaces.ICoordinate;
import XXLChess.Interfaces.IPiece;
import XXLChess.*;

public class Cell implements ICell {
    private CellStatus status;
    private boolean selected;
    private IPiece pieceOnIt;
    private ICoordinate coordinate;

    public Cell(CellStatus status, boolean selected, IPiece pieceOnIt, ICoordinate coordinate) {
        this.status = status;
        this.selected = selected;
        this.pieceOnIt = pieceOnIt;
        this.coordinate = coordinate;
    }

    public CellStatus getStatus() {
        return status;
    }
    public void setStatus(CellStatus status) {
        this.status = status;
    }

    public boolean isSelected() {
        return selected;
    }

    public boolean canBeSelected() 
    {
        return pieceOnIt != null && pieceOnIt.getOwningPlayer() instanceof HumanPlayer;
        
    }

    public IPiece getPieceOnIt() {
        return pieceOnIt;
    }

    public ICoordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public void setPieceOnIt(IPiece piece) {
        this.pieceOnIt = piece;
    }
}
