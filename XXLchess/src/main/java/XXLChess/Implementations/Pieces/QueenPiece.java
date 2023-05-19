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

public class QueenPiece extends AbstractPiece {

    public QueenPiece(ICoordinate coordinate, IPlayer owningPlayer, IMovingService movingService) {
        super(coordinate, owningPlayer, movingService);
    }

    @Override
    public List<ICell> getOptionalMovements(IBoard board) throws Exception {
        List<ICell> optionalMovements = new ArrayList<>();
        int currentX = getCoordinate().getRow();
        int currentY = getCoordinate().getColumn();

        // Define the eight possible directions for queen movement
        int[] xDirections = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] yDirections = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Check all eight directions for valid movements
        for (int i = 0; i < xDirections.length; i++) {
            int x = currentX;
            int y = currentY;

            // Continue moving in the current direction until the end of the board is reached or an obstacle is encountered
            while (true) {
                x += xDirections[i];
                y += yDirections[i];

                Coordinate coordinate = Coordinate.createInstance(x, y, false);
                if (coordinate.isValidCoordinate()) {
                    ICell cell = board.getCell(coordinate);
                    if (cell.getPieceOnIt() == null || cell.getPieceOnIt().getOwningPlayer() != getOwningPlayer()) {
                        optionalMovements.add(cell);
                    }

                    // Stop if an obstacle is encountered
                    if (cell.getPieceOnIt() != null) {
                        break;
                    }
                } else {
                    // Stop if the end of the board is reached
                    break;
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
