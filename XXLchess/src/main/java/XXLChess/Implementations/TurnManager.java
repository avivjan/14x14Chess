package XXLChess.Implementations;

import XXLChess.GameSettings.GameSettings;
import XXLChess.Interfaces.IBoardData;
import XXLChess.Interfaces.IPlayer;
import XXLChess.Interfaces.ITurnManager;

public class TurnManager implements ITurnManager {
    private IPlayer playerInTurn;

    public TurnManager(IBoardData boardData, GameSettings gameSettings) {
        String playerColor = gameSettings.getPlayerColor();
        if (playerColor.equalsIgnoreCase("white")) {
            playerInTurn = boardData.getPlayer("white");
        } else {
            playerInTurn = boardData.getPlayer("black");
        }
    }

    @Override
    public IPlayer getPlayerInTurn() {
        return playerInTurn;
    }

    @Override
    public void setPlayerInTurn(IPlayer player) {
        playerInTurn = player;
    }
}
