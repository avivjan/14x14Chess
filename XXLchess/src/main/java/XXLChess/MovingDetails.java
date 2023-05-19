package XXLChess;

import XXLChess.Interfaces.ICell;
import XXLChess.Interfaces.IPiece;

public class MovingDetails {
    private double pieceMovementSpeed;
    private int maxMovementTime;
    private IPiece movingPiece;
    private ICell targetCell;

    public MovingDetails(IPiece piece, ICell target) {
        this.movingPiece = piece;
        this.targetCell = target;
        double distance = movingPiece.getCoordinate().getDistanceTo(targetCell.getCoordinate());
        double timeRemainingToReach = distance / pieceMovementSpeed;
        if (timeRemainingToReach > maxMovementTime) {
            timeRemainingToReach = maxMovementTime;
            pieceMovementSpeed = distance / timeRemainingToReach;
        }
    }

    public double getPieceMovementSpeed() {
        return pieceMovementSpeed;
    }

    public void setPieceMovementSpeed(double pieceMovementSpeed) {
        this.pieceMovementSpeed = pieceMovementSpeed;
    }

    public int getMaxMovementTime() {
        return maxMovementTime;
    }

    public void setMaxMovementTime(int maxMovementTime) {
        this.maxMovementTime = maxMovementTime;
    }

    public IPiece getMovingPiece() {
        if (movingPiece == null) {
            throw new NullPointerException("Moving piece is null.");
        }
        return movingPiece;
    }

    public void setMovingPiece(IPiece movingPiece) {
        this.movingPiece = movingPiece;
    }

    public ICell getTargetCell() {
        return targetCell;
    }

    public void setTargetCell(ICell targetCell) {
        this.targetCell = targetCell;
    }
}
