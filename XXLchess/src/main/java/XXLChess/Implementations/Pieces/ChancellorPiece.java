package XXLChess.Implementations.Pieces;

import XXLChess.Interfaces.IBoard;
import XXLChess.Interfaces.ICell;
import XXLChess.Interfaces.ICoordinate;
import XXLChess.Interfaces.IPlayer;
import XXLChess.Implementations.*;
import XXLChess.Interfaces.IMovingService;

import java.util.List;

public class ChancellorPiece extends AbstractPiece {
    public ChancellorPiece(ICoordinate coordinate, IPlayer owningPlayer, IMovingService movingService) 
    {
        super(coordinate, owningPlayer, movingService);
    }





    @Override
    public List<ICell> getOptionalMovements(IBoard board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOptionalMovements'");
    }
}
