package ttr.up.edu.tickettoride;

import java.util.ArrayList;

import ttr.up.edu.game.GamePlayer;

public class TTR_GameState {
    private TrainDeck trainDeck;
    private RouteDeck routeDeck;
    private ArrayList<GamePlayer> players;
    private TrainStash trainStash;
    private Board board;
    private int currentPlayer;
    private Routes routes;
}
