package XXLChess.Implementations;

import XXLChess.Interfaces.IBoard;
import XXLChess.Interfaces.ICell;

public class CpuPlayer extends AbstractPlayer
{

    public CpuPlayer(String name, String color, IBoard board) {
        super(name, color, board);
    }

    @Override
    public void play(ICell cellClicked){
        //time
        //Plays randomly.
        //time
    }

}
