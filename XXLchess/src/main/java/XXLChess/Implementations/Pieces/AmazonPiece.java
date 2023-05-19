package XXLChess.Implementations.Pieces;

import XXLChess.Interfaces.IBoard;
import XXLChess.Interfaces.ICell;
import XXLChess.Interfaces.ICoordinate;
import XXLChess.Interfaces.IPlayer;
import XXLChess.Interfaces.IMovingService;
import XXLChess.Implementations.AbstractPiece;

import java.util.ArrayList;
import java.util.List;

public class AmazonPiece extends AbstractPiece {

    public AmazonPiece(ICoordinate coordinate, IPlayer owningPlayer, IMovingService movingService) {
        super(coordinate, owningPlayer, movingService);
    }

    @Override
    public List<ICell> getOptionalMovements(IBoard board) throws Exception {
        List<ICell> optionalMovements = new ArrayList<>();

        optionalMovements.addAll(getKnightMovements(board));
        optionalMovements.addAll(getBishopMovements(board));
        optionalMovements.addAll(getRookMovements(board));

        // Print the optional movements
        System.out.println("Optional Movements:");
        for (ICell cell : optionalMovements) {
            System.out.println(cell.getCoordinate());
            board.addOptionCells(cell);
        }
        return optionalMovements;
    }

    private List<ICell> getKnightMovements(IBoard board) throws Exception {
        KnightPiece knight = new KnightPiece(getCoordinate(), getOwningPlayer(), movingService);
        return knight.getOptionalMovements(board);
    }

    private List<ICell> getBishopMovements(IBoard board) throws Exception {
        BishopPiece bishop = new BishopPiece(getCoordinate(), getOwningPlayer(), movingService);
        return bishop.getOptionalMovements(board);
    }

    private List<ICell> getRookMovements(IBoard board) throws Exception {
        RookPiece rook = new RookPiece(getCoordinate(), getOwningPlayer(), movingService);
        return rook.getOptionalMovements(board);
    }
}
