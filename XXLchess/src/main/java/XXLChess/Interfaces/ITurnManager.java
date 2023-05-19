package XXLChess.Interfaces;

public interface ITurnManager {
    IPlayer getPlayerInTurn();
    void setPlayerInTurn(IPlayer player);
}