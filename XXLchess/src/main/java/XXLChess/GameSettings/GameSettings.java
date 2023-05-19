package XXLChess.GameSettings;
import XXLChess.Interfaces.IPAppletWrapper;
import processing.data.JSONObject;


public class GameSettings {
    private String layout;
    private TimeDetails timeDetails;
    private String playerColour;
    private float pieceMovementSpeed;
    private int maxMovementTime;

    public GameSettings(JSONObject json, IPAppletWrapper pApplet) {
        layout = json.getString("layout");

        JSONObject timeControlsJson = json.getJSONObject("time_controls");
        int playerSeconds = timeControlsJson.getJSONObject("player").getInt("seconds");
        int playerIncrement = timeControlsJson.getJSONObject("player").getInt("increment");
        int cpuSeconds = timeControlsJson.getJSONObject("cpu").getInt("seconds");
        int cpuIncrement = timeControlsJson.getJSONObject("cpu").getInt("increment");
        timeDetails = new TimeDetails(playerSeconds, playerIncrement, cpuSeconds, cpuIncrement);

        playerColour = json.getString("player_colour");
        pieceMovementSpeed = json.getFloat("piece_movement_speed");
        maxMovementTime = json.getInt("max_movement_time");
    }

    public String getLayout() {
        return layout;
    }

    public TimeDetails getTimeDetails() {
        return timeDetails;
    }

    public String getPlayerColor() {
        return playerColour;
    }

    public float getPieceMovementSpeed() {
        return pieceMovementSpeed;
    }

    public int getMaxMovementTime() {
        return maxMovementTime;
    }
    
}
