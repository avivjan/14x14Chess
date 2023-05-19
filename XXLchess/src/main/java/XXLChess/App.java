package XXLChess;

//import org.reflections.Reflections;
//import org.reflections.scanners.Scanners;
import processing.core.PApplet;
import processing.data.JSONObject;
import processing.event.MouseEvent;


import XXLChess.GameSettings.GameSettings;
import XXLChess.Implementations.Board;
import XXLChess.Implementations.BoardData;
import XXLChess.Implementations.ClickEventHandler;
import XXLChess.Implementations.DrawingService;
import XXLChess.Implementations.MovingService;
import XXLChess.Implementations.ObjectsCreator;
import XXLChess.Implementations.PAppletWrapper;
import XXLChess.Implementations.SpriteManager;
import XXLChess.Implementations.TurnManager;
import XXLChess.Interfaces.*;
import XXLChess.Interfaces.IDrawingService;
import XXLChess.Interfaces.IObjectsCreator;
import java.io.*;

public class App extends PApplet {

    public static final int SPRITESIZE = 480;
    public static final int CELLSIZE = 48;
    public static final int SIDEBAR = 120;
    public static final int BOARD_WIDTH = 14;

    public static int WIDTH = CELLSIZE*BOARD_WIDTH+SIDEBAR;
    public static int HEIGHT = BOARD_WIDTH*CELLSIZE;

    public static final int FPS = 60;
	
    public String configPath;

    private IBoard board;
    private IDrawingService drawingService;
    private IObjectsCreator objectsCreator;
    private IPAppletWrapper appletWrapper;
    private IBoardData boardData;
    private GameSettings gameSettings;
    private ISpriteManager spriteManager;
    private IClickEventHandler clickEventHandler;
    private ITurnManager turnManager;
    private IMovingService movingService;

    public App() {
        this.configPath = "config.json";
    }

    /**
     * Initialise the setting of the window size.
    */
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    /**
     * Load all resources such as images. Initialise the elements such as the player, enemies and map elements.
    */
    public void setup() {
        frameRate(FPS);
        this.appletWrapper = new PAppletWrapper(this, configPath);
        this.spriteManager = new SpriteManager(appletWrapper);
        this.boardData = new BoardData(BOARD_WIDTH, BOARD_WIDTH, CELLSIZE);
        this.board = new Board(boardData, gameSettings);
        this.drawingService = new DrawingService(appletWrapper, boardData, spriteManager);
        this.movingService = new MovingService(board);

        JSONObject conf = loadJSONObject(new File(this.configPath));

        this.gameSettings = new GameSettings(conf, appletWrapper);
        this.objectsCreator = new ObjectsCreator(boardData, gameSettings, board, movingService);

        objectsCreator.createPlayers();
        objectsCreator.createCellsOnGameStarted();
        objectsCreator.createPiecesOnGameStarted();
        this.turnManager = new TurnManager(boardData, gameSettings);
        clickEventHandler = new ClickEventHandler(turnManager, board);

        

    }

    /**
     * Receive key pressed signal from the keyboard.
    */
    public void keyPressed(){


    }
    
    /**
     * Receive key released signal from the keyboard.
    */
    public void keyReleased(){

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clickEventHandler.handle(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    /**
     * Draw all elements in the game by current frame. 
    */
    public void draw() 
    {
        try {
            drawingService.draw();
            if(movingService.isMoving())
            {
                movingService.move();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
	
	// Add any additional methods or attributes you want. Please put classes in different files.


    public static void main(String[] args) {
        PApplet.main("XXLChess.App");
    }

}
