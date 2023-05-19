package XXLChess.Implementations;

import XXLChess.CellStatus;
import XXLChess.GameSettings.GameSettings;
import XXLChess.Interfaces.IBoard;
import XXLChess.Interfaces.ICell;
import XXLChess.Interfaces.ICoordinate;
import XXLChess.Interfaces.IBoardData;

public class Board implements IBoard {
    private IBoardData boardData;
    private GameSettings gameSettings;
    

    public Board(IBoardData boardData, GameSettings gameSettings) {
        this.boardData = boardData;
        boardData.getCellSizeInPixels();
        Coordinate.SetNumOfRows(boardData.getNumOfRows());
        Coordinate.SetNumOfCols(boardData.getNumOfCols());
        this.gameSettings = gameSettings;
    }

    @Override
    public ICell getCell(ICoordinate coordinate) throws Exception {
        return boardData.getCell(coordinate);
    }

    @Override
    public ICell getSelectedCell() {
        return boardData.getSelectedCell();
    }

    @Override
    public void setSelectedCell(ICell cell) {
        boardData.setSelectedCell(cell);
    }
    @Override
    public int getNumOfCols() {
        return boardData.getNumOfCols();
    }

    @Override
    public int getNumOfRows() {
        return boardData.getNumOfRows();
    }

    @Override
    public float getMaxMoveDuration() {
        return gameSettings.getMaxMovementTime();
    }

    @Override
    public float getMovingSpeed() {
        return gameSettings.getPieceMovementSpeed();
    }

    @Override
    public void DeselectCellIfExists() {
        try {
            ICell selectedCell = getSelectedCell();
            if (selectedCell == null) {
                return;
            }
            for (ICell optional : boardData.getOptionalCells())
            {
                optional.setStatus(CellStatus.None);
            }
            if (selectedCell != null) {
                selectedCell.setStatus(CellStatus.None);
                setSelectedCell(null);
                System.out.println("Cell " + selectedCell.getCoordinate() + " deselected");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectCell(ICell cell) {
        try {
            DeselectCellIfExists();
            cell.setStatus(CellStatus.Selected);
            setSelectedCell(cell);
            for (ICell optionalCell : cell.getPieceOnIt().getOptionalMovements(this)) {
                if (optionalCell.getPieceOnIt() != null && optionalCell.getPieceOnIt().getOwningPlayer() != this ) {
                    optionalCell.setStatus(CellStatus.OptionWithCapture);
                    System.out.println("Cell " + optionalCell.getCoordinate() + " is an option with capture");
                    continue;
                }
                optionalCell.setStatus(CellStatus.Option);
                System.out.println("Cell " + optionalCell.getCoordinate() + " is an option");
            }

            System.out.println("Cell " + cell.getCoordinate() + "selected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOptionCells(ICell optionCell) {
        boardData.addOptionCells(optionCell);
    }
}
