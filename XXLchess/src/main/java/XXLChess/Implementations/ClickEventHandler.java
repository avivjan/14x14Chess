package XXLChess.Implementations;

import XXLChess.Interfaces.IBoard;
import XXLChess.Interfaces.IClickEventHandler;
import XXLChess.Interfaces.IPlayer;
import XXLChess.Interfaces.ITurnManager;
import processing.event.MouseEvent;

public class ClickEventHandler implements IClickEventHandler {
    private ITurnManager turnManager;
    private IBoard board;

    public ClickEventHandler(ITurnManager turnManager, IBoard board) {
        this.turnManager = turnManager;
        this.board = board;
    }

    @Override
    public void handle(MouseEvent event) {
        try {
            IPlayer playerInTurn = turnManager.getPlayerInTurn();
            if (playerInTurn instanceof CpuPlayer) {
                System.err.println("Cpu player is in turn. Click event is ignored.");
                return;
            }
            Coordinate coordinateClicked = Coordinate.createInstance(event.getX(), event.getY(), true);
            if (coordinateClicked == null) {
                System.out.println("Clicked on the sidebar");
                return;
            }
            playerInTurn.play(board.getCell(coordinateClicked));
        } catch (Exception e) {
            System.err.println("Error in ClickEventHandler.handleMouseClickEvent");
            e.printStackTrace();
        }
    }
}
