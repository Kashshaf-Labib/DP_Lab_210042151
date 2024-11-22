package Widgets;

import Interfaces.IWidget;

import java.util.UUID;
import Mediator.Mediator;

public class Location implements IWidget {

    public String latitude;
    public String longitude;

    public String uniqueID;

    private Mediator mediator;

    public Location(Mediator mediator){
        this.uniqueID = UUID.randomUUID().toString();
        this.mediator = mediator;
    }

    @Override
    public void update() {
        System.out.println("Location has been updated.");
        mediator.notify(uniqueID);
    }
}
