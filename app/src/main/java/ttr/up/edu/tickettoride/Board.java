package ttr.up.edu.tickettoride;

import static ttr.up.edu.tickettoride.BoardRoute.Color.Black;
import static ttr.up.edu.tickettoride.BoardRoute.Color.White;

/**
 * class Board
 *
 * is a class to store all the routes which exist on a Ticket To Ride board.
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

public class Board {
    private BoardRoute[] boardRoutes;

    public Board(){
        boardRoutes = new BoardRoute[]{new BoardRoute(BoardRoute.City.Vancouver, BoardRoute.City.Calgary, White, false),
            new BoardRoute(BoardRoute.City.Calgary, BoardRoute.City.Winnipeg, Black, false),
        };/*TO-DO Finish adding all the boardRoutes.*/
    }

    public Board(Board board){
        for(int i = 0; i<board.boardRoutes.length; i++)
            boardRoutes[i] = board.boardRoutes[i].clone();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (BoardRoute r: boardRoutes){
            out.append(r.toString());
        }
        out.append("\n");
        return out.toString();
    }
}
