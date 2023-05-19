package XXLChess.Interfaces;


public interface IPlayer
{
    String getName();

    void play(ICell cellClicked);
    
    String getColor();
}
