package XXLChess.Implementations;

import java.util.ArrayList;
import java.util.List;

import XXLChess.Interfaces.*;;


public class BoardData implements IBoardData {
    private ICell[][] board;
    private ICell selectedCell;
    private List<IPiece> pieces;
    private List<IPlayer> players;
    private int cellSizeInPixels;
    private int numOfCols;
    private int numOfRows;
    private List<ICell> optionCells;
    

    public BoardData(int numOfCols, int numOfrows, int cellSize) {
        selectedCell = null;
        this.numOfCols = numOfCols;
        this.numOfRows = numOfrows;
        this.cellSizeInPixels = cellSize;
        board = new ICell[numOfrows][numOfCols];
        this.pieces = new ArrayList<IPiece>();
        this.players = new ArrayList<IPlayer>();
        optionCells = new ArrayList<ICell>();
    }

    @Override
    public ICell getCell(ICoordinate coordinate) throws Exception {
        int row = coordinate.getRow();
        int col = coordinate.getColumn();
        if (isValidCoordinate(row, col)) {
            return board[row][col];
        }
        throw new Exception("invalid coordinate");
    }

    @Override
    public void addPlayer(IPlayer player) {
        players.add(player);
    }

    @Override
    public IPlayer getPlayer(String color) {
        for (IPlayer player : players) {
            if (player.getColor().equals(color)) {
                return player;
            }
        }
        throw new IllegalArgumentException("No player with color " + color + " found");
    }

    

    @Override
    public ICell getSelectedCell() {
        return selectedCell;
    }

    @Override
    public void setSelectedCell(ICell cell) {
        selectedCell = cell;
    }
    
    @Override
    public void addPiece(IPiece piece, ICoordinate coordinate) {
        pieces.add(piece);
        board[coordinate.getRow()][coordinate.getColumn()].setPieceOnIt(piece);
    }

    @Override
    public void addCell(ICell cell, Coordinate coordinate) {
        board[coordinate.getRow()][coordinate.getColumn()] = cell;
    }

    private boolean isValidCoordinate(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[row].length;
    }

    @Override
    public int getCellSizeInPixels() {
        return cellSizeInPixels;
    }

    @Override
    public int getNumOfCols() {
        return numOfCols;
    }

    @Override
    public int getNumOfRows() {
        return numOfRows;
    }

    @Override
    public List<IPiece> getPieces() {
        return pieces;
    }

    @Override
    public List<ICell> getOptionalCells() {
        return  optionCells;
    }

    @Override
    public void addOptionCells(ICell optionCell) {
        optionCells.add(optionCell);
    }
  
}
