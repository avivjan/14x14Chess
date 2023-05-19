package XXLChess.Implementations.Pieces;

import XXLChess.Interfaces.IBoard;
import XXLChess.Interfaces.ICell;
import XXLChess.Interfaces.ICoordinate;
import XXLChess.Interfaces.IMovingService;
import XXLChess.Interfaces.IPlayer;
import XXLChess.Implementations.AbstractPiece;

import java.util.ArrayList;
import java.util.List;

public class KnightKingPiece extends AbstractPiece {

    public KnightKingPiece(ICoordinate coordinate, IPlayer owningPlayer, IMovingService movingService) {
        super(coordinate, owningPlayer, movingService);
    }

    @Override
    public List<ICell> getOptionalMovements(IBoard board) throws Exception {
        List<ICell> optionalMovements = new ArrayList<>();
        optionalMovements.addAll(getKnightMovements(board));
        optionalMovements.addAll(getKingMovements(board));
        
        // Print the optional movements
        System.out.println("Optional Movements:");
        for (ICell cell : optionalMovements) {
            System.out.println(cell.getCoordinate());
            board.addOptionCells(cell);
        }

        return optionalMovements;
    }
    
    private List<ICell> getKnightMovements(IBoard board) throws Exception {
        KnightPiece knightPiece = new KnightPiece(getCoordinate(), getOwningPlayer(), movingService);
        return knightPiece.getOptionalMovements(board);
    }
    
    private List<ICell> getKingMovements(IBoard board) throws Exception {
        KingPiece kingPiece = new KingPiece(getCoordinate(), getOwningPlayer(), movingService);
        return kingPiece.getOptionalMovements(board);
    }
}
