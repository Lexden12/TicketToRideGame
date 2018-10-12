package ttr.up.edu.tickettoride;

public class Board {
    private BoardRoute[] boardRoutes;

    public Board(){
        boardRoutes = new BoardRoute[]{new BoardRoute(BoardRoute.City.Vancouver, BoardRoute.City.Calgary, false),
            new BoardRoute(BoardRoute.City.Calgary, BoardRoute.City.Winnipeg, false),
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
