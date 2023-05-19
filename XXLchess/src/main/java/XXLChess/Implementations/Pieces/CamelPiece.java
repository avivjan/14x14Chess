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

public class CamelPiece extends AbstractPiece {

    public CamelPiece(ICoordinate coordinate, IPlayer owningPlayer, IMovingService movingService) {
        super(coordinate, owningPlayer, movingService);
    }

    @Override
    public List<ICell> getOptionalMovements(IBoard board) throws Exception {
        List<ICell> optionalMovements = new ArrayList<>();

        int currentX = getCoordinate().getRow();
        int currentY = getCoordinate().getColumn();

        int[] verticalOffsets = { -3, 3 };
        int[] horizontalOffsets = { -1, 1 };

        for (int verticalOffset : verticalOffsets) {
            for (int horizontalOffset : horizontalOffsets) {
                int targetX = currentX + verticalOffset;
                int targetY = currentY + horizontalOffset;

                Coordinate coordinate = Coordinate.createInstance(targetX, targetY, false);
                if (coordinate.isValidCoordinate()) {
                    ICell targetCell = board.getCell(Coordinate.createInstance(targetX, targetY, false));
                    optionalMovements.add(targetCell);
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
