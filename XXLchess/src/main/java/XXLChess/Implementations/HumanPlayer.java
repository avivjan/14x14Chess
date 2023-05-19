package XXLChess.Implementations;

import XXLChess.CellStatus;
import XXLChess.Interfaces.IBoard;
import XXLChess.Interfaces.ICell;
import XXLChess.Interfaces.IPiece;

public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(String name, String color, IBoard board) {
        super(name, color, board);
    }

    @Override
    public void play(ICell cellClicked) {
        try {
            CellStatus cellStatus = cellClicked.getStatus();
            

            if (cellStatus == CellStatus.Selected) {
                board.DeselectCellIfExists();
                return;
            }
            if (cellStatus == CellStatus.Option || cellStatus == CellStatus.OptionWithCapture) {
                if (cellStatus == CellStatus.OptionWithCapture)
                {
                    //capture
                    cellClicked.getPieceOnIt().capture();
                    cellClicked.setPieceOnIt(null);
                }
                //move
                ICell moveFrom =  board.getSelectedCell();
                ICell moveTo = cellClicked;
                IPiece pieceToMove = moveFrom.getPieceOnIt();

                pieceToMove.startMoving(moveTo);
                board.DeselectCellIfExists();
                moveFrom.setPieceOnIt(null);
                moveTo.setPieceOnIt(pieceToMove);
            }
            if (!cellClicked.canBeSelected()) {
                System.out.println("Cell cannot be selected");
                return;
            }
            // Here we know that the cell is not selected, can be selected and is not an
            // option.
            if (board.getSelectedCell() != null) {
                board.selectCell(cellClicked);
                return;
            }
            board.selectCell(cellClicked);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
