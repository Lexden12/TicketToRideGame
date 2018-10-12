package ttr.up.edu.tickettoride;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import ttr.up.edu.game.GamePlayer;

public class TTRGameState implements Cloneable{
    //general information
    private TrainDeck boardTrainDeck;
    private TrainDeck boardFaceupTrainDeck;
    private RouteDeck boardRouteDeck;

    private ArrayList<TTRGamePlayer> players;
    private TTRGamePlayer activePlayer;

    private String notification;

    //player specific information
    HashMap<TTRGamePlayer, TrainStash> playerTrainStashes = new HashMap<TTRGamePlayer, TrainStash>();
    HashMap<TTRGamePlayer, TrainDeck> playerTrainDecks = new HashMap<TTRGamePlayer, TrainDeck>();
    HashMap<TTRGamePlayer, RouteDeck> playerRouteDecks = new HashMap<TTRGamePlayer, RouteDeck>();
    HashMap<TTRGamePlayer, RouteDeck> playerClaimedRouteDecks = new HashMap<TTRGamePlayer, RouteDeck>();
    HashMap<TTRGamePlayer, Integer> playerScores = new HashMap<TTRGamePlayer, Integer>();

    //todo implement constructors
    public TTRGameState() {

    }

    public TTRGameState(TTRGameState gameState){
        try {
            TTRGameState gameStateCopy = (TTRGameState) gameState.clone();
        }catch(CloneNotSupportedException ex){};
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        TTRGameState gameState = (TTRGameState) super.clone();

        gameState.setBoardTrainDeck((TrainDeck) this.boardTrainDeck.clone());
        gameState.setBoardFaceupTrainDeck((TrainDeck) this.boardFaceupTrainDeck.clone());
        gameState.setBoardRouteDeck((RouteDeck) this.boardRouteDeck.clone());
        gameState.setActivePlayer((TTRGamePlayer) this.activePlayer.clone());
        gameState.setNotification(notification.substring(0));

        ArrayList<TTRGamePlayer> playersCopy = new ArrayList<TTRGamePlayer>();
        gameState.setPlayers(playersCopy);
        HashMap<TTRGamePlayer, TrainStash> playerTrainStashesCopy = new HashMap<TTRGamePlayer, TrainStash>();
        gameState.setPlayerTrainStashes(playerTrainStashesCopy);
        HashMap<TTRGamePlayer, TrainDeck> playerTrainDecksCopy = new HashMap<TTRGamePlayer, TrainDeck>();
        gameState.setPlayerTrainDecks(playerTrainDecksCopy);
        HashMap<TTRGamePlayer, RouteDeck> playerRouteDecksCopy = new HashMap<TTRGamePlayer, RouteDeck>();
        gameState.setPlayerRouteDecks(playerRouteDecksCopy);
        HashMap<TTRGamePlayer, RouteDeck> playerClaimedRouteDecksCopy = new HashMap<TTRGamePlayer, RouteDeck>();
        gameState.setPlayerClaimedRouteDecks(playerClaimedRouteDecksCopy);
        HashMap<TTRGamePlayer, Integer> playerScoresCopy = new HashMap<TTRGamePlayer, Integer>();
        gameState.setPlayerScores(playerScoresCopy);

        for (TTRGamePlayer player: this.players){
            playersCopy.add((TTRGamePlayer) player.clone());
            playerTrainStashesCopy.put((TTRGamePlayer) player.clone(), (TrainStash) ( (TrainStash) playerTrainStashes.get(player) ).clone());
            playerTrainDecksCopy.put((TTRGamePlayer) player.clone(), (TrainDeck) ( (TrainDeck) playerTrainDecks.get(player) ).clone());
            playerRouteDecksCopy.put((TTRGamePlayer) player.clone(), (RouteDeck) ( (RouteDeck) playerRouteDecks.get(player) ).clone());
            playerClaimedRouteDecksCopy.put((TTRGamePlayer) player.clone(), (RouteDeck) ( (RouteDeck) playerClaimedRouteDecks.get(player) ).clone());
            playerScoresCopy.put((TTRGamePlayer) player.clone(), new Integer( ((Integer) playerScores.get(player)).intValue()) );
        }



        return gameState;
    }

