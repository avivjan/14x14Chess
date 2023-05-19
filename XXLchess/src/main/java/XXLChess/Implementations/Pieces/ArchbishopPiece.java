package XXLChess.Implementations.Pieces;

import XXLChess.Interfaces.IBoard;
import XXLChess.Interfaces.ICell;
import XXLChess.Interfaces.ICoordinate;
import XXLChess.Interfaces.IPlayer;
import XXLChess.Interfaces.IMovingService;
import XXLChess.Implementations.AbstractPiece;

import java.util.ArrayList;
import java.util.List;

public class ArchbishopPiece extends AbstractPiece {

    public ArchbishopPiece(ICoordinate coordinate, IPlayer owningPlayer, IMovingService movingService) {
        super(coordinate, owningPlayer, movingService);
    }

    @Override
    public List<ICell> getOptionalMovements(IBoard board) throws Exception {
        List<ICell> optionalMovements = new ArrayList<>();
        optionalMovements.addAll(getBishopMovements(board));
        optionalMovements.addAll(getKnightMovements(board));
        
        System.out.println("Optional Movements:");
        for (ICell cell : optionalMovements) {
            System.out.println(cell.getCoordinate());
            board.addOptionCells(cell);
        }

        return optionalMovements;
    }
    
    private List<ICell> getBishopMovements(IBoard board) throws Exception {
        BishopPiece bishopPiece = new BishopPiece(getCoordinate(), getOwningPlayer(), movingService);
        return bishopPiece.getOptionalMovements(board);
    }
    
    private List<ICell> getKnightMovements(IBoard board) throws Exception {
        KnightPiece knightPiece = new KnightPiece(getCoordinate(), getOwningPlayer(), movingService);
        return knightPiece.getOptionalMovements(board);
    }
}
