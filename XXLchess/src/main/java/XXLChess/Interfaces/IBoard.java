package XXLChess.Interfaces;


public interface IBoard {
    ICell getCell(ICoordinate coordinate) throws Exception;
    ICell getSelectedCell();
    void setSelectedCell(ICell cell);
    int getNumOfRows();
    int getNumOfCols();
    float getMaxMoveDuration();
    float getMovingSpeed();
    void selectCell(ICell cell);
    void DeselectCellIfExists();
    void addOptionCells(ICell optionCell);
}
