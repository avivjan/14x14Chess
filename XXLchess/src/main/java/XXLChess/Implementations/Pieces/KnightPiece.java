package XXLChess.Implementations.Pieces;

import XXLChess.Interfaces.IBoard;
import XXLChess.Interfaces.ICell;
import XXLChess.Interfaces.ICoordinate;
import XXLChess.Interfaces.IMovingService;
import XXLChess.Interfaces.IPlayer;
import XXLChess.Implementations.AbstractPiece;
import XXLChess.Implementations.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class KnightPiece extends AbstractPiece {

    public KnightPiece(ICoordinate coordinate, IPlayer owningPlayer, IMovingService movingService) {
        super(coordinate, owningPlayer, movingService);
    }

    @Override
    public List<ICell> getOptionalMovements(IBoard board) throws Exception {
        List<ICell> optionalMovements = new ArrayList<>();
        int currentX = getCoordinate().getRow();
        int currentY = getCoordinate().getColumn();

        // Define the eight possible knight movement offsets
        int[] xOffset = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] yOffset = {1, 2, 2, 1, -1, -2, -2, -1};

        // Check all eight possible knight movements
        for (int i = 0; i < xOffset.length; i++) {
            int newX = currentX + xOffset[i];
            int newY = currentY + yOffset[i];

            Coordinate coordinate = Coordinate.createInstance(newX, newY, false);
            if (coordinate.isValidCoordinate()) {
                ICell cell = board.getCell(coordinate);
                if (cell.getPieceOnIt() == null || cell.getPieceOnIt().getOwningPlayer() != getOwningPlayer()) {
                    optionalMovements.add(cell);
                }
            }
        }

        // Print the optional movements
        System.out.println("Optional Movements:");
        for (ICell cell : optionalMovements) {
            System.out.println(cell.getCoordinate());
            board.addOptionCells(cell);
        }

        return optionalMovements;
    }
}
