package XXLChess;

public enum CellStatus {
    None,
    Option,
    OptionWithCapture,
    Selected,
    LastMoveWasFromHere,
    LastMoveWasToHere,
    Check,
    Checkmate,
    Checking,
    Checkmating
}