    @Override
    public String toString(){
        String toReturn = "";
        toReturn += "Board Train Deck: " + this.boardTrainDeck.toString();
        toReturn += "\n\n";
        toReturn += "Board Faceup Train Deck: " + this.boardFaceupTrainDeck.toString();
        toReturn += "\n\n";
        toReturn += "Board Route Deck: " + this.boardRouteDeck.toString();
        toReturn += "\n\n";
        toReturn += "Active Player: " + this.activePlayer.toString();
        toReturn += "\n\n";
        toReturn += "Notification: " + this.notification.toString();
        toReturn += "\n\n\n";

        toReturn += "Player Information: ";
        toReturn += "------------------------";
        toReturn += "\n\n";
        for (TTRGamePlayer player: this.players){
            toReturn += player.toString();
            toReturn += "\n";
            toReturn += "Train Stash: " + ((TrainStash) playerTrainStashes.get(player)).toString();
            toReturn += "\n";
            toReturn += "Train Cards: " + ((TrainDeck) playerTrainDecks.get(player)).toString();
            toReturn += "\n";
            toReturn += "Route Cards: " + ((RouteDeck) playerRouteDecks.get(player)).toString();
            toReturn += "\n";
            toReturn += "Completed Routes: " + ((RouteDeck) playerClaimedRouteDecks.get(player)).toString();
            toReturn += "\n";
            toReturn += "Score: " + ((Integer) playerScores.get(player)).toString();

            toReturn += "\n\n";
        }



        return toReturn;
    }


    /**
     * Getters:
     */
    public TrainDeck getBoardTrainDeck() {
        return boardTrainDeck;
    }

    public TrainDeck getBoardFaceupTrainDeck() {
        return boardFaceupTrainDeck;
    }


    public RouteDeck getBoardRouteDeck() {
        return boardRouteDeck;
    }

    public ArrayList<TTRGamePlayer> getPlayers() {
        return players;
    }

    public GamePlayer getActivePlayer() {
        return activePlayer;
    }


    public String getNotification() {
        return notification;
    }

    public HashMap<TTRGamePlayer, TrainStash> getPlayerTrainStashes() {
        return playerTrainStashes;
    }

    public HashMap<TTRGamePlayer, TrainDeck> getPlayerTrainDecks() {
        return playerTrainDecks;
    }

    public HashMap<TTRGamePlayer, RouteDeck> getPlayerRouteDecks() {
        return playerRouteDecks;
    }

    public HashMap<TTRGamePlayer, RouteDeck> getPlayerClaimedRouteDecks() {
        return playerClaimedRouteDecks;
    }

    public HashMap<TTRGamePlayer, Integer> getPlayerScores() {
        return playerScores;
    }

    /**
     *Setters
     */
    public void setNotification(String notification) {
        this.notification = notification;
    }

    public void setActivePlayer(TTRGamePlayer activePlayer) {
        this.activePlayer = activePlayer;
    }

    public void setBoardTrainDeck(TrainDeck boardTrainDeck) {
        this.boardTrainDeck = boardTrainDeck;
    }

    public void setBoardFaceupTrainDeck(TrainDeck boardFaceupTrainDeck) {
        this.boardFaceupTrainDeck = boardFaceupTrainDeck;
    }

    public void setBoardRouteDeck(RouteDeck boardRouteDeck) {
        this.boardRouteDeck = boardRouteDeck;
    }

    public void setPlayers(ArrayList<TTRGamePlayer> players) {
        this.players = players;
    }

    public void setPlayerTrainStashes(HashMap<TTRGamePlayer, TrainStash> playerTrainStashes) {
        this.playerTrainStashes = playerTrainStashes;
    }

    public void setPlayerTrainDecks(HashMap<TTRGamePlayer, TrainDeck> playerTrainDecks) {
        this.playerTrainDecks = playerTrainDecks;
    }

    public void setPlayerRouteDecks(HashMap<TTRGamePlayer, RouteDeck> playerRouteDecks) {
        this.playerRouteDecks = playerRouteDecks;
    }

    public void setPlayerClaimedRouteDecks(HashMap<TTRGamePlayer, RouteDeck> playerClaimedRouteDecks) {
        this.playerClaimedRouteDecks = playerClaimedRouteDecks;
    }

    public void setPlayerScores(HashMap<TTRGamePlayer, Integer> playerScores) {
        this.playerScores = playerScores;
    }
}
