package XXLChess.Implementations;

import processing.core.PImage;
import XXLChess.Implementations.Pieces.*;
import XXLChess.Interfaces.IPAppletWrapper;
import XXLChess.Interfaces.IPiece;
import XXLChess.Interfaces.ISpriteManager;

public class SpriteManager implements ISpriteManager {
    private PImage blackPawn;
    private PImage blackRook;
    private PImage blackKnight;
    private PImage blackBishop;
    private PImage blackArchbishop;
    private PImage blackCamel;
    private PImage blackKnightKing;
    private PImage blackAmazon;
    private PImage blackKing;
    private PImage blackChancellor;
    private PImage blackQueen;
    
    private PImage whitePawn;
    private PImage whiteRook;
    private PImage whiteKnight;
    private PImage whiteBishop;
    private PImage whiteArchbishop;
    private PImage whiteCamel;
    private PImage whiteKnightKing;
    private PImage whiteKing;
    private PImage whiteChancellor;
    private PImage whiteAmazon;
    private PImage whiteQueen;

    public SpriteManager(IPAppletWrapper pAppletWrapper) {
        blackRook = pAppletWrapper.loadImage("src/main/resources/XXLChess/b-rook.png");// TODO: change to relative path
        blackKnight = pAppletWrapper.loadImage("src/main/resources/XXLChess/b-knight.png");
        blackBishop = pAppletWrapper.loadImage("src/main/resources/XXLChess/b-bishop.png");
        blackArchbishop = pAppletWrapper.loadImage("src/main/resources/XXLChess/b-archbishop.png");
        blackCamel = pAppletWrapper.loadImage("src/main/resources/XXLChess/b-camel.png");
        blackKnightKing = pAppletWrapper.loadImage("src/main/resources/XXLChess/b-knight-king.png");
        blackAmazon = pAppletWrapper.loadImage("src/main/resources/XXLChess/b-amazon.png");
        blackKing = pAppletWrapper.loadImage("src/main/resources/XXLChess/b-king.png");
        blackChancellor = pAppletWrapper.loadImage("src/main/resources/XXLChess/b-chancellor.png");
        blackPawn = pAppletWrapper.loadImage("src/main/resources/XXLChess/b-pawn.png");
        blackQueen = pAppletWrapper.loadImage("src/main/resources/XXLChess/b-queen.png");

        whitePawn = pAppletWrapper.loadImage("src/main/resources/XXLChess/w-pawn.png");
        whiteRook = pAppletWrapper.loadImage("src/main/resources/XXLChess/w-rook.png");
        whiteKnight = pAppletWrapper.loadImage("src/main/resources/XXLChess/w-knight.png");
        whiteBishop = pAppletWrapper.loadImage("src/main/resources/XXLChess/w-bishop.png");
        whiteArchbishop = pAppletWrapper.loadImage("src/main/resources/XXLChess/w-archbishop.png");
        whiteCamel = pAppletWrapper.loadImage("src/main/resources/XXLChess/w-camel.png");
        whiteKnightKing = pAppletWrapper.loadImage("src/main/resources/XXLChess/w-knight-king.png");
        whiteKing = pAppletWrapper.loadImage("src/main/resources/XXLChess/w-king.png");
        whiteChancellor = pAppletWrapper.loadImage("src/main/resources/XXLChess/w-chancellor.png");
        whiteAmazon = pAppletWrapper.loadImage("src/main/resources/XXLChess/w-amazon.png");
        whiteQueen = pAppletWrapper.loadImage("src/main/resources/XXLChess/w-queen.png");
    }

    public PImage getSprite(IPiece piece, String color) {
        if (piece instanceof PawnPiece) {
            if (color.equals("black")) {
                return blackPawn;
            } else if (color.equals("white")) {
                return whitePawn;
            }
        } else if (piece instanceof RookPiece) {
            if (color.equals("black")) {
                return blackRook;
            } else if (color.equals("white")) {
                return whiteRook;
            }
        } else if (piece instanceof KnightPiece) {
            if (color.equals("black")) {
                return blackKnight;
            } else if (color.equals("white")) {
                return whiteKnight;
            }
        } else if (piece instanceof BishopPiece) {
            if (color.equals("black")) {
                return blackBishop;
            } else if (color.equals("white")) {
                return whiteBishop;
            }
        } else if (piece instanceof ArchbishopPiece) {
            if (color.equals("black")) {
                return blackArchbishop;
            } else if (color.equals("white")) {
                return whiteArchbishop;
            }
        } else if (piece instanceof CamelPiece) {
            if (color.equals("black")) {
                return blackCamel;
            } else if (color.equals("white")) {
                return whiteCamel;
            }
        } else if (piece instanceof KnightKingPiece) {
            if (color.equals("black")) {
                return blackKnightKing;
            } else if (color.equals("white")) {
                return whiteKnightKing;
            }
        } else if (piece instanceof AmazonPiece) {
            if (color.equals("black")) {
                return blackAmazon;
            } else if (color.equals("white")) {
                return whiteAmazon;
            }
        } else if (piece instanceof KingPiece) {
            if (color.equals("black")) {
                return blackKing;
            } else if (color.equals("white")) {
                return whiteKing;
            }
        } else if (piece instanceof ChancellorPiece) {
            if (color.equals("black")) {
                return blackChancellor;
            } else if (color.equals("white")) {
                return whiteChancellor;
            }
        } else if (piece instanceof QueenPiece) {
            if (color.equals("black")) {
                return blackQueen;
            } else if (color.equals("white")) {
                return whiteQueen;
            }
        }

        throw new IllegalArgumentException(
                "Invalid piece type or color: " + piece.getClass().getSimpleName() + ", " + color);
    }
}
