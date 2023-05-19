package XXLChess.Interfaces;

import XXLChess.MovingDetails;

public interface IMovingService
{
    void move() throws Exception;
    void setMovingDetails(MovingDetails movingDetails);
    boolean isMoving(); 
    boolean isMoving(IPiece piece); 
}
