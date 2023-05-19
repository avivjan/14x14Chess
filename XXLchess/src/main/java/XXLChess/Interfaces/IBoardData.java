package XXLChess.Interfaces;


import java.util.List;

import XXLChess.Implementations.Coordinate;

public interface IBoardData {

    ICell getCell(ICoordinate coordinate) throws Exception;

    ICell getSelectedCell();

    void setSelectedCell(ICell cell);

    void addPiece(IPiece piece, ICoordinate coordinate);
    
    int getCellSizeInPixels();

    int getNumOfCols();

    int getNumOfRows();

    void addCell(ICell cell, Coordinate coordinate);

    List<IPiece> getPieces();

    void addPlayer(IPlayer player);

    IPlayer getPlayer(String color);

    List<ICell> getOptionalCells();
    
    void addOptionCells(ICell optionCell);
}