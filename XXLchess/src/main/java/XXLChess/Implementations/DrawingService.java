package XXLChess.Implementations;

import java.util.List;

import XXLChess.CellStatus;
import XXLChess.Interfaces.IBoardData;
import XXLChess.Interfaces.ICell;
import XXLChess.Interfaces.ICoordinate;
import XXLChess.Interfaces.IDrawingService;
import XXLChess.Interfaces.IPAppletWrapper;
import XXLChess.Interfaces.IPiece;
import XXLChess.Interfaces.ISpriteManager;
import processing.core.PImage;

public class DrawingService implements IDrawingService {
    private IPAppletWrapper pAppletWrapper;
    private IBoardData boardData;
    private ISpriteManager spriteManager;


    public DrawingService(IPAppletWrapper appletWrapper, IBoardData boardData,
            ISpriteManager spriteManager) {
        this.pAppletWrapper = appletWrapper;
        this.boardData = boardData;
        this.spriteManager = spriteManager;
    }

    @Override
    public void draw() throws Exception {
        pAppletWrapper.background(200);
        pAppletWrapper.fill(250);
        pAppletWrapper.textSize(25);
        drawCells();
        drawPieces();

    }

    private void drawPieces() {
        List<IPiece> pieces = boardData.getPieces();
        for (IPiece piece : pieces) {
            if (piece.isCaptured()) {
                continue;
            }
            PImage sprite = spriteManager.getSprite(piece, piece.getOwningPlayer().getColor());
            ICoordinate coordinate = piece.getCoordinate();

            int pixelX = coordinate.getXInPixels();
            int pixelY = coordinate.getYInPixels();
            // Draw the image
            if (sprite != null) {
                pAppletWrapper.image(sprite, pixelX, pixelY, boardData.getCellSizeInPixels(),
                        boardData.getCellSizeInPixels());
            } else {
                System.out.println("Error: Sprite is null for piece: " + piece.getClass().getSimpleName());
            }

        }
    }

    private void drawCells() throws Exception {
        int numOfCols = boardData.getNumOfCols();
        int numOfrows = boardData.getNumOfRows();
        int cellSize = boardData.getCellSizeInPixels();

        for (int i = 0; i < numOfrows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                int x = i * cellSize;
                int y = j * cellSize;
                decideAColor(i, j);
                pAppletWrapper.rect(x, y, cellSize, cellSize);
            }
        }
    }

    private void decideAColor(int i, int j) throws Exception {
        ICell cell = boardData.getCell(Coordinate.createInstance(i, j, false));
        CellStatus cellStatus = cell.getStatus();
        switch (cellStatus) {
            case Option:
                pAppletWrapper.fill(0, 0, 255); // Blue
                break;
            case OptionWithCapture:
                pAppletWrapper.fill(255, 0, 0); // Red
                break;
            case Selected:
                pAppletWrapper.fill(0, 255, 0); // Green
                break;
            case LastMoveWasFromHere:
                pAppletWrapper.fill(255, 255, 0); // Yellow
                break;
            case LastMoveWasToHere:
                pAppletWrapper.fill(255, 255, 0); // Yellow
                break;
            case None:
                if ((i + j) % 2 == 0) {
                    pAppletWrapper.fill(255, 235, 205);
                } else {
                    pAppletWrapper.fill(200, 150, 50);
                }
                break;
            default:
                throw new Exception("Invalid cell status");
        }
    }
}
