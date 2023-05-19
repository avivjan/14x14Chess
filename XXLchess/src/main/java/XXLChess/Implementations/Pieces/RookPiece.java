package XXLChess.Implementations.Pieces;

import XXLChess.Interfaces.IBoard;
import XXLChess.Interfaces.ICell;
import XXLChess.Interfaces.ICoordinate;
import XXLChess.Interfaces.IMovingService;
import XXLChess.Interfaces.IPlayer;
import XXLChess.Implementations.*;

import java.util.ArrayList;
import java.util.List;

public class RookPiece extends AbstractPiece {
    public RookPiece(ICoordinate coordinate, IPlayer owningPlayer, IMovingService movingService) 
    {
        super(coordinate, owningPlayer, movingService);
    }



    @Override
    public List<ICell> getOptionalMovements(IBoard board) throws Exception {
        List<ICell> optionalMovements = new ArrayList<>();
        int currentX = getCoordinate().getRow();
        int currentY = getCoordinate().getColumn();
    
        checkMovementsInDirection(board, optionalMovements, currentX, currentY, -1, 0); // Upward direction
        checkMovementsInDirection(board, optionalMovements, currentX, currentY, 1, 0); // Downward direction
        checkMovementsInDirection(board, optionalMovements, currentX, currentY, 0, -1); // Left direction
        checkMovementsInDirection(board, optionalMovements, currentX, currentY, 0, 1); // Right direction
        
         // Print the optional movements
         System.out.println("Optional Movements:");
         for (ICell cell : optionalMovements) {
             System.out.println(cell.getCoordinate());
             board.addOptionCells(cell);
         }
    
        return optionalMovements;
    }
    
    private void checkMovementsInDirection(IBoard board, List<ICell> optionalMovements,
                                           int currentX, int currentY, int deltaX, int deltaY) throws Exception {
        int x = currentX + deltaX;
        int y = currentY + deltaY;
    
        while (Coordinate.createInstance(x, y, false).isValidCoordinate()) {
            ICell destinationCell = board.getCell(Coordinate.createInstance(x, y, false));
            if (destinationCell.getPieceOnIt() == null) {
                optionalMovements.add(destinationCell);
            } else if (destinationCell.getPieceOnIt().getOwningPlayer() != getOwningPlayer()) {
                optionalMovements.add(destinationCell);
                break; // Stop checking in this direction if capturing a piece
            } else {
                break; // Stop checking in this direction if blocked by own piece
            }
    
            x += deltaX;
            y += deltaY;
        }
         // Print the optional movements
        System.out.println("Optional Movements:");
        for (ICell cell : optionalMovements) {
            System.out.println(cell.getCoordinate());
            board.addOptionCells(cell);
        }
    }    
}
