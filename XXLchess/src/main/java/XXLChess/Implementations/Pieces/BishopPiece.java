package XXLChess.Implementations.Pieces;

import XXLChess.Interfaces.IBoard;
import XXLChess.Interfaces.ICell;
import XXLChess.Interfaces.ICoordinate;
import XXLChess.Interfaces.IMovingService;
import XXLChess.Interfaces.IPlayer;
import XXLChess.Implementations.*;

import java.util.ArrayList;
import java.util.List;

public class BishopPiece extends AbstractPiece {
    public BishopPiece(ICoordinate coordinate, IPlayer owningPlayer, IMovingService movingService) 
    {
        super(coordinate, owningPlayer, movingService);
    }


    @Override
    public List<ICell> getOptionalMovements(IBoard board) throws Exception {
        List<ICell> optionalMovements = new ArrayList<>();
        int currentX = getCoordinate().getRow();
        int currentY = getCoordinate().getColumn();

        // Check diagonal movements in all four directions
        checkDiagonalMovements(currentX, currentY, -1, -1, board, optionalMovements); // Top-left
        checkDiagonalMovements(currentX, currentY, -1, 1, board, optionalMovements); // Top-right
        checkDiagonalMovements(currentX, currentY, 1, -1, board, optionalMovements); // Bottom-left
        checkDiagonalMovements(currentX, currentY, 1, 1, board, optionalMovements); // Bottom-right

        // Print the optional movements
        System.out.println("Optional Movements:");
        for (ICell cell : optionalMovements) {
            System.out.println(cell.getCoordinate());
            board.addOptionCells(cell);
        }

        return optionalMovements;
    }

    private void checkDiagonalMovements(int startX, int startY, int xDirection, int yDirection, IBoard board, List<ICell> optionalMovements) throws Exception {
        int x = startX + xDirection;
        int y = startY + yDirection;

        while (isValidCoordinate(x, y, board)) {
            ICell cell = board.getCell(Coordinate.createInstance(x, y, false));
            if (cell.getPieceOnIt() == null) {
                optionalMovements.add(cell);
            } else {
                if (cell.getPieceOnIt().getOwningPlayer() != getOwningPlayer()) {
                    optionalMovements.add(cell);
                }
                break;
            }
            x += xDirection;
            y += yDirection;
        }
    }

    private boolean isValidCoordinate(int x, int y, IBoard board) {
        return x >= 0 && x < board.getNumOfRows() && y >= 0 && y < board.getNumOfCols();
    }
}
