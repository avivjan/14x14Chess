package XXLChess.Implementations.Pieces;

import XXLChess.Interfaces.IBoard;
import XXLChess.Interfaces.ICell;
import XXLChess.Interfaces.ICoordinate;
import XXLChess.Interfaces.IMovingService;
import XXLChess.Interfaces.IPlayer;
import XXLChess.Implementations.*;

import java.util.ArrayList;
import java.util.List;

public class KingPiece extends AbstractPiece {
    public KingPiece(ICoordinate iCoordinate, IPlayer owningPlayer, IMovingService movingService) 
    {
        super(iCoordinate, owningPlayer, movingService);
    }


    @Override
    public List<ICell> getOptionalMovements(IBoard board) throws Exception {
        List<ICell> optionalMovements = new ArrayList<>();
        int currentX = getCoordinate().getRow();
        int currentY = getCoordinate().getColumn();

        // Define the eight possible directions for king movement
        int[] xDirections = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] yDirections = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Check all eight directions for valid movements
        for (int i = 0; i < xDirections.length; i++) {
            int x = currentX + xDirections[i];
            int y = currentY + yDirections[i];

            if (Coordinate.createInstance(x, y, false).isValidCoordinate()) {
                ICell cell = board.getCell(Coordinate.createInstance(x, y, false));
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
