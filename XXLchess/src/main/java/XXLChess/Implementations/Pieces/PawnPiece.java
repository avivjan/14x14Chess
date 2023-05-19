package XXLChess.Implementations.Pieces;

import XXLChess.Interfaces.IBoard;
import XXLChess.Interfaces.ICell;
import XXLChess.Interfaces.ICoordinate;
import XXLChess.Interfaces.IMovingService;
import XXLChess.Interfaces.IPlayer;
import XXLChess.Implementations.*;

import java.util.ArrayList;
import java.util.List;

public class PawnPiece extends AbstractPiece {

    public PawnPiece(ICoordinate coordinate, IPlayer owningPlayer, IMovingService movingService) {
        super(coordinate, owningPlayer, movingService);
    }

    @Override
    public List<ICell> getOptionalMovements(IBoard board) throws Exception {
        List<ICell> optionalMovements = new ArrayList<>();
        int currentX = getCoordinate().getRow();
        int currentY = getCoordinate().getColumn();

        // Determine the direction of movement based on the player's color
        int direction = getOwningPlayer().getColor().equals("white") ? -1 : 1;

        // Check the forward movement
        int forwardY = currentY + direction;
        if (isValidCoordinate(currentX, forwardY, board)) {
            ICell forwardCell = board.getCell(Coordinate.createInstance(currentX, forwardY, false));
            if (forwardCell.getPieceOnIt() == null) {
                optionalMovements.add(forwardCell);

                // Check the double forward movement from the starting position
                System.err.println(currentY);
                if ((currentY == 1 && direction == 1) || (currentY == 12 && direction == -1)) {
                    int doubleForwardY = currentY + 2 * direction;
                    ICell doubleForwardCell = board.getCell(Coordinate.createInstance(currentX, doubleForwardY, false));
                    if (doubleForwardCell.getPieceOnIt() == null) {
                        optionalMovements.add(doubleForwardCell);
                    }
                }
            }
        }

        // Check diagonal capture movements
        int[] captureXOffsets = { -1, 1 };
        for (int xOffset : captureXOffsets) {
            int captureX = currentX + xOffset;
            int captureY = currentY + direction;
            if (isValidCoordinate(captureX, captureY, board)) {
                ICell captureCell = board.getCell(Coordinate.createInstance(captureX, captureY, false));
                if (captureCell.getPieceOnIt() != null
                        && captureCell.getPieceOnIt().getOwningPlayer() != getOwningPlayer()) {
                    optionalMovements.add(captureCell);
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

    private boolean isValidCoordinate(int x, int y, IBoard board) {
        return x >= 0 && x < board.getNumOfRows() && y >= 0 && y < board.getNumOfCols();
    }

}
