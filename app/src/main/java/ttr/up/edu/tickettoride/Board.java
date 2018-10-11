package ttr.up.edu.tickettoride;

import java.util.ArrayList;

public class Board {
    private Route[] routes;

    public Board(){
        routes = new Route[]{new Route(Route.City.Vancouver, Route.City.Calgary, false),
            new Route(Route.City.Calgary, Route.City.Winnipeg, false),
        };/*TO-DO Finish adding all the routes.*/
    }

    public Board(Board board){
        for(int i=0; i<board.routes.length; i++)
            routes[i] = board.routes[i].clone();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Route r:routes){
            out.append(r.toString());
        }
        out.append("\n");
        return out.toString();
    }
}
