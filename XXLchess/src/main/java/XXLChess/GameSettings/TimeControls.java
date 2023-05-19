package XXLChess.GameSettings;

class TimeDetails {
    private int playerRemainingSeconds;
    private int playerIncrementSecAfterMove;
    private int cpuRemainingSeconds;
    private int cpuIncrementSecAfterMove;


    public TimeDetails(int playerRemainingSeconds, int playerIncrementSecAfterMove, int cpuRemainingSeconds, int cpuIncrementSecAfterMove) {
        this.playerRemainingSeconds = playerRemainingSeconds;
        this.playerIncrementSecAfterMove = playerIncrementSecAfterMove;
        this.cpuRemainingSeconds = cpuRemainingSeconds;
        this.cpuIncrementSecAfterMove = cpuIncrementSecAfterMove;
    }

    public int getPlayerRemainingSeconds() {
        return playerRemainingSeconds;
    }

    public void setPlayerRemainingSeconds(int playerRemainingSeconds) {
        this.playerRemainingSeconds = playerRemainingSeconds;
    }

    public int getPlayerIncrementSecAfterMove() {
        return playerIncrementSecAfterMove;
    }

    public void setPlayerIncrementSecAfterMove(int playerIncrementSecAfterMove) {
        this.playerIncrementSecAfterMove = playerIncrementSecAfterMove;
    }

    public int getCpuRemainingSeconds() {
        return cpuRemainingSeconds;
    }

    public void setCpuRemainingSeconds(int cpuRemainingSeconds) {
        this.cpuRemainingSeconds = cpuRemainingSeconds;
    }

    public int getCpuIncrementSecAfterMove() {
        return cpuIncrementSecAfterMove;
    }

    public void setCpuIncrementSecAfterMove(int cpuIncrementSecAfterMove) {
        this.cpuIncrementSecAfterMove = cpuIncrementSecAfterMove;
    }
}
