package ttr.up.edu.tickettoride;

public class RouteCard extends Card {
    int value;
    public RouteCard(String name, int value) {
        super(name);
        this.value = value;
    }

    public RouteCard(RouteCard rc){
        super(rc);
        this.value = rc.getValue();
    }

    public RouteCard clone(){
        RouteCard c = new RouteCard(getName(), getValue());
        return c;
    }

    public int getValue() {
        return value;
    }
}
