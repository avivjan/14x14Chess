package XXLChess.Implementations;

import XXLChess.Interfaces.IBoard;
import XXLChess.Interfaces.IBoardData;
import XXLChess.Interfaces.ICell;
import XXLChess.Interfaces.IMovingService;
import XXLChess.Interfaces.IObjectsCreator;
import XXLChess.Interfaces.IPiece;
import XXLChess.Interfaces.IPlayer;
import XXLChess.*;
import XXLChess.GameSettings.GameSettings;
import XXLChess.Implementations.Pieces.*;

public class ObjectsCreator implements IObjectsCreator {
    private IBoardData boardData;
    private IPlayer player;
    private IPlayer cpu;
    private GameSettings gameSettings;
    private IBoard board;
    private IMovingService movingService;

    public ObjectsCreator(IBoardData boardData, GameSettings gameSettings, IBoard board, IMovingService movingService) {
        this.board = board;
        this.boardData = boardData;
        this.gameSettings = gameSettings;
        this.movingService = movingService;
    }

    @Override
    public void createPlayers() {
        player = new HumanPlayer("player", gameSettings.getPlayerColor(), board);
        cpu = new CpuPlayer("cpu", gameSettings.getPlayerColor().equals("white") ? "black" : "white", board);
        boardData.addPlayer(player);
        boardData.addPlayer(cpu);
    }

    @Override
    public void createPiecesOnGameStarted() {
        Coordinate tempCor;
        IPiece piece;

        for (int i = 0; i < 14; i++) {
            tempCor = Coordinate.createInstance(i, (14 - 2), false);
            piece = new PawnPiece(tempCor, player, movingService);
            boardData.addPiece(piece, tempCor);
        }

        for (int i = 0; i < 14; i++) {
            tempCor = Coordinate.createInstance(i, 1, false);
            piece = new PawnPiece(tempCor, cpu, movingService);
            boardData.addPiece(piece, tempCor);
        }

        // Creating and adding Rooks
        tempCor = Coordinate.createInstance(0, (14 - 1), false);
        piece = new RookPiece(tempCor, player, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(13, (14 - 1), false);
        piece = new RookPiece(tempCor, player, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(0, 0, false);
        piece = new RookPiece(tempCor, cpu, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(13, 0, false);
        piece = new RookPiece(tempCor, cpu, movingService);
        boardData.addPiece(piece, tempCor);


        // Creating and adding Knight
        tempCor = Coordinate.createInstance(1, (14 - 1), false);
        piece = new KnightPiece(tempCor, player, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(12, (14 - 1), false);
        piece = new KnightPiece(tempCor, player, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(1, 0, false);
        piece = new KnightPiece(tempCor, cpu, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(12, 0, false);
        piece = new KnightPiece(tempCor, cpu, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(2, (14 - 1), false);
        piece = new BishopPiece(tempCor, player, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(11, (14 - 1), false);
        piece = new BishopPiece(tempCor, player, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(2, 0, false);
        piece = new BishopPiece(tempCor, cpu, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(11, 0, false);
        piece = new BishopPiece(tempCor, cpu, movingService);
        boardData.addPiece(piece, tempCor);


        // Add Archbishops 
        tempCor = Coordinate.createInstance(3, 13, false);
        piece = new ArchbishopPiece(tempCor, player, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(3, 0, false);
        piece = new ArchbishopPiece(tempCor, cpu, movingService);
        boardData.addPiece(piece, tempCor);

        // Add Chancellors
        tempCor = Coordinate.createInstance(10, 13, false);
        piece = new ChancellorPiece(tempCor, player, movingService);
        boardData.addPiece(piece, tempCor);

        // Add Chancellors
        tempCor = Coordinate.createInstance(10, 10, false);
        piece = new QueenPiece(tempCor, player, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(10, 0, false);
        piece = new ChancellorPiece(tempCor, cpu, movingService);
        boardData.addPiece(piece, tempCor);


        // Add Camels 
        tempCor = Coordinate.createInstance(4, 0, false);
        piece = new CamelPiece(tempCor, cpu, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(9, 0, false);
        piece = new CamelPiece(tempCor, cpu, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(4, 14 - 1, false);
        piece = new CamelPiece(tempCor, player, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(9, 14 - 1, false);
        piece = new CamelPiece(tempCor, player, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(6, 0, false);
        piece = new AmazonPiece(tempCor, cpu, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(6, 13, false);
        piece = new AmazonPiece(tempCor, player, movingService);
        boardData.addPiece(piece, tempCor);



        // Add knightKing
        tempCor = Coordinate.createInstance(5, 0, false);
        piece = new KnightKingPiece(tempCor, cpu, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(8, 0, false);
        piece = new KnightKingPiece(tempCor, cpu, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(5, 13, false);
        piece = new KnightKingPiece(tempCor, player, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(8, 13, false);
        piece = new KnightKingPiece(tempCor, player, movingService);
        boardData.addPiece(piece, tempCor);



        // add Kings
        tempCor = Coordinate.createInstance(7, 0, false);
        piece = new KingPiece(tempCor, cpu, movingService);
        boardData.addPiece(piece, tempCor);

        tempCor = Coordinate.createInstance(7, 13, false);
        piece = new KingPiece(tempCor, player, movingService);
        boardData.addPiece(piece, tempCor);
    }

    @Override
    public void createCellsOnGameStarted() {
        for (int row = 0; row < 14; row++) {
            for (int col = 0; col < 14; col++) {
                ICell cell = new Cell(CellStatus.None, false, null, Coordinate.createInstance(row, col, false));
                boardData.addCell(cell, Coordinate.createInstance(row, col, false));
            }
        }
    }
}
