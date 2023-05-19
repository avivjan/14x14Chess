package XXLChess.Implementations;

import XXLChess.Interfaces.IBoard;
import XXLChess.Interfaces.ICell;
import XXLChess.Interfaces.IMovingService;
import XXLChess.Interfaces.IPiece;

import XXLChess.MovingDetails;

public class MovingService implements IMovingService {
    private MovingDetails movingDetails;
    private IBoard board;
    public MovingService(IBoard board) {
        this.board = board;
    }

    @Override
    public void move() throws Exception {
        if (movingDetails == null ) {
            return;
        }
        IPiece movingPiece = movingDetails.getMovingPiece();
        ICell targetCell = movingDetails.getTargetCell();

        if (movingPiece == null) {
            throw new NullPointerException("Moving piece is null.");
        }
        if (targetCell == null) {
            throw new NullPointerException("Target cell is null.");
        }

        // Update the piece's position based on the movement speed and time
        double speed = movingDetails.getPieceMovementSpeed();
        double distance = movingPiece.getCoordinate().getDistanceTo(targetCell.getCoordinate());

        //move
        int currentX = movingPiece.getCoordinate().getXInPixels();
        int currentY = movingPiece.getCoordinate().getYInPixels();

        int targetX = targetCell.getCoordinate().getXInPixels();
        int targetY = targetCell.getCoordinate().getYInPixels();

        int deltaX = targetX - currentX;
        int deltaY = targetY - currentY;

        int newX = currentX;
        int newY = currentY;

        if (distance > speed) {
            Double vx = deltaX / distance * speed;
            Double vy = deltaY / distance * speed;
            newX += vx;
            newY += vy;
          } else {
            newX = targetX;
            newY = targetY;
          }
        
        if (Coordinate.isOnBoard(newX, newY) == false) {
            throw new Exception(" piece is moving out of the board.");
        }

        movingPiece.setCoordinate(Coordinate.createInstance(newX, newY, true));

        if (hasReached())
        {
            movingPiece.setCoordinate(targetCell.getCoordinate());
            movingDetails = null;
            board.DeselectCellIfExists();
        }
    }

    private boolean hasReached() {
        IPiece movingPiece = movingDetails.getMovingPiece();
        ICell targetCell = movingDetails.getTargetCell();

        return movingPiece.getCoordinate().getDistanceTo(targetCell.getCoordinate()) < 0.01;
    }

    @Override
    public void setMovingDetails(MovingDetails movingDetails) {
        this.movingDetails = movingDetails;
    }

    @Override
    public boolean isMoving() {
        return movingDetails != null;
    }

    @Override
    public boolean isMoving(IPiece piece) {
        return movingDetails != null && movingDetails.getMovingPiece() == piece;
    }
}
