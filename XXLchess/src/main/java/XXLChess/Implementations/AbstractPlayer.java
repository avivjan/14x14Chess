package XXLChess.Implementations;

import XXLChess.Interfaces.IBoard;
import XXLChess.Interfaces.ICell;
import XXLChess.Interfaces.IPlayer;


public abstract class AbstractPlayer implements IPlayer {
    private String name;
    private String color;
    protected IBoard board;
    
    

    public AbstractPlayer(String name, String color, IBoard board) {
        this.name = name;
        this.color = color;
        this.board = board;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getName() {
        return name;
    }

    

    @Override
    public abstract void play(ICell cellClicked);
}





